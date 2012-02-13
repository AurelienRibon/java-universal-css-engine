package aurelienribon.ui.css.predefined;

import aurelienribon.ui.css.StyleAttributes;
import aurelienribon.ui.css.StyleProcessor;
import java.awt.Component;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingProcessor implements StyleProcessor {
	@Override
	public void process(Object target, StyleAttributes attrs) {
		if (target instanceof Component) {
			Component t = (Component) target;
			if (attrs.contains(SwingStyle.RULE_BACKGROUND)) t.setBackground(attrs.asColor(SwingStyle.RULE_BACKGROUND));
			if (attrs.contains(SwingStyle.RULE_FOREGROUND)) t.setForeground(attrs.asColor(SwingStyle.RULE_FOREGROUND));
			if (attrs.contains(SwingStyle.RULE_VISIBLE)) t.setVisible(attrs.asBoolean(SwingStyle.RULE_VISIBLE));
			if (attrs.contains(SwingStyle.RULE_ENABLED)) t.setEnabled(attrs.asBoolean(SwingStyle.RULE_ENABLED));
			if (attrs.contains(SwingStyle.RULE_FOCUSABLE)) t.setFocusable(attrs.asBoolean(SwingStyle.RULE_FOCUSABLE));
			if (attrs.contains(SwingStyle.RULE_FONT)) t.setFont(attrs.asFont(SwingStyle.RULE_FONT));
		}

		if (target instanceof JComponent) {
			JComponent t = (JComponent) target;
			if (attrs.contains(SwingStyle.RULE_OPAQUE)) t.setOpaque(attrs.asBoolean(SwingStyle.RULE_OPAQUE));
			if (attrs.contains(SwingStyle.RULE_TOOLTIP)) t.setToolTipText(attrs.asString(SwingStyle.RULE_TOOLTIP));
		}

		if (target instanceof AbstractButton) {
			AbstractButton t = (AbstractButton) target;
			if (attrs.contains(SwingStyle.RULE_MARGIN)) t.setMargin(attrs.asInsets(SwingStyle.RULE_MARGIN));
			if (attrs.contains(SwingStyle.RULE_H_ALIGN)) t.setHorizontalAlignment(attrs.asHAlign(SwingStyle.RULE_H_ALIGN));
			if (attrs.contains(SwingStyle.RULE_V_ALIGN)) t.setVerticalAlignment(attrs.asVAlign(SwingStyle.RULE_V_ALIGN));
		}

		if (target instanceof JLabel) {
			JLabel t = (JLabel) target;
			if (attrs.contains(SwingStyle.RULE_H_ALIGN)) t.setHorizontalAlignment(attrs.asHAlign(SwingStyle.RULE_H_ALIGN));
			if (attrs.contains(SwingStyle.RULE_V_ALIGN)) t.setVerticalAlignment(attrs.asVAlign(SwingStyle.RULE_V_ALIGN));
			if (attrs.contains(SwingStyle.RULE_TEXT)) t.setText(attrs.asString(SwingStyle.RULE_TEXT));
		}

		if (target instanceof JTextComponent) {
			JTextComponent t = (JTextComponent) target;
			if (attrs.contains(SwingStyle.RULE_CARETPOSITION)) t.setCaretPosition(attrs.asInteger(SwingStyle.RULE_CARETPOSITION));
			if (attrs.contains(SwingStyle.RULE_EDITABLE)) t.setEditable(attrs.asBoolean(SwingStyle.RULE_EDITABLE));
			if (attrs.contains(SwingStyle.RULE_MARGIN)) t.setMargin(attrs.asInsets(SwingStyle.RULE_MARGIN));
			if (attrs.contains(SwingStyle.RULE_TEXT)) t.setText(attrs.asString(SwingStyle.RULE_TEXT));
		}

		if (target instanceof JTextArea) {
			JTextArea t = (JTextArea) target;
			if (attrs.contains(SwingStyle.RULE_LINEWRAP)) t.setLineWrap(attrs.asBoolean(SwingStyle.RULE_LINEWRAP));
			if (attrs.contains(SwingStyle.RULE_WRAPSTYLEWORD)) t.setWrapStyleWord(attrs.asBoolean(SwingStyle.RULE_WRAPSTYLEWORD));
			if (attrs.contains(SwingStyle.RULE_TABSIZE)) t.setTabSize(attrs.asInteger(SwingStyle.RULE_TABSIZE));
		}
	}
}
