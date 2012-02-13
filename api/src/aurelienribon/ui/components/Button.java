package aurelienribon.ui.components;

import aurelienribon.ui.css.StyleAttributes;
import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.utils.PaintUtils;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Button extends JButton {
	public static class Processor implements StyleProcessor {
		@Override
		public void process(Object target, StyleAttributes attrs) {
			if (target instanceof Button) {
				Button t = (Button) target;
				if (attrs.contains(AruiStyle.RULE_FOREGROUND_MOUSEDOWN)) t.foregroundMouseDown = attrs.asColor(AruiStyle.RULE_FOREGROUND_MOUSEDOWN);
				if (attrs.contains(AruiStyle.RULE_FOREGROUND_MOUSEOVER)) t.foregroundMouseOver = attrs.asColor(AruiStyle.RULE_FOREGROUND_MOUSEOVER);
				if (attrs.contains(AruiStyle.RULE_STROKE)) t.stroke = attrs.asColor(AruiStyle.RULE_STROKE);
				if (attrs.contains(AruiStyle.RULE_STROKE_MOUSEDOWN)) t.strokeMouseDown = attrs.asColor(AruiStyle.RULE_STROKE_MOUSEDOWN);
				if (attrs.contains(AruiStyle.RULE_STROKE_MOUSEOVER)) t.strokeMouseOver = attrs.asColor(AruiStyle.RULE_STROKE_MOUSEOVER);
				if (attrs.contains(AruiStyle.RULE_FILL)) t.fill = attrs.asPaint(AruiStyle.RULE_FILL);
				if (attrs.contains(AruiStyle.RULE_FILL_MOUSEDOWN)) t.fillMouseDown = attrs.asPaint(AruiStyle.RULE_FILL_MOUSEDOWN);
				if (attrs.contains(AruiStyle.RULE_FILL_MOUSEOVER)) t.fillMouseOver = attrs.asPaint(AruiStyle.RULE_FILL_MOUSEOVER);
				if (attrs.contains(AruiStyle.RULE_CORNERRADIUS)) t.cornerRadius = attrs.asInteger(AruiStyle.RULE_CORNERRADIUS);
				t.reload();
			}
		}
	}

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
		setOpaque(false);
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		addMouseListener(mouseAdapter);
		reload();
	}

	private void reload() {
		label.setHorizontalAlignment(getHorizontalAlignment());
		label.setVerticalAlignment(getVerticalAlignment());
		label.setFont(getFont());

		if (isMouseDown && isMouseOver) {
			label.setForeground(foregroundMouseDown);
		} else if (isMouseOver || (isMouseDown && !isMouseOver)) {
			label.setForeground(foregroundMouseOver);
		} else {
			label.setForeground(getForeground());
		}

		revalidate();
		repaint();
	}

	@Override
	public void setText(String text) {
		super.setText(text);
		if (label != null) label.setText(text);
	}

	@Override
	public void setIcon(Icon defaultIcon) {
		super.setIcon(defaultIcon);
		if (label != null) label.setIcon(defaultIcon);
	}

	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (label != null) label.setForeground(fg);
	}

	@Override
	public void setHorizontalAlignment(int alignment) {
		super.setHorizontalAlignment(alignment);
		if (label != null) label.setHorizontalAlignment(alignment);
	}

	@Override
	public void setVerticalAlignment(int alignment) {
		super.setVerticalAlignment(alignment);
		if (label != null) label.setVerticalAlignment(alignment);
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
			reload();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isMouseOver = false;
			reload();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isMouseDown = true;
				reload();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isMouseDown = false;
				reload();
			}
		}
	};
}
