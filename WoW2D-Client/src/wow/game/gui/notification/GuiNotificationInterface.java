package wow.game.gui.notification;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import wow.game.gui.GuiBasicImage;
import wow.game.gui.GuiButton;

/** 
 * An implementable class for the notification classes.
 * @author Xolitude (October 26, 2018)
 *
 */
public abstract class GuiNotificationInterface {

	protected GuiBasicImage image = new GuiBasicImage("res/ui/wow_status_box.png");
	
	protected float x, y;
	protected String text;
	
	protected GuiButton button;
	
	protected boolean shouldUpdate = false;
	
	public GuiNotificationInterface(float x, float y, String text) throws SlickException {
		this.x = x;
		this.y = y;
		this.image.setLocation(x, y);
		this.text = text;
		shouldUpdate = true;
	}
	
	public abstract void render(GameContainer container, StateBasedGame sbg, Graphics graphics) throws SlickException;
	public abstract void update(GameContainer container, StateBasedGame sbg) throws SlickException;
	
	public void addButton(GuiButton button) {
		button.setLocation((x + (image.getWidth() / 2 - button.getButtonWidth() / 2)), (y + (image.getHeight() / 2 - button.getButtonHeight() / 2)) + 20);
		this.button = button;
	}
	
	public boolean isButtonPressed() {
		return button.isPressed();
	}
}
