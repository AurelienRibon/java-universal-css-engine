package aurelienribon.ui.components;

import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.primitives.FunctionProperty;
import aurelienribon.ui.css.primitives.SingleParamProperty;
import aurelienribon.ui.css.swing.SwingFunctions;
import java.awt.Color;
import java.awt.Paint;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AruiProperties {
	public static final Property foregroundMouseOver = new SingleParamProperty("-arui-foreground-mouseover", Color.class, "color");
	public static final Property foregroundMouseDown = new SingleParamProperty("-arui-foreground-mousedown", Color.class, "color");
	public static final Property foregroundSelected = new SingleParamProperty("-arui-foreground-selected", Color.class, "color");
	public static final Property foregroundUnselected = new SingleParamProperty("-arui-foreground-unselected", Color.class, "color");
	public static final Property stroke = new SingleParamProperty("-arui-stroke", Paint.class, "paint");
	public static final Property strokeMouseOver = new SingleParamProperty("-arui-stroke-mouseover", Paint.class, "paint");
	public static final Property strokeMouseDown = new SingleParamProperty("-arui-stroke-mousedown", Paint.class, "paint");
	public static final Property strokeSelected = new SingleParamProperty("-arui-stroke-selected", Paint.class, "paint");
	public static final Property strokeUnselected = new SingleParamProperty("-arui-stroke-unselected", Paint.class, "paint");

	public static final Property fill = new SingleParamProperty("-arui-fill", Paint.class, "paint");
	public static final Property fillMouseOver = new SingleParamProperty("-arui-fill-mouseover", Paint.class, "paint");
	public static final Property fillMouseDown = new SingleParamProperty("-arui-fill-mousedown", Paint.class, "paint");
	public static final Property fillSelected = new SingleParamProperty("-arui-fill-selected", Paint.class, "paint");
	public static final Property fillUnselected = new SingleParamProperty("-arui-fill-unselected", Paint.class, "paint");

	public static final Property strokeThickness = new SingleParamProperty("-arui-strokethickness", Integer.class, "thickness");
	public static final Property corderRadius = new SingleParamProperty("-arui-cornerradius", Integer.class, "radius");

	public static final Property borderStroke = new SingleParamProperty("-arui-border-stroke", Paint.class, "stroke");
	public static final Property borderThickness = new FunctionProperty("-arui-border-thickness", SwingFunctions.insets, "thickness");
	public static final Property borderHeaderStroke = new SingleParamProperty("-arui-border-header-stroke", Paint.class, "stroke");
	public static final Property borderHeaderThickness = new FunctionProperty("-arui-border-header-thickness", SwingFunctions.insets, "thickness");
	public static final Property borderHeaderFill = new SingleParamProperty("-arui-border-header-fill", Paint.class, "paint");
	public static final Property borderTitle = new SingleParamProperty("-arui-border-title", String.class, "text");
	public static final Property borderIcon = new FunctionProperty("-arui-border-icon", SwingFunctions.icon, "icon");
	public static final Property borderFont = new FunctionProperty("-arui-border-font", SwingFunctions.font, "font");
	public static final Property borderForeground = new SingleParamProperty("-arui-border-foreground", Color.class, "color");
	public static final Property borderMargin = new FunctionProperty("-arui-border-margin", SwingFunctions.insets, "insets");
}
