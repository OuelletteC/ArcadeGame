package GameStateManager;

import java.awt.Graphics;

public abstract class State {

	private static State state = null;

	public static void setState(State newState) {
		state = newState;
	}

	public static State getState() {
		return state;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
