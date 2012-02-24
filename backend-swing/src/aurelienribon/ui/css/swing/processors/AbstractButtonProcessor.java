package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRule;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingRules;
import aurelienribon.ui.css.swing.SwingUtils;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.Icon;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AbstractButtonProcessor implements StyleProcessor<AbstractButton> {
	@Override
	public void process(AbstractButton target, StyleRuleSet rs) {
		StyleRule rule;

		rule = SwingRules.MARGIN;
		if (rs.contains(rule)) {
			Object param = rs.getParams(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(rs.getParams(rule));
			target.setMargin(value);
		}

		rule = SwingRules.H_ALIGN;
		if (rs.contains(rule)) {
			int value = SwingUtils.asHAlign(rs.getParams(rule), 0);
			target.setHorizontalAlignment(value);
		}

		rule = SwingRules.V_ALIGN;
		if (rs.contains(rule)) {
			int value = SwingUtils.asVAlign(rs.getParams(rule), 0);
			target.setVerticalAlignment(value);
		}

		rule = SwingRules.TEXT;
		if (rs.contains(rule)) {
			String value = (String) rs.getParams(rule).get(0);
			target.setText(value);
		}

		rule = SwingRules.ICON;
		if (rs.contains(rule)) {
			Icon value = (Icon) rs.getParams(rule).get(0);
			target.setIcon(value);
		}
	}
}
