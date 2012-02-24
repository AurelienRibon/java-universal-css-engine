package aurelienribon.ui.components;

import aurelienribon.ui.css.StyleRule;
import aurelienribon.ui.css.primitives.SingleParamRule;
import java.awt.Color;
import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiRules {
	public static final StyleRule FOREGROUND_MOUSEOVER = new SingleParamRule("-arui-foreground-mouseover", Color.class, "color");
	public static final StyleRule FOREGROUND_MOUSEDOWN = new SingleParamRule("-arui-foreground-mousedown", Color.class, "color");
	public static final StyleRule FOREGROUND_SELECTED = new SingleParamRule("-arui-foreground-selected", Color.class, "color");
	public static final StyleRule FOREGROUND_UNSELECTED = new SingleParamRule("-arui-foreground-unselected", Color.class, "color");
	public static final StyleRule STROKE = new SingleParamRule("-arui-stroke", Color.class, "color");
	public static final StyleRule STROKE_MOUSEOVER = new SingleParamRule("-arui-stroke-mouseover", Color.class, "color");
	public static final StyleRule STROKE_MOUSEDOWN = new SingleParamRule("-arui-stroke-mousedown", Color.class, "color");
	public static final StyleRule STROKE_SELECTED = new SingleParamRule("-arui-stroke-selected", Color.class, "color");
	public static final StyleRule STROKE_UNSELECTED = new SingleParamRule("-arui-stroke-unselected", Color.class, "color");

	public static final StyleRule FILL = new SingleParamRule("-arui-fill", Paint.class, "paint");
	public static final StyleRule FILL_MOUSEOVER = new SingleParamRule("-arui-fill-mouseover", Paint.class, "paint");
	public static final StyleRule FILL_MOUSEDOWN = new SingleParamRule("-arui-fill-mousedown", Paint.class, "paint");
	public static final StyleRule FILL_SELECTED = new SingleParamRule("-arui-fill-selected", Paint.class, "paint");
	public static final StyleRule FILL_UNSELECTED = new SingleParamRule("-arui-fill-unselected", Paint.class, "paint");

	public static final StyleRule CORNERRADIUS = new SingleParamRule("-arui-cornerradius", Integer.class, "radius");
}
