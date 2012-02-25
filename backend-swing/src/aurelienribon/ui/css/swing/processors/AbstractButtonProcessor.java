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
		Property rule;

		rule = SwingProperties.MARGIN;
		if (ds.contains(rule)) {
			Object param = ds.getValue(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(ds.getValue(rule));
			target.setMargin(value);
		}

		rule = SwingProperties.H_ALIGN;
		if (ds.contains(rule)) {
			int value = SwingUtils.asHAlign(ds.getValue(rule), 0);
			target.setHorizontalAlignment(value);
		}

		rule = SwingProperties.V_ALIGN;
		if (ds.contains(rule)) {
			int value = SwingUtils.asVAlign(ds.getValue(rule), 0);
			target.setVerticalAlignment(value);
		}

		rule = SwingProperties.TEXT;
		if (ds.contains(rule)) {
			String value = (String) ds.getValue(rule).get(0);
			target.setText(value);
		}

		rule = SwingProperties.ICON;
		if (ds.contains(rule)) {
			Icon value = (Icon) ds.getValue(rule).get(0);
			target.setIcon(value);
		}
	}
}
