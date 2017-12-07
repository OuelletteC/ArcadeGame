package Manager;

import java.awt.Graphics;

import Images.MenuImage;

public class MenuScreen {

	MenuImage menuImage = new MenuImage();

	private int selected = 1;

	public MenuScreen() { }

	public void drawMenuScreen(Graphics g) {
		
		g.drawImage(menuImage.getMenuBackground(), 0, 0, null);
		g.drawImage(menuImage.getMenu(), 335, 170, null);
		g.drawImage(menuImage.getGameTitle(), 230, 50, null);

		if (selected == 1) {
			g.drawImage(menuImage.getArrow(), 290, 172, null);
		}
		else if (selected == 2) {
			g.drawImage(menuImage.getArrow(), 290, 228, null);
		}
		else if (selected == 3) {
			g.drawImage(menuImage.getArrow(), 290, 286, null);
		}
		else if (selected == 4) {
			g.drawImage(menuImage.getArrow(), 290, 344, null);
		}

	}

	public void moveDown() {

		if (selected == 1) {
			selected = 2;
		}
		/*
		else if (selected == 2) {
			selected = 3;
		}
		else if (selected == 3) {
			selected = 4;
		}
		else if (selected == 4) {
			selected = 1;
		}*/
	}

	public void moveUp() {
		if (selected == 2) {
			selected = 1;
		}
	}

	public int getSelected() {
		return this.selected;
	}

}
