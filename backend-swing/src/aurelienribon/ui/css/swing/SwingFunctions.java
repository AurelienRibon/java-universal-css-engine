package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.BaseFunction;
import aurelienribon.ui.css.StyleFunction;
import java.awt.Color;
import java.awt.Font;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
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

	public static final StyleFunction URL = new BaseFunction("url") {
		@Override public Class[][] getParams() {return new Class[][] {
			{String.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"absoluteUrl"}
		};}

		@Override public Class getReturn() {
			return URL.class;
		}

		@Override public Object process(List<Object> params) {
			String name = (String) params.get(0);
			return getClass().getResource(name);
		}
	};

	public static final StyleFunction ICON = new BaseFunction("icon") {
		@Override public Class[][] getParams() {return new Class[][] {
			{URL.class},
			{String.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"url"},
			{"filepath"}
		};}

		@Override public Class getReturn() {
			return ImageIcon.class;
		}

		@Override public Object process(List<Object> params) {
			if (params.get(0) instanceof URL) return new ImageIcon((URL) params.get(0));
			if (params.get(0) instanceof String) return new ImageIcon((String) params.get(0));
			assert false;
			return null;
		}
	};

	public static final StyleFunction FONT = new BaseFunction("font") {
		@Override public Class[][] getParams() {return new Class[][] {
			{String.class, String.class, Integer.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"name", "style", "size"}
		};}

		@Override public String[] getKeywords(int paramsId, int paramId) {
			if (paramId == 1) return new String[] {"plain", "italic", "bold"};
			return null;
		}

		@Override public Class getReturn() {
			return Font.class;
		}

		@Override public Object process(List<Object> params) {
			String name = (String) params.get(0);
			String styleStr = (String) params.get(1);
			int size = (Integer) params.get(2);

			int style = -1;

			if (styleStr.equals("plain")) style = Font.PLAIN;
			else if (styleStr.equals("italic")) style = Font.ITALIC;
			else if (styleStr.equals("bold")) style = Font.BOLD;
			else assert false;

			return new Font(name, style, size);
		}
	};

	// -------------------------------------------------------------------------
	// Colors
	// -------------------------------------------------------------------------

	public static final StyleFunction RGB = new BaseFunction("rgb") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"r", "g", "b"}
		};}

		@Override public Class getReturn() {
			return Color.class;
		}

		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			return new Color(r, g, b);
		}
	};

	public static final StyleFunction RGBA = new BaseFunction("rgba") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Float.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"r", "g", "b", "a"}
		};}

		@Override public Class getReturn() {
			return Color.class;
		}

		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			int a = (int) (((Float) params.get(3)) * 255);
			return new Color(r, g, b, a);
		}
	};

	public static final StyleFunction LINEARGRADIENT = new BaseFunction("lineargradient") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3", "fraction4", "color4"},
			{"x1", "y1", "x2", "y2", "fraction1", "color1", "fraction2", "color2", "fraction3", "color3", "fraction4", "color4", "fraction5", "color5"}
		};}

		@Override public Class getReturn() {
			return LinearGradientPaint.class;
		}

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

	public static final StyleFunction EMPTYBORDER = new BaseFunction("emptyborder") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"top", "left", "bottom", "right"}
		};}

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int left = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int right = (Integer) params.get(4);
			return BorderFactory.createEmptyBorder(top, left, bottom, right);
		}
	};

	public static final StyleFunction LINEBORDER = new BaseFunction("lineborder") {
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

		@Override public Class getReturn() {
			return Border.class;
		}

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

	public static final StyleFunction MATTEBORDER = new BaseFunction("matteborder") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class, Color.class},
			{Integer.class, Integer.class, Integer.class, Integer.class, Icon.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"top", "left", "bottom", "up", "color"},
			{"top", "left", "bottom", "up", "tileIcon"}
		};}

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int left = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int right = (Integer) params.get(3);

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

	public static final StyleFunction BEVELBORDER = new BaseFunction("bevelborder") {
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

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			String typeStr = (String) params.get(0);
			int type = typeStr.equals("lowered") ? BevelBorder.LOWERED : BevelBorder.RAISED;

			if (params.size() == 1) {
				return BorderFactory.createBevelBorder(type);
			}

			if (params.size() == 3) {
				Color highlight = (Color) params.get(1);
				Color shadow = (Color) params.get(2);
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

	public static final StyleFunction SOFTBEVELBORDER = new BaseFunction("softbevelborder") {
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

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			String typeStr = (String) params.get(0);
			int type = typeStr.equals("lowered") ? BevelBorder.LOWERED : BevelBorder.RAISED;

			if (params.size() == 1) {
				return BorderFactory.createSoftBevelBorder(type);
			}

			if (params.size() == 3) {
				Color highlight = (Color) params.get(1);
				Color shadow = (Color) params.get(2);
				return BorderFactory.createSoftBevelBorder(type, highlight, shadow);
			}

			if (params.size() == 5) {
				Color highlightOuter = (Color) params.get(1);
				Color highlightInner = (Color) params.get(2);
				Color shadowOuter = (Color) params.get(3);
				Color shadowInner = (Color) params.get(4);
				return BorderFactory.createSoftBevelBorder(type, highlightOuter, highlightInner, shadowOuter, shadowInner);
			}

			assert false;
			return null;
		}
	};

	public static final StyleFunction COMPOUNDBORDER = new BaseFunction("compoundborder") {
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

		@Override public Class getReturn() {
			return Border.class;
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

	public static final StyleFunction DASHEDBORDER = new BaseFunction("dashedborder") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Paint.class},
			{Paint.class, Number.class, Number.class},
			{Paint.class, Number.class, Number.class, Number.class, Boolean.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"paint"},
			{"paint", "length", "spacing"},
			{"paint", "thickness", "length", "spacing", "rounded"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return paramId == 0;
		}

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			if (params.size() == 1) {
				Paint paint = (Paint) params.get(0);
				return BorderFactory.createDashedBorder(paint);
			}

			if (params.size() == 2) {
				Paint paint = (Paint) params.get(0);
				float length = (Float) params.get(1);
				float spacing = (Float) params.get(2);
				return BorderFactory.createDashedBorder(paint, length, spacing);
			}

			if (params.size() == 4) {
				Paint paint = (Paint) params.get(0);
				float thickness = (Float) params.get(1);
				float length = (Float) params.get(2);
				float spacing = (Float) params.get(3);
				boolean rounded = (Boolean) params.get(4);
				return BorderFactory.createDashedBorder(paint, thickness, length, spacing, rounded);
			}

			assert false;
			return null;
		}
	};

	public static final StyleFunction ETCHEDBORDER = new BaseFunction("etchedborder") {
		@Override public Class[][] getParams() {return new Class[][] {
			{},
			{Integer.class},
			{Color.class, Color.class},
			{Integer.class, Color.class, Color.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{},
			{"type"},
			{"highlight", "shadow"},
			{"type", "highlight", "shadow"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return paramId == 0;
		}

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			if (params.isEmpty()) {
				return BorderFactory.createEtchedBorder();
			}

			if (params.size() == 1) {
				int type = (Integer) params.get(0);
				return BorderFactory.createEtchedBorder(type);
			}

			if (params.size() == 2) {
				Color highlight = (Color) params.get(0);
				Color shadow = (Color) params.get(1);
				return BorderFactory.createEtchedBorder(highlight, shadow);
			}

			if (params.size() == 3) {
				int type = (Integer) params.get(0);
				Color highlight = (Color) params.get(1);
				Color shadow = (Color) params.get(2);
				return BorderFactory.createEtchedBorder(type, highlight, shadow);
			}

			assert false;
			return null;
		}
	};

	public static final StyleFunction TITLEDBORDER = new BaseFunction("titledborder") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Border.class},
			{String.class},
			{Border.class, String.class},
			{Border.class, String.class, Integer.class, Integer.class},
			{Border.class, String.class, Integer.class, Integer.class, Font.class},
			{Border.class, String.class, Integer.class, Integer.class, Font.class, Color.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"border"},
			{"title"},
			{"border", "title"},
			{"border", "title", "titleJustification", "titlePosition"},
			{"border", "title", "titleJustification", "titlePosition", "titleFont"},
			{"border", "title", "titleJustification", "titlePosition", "titleFont", "titleColor"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return paramId == 0;
		}

		@Override public Class getReturn() {
			return Border.class;
		}

		@Override public Object process(List<Object> params) {
			if (params.size() == 1 && params.get(0) instanceof Border) {
				Border border = (Border) params.get(0);
				return BorderFactory.createTitledBorder(border);
			}

			if (params.size() == 1 && params.get(0) instanceof String) {
				String title = (String) params.get(0);
				return BorderFactory.createTitledBorder(title);
			}

			if (params.size() == 2) {
				Border border = (Border) params.get(0);
				String title = (String) params.get(1);
				return BorderFactory.createTitledBorder(border, title);
			}

			if (params.size() == 4) {
				Border border = (Border) params.get(0);
				String title = (String) params.get(1);
				int titleJustification = (Integer) params.get(2);
				int titlePosition = (Integer) params.get(3);
				return BorderFactory.createTitledBorder(border, title, titleJustification, titlePosition);
			}

			if (params.size() == 5) {
				Border border = (Border) params.get(0);
				String title = (String) params.get(1);
				int titleJustification = (Integer) params.get(2);
				int titlePosition = (Integer) params.get(3);
				Font titleFont = (Font) params.get(4);
				return BorderFactory.createTitledBorder(border, title, titleJustification, titlePosition, titleFont);
			}

			if (params.size() == 6) {
				Border border = (Border) params.get(0);
				String title = (String) params.get(1);
				int titleJustification = (Integer) params.get(2);
				int titlePosition = (Integer) params.get(3);
				Font titleFont = (Font) params.get(4);
				Color titleColor = (Color) params.get(5);
				return BorderFactory.createTitledBorder(border, title, titleJustification, titlePosition, titleFont, titleColor);
			}

			assert false;
			return null;
		}
	};
}
