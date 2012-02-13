package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.StyleFunction;
import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingFunctions {
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
}
