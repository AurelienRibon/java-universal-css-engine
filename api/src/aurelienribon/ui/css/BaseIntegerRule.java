package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BaseIntegerRule extends BaseRule {
	public BaseIntegerRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{Integer.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"value"}};
	}
}
