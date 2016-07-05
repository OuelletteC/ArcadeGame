package GameStateManager;

import java.awt.Graphics;

import Main.Main;

public class PlayState extends State {

	public PlayState() { }

	@Override
	public void tick() {
		Main.getPlayer().tick();

	}

	@Override
	public void render(Graphics g) {
		Main.getCurrentLevel().drawMap(g);
		Main.getPlayer().render(g);
	}

}
