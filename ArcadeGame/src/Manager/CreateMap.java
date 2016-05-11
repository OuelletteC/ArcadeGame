package Manager;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Control.Main;
import Images.MapElements;

public class CreateMap {

	MapElements me = new MapElements();

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

			if (line[i].equals("G")) {
				g.drawImage(me.getGrass(), 32*i, 32*horizontalCount, null);
			}
			else if (line[i].equals("S")) {
				g.drawImage(me.getGrassWithTwill(), 32*i, 32*horizontalCount, null);
			}
			else if (line[i].equals("T")) {
				g.drawImage(me.getTree(), 32*i, 32*horizontalCount, null);

				// Adding coordinates of trees to illegal coordinates array
				Main.collision.addCoordinates(32*i, 32*horizontalCount);
			}
			else if (line[i].equals("R")) {
				g.drawImage(me.getSpecialTree(), 32*i, 32*horizontalCount, null);

				// Adding coordinates of trees to illegal coordinates array
				Main.collision.addCoordinates(32*i, 32*horizontalCount);
			}
		}
	}

}
