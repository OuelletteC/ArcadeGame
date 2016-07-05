package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import Control.Character;
import GameStateManager.MenuState;
import GameStateManager.PauseState;
import GameStateManager.PlayState;
import GameStateManager.State;
import GameStateManager.WinState;
import Manager.CreateMap;
import Manager.WinScreen;
import Manager.KeyManager;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int TILES = 32;
	public static final int TILES_IN_WIDTH = 30, TILES_IN_HEIGHT = 20;
	public static final int WIDTH = TILES*TILES_IN_WIDTH, HEIGHT = TILES*TILES_IN_HEIGHT;
	public static final int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;

	public static boolean running = false;
	public Thread gameThread;

	//public static State playState, winState, pauseState, menuState;

	public static MenuState menuState;
	public static PlayState playState;
	public static WinState winState;
	public static PauseState pauseState;

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

	public static void main(String[] args) {
		Main main = new Main();
		main.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		main.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		main.setMinimumSize(new Dimension(WIDTH, HEIGHT));

		JFrame frame = new JFrame("Arcade Game");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(main);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		main.start();
		main.requestFocus();
	}

	public synchronized void start() {
		if (running) return;
		running = true;
		gameThread = new Thread(this);
		// Calls run();
		gameThread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		init();
		loadMaps();

		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				delta--;
			}
			render();
		}
	}

	public void init() {

		player = new Character(9, TILES*3, TILES*3);
		this.addKeyListener(new KeyManager());

		// Initialize the states
		playState = new PlayState();
		winState = new WinState();
		pauseState = new PauseState();
		menuState = new MenuState();

		// Setting the initial state

		State.setState(menuState);
	}

	public void loadMaps() {
		try {
			level1 = new CreateMap(1);
			currentLevel = level1;
		} catch (IOException e) {
			System.out.println("Failed to create map 1");
		}

	}

	public void tick() {
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (State.getState() != null) {
			State.getState().render(g);
		}

		g.dispose();
		bs.show();
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
			State.setState(winState);
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

	public static Character getPlayer() {
		return player;
	}
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
}
