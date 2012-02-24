package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.*;
import aurelienribon.ui.css.primitives.FunctionRule;
import aurelienribon.ui.css.primitives.SingleParamRule;
import java.awt.Color;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingRules {
	public static final StyleRule BACKGROUND = new SingleParamRule("-swing-background", Color.class, "color");
	public static final StyleRule FOREGROUND = new SingleParamRule("-swing-foreground", Color.class, "color");

	public static final StyleRule VISIBLE = new SingleParamRule("-swing-visible", Boolean.class, "b");
	public static final StyleRule ENABLED = new SingleParamRule("-swing-enabled", Boolean.class, "b");
	public static final StyleRule FOCUSABLE = new SingleParamRule("-swing-focusable", Boolean.class, "b");
	public static final StyleRule OPAQUE = new SingleParamRule("-swing-opaque", Boolean.class, "b");
	public static final StyleRule EDITABLE = new SingleParamRule("-swing-editable", Boolean.class, "b");
	public static final StyleRule LINEWRAP = new SingleParamRule("-swing-linewrap", Boolean.class, "b");
	public static final StyleRule WRAPSTYLEWORD = new SingleParamRule("-swing-wrapstyleword", Boolean.class, "b");

	public static final StyleRule TABSIZE = new SingleParamRule("-swing-tabsize", Integer.class, "size");
	public static final StyleRule CARETPOSITION = new SingleParamRule("-swing-caretposition", Integer.class, "pos");

	public static final StyleRule TOOLTIP = new SingleParamRule("-swing-tooltiptext", String.class, "tooltip");
	public static final StyleRule TEXT = new SingleParamRule("-swing-text", String.class, "text");
	public static final StyleRule H_ALIGN = new SingleParamRule("-swing-horizontalalignment", String.class, "halign");
	public static final StyleRule V_ALIGN = new SingleParamRule("-swing-verticalalignment", String.class, "valign");

	public static final StyleRule BORDER = new SingleParamRule("-swing-border", Border.class, "border");

	public static final StyleRule MARGIN = new FunctionRule("-swing-margin", SwingFunctions.insets, "insets");
	public static final StyleRule FONT = new FunctionRule("-swing-font", SwingFunctions.font, "font");
	public static final StyleRule ICON = new FunctionRule("-swing-icon", SwingFunctions.icon, "icon");
}
