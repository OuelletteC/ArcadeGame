package GameStateManager;

import java.awt.Graphics;

import Manager.WinScreen;

public class WinState extends State {

	WinScreen winScreen = new WinScreen();

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		winScreen.drawWinScreen(g);

	}

}
