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
		Property rule;

		rule = SwingProperties.background;
		if (ds.contains(rule)) {
			Color value = (Color) ds.getValue(rule).get(0);
			target.setBackground(value);
		}

		rule = SwingProperties.foreground;
		if (ds.contains(rule)) {
			Color value = (Color) ds.getValue(rule).get(0);
			target.setForeground(value);
		}

		rule = SwingProperties.visible;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setVisible(value);
		}

		rule = SwingProperties.enabled;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setEnabled(value);
		}

		rule = SwingProperties.focusable;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setFocusable(value);
		}

		rule = SwingProperties.font;
		if (ds.contains(rule)) {
			Object param = ds.getValue(rule).get(0);
			Font value = param instanceof Font
				? (Font) param
				: (Font) SwingFunctions.font.process(ds.getValue(rule));
			target.setFont(value);
		}
	}
}
