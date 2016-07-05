package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameStateManager.State;
import Main.Main;

public class KeyManager implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		if (State.getState() == Main.playState) {

			// Controls player 1 movement
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Main.getPlayer().down = true;
				Main.getPlayer().setDirection(1);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Main.getPlayer().left = true;
				Main.getPlayer().setDirection(2);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Main.getPlayer().right = true;
				Main.getPlayer().setDirection(3);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Main.getPlayer().up = true;
				Main.getPlayer().setDirection(4);
			}
		}
		else if (State.getState() == Main.menuState) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Main.menuState.getMenu().moveDown();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Main.menuState.getMenu().moveUp();
			}
		}

		// For key "A", check if the player has the axe, and if they are facing a special tree
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (Main.getPlayer().getHasAxe() == true) {
				if (Main.getPlayer().getMoveDirection() == Main.DOWN) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals(CreateMap.getSpecialTree())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getGrass(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)+1);
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.LEFT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals(CreateMap.getSpecialTree())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getGrass(), (Main.getPlayer().getX()/32)-1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)+1][(Main.getPlayer().getY()/32)].equals(CreateMap.getSpecialTree())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getGrass(), (Main.getPlayer().getX()/32)+1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.UP) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)-1].equals(CreateMap.getSpecialTree())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getGrass(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)-1);
					}
				}
			}
		}
		// For key "K", check if the player has the key, and if they are facing a door
		if (e.getKeyCode() == KeyEvent.VK_K) {
			if (Main.getPlayer().getHasKey() == true) {
				if (Main.getPlayer().getMoveDirection() == Main.DOWN) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals(CreateMap.getDoor())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)+1);
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.LEFT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals(CreateMap.getDoor())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), (Main.getPlayer().getX()/32)-1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)+1][(Main.getPlayer().getY()/32)].equals(CreateMap.getDoor())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), (Main.getPlayer().getX()/32)+1, (Main.getPlayer().getY()/32));
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.UP) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)-1].equals(CreateMap.getDoor())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)-1);
					}
				}
			}
		}

		// Detonate bombs
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.getPlayer().setDetonate(true);
		}
		// Place small bomb
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (Main.getPlayer().getSmallBomb() > 0) {
				if (Main.getPlayer().getMoveDirection() == Main.DOWN) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals(CreateMap.getGrass()) ||
							Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)+1].equals("R")) {
						Main.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)+1);
						Main.getPlayer().decrementSmallBomb();
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.LEFT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals(CreateMap.getGrass()) ||
							Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)-1][(Main.getPlayer().getY()/32)].equals("R")) {
						Main.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), (Main.getPlayer().getX()/32)-1, (Main.getPlayer().getY()/32));
						Main.getPlayer().decrementSmallBomb();
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (Main.getCurrentLevel().getMapArray()[(Main.getPlayer().getX()/32)+1][(Main.getPlayer().getY()/32)].equals(CreateMap.getGrass())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), (Main.getPlayer().getX()/32)+1, (Main.getPlayer().getY()/32));
						Main.getPlayer().decrementSmallBomb();
					}
				}
				else if (Main.getPlayer().getMoveDirection() == Main.UP) {
					if (Main.getCurrentLevel().getMapArray()[Main.getPlayer().getX()/32][(Main.getPlayer().getY()/32)-1].equals(CreateMap.getGrass())) {
						Main.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), Main.getPlayer().getX()/32, (Main.getPlayer().getY()/32)-1);
						Main.getPlayer().decrementSmallBomb();
					}
				}
			}
		}
		// R to reset level
		if (e.getKeyCode() == KeyEvent.VK_R) {
			Main.getPlayer().reset = true;
		}

		// To bring up controls menu
		if (e.getKeyCode() == KeyEvent.VK_C) {

			if (State.getState() == Main.playState) {
				State.setState(Main.pauseState);
			}
			else {
				State.setState(Main.playState);
			}

		}

		// Press enter
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			// Start game
			if (Main.menuState.getMenu().getSelected() == 1) {
				State.setState(Main.playState);
			}
			// Character select
			else if (Main.menuState.getMenu().getSelected() == 2) {

			}
			// Items
			else if (Main.menuState.getMenu().getSelected() == 3) {

			}
			// Controls
			else if (Main.menuState.getMenu().getSelected() == 4) {

			}

		}
		// Press Escape
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			State.setState(Main.menuState);
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.getPlayer().setDetonate(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) { }

}
