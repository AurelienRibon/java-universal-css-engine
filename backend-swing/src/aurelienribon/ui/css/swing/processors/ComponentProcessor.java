package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingRules;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ComponentProcessor implements DeclarationSetProcessor<Component> {
	@Override
	public void process(Component target, DeclarationSet rs) {
		Property rule;

		rule = SwingRules.BACKGROUND;
		if (rs.contains(rule)) {
			Color value = (Color) rs.getValue(rule).get(0);
			target.setBackground(value);
		}

		rule = SwingRules.FOREGROUND;
		if (rs.contains(rule)) {
			Color value = (Color) rs.getValue(rule).get(0);
			target.setForeground(value);
		}

		rule = SwingRules.VISIBLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setVisible(value);
		}

		rule = SwingRules.ENABLED;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setEnabled(value);
		}

		rule = SwingRules.FOCUSABLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setFocusable(value);
		}

		rule = SwingRules.FONT;
		if (rs.contains(rule)) {
			Object param = rs.getValue(rule).get(0);
			Font value = param instanceof Font
				? (Font) param
				: (Font) SwingFunctions.font.process(rs.getValue(rule));
			target.setFont(value);
		}
	}
}
