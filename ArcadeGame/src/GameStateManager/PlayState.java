package GameStateManager;

import java.awt.Graphics;
import java.io.IOException;

import Main.Main;
import Manager.CreateMap;
import Manager.WinScreen;
import Control.Character;

public class PlayState extends State {
	
	private static Character player;
	private static CreateMap level1;
	private static CreateMap level2;
	private static CreateMap level3;
	private static CreateMap level4;
	private static CreateMap level5;
	private static CreateMap level6;
	private static CreateMap level7;
	private static CreateMap currentLevel;
	private static WinScreen winScreen;

	public PlayState() { 
		
		player = new Character(9, Main.TILES*3, Main.TILES*3);
		
		loadMaps();
		
		
	}

	public void loadMaps() {
		try {
			level1 = new CreateMap(1);
			currentLevel = level1;
		} catch (IOException e) {
			System.out.println("Failed to create map 1");
		}

	}
	
	public static void setNextLevel() {
		if (currentLevel == level1) {
			try {
				level2 = new CreateMap(2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level2;
		}
		else if (currentLevel == level2) {
			try {
				level3 = new CreateMap(3);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level3;
		}
		else if (currentLevel == level3) {
			try {
				level4 = new CreateMap(4);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level4;
		}
		else if (currentLevel == level4) {
			try {
				level5 = new CreateMap(5);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level5;
		}
		else if (currentLevel == level5) {
			try {
				level6 = new CreateMap(6);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level6;
		}
		else if (currentLevel == level6) {
			try {
				level7 = new CreateMap(7);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level7;
		}
		else {
			State.setState(Main.winState);
		}

	}

	public static void resetLevel() {

		if (currentLevel == level1) {
			try {
				level1 = new CreateMap(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level1;
		}
		else if (currentLevel == level2) {
			try {
				level2 = new CreateMap(2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level2;
		}
		else if (currentLevel == level3) {
			try {
				level3 = new CreateMap(3);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level3;
		}
		else if (currentLevel == level4) {
			try {
				level4 = new CreateMap(4);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level4;
		}
		else if (currentLevel == level5) {
			try {
				level5 = new CreateMap(5);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level5;
		}
		else if (currentLevel == level6) {
			try {
				level6 = new CreateMap(6);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level6;
		}
		else if (currentLevel == level7) {
			try {
				level7 = new CreateMap(7);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLevel = level7;
		}

	}

	//public static Character getPlayer() {
		//return player;
	//}
	public static CreateMap getCurrentLevel() {
		return currentLevel;
	}
	public static void setCurrentLevel(CreateMap map) {
		currentLevel = map;
	}
	public static WinScreen getWinScreen() {
		return winScreen;
	}
	public static CreateMap getLevel1() {
		return level1;
	}
	
	@Override
	public void tick() {
		player.tick();

	}

	@Override
	public void render(Graphics g) {
		currentLevel.drawMap(g);
		player.render(g);
	}
	
	public static Character getPlayer() {
			return player;
	}

}
