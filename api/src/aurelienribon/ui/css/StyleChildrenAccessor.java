package aurelienribon.ui.css;

import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleChildrenAccessor<T> {
	public List<?> getChildren(T target);
}
