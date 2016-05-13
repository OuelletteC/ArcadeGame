package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Main;

public class KeyManager implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		// Controls player movement
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.getPlayer().down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.getPlayer().left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.getPlayer().right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.getPlayer().up = true;
		}
		// For key "A", check if the player has the axe, and if they are facing a special tree
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (Main.getPlayer().getHasAxe() == true) {
				if (Main.getPlayer().getMoveDirection() == Main.DOWN) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals("S")) {
						Main.getCurrentLevel().setMapArray("G", Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)+1);
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.LEFT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals("S")) {
						Main.getCurrentLevel().setMapArray("G", (Main.getPlayer().getX()/32)-1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)+1][(Main.getPlayer().getY()/32)].equals("S")) {
						Main.getCurrentLevel().setMapArray("G", (Main.getPlayer().getX()/32)+1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.UP) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)-1].equals("S")) {
						Main.getCurrentLevel().setMapArray("G", Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)-1);
					}
				}
			}
		}
		// For key "K", check if the player has the key, and if they are facing a door
		if (e.getKeyCode() == KeyEvent.VK_K) {
			if (Main.getPlayer().getHasKey() == true) {
				if (Main.getPlayer().getMoveDirection() == Main.DOWN) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals("D")) {
						Main.getCurrentLevel().setMapArray("O", Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)+1);
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.LEFT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals("D")) {
						Main.getCurrentLevel().setMapArray("O", (Main.getPlayer().getX()/32)-1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)+1][(Main.getPlayer().getY()/32)].equals("D")) {
						Main.getCurrentLevel().setMapArray("O", (Main.getPlayer().getX()/32)+1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.UP) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)-1].equals("D")) {
						Main.getCurrentLevel().setMapArray("O", Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)-1);
					}
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.getPlayer().down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.getPlayer().left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.getPlayer().right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.getPlayer().up = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { }

}
