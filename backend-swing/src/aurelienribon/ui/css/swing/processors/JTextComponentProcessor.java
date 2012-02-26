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
		Property rule;

		rule = SwingProperties.caretPosition;
		if (ds.contains(rule)) {
			int value = (Integer) ds.getValue(rule).get(0);
			target.setCaretPosition(value);
		}

		rule = SwingProperties.editable;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setEditable(value);
		}

		rule = SwingProperties.margin;
		if (ds.contains(rule)) {
			Object param = ds.getValue(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(ds.getValue(rule));
			target.setMargin(value);
		}

		rule = SwingProperties.text;
		if (ds.contains(rule)) {
			String value = (String) ds.getValue(rule).get(0);
			target.setText(value);
		}
	}
}
