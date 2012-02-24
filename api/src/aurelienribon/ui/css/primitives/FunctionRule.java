package aurelienribon.ui.css.primitives;

import aurelienribon.ui.css.StyleFunction;

/**
 * A FunctionRule is a rule that accepts the exact same parameters as an
 * existing function, plus the function result itself. To avoid duplicating
 * code, the params classes and names of the rule are computed from the
 * function.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class FunctionRule extends BaseRule {
	private final StyleFunction function;
	private final Class paramClass;
	private final String paramName;

	public FunctionRule(String name, StyleFunction function, String paramName) {
		super(name);
		this.function = function;
		this.paramClass = function.getReturn();
		this.paramName = paramName;
	}

	@Override
	public Class[][] getParams() {
		return concat(paramClass, function);
	}

	@Override
	public String[][] getParamsNames() {
		return concat(paramName, function);
	}

	private Class[][] concat(Class newParam, StyleFunction function) {
		Class[][] ps = function.getParams();
		Class[][] result = new Class[ps.length + 1][];
		result[0] = new Class[] {newParam};
		System.arraycopy(ps, 0, result, 1, ps.length);
		return result;
	}

	private String[][] concat(String newParam, StyleFunction function) {
		String[][] ps = function.getParamsNames();
		String[][] result = new String[ps.length + 1][];
		result[0] = new String[] {newParam};
		System.arraycopy(ps, 0, result, 1, ps.length);
		return result;
	}
}
