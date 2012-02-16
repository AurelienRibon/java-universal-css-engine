package aurelienribon.ui.css;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StyleClass {
	private final List<String> selectors;
	private final StyleRuleSet ruleSet;

	public StyleClass(String selectors, StyleRuleSet ruleSet) {
		this.selectors = Collections.unmodifiableList(Arrays.asList(selectors.split(" ")));
		this.ruleSet = ruleSet;
	}

	public List<String> getSelectors() {
		return selectors;
	}

	public String getLastSelector() {
		return selectors.get(selectors.size()-1);
	}

	public StyleRuleSet getRuleSet() {
		return ruleSet;
	}
}
