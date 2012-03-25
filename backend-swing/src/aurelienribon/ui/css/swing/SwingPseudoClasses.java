package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.PseudoClass;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface SwingPseudoClasses {
	public static final PseudoClass hover = new PseudoClass(":hover");
	public static final PseudoClass active = new PseudoClass(":active");
	public static final PseudoClass focus = new PseudoClass(":focus");
	public static final PseudoClass disabled = new PseudoClass(":disabled");
}
