package aurelienribon.ui.css;

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

	@Override
	public boolean canBeNull(int paramsId, int paramId) {
		return false;
	}

	@Override
	public String[] getKeywords(int paramsId, int paramId) {
		return null;
	}
}
