package aurelienribon.ui.test;

import aurelienribon.ui.components.AruiStyle;
import aurelienribon.ui.components.TabPanel;
import aurelienribon.ui.components.TabPanelModel;
import aurelienribon.ui.css.Style;
import aurelienribon.ui.css.StyleException;
import aurelienribon.ui.css.predefined.SwingStyle;
import gfx.Gfx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MainWindow extends javax.swing.JFrame {
	private Style style;

    public MainWindow() {
		SwingStyle.init();
		AruiStyle.init();

        initComponents();

		applyBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(editorArea.getText());
			}
		});

		loadStyle1Btn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(getClass().getResource("style-netbeans.css"));
			}
		});

		loadStyle2Btn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(getClass().getResource("style-blend.css"));
			}
		});

		resetBtn.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {reset();}});
		toggleLayoutBtn.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {toggleLayout();}});

		Style.registerTargetClass(getContentPane(), "rootPanel");
		Style.registerTargetClass(controlPanel, "controlPanel");
		Style.registerTargetClass(applyBtn, "applyButton");
		Style.registerTargetClass(resetBtn, "resetButton");
		Style.registerTargetClass(loadStyle1Btn, "loadButton");
		Style.registerTargetClass(loadStyle2Btn, "loadButton");
		Style.registerTargetClass(toggleLayoutBtn, "toggleLayoutButton");

		reset();
    }

	private void reset() {
		tabPanel.setHeaderLayout(TabPanel.LAYOUT_STACK);

		JPanel[] panels = new JPanel[3];
		for (int i=0; i<panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setOpaque(false);
		}

		tabPanel.setModel(new TabPanelModel());
		tabPanel.getModel().add(editorPanel, "Style editor", null, false);
		tabPanel.getModel().add(panels[0], "Pinned panel with icon", Gfx.getIcon("ic_file.png"), false);
		tabPanel.getModel().add(panels[1], "Panel", null, true);
		tabPanel.getModel().add(panels[2], "Panel with icon", Gfx.getIcon("ic_file.png"), true);

		setStyle(getClass().getResource("style-netbeans.css"));
	}

	private void toggleLayout() {
		int layout = tabPanel.getHeaderLayout();
		tabPanel.setHeaderLayout(layout == TabPanel.LAYOUT_STACK ? TabPanel.LAYOUT_GRID : TabPanel.LAYOUT_STACK);
	}

	private void setStyle(URL input) {
		try {
			style = new Style(input);
			editorArea.setText(style.getStyleSheet());
			editorArea.setCaretPosition(0);
			Style.apply(getContentPane(), style);
		} catch (StyleException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void setStyle(String input) {
		try {
			style = new Style(input);
			editorArea.setText(style.getStyleSheet());
			editorArea.setCaretPosition(0);
			Style.apply(getContentPane(), style);
		} catch (StyleException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	// -------------------------------------------------------------------------
	// Generated stuff
	// -------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorArea = new javax.swing.JTextArea();
        tabPanel = new aurelienribon.ui.components.TabPanel();
        controlPanel = new javax.swing.JPanel();
        toggleLayoutBtn = new aurelienribon.ui.components.Button();
        applyBtn = new aurelienribon.ui.components.Button();
        loadStyle2Btn = new aurelienribon.ui.components.Button();
        resetBtn = new aurelienribon.ui.components.Button();
        loadStyle1Btn = new aurelienribon.ui.components.Button();

        editorPanel.setOpaque(false);
        editorPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        editorArea.setColumns(20);
        editorArea.setRows(5);
        jScrollPane1.setViewportView(editorArea);

        editorPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arui test");

        toggleLayoutBtn.setText("Toggle TabPanel layout");

        applyBtn.setText("Apply");

        loadStyle2Btn.setText("Load style 2");

        resetBtn.setText("Reset");

        loadStyle1Btn.setText("Load Style 1");

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadStyle1Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadStyle2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                        .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(loadStyle1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadStyle2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 245, Short.MAX_VALUE))
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.ui.components.Button applyBtn;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextArea editorArea;
    private javax.swing.JPanel editorPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private aurelienribon.ui.components.Button loadStyle1Btn;
    private aurelienribon.ui.components.Button loadStyle2Btn;
    private aurelienribon.ui.components.Button resetBtn;
    private aurelienribon.ui.components.TabPanel tabPanel;
    private aurelienribon.ui.components.Button toggleLayoutBtn;
    // End of variables declaration//GEN-END:variables

}
