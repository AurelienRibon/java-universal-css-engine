package aurelienribon.ui.components;

import aurelienribon.ui.css.Style;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiStyle {
	public static void init() {
		Style.registerProperty(AruiRules.FOREGROUND_MOUSEOVER);
		Style.registerProperty(AruiRules.FOREGROUND_MOUSEDOWN);
		Style.registerProperty(AruiRules.FOREGROUND_SELECTED);
		Style.registerProperty(AruiRules.FOREGROUND_UNSELECTED);
		Style.registerProperty(AruiRules.STROKE);
		Style.registerProperty(AruiRules.STROKE_MOUSEOVER);
		Style.registerProperty(AruiRules.STROKE_MOUSEDOWN);
		Style.registerProperty(AruiRules.STROKE_SELECTED);
		Style.registerProperty(AruiRules.STROKE_UNSELECTED);
		Style.registerProperty(AruiRules.FILL);
		Style.registerProperty(AruiRules.FILL_MOUSEOVER);
		Style.registerProperty(AruiRules.FILL_MOUSEDOWN);
		Style.registerProperty(AruiRules.FILL_SELECTED);
		Style.registerProperty(AruiRules.FILL_UNSELECTED);
		Style.registerProperty(AruiRules.CORNERRADIUS);

		Style.registerFunction(AruiFunctions.groupBorder);

		Style.registerProcessor(Button.class, new Button.Processor());
		Style.registerProcessor(TabPanel.class, new TabPanel.Processor());
		Style.registerProcessor(TabPanelHeaderPanel.class, new TabPanelHeaderPanel.Processor());
		Style.registerProcessor(TabPanelHeaderSubPanel.class, new TabPanelHeaderSubPanel.Processor());
	}
}
