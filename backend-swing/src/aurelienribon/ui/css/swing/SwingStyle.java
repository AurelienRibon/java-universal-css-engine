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
		Style.registerRule(SwingRules.BACKGROUND);
		Style.registerRule(SwingRules.FOREGROUND);
		Style.registerRule(SwingRules.VISIBLE);
		Style.registerRule(SwingRules.ENABLED);
		Style.registerRule(SwingRules.FOCUSABLE);
		Style.registerRule(SwingRules.OPAQUE);
		Style.registerRule(SwingRules.EDITABLE);
		Style.registerRule(SwingRules.LINEWRAP);
		Style.registerRule(SwingRules.WRAPSTYLEWORD);
		Style.registerRule(SwingRules.TABSIZE);
		Style.registerRule(SwingRules.CARETPOSITION);
		Style.registerRule(SwingRules.TOOLTIP);
		Style.registerRule(SwingRules.TEXT);
		Style.registerRule(SwingRules.H_ALIGN);
		Style.registerRule(SwingRules.V_ALIGN);
		Style.registerRule(SwingRules.MARGIN);
		Style.registerRule(SwingRules.FONT);
		Style.registerRule(SwingRules.ICON);
		Style.registerRule(SwingRules.BORDER);

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

		Style.registerChildrenAccessor(Container.class, new StyleChildrenAccessor<Container>() {
			@Override public List<?> getStyleChildren(Container target) {
				return Arrays.asList(target.getComponents());
			}
		});

		Style.setParamConverter(new StyleParamConverter() {
			@Override public Object convertColor(int r, int g, int b, int a) {
				return new Color(r, g, b, a);
			}
		});
	}
}
