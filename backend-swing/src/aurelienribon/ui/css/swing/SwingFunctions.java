package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.StyleFunction;
import aurelienribon.ui.css.swing.functions.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingFunctions {
	// General
	public static StyleFunction font = new FontFunction();
	public static StyleFunction icon = new IconFunction();
	public static StyleFunction insets = new InsetsFunction();
	public static StyleFunction url = new UrlFunction();

	// Colors + paints
	public static StyleFunction rgb = new RgbFunction();
	public static StyleFunction rgba = new RgbaFunction();
	public static StyleFunction linearGradient = new LinearGradientFunction();

	// Borders
	public static StyleFunction bevelBorder = new BevelBorderFunction();
	public static StyleFunction compoundBorder = new CompoundBorderFunction();
	public static StyleFunction dashedBorder = new DashedBorderFunction();
	public static StyleFunction emptyBorder = new EmptyBorderFunction();
	public static StyleFunction etchedBorder = new EtchedBorderFunction();
	public static StyleFunction lineBorder = new LineBorderFunction();
	public static StyleFunction matteBorder = new MatteBorderFunction();
	public static StyleFunction titledBorder = new TitledBorderFunction();
}
