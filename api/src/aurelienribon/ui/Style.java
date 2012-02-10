package aurelienribon.ui;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Style {
	// -------------------------------------------------------------------------
	// Static API
	// -------------------------------------------------------------------------

	private static final Map<Class, StyleAccessor> accessors = new HashMap<Class, StyleAccessor>();
	private static final Map<Object, String> classNames = new HashMap<Object, String>();

	static {
		register(Component.class, new StyleAccessor<Component>() {
			@Override public void applyStyle(Component target, StyleAttributes attrs) {
				target.setBackground(attrs.getColor("-swing-background", target.getBackground()));
				target.setForeground(attrs.getColor("-swing-foreground", target.getForeground()));
				target.setVisible(attrs.getBoolean("-swing-visible", target.isVisible()));
				target.setEnabled(attrs.getBoolean("-swing-enabled", target.isEnabled()));
				target.setFocusable(attrs.getBoolean("-swing-focusable", target.isFocusable()));
				target.setFont(attrs.getFont("-swing-font", target.getFont()));
			}
		});

		register(JComponent.class, new StyleAccessor<JComponent>() {
			@Override public void applyStyle(JComponent target, StyleAttributes attrs) {
				target.setOpaque(attrs.getBoolean("-swing-opaque", target.isOpaque()));
				target.setToolTipText(attrs.getText("-swing-tooltiptext", target.getToolTipText()));
			}
		});

		register(AbstractButton.class, new StyleAccessor<AbstractButton>() {
			@Override public void applyStyle(AbstractButton target, StyleAttributes attrs) {
				target.setMargin(attrs.getMargin("-swing-margin", target.getMargin()));
				target.setHorizontalAlignment(attrs.getHAlign("-swing-horizontalalignment", target.getHorizontalAlignment()));
				target.setVerticalAlignment(attrs.getVAlign("-swing-verticalalignment", target.getVerticalAlignment()));
			}
		});

		register(JLabel.class, new StyleAccessor<JLabel>() {
			@Override public void applyStyle(JLabel target, StyleAttributes attrs) {
				target.setHorizontalAlignment(attrs.getHAlign("-swing-horizontalalignment", target.getHorizontalAlignment()));
				target.setVerticalAlignment(attrs.getVAlign("-swing-verticalalignment", target.getVerticalAlignment()));
				target.setText(attrs.getText("-swing-text", target.getText()));
			}
		});

		register(JTextComponent.class, new StyleAccessor<JTextComponent>() {
			@Override public void applyStyle(JTextComponent target, StyleAttributes attrs) {
				target.setCaretPosition(attrs.getInt("-swing-caretposition", target.getCaretPosition()));
				target.setEditable(attrs.getBoolean("-swing-editable", target.isEditable()));
				target.setMargin(attrs.getMargin("-swing-margin", target.getMargin()));
				String text = attrs.getText("-swing-text", null); if (text != null) target.setText(text);
			}
		});

		register(JTextArea.class, new StyleAccessor<JTextArea>() {
			@Override public void applyStyle(JTextArea target, StyleAttributes attrs) {
				target.setLineWrap(attrs.getBoolean("-swing-linewrap", target.getLineWrap()));
				target.setWrapStyleWord(attrs.getBoolean("-swing-wrapstyleword", target.getWrapStyleWord()));
				target.setTabSize(attrs.getInt("-swing-tabsize", target.getTabSize()));
			}
		});
	}

	public static void register(Class targetClass, StyleAccessor accessor) {
		accessors.put(targetClass, accessor);
	}

	public static void registerClassName(Object target, String className) {
		classNames.put(target, "." + className);
	}

	public static void forget(Object target) {
		classNames.remove(target);
	}

	public static void apply(Object target, Style style) {
		apply(target, style, new ArrayList<String>());
	}

	public static void apply(Object target, StyleAttributes attrs) {
		for (Class c : accessors.keySet()) {
			if (c.isInstance(target)) {
				StyleAccessor accessor = accessors.get(c);
				accessor.applyStyle(target, attrs);
			}
		}
	}

	// -------------------------------------------------------------------------
	// Attrs + ctors
	// -------------------------------------------------------------------------

	private final String styleSheet;
	private final Map<String, Map<String, String>> propertiesMap = new LinkedHashMap<String, Map<String, String>>();

	public Style(URL styleSheetUrl) {
		this.styleSheet = getStyleSheet(styleSheetUrl);
		parse(styleSheet);
	}

	public Style(String styleSheet) {
		this.styleSheet = styleSheet;
		parse(styleSheet);
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	public String getStyleSheet() {
		return styleSheet;
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private String getStyleSheet(URL styleSheetUrl) {
		if (styleSheetUrl == null) throw new NullPointerException("styleSheetUrl");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(styleSheetUrl.openStream()));
			StringBuilder sb = new StringBuilder();
			char[] buffer = new char[4096];
			int len;
			while ((len = reader.read(buffer)) > -1) sb.append(buffer, 0, len);
			return sb.toString();

		} catch (IOException ex) {
			return null;

		} finally {
			try {reader.close();
			} catch (IOException ex) {}
		}
	}

	private void parse(String styleSheet) {
		styleSheet = styleSheet.replaceAll("(?s)/\\*.*\\*/", "");
		Matcher selectorMatcher = Pattern.compile("^([^\\{]+)\\{([^\\}]*)}", Pattern.MULTILINE).matcher(styleSheet);

		while (selectorMatcher.find()) {
			String selectorKey = selectorMatcher.group(1).trim().replaceAll("\\s*,\\s*", ",").replaceAll("\\s+", " ");
			String[] selectors = selectorKey.split(",");

			for (String selector : selectors)
				if (!propertiesMap.containsKey(selector))
					propertiesMap.put(selector, new HashMap<String, String>());

			String selectorValue = selectorMatcher.group(2).trim();
			String[] lines = selectorValue.split("\n");
			Map<String, String> valuesMap = new LinkedHashMap<String, String>();

			for (String line : lines) {
				Matcher propertyMatcher = Pattern.compile("([^:]+):(.*);").matcher(line.trim());

				while (propertyMatcher.find()) {
					String key = propertyMatcher.group(1).trim();
					String value = propertyMatcher.group(2).trim();
					valuesMap.put(key, value);
				}
			}

			for (String selector : selectors)
				propertiesMap.get(selector).putAll(valuesMap);
		}
	}

	private static void apply(Object target, Style style, List<String> stack) {
		StyleAttributes attrs = buildAttributes(target, style, stack);
		if (attrs != null) apply(target, attrs);

		stack.add(target.getClass().getName());
		if (classNames.containsKey(target)) stack.add(classNames.get(target));

		if (target instanceof Container) {
			Container cnt = (Container) target;
			for (Component child : cnt.getComponents()) apply(child, style, stack);
		}
	}

	private static StyleAttributes buildAttributes(Object target, Style style, List<String> stack) {
		Map<String, String> attrs = new HashMap<String, String>();

		for (String selector : style.propertiesMap.keySet()) {
			String[] selectors = selector.split(" ");

			if (isLastSelectorValid(selectors, target) && isStackValid(selectors, stack)) {
				attrs.putAll(style.propertiesMap.get(selector));
			}
		}

		return attrs.isEmpty() ? null : new StyleAttributes(style, attrs);
	}

	private static boolean isLastSelectorValid(String[] selectors, Object target) {
		String lastSelector = selectors[selectors.length-1];

		if (lastSelector.startsWith(".")) {
			String className = classNames.get(target);
			return className != null && className.equals(lastSelector);

		} else {
			try {
				Class clazz = Class.forName(lastSelector.replaceAll("-", "."));
				return clazz.isInstance(target);

			} catch (ClassNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private static boolean isStackValid(String[] selectors, List<String> stack) {
		if (selectors.length == 1) return true;
		int[] idxs = new int[selectors.length-1];
		for (int i=0; i<selectors.length-1; i++) idxs[i] = stack.indexOf(selectors[i]);
		for (int i=0; i<selectors.length-1; i++) if (idxs[i] == -1) return false;
		for (int i=1; i<selectors.length-1; i++) if (idxs[i-1] > idxs[i]) return false;
		return true;
	}
}
