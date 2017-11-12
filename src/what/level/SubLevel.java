package what.level;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import what.tile.BlockTile;
import what.tile.NullTile;
import what.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by USER on 11/11/2017.
 */
public class SubLevel {
	private Tile[] tiles;
	private int width = 0, height = 0;

	public SubLevel(String path) {
		try {
			load(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(String path) throws IOException {
		BufferedImage image = ImageIO.read(new File(path));

		if (image != null) {
			width = image.getWidth();
			height = image.getHeight();
			tiles = new Tile[width * height];

			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					int pixel = image.getRGB(i, j);

					if (pixel == 0xff000000)
						tiles[j * width + i] = new BlockTile(i, j);
					else
						tiles[j * width + i] = new NullTile(i, j);
				}
			}
		}
	}

	public void update() {

	}

	public void render() {
		for (Tile tile : tiles) {
			tile.render();
		}
	}

	public void render(Color filter) {
		for (Tile tile : tiles) {
			tile.render(filter);
		}
	}

	public Tile findTile(double x, double y) {
		return tiles[(int) (y / Tile.TILE_SIZE) * width + (int) (x / Tile.TILE_SIZE)];
	}

	public Tile[] getTiles() {
		return tiles;
	}
}
