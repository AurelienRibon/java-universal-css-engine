package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingProperties;
import java.awt.Insets;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JTextComponentProcessor implements DeclarationSetProcessor<JTextComponent> {
	@Override
	public void process(JTextComponent target, DeclarationSet ds) {
		Property property;

		property = SwingProperties.caretPosition;
		if (ds.contains(property)) {
			int value = (Integer) ds.getValue(property).get(0);
			target.setCaretPosition(value);
		}

		property = SwingProperties.editable;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setEditable(value);
		}

		property = SwingProperties.margin;
		if (ds.contains(property)) {
			Object param = ds.getValue(property).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(ds.getValue(property));
			target.setMargin(value);
		}

		property = SwingProperties.text;
		if (ds.contains(property)) {
			String value = (String) ds.getValue(property).get(0);
			target.setText(value);
		}
	}
}
