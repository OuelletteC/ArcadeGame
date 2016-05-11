package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Control.Main;
import Manager.BufferedImageLoader;

public class Items {

	private BufferedImage axe;
	private BufferedImage key;
	private BufferedImage axeOverlay;
	private BufferedImage keyOverlay;

	public Items() {
		initElements();
	}

	private void initElements() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("items.gif");
			this.axe = spriteSheet.getSubimage(32*1, 32*1, 32, 32);
			this.key = spriteSheet.getSubimage(32*2, 32*1, 32, 32);
			this.axeOverlay = spriteSheet.getSubimage(32*1, 32*0, 32, 32);
			this.keyOverlay = spriteSheet.getSubimage(32*2, 32*0, 32, 32);


		} catch (IOException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public BufferedImage getAxe() {
		return this.axe;
	}
	public BufferedImage getKey() {
		return this.key;
	}
	public BufferedImage getAxeOverlay() {
		return this.axeOverlay;
	}
	public BufferedImage getKeyOverlay() {
		return this.keyOverlay;
	}

}
