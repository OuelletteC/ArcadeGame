package Images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Control.Main;
import Manager.BufferedImageLoader;
import Manager.Pixel;

public class Character {

	// Size of the characters
	final int HEIGHT = 32, WIDTH = 32;

	// Controls movement in the X and Y directions
	private int x, y;

	private Pixel coordinates;

	private int xFuture, yFuture;

	private Pixel futureCoordinates;

	private boolean hasAxe = false, hasKey = false;

	// Controls player speed
	private final int SPEED = 2;

	// Array storing the 4 image directions of the character
	private BufferedImage[] characterDown = new BufferedImage[4];
	private BufferedImage[] characterLeft = new BufferedImage[4];
	private BufferedImage[] characterRight = new BufferedImage[4];
	private BufferedImage[] characterUp = new BufferedImage[4];

	// Stores movement direction so the render method displays the correct sprite
	private int moveDirection = 0;

	// Load the character with appropriate character number
	public Character (int charNum, int x, int y) {
		this.x = x;
		this.y = y;
		this.coordinates = new Pixel(x, y);
		this.xFuture = x;
		this.yFuture = y;
		this.futureCoordinates = new Pixel(x, y);
		init(charNum);
	}

	// Loads the sprite and finds the correct location of the character from the character number
	public void init(int charNum) {

		// For now, if the character num isn't one of these 4, it defaults to 1
		if (!(charNum == 0 || charNum == 3 || charNum == 6 || charNum == 9)) {
			charNum = 6;
		}

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("player_sprites_green.png");

		} catch (IOException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}

		// Works for chars 1 to 4 (only grabbing 4 pictures, down, left, right, up)
		for (int i = 0; i < 3; i++) {
			this.characterDown[i] = spriteSheet.getSubimage((WIDTH*charNum) + (WIDTH*i), HEIGHT*0, WIDTH, HEIGHT);
		}
		for (int i = 0; i < 3; i++) {
			this.characterLeft[i] = spriteSheet.getSubimage(WIDTH*charNum + WIDTH*i, HEIGHT*1, WIDTH, HEIGHT);
		}
		for (int i = 0; i < 3; i++) {
			this.characterRight[i] = spriteSheet.getSubimage(WIDTH*charNum + WIDTH*i, HEIGHT*2, WIDTH, HEIGHT);
		}
		for (int i = 0; i < 3; i++) {
			this.characterUp[i] = spriteSheet.getSubimage(WIDTH*charNum + WIDTH*i, HEIGHT*3, WIDTH, HEIGHT);
		}

	}

	// Controls the movement
	public void tick(){

		if (x > xFuture) {
			x -= SPEED;
		}
		else if (x < xFuture) {
			x += SPEED;
		}
		else if (y > yFuture) {
			y -= SPEED;
		}
		else if (y < yFuture) {
			y += SPEED;
		}

		if (this.x == Main.collision.getAxeCoordinates().getX() && this.y == Main.collision.getAxeCoordinates().getY()) {
			hasAxe = true;
		}
		if (this.x == Main.collision.getKeyCoordinates().getX() && this.y == Main.collision.getKeyCoordinates().getY()) {
			hasKey = true;
		}


	}

	// Draws the character sprite to the screen
	public void render(Graphics g){

		if (moveDirection == 0) {
			if (this.yFuture - this.y >= 20) {
				g.drawImage(characterDown[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.yFuture - this.y >= 8) {
				g.drawImage(characterDown[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterDown[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}

		else if (moveDirection == 1) {
			if (this.x - this.xFuture >= 20) {
				g.drawImage(characterLeft[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.x - this.xFuture >= 8) {
				g.drawImage(characterLeft[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterLeft[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}

		else if (moveDirection == 2) {
			if (this.xFuture - this.x >= 20) {
				g.drawImage(characterRight[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.xFuture - this.x >= 8) {
				g.drawImage(characterRight[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterRight[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}

		else if (moveDirection == 3) {
			if (this.y - this.yFuture >= 20) {
				g.drawImage(characterUp[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.y - this.yFuture >= 8) {
				g.drawImage(characterUp[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterUp[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}
	}

	// Checking the new x position against the arraylist containing the coordinates of trees
	public boolean checkIfHorizontalCollision(int futurePosition) {

		for (int i = 0; i < Main.collision.getIllegalPixels().size(); i++) {
			if (this.y == Main.collision.getIllegalPixels().get(i).getY()) {
				if (futurePosition == Main.collision.getIllegalPixels().get(i).getX()) {
					return true;
				}
			}
		}
		return false;
	}

	// Checking the new y position against the arraylist containing the coordinates of trees
	public boolean checkIfVerticalCollision(int futurePosition) {

		for (int i = 0; i < Main.collision.getIllegalPixels().size(); i++) {
			if (this.x == Main.collision.getIllegalPixels().get(i).getX()) {
				if (futurePosition == Main.collision.getIllegalPixels().get(i).getY()) {
					return true;
				}
			}
		}
		return false;
	}

	public void setMoveDirection(int i) {
		this.moveDirection = i;
	}

	// Checks if its a legal move and sets new x value if it is
	public void setXFuture(int i) {
		if ((this.x == this.xFuture) && (this.y == this.yFuture) && !checkIfHorizontalCollision(i)) {
			this.xFuture = i;
		}
	}

	// Checks if the move is legal and sets new y value if it is
	public void setYFuture(int i) {
		if ((this.x == this.xFuture) && (this.y == this.yFuture) && !checkIfVerticalCollision(i)) {
			this.yFuture = i;
		}
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public boolean getHasAxe() {
		return this.hasAxe;
	}
	public boolean getHasKey() {
		return this.hasKey;
	}

}

