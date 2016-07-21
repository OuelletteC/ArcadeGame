package GameStateManager;

import java.awt.Graphics;

import Main.Main;

public class PauseState extends State {

	@Override
	public void tick() {


	}

	@Override
	public void render(Graphics g) {

		//Main.getCurrentLevel().drawMap(g);
		//Main.getPlayer().render(g);
		PlayState.getCurrentLevel().drawControls(g);

	}

}
