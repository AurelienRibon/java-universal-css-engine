package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRule;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingRules;
import java.awt.Insets;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JTextComponentProcessor implements StyleProcessor<JTextComponent> {
	@Override
	public void process(JTextComponent target, StyleRuleSet rs) {
		StyleRule rule;

		rule = SwingRules.CARETPOSITION;
		if (rs.contains(rule)) {
			int value = (Integer) rs.getParams(rule).get(0);
			target.setCaretPosition(value);
		}

		rule = SwingRules.EDITABLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getParams(rule).get(0);
			target.setEditable(value);
		}

		rule = SwingRules.MARGIN;
		if (rs.contains(rule)) {
			Object param = rs.getParams(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(rs.getParams(rule));
			target.setMargin(value);
		}

		rule = SwingRules.TEXT;
		if (rs.contains(rule)) {
			String value = (String) rs.getParams(rule).get(0);
			target.setText(value);
		}
	}
}
