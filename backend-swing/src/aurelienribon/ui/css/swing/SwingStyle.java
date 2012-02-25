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
	public static void init() {
		Style.registerProperty(SwingRules.BACKGROUND);
		Style.registerProperty(SwingRules.FOREGROUND);
		Style.registerProperty(SwingRules.VISIBLE);
		Style.registerProperty(SwingRules.ENABLED);
		Style.registerProperty(SwingRules.FOCUSABLE);
		Style.registerProperty(SwingRules.OPAQUE);
		Style.registerProperty(SwingRules.EDITABLE);
		Style.registerProperty(SwingRules.LINEWRAP);
		Style.registerProperty(SwingRules.WRAPSTYLEWORD);
		Style.registerProperty(SwingRules.TABSIZE);
		Style.registerProperty(SwingRules.CARETPOSITION);
		Style.registerProperty(SwingRules.TOOLTIP);
		Style.registerProperty(SwingRules.TEXT);
		Style.registerProperty(SwingRules.H_ALIGN);
		Style.registerProperty(SwingRules.V_ALIGN);
		Style.registerProperty(SwingRules.MARGIN);
		Style.registerProperty(SwingRules.FONT);
		Style.registerProperty(SwingRules.ICON);
		Style.registerProperty(SwingRules.BORDER);

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
