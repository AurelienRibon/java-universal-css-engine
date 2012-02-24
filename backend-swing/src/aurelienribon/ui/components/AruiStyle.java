package aurelienribon.ui.components;

import aurelienribon.ui.css.Style;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiStyle {
	public static void init() {
		Style.registerRule(AruiRules.FOREGROUND_MOUSEOVER);
		Style.registerRule(AruiRules.FOREGROUND_MOUSEDOWN);
		Style.registerRule(AruiRules.FOREGROUND_SELECTED);
		Style.registerRule(AruiRules.FOREGROUND_UNSELECTED);
		Style.registerRule(AruiRules.STROKE);
		Style.registerRule(AruiRules.STROKE_MOUSEOVER);
		Style.registerRule(AruiRules.STROKE_MOUSEDOWN);
		Style.registerRule(AruiRules.STROKE_SELECTED);
		Style.registerRule(AruiRules.STROKE_UNSELECTED);
		Style.registerRule(AruiRules.FILL);
		Style.registerRule(AruiRules.FILL_MOUSEOVER);
		Style.registerRule(AruiRules.FILL_MOUSEDOWN);
		Style.registerRule(AruiRules.FILL_SELECTED);
		Style.registerRule(AruiRules.FILL_UNSELECTED);
		Style.registerRule(AruiRules.CORNERRADIUS);

		Style.registerFunction(AruiFunctions.groupBorder);

		Style.registerProcessor(Button.class, new Button.Processor());
		Style.registerProcessor(TabPanel.class, new TabPanel.Processor());
		Style.registerProcessor(TabPanelHeaderPanel.class, new TabPanelHeaderPanel.Processor());
		Style.registerProcessor(TabPanelHeaderSubPanel.class, new TabPanelHeaderSubPanel.Processor());
	}
}
