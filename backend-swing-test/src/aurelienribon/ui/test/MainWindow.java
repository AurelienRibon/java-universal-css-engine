package aurelienribon.ui.test;

import aurelienribon.ui.components.AruiStyle;
import aurelienribon.ui.components.TabPanel;
import aurelienribon.ui.css.Style;
import aurelienribon.ui.css.StyleException;
import aurelienribon.ui.css.swing.SwingStyle;
import gfx.Gfx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MainWindow extends javax.swing.JFrame {
	private final JTextArea editorArea = new JTextArea();
	private final JTextArea rulesManualArea = new JTextArea();
	private final JTextArea functionsManualArea = new JTextArea();
	private Style style;

    public MainWindow() {
		SwingStyle.init();
		AruiStyle.init();

		rulesManualArea.setText(Style.getPropertiesManual());
		rulesManualArea.setCaretPosition(0);
		functionsManualArea.setText(Style.getFunctionsManual());
		functionsManualArea.setCaretPosition(0);

        initComponents();

		applyBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(editorArea.getText());
			}
		});

		loadStyleVisualStudioBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(getClass().getResource("style-visualstudio.css"));
			}
		});

		loadStyleNetbeansBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(getClass().getResource("style-netbeans.css"));
			}
		});

		loadStyleBlendBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				setStyle(getClass().getResource("style-blend.css"));
			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				reset();
			}
		});

		addIconPanelBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				tabPanel.getModel().add(new JPanel() {{setOpaque(false);}}, "Panel", Gfx.getIcon("ic_panel.png"));
			}
		});

		addPanelBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				tabPanel.getModel().add(new JPanel() {{setOpaque(false);}}, "Panel");
			}
		});

		addPinnedPannelBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				tabPanel.getModel().add(new JPanel() {{setOpaque(false);}}, "Panel", null, false);
			}
		});

		toggleLayoutBtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				int layout = tabPanel.getHeaderLayout();
				tabPanel.setHeaderLayout(layout == TabPanel.LAYOUT_STACK ? TabPanel.LAYOUT_GRID : TabPanel.LAYOUT_STACK);
			}
		});

		Style.registerTarget(getContentPane(), "rootPanel");
		Style.registerTarget(styleControlPanel, "styleControlPanel");
		Style.registerTarget(tabPanelControlPanel, "tabPanelControlPanel");
		Style.registerTarget(applyBtn, "applyButton");
		Style.registerTarget(resetBtn, "resetButton");

		tabPanel.getModel().add(new JScrollPane(editorArea), "Style editor", Gfx.getIcon("ic_edit.png"), false);
		tabPanel.getModel().add(new JScrollPane(rulesManualArea), "CSS rules", Gfx.getIcon("ic_manual.png"), false);
		tabPanel.getModel().add(new JScrollPane(functionsManualArea), "CSS functions", Gfx.getIcon("ic_manual.png"), false);
		reset();
    }

	private void reset() {
		for (int i=tabPanel.getModel().getTabsCount()-1; i>2; i--) tabPanel.getModel().remove(i);
		tabPanel.setHeaderLayout(TabPanel.LAYOUT_STACK);
		setStyle(getClass().getResource("style-visualstudio.css"));
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

        tabPanel = new aurelienribon.ui.components.TabPanel();
        jPanel2 = new javax.swing.JPanel();
        styleControlPanel = new javax.swing.JPanel();
        applyBtn = new aurelienribon.ui.components.Button();
        resetBtn = new aurelienribon.ui.components.Button();
        loadStyleVisualStudioBtn = new aurelienribon.ui.components.Button();
        loadStyleNetbeansBtn = new aurelienribon.ui.components.Button();
        loadStyleBlendBtn = new aurelienribon.ui.components.Button();
        tabPanelControlPanel = new javax.swing.JPanel();
        addIconPanelBtn = new aurelienribon.ui.components.Button();
        addPanelBtn = new aurelienribon.ui.components.Button();
        addPinnedPannelBtn = new aurelienribon.ui.components.Button();
        toggleLayoutBtn = new aurelienribon.ui.components.Button();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Universal CSS Engine");

        jPanel2.setOpaque(false);

        applyBtn.setText("Apply");

        resetBtn.setText("Reset");

        loadStyleVisualStudioBtn.setText("Load Visual Studio Style");

        loadStyleNetbeansBtn.setText("Load Netbeans Style");

        loadStyleBlendBtn.setText("Load Blend Style");

        javax.swing.GroupLayout styleControlPanelLayout = new javax.swing.GroupLayout(styleControlPanel);
        styleControlPanel.setLayout(styleControlPanelLayout);
        styleControlPanelLayout.setHorizontalGroup(
            styleControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(styleControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(styleControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadStyleNetbeansBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadStyleBlendBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, styleControlPanelLayout.createSequentialGroup()
                        .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loadStyleVisualStudioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        styleControlPanelLayout.setVerticalGroup(
            styleControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(styleControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(styleControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(loadStyleVisualStudioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadStyleNetbeansBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadStyleBlendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addIconPanelBtn.setText("Add panel w/ icon");

        addPanelBtn.setText("Add panel w/o icon");

        addPinnedPannelBtn.setText("Add pinned panel");

        toggleLayoutBtn.setText("Toggle layout");

        javax.swing.GroupLayout tabPanelControlPanelLayout = new javax.swing.GroupLayout(tabPanelControlPanel);
        tabPanelControlPanel.setLayout(tabPanelControlPanelLayout);
        tabPanelControlPanelLayout.setHorizontalGroup(
            tabPanelControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPanelControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addIconPanelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPanelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPinnedPannelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabPanelControlPanelLayout.setVerticalGroup(
            tabPanelControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addIconPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPinnedPannelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toggleLayoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(styleControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabPanelControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(styleControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPanelControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.ui.components.Button addIconPanelBtn;
    private aurelienribon.ui.components.Button addPanelBtn;
    private aurelienribon.ui.components.Button addPinnedPannelBtn;
    private aurelienribon.ui.components.Button applyBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private aurelienribon.ui.components.Button loadStyleBlendBtn;
    private aurelienribon.ui.components.Button loadStyleNetbeansBtn;
    private aurelienribon.ui.components.Button loadStyleVisualStudioBtn;
    private aurelienribon.ui.components.Button resetBtn;
    private javax.swing.JPanel styleControlPanel;
    private aurelienribon.ui.components.TabPanel tabPanel;
    private javax.swing.JPanel tabPanelControlPanel;
    private aurelienribon.ui.components.Button toggleLayoutBtn;
    // End of variables declaration//GEN-END:variables

}
