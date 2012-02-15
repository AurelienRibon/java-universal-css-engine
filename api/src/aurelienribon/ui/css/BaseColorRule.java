package aurelienribon.ui.css;

import java.awt.Color;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BaseColorRule extends BaseRule {
	public BaseColorRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{Color.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"value"}};
	}
}
