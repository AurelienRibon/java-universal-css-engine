package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingProperties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ComponentProcessor implements DeclarationSetProcessor<Component> {
	@Override
	public void process(Component target, DeclarationSet ds) {
		Property property;

		property = SwingProperties.background;
		if (ds.contains(property)) {
			Color value = (Color) ds.getValue(property).get(0);
			target.setBackground(value);
		}

		property = SwingProperties.foreground;
		if (ds.contains(property)) {
			Color value = (Color) ds.getValue(property).get(0);
			target.setForeground(value);
		}

		property = SwingProperties.visible;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setVisible(value);
		}

		property = SwingProperties.enabled;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setEnabled(value);
		}

		property = SwingProperties.focusable;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setFocusable(value);
		}

		property = SwingProperties.font;
		if (ds.contains(property)) {
			Object param = ds.getValue(property).get(0);
			Font value = param instanceof Font
				? (Font) param
				: (Font) SwingFunctions.font.process(ds.getValue(property));
			target.setFont(value);
		}
	}
}
