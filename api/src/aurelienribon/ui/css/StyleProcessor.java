package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleProcessor<T> {
	public void process(T target, DeclarationSet rules);
}
