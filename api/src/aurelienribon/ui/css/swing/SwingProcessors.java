package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.StyleRuleSet;
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
public class SwingProcessors {
	public static final StyleProcessor COMPONENT = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof Component) {
				Component t = (Component) target;
				if (rs.contains(SwingRules.BACKGROUND)) t.setBackground(SwingUtils.asColor(rs, SwingRules.BACKGROUND, 0));
				if (rs.contains(SwingRules.FOREGROUND)) t.setForeground(SwingUtils.asColor(rs, SwingRules.FOREGROUND, 0));
				if (rs.contains(SwingRules.VISIBLE)) t.setVisible(rs.asBoolean(SwingRules.VISIBLE, 0));
				if (rs.contains(SwingRules.ENABLED)) t.setEnabled(rs.asBoolean(SwingRules.ENABLED, 0));
				if (rs.contains(SwingRules.FOCUSABLE)) t.setFocusable(rs.asBoolean(SwingRules.FOCUSABLE, 0));
				if (rs.contains(SwingRules.FONT)) t.setFont(SwingUtils.asFont(rs, SwingRules.FONT));
			}
		}
	};

	public static final StyleProcessor JCOMPONENT = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof JComponent) {
				JComponent t = (JComponent) target;
				if (rs.contains(SwingRules.OPAQUE)) t.setOpaque(rs.asBoolean(SwingRules.OPAQUE, 0));
				if (rs.contains(SwingRules.TOOLTIP)) t.setToolTipText(rs.asString(SwingRules.TOOLTIP, 0));
				if (rs.contains(SwingRules.BORDER)) t.setBorder(SwingUtils.asBorder(rs, SwingRules.BORDER, 0));
			}
		}
	};

	public static final StyleProcessor ABSTRACTBUTTON = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof AbstractButton) {
				AbstractButton t = (AbstractButton) target;
				if (rs.contains(SwingRules.MARGIN)) t.setMargin(SwingUtils.asInsets(rs, SwingRules.MARGIN));
				if (rs.contains(SwingRules.H_ALIGN)) t.setHorizontalAlignment(SwingUtils.asHAlign(rs, SwingRules.H_ALIGN, 0));
				if (rs.contains(SwingRules.V_ALIGN)) t.setVerticalAlignment(SwingUtils.asVAlign(rs, SwingRules.V_ALIGN, 0));
				if (rs.contains(SwingRules.TEXT)) t.setText(rs.asString(SwingRules.TEXT, 0));
				if (rs.contains(SwingRules.ICON)) t.setIcon(SwingUtils.asIcon(rs, SwingRules.ICON, 0));
			}
		}
	};

	public static final StyleProcessor JLABEL = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof JLabel) {
				JLabel t = (JLabel) target;
				if (rs.contains(SwingRules.H_ALIGN)) t.setHorizontalAlignment(SwingUtils.asHAlign(rs, SwingRules.H_ALIGN, 0));
				if (rs.contains(SwingRules.V_ALIGN)) t.setVerticalAlignment(SwingUtils.asVAlign(rs, SwingRules.V_ALIGN, 0));
				if (rs.contains(SwingRules.TEXT)) t.setText(rs.asString(SwingRules.TEXT, 0));
				if (rs.contains(SwingRules.ICON)) t.setIcon(SwingUtils.asIcon(rs, SwingRules.ICON, 0));
			}
		}
	};

	public static final StyleProcessor JTEXTCOMPONENT = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof JTextComponent) {
				JTextComponent t = (JTextComponent) target;
				if (rs.contains(SwingRules.CARETPOSITION)) t.setCaretPosition(rs.asInteger(SwingRules.CARETPOSITION, 0));
				if (rs.contains(SwingRules.EDITABLE)) t.setEditable(rs.asBoolean(SwingRules.EDITABLE, 0));
				if (rs.contains(SwingRules.MARGIN)) t.setMargin(SwingUtils.asInsets(rs, SwingRules.MARGIN));
				if (rs.contains(SwingRules.TEXT)) t.setText(rs.asString(SwingRules.TEXT, 0));
			}
		}
	};

	public static final StyleProcessor JTEXTAREA = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof JTextArea) {
				JTextArea t = (JTextArea) target;
				if (rs.contains(SwingRules.LINEWRAP)) t.setLineWrap(rs.asBoolean(SwingRules.LINEWRAP, 0));
				if (rs.contains(SwingRules.WRAPSTYLEWORD)) t.setWrapStyleWord(rs.asBoolean(SwingRules.WRAPSTYLEWORD, 0));
				if (rs.contains(SwingRules.TABSIZE)) t.setTabSize(rs.asInteger(SwingRules.TABSIZE, 0));
			}
		}
	};
}
