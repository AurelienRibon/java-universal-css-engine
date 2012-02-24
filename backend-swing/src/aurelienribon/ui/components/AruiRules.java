package aurelienribon.ui.components;

import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.primitives.SingleParamRule;
import java.awt.Color;
import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiRules {
	public static final Property FOREGROUND_MOUSEOVER = new SingleParamRule("-arui-foreground-mouseover", Color.class, "color");
	public static final Property FOREGROUND_MOUSEDOWN = new SingleParamRule("-arui-foreground-mousedown", Color.class, "color");
	public static final Property FOREGROUND_SELECTED = new SingleParamRule("-arui-foreground-selected", Color.class, "color");
	public static final Property FOREGROUND_UNSELECTED = new SingleParamRule("-arui-foreground-unselected", Color.class, "color");
	public static final Property STROKE = new SingleParamRule("-arui-stroke", Color.class, "color");
	public static final Property STROKE_MOUSEOVER = new SingleParamRule("-arui-stroke-mouseover", Color.class, "color");
	public static final Property STROKE_MOUSEDOWN = new SingleParamRule("-arui-stroke-mousedown", Color.class, "color");
	public static final Property STROKE_SELECTED = new SingleParamRule("-arui-stroke-selected", Color.class, "color");
	public static final Property STROKE_UNSELECTED = new SingleParamRule("-arui-stroke-unselected", Color.class, "color");

	public static final Property FILL = new SingleParamRule("-arui-fill", Paint.class, "paint");
	public static final Property FILL_MOUSEOVER = new SingleParamRule("-arui-fill-mouseover", Paint.class, "paint");
	public static final Property FILL_MOUSEDOWN = new SingleParamRule("-arui-fill-mousedown", Paint.class, "paint");
	public static final Property FILL_SELECTED = new SingleParamRule("-arui-fill-selected", Paint.class, "paint");
	public static final Property FILL_UNSELECTED = new SingleParamRule("-arui-fill-unselected", Paint.class, "paint");

	public static final Property CORNERRADIUS = new SingleParamRule("-arui-cornerradius", Integer.class, "radius");
}
