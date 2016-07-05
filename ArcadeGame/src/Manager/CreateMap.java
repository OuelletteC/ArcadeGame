package Manager;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Images.ItemImages;
import Images.MapElements;
import Main.Main;

public class CreateMap {

	public static MapElements mapElements = new MapElements();
	private ItemImages items = new ItemImages();
	private String[][] mapArray = new String[Main.TILES_IN_WIDTH][Main.TILES_IN_HEIGHT];
	private String newLine;
	private BufferedReader br = null;
	public ItemCoordinates itemCoordinates;
	private static final String tree = "TTT", specialTree = "SSS", axe = "AXE", key = "KEY", door = "DDD", wall = "WWW", rockBottomLeft = "RBL",
			rockBottomOnly = "RBO", rockBottomRight = "RBR", grassTopLeft = "GTL", grassTopOnly = "GTO", grassTopRight = "GTR",
			grassLeftOnly = "GLO", grass = "GGG", grassRightOnly = "GRO", grassBottomLeft = "GBL", grassBottomOnly = "GBO", grassBottomRight = "GBR",
			smallBomb = "SMB", openDoor = "OOO", playerSpawn = "PPP", emptyInventory= "EEE", smallBombOverlay = "SBO", horizontalFence = "HFF",
			verticalFence = "WWW", rock = "RRR", water = "WWW", rockWaterLeft = "RWL", rockWaterTop = "RWT", rockWaterRight ="RWR",
			grassWaterLeft = "GWL", grassWaterTop = "GWT", grassWaterRight = "GWR", steps = "STP", cave = "CVE", axeOverlay = "AOV",
			keyOverlay = "KOV";

	private long startTime = System.nanoTime();
	private long currentTime = 0;


	// Creates the map with the given map number
	// Also calls item coordinates which stores coordinates to each item in a pixel array
	public CreateMap(int mapNumber) throws IOException {

		br = new BufferedReader(new InputStreamReader(CreateMap.class.getResourceAsStream("level" + mapNumber + ".txt")));

		int horizontalCount = 0;
		while ((newLine = br.readLine()) != null) {

			String[] line = newLine.split(" ");

			for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
				mapArray[i][horizontalCount] = line[i];
			}

			horizontalCount++;
		}

		itemCoordinates = new ItemCoordinates(mapArray);

