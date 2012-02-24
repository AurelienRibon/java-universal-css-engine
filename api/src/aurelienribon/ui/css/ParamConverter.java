package aurelienribon.ui.css;

/**
 * Some definitions in a CSS stylesheet may correspond to some objects that
 * are not defined. This is the case for color definitions, like "#FFF", which
 * need to be assigned to a color object. However, since the CSS engine is not
 * bound to any UI technology, it will ask you to create a color object from
 * every color definition, according to your framework.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface ParamConverter {
	/**
	 * Creates an object representing a color from a color definition (rgba).
	 */
	public Object convertColor(int r, int g, int b, int a);
}
