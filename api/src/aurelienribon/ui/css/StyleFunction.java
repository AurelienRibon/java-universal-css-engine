package aurelienribon.ui.css;

import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleFunction extends StyleRule{
	public Object process(List<Object> params);
}
