package aurelienribon.ui.components;

import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.SwingUtils;
import aurelienribon.ui.css.swing.PaintUtils;
import aurelienribon.ui.css.StyleParent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Button extends JButton implements StyleParent {
	public static final StyleProcessor PROCESSOR = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof Button) {
				Button t = (Button) target;
				if (rs.contains(AruiRules.FOREGROUND_MOUSEDOWN)) t.foregroundMouseDown = SwingUtils.asColor(rs.getParams(AruiRules.FOREGROUND_MOUSEDOWN), 0);
				if (rs.contains(AruiRules.FOREGROUND_MOUSEOVER)) t.foregroundMouseOver = SwingUtils.asColor(rs.getParams(AruiRules.FOREGROUND_MOUSEOVER), 0);
				if (rs.contains(AruiRules.STROKE)) t.stroke = SwingUtils.asColor(rs.getParams(AruiRules.STROKE), 0);
				if (rs.contains(AruiRules.STROKE_MOUSEDOWN)) t.strokeMouseDown = SwingUtils.asColor(rs.getParams(AruiRules.STROKE_MOUSEDOWN), 0);
				if (rs.contains(AruiRules.STROKE_MOUSEOVER)) t.strokeMouseOver = SwingUtils.asColor(rs.getParams(AruiRules.STROKE_MOUSEOVER), 0);
				if (rs.contains(AruiRules.FILL)) t.fill = SwingUtils.asPaint(rs.getParams(AruiRules.FILL), 0);
				if (rs.contains(AruiRules.FILL_MOUSEDOWN)) t.fillMouseDown = SwingUtils.asPaint(rs.getParams(AruiRules.FILL_MOUSEDOWN), 0);
				if (rs.contains(AruiRules.FILL_MOUSEOVER)) t.fillMouseOver = SwingUtils.asPaint(rs.getParams(AruiRules.FILL_MOUSEOVER), 0);
				if (rs.contains(AruiRules.CORNERRADIUS)) t.cornerRadius = rs.asInteger(AruiRules.CORNERRADIUS, 0);
				t.revalidate();
			}
		}
	};

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
}
