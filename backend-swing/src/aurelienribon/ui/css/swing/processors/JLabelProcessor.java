package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingProperties;
import aurelienribon.ui.css.swing.SwingUtils;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JLabelProcessor implements DeclarationSetProcessor<JLabel> {
	@Override
	public void process(JLabel target, DeclarationSet ds) {
		Property rule;

		rule = SwingProperties.horizAlign;
		if (ds.contains(rule)) {
			int value = SwingUtils.asHAlign(ds.getValue(rule), 0);
			target.setHorizontalAlignment(value);
		}

		rule = SwingProperties.vertAlign;
		if (ds.contains(rule)) {
			int value = SwingUtils.asVAlign(ds.getValue(rule), 0);
			target.setVerticalAlignment(value);
		}

		rule = SwingProperties.text;
		if (ds.contains(rule)) {
			String value = (String) ds.getValue(rule).get(0);
			target.setText(value);
		}

		rule = SwingProperties.icon;
		if (ds.contains(rule)) {
			Icon value = (Icon) ds.getValue(rule).get(0);
			target.setIcon(value);
		}
	}
}
