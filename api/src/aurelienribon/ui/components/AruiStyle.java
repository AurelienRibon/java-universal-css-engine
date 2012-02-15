package aurelienribon.ui.components;

import aurelienribon.ui.css.BaseColorRule;
import aurelienribon.ui.css.BaseIntegerRule;
import aurelienribon.ui.css.BasePaintRule;
import aurelienribon.ui.css.Style;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiStyle {
	public static final String RULE_FOREGROUND_MOUSEOVER = "-arui-foreground-mouseover";
	public static final String RULE_FOREGROUND_MOUSEDOWN = "-arui-foreground-mousedown";
	public static final String RULE_FOREGROUND_SELECTED = "-arui-foreground-selected";
	public static final String RULE_STROKE = "-arui-stroke";
	public static final String RULE_STROKE_MOUSEOVER = "-arui-stroke-mouseover";
	public static final String RULE_STROKE_MOUSEDOWN = "-arui-stroke-mousedown";
	public static final String RULE_STROKE_SELECTED = "-arui-stroke-selected";
	public static final String RULE_FILL = "-arui-fill";
	public static final String RULE_FILL_MOUSEOVER = "-arui-fill-mouseover";
	public static final String RULE_FILL_MOUSEDOWN = "-arui-fill-mousedown";
	public static final String RULE_FILL_SELECTED = "-arui-fill-selected";
	public static final String RULE_CORNERRADIUS = "-arui-cornerradius";

	public static void init() {
		Style.registerFunction(new AruiFunctions.GroupBorderFunction());

		Style.registerProcessor(new Button.Processor());
		Style.registerProcessor(new TabPanel.Processor());
		Style.registerProcessor(new TabPanelHeaderPanel.Processor());
		Style.registerProcessor(new TabPanelHeaderSubPanel.Processor());

		Style.registerRule(new BaseColorRule(RULE_FOREGROUND_MOUSEOVER));
		Style.registerRule(new BaseColorRule(RULE_FOREGROUND_MOUSEDOWN));
		Style.registerRule(new BaseColorRule(RULE_FOREGROUND_SELECTED));
		Style.registerRule(new BaseColorRule(RULE_STROKE));
		Style.registerRule(new BaseColorRule(RULE_STROKE_MOUSEOVER));
		Style.registerRule(new BaseColorRule(RULE_STROKE_MOUSEDOWN));
		Style.registerRule(new BaseColorRule(RULE_STROKE_SELECTED));
		Style.registerRule(new BasePaintRule(RULE_FILL));
		Style.registerRule(new BasePaintRule(RULE_FILL_MOUSEOVER));
		Style.registerRule(new BasePaintRule(RULE_FILL_MOUSEDOWN));
		Style.registerRule(new BasePaintRule(RULE_FILL_SELECTED));
		Style.registerRule(new BaseIntegerRule(RULE_CORNERRADIUS));
	}
}
