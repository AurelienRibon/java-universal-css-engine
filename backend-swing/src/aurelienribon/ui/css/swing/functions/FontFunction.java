package aurelienribon.ui.css.swing.functions;

import aurelienribon.ui.css.StyleException;
import aurelienribon.ui.css.Function;
import java.awt.Font;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class FontFunction implements Function {
	@Override
	public String getName() {
		return "font";
	}

	@Override
	public Class[][] getParams() {
		return new Class[][] {
			{String.class, String.class, Integer.class}
		};
	}

	@Override
	public String[][] getParamsNames() {
		return new String[][] {
			{"name", "style", "size"}
		};
	}

	@Override
	public Class getReturn() {
		return Font.class;
	}

	@Override
	public Object process(List<Object> params) {
		String name = (String) params.get(0);
		String styleStr = (String) params.get(1);
		int size = (Integer) params.get(2);

		int style;
		if (styleStr.equals("plain")) style = Font.PLAIN;
		else if (styleStr.equals("italic")) style = Font.ITALIC;
		else if (styleStr.equals("bold")) style = Font.BOLD;
		else throw StyleException.forFunctionParamKeyword(this, 1, "plain", "italic", "bold");

		return new Font(name, style, size);
	}
}
