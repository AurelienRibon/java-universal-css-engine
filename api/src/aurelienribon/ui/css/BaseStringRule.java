package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BaseStringRule extends BaseRule {
	public BaseStringRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{String.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"value"}};
	}
}
