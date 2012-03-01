package aurelienribon.ui.css.swing;

import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.PseudoClass;
import aurelienribon.ui.css.DeclarationSetManager;
import aurelienribon.ui.css.Style;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
			if (ml instanceof MyMouseListener) target.removeMouseListener(ml);
		}

		if (!hoverDS.isEmpty() || !activeDS.isEmpty()) {
			MyMouseListener listener = new MyMouseListener(target, hoverDS, activeDS, normalDS);
			target.addMouseListener(listener);
		}

		Style.apply(target, normalDS);
	}

	private class MyMouseListener extends MouseAdapter {
		private final Component target;
		private final DeclarationSet hoverDS;
		private final DeclarationSet activeDS;
		private final DeclarationSet normalDS;
		private boolean isOver = false, isPressed = false;

		public MyMouseListener(Component target, DeclarationSet hoverDS, DeclarationSet activeDS, DeclarationSet normalDS) {
			this.target = target;
			this.hoverDS = hoverDS;
			this.activeDS = activeDS;
			this.normalDS = normalDS;
		}

		@Override public void mouseEntered(MouseEvent e) {apply(); isOver = true;}
		@Override public void mouseExited(MouseEvent e) {apply(); isOver = false;}
		@Override public void mousePressed(MouseEvent e) {apply(); isPressed = true;}
		@Override public void mouseReleased(MouseEvent e) {apply(); isPressed = false;}

		private void apply() {
			Style.apply(target, normalDS);
			if (isOver) Style.apply(target, hoverDS);
			if (isPressed) Style.apply(target, activeDS);
		}
	}
}
