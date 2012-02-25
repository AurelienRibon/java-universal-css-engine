package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.swing.SwingRules;
import aurelienribon.ui.css.swing.SwingUtils;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JLabelProcessor implements DeclarationSetProcessor<JLabel> {
	@Override
	public void process(JLabel target, DeclarationSet rs) {
		Property rule;

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
