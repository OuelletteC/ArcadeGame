package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import Control.Character;
import GameStateManager.ControlsState;
import GameStateManager.MenuState;
import GameStateManager.PauseState;
import GameStateManager.PlayState;
import GameStateManager.State;
import GameStateManager.WinState;
import Manager.CreateMap;
import Manager.KeyManager;
import Manager.WinScreen;

public class Main extends Canvas implements Runnable {

	public static final int TILES = 32;
	public static final int WIDTH = 960, HEIGHT = 640;
	public static final int TILES_IN_WIDTH = WIDTH/TILES, TILES_IN_HEIGHT = HEIGHT/TILES;
	public static final int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;

	public static boolean running = false;
	public Thread gameThread;

	public static MenuState menuState;
	public static PlayState playState;
	public static WinState winState;
	public static PauseState pauseState;
	public static ControlsState controlsState;

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

		this.addKeyListener(new KeyManager());

		// Initialize the states
		playState = new PlayState();
		winState = new WinState();
		pauseState = new PauseState();
		menuState = new MenuState();
		controlsState = new ControlsState();

		// Setting the initial state
		State.setState(menuState);
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

}
