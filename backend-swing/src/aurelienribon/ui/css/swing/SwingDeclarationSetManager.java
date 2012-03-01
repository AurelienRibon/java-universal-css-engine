package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.PseudoClass;
import aurelienribon.ui.css.DeclarationSetManager;
import aurelienribon.ui.css.Style;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingDeclarationSetManager implements DeclarationSetManager<Component> {
	@Override
	public void manage(Component target, Map<PseudoClass, DeclarationSet> dss) {
		DeclarationSet normalDS = dss.get(PseudoClass.NONE);
		DeclarationSet hoverDS = dss.get(PseudoClass.HOVER);
		DeclarationSet activeDS = dss.get(PseudoClass.ACTIVE);
		DeclarationSet focusDS = dss.get(PseudoClass.FOCUS);
		DeclarationSet disabledDS = dss.get(PseudoClass.DISABLED);

		for (int i=target.getMouseListeners().length-1; i>=0; i--) {
			MouseListener ml = target.getMouseListeners()[i];
			if (ml instanceof TargetManager.MouseListener) target.removeMouseListener(ml);
		}

		for (int i=target.getFocusListeners().length-1; i>=0; i--) {
			FocusListener fl = target.getFocusListeners()[i];
			if (fl instanceof TargetManager.FocusListener) target.removeFocusListener(fl);
		}

		if (!hoverDS.isEmpty() || !activeDS.isEmpty() || !focusDS.isEmpty() || !disabledDS.isEmpty()) {
			TargetManager manager = new TargetManager(target, normalDS, hoverDS, activeDS, focusDS, disabledDS);

			if (!hoverDS.isEmpty() || !activeDS.isEmpty()) {
				target.addMouseListener(manager.mouseListener);
			}

			if (!focusDS.isEmpty()) {
				target.addFocusListener(manager.focusListener);
			}
		}

		Style.apply(target, normalDS);
	}

	private class TargetManager {
		private final Component target;
		private final DeclarationSet normalDS;
		private final DeclarationSet hoverDS;
		private final DeclarationSet activeDS;
		private final DeclarationSet focusDS;
		private final DeclarationSet disabledDS;
		private final MouseListener mouseListener = new MouseListener();
		private final FocusListener focusListener = new FocusListener();
		private boolean isOver = false;
		private boolean isPressed = false;
		private boolean isFocused;
		private boolean isDisabled;

		public TargetManager(Component target, DeclarationSet normalDS, DeclarationSet hoverDS, DeclarationSet activeDS, DeclarationSet focusDS, DeclarationSet disabledDS) {
			this.target = target;
			this.normalDS = normalDS;
			this.hoverDS = hoverDS;
			this.activeDS = activeDS;
			this.focusDS = focusDS;
			this.disabledDS = disabledDS;
			this.isFocused = target.isFocusOwner();
			this.isDisabled = !target.isEnabled();
		}

		private void apply() {
			Style.apply(target, normalDS);

			if (isDisabled) {
				Style.apply(target, disabledDS);
			} else {
				if (isFocused) Style.apply(target, focusDS);
				if (isOver) Style.apply(target, hoverDS);
				if (isPressed) Style.apply(target, activeDS);
			}
		}

		public class MouseListener extends MouseAdapter {
			@Override public void mouseEntered(MouseEvent e) {isOver = true; apply();}
			@Override public void mouseExited(MouseEvent e) {isOver = false; apply();}
			@Override public void mousePressed(MouseEvent e) {isPressed = true; apply();}
			@Override public void mouseReleased(MouseEvent e) {isPressed = false; apply();}
		}

		public class FocusListener extends FocusAdapter {
			@Override public void focusGained(FocusEvent e) {isFocused = true; apply();}
			@Override public void focusLost(FocusEvent e) {isFocused = false; apply();}
		}

		public class PropertyChangeListener implements java.beans.PropertyChangeListener {
			@Override public void propertyChange(PropertyChangeEvent e) {
				if (e.getPropertyName().equals("enabled")) {isDisabled = !((Boolean)e.getNewValue()); apply();}
			}
		}
	}
}
