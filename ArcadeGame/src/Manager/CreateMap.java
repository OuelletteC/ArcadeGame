package Manager;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Control.Main;
import Images.Items;
import Images.MapElements;

public class CreateMap {

	MapElements me = new MapElements();
	Items items = new Items();

	public CreateMap(Graphics g) throws IOException {

		String newLine;
		BufferedReader br = null;

		try {
			String absolute = new File("").getAbsolutePath();
			br = new BufferedReader(new FileReader(absolute + "/resources/testmap.txt"));
		} catch (IOException e) {
			System.out.println("Failed to create map");
		}


		int horizontalCount = 0;
		while ((newLine = br.readLine()) != null) {

			String[] line = newLine.split(" ");
			draw(line, g, horizontalCount);
			horizontalCount++;
		}

	}

	public void draw(String[] line, Graphics g, int horizontalCount) {

		for (int i = 0; i < 30; i++) {

			// G represents grass
			if (line[i].equals("G")) {
				g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
			}
			// S represents a special tree
			else if (line[i].equals("R")) {
				g.drawImage(me.getGrassWithTwill(), 32*i, 32*horizontalCount, null);
			}
			// A represents an axe
			else if (line[i].equals("A")) {
				Main.collision.addAxeCoordinates(32*i, 32*horizontalCount);
				if (Main.player.getHasAxe()) {
					g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
				}
				else {
					g.drawImage(items.getAxe(), 32*i, 32*horizontalCount, null);
				}
			}
			// K represents a key
			else if (line[i].equals("K")) {
				Main.collision.addKeyCoordinates(32*i, 32*horizontalCount);
				if (Main.player.getHasKey()) {
					g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
				}
				else {
					g.drawImage(items.getKey(), 32*i, 32*horizontalCount, null);
				}
			}
			// X represents the placeholder for the axe overlay
			else if (line[i].equals("X")) {
				if (Main.player.getHasAxe()) {
					g.drawImage(items.getAxeOverlay(), 32*i, 32*horizontalCount, null);
				}
				else {
					g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
				}
			}
			// E represents the placeholder for the key overlay
			else if (line[i].equals("E")) {
				if (Main.player.getHasKey()) {
					g.drawImage(items.getKeyOverlay(), 32*i, 32*horizontalCount, null);
				}
				else {
					g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
				}
			}
			// T represents a tree
			else if (line[i].equals("T")) {
				g.drawImage(me.getTree(), 32*i, 32*horizontalCount, null);

				// Adding coordinates of trees to illegal coordinates array
				Main.collision.addCoordinates(32*i, 32*horizontalCount);
			}
			// S represents a special tree
			else if (line[i].equals("S")) {
				g.drawImage(me.getSpecialTree(), 32*i, 32*horizontalCount, null);

				// Adding coordinates of trees to illegal coordinates array
				Main.collision.addCoordinates(32*i, 32*horizontalCount);
			}
		}
	}

}
