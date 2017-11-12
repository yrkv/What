package what.tile;

import org.newdawn.slick.Color;

/**
 * Created by USER on 11/11/2017.
 */
public class NullTile extends Tile {
	public NullTile(int x, int y) {
		super(x, y, null);
	}

	public void render() {
	}

	public void render(Color filter) {
	}
}
