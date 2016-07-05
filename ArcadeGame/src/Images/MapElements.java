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
	private BufferedImage[] door = new BufferedImage[4];
	private BufferedImage emptyInventorySpace;
	private BufferedImage inventoryOutline;
	private BufferedImage controls;
	private BufferedImage[][] grassArray = new BufferedImage[3][3];
	private BufferedImage[][] rockWallArray = new BufferedImage[3][3];
	private BufferedImage horizontalFence;
	private BufferedImage verticalFence;
	private BufferedImage rock;
	private BufferedImage rockWithGrass;
	private BufferedImage water;
	private BufferedImage[] waterAndRock = new BufferedImage[3];
	private BufferedImage[] grassWithWater = new BufferedImage[3];
	private BufferedImage steps;
	private BufferedImage cave;

	public MapElements() {
		initElements();
	}

	private void initElements() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("specialtree.gif");
			specialTree = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("doors.gif");
			for (int i = 0; i < 4; i++) {
				door[i] = spriteSheet.getSubimage(32*0, 32*i, 32, 32);
			}

			spriteSheet = loader.loadImage("empty_item.gif");
			emptyInventorySpace = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("controls.gif");
			controls = spriteSheet.getSubimage(32*0, 32*0, 475, 250);

			spriteSheet = loader.loadImage("tree.gif");
			tree = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("grass.gif");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					grassArray[i][j] = spriteSheet.getSubimage(32*i, 32*j, 32, 32);
				}
			}

			spriteSheet = loader.loadImage("rockwall.gif");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rockWallArray[i][j] = spriteSheet.getSubimage(32*i, 32*j, 32, 32);
				}
			}

			spriteSheet = loader.loadImage("water.gif");
			water = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("plainrock.gif");
			rock = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("rockbehindgrass.gif");
			rockWithGrass = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("waterandrock.gif");
			for (int i = 0; i < 3; i++) {
				waterAndRock[i] = spriteSheet.getSubimage(32*i, 0, 32, 32);
			}

			spriteSheet = loader.loadImage("grasswithwater.gif");
			for (int i = 0; i < 3; i++) {
				grassWithWater[i] = spriteSheet.getSubimage(32*i, 0, 32, 32);
			}

			spriteSheet = loader.loadImage("steps.gif");
			steps = spriteSheet.getSubimage(32*0, 32*0, 32, 32);

			spriteSheet = loader.loadImage("cave.gif");
			cave = spriteSheet.getSubimage(32*0, 32*0, 32, 32);



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
	public BufferedImage[] getDoor() {
		return this.door;
	}
	//public BufferedImage getEmptyInventorySpace() {
		//return this.emptyInventorySpace;
	//}
	public BufferedImage getInventoryOutline() {
		return this.inventoryOutline;
	}

	public BufferedImage getControls() {
		return this.controls;
	}
	public BufferedImage[][] getGrassArray() {
		return this.grassArray;
	}
	public BufferedImage[][] getRockWallArray() {
		return this.rockWallArray;
	}
	public BufferedImage getHorizontalFence() {
		return this.horizontalFence;
	}
	public BufferedImage getVerticalFence() {
		return this.verticalFence;
	}
	public BufferedImage getRock() {
		return rock;
	}
	public BufferedImage getRockWithGrass() {
		return rockWithGrass;
	}

	public BufferedImage getWater() {
		return water;
	}
	public BufferedImage[] getWaterAndRock() {
		return waterAndRock;
	}
	public BufferedImage[] getGrassWithWater() {
		return grassWithWater;
	}
	public BufferedImage getSteps() {
		return steps;
	}
	public BufferedImage getCave() {
		return cave;
	}

}
