package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.BaseBooleanRule;
import aurelienribon.ui.css.BaseColorRule;
import aurelienribon.ui.css.BaseIntegerRule;
import aurelienribon.ui.css.BaseKeywordRule;
import aurelienribon.ui.css.BaseRule;
import aurelienribon.ui.css.BaseStringRule;
import aurelienribon.ui.css.Style;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingStyle {
	// Color
	public static final String RULE_BACKGROUND = "-swing-background";
	public static final String RULE_FOREGROUND = "-swing-foreground";

	// Boolean
	public static final String RULE_VISIBLE = "-swing-visible";
	public static final String RULE_ENABLED = "-swing-enabled";
	public static final String RULE_FOCUSABLE = "-swing-focusable";
	public static final String RULE_OPAQUE = "-swing-opaque";
	public static final String RULE_EDITABLE = "-swing-editable";
	public static final String RULE_LINEWRAP = "-swing-linewrap";
	public static final String RULE_WRAPSTYLEWORD = "-swing-wrapstyleword";

	// Integer
	public static final String RULE_TABSIZE = "-swing-tabsize";
	public static final String RULE_CARETPOSITION = "-swing-caretposition";

	// String
	public static final String RULE_TOOLTIP = "-swing-tooltiptext";
	public static final String RULE_TEXT = "-swing-text";
	public static final String RULE_H_ALIGN = "-swing-horizontalalignment";
	public static final String RULE_V_ALIGN = "-swing-verticalalignment";

	// Misc
	public static final String RULE_MARGIN = "-swing-margin";
	public static final String RULE_FONT = "-swing-font";

	public static void init() {
		Style.registerFunction(new SwingFunctions.Rgb());
		Style.registerFunction(new SwingFunctions.Rgba());
		Style.registerFunction(new SwingFunctions.LinearGradient());

		Style.registerProcessor(new SwingProcessor());

		Style.registerRule(new BaseColorRule(RULE_BACKGROUND));
		Style.registerRule(new BaseColorRule(RULE_FOREGROUND));
		Style.registerRule(new BaseBooleanRule(RULE_VISIBLE));
		Style.registerRule(new BaseBooleanRule(RULE_ENABLED));
		Style.registerRule(new BaseBooleanRule(RULE_FOCUSABLE));
		Style.registerRule(new BaseBooleanRule(RULE_OPAQUE));
		Style.registerRule(new BaseBooleanRule(RULE_EDITABLE));
		Style.registerRule(new BaseBooleanRule(RULE_LINEWRAP));
		Style.registerRule(new BaseBooleanRule(RULE_WRAPSTYLEWORD));
		Style.registerRule(new BaseIntegerRule(RULE_TABSIZE));
		Style.registerRule(new BaseIntegerRule(RULE_CARETPOSITION));
		Style.registerRule(new BaseStringRule(RULE_TOOLTIP));
		Style.registerRule(new BaseStringRule(RULE_TEXT));
		Style.registerRule(new BaseKeywordRule(RULE_H_ALIGN, "leading", "trailing", "left", "right", "center"));
		Style.registerRule(new BaseKeywordRule(RULE_V_ALIGN, "top", "bottom", "center"));

		Style.registerRule(new BaseRule(RULE_MARGIN) {
			@Override public Class[][] getParams() {return new Class[][] {
				{Integer.class, Integer.class, Integer.class, Integer.class},
				{Integer.class, Integer.class},
				{Integer.class}
			};}
		});

		Style.registerRule(new BaseRule(RULE_FONT) {
			@Override public Class[][] getParams() {return new Class[][] {
				{String.class, String.class, Integer.class}
			};}

			@Override public String[] getKeywords(int paramsId, int paramId) {
				if (paramId == 1) return new String[] {"plain", "italic", "bold"};
				return null;
			}
		});
	}
}
