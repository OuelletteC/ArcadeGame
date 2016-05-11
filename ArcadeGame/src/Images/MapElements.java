package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Main;

public class MapElements {

	private BufferedImage grass;
	private BufferedImage tree;
	private BufferedImage specialTree;
	private BufferedImage grassWithTwill;

	public MapElements() {
		initElements();
	}

	private void initElements() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("tile_set.png");
			this.grass = spriteSheet.getSubimage(32*1, 32*0, 32, 32);
			this.grassWithTwill = spriteSheet.getSubimage(32*2, 32*0, 32, 32);
			this.tree = spriteSheet.getSubimage(32*0, 32*1, 32, 32);
			this.specialTree = spriteSheet.getSubimage(32*1, 32*1, 32, 32);

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
	public BufferedImage getGrassWithTwill() {
		return this.grassWithTwill;
	}
	public BufferedImage getSpecialTree() {
		return this.specialTree;
	}

}
