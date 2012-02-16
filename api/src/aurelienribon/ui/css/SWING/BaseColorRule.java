package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.BaseRule;
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
		return new String[][] {{"color"}};
	}
}
