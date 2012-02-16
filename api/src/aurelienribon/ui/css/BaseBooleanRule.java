package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BaseBooleanRule extends BaseRule {
	public BaseBooleanRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{Boolean.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"b"}};
	}
}
