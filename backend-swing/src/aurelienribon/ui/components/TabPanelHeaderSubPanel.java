package aurelienribon.ui.components;

import aurelienribon.ui.components.TabPanelModel.TabModel;
import aurelienribon.ui.css.StyleProcessor;
import aurelienribon.ui.css.StyleRuleSet;
import aurelienribon.ui.css.swing.SwingUtils;
import aurelienribon.ui.css.swing.PaintUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
class TabPanelHeaderSubPanel extends JComponent {
	public static final StyleProcessor PROCESSOR = new StyleProcessor() {
		@Override public void process(Object target, StyleRuleSet rs) {
			if (target instanceof TabPanelHeaderSubPanel) {
				TabPanelHeaderSubPanel t = (TabPanelHeaderSubPanel) target;
				if (rs.contains(AruiRules.FOREGROUND_UNSELECTED)) t.foregroundUnselected = SwingUtils.asColor(rs.getParams(AruiRules.FOREGROUND_UNSELECTED), 0);
				if (rs.contains(AruiRules.FOREGROUND_SELECTED)) t.foregroundSelected = SwingUtils.asColor(rs.getParams(AruiRules.FOREGROUND_SELECTED), 0);
				if (rs.contains(AruiRules.FOREGROUND_MOUSEOVER)) t.foregroundMouseOver = SwingUtils.asColor(rs.getParams(AruiRules.FOREGROUND_MOUSEOVER), 0);
				if (rs.contains(AruiRules.STROKE)) t.stroke = SwingUtils.asColor(rs.getParams(AruiRules.STROKE), 0);
				if (rs.contains(AruiRules.STROKE_UNSELECTED)) t.strokeUnselected = SwingUtils.asColor(rs.getParams(AruiRules.STROKE_UNSELECTED), 0);
				if (rs.contains(AruiRules.STROKE_SELECTED)) t.strokeSelected = SwingUtils.asColor(rs.getParams(AruiRules.STROKE_SELECTED), 0);
				if (rs.contains(AruiRules.STROKE_MOUSEOVER)) t.strokeMouseOver = SwingUtils.asColor(rs.getParams(AruiRules.STROKE_MOUSEOVER), 0);
				if (rs.contains(AruiRules.FILL_UNSELECTED)) t.fillUnselected = SwingUtils.asPaint(rs.getParams(AruiRules.FILL_UNSELECTED), 0);
				if (rs.contains(AruiRules.FILL_SELECTED)) t.fillSelected = SwingUtils.asPaint(rs.getParams(AruiRules.FILL_SELECTED), 0);
				if (rs.contains(AruiRules.FILL_MOUSEOVER)) t.fillMouseOver = SwingUtils.asPaint(rs.getParams(AruiRules.FILL_MOUSEOVER), 0);
				t.reload();
			}
		}
	};

	private static final ImageIcon IC_CROSS1_DARK = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross1_dark.png"));
	private static final ImageIcon IC_CROSS2_DARK = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross2_dark.png"));
	private static final ImageIcon IC_CROSS1_LIGHT = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross1_light.png"));
	private static final ImageIcon IC_CROSS2_LIGHT = new ImageIcon(TabPanelHeaderSubPanel.class.getResource("ic_cross2_light.png"));

	private final TabModel model;
	private final Callback callback;
	private final JLabel descLabel;
	private final JLabel crossLabel;
	private boolean isMouseOver = false;

	private Color foregroundUnselected = Color.RED;
	private Color foregroundSelected = Color.RED;
	private Color foregroundMouseOver = Color.RED;
	private Color stroke = Color.RED;
	private Color strokeUnselected = Color.RED;
	private Color strokeSelected = Color.RED;
	private Color strokeMouseOver = Color.RED;
	private Paint fillUnselected = Color.RED;
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
			descLabel.setForeground(foregroundUnselected);
			brightness = PaintUtils.getBrightness(fillUnselected);
		}

		if (brightness < 128) crossLabel.setIcon(IC_CROSS1_LIGHT);
		else crossLabel.setIcon(IC_CROSS1_DARK);

		revalidate();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int w = getWidth();
		int h = getHeight();

		if (model.selected) {
			if (fillSelected != null) {
				gg.setPaint(PaintUtils.buildPaint(fillSelected, w, h));
				gg.fillRect(0, 0, w, h);
			}
			if (strokeSelected != null) {
				gg.setColor(strokeSelected);
				gg.drawLine(0, 0, w-1, 0);
				gg.drawLine(0, 0, 0, h-1);
				gg.drawLine(w-1, 0, w-1, h-1);
			}

		} else if (isMouseOver) {
			if (fillMouseOver != null) {
				gg.setPaint(PaintUtils.buildPaint(fillMouseOver, w, h));
				gg.fillRect(0, 0, w, h);
			}
			if (strokeMouseOver != null) {
				gg.setColor(strokeMouseOver);
				gg.drawLine(0, 0, w-1, 0);
				gg.drawLine(0, 0, 0, h-1);
				gg.drawLine(w-1, 0, w-1, h-1);
			}
			if (stroke != null) {
				gg.setColor(strokeUnselected);
				gg.drawLine(0, h-1, w-1, h-1);
			}

		} else {
			if (fillUnselected != null) {
				gg.setPaint(PaintUtils.buildPaint(fillUnselected, w, h));
				gg.fillRect(0, 0, w, h);
			}
			if (strokeUnselected != null) {
				gg.setColor(strokeUnselected);
				gg.drawLine(0, 0, w-1, 0);
				gg.drawLine(0, 0, 0, h-1);
				gg.drawLine(w-1, 0, w-1, h-1);
			}
			if (stroke != null) {
				gg.setColor(strokeUnselected);
				gg.drawLine(0, h-1, w-1, h-1);
			}
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
