package aurelienribon.ui.css;

import java.util.List;

/**
 * A function, or a "functional notation", is used to produce a value for a
 * parameter of a declaration value. It takes one or more parameters (which
 * can be functions too), processes them and returns an object.
 * <p/>
 * See <a href="http://www.w3.org/TR/css3-values/#functional-notation">w3.org
 * </a> for more information about functional notations.
 *
 * @see Property
 * @see Style
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface Function extends Property {
	/**
	 * Gets the class of the returned object.
	 */
	public Class getReturn();

	/**
	 * Processes the given parameters and returns an object.
	 */
	public Object process(List<Object> params);
}
