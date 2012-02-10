package aurelienribon.ui.components;

import aurelienribon.ui.Style;
import aurelienribon.ui.StyleAttributes;
import aurelienribon.ui.StyleAccessor;
import aurelienribon.ui.utils.PaintUtils;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Button extends JButton {
	static {
		Style.register(Button.class, new StyleAccessor<Button>() {
			@Override public void applyStyle(Button target, StyleAttributes attrs) {
				target.foregroundPressed = attrs.getColor("-arui-foreground-pressed", target.foregroundPressed);
				target.foregroundMouseOver = attrs.getColor("-arui-foreground-mouseover", target.foregroundMouseOver);
				target.stroke = attrs.getColor("-arui-stroke", target.stroke);
				target.strokePressed = attrs.getColor("-arui-stroke-pressed", target.strokePressed);
				target.strokeMouseOver = attrs.getColor("-arui-stroke-mouseover", target.strokeMouseOver);
				target.fill = attrs.getPaint("-arui-fill", target.fill);
				target.fillPressed = attrs.getPaint("-arui-fill-pressed", target.fillPressed);
				target.fillMouseOver = attrs.getPaint("-arui-fill-mouseover", target.fillMouseOver);
				target.cornerRadius = attrs.getInt("-arui-cornerradius", target.cornerRadius);
				target.reload();
			}
		});
	}

	private Color foregroundPressed = Color.RED;
	private Color foregroundMouseOver = Color.RED;
	private Color stroke = Color.RED;
	private Color strokePressed = Color.RED;
	private Color strokeMouseOver = Color.RED;
	private Paint fill = Color.RED;
	private Paint fillPressed = Color.RED;
	private Paint fillMouseOver = Color.RED;
	private int cornerRadius = 0;

	private final JLabel label = new JLabel();
	private boolean isMouseOver = false;
	private boolean isPressed = false;

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

		if (isPressed && isMouseOver) {
			label.setForeground(foregroundPressed);
		} else if (isMouseOver || (isPressed && !isMouseOver)) {
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

		if (isPressed && isMouseOver) {
			gg.setPaint(PaintUtils.buildPaint(fillPressed, w, h));
			gg.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);
			gg.setColor(strokePressed);
			gg.drawRoundRect(0, 0, w-1, h-1, cornerRadius, cornerRadius);

		} else if (isMouseOver || (isPressed && !isMouseOver)) {
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
				isPressed = true;
				reload();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isPressed = false;
				reload();
			}
		}
	};
}
