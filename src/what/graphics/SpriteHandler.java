package what.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Created by USER on 11/11/2017.
 */
public class SpriteHandler {
	private SpriteSheet tileSheet;

	public static Image blockTile;
	public static Image player;

	public SpriteHandler() {
		try {
			blockTile = new Image("res/block.png");
			player = new Image("res/player.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Image getImage(SpriteSheet sheet, int x, int y) {
		return sheet.getSprite(x, y);
	}
}
