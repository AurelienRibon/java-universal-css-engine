package aurelienribon.ui.css;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A rule defines
 * <p/>
 * See <a href="http://www.w3schools.com/css/css_syntax.asp">w3schools</a> for
 * more information about CSS syntax.
 *
 * @see Property
 * @see DeclarationSet
 * @see Style
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Rule {
	private final List<String> selectors;
	private final DeclarationSet ruleSet;

	public Rule(String selectors, DeclarationSet ruleSet) {
		this.selectors = Collections.unmodifiableList(Arrays.asList(selectors.split(" ")));
		this.ruleSet = ruleSet;
	}

	public List<String> getSelectors() {
		return selectors;
	}

	public String getLastSelector() {
		return selectors.get(selectors.size()-1);
	}

	public DeclarationSet getRuleSet() {
		return ruleSet;
	}
}
