package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class WinScreenImage {

	private BufferedImage winScreen;

	public WinScreenImage() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;

		try {
			spriteSheet = loader.loadImage("win-screen.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		winScreen = spriteSheet.getSubimage(32*0, 32*0, 960, 640);
	}

	public BufferedImage getWinScreen(){
		return this.winScreen;
	}

}
