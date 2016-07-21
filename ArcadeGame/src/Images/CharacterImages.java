package Images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Main;

public class CharacterImages {

	// Array storing the 4 image directions of the character
		private BufferedImage[] characterDown = new BufferedImage[3];
		private BufferedImage[] characterLeft = new BufferedImage[3];
		private BufferedImage[] characterRight = new BufferedImage[3];
		private BufferedImage[] characterUp = new BufferedImage[3];

		// Loads the sprite and finds the correct location of the character from the character number
		public CharacterImages(int charNum) {

			// For now, if the character num isn't one of these 4, it defaults to 6
			if (!(charNum == 0 || charNum == 3 || charNum == 6 || charNum == 9)) {
				charNum = 6;
			}

			BufferedImageLoader loader = new BufferedImageLoader();
			BufferedImage spriteSheet = null;
			try {
				spriteSheet = loader.loadImage("player_sprites.gif");

			} catch (IOException e) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
			}

			// Works for chars 1 to 4 (only grabbing 4 pictures, down, left, right, up)
			for (int i = 0; i < 3; i++) {
				this.characterDown[i] = spriteSheet.getSubimage((Main.TILES*charNum) + (Main.TILES*i), Main.TILES*0, Main.TILES, Main.TILES);
			}
			for (int i = 0; i < 3; i++) {
				this.characterLeft[i] = spriteSheet.getSubimage(Main.TILES*charNum + Main.TILES*i, Main.TILES*1, Main.TILES, Main.TILES);
			}
			for (int i = 0; i < 3; i++) {
				this.characterRight[i] = spriteSheet.getSubimage(Main.TILES*charNum + Main.TILES*i, Main.TILES*2, Main.TILES, Main.TILES);
			}
			for (int i = 0; i < 3; i++) {
				this.characterUp[i] = spriteSheet.getSubimage(Main.TILES*charNum + Main.TILES*i, Main.TILES*3, Main.TILES, Main.TILES);
			}

		}

		public BufferedImage[] getCharacterDown() {
			return this.characterDown;
		}
		public BufferedImage[] getCharacterLeft() {
			return this.characterLeft;
		}
		public BufferedImage[] getCharacterRight() {
			return this.characterRight;
		}
		public BufferedImage[] getCharacterUp() {
			return this.characterUp;
		}

}
