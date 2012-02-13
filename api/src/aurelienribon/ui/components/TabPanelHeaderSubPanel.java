package aurelienribon.ui.components;

import aurelienribon.ui.components.TabPanelModel.TabModel;
import aurelienribon.ui.css.StyleAttributes;
import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.predefined.SwingStyle;
import aurelienribon.ui.utils.PaintUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
class TabPanelHeaderSubPanel extends JPanel {
	public static class Processor implements StyleProcessor {
		@Override
		public void process(Object target, StyleAttributes attrs) {
			if (target instanceof TabPanelHeaderSubPanel) {
				TabPanelHeaderSubPanel t = (TabPanelHeaderSubPanel) target;
				if (attrs.contains(SwingStyle.RULE_FOREGROUND)) t.foreground = attrs.asColor(SwingStyle.RULE_FOREGROUND);
				if (attrs.contains(AruiStyle.RULE_FOREGROUND_SELECTED)) t.foregroundSelected = attrs.asColor(AruiStyle.RULE_FOREGROUND_SELECTED);
				if (attrs.contains(AruiStyle.RULE_FOREGROUND_MOUSEOVER)) t.foregroundMouseOver = attrs.asColor(AruiStyle.RULE_FOREGROUND_MOUSEOVER);
				if (attrs.contains(AruiStyle.RULE_STROKE)) t.stroke = attrs.asColor(AruiStyle.RULE_STROKE);
				if (attrs.contains(AruiStyle.RULE_STROKE_SELECTED)) t.strokeSelected = attrs.asColor(AruiStyle.RULE_STROKE_SELECTED);
				if (attrs.contains(AruiStyle.RULE_STROKE_MOUSEOVER)) t.strokeMouseOver = attrs.asColor(AruiStyle.RULE_STROKE_MOUSEOVER);
				if (attrs.contains(AruiStyle.RULE_FILL)) t.fill = attrs.asPaint(AruiStyle.RULE_FILL);
				if (attrs.contains(AruiStyle.RULE_FILL_SELECTED)) t.fillSelected = attrs.asPaint(AruiStyle.RULE_FILL_SELECTED);
				if (attrs.contains(AruiStyle.RULE_FILL_MOUSEOVER)) t.fillMouseOver = attrs.asPaint(AruiStyle.RULE_FILL_MOUSEOVER);
				t.reload();
			}
		}
	}

	private static final ImageIcon IC_CROSS1_DARK = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross1_dark.png"));
	private static final ImageIcon IC_CROSS2_DARK = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross2_dark.png"));
	private static final ImageIcon IC_CROSS1_LIGHT = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross1_light.png"));
	private static final ImageIcon IC_CROSS2_LIGHT = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross2_light.png"));

	private final TabModel model;
	private final Callback callback;
	private final JLabel descLabel;
	private final JLabel crossLabel;
	private boolean isMouseOver = false;

	private Color foreground = Color.RED;
	private Color foregroundSelected = Color.RED;
	private Color foregroundMouseOver = Color.RED;
	private Color stroke = Color.RED;
	private Color strokeSelected = Color.RED;
	private Color strokeMouseOver = Color.RED;
	private Paint fill = Color.RED;
	private Paint fillSelected = Color.RED;
	private Paint fillMouseOver = Color.RED;

