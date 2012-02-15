package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.StyleFunction;
import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingFunctions {

	// -------------------------------------------------------------------------
	// Files
	// -------------------------------------------------------------------------

	public static class Url implements StyleFunction {
		@Override public String getName() {return "url";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{String.class}
		};}

		@Override public Object process(List<Object> params) {
			String name = (String) params.get(0);
			return getClass().getResource(name);
		}
	};

	public static class Icon implements StyleFunction {
		@Override public String getName() {return "icon";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{URL.class},
			{String.class}
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

	public static class Rgb implements StyleFunction {
		@Override public String getName() {return "rgb";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class}
		};}

		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			return new Color(r, g, b);
		}
	};

	public static class Rgba implements StyleFunction {
		@Override public String getName() {return "rgba";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}

		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Float.class}
		};}


		@Override public Object process(List<Object> params) {
			int r = (Integer) params.get(0);
			int g = (Integer) params.get(1);
			int b = (Integer) params.get(2);
			int a = (int) (((Float) params.get(3)) * 255);
			return new Color(r, g, b, a);
		}
	};

	public static class LinearGradient implements StyleFunction {
		@Override public String getName() {return "lineargradient";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class, Number.class, Color.class},
			{Number.class, Number.class, Number.class, Number.class, Number.class, Color.class, Number.class, Color.class}
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

	public static class EmptyBorder implements StyleFunction {
		@Override public String getName() {return "emptyborder";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class}
		};}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int right = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int left = (Integer) params.get(3);
			return BorderFactory.createEmptyBorder(top, left, bottom, right);
		}
	};

	public static class LineBorder implements StyleFunction {
		@Override public String getName() {return "lineborder";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{Color.class},
			{Color.class, Integer.class},
			{Color.class, Integer.class, Boolean.class}
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

	public static class MatteBorder implements StyleFunction {
		@Override public String getName() {return "matteborder";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{Integer.class, Integer.class, Integer.class, Integer.class, Color.class},
			{Integer.class, Integer.class, Integer.class, Integer.class, javax.swing.Icon.class}
		};}

		@Override public Object process(List<Object> params) {
			int top = (Integer) params.get(0);
			int right = (Integer) params.get(1);
			int bottom = (Integer) params.get(2);
			int left = (Integer) params.get(3);

			if (params.get(4) instanceof Color) {
				Color color = (Color) params.get(4);
				return BorderFactory.createMatteBorder(top, left, bottom, right, color);
			}

			if (params.get(4) instanceof javax.swing.Icon) {
				javax.swing.Icon icon = (javax.swing.Icon) params.get(4);
				return BorderFactory.createMatteBorder(top, left, bottom, right, icon);
			}

			assert false;
			return null;
		}
	};

	public static class BevelBorder implements StyleFunction {
		@Override public String getName() {return "bevelborder";}
		@Override public String[] getKeywords(int paramsId, int paramId) {
			if (paramId == 0) return new String[] {"lowered", "raised"};
			return null;
		}

		@Override public Class[][] getParams() {return new Class[][] {
			{String.class},
			{String.class, Color.class, Color.class},
			{String.class, Color.class, Color.class, Color.class, Color.class}
		};}

		@Override public Object process(List<Object> params) {
			String typeStr = (String) params.get(0);
			int type = typeStr.equals("lowered") ? javax.swing.border.BevelBorder.LOWERED
					: javax.swing.border.BevelBorder.RAISED;

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

	public static class CompoundBorder implements StyleFunction {
		@Override public String getName() {return "compoundborder";}
		@Override public String[] getKeywords(int paramsId, int paramId) {return null;}
		@Override public Class[][] getParams() {return new Class[][] {
			{},
			{Border.class, Border.class}
		};}

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
