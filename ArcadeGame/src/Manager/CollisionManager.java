package Manager;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {

	List<Pixel> illegalPixels = new ArrayList<Pixel>();
	int count = 0;

	public CollisionManager() {}

	public void addCoordinates(int x, int y) {
		illegalPixels.add(new Pixel(x, y));
		count++;
	}

	public List<Pixel> getIllegalPixels() {
		return illegalPixels;
	}

}