	public TabPanelHeaderSubPanel(TabModel model, Callback callback) {
		this.model = model;
		this.callback = callback;

		addMouseListener(mouseAdapter);

		descLabel = new JLabel();
		descLabel.setIconTextGap(6);
		descLabel.setText(model.title);
		descLabel.setIcon(model.icon);
		crossLabel = new JLabel(IC_CROSS1_DARK);
		crossLabel.setVisible(model.closable);
		crossLabel.addMouseListener(crossMouseAdapter);

		JPanel p = new JPanel(new BorderLayout());
		p.setOpaque(false);
		p.add(Box.createHorizontalStrut(12), BorderLayout.WEST);
		p.add(crossLabel, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(Box.createHorizontalStrut(6), BorderLayout.WEST);
		add(descLabel, BorderLayout.CENTER);
		add(p, BorderLayout.EAST);
	}

	public interface Callback {
		public void selectRequested(TabModel tm);
		public void closeRequested(TabModel tm);
		public void closeAllRequested();
		public void closeOthersRequested(TabModel tm);
	}

	public TabModel getModel() {
		return model;
	}

	public void reload() {
		setBorder(new MatteBorder(1, 0, 0, 1, stroke));

		descLabel.setText(model.title);
		descLabel.setIcon(model.icon);
		crossLabel.setVisible(model.closable);

		int brightness;

		if (model.selected) {
			descLabel.setForeground(foregroundSelected);
			brightness = PaintUtils.getBrightness(fillSelected);
		} else if (isMouseOver) {
			descLabel.setForeground(foregroundMouseOver);
			brightness = PaintUtils.getBrightness(fillMouseOver);
		} else {
			descLabel.setForeground(foreground);
			brightness = PaintUtils.getBrightness(fill);
		}

		if (brightness < 128) crossLabel.setIcon(IC_CROSS1_LIGHT);
		else crossLabel.setIcon(IC_CROSS1_DARK);

		revalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int w = getWidth();
		int h = getHeight();

		if (model.selected) {
			gg.setPaint(PaintUtils.buildPaint(fillSelected, w, h));
			gg.fillRect(0, 0, w, h);
			gg.setColor(strokeSelected);
			gg.drawLine(0, 0, w, 0);
			gg.drawLine(0, 0, 0, h);
			gg.drawLine(w-1, 0, w-1, h);

		} else if (isMouseOver) {
			gg.setPaint(PaintUtils.buildPaint(fillMouseOver, w, h));
			gg.fillRect(0, 0, w, h);
			gg.setColor(strokeMouseOver);
			gg.drawLine(0, 0, w, 0);
			gg.setColor(stroke);
			gg.drawLine(0, 0, 0, h);
			gg.drawLine(w-1, 0, w-1, h);
			gg.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);

		} else {
			gg.setPaint(PaintUtils.buildPaint(fill, w, h));
			gg.fillRect(0, 0, w, h);
			gg.setColor(stroke);
			gg.drawLine(0, 0, w, 0);
			gg.drawLine(0, 0, 0, h);
			gg.drawLine(w-1, 0, w-1, h);
			gg.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
		}
	}

	private final MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			isMouseOver = true;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isMouseOver = false;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				callback.selectRequested(model);
			} else if (SwingUtilities.isMiddleMouseButton(e)) {
				callback.closeRequested(model);
			}

			if (e.isPopupTrigger()) new PopupMenu().show(TabPanelHeaderSubPanel.this, e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) new PopupMenu().show(TabPanelHeaderSubPanel.this, e.getX(), e.getY());
		}
	};

	private final MouseAdapter crossMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (crossLabel.getIcon() == IC_CROSS1_DARK) crossLabel.setIcon(IC_CROSS2_DARK);
			else if (crossLabel.getIcon() == IC_CROSS1_LIGHT) crossLabel.setIcon(IC_CROSS2_LIGHT);
			isMouseOver = true;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (crossLabel.getIcon() == IC_CROSS2_DARK) crossLabel.setIcon(IC_CROSS1_DARK);
			else if (crossLabel.getIcon() == IC_CROSS2_LIGHT) crossLabel.setIcon(IC_CROSS1_LIGHT);
			isMouseOver = false;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				callback.closeRequested(model);
			} else if (SwingUtilities.isMiddleMouseButton(e)) {
				callback.closeRequested(model);
			}
		}
	};

	private class PopupMenu extends JPopupMenu {
		public PopupMenu() {
			add(closeAction);
			add(closeAllAction);
			add(closeOthersAction);
		}

		private final Action closeAction = new AbstractAction("Close") {
			@Override public void actionPerformed(ActionEvent e) {callback.closeRequested(model);}
		};

		private final Action closeAllAction = new AbstractAction("Close all") {
			@Override public void actionPerformed(ActionEvent e) {callback.closeAllRequested();}
		};

		private final Action closeOthersAction = new AbstractAction("Close others") {
			@Override public void actionPerformed(ActionEvent e) {callback.closeOthersRequested(model);}
		};
	};
}
