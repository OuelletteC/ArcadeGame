package GameStateManager;

import java.awt.Graphics;

import Manager.MenuScreen;

public class MenuState extends State {

	private MenuScreen menuScreen = new MenuScreen();

	public MenuState() { }

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		menuScreen.drawMenuScreen(g);
	}

	public MenuScreen getMenu() {
		return this.menuScreen;
	}

}
