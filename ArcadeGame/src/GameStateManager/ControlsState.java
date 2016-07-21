package GameStateManager;

import java.awt.Graphics;

import Images.ControlsImages;

public class ControlsState extends State {
	
	ControlsImages controlsImages = new ControlsImages();
	
	public ControlsState() { }

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(controlsImages.getMenuBackground(), 0, 0, null);
		g.drawImage(controlsImages.getControls(), 250, 150, null);
		
	}


}
