package aurelienribon.ui.components;

import aurelienribon.ui.utils.PaintUtils;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class GroupBorder implements Border {
	private final JLabel label = new JLabel();
	private int titleHeight = 20;
	private int padding = 6;
	private Color stroke = Color.BLACK;
	private Paint fill = Color.WHITE;

	public GroupBorder() {
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.CENTER);
	}

	public GroupBorder(Icon icon, String title, int titleHeight, int padding, Color foreground, Color stroke, Paint fill) {
		this.titleHeight = titleHeight;
		this.padding = padding;
		this.stroke = stroke;
		this.fill = fill;

		label.setForeground(foreground);
		label.setIcon(icon);
		label.setText(title);
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
			gg.drawRect(0, 0, width-1, height-1);
		}

		label.setFont(c.getFont());
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
}
