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
		Property p;

		p = SwingProperties.border;
		if (ds.contains(p) && ds.getValue(p).get(0) instanceof GroupBorder) {
			GroupBorder border = (GroupBorder) ds.getValue(p).get(0);

			p = AruiProperties.borderStroke;
			if (ds.contains(p)) border.setStroke(ds.getValue(p, Paint.class));

			p = AruiProperties.borderThickness;
			if (ds.contains(p)) border.setThickness(ds.getValue(p, Insets.class, SwingFunctions.insets));

			p = AruiProperties.borderHeaderStroke;
			if (ds.contains(p)) border.setHeaderStroke(ds.getValue(p, Paint.class));

			p = AruiProperties.borderHeaderThickness;
			if (ds.contains(p)) border.setHeaderThickness(ds.getValue(p, Insets.class, SwingFunctions.insets));

			p = AruiProperties.borderHeaderFill;
			if (ds.contains(p)) border.setHeaderFill(ds.getValue(p, Paint.class));

			p = AruiProperties.borderTitle;
			if (ds.contains(p)) border.setTitle(ds.getValue(p, String.class));

			p = AruiProperties.borderIcon;
			if (ds.contains(p)) border.setTitleIcon(ds.getValue(p, Icon.class, SwingFunctions.icon));

			p = AruiProperties.borderFont;
			if (ds.contains(p)) border.setTitleFont(ds.getValue(p, Font.class, SwingFunctions.font));

			p = AruiProperties.borderForeground;
			if (ds.contains(p)) border.setTitleForeground(ds.getValue(p, Color.class));

			p = AruiProperties.borderMargin;
			if (ds.contains(p)) border.setTitleMargin(ds.getValue(p, Insets.class, SwingFunctions.insets));
		}
	}
}
