package what.tile;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import what.graphics.SpriteHandler;

/**
 * Created by USER on 11/11/2017.
 */
public class BlockTile extends Tile {
	public BlockTile(int x, int y) {
		super(x, y, SpriteHandler.blockTile);
	}

	@Override
	public boolean collides() {
		return true;
	}
}
