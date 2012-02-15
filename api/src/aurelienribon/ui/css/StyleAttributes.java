package aurelienribon.ui.css;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Paint;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StyleAttributes {
	private final Map<String, List<Object>> attrs = new HashMap<String, List<Object>>();

	public StyleAttributes(Style style, Object target, List<String> stack) {
		for (StyleClass sc : style.getClasses()) {
			if (isLastSelectorValid(sc.getLastSelector(), target) && isStackValid(sc.getSelectors(), stack)) {
				attrs.putAll(sc.getRules());
			}
		}
	}

	public List<String> getNames() {
		return new ArrayList<String>(attrs.keySet());
	}

	public List<Object> getParams(String attrName) {
		return attrs.get(attrName);
	}

	public boolean contains(String name) {
		return attrs.containsKey(name);
	}

	private boolean isLastSelectorValid(String selector, Object target) {
		if (selector.startsWith(".")) {
			String className = Style.getRegisteredTargetClass(target);
			return className != null && className.equals(selector);

		} else {
			try {
				Class clazz = Class.forName(selector.replaceAll("-", "."));
				return clazz.isInstance(target);

			} catch (ClassNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private boolean isStackValid(List<String> selectors, List<String> stack) {
		if (selectors.size() == 1) return true;

		for (int i=0; i<selectors.size()-1; i++) {
			int idx = stack.indexOf(selectors.get(i));
			if (idx == -1) return false;
		}

		for (int i=1; i<selectors.size()-1; i++) {
			int idx1 = stack.indexOf(selectors.get(i-1));
			int idx2 = stack.lastIndexOf(selectors.get(i));
			if (idx1 >= idx2) return false;
		}

		return true;
	}

	// -------------------------------------------------------------------------
	// Utils
	// -------------------------------------------------------------------------

	public Color asColor(String ruleName) {
		return (Color) attrs.get(ruleName).get(0);
	}

	public Paint asPaint(String ruleName) {
		return (Paint) attrs.get(ruleName).get(0);
	}

	public Boolean asBoolean(String ruleName) {
		return (Boolean) attrs.get(ruleName).get(0);
	}

	public Integer asInteger(String ruleName) {
		return (Integer) attrs.get(ruleName).get(0);
	}

	public Float asFloat(String ruleName) {
		return (Float) attrs.get(ruleName).get(0);
	}

	public String asString(String ruleName) {
		return (String) attrs.get(ruleName).get(0);
	}

	public Insets asInsets(String ruleName) {
		List<Object> params = attrs.get(ruleName);
		if (params.get(0) == null) return null;

		int top, left, bottom, right;

		if (params.size() == 1) {
			top = left = bottom = right = (Integer) params.get(0);

		} else if (params.size() == 2) {
			top = bottom = (Integer) params.get(0);
			left = right = (Integer) params.get(1);

		} else {
			top = (Integer) params.get(0);
			left = (Integer) params.get(1);
			bottom = (Integer) params.get(2);
			right = (Integer) params.get(3);
		}

		return new Insets(top, left, bottom, right);
	}

	public int asHAlign(String ruleName) {
		List<Object> params = attrs.get(ruleName);
		String val = (String) params.get(0);

		if (val.equals("leading")) return SwingConstants.LEADING;
		else if (val.equals("trailing")) return SwingConstants.TRAILING;
		else if (val.equals("left")) return SwingConstants.LEFT;
		else if (val.equals("right")) return SwingConstants.RIGHT;
		else if (val.equals("center")) return SwingConstants.CENTER;

		assert false;
		return -1;
	}

	public int asVAlign(String ruleName) {
		List<Object> params = attrs.get(ruleName);
		String val = (String) params.get(0);

		if (val.equals("bottom")) return AbstractButton.BOTTOM;
		else if (val.equals("top")) return AbstractButton.TOP;
		else if (val.equals("center")) return AbstractButton.CENTER;

		assert false;
		return -1;
	}

	public Font asFont(String ruleName) {
		if (attrs.get(ruleName).get(0) instanceof Font)
			return (Font) attrs.get(ruleName).get(0);

		String p1 = (String) attrs.get(ruleName).get(0);
		String p2 = (String) attrs.get(ruleName).get(1);
		int p3 = (Integer) attrs.get(ruleName).get(2);

		int style = -1;

		if (p2.equals("plain")) style = Font.PLAIN;
		else if (p2.equals("italic")) style = Font.ITALIC;
		else if (p2.equals("bold")) style = Font.BOLD;
		else assert false;

		return new Font(p1, style, p3);
	}

	public Icon asIcon(String ruleName) {
		Object param = getParams(ruleName).get(0);

		if (param instanceof URL) return new ImageIcon((URL) param);
		if (param instanceof String) return new ImageIcon((String) param);
		if (param instanceof Icon) return (Icon) param;
		if (param == null) return null;

		assert false;
		return null;
	}

	public Border asBorder(String ruleName) {
		return (Border) getParams(ruleName).get(0);
	}
}
