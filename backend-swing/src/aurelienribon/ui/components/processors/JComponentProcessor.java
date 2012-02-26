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

			rule = AruiProperties.borderBody;
			if (ds.contains(rule)) border.setBodyBorder(ds.getValue(rule, Border.class));

			rule = AruiProperties.borderHeader;
			if (ds.contains(rule)) border.setHeaderBorder(ds.getValue(AruiProperties.borderHeader, Border.class));

			rule = AruiProperties.borderFill;
			if (ds.contains(rule)) border.setHeaderFill(ds.getValue(AruiProperties.borderFill, Paint.class));

			rule = AruiProperties.borderMargin;
			if (ds.contains(rule)) border.setHeaderMargin(ds.getValue(AruiProperties.borderMargin, Insets.class, SwingFunctions.insets));

			rule = AruiProperties.borderTitle;
			if (ds.contains(rule)) border.setTitle(ds.getValue(AruiProperties.borderTitle, String.class));

			rule = AruiProperties.borderIcon;
			if (ds.contains(rule)) border.setIcon(ds.getValue(AruiProperties.borderIcon, Icon.class, SwingFunctions.icon));

			rule = AruiProperties.borderFont;
			if (ds.contains(rule)) border.setFont(ds.getValue(AruiProperties.borderFont, Font.class, SwingFunctions.font));

			rule = AruiProperties.borderForeground;
			if (ds.contains(rule)) border.setForeground(ds.getValue(AruiProperties.borderForeground, Color.class));
		}
	}
}
