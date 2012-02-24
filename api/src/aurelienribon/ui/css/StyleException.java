package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StyleException extends RuntimeException {
	public static StyleException forRule(String name) {
		return new StyleException("Rule \"" + name + "\" is not registered.");
	}

	public static StyleException forRuleParams(StyleRule rule) {
		return new StyleException("Bad parameter(s) for rule \"" + rule.getName() + "\"");
	}

	public static StyleException forFunction(String name) {
		return new StyleException("Function \"" + name + "\" is not registered.");
	}

	public static StyleException forFunctionParams(StyleFunction function) {
		return new StyleException("Bad parameter(s) for function \"" + function.getName() + "\"");
	}

	public static StyleException forFunctionParamKeyword(StyleFunction function, int paramId, String... keywords) {
		return new StyleException("Bad parameter(s) for function \"" + function.getName() + "\"");
	}

	public StyleException(String msg) {
		super(msg);
	}
}
