package aurelienribon.ui.css;

import java.util.*;

/**
 * A declaration set defines a group of declarations. In CSS, a declaration is
 * a property associated to a value (one or more parameters). Declaration sets
 * are mainly used in two ways:
 * <p/>
 * 1. To group every declarations associated to a rule in a CSS stylesheet.
 * 2. To group every declarations that are part of rules which selectors
 * correspond to a target object, when a style is applied to this target object.
 * <p/>
 * See <a href="http://www.w3schools.com/css/css_syntax.asp">w3schools</a> for
 * more information about CSS syntax.
 *
 * @see Property
 * @see Rule
 * @see Style
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class DeclarationSet {
	private final List<Property> properties;
	private final Map<Property, List<Object>> propertiesValues;

	/**
	 * Constructor used to group every declarations associated to a rule in a
	 * CSS stylesheet.
	 * @param properties A list of properties.
	 * @param propertiesValues A map of values associated to the properties.
	 */
	public DeclarationSet(List<Property> properties, Map<Property, List<Object>> propertiesValues) {
		this.properties = Collections.unmodifiableList(new ArrayList<Property>(properties));
		this.propertiesValues = Collections.unmodifiableMap(new HashMap<Property, List<Object>>(propertiesValues));
	}

	/**
	 * Constructor used to group every declarations that are part of rules which
	 * selectors correspond to a target object, when a style is applied to this
	 * target object.
	 * @param style The style applied to the target.
	 * @param target The target object.
	 * @param stack The stack of classnames for the target. Used to know if the
	 * target correspond to some nested selectors.
	 */
	public DeclarationSet(Style style, Object target, List<String> stack) {
		List<Property> tRules = new ArrayList<Property>();
		Map<Property, List<Object>> tRulesParams = new HashMap<Property, List<Object>>();

		for (Rule sc : style.getClasses()) {
			if (isLastSelectorValid(sc.getLastSelector(), target) && isStackValid(sc.getSelectors(), stack)) {
				tRules.addAll(sc.getRuleSet().getProperties());
				tRulesParams.putAll(sc.getRuleSet().getPropertiesValues());
			}
		}

		this.properties = Collections.unmodifiableList(tRules);
		this.propertiesValues = Collections.unmodifiableMap(tRulesParams);
	}

	/**
	 * Constructor used to build a new declaration set from an old one, by
	 * keeping only the declarations corresponding to the given properties.
	 * @param ds A declaration set.
	 * @param propertiesToKeep An array of the properties to keep.
	 */
	public DeclarationSet(DeclarationSet ds, Property[] propertiesToKeep) {
		List<Property> tRules = new ArrayList<Property>();
		Map<Property, List<Object>> tRulesParams = new HashMap<Property, List<Object>>();

		for (Property rule : propertiesToKeep) {
			if (ds.getProperties().contains(rule)) {
				tRules.add(rule);
				tRulesParams.put(rule, ds.getValue(rule));
			}
		}

		this.properties = Collections.unmodifiableList(new ArrayList<Property>(tRules));
		this.propertiesValues = Collections.unmodifiableMap(new HashMap<Property, List<Object>>(tRulesParams));
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Gets the list of every properties contained in this set.
	 */
	public List<Property> getProperties() {
		return properties;
	}

	/**
	 * Gets the map of the values associated to the properties contained in this
	 * declaration set.
	 */
	public Map<Property, List<Object>> getPropertiesValues() {
		return propertiesValues;
	}

	/**
	 * Gets the value (a list of one or more parameters) associated to the
	 * given property.
	 */
	public List<Object> getValue(Property property) {
		return propertiesValues.get(property);
	}

	/**
	 * Returns true of the declaration set contains a declaration with the
	 * given property.
	 */
	public boolean contains(Property property) {
		return properties.contains(property);
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private boolean isLastSelectorValid(String selector, Object target) {
		if (selector.startsWith(".")) {
			String className = Style.getRegisteredTargetClassName(target);
			return className != null && className.equals(selector);

		} else {
			try {
				Class clazz = Class.forName(selector.replaceAll("-", "."));
				return clazz.isInstance(target);

			} catch (ClassNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private boolean isStackValid(List<String> selectors, List<String> stack) {
		if (selectors.size() == 1) return true;

		for (int i=0; i<selectors.size()-1; i++) {
			int idx = stack.indexOf(selectors.get(i));
			if (idx == -1) return false;
		}

		for (int i=1; i<selectors.size()-1; i++) {
			int idx1 = stack.indexOf(selectors.get(i-1));
			int idx2 = stack.lastIndexOf(selectors.get(i));
			if (idx1 >= idx2) return false;
		}

		return true;
	}
}
