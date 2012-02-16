package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.*;
import java.awt.Container;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingStyle {
	public static void init() {
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
		Style.registerRule(SwingRules.BACKGROUND);
		Style.registerRule(SwingRules.FOREGROUND);

		Style.registerFunction(SwingFunctions.URL);
		Style.registerFunction(SwingFunctions.ICON);
		Style.registerFunction(SwingFunctions.FONT);
		Style.registerFunction(SwingFunctions.RGB);
		Style.registerFunction(SwingFunctions.RGBA);
		Style.registerFunction(SwingFunctions.LINEARGRADIENT);
		Style.registerFunction(SwingFunctions.EMPTYBORDER);
		Style.registerFunction(SwingFunctions.LINEBORDER);
		Style.registerFunction(SwingFunctions.MATTEBORDER);
		Style.registerFunction(SwingFunctions.BEVELBORDER);
		Style.registerFunction(SwingFunctions.SOFTBEVELBORDER);
		Style.registerFunction(SwingFunctions.DASHEDBORDER);
		Style.registerFunction(SwingFunctions.ETCHEDBORDER);
		Style.registerFunction(SwingFunctions.TITLEDBORDER);

		Style.registerProcessor(SwingProcessors.COMPONENT);
		Style.registerProcessor(SwingProcessors.JCOMPONENT);
		Style.registerProcessor(SwingProcessors.ABSTRACTBUTTON);
		Style.registerProcessor(SwingProcessors.JLABEL);
		Style.registerProcessor(SwingProcessors.JTEXTCOMPONENT);
		Style.registerProcessor(SwingProcessors.JTEXTAREA);

		Style.registerChildrenAccessor(Container.class, new StyleChildrenAccessor<Container>() {
			@Override public List<?> getChildren(Container target) {
				return Arrays.asList(target.getComponents());
			}
		});
	}
}
