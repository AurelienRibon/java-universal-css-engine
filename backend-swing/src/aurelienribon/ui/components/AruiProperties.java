package aurelienribon.ui.components;

import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.primitives.SingleParamRule;
import java.awt.Color;
import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiProperties {
	public static final Property foregroundMouseOver = new SingleParamRule("-arui-foreground-mouseover", Color.class, "color");
	public static final Property foregroundMouseDown = new SingleParamRule("-arui-foreground-mousedown", Color.class, "color");
	public static final Property foregroundSelected = new SingleParamRule("-arui-foreground-selected", Color.class, "color");
	public static final Property foregroundUnselected = new SingleParamRule("-arui-foreground-unselected", Color.class, "color");
	public static final Property stroke = new SingleParamRule("-arui-stroke", Color.class, "color");
	public static final Property strokeMouseOver = new SingleParamRule("-arui-stroke-mouseover", Color.class, "color");
	public static final Property strokeMouseDown = new SingleParamRule("-arui-stroke-mousedown", Color.class, "color");
	public static final Property strokeSelected = new SingleParamRule("-arui-stroke-selected", Color.class, "color");
	public static final Property strokeUnselected = new SingleParamRule("-arui-stroke-unselected", Color.class, "color");

	public static final Property fill = new SingleParamRule("-arui-fill", Paint.class, "paint");
	public static final Property fillMouseOver = new SingleParamRule("-arui-fill-mouseover", Paint.class, "paint");
	public static final Property fillMouseDown = new SingleParamRule("-arui-fill-mousedown", Paint.class, "paint");
	public static final Property fillSelected = new SingleParamRule("-arui-fill-selected", Paint.class, "paint");
	public static final Property fillUnselected = new SingleParamRule("-arui-fill-unselected", Paint.class, "paint");

	public static final Property corderRadius = new SingleParamRule("-arui-cornerradius", Integer.class, "radius");
}
