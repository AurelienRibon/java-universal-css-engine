package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BaseFloatRule extends BaseRule {
	public BaseFloatRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{Float.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"f"}};
	}
}
