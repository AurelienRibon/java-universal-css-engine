package gfx;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Gfx {
	private static Map<String, ImageIcon> icons = new HashMap<String, ImageIcon>();
	
	public static ImageIcon getIcon(String name) {
		if (!icons.containsKey(name)) {
			URL url = Gfx.class.getResource(name);
			if (url == null) throw new RuntimeException("Gfx not found: " + name);
			icons.put(name, new ImageIcon(url));
		}
		
		return icons.get(name);
	}
}
