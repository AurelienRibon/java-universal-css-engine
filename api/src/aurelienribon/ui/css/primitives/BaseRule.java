package aurelienribon.ui.css.primitives;

import aurelienribon.ui.css.Property;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class BaseRule implements Property {
	private final String name;

	public BaseRule(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
