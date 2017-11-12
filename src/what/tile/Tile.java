package what.tile;

import org.newdawn.slick.Color;
import what.Main;
import org.newdawn.slick.Image;

/**
 * Created by USER on 11/11/2017.
 */
public class Tile {
	public static int TILE_SIZE = 16;
	private int x, y;

	private Image image;

	public Tile(int x, int y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;

//		if (image != null)
//			image.clampTexture();
	}

	public void render() {
		if (image != null)
			image.draw(x * TILE_SIZE - Main.screenOffsetX,
					y * TILE_SIZE - Main.screenOffsetY,
					TILE_SIZE,
					TILE_SIZE);
	}

	public void render(Color filter) {
		if (image != null)
			image.draw(x * TILE_SIZE - Main.screenOffsetX,
					y * TILE_SIZE - Main.screenOffsetY,
					TILE_SIZE,
					TILE_SIZE,
					filter);
	}

	public boolean collides() {
		return false;
	}
}