		// Finds player spawn point
		for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
			for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {
				if (mapArray[i][j].equals(playerSpawn)) {
					Main.getPlayer().setLocation(i*Main.TILES, j*Main.TILES);
				}
			}
		}

	}

	public void drawMap(Graphics g) {

		for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
			for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {

				// Drawing grass on every square
				g.drawImage(mapElements.getGrassArray()[1][1], 32*i, 32*j, null);


				if (mapArray[i][j].equals(grassTopLeft)) {

					g.drawImage(mapElements.getGrassArray()[0][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassTopOnly)) {

					g.drawImage(mapElements.getGrassArray()[1][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassTopRight)) {

					g.drawImage(mapElements.getGrassArray()[2][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassLeftOnly)) {

					g.drawImage(mapElements.getGrassArray()[0][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grass)) {

					g.drawImage(mapElements.getGrassArray()[1][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassRightOnly)) {

					g.drawImage(mapElements.getGrassArray()[2][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassBottomLeft)) {

					g.drawImage(mapElements.getGrassArray()[0][2], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassBottomOnly)) {

					g.drawImage(mapElements.getGrassArray()[1][2], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(grassBottomRight)) {

					g.drawImage(mapElements.getGrassArray()[2][2], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RTL")) {

					g.drawImage(mapElements.getRockWallArray()[0][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RTO")) {

					g.drawImage(mapElements.getRockWallArray()[1][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RTR")) {

					g.drawImage(mapElements.getRockWallArray()[2][0], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RLO")) {

					g.drawImage(mapElements.getRockWallArray()[0][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RCO")) {

					g.drawImage(mapElements.getRockWallArray()[1][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals("RRO")) {

					g.drawImage(mapElements.getRockWallArray()[2][1], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(rockBottomLeft)) {

					g.drawImage(mapElements.getRockWallArray()[0][2], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(rockBottomOnly)) {

					g.drawImage(mapElements.getRockWallArray()[1][2], 32*i, 32*j, null);
				}
				else if (mapArray[i][j].equals(rockBottomRight)) {

					g.drawImage(mapElements.getRockWallArray()[2][2], 32*i, 32*j, null);
				}
				// A represents an axe
				else if (mapArray[i][j].equals(axe)) {
					if (Main.getPlayer().getHasAxe()) {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(items.getAxe(), 32*i, 32*j, null);
					}
				}
				// K represents a key
				else if (mapArray[i][j].equals(key)) {
					if (Main.getPlayer().getHasKey()) {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(items.getKey(), 32*i, 32*j, null);
					}
				}
				// TTT represents a tree
				else if (mapArray[i][j].equals(tree)) {
					g.drawImage(mapElements.getTree(), 32*i, 32*j, null);
				}
				// SSS represents a special tree
				else if (mapArray[i][j].equals(specialTree)) {
					g.drawImage(mapElements.getSpecialTree(), 32*i, 32*j, null);
				}
				// HFF represents a horizontalFence
				else if (mapArray[i][j].equals(horizontalFence)) {
					g.drawImage(mapElements.getHorizontalFence(), 32*i, 32*j, null);
				}
				// WWW represents a vertical fence
				else if (mapArray[i][j].equals(verticalFence)) {
					g.drawImage(mapElements.getVerticalFence(), 32*i, 32*j, null);
				}
				// DDD represents a door
				else if (mapArray[i][j].equals(door)) {
					g.drawImage(mapElements.getDoor()[0], 32*i, 32*j, null);
				}
				// O represents an open door
				else if (mapArray[i][j].equals(openDoor)) {
					g.drawImage(mapElements.getDoor()[2], 32*i, 32*j, null);
				}
				// SMB represents small bomb
				else if (mapArray[i][j].equals(smallBomb)) {
					g.drawImage(items.getSmallBomb()[0], 32*i, 32*j, null);
				}
				// SBO represents small bomb overlay
				else if (mapArray[i][j].equals(smallBombOverlay)) {
					g.drawImage(items.getSmallBomb()[0], 32*i, 32*j, null);
				}
				// RRR represents a rock
				else if (mapArray[i][j].equals(rock)) {
					g.drawImage(mapElements.getRock(), 32*i, 32*j, null);
				}
				// STP represents steps
				else if (mapArray[i][j].equals(steps)) {
					g.drawImage(mapElements.getSteps(), 32*i, 32*j, null);
				}
				// CVE represents a cave
				else if (mapArray[i][j].equals(cave)) {
					g.drawImage(mapElements.getCave(), 32*i, 32*j, null);
				}

				// AOV represents the placeholder for the axe overlay
				else if (mapArray[i][j].equals(axeOverlay)) {
					if (Main.getPlayer().getHasAxe()) {
						g.drawImage(items.getAxe(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
				}
				// KOV represents the placeholder for the key overlay
				else if (mapArray[i][j].equals(keyOverlay)) {
					if (Main.getPlayer().getHasKey()) {
						g.drawImage(items.getKey(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
				}

			}
		}

	}

	public void drawTime(Graphics g) {

		currentTime = System.nanoTime() - startTime;

		long time;

		time = currentTime / 100000000;
		time = time % 10000;

		int minutes = (int)time / 1000;
		int seconds = (int)time % 1000;
		seconds = seconds / 10;
		int miliseconds = (int)time % 10;

		//System.out.println(seconds + "." + miliseconds);

	}

	public void drawControls(Graphics g) {
		g.drawImage(mapElements.getControls(), 237, 195, null);
	}

	public void setMapArray(String i, int x, int y) {
		mapArray[x][y] = i;
	}
	public String[][] getMapArray() {
		return mapArray;
	}

	public static String getTree() {
		return tree;
	}

	public static String getSpecialTree() {
		return specialTree;
	}

	public static String getAxe() {
		return axe;
	}

	public static String getKey() {
		return key;
	}

	public static String getDoor() {
		return door;
	}

	public static String getWall() {
		return wall;
	}
	public static String getRockBottomLeft() {
		return rockBottomLeft;
	}

	public static String getRockBottomOnly() {
		return rockBottomOnly;
	}

	public static String getRockBottomRight() {
		return rockBottomRight;
	}

	public static String getGrassTopLeft() {
		return grassTopLeft;
	}

	public static String getGrassTopOnly() {
		return grassTopOnly;
	}

	public static String getGrassTopRight() {
		return grassTopRight;
	}

	public static String getGrassLeftOnly() {
		return grassLeftOnly;
	}

	public static String getGrass() {
		return grass;
	}

	public static String getGrassRightOnly() {
		return grassRightOnly;
	}

	public static String getGrassBottomLeft() {
		return grassBottomLeft;
	}

	public static String getGrassBottomOnly() {
		return grassBottomOnly;
	}

	public static String getGrassBottomRight() {
		return grassBottomRight;
	}
	public static String getSmallBomb() {
		return smallBomb;
	}
	public static String getOpenDoor() {
		return openDoor;
	}
	public static String getPlayerSpawn() {
		return playerSpawn;
	}
	//public static String getEmptyInventory() {
		//return emptyInventory;
	//}
	public static String getSmallBombOverlay() {
		return smallBombOverlay;
	}
	public static String getRock() {
		return rock;
	}

	public static String getWater() {
		return water;
	}

	public static String getRockwaterleft() {
		return rockWaterLeft;
	}

	public static String getRockwatertop() {
		return rockWaterTop;
	}

	public static String getRockwaterright() {
		return rockWaterRight;
	}

	public static String getGrasswaterleft() {
		return grassWaterLeft;
	}

	public static String getGrasswatertop() {
		return grassWaterTop;
	}

	public static String getGrasswaterright() {
		return grassWaterRight;
	}

}
