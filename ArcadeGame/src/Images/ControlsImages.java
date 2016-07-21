package Images;

import java.awt.image.BufferedImage;

import GameStateManager.PlayState;

public class ControlsImages {
	
	private BufferedImage menuBackground;
	private BufferedImage controls;
	
	private MenuImage menuImage = new MenuImage();

	public ControlsImages() {
		
		this.menuBackground = menuImage.getMenuBackground();
		this.controls = PlayState.getCurrentLevel().mapElements.getControls();
		
	}
		
	public BufferedImage getMenuBackground() {
		return menuBackground;
	}
	public BufferedImage getControls() {
		return controls;
	}
	
	
}
