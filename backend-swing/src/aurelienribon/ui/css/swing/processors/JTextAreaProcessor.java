package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.swing.SwingRules;
import javax.swing.JTextArea;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JTextAreaProcessor implements StyleProcessor<JTextArea> {
	@Override
	public void process(JTextArea target, DeclarationSet rs) {
		Property rule;

		rule = SwingRules.LINEWRAP;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setLineWrap(value);
		}

		rule = SwingRules.WRAPSTYLEWORD;
		if (rs.contains(rule)) {
			boolean value = (Boolean) rs.getValue(rule).get(0);
			target.setWrapStyleWord(value);
		}

		rule = SwingRules.TABSIZE;
		if (rs.contains(rule)) {
			int value = (Integer) rs.getValue(rule).get(0);
			target.setTabSize(value);
		}
	}
}
