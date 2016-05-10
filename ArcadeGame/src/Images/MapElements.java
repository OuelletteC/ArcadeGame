package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Control.Main;
import Manager.BufferedImageLoader;

public class MapElements {

	private BufferedImage grass;
	private BufferedImage tree;

	public MapElements() {
		initElements();
	}

	private void initElements() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			// Grass sprite
			spriteSheet = loader.loadImage("grass_sprites.png");
			this.grass = spriteSheet.getSubimage(130, 130, 32, 32);

			spriteSheet = loader.loadImage("tree.png");
			this.tree = spriteSheet.getSubimage(0, 0, 32, 32);

		} catch (IOException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public BufferedImage getGrass() {
		return this.grass;
	}
	public BufferedImage getTree() {
		return this.tree;
	}
}
