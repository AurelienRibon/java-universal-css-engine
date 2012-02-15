package aurelienribon.ui.css;

import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class BasePaintRule extends BaseRule {
	public BasePaintRule(String name) {
		super(name);
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {{Paint.class}};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {{"value"}};
	}
}
