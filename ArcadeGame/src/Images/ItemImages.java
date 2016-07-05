package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Main;

public class ItemImages {

	private BufferedImage axe;
	private BufferedImage key;
	private BufferedImage axeOverlay;
	private BufferedImage keyOverlay;
	private BufferedImage[] smallBomb = new BufferedImage[4];
	private BufferedImage bigBomb;
	private BufferedImage smallBombOverlay;
	private BufferedImage bigBombOverlay;

	public ItemImages() {
		initElements();
	}

	private void initElements() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("boataxekey.gif");
			this.axe = spriteSheet.getSubimage(32*1, 32*1, 32, 32);
			this.key = spriteSheet.getSubimage(32*2, 32*1, 32, 32);
			this.axeOverlay = spriteSheet.getSubimage(32*1, 32*0, 32, 32);
			this.keyOverlay = spriteSheet.getSubimage(32*2, 32*0, 32, 32);

			spriteSheet = loader.loadImage("bomb.gif");
			this.smallBomb[0] = spriteSheet.getSubimage(32*0, 32*0, 32, 32);
			this.smallBomb[1] = spriteSheet.getSubimage(32*0, 32*1, 32, 32);
			this.smallBomb[2] = spriteSheet.getSubimage(32*1, 32*1, 32, 32);
			this.smallBomb[3] = spriteSheet.getSubimage(32*2, 32*1, 32, 32);

			spriteSheet = loader.loadImage("bomb_overlay.gif");
			smallBombOverlay = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

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
	public BufferedImage[] getSmallBomb() {
		return this.smallBomb;
	}
	public BufferedImage getBigBomb() {
		return this.bigBomb;
	}
	public BufferedImage getSmallBombOverlay() {
		return this.smallBombOverlay;
	}
	public BufferedImage getBigBombOverlay() {
		return this.bigBombOverlay;
	}

}
