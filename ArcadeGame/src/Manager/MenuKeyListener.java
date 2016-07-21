package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameStateManager.State;
import Main.Main;

public class MenuKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		// Controls player movement
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {



		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		/*
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.getPlayer().down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.getPlayer().up = false;
		}
		*/

	}

	@Override
	public void keyTyped(KeyEvent e) { }

}
