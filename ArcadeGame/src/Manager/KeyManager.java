package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameStateManager.State;
import Main.Main;
import GameStateManager.PlayState;

public class KeyManager implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		if (State.getState() == Main.playState) {

			// Controls player 1 movement
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				PlayState.getPlayer().down = true;
				PlayState.getPlayer().setDirection(1);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				PlayState.getPlayer().left = true;
				PlayState.getPlayer().setDirection(2);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				PlayState.getPlayer().right = true;
				PlayState.getPlayer().setDirection(3);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				PlayState.getPlayer().up = true;
				PlayState.getPlayer().setDirection(4);
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
			if (PlayState.getPlayer().getHasAxe() == true) {
				if (PlayState.getPlayer().getMoveDirection() == Main.DOWN) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)+1].equals(CreateMap.getSpecialTree())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)+1);
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.LEFT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)-1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getSpecialTree())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), (PlayState.getPlayer().getX()/32)-1, (PlayState.getPlayer().getY()/32));
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)+1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getSpecialTree())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), (PlayState.getPlayer().getX()/32)+1, (PlayState.getPlayer().getY()/32));
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.UP) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)-1].equals(CreateMap.getSpecialTree())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getGrass(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)-1);
					}
				}
			}
		}
		// For key "K", check if the player has the key, and if they are facing a door
		if (e.getKeyCode() == KeyEvent.VK_K) {
			if (PlayState.getPlayer().getHasKey() == true) {
				if (PlayState.getPlayer().getMoveDirection() == Main.DOWN) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)+1].equals(CreateMap.getDoor())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)+1);
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.LEFT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)-1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getDoor())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), (PlayState.getPlayer().getX()/32)-1, (PlayState.getPlayer().getY()/32));
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)+1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getDoor())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), (PlayState.getPlayer().getX()/32)+1, (PlayState.getPlayer().getY()/32));
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.UP) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)-1].equals(CreateMap.getDoor())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getOpenDoor(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)-1);
					}
				}
			}
		}

		// Detonate bombs
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			PlayState.getPlayer().setDetonate(true);
		}
		// Place small bomb
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (PlayState.getPlayer().getSmallBomb() > 0) {
				if (PlayState.getPlayer().getMoveDirection() == Main.DOWN) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)+1].equals(CreateMap.getGrass()) ||
							PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)+1].equals("R")) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)+1);
						PlayState.getPlayer().decrementSmallBomb();
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.LEFT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)-1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getGrass()) ||
							PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)-1][(PlayState.getPlayer().getY()/32)].equals("R")) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), (PlayState.getPlayer().getX()/32)-1, (PlayState.getPlayer().getY()/32));
						PlayState.getPlayer().decrementSmallBomb();
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.RIGHT) {
					if (PlayState.getCurrentLevel().getMapArray()[(PlayState.getPlayer().getX()/32)+1][(PlayState.getPlayer().getY()/32)].equals(CreateMap.getGrass())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), (PlayState.getPlayer().getX()/32)+1, (PlayState.getPlayer().getY()/32));
						PlayState.getPlayer().decrementSmallBomb();
					}
				}
				else if (PlayState.getPlayer().getMoveDirection() == Main.UP) {
					if (PlayState.getCurrentLevel().getMapArray()[PlayState.getPlayer().getX()/32][(PlayState.getPlayer().getY()/32)-1].equals(CreateMap.getGrass())) {
						PlayState.getCurrentLevel().setMapArray(CreateMap.getSmallBomb(), PlayState.getPlayer().getX()/32, (PlayState.getPlayer().getY()/32)-1);
						PlayState.getPlayer().decrementSmallBomb();
					}
				}
			}
		}
		// R to reset level
		if (e.getKeyCode() == KeyEvent.VK_R) {
			PlayState.getPlayer().reset = true;
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

		// When enter is pressed during the menu screen
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// Start game
			if (Main.menuState.getMenu().getSelected() == 1) {
				State.setState(Main.playState);
			}
			// Controls
			else if (Main.menuState.getMenu().getSelected() == 2) {
				State.setState(Main.controlsState);
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
			PlayState.getPlayer().down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			PlayState.getPlayer().left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			PlayState.getPlayer().right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			PlayState.getPlayer().up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			PlayState.getPlayer().setDetonate(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) { }

}
