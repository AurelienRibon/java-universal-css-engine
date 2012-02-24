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
	public static final Property BACKGROUND = new SingleParamRule("-swing-background", Color.class, "color");
	public static final Property FOREGROUND = new SingleParamRule("-swing-foreground", Color.class, "color");

	public static final Property VISIBLE = new SingleParamRule("-swing-visible", Boolean.class, "b");
	public static final Property ENABLED = new SingleParamRule("-swing-enabled", Boolean.class, "b");
	public static final Property FOCUSABLE = new SingleParamRule("-swing-focusable", Boolean.class, "b");
	public static final Property OPAQUE = new SingleParamRule("-swing-opaque", Boolean.class, "b");
	public static final Property EDITABLE = new SingleParamRule("-swing-editable", Boolean.class, "b");
	public static final Property LINEWRAP = new SingleParamRule("-swing-linewrap", Boolean.class, "b");
	public static final Property WRAPSTYLEWORD = new SingleParamRule("-swing-wrapstyleword", Boolean.class, "b");

	public static final Property TABSIZE = new SingleParamRule("-swing-tabsize", Integer.class, "size");
	public static final Property CARETPOSITION = new SingleParamRule("-swing-caretposition", Integer.class, "pos");

	public static final Property TOOLTIP = new SingleParamRule("-swing-tooltiptext", String.class, "tooltip");
	public static final Property TEXT = new SingleParamRule("-swing-text", String.class, "text");
	public static final Property H_ALIGN = new SingleParamRule("-swing-horizontalalignment", String.class, "halign");
	public static final Property V_ALIGN = new SingleParamRule("-swing-verticalalignment", String.class, "valign");

	public static final Property BORDER = new SingleParamRule("-swing-border", Border.class, "border");

	public static final Property MARGIN = new FunctionRule("-swing-margin", SwingFunctions.insets, "insets");
	public static final Property FONT = new FunctionRule("-swing-font", SwingFunctions.font, "font");
	public static final Property ICON = new FunctionRule("-swing-icon", SwingFunctions.icon, "icon");
}
