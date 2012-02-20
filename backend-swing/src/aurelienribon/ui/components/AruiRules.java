package aurelienribon.ui.components;

import aurelienribon.ui.css.BaseIntegerRule;
import aurelienribon.ui.css.StyleRule;
import aurelienribon.ui.css.swing.BaseColorRule;
import aurelienribon.ui.css.swing.BasePaintRule;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiRules {
	public static final StyleRule FOREGROUND_MOUSEOVER = new BaseColorRule("-arui-foreground-mouseover");
	public static final StyleRule FOREGROUND_MOUSEDOWN = new BaseColorRule("-arui-foreground-mousedown");
	public static final StyleRule FOREGROUND_SELECTED = new BaseColorRule("-arui-foreground-selected");
	public static final StyleRule STROKE = new BaseColorRule("-arui-stroke");
	public static final StyleRule STROKE_MOUSEOVER = new BaseColorRule("-arui-stroke-mouseover");
	public static final StyleRule STROKE_MOUSEDOWN = new BaseColorRule("-arui-stroke-mousedown");
	public static final StyleRule STROKE_SELECTED = new BaseColorRule("-arui-stroke-selected");
	public static final StyleRule FILL = new BasePaintRule("-arui-fill");
	public static final StyleRule FILL_MOUSEOVER = new BasePaintRule("-arui-fill-mouseover");
	public static final StyleRule FILL_MOUSEDOWN = new BasePaintRule("-arui-fill-mousedown");
	public static final StyleRule FILL_SELECTED = new BasePaintRule("-arui-fill-selected");
	public static final StyleRule CORNERRADIUS = new BaseIntegerRule("-arui-cornerradius");
}
