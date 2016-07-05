package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuImage {

	private BufferedImage menuBackground;
	private BufferedImage arrow;
	private BufferedImage menu;
	private BufferedImage gameTitle;

	public MenuImage(){
		init();
	}

	public void init() {
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;


		try {
			spriteSheet = loader.loadImage("menubackground.gif");
			this.menuBackground = spriteSheet.getSubimage(0, 0, 960, 640);

			spriteSheet = loader.loadImage("arrow.gif");
			this.arrow = spriteSheet.getSubimage(0, 0, 50, 50);

			spriteSheet = loader.loadImage("menu.gif");
			this.menu = spriteSheet.getSubimage(0, 0, 400, 230);

			spriteSheet = loader.loadImage("gametitle.gif");
			this.gameTitle = spriteSheet.getSubimage(0, 0, 500, 80);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedImage getMenuBackground() {
		return this.menuBackground;
	}
	public BufferedImage getArrow() {
		return this.arrow;
	}
	public BufferedImage getMenu() {
		return this.menu;
	}
	public BufferedImage getGameTitle() {
		return this.gameTitle;
	}

}
