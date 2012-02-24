package aurelienribon.ui.css.primitives;

/**
 * A SingleParamRule, as says its name, defines a rule that accepts only one
 * parameter.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SingleParamRule extends BaseRule {
	private Class paramClass;
	private String paramName;

	public SingleParamRule(String name, Class paramClass, String paramName) {
		super(name);
		this.paramClass = paramClass;
		this.paramName = paramName;
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{paramClass}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{paramName}};
	}
}
