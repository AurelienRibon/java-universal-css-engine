package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.*;
import java.awt.Font;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingRules {
	public static final StyleRule BACKGROUND = new BaseColorRule("-swing-background");
	public static final StyleRule FOREGROUND = new BaseColorRule("-swing-foreground");

	public static final StyleRule VISIBLE = new BaseBooleanRule("-swing-visible");
	public static final StyleRule ENABLED = new BaseBooleanRule("-swing-enabled");
	public static final StyleRule FOCUSABLE = new BaseBooleanRule("-swing-focusable");
	public static final StyleRule OPAQUE = new BaseBooleanRule("-swing-opaque");
	public static final StyleRule EDITABLE = new BaseBooleanRule("-swing-editable");
	public static final StyleRule LINEWRAP = new BaseBooleanRule("-swing-linewrap");
	public static final StyleRule WRAPSTYLEWORD = new BaseBooleanRule("-swing-wrapstyleword");

	public static final StyleRule TABSIZE = new BaseIntegerRule("-swing-tabsize");
	public static final StyleRule CARETPOSITION = new BaseIntegerRule("-swing-caretposition");

	public static final StyleRule TOOLTIP = new BaseStringRule("-swing-tooltiptext");
	public static final StyleRule TEXT = new BaseStringRule("-swing-text");

	public static final StyleRule H_ALIGN = new BaseKeywordRule("-swing-horizontalalignment", "leading", "trailing", "left", "right", "center");
	public static final StyleRule V_ALIGN = new BaseKeywordRule("-swing-verticalalignment", "top", "bottom", "center");

	public static final StyleRule MARGIN = new BaseRule("-swing-margin") {
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
	};

	public static final StyleRule FONT = new BaseRule("-swing-font") {
		@Override public Class[][] getParams() {return new Class[][] {
			{String.class, String.class, Integer.class},
			{Font.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"name", "style", "size"},
			{"font"}
		};}

		@Override
		public boolean canBeNull(int paramsId, int paramId) {
			return false;
		}

		@Override public String[] getKeywords(int paramsId, int paramId) {
			if (paramId == 1) return new String[] {"plain", "italic", "bold"};
			return null;
		}
	};


	public static final StyleRule ICON = new BaseRule("-swing-icon") {
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
	};


	public static final StyleRule BORDER = new BaseRule("-swing-border") {
		@Override public Class[][] getParams() {return new Class[][] {
			{Border.class}
		};}

		@Override public String[][] getParamsNames() {return new String[][] {
			{"border"}
		};}

		@Override public boolean canBeNull(int paramsId, int paramId) {
			return true;
		}
	};
}
