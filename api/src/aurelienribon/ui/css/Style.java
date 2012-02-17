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
	private static StyleParamConverter converter;

	/**
	 * Registers a new rule to the engine.
	 * <p/>
	 * A rule takes one or more parameters, separated by whitespaces. It may
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
	 * A function takes one or more parameters, separated by whitespaces. It may
	 * take different numbers of parameters. A function defines a process, and
	 * always returns something. Therefore, a function can be used as a
	 * parameter to a rule, or to another function.
	 */
	public static void registerFunction(StyleFunction function) {
		if (registeredFunctions.containsKey(function.getName())) throw new RuntimeException("Function already registered");
		registeredFunctions.put(function.getName(), function);
	}

	/**
	 * Registers a new processor to the engine.
	 * <p/>
	 * A processor acts directly on a target according to the rules given to it,
	 * and their parameters. Note that upon applying a style, the targets of
	 * your application will be sent to every registered processors. Therefore,
	 * a processor should return immediatly if a target is not of a type it
	 * was built to handle.
	 */
	public static void registerProcessor(StyleProcessor processor) {
		for (StyleProcessor sp : registeredProcessors)
			if (sp.getClass() == processor.getClass())
				throw new RuntimeException("Processor already registered");
		registeredProcessors.add(processor);
	}

	/**
	 * Registers a target with a className.
	 * <p/>
	 * This is used to assign CSS classnames (like ".something" to a target).
	 * Don't forget to unregister the target when you dispose of it, to remove
	 * it from memory.
	 */
	public static void registerTargetClassName(Object target, String className) {
		if (!className.startsWith(".")) className = "." + className;
		registeredTargetsClassNames.put(target, className);
	}

	/**
	 * Registers a class or interface to be skipped by the engine.
	 * <p/>
	 * You may not always want an object type to be processed by a style.
	 * Registering this type as a skipped class will exlude every instances
	 * from the engine process methodology.
	 */
	public static void registerSkippedClass(Class clazz) {
		if (registeredSkippedClasses.contains(clazz)) throw new RuntimeException("Skipped class already registered");
		registeredSkippedClasses.add(clazz);
	}

	/**
	 * Registers a children accessor with a parent class.
	 * <p/>
	 * Accessors are used to automatically apply a style to the children of a
	 * target, without requiring it to manually pass it to its children.
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
	 * Unregisters a children accessor.
	 */
	public static void unregisterChildrenAccessor(Class parentClass) {
		registeredChildrenAccessors.remove(parentClass);
	}

	/**
	 * Applies a stylesheet to a target and its children, if it has a
	 * corresponding StyleChildrenAccessor registered.
	 */
	public static void apply(Object target, Style style) {
		apply(target, style, new ArrayList<String>());
	}

	/**
	 * Applies a group of attributes to a target. It may be interesting when you
	 * want to apply the same group of rules to some objects, directly from
	 * a StyleProcessor for instance.
	 */
	public static void apply(Object target, StyleRuleSet rs) {
		for (StyleProcessor sp : registeredProcessors) sp.process(target, rs);
	}

	/**
	 * Sets the converter that will be used to convert special objects found
	 * during parsing into something useable. For instance, colors can be
	 * found in CSS files with the syntax #ABCDEF. However, since there is no
	 * Color class in generic java packages (java.awt is not available on
	 * Android), the engine doesn't know how to treat such syntax, and will
	 * return an undocumented object. Therefore, you'll want to set a converter
	 * that will translate every undocomented color into java.awt.Color class
	 * for Swing targets for instance, or android.graphics.Color for Android
	 * targets.
	 */
	public static void setParamConverter(StyleParamConverter converter) {
		Style.converter = converter;
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
	 * Gets a list of every registered processor.
	 */
	public static List<StyleProcessor> getRegisteredProcessors() {
		return Collections.unmodifiableList(registeredProcessors);
	}

	/**
	 * Gets a list of every target registered with a classname.
	 */
	public static List<Object> getRegisteredTargets() {
		return Collections.unmodifiableList(new ArrayList<Object>(registeredTargetsClassNames.keySet()));
	}

	/**
	 * Gets the className associated to the given target.
	 */
	public static String getRegisteredTargetClassName(Object target) {
		return registeredTargetsClassNames.get(target);
	}

	/**
	 * Gets the rules manual.
	 */
	public static String getRulesManual() {
		return generateManual(registeredRules.values());
	}

	/**
	 * Gets the functions manual.
	 */
	public static String getFunctionsManual() {
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
			try {reader.close();} catch (IOException ex) {}
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
				Map<String, List<Object>> resultRules = result.get(selector);

				List<StyleRule> rules = new ArrayList<StyleRule>();
				Map<StyleRule, List<Object>> rulesParams = new HashMap<StyleRule, List<Object>>();

				for (String name : resultRules.keySet()) {
					StyleRule rule = registeredRules.get(name);
					List<Object> params = resultRules.get(name);

					if (rule == null) throw StyleException.forRule(name);
					for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));
					if (!checkParams(rule, params)) throw StyleException.forRuleParams(rule);

					rules.add(rule);
					rulesParams.put(rule, params);
				}

				StyleRuleSet rs = new StyleRuleSet(rules, rulesParams);
				StyleClass sc = new StyleClass(selector, rs);
				classes.add(sc);
			}

		} catch (RecognitionException ex) {
			throw new StyleException(ex.getMessage());
		}
	}

	private static Object evaluateParam(Object param) throws StyleException {
		if (param instanceof CssParser.Color) {
			CssParser.Color c = (CssParser.Color) param;
			if (converter != null) return converter.convertColor(c.r, c.g, c.b, c.a);
		}

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
		// Skip target if required
		for (Class clazz : registeredSkippedClasses) if (clazz.isInstance(target)) return;

		// Retrieve all the rules belonging to the target, and apply them
		StyleRuleSet rs = new StyleRuleSet(style, target, stack);
		apply(target, rs);

		// Add the target class and className to the selectors stack
		stack.add(target.getClass().getName());
		if (registeredTargetsClassNames.containsKey(target)) stack.add(registeredTargetsClassNames.get(target));

		// Iterate over the target children, if any
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
			str += rule.getName() + getReturnStatement(rule) + "\n";

			for (int i=0; i<rule.getParams().length; i++) {
				str += "    ";

				if (rule.getParams()[i].length == 0) str += "nothing";

				for (int ii=0; ii<rule.getParams()[i].length; ii++) {
					String clazz = rule.getParams()[i][ii].getSimpleName();
					String name = rule.getParamsNames()[i][ii];

					if (ii > 0) str += ", ";
					str += prettify(clazz) + " " + name;
				}

				str += "\n";
			}

			str += "\n";
		}

		return str.trim();
	}

	private static String prettify(String clazz) {
		clazz = clazz.replace("Integer", "int");
		clazz = clazz.replace("Float", "float");
		clazz = clazz.replace("Number", "float");
		clazz = clazz.replace("Boolean", "boolean");
		return clazz;
	}

	private static String getReturnStatement(StyleRule rule) {
		if (rule instanceof StyleFunction) {
			StyleFunction func = (StyleFunction) rule;
			return " [returns " + prettify(func.getReturn().getSimpleName()) + "]";
		}
		return "";
	}
}
