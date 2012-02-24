package aurelienribon.ui.css;

import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleFunction extends StyleRule {
	public Class getReturn();
	public Object process(List<Object> params);
}
