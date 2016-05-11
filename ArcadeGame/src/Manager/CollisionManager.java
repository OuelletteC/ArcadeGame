package Manager;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {

	List<Pixel> illegalPixels = new ArrayList<Pixel>();
	int count = 0;

	Pixel axe;
	Pixel key;

	public CollisionManager() {}

	public void addCoordinates(int x, int y) {
		illegalPixels.add(new Pixel(x, y));
		count++;
	}

	public void addAxeCoordinates(int x, int y) {
		axe = new Pixel(x, y);
	}

	public void addKeyCoordinates(int x, int y) {
		key = new Pixel(x, y);
	}

	public List<Pixel> getIllegalPixels() {
		return illegalPixels;
	}

	public Pixel getAxeCoordinates() {
		return this.axe;
	}
	public Pixel getKeyCoordinates() {
		return this.key;
	}

}
