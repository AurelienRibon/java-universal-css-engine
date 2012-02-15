package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.BaseBooleanRule;
import aurelienribon.ui.css.BaseColorRule;
import aurelienribon.ui.css.BaseIntegerRule;
import aurelienribon.ui.css.BaseKeywordRule;
import aurelienribon.ui.css.BaseRule;
import aurelienribon.ui.css.BaseStringRule;
import aurelienribon.ui.css.Style;
import java.awt.Font;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.border.Border;

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
	public static final String RULE_ICON = "-swing-icon";
	public static final String RULE_BORDER = "-swing-border";

	public static void init() {
		Style.registerFunction(new SwingFunctions.UrlFunction());
		Style.registerFunction(new SwingFunctions.IconFunction());
		Style.registerFunction(new SwingFunctions.FontFunction());
		Style.registerFunction(new SwingFunctions.RgbFunction());
		Style.registerFunction(new SwingFunctions.RgbaFunction());
		Style.registerFunction(new SwingFunctions.LinearGradientFunction());
		Style.registerFunction(new SwingFunctions.EmptyBorderFunction());
		Style.registerFunction(new SwingFunctions.LineBorderFunction());
		Style.registerFunction(new SwingFunctions.MatteBorderFunction());
		Style.registerFunction(new SwingFunctions.BevelBorderFunction());
		Style.registerFunction(new SwingFunctions.SoftBevelBorderFunction());
		Style.registerFunction(new SwingFunctions.DashedBorderFunction());
		Style.registerFunction(new SwingFunctions.EtchedBorderFunction());
		Style.registerFunction(new SwingFunctions.TitledBorderFunction());

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

			@Override public String[][] getParamsNames() {return new String[][] {
				{"top", "left", "bottom", "right"},
				{"topBottom", "leftRight"},
				{"thickness"}
			};}

			@Override public boolean canBeNull(int paramsId, int paramId) {
				return paramsId == 2;
			}
		});

		Style.registerRule(new BaseRule(RULE_FONT) {
			@Override public Class[][] getParams() {return new Class[][] {
				{String.class, String.class, Integer.class},
				{Font.class}
			};}

			@Override public String[][] getParamsNames() {return new String[][] {
				{"name", "style", "size"},
				{"font"}
			};}

			@Override public String[] getKeywords(int paramsId, int paramId) {
				if (paramId == 1) return new String[] {"plain", "italic", "bold"};
				return null;
			}
		});

		Style.registerRule(new BaseRule(RULE_ICON) {
			@Override public Class[][] getParams() {return new Class[][] {
				{URL.class},
				{String.class},
				{Icon.class}
			};}

			@Override public String[][] getParamsNames() {return new String[][] {
				{"url"},
				{"filepath"},
				{"icon"}
			};}

			@Override public boolean canBeNull(int paramsId, int paramId) {
				return true;
			}
		});

		Style.registerRule(new BaseRule(RULE_BORDER) {
			@Override public Class[][] getParams() {return new Class[][] {
				{Border.class}
			};}

			@Override public String[][] getParamsNames() {return new String[][] {
				{"border"}
			};}

			@Override public boolean canBeNull(int paramsId, int paramId) {
				return true;
			}
		});
	}
}
