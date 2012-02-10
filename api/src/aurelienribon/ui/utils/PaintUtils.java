package aurelienribon.ui.utils;

import java.awt.Color;
import java.awt.GradientPaint;
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
		if (p instanceof Color) return getBrightness((Color) p);
		if (p instanceof GradientPaint) {
			GradientPaint gp = (GradientPaint) p;
			int b1 = getBrightness(gp.getColor1());
			int b2 = getBrightness(gp.getColor2());
			return (b1 + b2) / 2;
		}

		assert false;
		return -1;
	}

	public static Paint buildPaint(Paint p, int w, int h) {
		if (p instanceof Color) return p;
		if (p instanceof GradientPaint) {
			GradientPaint gp = (GradientPaint) p;
			double gpX1 = gp.getPoint1().getX();
			double gpY1 = gp.getPoint1().getY();
			double gpX2 = gp.getPoint2().getX();
			double gpY2 = gp.getPoint2().getY();
			float x1 = (float) (gpX1 * w);
			float y1 = (float) (gpY1 * h);
			float x2 = (float) (gpX2 * w);
			float y2 = (float) (gpY2 * h);
			return new GradientPaint(x1, y1, gp.getColor1(), x2, y2, gp.getColor2());
		}

		assert false;
		return null;
	}
}
