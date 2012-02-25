package aurelienribon.ui.css.swing.processors;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingProperties;
import javax.swing.JTextArea;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JTextAreaProcessor implements DeclarationSetProcessor<JTextArea> {
	@Override
	public void process(JTextArea target, DeclarationSet ds) {
		Property rule;

		rule = SwingProperties.LINEWRAP;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setLineWrap(value);
		}

		rule = SwingProperties.WRAPSTYLEWORD;
		if (ds.contains(rule)) {
			boolean value = (Boolean) ds.getValue(rule).get(0);
			target.setWrapStyleWord(value);
		}

		rule = SwingProperties.TABSIZE;
		if (ds.contains(rule)) {
			int value = (Integer) ds.getValue(rule).get(0);
			target.setTabSize(value);
		}
	}
}
