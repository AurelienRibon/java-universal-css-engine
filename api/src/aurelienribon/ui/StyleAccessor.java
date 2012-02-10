package aurelienribon.ui;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleAccessor<T> {
	public void applyStyle(T target, StyleAttributes attrs);
}
