package Control;

import java.awt.Graphics;

import GameStateManager.PlayState;
import Images.CharacterImages;
import Main.Main;
import Manager.CreateMap;

public class Character {

	// Size of the characters
	final int HEIGHT = 32, WIDTH = 32;
	public boolean down = false, left = false, right = false, up = false;

	private final int downInt = 1, leftInt = 2, rightInt = 3, upInt = 4;
	private int direction = 1;

	// Controls movement in the X and Y directions
	private int x, y;
	private int xFuture, yFuture;

	// Variables to store whether or not user has these items
	private boolean hasAxe = false, hasKey = false, detonate = false;

	public boolean reset = false;

	// Initialized for level 1
	private int smallBomb = 1, detonatedSmallBomb = 0;

	// Controls player speed
	public static final int SPEED = 4;

	// Stores movement direction so the render method displays the correct sprite
	private int moveDirection = 0;

	// Stores images for specific character
	private CharacterImages characterImages;

	// Load the character with appropriate character number
	public Character (int charNum, int x, int y) {
		characterImages = new CharacterImages(charNum);
		this.x = x;
		this.y = y;
		this.xFuture = x;
		this.yFuture = y;

	}

	// Controls the movement
	public void tick() {

		if (!down && !left && !right && !up) {
			direction = 0;
		}
		if (down && !left && !right && !up) {
			direction = downInt;
		}
		if (left && !down && !right && !up) {
			direction = leftInt;
		}
		if (right && !left && !down && !up) {
			direction = rightInt;
		}
		if (up && !left && !right && !down) {
			direction = upInt;
		}

		// Checks if x or y is different from xFuture and yFuture and updates them at the speed if they are
		if (direction == downInt) {
			if ((x == xFuture) && (y == yFuture)) {

				// new
				if (!(PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getTree()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getSpecialTree()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getDoor()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getWall()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getRockBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getRockBottomOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getRockBottomRight()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getGrassTopLeft()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getGrassTopOnly()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getGrassTopRight()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getRockBottomOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassBottomRight()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)+1].equals(CreateMap.getRock()))) {
							if (!(yFuture + Main.TILES > Main.HEIGHT - Main.TILES)) {
								yFuture += Main.TILES;
							}

				}
				setMoveDirection(Main.DOWN);
			}
		}
		else if (direction == leftInt) {
			if ((this.x == this.xFuture) && (this.y == this.yFuture)) {
				if (!(PlayState.getCurrentLevel().getMapArray()[(x/32)-1][y/32].equals(CreateMap.getTree()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][y/32].equals(CreateMap.getSpecialTree()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)-1][y/32].equals(CreateMap.getDoor()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][y/32].equals(CreateMap.getWall()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getRockBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getRockBottomOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getRockBottomRight()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getGrassTopRight()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getGrassRightOnly()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getGrassBottomRight()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassTopLeft()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassLeftOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[(x/32)-1][(y/32)].equals(CreateMap.getRock()))) {
					if (!(xFuture - Main.TILES < 0)) {
						xFuture -= Main.TILES;
					}
				}
				setMoveDirection(Main.LEFT);
			}
		}
		else if (direction == rightInt) {
			if ((this.x == this.xFuture) && (this.y == this.yFuture)) {
				if (!(PlayState.getCurrentLevel().getMapArray()[(x/32)+1][y/32].equals(CreateMap.getTree()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][y/32].equals(CreateMap.getSpecialTree()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)+1][y/32].equals(CreateMap.getDoor()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][y/32].equals(CreateMap.getWall()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getRockBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getRockBottomOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getRockBottomRight()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getGrassTopLeft()) ||
						PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getGrassLeftOnly()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getGrassBottomLeft()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassTopRight()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassRightOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassBottomRight()) || PlayState.getCurrentLevel().getMapArray()[(x/32)+1][(y/32)].equals(CreateMap.getRock()))) {
					if (!(xFuture + Main.TILES > Main.WIDTH - Main.TILES)) {
						xFuture += Main.TILES;
					}

				}
				setMoveDirection(Main.RIGHT);
			}
		}
		else if (direction == upInt) {
			if ((this.x == this.xFuture) && (this.y == this.yFuture)) {
				if (!(PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getTree()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getSpecialTree()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getDoor()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getWall()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getRockBottomLeft()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getRockBottomOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getRockBottomRight()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getGrassBottomLeft()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getRockBottomOnly()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getGrassBottomRight()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassTopLeft()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassTopOnly()) ||
						PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)].equals(CreateMap.getGrassTopRight()) || PlayState.getCurrentLevel().getMapArray()[x/32][(y/32)-1].equals(CreateMap.getRock()))) {
					if (!(yFuture - Main.TILES < 0)) {
						yFuture -= Main.TILES;
					}
				}
				setMoveDirection(Main.UP);
			}
		}

		// Moves the character
		if (y < yFuture) {
			y += SPEED;
		}
		if (x > xFuture) {
			x -= SPEED;
		}
		if (x < xFuture) {
			x += SPEED;
		}
		if (y > yFuture) {
			y -= SPEED;
		}

		// Axe
		if (PlayState.getCurrentLevel().getMapArray()[x/WIDTH][y/HEIGHT].equals(CreateMap.getAxe())) {
			hasAxe = true;
			PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), x/WIDTH, y/HEIGHT);
		}
		// Key
		if (PlayState.getCurrentLevel().getMapArray()[x/WIDTH][y/HEIGHT].equals(CreateMap.getKey())) {
			hasKey = true;
			PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), x/WIDTH, y/HEIGHT);
		}


		// If a bomb gets detonated
		if (detonate == true) {
			for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
				for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {
					if (PlayState.getCurrentLevel().getMapArray()[i][j].equals(CreateMap.getSmallBomb())) {

						detonatedSmallBomb++;

						// Checking what the bomb removes
						for (int a = i-1; a < i+2; a++) {
							for (int b = j-1; b < j+2; b++) {
								if (PlayState.getCurrentLevel().getMapArray()[a][b].equals(CreateMap.getRock()) ||
										PlayState.getCurrentLevel().getMapArray()[a][b].equals(CreateMap.getSmallBomb())) {
									PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), a, b);
								}
							}
						}
					}

				}
			}
		}

		// If level is passed
		if (PlayState.getCurrentLevel().getMapArray()[this.x/Main.TILES][this.y/Main.TILES].equals(CreateMap.getOpenDoor())) {
			hasAxe = false;
			hasKey = false;
			PlayState.setNextLevel();
			detonatedSmallBomb = 0;
			smallBomb = 0;

			for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
				for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {
					if (PlayState.getCurrentLevel().getMapArray()[i][j].equals(CreateMap.getSmallBombOverlay())) {
						smallBomb++;
					}
				}
			}

		}

		// If level is reset
		if (this.reset == true) {

			PlayState.resetLevel();

			hasAxe = false;
			hasKey = false;
			detonatedSmallBomb = 0;
			smallBomb = 0;

			for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
				for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {
					if (PlayState.getCurrentLevel().getMapArray()[i][j].equals(CreateMap.getSmallBombOverlay())) {
						smallBomb++;
					}
				}
			}

			this.reset = false;
		}

	}

	// Draws the character sprite to the screen
	public void render(Graphics g){

		if (moveDirection == 0) {
			if (this.yFuture - this.y >= 20) {
				g.drawImage(characterImages.getCharacterDown()[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.yFuture - this.y >= 8) {
				g.drawImage(characterImages.getCharacterDown()[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterImages.getCharacterDown()[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}
		else if (moveDirection == 1) {
			if (this.x - this.xFuture >= 20) {
				g.drawImage(characterImages.getCharacterLeft()[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.x - this.xFuture >= 8) {
				g.drawImage(characterImages.getCharacterLeft()[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterImages.getCharacterLeft()[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}
		else if (moveDirection == 2) {
			if (this.xFuture - this.x >= 20) {
				g.drawImage(characterImages.getCharacterRight()[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.xFuture - this.x >= 8) {
				g.drawImage(characterImages.getCharacterRight()[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterImages.getCharacterRight()[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}
		else if (moveDirection == 3) {
			if (this.y - this.yFuture >= 20) {
				g.drawImage(characterImages.getCharacterUp()[0],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else if (this.y - this.yFuture >= 8) {
				g.drawImage(characterImages.getCharacterUp()[2],this.x,this.y,WIDTH,HEIGHT,null);
			}
			else {
				g.drawImage(characterImages.getCharacterUp()[1],this.x,this.y,WIDTH,HEIGHT,null);
			}
		}
	}

	public void openDoor() {



	}

	public void setMoveDirection(int i) {
		this.moveDirection = i;
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getXFuture() {
		return this.xFuture;
	}
	public int getYFuture() {
		return this.yFuture;
	}
	public boolean getHasAxe() {
		return this.hasAxe;
	}
	public boolean getHasKey() {
		return this.hasKey;
	}
	public int getMoveDirection() {
		return this.moveDirection;
	}
	public void decrementSmallBomb() {
		this.smallBomb--;
		PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), PlayState.getCurrentLevel().itemCoordinates.getSmallBombOverlay().get(detonatedSmallBomb).getX(),
				PlayState.getCurrentLevel().itemCoordinates.getSmallBombOverlay().get(detonatedSmallBomb).getY());
	}
	public int getSmallBomb() {
		return this.smallBomb;
	}
	public void setDetonate(boolean i) {
		this.detonate = i;
	}
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		this.xFuture = x;
		this.yFuture = y;
	}

	public void setDirection(int newDirection) {
		if (newDirection >= 1 && newDirection <= 4) {
			this.direction = newDirection;
		}
	}

}
