package aurelienribon.ui.css;

import aurelienribon.ui.css.antlr.CssLexer;
import aurelienribon.ui.css.antlr.CssParser;
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
 * The CSS Style engine lets you easily apply any kind of parameter to your
 * objects, using CSS stylesheets. It is not directly linked with any
 * technology such as Swing, and therefore can be used with any kind of object,
 * being UI components, business models, or game elements.
 * <p/>
 *
 * <h2>What is CSS?</h2>
 * To understand how to customize the engine with your own elements, you must
 * first quickly understand how a CSS stylesheet is built. A stylesheet is
 * composed of rules, which are each defined by a selector, and a group of
 * declarations. Finally, a declaration is made of a property associated to
 * a value. The following image sums-up all of this:
 * <p/>
 *
 * <img src="http://www.w3schools.com/css/selector.gif" />
 * <p/>
 *
 * As it is commonly used in CSS stylesheets, the engine supports: <br/>
 * + Nested selectors, like ".parent .child {...}"<br/>
 * + Groups of selectors, like ".class1, .class2, .class3 {...}"
 * <p/>
 *
 * <h2>How can I use the engine?</h2>
 * The engine is built around 3 kinds of components: {@link Property
 * properties}, {@link Function functions}, and
 * {@link DeclarationSetProcessor processors}, and you will need to register
 * these components to the engine, since it comes as naked as possible.
 * <p/>
 *
 * <b>Important:</b> <font color="#AA0000">remember that the engine is completely naked, this means
 * that it comes without any registered property, function, or processor. You
 * first need to register these entities to the engine to let it understand
 * how to parse CSS stylesheets and apply them to your targets. Some
 * already made entities (for <b>Swing UIs</b> for instance) can be found at
 * the</font> <a href="http://code.google.com/p/java-universal-css-engine/">
 * project website</a>.
 * <p/>
 *
 * 1. <b>Properties:</b> a property defines a style attribute, like "margin",
 * "border" or "color" in common CSS syntax. A property is always associated
 * with a value in declarations, like "color: #FFF", and this value can be made
 * of one or more parameters. Actually, a property can support different sets of
 * parameters. For instance, the common "margin" CSS property can be called with
 * either 1, 2 or 4 parameters, defining the margin insets.
 * <p/>
 *
 * 2. <b>Functions:</b> a function, or a "functional notation", is used to
 * produce a value for a parameter of a declaration value. It takes one or more
 * parameters (which can be functions too), processes them and returns an
 * object.
 * <p/>
 *
 * 3. <b>Processors:</b> a declarations processor is responsible for applying a
 * group of declarations to a target object. These declarations are retrieved
 * from the stylesheet and correspond to the rules which selectors were
 * walidated by the target object.
 * <p/>
 *
 * <h2>Examples</h2>
 * For examples on how to create custom properties, functions and processors,
 * please see the proposed implementation for Swing, at the <a href=
 * "http://code.google.com/p/java-universal-css-engine/">project website</a>.
 * <p/>
 *
 * Simple rule: this rule will by applied to every JButton of the application
 * (if using the Swing backend for properties/functions/processors of course):
 * <pre>
 * javax-swing-JButton {
 *     -swing-foreground: #000;
 *     -swing-background: #FFF;
 * }
 * </pre>
 *
 * Nested seelctors: this rule will be applied to every object registered with
 * the ".redLabel" classname, but only if it is a child of a toolbar:
 * <pre>
 * javax-swing-JToolBar .redLabel {
 *     -swing-foreground: #F00;
 * }
 * </pre>
 *
 * Grouped selectors: this rule will be applied to every object registered with
 * either the ".redLabel" classname, or the ".importantLabel" classname:
 * <pre>
 * .redLabel, .importantLabel {
 *     -swing-foreground: #F00;
 * }
 * </pre>
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Style {
	// -------------------------------------------------------------------------
	// Static API
	// -------------------------------------------------------------------------

	private static final Map<String, Property> registeredRules = new LinkedHashMap<String, Property>();
	private static final Map<String, Function> registeredFunctions = new LinkedHashMap<String, Function>();
	private static final Map<Class, List<DeclarationSetProcessor>> registeredProcessors = new LinkedHashMap<Class, List<DeclarationSetProcessor>>();
	private static final Map<Object, String> registeredTargetsClassNames = new LinkedHashMap<Object, String>();
	private static final Map<Class, ChildrenAccessor> registeredChildrenAccessors = new HashMap<Class, ChildrenAccessor>();
	private static ParamConverter converter;

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
	public static void registerRule(Property rule) {
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
	public static void registerFunction(Function function) {
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
	public static void registerProcessor(Class clazz, DeclarationSetProcessor processor) {
		List<DeclarationSetProcessor> list = registeredProcessors.get(clazz);
		if (list == null) {
			list = new ArrayList<DeclarationSetProcessor>();
			registeredProcessors.put(clazz, list);
		}

		if (!list.contains(processor)) list.add(processor);
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
	 * Registers a children accessor with a parent class.
	 * <p/>
	 * Accessors are used to automatically apply a style to the children of a
	 * target, without requiring it to manually pass it to its children.
	 */
	public static void registerChildrenAccessor(Class parentClass, ChildrenAccessor accessor) {
		if (registeredChildrenAccessors.containsKey(parentClass)) throw new RuntimeException("Accessor already registered");
		registeredChildrenAccessors.put(parentClass, accessor);
	}

	/**
	 * Unregisters a className from the engine.
	 */
	public static void unregisterTargetClassName(Object target) {
		registeredTargetsClassNames.remove(target);
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
	public static void apply(Object target, DeclarationSet rs) {
		for (Class clazz : registeredProcessors.keySet()) {
			if (clazz.isInstance(target)) {
				List<DeclarationSetProcessor> processors = registeredProcessors.get(clazz);
				for (DeclarationSetProcessor proc : processors) {
					proc.process(target, rs);
				}
			}
		}
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
	public static void setParamConverter(ParamConverter converter) {
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
	public static Property getRegisteredRule(String name) {
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
	public static Function getRegisteredFunction(String name) {
		return registeredFunctions.get(name);
	}

	/**
	 * Gets a list of every registered processor.
	 */
	public static List<Class> getRegisteredProcessorsClasses() {
		return Collections.unmodifiableList(new ArrayList<Class>(registeredProcessors.keySet()));
	}

	/**
	 * Gets a list of every registered processor.
	 */
	public static List<DeclarationSetProcessor> getRegisteredProcessors(Class clazz) {
		return Collections.unmodifiableList(registeredProcessors.get(clazz));
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
	private final List<Rule> classes = new ArrayList<Rule>();

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
	public List<Rule> getClasses() {
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

				List<Property> rules = new ArrayList<Property>();
				Map<Property, List<Object>> rulesParams = new HashMap<Property, List<Object>>();

				for (String name : resultRules.keySet()) {
					Property rule = registeredRules.get(name);
					List<Object> params = resultRules.get(name);

					if (rule == null) throw StyleException.forProperty(name);
					for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));
					if (!checkParams(rule, params)) throw StyleException.forPropertyParams(rule);

					rules.add(rule);
					rulesParams.put(rule, params);
				}

				DeclarationSet rs = new DeclarationSet(rules, rulesParams);
				Rule sc = new Rule(selector, rs);
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
			Function regFunc = registeredFunctions.get(func.name);
			List<Object> params = new ArrayList<Object>(func.params);

			for (int i=0; i<params.size(); i++) params.set(i, evaluateParam(params.get(i)));

			if (regFunc == null) throw StyleException.forFunction(func.name);
			if (!checkParams(regFunc, params)) throw StyleException.forFunctionParams(regFunc);

			return regFunc.process(params);
		}

		return param;
	}

	private static boolean checkParams(Property rule, List<Object> params) {
		for (int i=0; i<rule.getParams().length; i++) {
			Class[] cs = rule.getParams()[i];

			if (params.size() == cs.length) {
				boolean isMatch = true;

				for (int ii=0; ii<params.size(); ii++) {
					assert cs[ii] != null;
					Object param = params.get(ii);

					if (param == null || cs[ii].isInstance(param)) {
						continue;
					} else {
						isMatch = false;
						break;
					}
				}

				if (isMatch) return true;
			}
		}

		return false;
	}

	private static void apply(Object target, Style style, List<String> stack) {
		// Retrieve all the rules belonging to the target, and apply them
		DeclarationSet rs = new DeclarationSet(style, target, stack);
		apply(target, rs);

		// Add the target class and className to the selectors stack
		stack.add(target.getClass().getName());
		if (registeredTargetsClassNames.containsKey(target)) stack.add(registeredTargetsClassNames.get(target));

		// Iterate over the target children, if any
		if (target instanceof Container) {
			Container parent = (Container) target;
			if (parent.getChildren() != null) {
				for (Object child : parent.getChildren()) apply(child, style, stack);
			}
		} else {
			for (Class clazz : registeredChildrenAccessors.keySet()) {
				if (clazz.isInstance(target)) {
					ChildrenAccessor accessor = registeredChildrenAccessors.get(clazz);
					if (accessor.getChildren(target) != null) {
						for (Object child : accessor.getChildren(target)) apply(child, style, stack);
					}
				}
			}
		}
	}

	private static String generateManual(Collection<? extends Property> rules) {
		String str = "";

		for (Property rule : rules) {
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

	private static String getReturnStatement(Property rule) {
		if (rule instanceof Function) {
			Function func = (Function) rule;
			return " [returns " + prettify(func.getReturn().getSimpleName()) + "]";
		}
		return "";
	}
}
