package wow.game.gui.notification;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import wow.game.gui.GuiButton;

/**
 * A notification gui with buttons.
 * @author Xolitude (October 26, 2018)
 *
 */
public class GuiNotificationConfirmation extends GuiNotificationInterface {

	public GuiNotificationConfirmation(float x, float y, String text, String buttonText) throws SlickException {
		super(x, y, text);
		this.addButton(new GuiButton(buttonText));
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics graphics) throws SlickException {
		if (shouldUpdate) {
			image.render(container, sbg, graphics);
			graphics.setColor(Color.yellow);
			graphics.drawString(text, (x + (image.getWidth() / 2 - graphics.getFont().getWidth(text) / 2)), (y + (image.getHeight() / 2 - graphics.getFont().getHeight(text) / 2) - 25));
			button.render(container, sbg, graphics);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg) throws SlickException {
		if (shouldUpdate) {
			if (button != null) {
				button.update(container, sbg);
				if (button.isPressed())
					shouldUpdate = false;
			}
		}
	}
}
