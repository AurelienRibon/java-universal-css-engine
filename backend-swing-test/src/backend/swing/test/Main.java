package backend.swing.test;

import javax.swing.SwingUtilities;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow mw = new MainWindow();
				mw.pack();
				mw.setLocationRelativeTo(null);
				mw.setVisible(true);
			}
		});
	}
}
