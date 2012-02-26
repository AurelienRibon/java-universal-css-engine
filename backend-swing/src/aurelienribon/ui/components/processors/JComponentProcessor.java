package aurelienribon.ui.components.processors;

import aurelienribon.ui.components.AruiProperties;
import aurelienribon.ui.components.GroupBorder;
import aurelienribon.ui.css.DeclarationSet;
import aurelienribon.ui.css.DeclarationSetProcessor;
import aurelienribon.ui.css.Property;
import aurelienribon.ui.css.swing.SwingFunctions;
import aurelienribon.ui.css.swing.SwingProperties;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Paint;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class JComponentProcessor implements DeclarationSetProcessor<JComponent> {
	@Override
	public void process(JComponent target, DeclarationSet ds) {
		Property rule;

		rule = SwingProperties.border;
		if (ds.contains(rule) && ds.getValue(rule).get(0) instanceof GroupBorder) {
			GroupBorder border = (GroupBorder) ds.getValue(rule).get(0);

			if (ds.contains(AruiProperties.borderBody)) {
				Border value = ds.getValue(AruiProperties.borderBody, Border.class);
				border.setBodyBorder(value);
			}

			if (ds.contains(AruiProperties.borderHeader)) {
				Border value = ds.getValue(AruiProperties.borderHeader, Border.class);
				border.setHeaderBorder(value);
			}

			if (ds.contains(AruiProperties.borderFill)) {
				Paint value = ds.getValue(AruiProperties.borderFill, Paint.class);
				border.setHeaderFill(value);
			}

			if (ds.contains(AruiProperties.borderMargin)) {
				Insets value = ds.getValue(AruiProperties.borderMargin, Insets.class, SwingFunctions.insets);
				border.setHeaderMargin(value);
			}

			if (ds.contains(AruiProperties.borderTitle)) {
				String value = ds.getValue(AruiProperties.borderTitle, String.class);
				border.setTitle(value);
			}

			if (ds.contains(AruiProperties.borderIcon)) {
				Icon value = ds.getValue(AruiProperties.borderIcon, Icon.class, SwingFunctions.icon);
				border.setIcon(value);
			}

			if (ds.contains(AruiProperties.borderFont)) {
				Font value = ds.getValue(AruiProperties.borderFont, Font.class, SwingFunctions.font);
				border.setFont(value);
			}

			if (ds.contains(AruiProperties.borderForeground)) {
				Color value = ds.getValue(AruiProperties.borderForeground, Color.class);
				border.setForeground(value);
			}
		}
	}
}
