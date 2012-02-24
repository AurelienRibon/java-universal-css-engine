package aurelienribon.ui.components;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.PaintUtils;
import aurelienribon.ui.css.StyleParent;
import aurelienribon.ui.css.StyleRule;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Button extends JButton implements StyleParent {
	private Color foregroundMouseDown = Color.RED;
	private Color foregroundMouseOver = Color.RED;
	private Color stroke = Color.RED;
	private Color strokeMouseDown = Color.RED;
	private Color strokeMouseOver = Color.RED;
	private Paint fill = Color.RED;
	private Paint fillMouseDown = Color.RED;
	private Paint fillMouseOver = Color.RED;
	private int cornerRadius = 0;

	private final JLabel label = new JLabel();
	private boolean isMouseDown = false;
	private boolean isMouseOver = false;

	public Button() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);

		addMouseListener(mouseAdapter);
		setOpaque(false);
	}

	@Override
	public List<?> getStyleChildren() {
		return null;
	}

	@Override
	public void revalidate() {
		if (label == null) {super.revalidate(); return;}

		label.setFont(getFont());
		label.setText(getText());
		label.setIcon(getIcon());
		label.setHorizontalAlignment(getHorizontalAlignment());
		label.setVerticalAlignment(getVerticalAlignment());
		label.setHorizontalTextPosition(getHorizontalTextPosition());
		label.setVerticalTextPosition(getVerticalTextPosition());

		if (isMouseDown && isMouseOver) {
			label.setForeground(foregroundMouseDown);
		} else if (isMouseOver || (isMouseDown && !isMouseOver)) {
			label.setForeground(foregroundMouseOver);
		} else {
			label.setForeground(getForeground());
		}

		super.revalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int w = getWidth();
		int h = getHeight();

		if (isMouseDown && isMouseOver) {
			gg.setPaint(PaintUtils.buildPaint(fillMouseDown, w, h));
			gg.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);
			gg.setColor(strokeMouseDown);
			gg.drawRoundRect(0, 0, w-1, h-1, cornerRadius, cornerRadius);

		} else if (isMouseOver || (isMouseDown && !isMouseOver)) {
			gg.setPaint(PaintUtils.buildPaint(fillMouseOver, w, h));
			gg.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);
			gg.setColor(strokeMouseOver);
			gg.drawRoundRect(0, 0, w-1, h-1, cornerRadius, cornerRadius);

		} else {
			gg.setPaint(PaintUtils.buildPaint(fill, w, h));
			gg.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);
			gg.setColor(stroke);
			gg.drawRoundRect(0, 0, w-1, h-1, cornerRadius, cornerRadius);
		}
	}

	private final MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			isMouseOver = true;
			revalidate();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isMouseOver = false;
			revalidate();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isMouseDown = true;
				revalidate();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isMouseDown = false;
				revalidate();
			}
		}
	};

	// -------------------------------------------------------------------------
	// StyleProcessor
	// -------------------------------------------------------------------------

	public static class Processor implements StyleProcessor<Button> {
		@Override
		public void process(Button target, StyleRuleSet rs) {
			StyleRule rule;

			rule = AruiRules.FOREGROUND_MOUSEDOWN;
			if (rs.contains(rule)) {target.foregroundMouseDown = (Color) rs.getParams(rule).get(0);}

			rule = AruiRules.FOREGROUND_MOUSEOVER;
			if (rs.contains(rule)) {target.foregroundMouseOver = (Color) rs.getParams(rule).get(0);}

			rule = AruiRules.STROKE;
			if (rs.contains(rule)) {target.stroke = (Color) rs.getParams(rule).get(0);}

			rule = AruiRules.STROKE_MOUSEDOWN;
			if (rs.contains(rule)) {target.strokeMouseDown = (Color) rs.getParams(rule).get(0);}

			rule = AruiRules.STROKE_MOUSEOVER;
			if (rs.contains(rule)) {target.strokeMouseOver = (Color) rs.getParams(rule).get(0);}

			rule = AruiRules.FILL;
			if (rs.contains(rule)) {target.fill = (Paint) rs.getParams(rule).get(0);}

			rule = AruiRules.FILL_MOUSEDOWN;
			if (rs.contains(rule)) {target.fillMouseDown = (Paint) rs.getParams(rule).get(0);}

			rule = AruiRules.FILL_MOUSEOVER;
			if (rs.contains(rule)) {target.fillMouseOver = (Paint) rs.getParams(rule).get(0);}

			rule = AruiRules.CORNERRADIUS;
			if (rs.contains(rule)) {target.cornerRadius = (Integer) rs.getParams(rule).get(0);}

			target.revalidate();
		}
	};
}
