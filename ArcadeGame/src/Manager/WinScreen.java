package Manager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Images.BufferedImageLoader;
import Images.WinScreenImage;

public class WinScreen {

	WinScreenImage winScreen = new WinScreenImage();

	public WinScreen() { }

	public void drawWinScreen(Graphics g) {
		g.drawImage(winScreen.getWinScreen(), 0, 0, null);
	}

}
