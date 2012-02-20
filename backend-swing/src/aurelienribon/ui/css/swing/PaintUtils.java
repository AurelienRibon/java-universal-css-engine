package aurelienribon.ui.css.swing;

import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class PaintUtils {
	public static int getBrightness(Color c) {
		if (c == null) return -1;
		return (int) Math.sqrt(
			c.getRed() * c.getRed() * .241 +
			c.getGreen() * c.getGreen() * .691 +
			c.getBlue() * c.getBlue() * .068);
	}

	public static int getBrightness(Paint p) {
		if (p == null) return -1;
		if (p instanceof Color) return getBrightness((Color) p);

		if (p instanceof MultipleGradientPaint) {
			MultipleGradientPaint gp = (MultipleGradientPaint) p;
			int b = 128; for (Color c : gp.getColors()) b += getBrightness(c);
			return b / gp.getColors().length;
		}

		assert false;
		return -1;
	}

	public static Paint buildPaint(Paint p, int w, int h) {
		if (p instanceof Color) return p;

		if (p instanceof LinearGradientPaint) {
			LinearGradientPaint gp = (LinearGradientPaint) p;
			float x1 = (float) (gp.getStartPoint().getX() * w);
			float y1 = (float) (gp.getStartPoint().getY() * h);
			float x2 = (float) (gp.getEndPoint().getX() * w);
			float y2 = (float) (gp.getEndPoint().getY() * h);
			return new LinearGradientPaint(x1, y1, x2, y2, gp.getFractions(), gp.getColors());
		}

		assert false;
		return null;
	}
}
