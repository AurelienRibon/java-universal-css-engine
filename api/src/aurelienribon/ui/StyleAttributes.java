package aurelienribon.ui;

import java.awt.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StyleAttributes {
	// -------------------------------------------------------------------------
	// Attrs + ctors
	// -------------------------------------------------------------------------

	private final Style style;
	private final Map<String, String> attrs;

	public StyleAttributes(Style style, Map<String, String> attrs) {
		this.style = style;
		this.attrs = attrs;
	}

	// -------------------------------------------------------------------------
	// Pubic API
	// -------------------------------------------------------------------------

	public Style getStyle() {
		return style;
	}

	public String get(String name) {
		return attrs.get(name);
	}

	public int getInt(String name, int defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;
		return Integer.parseInt(val);
	}

	public Color getColor(String name, Color defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;
		return getColor(name, val);
	}

	public Paint getPaint(String name, Paint defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;

		if (val.startsWith("gradient")) {
			Matcher m = Pattern.compile("gradient\\(([^,]+),([^,]+),([^,]+),([^,]+),([^,]+),([^\\)]+)\\)").matcher(val);
			if (m.matches()) {
				Color c1 = getColor(name, m.group(1).trim());
				Color c2 = getColor(name, m.group(4).trim());
				float x1 = Float.parseFloat(m.group(2).trim());
				float y1 = Float.parseFloat(m.group(3).trim());
				float x2 = Float.parseFloat(m.group(5).trim());
				float y2 = Float.parseFloat(m.group(6).trim());
				return new GradientPaint(x1, y1, c1, x2, y2, c2);
			} else {
				throw new RuntimeException(getErrorMsg(name));
			}

		} else {
			return getColor(name, val);
		}
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;
		return Boolean.parseBoolean(val);
	}

	public String getText(String name, String defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;
		return val.substring(1, val.length()-1);
	}

	public Insets getMargin(String name, Insets defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;

		String[] vals = val.split("\\s+");

		if (vals.length == 1) {
			int v = Integer.parseInt(vals[0]);
			return new Insets(v, v, v, v);

		} else if (vals.length == 2) {
			int v1 = Integer.parseInt(vals[0]);
			int v2 = Integer.parseInt(vals[1]);
			return new Insets(v1, v2, v1, v2);

		} else if (vals.length == 4) {
			int v1 = Integer.parseInt(vals[0]);
			int v2 = Integer.parseInt(vals[1]);
			int v3 = Integer.parseInt(vals[2]);
			int v4 = Integer.parseInt(vals[3]);
			return new Insets(v1, v4, v3, v2);

		} else throw new RuntimeException(getErrorMsg(name));
	}

	public int getHAlign(String name, int defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;

		if (val.equals("leading")) return SwingConstants.LEADING;
		if (val.equals("trailing")) return SwingConstants.TRAILING;
		if (val.equals("left")) return SwingConstants.LEFT;
		if (val.equals("right")) return SwingConstants.RIGHT;
		if (val.equals("center")) return SwingConstants.CENTER;

		throw new RuntimeException(getErrorMsg(name));
	}

	public int getVAlign(String name, int defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;

		if (val.equals("top")) return SwingConstants.TOP;
		if (val.equals("bottom")) return SwingConstants.BOTTOM;
		if (val.equals("center")) return SwingConstants.CENTER;

		throw new RuntimeException(getErrorMsg(name));
	}

	public Font getFont(String name, Font defaultValue) {
		String val = attrs.get(name);
		if (val == null) return defaultValue;

		Matcher m = Pattern.compile("\"([^\"]+)\"\\s+(plain|italic|bold)\\s+(\\d+)").matcher(val);
		if (m.matches()) {
			String familyName = m.group(1).substring(1, m.group(1).length()-2);
			int styleType = m.group(2).equals("plain") ? Font.PLAIN
				: m.group(2).equals("italic") ? Font.ITALIC
				: Font.BOLD;
			int size = Integer.parseInt(m.group(3));
			return new Font(familyName, styleType, size);
		}

		throw new RuntimeException(getErrorMsg(name));
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private String getErrorMsg(String name) {
		return "Invalid value for " + name;
	}

	private Color getColor(String name, String val) {
		if (val.length() == 7 || val.length() == 9) {
			long i = Long.decode(val);
			int r = (int) ((i>>16) & 0xFF);
			int g = (int) ((i>>8) & 0xFF);
			int b = (int) ((i) & 0xFF);
			int a = val.length() == 9 ? (int) ((i>>24) & 0xFF) : 255;
			return new Color(r, g, b, a);
		}

		throw new RuntimeException(getErrorMsg(name));
	}
}
