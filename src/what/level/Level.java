package what.level;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import what.entity.Entity;
import what.entity.Player;

import java.util.ArrayList;

/**
 * Created by USER on 11/11/2017.
 */
public class Level {
	private static String levelFolder = "";
	private SubLevel[] subLevels;
	private int currentSubLevel = 0;

	private boolean wasSpacePressed = false;

	private Player player;

	public Level(String path) {
		loadLevel(path);
	}

	private void loadLevel(String path) {
		subLevels = new SubLevel[2];
		subLevels[0] = new SubLevel(path);
		subLevels[1] = new SubLevel("res/aaa.png");
	}

	public void update() {
		player.update(subLevels[currentSubLevel]);

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !wasSpacePressed) {
			int swapTo = (currentSubLevel == 0) ? 1 : 0;

			if (!player.checkCollision(subLevels[swapTo]))
				currentSubLevel = swapTo;
		}

		wasSpacePressed = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
	}

	public void render() {
		subLevels[1-currentSubLevel].render(new Color(1f, 1f, 1f, 0.5f));
		subLevels[currentSubLevel].render();
		player.render();
	}

	public void setCurrentSubLevel(int level) {
		this.currentSubLevel = level;
	}

	public int getCurrentSubLevel() {
		return currentSubLevel;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
