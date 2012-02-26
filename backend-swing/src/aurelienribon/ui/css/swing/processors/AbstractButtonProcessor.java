package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingProperties;
import aurelienribon.ui.css.swing.SwingUtils;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.Icon;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AbstractButtonProcessor implements DeclarationSetProcessor<AbstractButton> {
	@Override
	public void process(AbstractButton target, DeclarationSet ds) {
		Property property;

		property = SwingProperties.margin;
		if (ds.contains(property)) {
			Object param = ds.getValue(property).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(ds.getValue(property));
			target.setMargin(value);
		}

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
