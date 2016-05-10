package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Control.Main;

public class KeyManager implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.getPlayer().setYFuture(Main.getPlayer().getY() + Main.TILE);
			Main.getPlayer().setMoveDirection(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.getPlayer().setXFuture(Main.getPlayer().getX() - Main.TILE);
			Main.getPlayer().setMoveDirection(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.getPlayer().setXFuture(Main.getPlayer().getX() + Main.TILE);
			Main.getPlayer().setMoveDirection(2);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.getPlayer().setYFuture(Main.getPlayer().getY() - Main.TILE);
			Main.getPlayer().setMoveDirection(3);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
