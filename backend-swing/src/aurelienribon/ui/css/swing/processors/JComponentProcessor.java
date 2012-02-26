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
		Property rule;

		rule = SwingProperties.opaque;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setOpaque(value);
		}

		rule = SwingProperties.tooltip;
		if (ds.contains(rule)) {
			String value = (String) ds.getValue(rule).get(0);
			target.setToolTipText(value);
		}

		rule = SwingProperties.border;
		if (ds.contains(rule)) {
			Border value = (Border) ds.getValue(rule).get(0);
			target.setBorder(value);
		}
	}
}
