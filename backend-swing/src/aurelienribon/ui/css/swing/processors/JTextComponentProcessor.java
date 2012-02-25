package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingRules;
import java.awt.Insets;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JTextComponentProcessor implements DeclarationSetProcessor<JTextComponent> {
	@Override
	public void process(JTextComponent target, DeclarationSet rs) {
		Property rule;

		rule = SwingRules.CARETPOSITION;
		if (rs.contains(rule)) {
			int value = (Integer) rs.getValue(rule).get(0);
			target.setCaretPosition(value);
		}

		rule = SwingRules.EDITABLE;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setEditable(value);
		}

		rule = SwingRules.MARGIN;
		if (rs.contains(rule)) {
			Object param = rs.getValue(rule).get(0);
			Insets value = param instanceof Insets
				? (Insets) param
				: (Insets) SwingFunctions.insets.process(rs.getValue(rule));
			target.setMargin(value);
		}

		rule = SwingRules.TEXT;
		if (rs.contains(rule)) {
			String value = (String) rs.getValue(rule).get(0);
			target.setText(value);
		}
	}
}
