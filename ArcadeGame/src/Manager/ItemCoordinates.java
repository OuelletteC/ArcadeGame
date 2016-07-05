package Manager;

import java.util.ArrayList;
import java.util.List;

import Main.Main;

public class ItemCoordinates {

	Pixel axe;
	Pixel key;
	Pixel door;
	List<Pixel> tree = new ArrayList<Pixel>();
	List<Pixel> specialTree = new ArrayList<Pixel>();
	List<Pixel> smallBombOverlay = new ArrayList<Pixel>();

	public ItemCoordinates(String[][] mapArray) {
		checkItemPositions(mapArray);
	}

	public void checkItemPositions(String[][] mapArray) {

		for (int i = 0; i < Main.TILES_IN_WIDTH; i++) {
			for (int j = 0; j < Main.TILES_IN_HEIGHT; j++) {

				if (mapArray[i][j].equals("A")) {
					axe = new Pixel(i*Main.TILES, j*Main.TILES);
				}
				if (mapArray[i][j].equals("K")) {
					key = new Pixel(i*Main.TILES, j*Main.TILES);
				}
				if (mapArray[i][j].equals("D")) {
					door = new Pixel(i*Main.TILES, j*Main.TILES);
				}
				if (mapArray[i][j].equals("T")) {
					tree.add(new Pixel(i*Main.TILES, j*Main.TILES));
				}
				if (mapArray[i][j].equals("S")) {
					specialTree.add(new Pixel(i*Main.TILES, j*Main.TILES));
				}

				if (mapArray[i][j].equals("SBO")) {
					smallBombOverlay.add(new Pixel(i, j));
				}
			}
		}
	}

	public Pixel getAxeCoordinates() {
		return this.axe;
	}
	public Pixel getKeyCoordinates() {
		return this.key;
	}
	public Pixel getDoorCoordinates() {
		return this.door;
	}
	public List<Pixel> getTreeCoordinates() {
		return tree;
	}
	public List<Pixel> getSpecialTreeCoordinates() {
		return specialTree;
	}
	public List<Pixel> getSmallBombOverlay() {
		return smallBombOverlay;
	}

}
