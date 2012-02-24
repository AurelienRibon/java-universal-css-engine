package aurelienribon.ui.css.swing.functions;

import aurelienribon.ui.css.StyleFunction;
import java.net.URL;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class UrlFunction implements StyleFunction {
	@Override
	public String getName() {
		return "url";
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {
			{String.class}
		};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {
			{"url"}
		};
	}

	@Override
	public Class getReturn() {
		return URL.class;
	}

	@Override
	public Object process(List<Object> params) {
		String name = (String) params.get(0);
		return getClass().getResource(name);
	}
}
