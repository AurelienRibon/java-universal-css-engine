package aurelienribon.ui.css.primitives;

import aurelienribon.ui.css.StyleFunction;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class BaseFunction implements StyleFunction {
	private final String name;

	public BaseFunction(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
