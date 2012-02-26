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

			rule = AruiProperties.borderStroke;
			if (ds.contains(rule)) border.setStroke(ds.getValue(rule, Paint.class));

			rule = AruiProperties.borderThickness;
			if (ds.contains(rule)) border.setThickness(ds.getValue(rule, Insets.class, SwingFunctions.insets));

			rule = AruiProperties.borderHeaderStroke;
			if (ds.contains(rule)) border.setHeaderStroke(ds.getValue(rule, Paint.class));

			rule = AruiProperties.borderHeaderThickness;
			if (ds.contains(rule)) border.setHeaderThickness(ds.getValue(rule, Insets.class, SwingFunctions.insets));

			rule = AruiProperties.borderHeaderFill;
			if (ds.contains(rule)) border.setHeaderFill(ds.getValue(rule, Paint.class));

			rule = AruiProperties.borderTitle;
			if (ds.contains(rule)) border.setTitle(ds.getValue(rule, String.class));

			rule = AruiProperties.borderIcon;
			if (ds.contains(rule)) border.setTitleIcon(ds.getValue(rule, Icon.class, SwingFunctions.icon));

			rule = AruiProperties.borderFont;
			if (ds.contains(rule)) border.setTitleFont(ds.getValue(rule, Font.class, SwingFunctions.font));

			rule = AruiProperties.borderForeground;
			if (ds.contains(rule)) border.setTitleForeground(ds.getValue(rule, Color.class));

			rule = AruiProperties.borderMargin;
			if (ds.contains(rule)) border.setTitleMargin(ds.getValue(rule, Insets.class, SwingFunctions.insets));
		}
	}
}
