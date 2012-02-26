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
		Property property;

		property = SwingProperties.lineWrap;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setLineWrap(value);
		}

		property = SwingProperties.wrapStyleWord;
		if (ds.contains(property)) {
			boolean value = (Boolean) ds.getValue(property).get(0);
			target.setWrapStyleWord(value);
		}

		property = SwingProperties.tabSize;
		if (ds.contains(property)) {
			int value = (Integer) ds.getValue(property).get(0);
			target.setTabSize(value);
		}
	}
}
