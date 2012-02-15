package aurelienribon.ui.css;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface StyleRule {
	public String getName();
	public Class[][] getParams();
	public boolean canBeNull(int paramsId, int paramId);
	public String[] getKeywords(int paramsId, int paramId);
}
