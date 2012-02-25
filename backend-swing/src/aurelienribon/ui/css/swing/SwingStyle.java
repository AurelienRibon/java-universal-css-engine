package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.*;
import aurelienribon.ui.css.swing.processors.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingStyle {

	/**
	 * Registers all the properties, functions and processors of the Swing
	 * backend to the CSS engine. Also registers a children accessor used
	 * to return every children of an AWT Container, and a param converter
	 * used to convert undefined colors into AWT Color objects.
	 */
	public static void init() {
		Style.registerProperty(SwingProperties.BACKGROUND);
		Style.registerProperty(SwingProperties.FOREGROUND);
		Style.registerProperty(SwingProperties.VISIBLE);
		Style.registerProperty(SwingProperties.ENABLED);
		Style.registerProperty(SwingProperties.FOCUSABLE);
		Style.registerProperty(SwingProperties.OPAQUE);
		Style.registerProperty(SwingProperties.EDITABLE);
		Style.registerProperty(SwingProperties.LINEWRAP);
		Style.registerProperty(SwingProperties.WRAPSTYLEWORD);
		Style.registerProperty(SwingProperties.TABSIZE);
		Style.registerProperty(SwingProperties.CARETPOSITION);
		Style.registerProperty(SwingProperties.TOOLTIP);
		Style.registerProperty(SwingProperties.TEXT);
		Style.registerProperty(SwingProperties.H_ALIGN);
		Style.registerProperty(SwingProperties.V_ALIGN);
		Style.registerProperty(SwingProperties.MARGIN);
		Style.registerProperty(SwingProperties.FONT);
		Style.registerProperty(SwingProperties.ICON);
		Style.registerProperty(SwingProperties.BORDER);

		Style.registerFunction(SwingFunctions.bevelBorder);
		Style.registerFunction(SwingFunctions.compoundBorder);
		Style.registerFunction(SwingFunctions.dashedBorder);
		Style.registerFunction(SwingFunctions.emptyBorder);
		Style.registerFunction(SwingFunctions.etchedBorder);
		Style.registerFunction(SwingFunctions.font);
		Style.registerFunction(SwingFunctions.icon);
		Style.registerFunction(SwingFunctions.insets);
		Style.registerFunction(SwingFunctions.lineBorder);
		Style.registerFunction(SwingFunctions.linearGradient);
		Style.registerFunction(SwingFunctions.matteBorder);
		Style.registerFunction(SwingFunctions.rgb);
		Style.registerFunction(SwingFunctions.rgba);
		Style.registerFunction(SwingFunctions.titledBorder);
		Style.registerFunction(SwingFunctions.url);

		Style.registerProcessor(Component.class, new ComponentProcessor());
		Style.registerProcessor(JComponent.class, new JComponentProcessor());
		Style.registerProcessor(AbstractButton.class, new AbstractButtonProcessor());
		Style.registerProcessor(JLabel.class, new JLabelProcessor());
		Style.registerProcessor(JTextComponent.class,new JTextComponentProcessor());
		Style.registerProcessor(JTextArea.class, new JTextAreaProcessor());

		Style.registerChildrenAccessor(Container.class, new ChildrenAccessor<Container>() {
			@Override public List<?> getChildren(Container target) {
				return Arrays.asList(target.getComponents());
			}
		});

		Style.setParamConverter(new ParamConverter() {
			@Override public Object convertColor(int r, int g, int b, int a) {
				return new Color(r, g, b, a);
			}
		});
	}
}
