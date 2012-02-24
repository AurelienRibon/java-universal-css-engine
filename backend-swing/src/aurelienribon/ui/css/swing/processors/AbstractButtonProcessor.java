package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.DeclarationSet;
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
	public void process(AbstractButton target, DeclarationSet rs) {
		Property rule;

		rule = SwingRules.MARGIN;
		if (rs.contains(rule)) {
			Object param = rs.getValue(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(rs.getValue(rule));
			target.setMargin(value);
		}

		rule = SwingRules.H_ALIGN;
		if (rs.contains(rule)) {
			int value = SwingUtils.asHAlign(rs.getValue(rule), 0);
			target.setHorizontalAlignment(value);
		}

		rule = SwingRules.V_ALIGN;
		if (rs.contains(rule)) {
			int value = SwingUtils.asVAlign(rs.getValue(rule), 0);
			target.setVerticalAlignment(value);
		}

		rule = SwingRules.TEXT;
		if (rs.contains(rule)) {
			String value = (String) rs.getValue(rule).get(0);
			target.setText(value);
		}

		rule = SwingRules.ICON;
		if (rs.contains(rule)) {
			Icon value = (Icon) rs.getValue(rule).get(0);
			target.setIcon(value);
		}
	}
}
