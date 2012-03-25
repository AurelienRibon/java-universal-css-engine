package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class PseudoClass {
	public static final PseudoClass none = new PseudoClass(":");

	private final String name;

	public PseudoClass(String name) {
		if (!name.startsWith(":")) throw new RuntimeException("A pseudo-class name have to start with ':'.");
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

