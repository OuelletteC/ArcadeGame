package Control;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Images.Character;
import Manager.CollisionManager;
import Manager.CreateMap;
import Manager.KeyManager;

public class Main extends Canvas implements Runnable {

	public static final int TILE = 32;
	public static final int WIDTH = TILE*30, HEIGHT = TILE*20;
	public final int moveDown = 0, moveLeft = 1, moveRight = 2, moveUp = 3;
	public static boolean running = false;
	public Thread gameThread;
	public static CollisionManager collision = new CollisionManager();

	private static Character player;

	Graphics g2 = getGraphics();

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

		player = new Character(9,TILE*3,TILE*3);
		this.addKeyListener(new KeyManager());

	}


	public void tick() {
		player.tick();
	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.fillRect(0, 0, WIDTH, HEIGHT);

		try {
			new CreateMap(g);
		} catch (IOException e) {
			System.out.println("Failed to create map");
		}

		player.render(g);

		g.dispose();
		bs.show();
	}

	public synchronized void start() {

		if (running) return;
		running = true;
		gameThread = new Thread(this);
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

	public static Character getPlayer() {
		return player;
	}


}
