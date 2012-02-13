package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class BaseRule implements StyleRule {
	private final String name;

	public BaseRule(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String[] getKeywords(int paramsId, int paramId) {
		return null;
	}
}
