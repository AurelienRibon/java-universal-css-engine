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
			{Icon.class, String.class, Integer.class, Integer.class, Color.class, Paint.class},
			{Icon.class, String.class, Integer.class, Integer.class, Color.class, Paint.class, Boolean.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"icon", "title", "titleHeight", "padding", "stroke", "fill"},
			{"icon", "title", "titleHeight", "padding", "stroke", "fill", "headerStrokeVisible"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return paramId == 0 || paramId == 4;
		}

		@Override public Object process(List<Object> params) {
			Icon icon = (Icon) params.get(0);
			String title = (String) params.get(1);
			int titleHeight = (Integer) params.get(2);
			int padding = (Integer) params.get(3);
			Color stroke = (Color) params.get(4);
			Paint fill = (Paint) params.get(5);

			if (params.size() == 6) {
				return new GroupBorder(icon, title, titleHeight, padding, stroke, fill);
			}

			if (params.size() == 7) {
				boolean headerStrokeVisible = (Boolean) params.get(6);
				return new GroupBorder(icon, title, titleHeight, padding, stroke, fill, headerStrokeVisible);
			}

			assert false;
			return null;
		}
	};
}
