package aurelienribon.ui.components;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * The ImagePreviewPanel shows an image resized to fit in the center of the
 * panel. The image is either loaded from a file or an url, and you can
 * choose to only display a region of this image.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class ImagePreviewPanel extends PaintedPanel {
	private BufferedImage image;
	private Rectangle region;

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage bi) {
		image = bi;
		region = null;
		repaint();
	}

	public void setImage(URL url) throws IOException {
		setImage(ImageIO.read(url));
	}

	public void setImage(File file) throws IOException {
		setImage(ImageIO.read(file));
	}

	public void setImage(URL url, int regionX, int regionY, int regionW, int regionH) throws IOException {
		setImage(url);
		region = new Rectangle(regionX, regionY, regionW, regionH);
	}

	public void setImage(File file, int regionX, int regionY, int regionW, int regionH) throws IOException {
		setImage(file);
		region = new Rectangle(regionX, regionY, regionW, regionH);
	}

	public void clearImage() {
		image = null;
		region = null;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D gg = (Graphics2D) g.create();
		gg.setColor(Color.LIGHT_GRAY);
		gg.fillRect(0, 0, getWidth(), getHeight());

		int w = getWidth();
		int h = getHeight();
		float panelRatio = (float) w / (float) h;

		if (image != null && region == null) {
			float imgRatio = (float) image.getWidth() / (float) image.getHeight();

			if (imgRatio > panelRatio) {
				int tw = w;
				int th = (int) (w / imgRatio);
				gg.drawImage(image, 0, (h-th)/2, tw, th, null);
			} else {
				int tw = (int) (h * imgRatio);
				int th = h;
				gg.drawImage(image, (int)(w-tw)/2, 0, tw, th, null);
			}

		} else if (image != null && region != null) {
			float imgRatio = (float) region.width / (float) region.height;

			if (imgRatio > panelRatio) {
				int tw = w;
				int th = (int) (w / imgRatio);
				int tx = 0;
				int ty = (h - th) / 2;
				gg.drawImage(image, tx, ty, tx + tw, ty + th, region.x, region.y, region.x + region.width, region.y + region.width, null);
			} else {
				int tw = (int) (h * imgRatio);
				int th = h;
				int tx = (w - tw) / 2;
				int ty = 0;
				gg.drawImage(image, tx, ty, tx + tw, ty + th, region.x, region.y, region.x + region.width, region.y + region.width, null);
			}
		}

		gg.dispose();
	}
}
