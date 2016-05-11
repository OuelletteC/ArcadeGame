package Manager;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Images.ItemImages;
import Images.MapElements;
import Main.Main;

public class CreateMap {

	private MapElements mapElements = Main.getMapElements();
	private ItemImages items = Main.getItemImages();
	private String[][] mapArray = new String[Main.TILES_IN_WIDTH][Main.TILES_IN_HEIGHT];
	private String newLine;
	private BufferedReader br = null;
	public ItemCoordinates itemCoordinates;

	// Creates the map with the given map number
	// Also calls item coordinates which stores coordinates to each item in a pixel array
	public CreateMap(int mapNumber) throws IOException {

		try {
			String absolute = new File("").getAbsolutePath();
			br = new BufferedReader(new FileReader(absolute + "/resources/level" + mapNumber + ".txt"));
		} catch (IOException e) {
			System.out.println("Failed to create map");
		}

		int horizontalCount = 0;
		while ((newLine = br.readLine()) != null) {

			String[] line = newLine.split(" ");

			for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
				mapArray[i][horizontalCount] = line[i];
			}

			horizontalCount++;
		}

		itemCoordinates = new ItemCoordinates(mapArray);
	}

	//  Draws the map to the screen using the 2D string array
	public void drawMap(Graphics g) {

		for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
			for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {

				// G represents grass
				if (mapArray[i][j].equals("G")) {
					g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
				}
				// R represents grass with twill
				else if (mapArray[i][j].equals("R")) {
					g.drawImage(mapElements.getGrassWithTwill(), 32*i, 32*j, null);
				}
				// D represents a door
				else if (mapArray[i][j].equals("D")) {
					g.drawImage(items.getDoor()[0], 32*i, 32*j, null);
				}
				// A represents an axe
				else if (mapArray[i][j].equals("A")) {
					if (Main.getPlayer().getHasAxe()) {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(items.getAxe(), 32*i, 32*j, null);
					}
				}
				// K represents a key
				else if (mapArray[i][j].equals("K")) {
					if (Main.getPlayer().getHasKey()) {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(items.getKey(), 32*i, 32*j, null);
					}
				}
				// X represents the placeholder for the axe overlay
				else if (mapArray[i][j].equals("X")) {
					if (Main.getPlayer().getHasAxe()) {
						g.drawImage(items.getAxeOverlay(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
				}
				// E represents the placeholder for the key overlay
				else if (mapArray[i][j].equals("E")) {
					if (Main.getPlayer().getHasKey()) {
						g.drawImage(items.getKeyOverlay(), 32*i, 32*j, null);
					}
					else {
						g.drawImage(mapElements.getGrass(), 32*i, 32*j, null);
					}
				}
				// T represents a tree
				else if (mapArray[i][j].equals("T")) {
					g.drawImage(mapElements.getTree(), 32*i, 32*j, null);
				}
				// S represents a special tree
				else if (mapArray[i][j].equals("S")) {
					g.drawImage(mapElements.getSpecialTree(), 32*i, 32*j, null);
				}
			}
		}
	}

}
