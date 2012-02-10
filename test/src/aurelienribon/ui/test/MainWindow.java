package aurelienribon.ui.test;

import aurelienribon.ui.Style;
import aurelienribon.ui.components.TabPanel;
import aurelienribon.ui.components.TabPanelModel;
import gfx.Gfx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MainWindow extends javax.swing.JFrame {
	private Style style;

    public MainWindow() {
        initComponents();

		applyBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				style = new Style(editorArea.getText());

				try {
					Style.apply(getContentPane(), style);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		loadStyle1Btn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				
			}
		});

		resetBtn.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {reset();}});
		toggleLayoutBtn.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {toggleLayout();}});

		Style.registerClassName(getContentPane(), "rootPanel");
		Style.registerClassName(applyBtn, "applyButton");
		Style.registerClassName(resetBtn, "resetButton");
		Style.registerClassName(loadStyle1Btn, "loadButton");
		Style.registerClassName(loadStyle2Btn, "loadButton");
		Style.registerClassName(toggleLayoutBtn, "toggleLayoutButton");

		reset();
    }

	private void reset() {
		style = new Style(getClass().getResource("style-netbeans.css"));

		editorArea.setText(style.getStyleSheet());
		editorArea.setCaretPosition(0);

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

		Style.apply(getContentPane(), style);
	}

	private void toggleLayout() {
		int layout = tabPanel.getHeaderLayout();
		tabPanel.setHeaderLayout(layout == TabPanel.LAYOUT_STACK ? TabPanel.LAYOUT_GRID : TabPanel.LAYOUT_STACK);
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
        resetBtn = new aurelienribon.ui.components.Button();
        toggleLayoutBtn = new aurelienribon.ui.components.Button();
        applyBtn = new aurelienribon.ui.components.Button();
        loadStyle1Btn = new aurelienribon.ui.components.Button();
        loadStyle2Btn = new aurelienribon.ui.components.Button();

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

        resetBtn.setText("Reset");

        toggleLayoutBtn.setText("Toggle TabPanel layout");

        applyBtn.setText("Apply");

        loadStyle1Btn.setText("Load Style 1");

        loadStyle2Btn.setText("Load style 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadStyle1Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadStyle2Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(loadStyle1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadStyle2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.ui.components.Button applyBtn;
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
