package aurelienribon.ui.css;

import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleFunction {
	public String getName();
	public Class[][] getParams();
	public Object process(List<Object> params);
}
