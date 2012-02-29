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
public class ComponentProcessor implements DeclarationSetProcessor<Component>, SwingProperties {
	@Override
	public void process(Component t, DeclarationSet ds) {
		Property p;

		p = background; if (ds.contains(p)) t.setBackground(ds.getValue(p, Color.class));
		p = foreground; if (ds.contains(p)) t.setForeground(ds.getValue(p, Color.class));
		p = visible; if (ds.contains(p)) t.setVisible(ds.getValue(p, Boolean.class));
		p = enabled; if (ds.contains(p)) t.setEnabled(ds.getValue(p, Boolean.class));
		p = focusable; if (ds.contains(p)) t.setFocusable(ds.getValue(p, Boolean.class));
		p = font; if (ds.contains(p)) t.setFont(ds.getValue(p, Font.class, SwingFunctions.font));
	}
}
