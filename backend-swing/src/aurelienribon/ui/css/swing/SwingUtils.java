package aurelienribon.ui.css.swing;

import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.SwingConstants;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingUtils {
	public static int asHAlign(List<Object> params, int paramId) {
		String val = (String) params.get(paramId);

		if (val.equals("leading")) return SwingConstants.LEADING;
		else if (val.equals("trailing")) return SwingConstants.TRAILING;
		else if (val.equals("left")) return SwingConstants.LEFT;
		else if (val.equals("right")) return SwingConstants.RIGHT;
		else if (val.equals("center")) return SwingConstants.CENTER;

		assert false;
		return -1;
	}

	public static int asVAlign(List<Object> params, int paramId) {
		String val = (String) params.get(paramId);

		if (val.equals("bottom")) return AbstractButton.BOTTOM;
		else if (val.equals("top")) return AbstractButton.TOP;
		else if (val.equals("center")) return AbstractButton.CENTER;

		assert false;
		return -1;
	}
}
