package aurelienribon.ui.components;

import aurelienribon.ui.css.swing.PaintUtils;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class GroupBorder implements Border {
	private final JLabel label = new JLabel();
	private int titleHeight;
	private int padding;
	private Color stroke;
	private Paint fill;
	private boolean headerStrokeVisible;

	public GroupBorder() {
		this(null, "GroupBorder", 20, 6, Color.BLACK, Color.LIGHT_GRAY, true);
	}

	public GroupBorder(Icon icon, String title, int titleHeight, int padding, Color stroke, Paint fill) {
		this(icon, title, titleHeight, padding, stroke, fill, true);
	}

	public GroupBorder(Icon icon, String title, int titleHeight, int padding, Color stroke, Paint fill, boolean headerStrokeVisible) {
		this.titleHeight = titleHeight;
		this.padding = padding;
		this.stroke = stroke;
		this.fill = fill;
		this.headerStrokeVisible = headerStrokeVisible;

		label.setIcon(icon);
		label.setText(title);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.CENTER);
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D gg = (Graphics2D) g.create();
		gg.translate(x, y);

		if (fill != null) {
			gg.setPaint(PaintUtils.buildPaint(fill, width, titleHeight));
			gg.fillRect(0, 0, width, titleHeight);
		}

		if (stroke != null) {
			gg.setColor(stroke);
			gg.drawLine(0, titleHeight, 0, height);
			gg.drawLine(width-1, titleHeight, width-1, height);
			gg.drawLine(0, height-1, width, height-1);

			if (headerStrokeVisible) {
				gg.drawLine(0, 0, 0, titleHeight);
				gg.drawLine(width-1, 0, width-1, titleHeight);
				gg.drawLine(0, 0, width, 0);
			}
		}

		label.setFont(c.getFont());
		label.setForeground(c.getForeground());
		label.setSize(width - padding*2, titleHeight);

		gg.translate(padding, 0);
		label.paint(gg);

		gg.dispose();
	}

	@Override
	public Insets getBorderInsets(Component c) {
		if (stroke != null) return new Insets(titleHeight, 1, 1, 1);
		return new Insets(titleHeight, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	public int getTitleHeight() {
		return titleHeight;
	}

	public void setTitleHeight(int titleHeight) {
		this.titleHeight = titleHeight;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public Color getStroke() {
		return stroke;
	}

	public void setStroke(Color stroke) {
		this.stroke = stroke;
	}

	public Paint getFill() {
		return fill;
	}

	public void setFill(Paint fill) {
		this.fill = fill;
	}

	public Color getForeground() {
		return label.getForeground();
	}

	public void setForeground(Color foreground) {
		label.setForeground(foreground);
	}

	public Icon getIcon() {
		return label.getIcon();
	}

	public void setIcon(Icon icon) {
		label.setIcon(icon);
	}

	public String getTitle() {
		return label.getText();
	}

	public void setTitle(String title) {
		label.setText(title);
	}

	public boolean isHeaderStrokeVisible() {
		return headerStrokeVisible;
	}

	public void setHeaderStrokeVisible(boolean headerStrokeVisible) {
		this.headerStrokeVisible = headerStrokeVisible;
	}
}
