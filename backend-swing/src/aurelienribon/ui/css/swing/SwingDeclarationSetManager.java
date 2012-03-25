package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetManager;
import aurelienribon.ui.css.PseudoClass;
import aurelienribon.ui.css.Style;
import aurelienribon.ui.css.swing.SwingDeclarationSetManager.TargetManager.MyFocusListener;
import aurelienribon.ui.css.swing.SwingDeclarationSetManager.TargetManager.MyMouseListener;
import aurelienribon.ui.css.swing.SwingDeclarationSetManager.TargetManager.MyPropertyChangeListener;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SwingDeclarationSetManager implements DeclarationSetManager<Component> {
	@Override
	public void manage(Component target, Map<PseudoClass, DeclarationSet> dss) {
		DeclarationSet normalDS = dss.get(PseudoClass.none);
		DeclarationSet hoverDS = dss.get(SwingPseudoClasses.hover);
		DeclarationSet activeDS = dss.get(SwingPseudoClasses.active);
		DeclarationSet focusDS = dss.get(SwingPseudoClasses.focus);
		DeclarationSet disabledDS = dss.get(SwingPseudoClasses.disabled);

		clearListeners(target);

		if (!hoverDS.isEmpty() || !activeDS.isEmpty() || !focusDS.isEmpty() || !disabledDS.isEmpty()) {
			TargetManager tm = new TargetManager(target, normalDS, hoverDS, activeDS, focusDS, disabledDS);
			if (!hoverDS.isEmpty() || !activeDS.isEmpty()) target.addMouseListener(tm.mouseListener);
			if (!focusDS.isEmpty()) target.addFocusListener(tm.focusListener);
			if (!disabledDS.isEmpty()) target.addPropertyChangeListener(tm.propChangeListener);
			tm.apply();
		} else {
			Style.apply(target, normalDS);
		}
	}

	private void clearListeners(Component target) {
		for (int i=target.getMouseListeners().length-1; i>=0; i--) {
			MouseListener lst = target.getMouseListeners()[i];
			if (lst instanceof MyMouseListener) target.removeMouseListener(lst);
		}

		for (int i=target.getFocusListeners().length-1; i>=0; i--) {
			FocusListener lst = target.getFocusListeners()[i];
			if (lst instanceof MyFocusListener) target.removeFocusListener(lst);
		}

		for (int i=target.getPropertyChangeListeners().length-1; i>=0; i--) {
			PropertyChangeListener lst = target.getPropertyChangeListeners()[i];
			if (lst instanceof MyPropertyChangeListener) target.removePropertyChangeListener(lst);
		}
	}

	public class TargetManager {
		private final Component target;
		private final DeclarationSet normalDS;
		private final DeclarationSet hoverDS;
		private final DeclarationSet activeDS;
		private final DeclarationSet focusDS;
		private final DeclarationSet disabledDS;
		private final MyMouseListener mouseListener = new MyMouseListener();
		private final MyFocusListener focusListener = new MyFocusListener();
		private final MyPropertyChangeListener propChangeListener = new MyPropertyChangeListener();
		private boolean isOver = false;
		private boolean isPressed = false;
		private boolean isFocused;

		public TargetManager(Component target, DeclarationSet normalDS, DeclarationSet hoverDS, DeclarationSet activeDS, DeclarationSet focusDS, DeclarationSet disabledDS) {
			this.target = target;
			this.normalDS = normalDS;
			this.hoverDS = hoverDS;
			this.activeDS = activeDS;
			this.focusDS = focusDS;
			this.disabledDS = disabledDS;
			this.isFocused = target.isFocusOwner();
		}

		public void apply() {
			Style.apply(target, normalDS);

			if (target.isEnabled()) {
				if (isFocused) Style.apply(target, focusDS);
				if (isOver) Style.apply(target, hoverDS);
				if (isPressed) Style.apply(target, activeDS);
			} else {
				Style.apply(target, disabledDS);
			}
		}

		public class MyMouseListener extends MouseAdapter {
			@Override public void mouseEntered(MouseEvent e) {isOver = true; apply();}
			@Override public void mouseExited(MouseEvent e) {isOver = false; apply();}
			@Override public void mousePressed(MouseEvent e) {isPressed = true; apply();}
			@Override public void mouseReleased(MouseEvent e) {isPressed = false; apply();}
		}

		public class MyFocusListener extends FocusAdapter {
			@Override public void focusGained(FocusEvent e) {isFocused = true; apply();}
			@Override public void focusLost(FocusEvent e) {isFocused = false; apply();}
		}

		public class MyPropertyChangeListener implements PropertyChangeListener {
			@Override public void propertyChange(PropertyChangeEvent e) {
				if (e.getPropertyName().equals("enabled")) {apply();}
			}
		}
	}
}
