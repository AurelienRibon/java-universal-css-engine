package aurelienribon.ui.components;

import aurelienribon.ui.css.swing.PaintUtils;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class GroupBorder implements Border {
	private final JLabel label = new JLabel();

	private Border bodyBorder;
	private Border headerBorder;
	private Insets headerMargin;
	private Paint headerFill;
	private String title;
	private Icon icon;
	private Color foreground;
	private Font font;
	private int horizontalAlignment;
	private int verticalAlignment;

	public GroupBorder() {
		this(new LineBorder(Color.GRAY, 1),
			new MatteBorder(1, 1, 0, 1, Color.GRAY),
			new Insets(0, 0, 0, 0),
			null,
			"",
			null,
			Color.BLACK,
			null,
			SwingConstants.LEFT,
			SwingConstants.CENTER);
	}

	public GroupBorder(Border bodyBorder, Border headerBorder, Insets headerMargin, Paint headerFill, String title, Icon icon, Color foreground, Font font, int horizontalAlignment, int verticalAlignment) {
		this.bodyBorder = bodyBorder;
		this.headerBorder = headerBorder;
		this.headerMargin = headerMargin;
		this.headerFill = headerFill;
		this.title = title;
		this.icon = icon;
		this.foreground = foreground;
		this.font = font;
		this.horizontalAlignment = horizontalAlignment;
		this.verticalAlignment = verticalAlignment;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D gg = (Graphics2D) g.create();
		gg.translate(x, y);

		int hh = getHeaderHeight(c);

		if (headerFill != null) {
			gg.setPaint(PaintUtils.buildPaint(headerFill, width, hh));
			gg.fillRect(0, 0, width, hh);
		}

		if (headerBorder != null) headerBorder.paintBorder(c, gg, 0, 0, width, hh);
		if (bodyBorder != null) bodyBorder.paintBorder(c, gg, 0, hh, width, height - hh);

		label.setSize(
			width - headerMargin.left - headerMargin.right,
			hh - headerMargin.top - headerMargin.bottom);

		gg.translate(headerMargin.left, headerMargin.top);
		label.paint(gg);

		gg.dispose();
	}

	@Override
	public Insets getBorderInsets(Component c) {
		Insets insets = new Insets(0, 0, 0, 0);

		if (bodyBorder != null) {
			insets.left += bodyBorder.getBorderInsets(c).left;
			insets.right += bodyBorder.getBorderInsets(c).right;
			insets.top += bodyBorder.getBorderInsets(c).top;
			insets.bottom += bodyBorder.getBorderInsets(c).bottom;
		}

		insets.top += getHeaderHeight(c);

		return insets;
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	public Border getBodyBorder() {
		return bodyBorder;
	}

	public Border getHeaderBorder() {
		return headerBorder;
	}

	public Insets getHeaderMargin() {
		return headerMargin;
	}

	public Paint getHeaderFill() {
		return headerFill;
	}

	public String getTitle() {
		return title;
	}

	public Icon getIcon() {
		return icon;
	}

	public Color getForeground() {
		return foreground;
	}

	public Font getFont() {
		return font;
	}

	public int getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setBodyBorder(Border bodyBorder) {
		this.bodyBorder = bodyBorder;
	}

	public void setHeaderBorder(Border headerBorder) {
		this.headerBorder = headerBorder;
	}

	public void setHeaderMargin(Insets headerMargin) {
		this.headerMargin = headerMargin;
	}

	public void setHeaderFill(Paint headerFill) {
		this.headerFill = headerFill;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setHorizontalAlignment(int horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private int getHeaderHeight(Component c) {
		int h = 0;

		h += headerMargin.top + headerMargin.bottom;
		h += getLabel(c).getPreferredSize().height;

		if (headerBorder != null) {
			h += headerBorder.getBorderInsets(c).top;
			h += headerBorder.getBorderInsets(c).bottom;
		}

		return h;
	}

	private JLabel getLabel(Component c) {
		label.setFont(font != null ? font : c.getFont());
		label.setText(title);
		label.setIcon(icon);
		label.setForeground(foreground);
		label.setHorizontalAlignment(horizontalAlignment);
		label.setVerticalAlignment(verticalAlignment);
		return label;
	}
}
