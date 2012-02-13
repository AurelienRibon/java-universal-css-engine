package aurelienribon.ui.css;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class StyleClass {
	private final List<String> selectors;
	private final Map<String, List<Object>> rules;
	
	public StyleClass(String selectors, Map<String, List<Object>> rules) {
		this.selectors = Collections.unmodifiableList(Arrays.asList(selectors.split(" ")));
		this.rules = Collections.unmodifiableMap(rules);
	}

	public List<String> getSelectors() {
		return selectors;
	}
	
	public String getLastSelector() {
		return selectors.get(selectors.size()-1);
	}

	public Map<String, List<Object>> getRules() {
		return rules;
	}
	
	public List<Object> getRule(String name) {
		return rules.get(name);
	}
}
