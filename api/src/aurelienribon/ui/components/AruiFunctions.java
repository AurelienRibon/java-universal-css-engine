package aurelienribon.ui.components;

import aurelienribon.ui.css.BaseFunction;
import java.awt.Color;
import java.awt.Paint;
import java.util.List;
import javax.swing.Icon;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiFunctions {
	public static class GroupBorderFunction extends BaseFunction {
		public GroupBorderFunction() {super("arui-groupborder");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Icon.class, String.class, Integer.class, Integer.class, Color.class, Color.class, Paint.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"icon", "title", "titleHeight", "padding", "foreground", "stroke", "fill"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return paramId == 0 || paramId == 5;
		}

		@Override public Object process(List<Object> params) {
			Icon icon = (Icon) params.get(0);
			String title = (String) params.get(1);
			int titleHeight = (Integer) params.get(2);
			int padding = (Integer) params.get(3);
			Color foreground = (Color) params.get(4);
			Color stroke = (Color) params.get(5);
			Paint fill = (Paint) params.get(6);
			return new GroupBorder(icon, title, titleHeight, padding, foreground, stroke, fill);
		}
	};
}
