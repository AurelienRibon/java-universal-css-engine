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
		Property property;

		property = SwingProperties.horizAlign;
		if (ds.contains(property)) {
			int value = SwingUtils.asHAlign(ds.getValue(property), 0);
			target.setHorizontalAlignment(value);
		}

		property = SwingProperties.vertAlign;
		if (ds.contains(property)) {
			int value = SwingUtils.asVAlign(ds.getValue(property), 0);
			target.setVerticalAlignment(value);
		}

		property = SwingProperties.text;
		if (ds.contains(property)) {
			String value = (String) ds.getValue(property).get(0);
			target.setText(value);
		}

		property = SwingProperties.icon;
		if (ds.contains(property)) {
			Icon value = (Icon) ds.getValue(property).get(0);
			target.setIcon(value);
		}
	}
}
