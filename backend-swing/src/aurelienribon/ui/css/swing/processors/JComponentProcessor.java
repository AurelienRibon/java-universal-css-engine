package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingProperties;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JComponentProcessor implements DeclarationSetProcessor<JComponent> {
	@Override
	public void process(JComponent target, DeclarationSet ds) {
		Property property;

		property = SwingProperties.opaque;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setOpaque(value);
		}

		property = SwingProperties.tooltip;
		if (ds.contains(property)) {
			String value = (String) ds.getValue(property).get(0);
			target.setToolTipText(value);
		}

		property = SwingProperties.border;
		if (ds.contains(property)) {
			Border value = (Border) ds.getValue(property).get(0);
			target.setBorder(value);
		}
	}
}
