package aurelienribon.ui.components;

import aurelienribon.ui.css.Container;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.utils.PaintUtils;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 * Custom button, highly customizable. Supports a stroke (can be any
 * {@link Paint} object), a stroke thickness, a fill {@link Paint} object, and
 * a corner radius.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Button extends JButton implements Container {
	private Paint stroke = Color.RED;
	private Paint fill = Color.RED;
	private int strokeThickness = 0;
	private int cornerRadius = 0;

	private final JLabel label = new JLabel();

	public Button() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		setOpaque(false);
	}

	@Override
	public Object[] getChildren() {
		return null;
	}

	@Override
	public void revalidate() {
		if (label != null) {
			label.setFont(getFont());
			label.setText(getText());
			label.setIcon(getIcon());
			label.setHorizontalAlignment(getHorizontalAlignment());
			label.setVerticalAlignment(getVerticalAlignment());
			label.setHorizontalTextPosition(getHorizontalTextPosition());
			label.setVerticalTextPosition(getVerticalTextPosition());
		}

		super.revalidate();
	}

	public Paint getStroke() {
		return stroke;
	}

	public Paint getFill() {
		return fill;
	}

	public int getStrokeThickness() {
		return strokeThickness;
	}

	public int getCornerRadius() {
		return cornerRadius;
	}

	@Override
	public void setForeground(Color fg) {
		if (label != null) label.setForeground(fg);
		super.setForeground(fg);
	}

	public void setStroke(Paint stroke) {
		this.stroke = stroke;
		repaint();
	}

	public void setFill(Paint fill) {
		this.fill = fill;
		repaint();
	}

	public void setStrokeThickness(int strokeThickness) {
		this.strokeThickness = strokeThickness;
		repaint();
	}

	public void setCornerRadius(int cornerRadius) {
		this.cornerRadius = cornerRadius;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g.create();
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int w = getWidth();
		int h = getHeight();
		double innerGap = strokeThickness / 2f;
		double innerW = w - innerGap*2 - 1;
		double innerH = h - innerGap*2 - 1;

		Shape rect = cornerRadius > 0
			? new RoundRectangle2D.Double(innerGap, innerGap, innerW, innerH, cornerRadius, cornerRadius)
			: new Rectangle2D.Double(innerGap, innerGap, innerW, innerH);

		gg.setStroke(new BasicStroke(strokeThickness));
		gg.setPaint(PaintUtils.buildPaint(fill, innerGap, innerGap, innerW, innerH));
		gg.fill(rect);

		if (strokeThickness > 0) {
			gg.setPaint(PaintUtils.buildPaint(stroke, 0, 0, w, h));
			gg.draw(rect);
		}

		gg.dispose();
	}

	// -------------------------------------------------------------------------
	// StyleProcessor
	// -------------------------------------------------------------------------

	public static class Processor implements DeclarationSetProcessor<Button>, AruiProperties {
		@Override
		public void process(Button target, DeclarationSet ds) {
			Property p;

			p = stroke; if (ds.contains(p)) target.setStroke(ds.getValue(p, Paint.class));
			p = fill; if (ds.contains(p)) target.setFill(ds.getValue(p, Paint.class));
			p = corderRadius; if (ds.contains(p)) target.setCornerRadius(ds.getValue(p, Integer.class));
			p = strokeThickness; if (ds.contains(p)) target.setStrokeThickness(ds.getValue(p, Integer.class));
		}
	}
}
