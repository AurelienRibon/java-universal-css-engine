package aurelienribon.ui.utils;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StrokeUtils {
	public static int getTopDelta(int width) {
		return width / 2;
	}

	public static int getLeftDelta(int width) {
		return width / 2;
	}

	public static int getBottomDelta(int width) {
		return -(width + 1) / 2 + 1;
	}

	public static int getRightDelta(int width) {
		return -(width + 1) / 2 + 1;
	}
}
