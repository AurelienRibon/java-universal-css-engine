package aurelienribon.ui.css;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

	private static final Map<String, StyleRule> registeredRules = new HashMap<String, StyleRule>();
	private static final Map<String, StyleFunction> registeredFunctions = new HashMap<String, StyleFunction>();
	private static final List<StyleProcessor> registeredProcessors = new ArrayList<StyleProcessor>();
	private static final Map<Object, String> registeredTargetsClasses = new HashMap<Object, String>();

	public static void registerFunction(StyleFunction function) {
		if (registeredFunctions.containsKey(function.getName())) throw new RuntimeException("Function already registered");
		registeredFunctions.put(function.getName(), function);
	}

	public static void registerRule(StyleRule rule) {
		if (registeredRules.containsKey(rule.getName())) throw new RuntimeException("Rule already registered");
		registeredRules.put(rule.getName(), rule);
	}

	public static void registerProcessor(StyleProcessor processor) {
		for (StyleProcessor sp : registeredProcessors)
			if (sp.getClass() == processor.getClass())
				throw new RuntimeException("Processor already registered");
		registeredProcessors.add(processor);
	}

	public static void registerTargetClass(Object target, String className) {
		registeredTargetsClasses.put(target, "." + className);
	}

	public static void unregisterTarget(Object target) {
		registeredTargetsClasses.remove(target);
	}

	public static String getRegisteredTargetClass(Object target) {
		return registeredTargetsClasses.get(target);
	}

	public static void apply(Object target, Style style) {
		apply(target, style, new ArrayList<String>());
	}

	public static void apply(Object target, StyleAttributes attrs) {
		for (StyleProcessor sp : registeredProcessors) sp.process(target, attrs);
	}

	// -------------------------------------------------------------------------
	// Attrs + ctors
	// -------------------------------------------------------------------------

	private final String styleSheet;
	private final List<StyleClass> classes = new ArrayList<StyleClass>();

	public Style(URL styleSheetUrl) {
		this.styleSheet = getStyleSheet(styleSheetUrl);
		parse(styleSheet);
	}

	public Style(String styleSheet) {
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

	private void parse(String styleSheet) {
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
					List<Object> params = rules.get(name);

					for (int i=0; i<params.size(); i++) {
						params.set(i, evaluateParam(params.get(i)));
					}
				}

				StyleClass sc = new StyleClass(selector, result.get(selector));
				classes.add(sc);
			}

		} catch (RecognitionException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	private static Object evaluateParam(Object param) {
		if (param instanceof CssParser.Function) {
			CssParser.Function func = (CssParser.Function) param;
			List<Object> funcParams = new ArrayList<Object>(func.params);

			for (int i=0; i<funcParams.size(); i++) {
				funcParams.set(i, evaluateParam(funcParams.get(i)));
			}

			StyleFunction regFunc = registeredFunctions.get(func.name);
			if (regFunc == null) throw new RuntimeException("function " + func.name + " is not registered");
			if (!checkParams(func.params, regFunc.getParams())) throw new RuntimeException("Bad parameters in function " + func.name);

			return regFunc.process(funcParams);

		} else {
			return param;
		}
	}

	private static boolean checkParams(List<Object> params, Class[][] paramsClasses) {
		for (Class[] cs : paramsClasses) {
			boolean match = true;

			for (int i=0; i<params.size(); i++) {
				if (!cs[i].isInstance(params.get(i))) match = false;
			}

			if (match) return true;
		}

		return false;
	}

	private static void apply(Object target, Style style, List<String> stack) {
		apply(target, new StyleAttributes(style, target, stack));

		stack.add(target.getClass().getName());
		if (registeredTargetsClasses.containsKey(target)) stack.add(registeredTargetsClasses.get(target));

		if (target instanceof Container) {
			Container cnt = (Container) target;
			for (Component child : cnt.getComponents()) apply(child, style, stack);
		}
	}
}
