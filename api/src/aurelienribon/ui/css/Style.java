package aurelienribon.ui.css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Style {
	// -------------------------------------------------------------------------
	// Static API
	// -------------------------------------------------------------------------

	private static final Map<String, StyleRule> registeredRules = new LinkedHashMap<String, StyleRule>();
	private static final Map<String, StyleFunction> registeredFunctions = new LinkedHashMap<String, StyleFunction>();
	private static final List<StyleProcessor> registeredProcessors = new ArrayList<StyleProcessor>();
	private static final Map<Object, String> registeredTargetsClassNames = new LinkedHashMap<Object, String>();
	private static final List<Class> registeredSkippedClasses = new ArrayList<Class>();
	private static final Map<Class, StyleChildrenAccessor> registeredChildrenAccessors = new HashMap<Class, StyleChildrenAccessor>();

	/**
	 * Registers a new rule to the engine.
	 * <p/>
	 * A Rule takes one or more parameters, separated by whitespaces. It may
	 * take different numbers of parameters. A rule is global, so it does
	 * nothing on its own: the processing behavior is managed by the target.
	 * Therefore, a rule can be treated differently by different targets, or
	 * even skipped if not relevant for a given target (but its children may
	 * use it, so its never totally irrelevant).
	 */
	public static void registerRule(StyleRule rule) {
		if (registeredRules.containsKey(rule.getName())) throw new RuntimeException("Rule already registered");
		registeredRules.put(rule.getName(), rule);
	}

	/**
	 * Registers a new function to the engine.
	 * <p/>
	 * A function
	 */
	public static void registerFunction(StyleFunction function) {
		if (registeredFunctions.containsKey(function.getName())) throw new RuntimeException("Function already registered");
		registeredFunctions.put(function.getName(), function);
	}

	/**
	 * Registers a new processor to the engine.
	 */
	public static void registerProcessor(StyleProcessor processor) {
		for (StyleProcessor sp : registeredProcessors)
			if (sp.getClass() == processor.getClass())
				throw new RuntimeException("Processor already registered");
		registeredProcessors.add(processor);
	}

	/**
	 * Registers a target with a className. Don't forget to unregister the
	 * target if you dispose of it, to remove it from memory.
	 */
	public static void registerTargetClassName(Object target, String className) {
		registeredTargetsClassNames.put(target, "." + className);
	}

	/**
	 * Registers a class or interface to be skipped by the engine.
	 */
	public static void registerSkippedClass(Class clazz) {
		if (registeredSkippedClasses.contains(clazz)) throw new RuntimeException("Skipped class already registered");
		registeredSkippedClasses.add(clazz);
	}

	/**
	 * Registers a children accessor with a parent class. Accessors are used to
	 * automatically apply a style to a target children, without requiring it
	 * to manually pass it to its children.
	 */
	public static void registerChildrenAccessor(Class parentClass, StyleChildrenAccessor accessor) {
		if (registeredChildrenAccessors.containsKey(parentClass)) throw new RuntimeException("Accessor already registered");
		registeredChildrenAccessors.put(parentClass, accessor);
	}

	/**
	 * Unregisters a rule from the engine.
	 */
	public static void unregisterRule(StyleRule rule) {
		registeredRules.remove(rule.getName());
	}

	/**
	 * Unregisters a function from the engine.
	 */
	public static void unregisterFunction(StyleFunction function) {
		registeredFunctions.remove(function.getName());
	}

	/**
	 * Unregisters a processor from the engine.
	 */
	public static void unregisterProcessor(StyleProcessor processor) {
		registeredProcessors.remove(processor);
	}

	/**
	 * Unregisters a className from the engine.
	 */
	public static void unregisterTargetClassName(Object target) {
		registeredTargetsClassNames.remove(target);
	}

	/**
	 * Unregisters a skipped class or interface from the engine.
	 */
	public static void unregisterSkippedClass(Class clazz) {
		registeredSkippedClasses.remove(clazz);
	}

	/**
	 * Gets a list of every registered rules.
	 */
	public static List<String> getRegisteredRulesNames() {
		return Collections.unmodifiableList(new ArrayList<String>(registeredRules.keySet()));
	}

	/**
	 * Gets a rule by its name.
	 */
	public static StyleRule getRegisteredRule(String name) {
		return registeredRules.get(name);
	}

	/**
	 * Gets a list of every registered functions.
	 */
	public static List<String> getRegisteredFunctionsNames() {
		return Collections.unmodifiableList(new ArrayList<String>(registeredFunctions.keySet()));
	}

	/**
	 * Gets a function by its name.
	 */
	public static StyleFunction getRegisteredFunction(String name) {
		return registeredFunctions.get(name);
	}

	/**
	 * Gets the className associated to the given target.
	 */
	public static String getRegisteredTargetClass(Object target) {
		return registeredTargetsClassNames.get(target);
	}

	/**
	 * Applies a stylesheet to a target. If the target is a swing Container,
	 * the style will be applied to its children too, etc.
	 */
	public static void apply(Object target, Style style) {
		apply(target, style, new ArrayList<String>());
	}

	/**
	 * Applies a group of attributes to a target. It may be interesting when you
	 * want to apply the same group of attributes to some objects, directly from
	 * a StyleProcessor for instance.
	 */
	public static void apply(Object target, StyleAttributes attrs) {
		for (StyleProcessor sp : registeredProcessors) sp.process(target, attrs);
	}

	/**
	 * Gets the rules manual.
	 */
	public static String generateRulesManual() {
		return generateManual(registeredRules.values());
	}

	/**
	 * Gets the functions manual.
	 */
	public static String generateFunctionsManual() {
		return generateManual(registeredFunctions.values());
	}

	// -------------------------------------------------------------------------
	// Attrs + ctors
	// -------------------------------------------------------------------------

	private final String styleSheet;
	private final List<StyleClass> classes = new ArrayList<StyleClass>();

	/**
	 * Builds a new Style from an URL pointing to a stylesheet.
	 * @throws StyleException
	 */
	public Style(URL styleSheetUrl) throws StyleException {
		this.styleSheet = getStyleSheet(styleSheetUrl);
		parse(styleSheet);
	}

	/**
	 * Builds a new Style from String stylesheet.
	 * @throws StyleException
	 */
	public Style(String styleSheet) throws StyleException {
		this.styleSheet = styleSheet;
		parse(styleSheet);
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Gets the stylesheet content.
	 */
	public String getStyleSheet() {
		return styleSheet;
	}

	/**
	 * Gets the retrieved classes.
	 */
	public List<StyleClass> getClasses() {
		return Collections.unmodifiableList(classes);
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private static String getStyleSheet(URL styleSheetUrl) {
		if (styleSheetUrl == null) throw new NullPointerException("styleSheetUrl");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(styleSheetUrl.openStream()));
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[4096];
			int len;
			while ((len = reader.read(buffer)) > -1) sb.append(buffer, 0, len);
			return sb.toString();

		} catch (IOException ex) {
			return null;

		} finally {
			try {reader.close();
			} catch (IOException ex) {}
		}
	}

	private void parse(String styleSheet) throws StyleException {
		CharStream cs = new ANTLRStringStream(styleSheet);
		CssLexer lexer = new CssLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		CssParser parser = new CssParser(tokens);

		try {
			Map<String, Map<String, List<Object>>> result = parser.stylesheet();

			for (String selector : result.keySet()) {
				Map<String, List<Object>> rules = result.get(selector);

				for (String name : rules.keySet()) {
					StyleRule regRule = registeredRules.get(name);
					List<Object> params = rules.get(name);

					for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));

					if (regRule == null) throw StyleException.forRule(name);
					if (!checkParams(regRule, params)) throw StyleException.forRuleParams(regRule);

					for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));
				}

				StyleClass sc = new StyleClass(selector, result.get(selector));
				classes.add(sc);
			}

		} catch (RecognitionException ex) {
			throw new StyleException(ex.getMessage());
		}
	}

	private static Object evaluateParam(Object param) throws StyleException {
		if (param instanceof CssParser.Function) {
			CssParser.Function func = (CssParser.Function) param;
			StyleFunction regFunc = registeredFunctions.get(func.name);
			List<Object> params = new ArrayList<Object>(func.params);

			for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));

			if (regFunc == null) throw StyleException.forFunction(func.name);
			if (!checkParams(regFunc, params)) throw StyleException.forFunctionParams(regFunc);

			return regFunc.process(params);
		}

		return param;
	}

	private static boolean checkParams(StyleRule rule, List<Object> params) {
		for (int i=0; i<rule.getParams().length; i++) {
			Class[] cs = rule.getParams()[i];
			if (params.size() != cs.length) continue;

			boolean isMatch = true;

			for (int ii=0; ii<params.size(); ii++) {
				assert cs[ii] != null;
				if (cs[ii].isInstance(params.get(ii))) continue;
				if (params.get(ii) == null && rule.canBeNull(i, ii)) continue;
				isMatch = false;
				break;
			}

			if (!isMatch) continue;

			for (int ii=0; ii<params.size(); ii++) {
				String[] keywords = rule.getKeywords(i, ii);

				if (keywords != null && !Arrays.asList(keywords).contains((String) params.get(ii))) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	private static void apply(Object target, Style style, List<String> stack) {
		for (Class clazz : registeredSkippedClasses)
			if (clazz.isInstance(target)) return;

		apply(target, new StyleAttributes(style, target, stack));

		stack.add(target.getClass().getName());
		if (registeredTargetsClassNames.containsKey(target)) stack.add(registeredTargetsClassNames.get(target));

		for (Class clazz : registeredChildrenAccessors.keySet()) {
			if (clazz.isInstance(target)) {
				StyleChildrenAccessor accessor = registeredChildrenAccessors.get(clazz);
				for (Object child : accessor.getChildren(target)) apply(child, style, stack);
			}
		}
	}

	private static String generateManual(Collection<? extends StyleRule> rules) {
		String str = "";

		for (StyleRule rule : rules) {
			str += rule.getName() + "\n";

			for (int i=0; i<rule.getParams().length; i++) {
				str += "    ";

				if (rule.getParams()[i].length == 0) str += "nothing";

				for (int ii=0; ii<rule.getParams()[i].length; ii++) {
					String clazz = rule.getParams()[i][ii].getSimpleName();
					String name = rule.getParamsNames()[i][ii];

					clazz = clazz.replace("Integer", "int");
					clazz = clazz.replace("Float", "float");
					clazz = clazz.replace("Number", "float");
					clazz = clazz.replace("Boolean", "boolean");

					if (ii > 0) str += ", ";
					str += clazz + " " + name;
				}

				str += "\n";
			}

			str += "\n";
		}

		return str;
	}
}
