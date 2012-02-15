package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.BaseFunction;
import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingFunctions {

	// -------------------------------------------------------------------------
	// Files
	// -------------------------------------------------------------------------

	public static class UrlFunction extends BaseFunction {
		public UrlFunction() {super("url");}

		@Override public Class[][] getParams() {return new Class[][] {
			{String.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"absoluteUrl"}
		};}

		@Override public Object process(List<Object> params) {
			String name = (String) params.get(0);
			return getClass().getResource(name);
		}
	};

	public static class IconFunction extends BaseFunction {
		public IconFunction() {super("icon");}

		@Override public Class[][] getParams() {return new Class[][] {
			{URL.class},
			{String.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"url"},
			{"filepath"}
		};}

		@Override public Object process(List<Object> params) {
			if (params.get(0) instanceof URL) return new ImageIcon((URL) params.get(0));
			if (params.get(0) instanceof String) return new ImageIcon((String) params.get(0));
			assert false;
			return null;
		}
	};

	// -------------------------------------------------------------------------
	// Colors
	// -------------------------------------------------------------------------

	public static class RgbFunction extends BaseFunction {
		public RgbFunction() {super("rgb");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"r", "g", "b"}
		};}

		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			return new Color(r, g, b);
		}
	};

	public static class RgbaFunction extends BaseFunction {
		public RgbaFunction() {super("rgba");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Float.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"r", "g", "b", "a"}
		};}

		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			int a = (int) (((Float) params.get(3)) * 255);
			return new Color(r, g, b, a);
		}
	};

	public static class LinearGradientFunction extends BaseFunction {
		public LinearGradientFunction() {super("lineargradient");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3", "fraction4", "color4", "fraction5", "color5"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3", "fraction4", "color4"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2"}
		};}

		@Override public Object process(List<Object> params) {
			float x1 = ((Number) params.get(0)).floatValue();
			float y1 = ((Number) params.get(1)).floatValue();
			float x2 = ((Number) params.get(2)).floatValue();
			float y2 = ((Number) params.get(3)).floatValue();

			int cnt = (params.size()-4)/2;
			float[] fractions = new float[cnt];
			Color[] colors = new Color[cnt];

			for (int i=0; i<cnt; i++) {
				fractions[i] = ((Number) params.get(4+i*2)).floatValue();
				colors[i] = (Color) params.get(5+i*2);
			}

			return new LinearGradientPaint(x1, y1, x2, y2, fractions, colors);
		}
	};

	// -------------------------------------------------------------------------
	// Borders
	// -------------------------------------------------------------------------

	public static class EmptyBorderFunction extends BaseFunction {
		public EmptyBorderFunction() {super("emptyborder");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"top", "left", "bottom", "right"}
		};}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int left = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int right = (Integer) params.get(4);
			return BorderFactory.createEmptyBorder(top, left, bottom, right);
		}
	};

	public static class LineBorderFunction extends BaseFunction {
		public LineBorderFunction() {super("lineborder");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Color.class},
			{Color.class, Integer.class},
			{Color.class, Integer.class, Boolean.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"color"},
			{"color", "thickness"},
			{"color", "thickness", "rounded"}
		};}

		@Override public Object process(List<Object> params) {
			if (params.size() == 1) {
				Color color = (Color) params.get(0);
				return BorderFactory.createLineBorder(color);
			}

			if (params.size() == 2) {
				Color color = (Color) params.get(0);
				int thickness = (Integer) params.get(1);
				return BorderFactory.createLineBorder(color, thickness);
			}

			if (params.size() == 2) {
				Color color = (Color) params.get(0);
				int thickness = (Integer) params.get(1);
				boolean rounded = (Boolean) params.get(2);
				return BorderFactory.createLineBorder(color, thickness, rounded);
			}

			assert false;
			return null;
		}
	};

	public static class MatteBorderFunction extends BaseFunction {
		public MatteBorderFunction() {super("matteborder");}

		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class, Color.class},
			{Integer.class, Integer.class, Integer.class, Integer.class, Icon.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"top", "left", "bottom", "up", "color"},
			{"top", "left", "bottom", "up", "tileIcon"}
		};}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int left = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int right = (Integer) params.get(4);

			if (params.get(4) instanceof Color) {
				Color color = (Color) params.get(4);
				return BorderFactory.createMatteBorder(top, left, bottom, right, color);
			}

			if (params.get(4) instanceof Icon) {
				Icon tileIcon = (Icon) params.get(4);
				return BorderFactory.createMatteBorder(top, left, bottom, right, tileIcon);
			}

			assert false;
			return null;
		}
	};

	public static class BevelBorderFunction extends BaseFunction {
		public BevelBorderFunction() {super("bevelborder");}

		@Override public String[] getKeywords(int paramsId, int paramId) {
			if (paramId == 0) return new String[] {"lowered", "raised"};
			return null;
		}

		@Override public Class[][] getParams() {return new Class[][] {
			{String.class},
			{String.class, Color.class, Color.class},
			{String.class, Color.class, Color.class, Color.class, Color.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"type"},
			{"type", "highlight", "shadow"},
			{"type", "highlightOuter", "highlightInner", "shadowOuter", "shadowInner"}
		};}

		@Override public Object process(List<Object> params) {
			String typeStr = (String) params.get(0);
			int type = typeStr.equals("lowered") ? BevelBorder.LOWERED : BevelBorder.RAISED;

			if (params.size() == 1) {
				return BorderFactory.createBevelBorder(type);
			}

			if (params.size() == 3) {
				Color highlight = (Color) params.get(1);
				Color shadow = (Color) params.get(1);
				return BorderFactory.createBevelBorder(type, highlight, shadow);
			}

			if (params.size() == 5) {
				Color highlightOuter = (Color) params.get(1);
				Color highlightInner = (Color) params.get(2);
				Color shadowOuter = (Color) params.get(3);
				Color shadowInner = (Color) params.get(4);
				return BorderFactory.createBevelBorder(type, highlightOuter, highlightInner, shadowOuter, shadowInner);
			}

			assert false;
			return null;
		}
	};

	public static class CompoundBorderFunction extends BaseFunction {
		public CompoundBorderFunction() {super("compoundborder");}

		@Override public Class[][] getParams() {return new Class[][] {
			{},
			{Border.class, Border.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{},
			{"outsideBorder", "insideBorder"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return true;
		}

		@Override public Object process(List<Object> params) {
			if (params.isEmpty()) {
				return BorderFactory.createCompoundBorder();
			}

			if (params.size() == 2) {
				Border outsideBorder = (Border) params.get(0);
				Border insideBorder = (Border) params.get(1);
				return BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
			}

			assert false;
			return null;
		}
	};
}
