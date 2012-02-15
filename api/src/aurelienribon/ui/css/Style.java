package aurelienribon.ui.css;

import java.awt.Component;
import java.awt.Container;
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

	public static void registerRule(StyleRule rule) {
		if (registeredRules.containsKey(rule.getName())) throw new RuntimeException("Rule already registered");
		registeredRules.put(rule.getName(), rule);
	}

	public static void registerFunction(StyleFunction function) {
		if (registeredFunctions.containsKey(function.getName())) throw new RuntimeException("Function already registered");
		registeredFunctions.put(function.getName(), function);
	}

	public static void registerProcessor(StyleProcessor processor) {
		for (StyleProcessor sp : registeredProcessors)
			if (sp.getClass() == processor.getClass())
				throw new RuntimeException("Processor already registered");
		registeredProcessors.add(processor);
	}

	public static void registerTargetClassName(Object target, String className) {
		registeredTargetsClassNames.put(target, "." + className);
	}

	public static void registerSkippedClass(Class clazz) {
		if (registeredSkippedClasses.contains(clazz)) throw new RuntimeException("Skipped class already registered");
		registeredSkippedClasses.add(clazz);
	}

	public static void unregisterRule(StyleRule rule) {
		registeredRules.remove(rule.getName());
	}

	public static void unregisterFunction(StyleFunction function) {
		registeredFunctions.remove(function.getName());
	}

	public static void unregisterProcessor(StyleProcessor processor) {
		registeredProcessors.remove(processor);
	}

	public static void unregisterTargetClassName(Object target) {
		registeredTargetsClassNames.remove(target);
	}

	public static void unregisterSkippedClass(Class clazz) {
		registeredSkippedClasses.remove(clazz);
	}

	public static List<String> getRegisteredRulesNames() {
		return Collections.unmodifiableList(new ArrayList<String>(registeredRules.keySet()));
	}

	public static StyleRule getRegisteredRule(String name) {
		return registeredRules.get(name);
	}

	public static List<String> getRegisteredFunctionsNames() {
		return Collections.unmodifiableList(new ArrayList<String>(registeredFunctions.keySet()));
	}

	public static StyleFunction getRegisteredFunction(String name) {
		return registeredFunctions.get(name);
	}

	public static String getRegisteredTargetClass(Object target) {
		return registeredTargetsClassNames.get(target);
	}

	public static void apply(Object target, Style style) {
		apply(target, style, new ArrayList<String>());
	}

	public static void apply(Object target, StyleAttributes attrs) {
		for (StyleProcessor sp : registeredProcessors) sp.process(target, attrs);
	}

	public static String generateRulesManual() {
		return generateManual(registeredRules.values());
	}

	public static String generateFunctionsManual() {
		return generateManual(registeredFunctions.values());
	}

	// -------------------------------------------------------------------------
	// Attrs + ctors
	// -------------------------------------------------------------------------

	private final String styleSheet;
	private final List<StyleClass> classes = new ArrayList<StyleClass>();

	public Style(URL styleSheetUrl) throws StyleException {
		this.styleSheet = getStyleSheet(styleSheetUrl);
		parse(styleSheet);
	}

	public Style(String styleSheet) throws StyleException {
		this.styleSheet = styleSheet;
		parse(styleSheet);
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	public String getStyleSheet() {
		return styleSheet;
	}

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

		if (target instanceof Container) {
			Container cnt = (Container) target;
			for (Component child : cnt.getComponents()) apply(child, style, stack);
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
