package what.entity;

import org.lwjgl.input.Keyboard;
import what.graphics.SpriteHandler;
import what.level.SubLevel;

/**
 * Created by USER on 11/11/2017.
 */
public class Player extends Entity {
	public Player(double x, double y) {
		super(x, y, SpriteHandler.player);
		setSize(16, 16);
	}

	@Override
	public void update(SubLevel level) {
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			vX = 5;
		else if (Keyboard.isKeyDown(Keyboard.KEY_A))
			vX = -5;
		else
			vX = 0;

		if (Keyboard.isKeyDown(Keyboard.KEY_W) && onGround(level))
			vY = -5;

		vY += 0.2;

		tryMoving(level);
	}
}
