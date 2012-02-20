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
		Style.registerRule(AruiRules.STROKE);
		Style.registerRule(AruiRules.STROKE_MOUSEOVER);
		Style.registerRule(AruiRules.STROKE_MOUSEDOWN);
		Style.registerRule(AruiRules.STROKE_SELECTED);
		Style.registerRule(AruiRules.FILL);
		Style.registerRule(AruiRules.FILL_MOUSEOVER);
		Style.registerRule(AruiRules.FILL_MOUSEDOWN);
		Style.registerRule(AruiRules.FILL_SELECTED);
		Style.registerRule(AruiRules.CORNERRADIUS);

		Style.registerFunction(AruiFunctions.GROUPBORDER);

		Style.registerProcessor(Button.PROCESSOR);
		Style.registerProcessor(TabPanel.PROCESSOR);
		Style.registerProcessor(TabPanelHeaderPanel.PROCESSOR);
		Style.registerProcessor(TabPanelHeaderSubPanel.PROCESSOR);
	}
}
