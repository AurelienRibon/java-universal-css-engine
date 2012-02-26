package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.*;
import aurelienribon.ui.css.primitives.FunctionRule;
import aurelienribon.ui.css.primitives.SingleParamRule;
import java.awt.Color;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingProperties {
	public static final Property background = new SingleParamRule("-swing-background", Color.class, "color");
	public static final Property foreground = new SingleParamRule("-swing-foreground", Color.class, "color");

	public static final Property visible = new SingleParamRule("-swing-visible", Boolean.class, "b");
	public static final Property enabled = new SingleParamRule("-swing-enabled", Boolean.class, "b");
	public static final Property focusable = new SingleParamRule("-swing-focusable", Boolean.class, "b");
	public static final Property opaque = new SingleParamRule("-swing-opaque", Boolean.class, "b");
	public static final Property editable = new SingleParamRule("-swing-editable", Boolean.class, "b");
	public static final Property lineWrap = new SingleParamRule("-swing-linewrap", Boolean.class, "b");
	public static final Property wrapStyleWord = new SingleParamRule("-swing-wrapstyleword", Boolean.class, "b");

	public static final Property tabSize = new SingleParamRule("-swing-tabsize", Integer.class, "size");
	public static final Property caretPosition = new SingleParamRule("-swing-caretposition", Integer.class, "pos");

	public static final Property tooltip = new SingleParamRule("-swing-tooltiptext", String.class, "tooltip");
	public static final Property text = new SingleParamRule("-swing-text", String.class, "text");
	public static final Property horizAlign = new SingleParamRule("-swing-horizontalalignment", String.class, "halign");
	public static final Property vertAlign = new SingleParamRule("-swing-verticalalignment", String.class, "valign");

	public static final Property border = new SingleParamRule("-swing-border", Border.class, "border");

	public static final Property margin = new FunctionRule("-swing-margin", SwingFunctions.insets, "insets");
	public static final Property font = new FunctionRule("-swing-font", SwingFunctions.font, "font");
	public static final Property icon = new FunctionRule("-swing-icon", SwingFunctions.icon, "icon");
}
