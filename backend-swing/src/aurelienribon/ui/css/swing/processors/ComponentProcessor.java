package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRule;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingRules;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ComponentProcessor implements StyleProcessor<Component> {
	@Override
	public void process(Component target, StyleRuleSet rs) {
		StyleRule rule;

		rule = SwingRules.BACKGROUND;
		if (rs.contains(rule)) {
			Color value = (Color) rs.getParams(rule).get(0);
			target.setBackground(value);
		}

		rule = SwingRules.FOREGROUND;
		if (rs.contains(rule)) {
			Color value = (Color) rs.getParams(rule).get(0);
			target.setForeground(value);
		}

		rule = SwingRules.VISIBLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getParams(rule).get(0);
			target.setVisible(value);
		}

		rule = SwingRules.ENABLED;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getParams(rule).get(0);
			target.setEnabled(value);
		}

		rule = SwingRules.FOCUSABLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getParams(rule).get(0);
			target.setFocusable(value);
		}

		rule = SwingRules.FONT;
		if (rs.contains(rule)) {
			Object param = rs.getParams(rule).get(0);
			Font value = param instanceof Font
				? (Font) param
				: (Font) SwingFunctions.font.process(rs.getParams(rule));
			target.setFont(value);
		}
	}
}
