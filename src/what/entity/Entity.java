package what.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import what.Main;
import what.level.SubLevel;
import what.tile.Tile;

/**
 * Created by USER on 11/11/2017.
 */
public class Entity {
	public double x, y, vX, vY;
	private int sizeX, sizeY;
	private Image image;

	public Entity(double x, double y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public void update(SubLevel level) {

	}

	public void render() {
		image.draw((float) x - Main.screenOffsetX, (float) y - Main.screenOffsetY, sizeX, sizeY);
	}

	public void render(Color filter) {
		image.draw((float) x - Main.screenOffsetX, (float) y - Main.screenOffsetY, sizeX, sizeY, filter);
	}

	private void move(double vX, double vY) {
		x += vX;
		y += vY;
	}

	protected void tryMoving(SubLevel level) {
		for (int c = 1; c < Math.abs(vX); c++) {
			if (!checkCollisionX(level, vX / (int) Math.abs(vX)))
				move(vX / (int) Math.abs(vX), 0);
			else
				vX = 0;
		}

		for (int c = 1; c < Math.abs(vY); c++) {
			if (!checkCollisionY(level, vY / (int) Math.abs(vY)))
				move(0, vY / (int) Math.abs(vY));
			else
				vY = 0;
		}
	}

	private boolean checkCollisionX(SubLevel level, double vX) {
		if (level.findTile(x + vX, y).collides()) return true;
		if (level.findTile(x + vX + sizeX-1, y).collides()) return true;
		if (level.findTile(x + vX, y + sizeY-1).collides()) return true;
		if (level.findTile(x + vX + sizeX-1, y + sizeY-1).collides()) return true;
		return false;
	}

	private boolean checkCollisionY(SubLevel level, double vY) {
		if (level.findTile(x, y + vY).collides()) return true;
		if (level.findTile(x + sizeX-1, y + vY).collides()) return true;
		if (level.findTile(x, y + sizeY-1 + vY).collides()) return true;
		if (level.findTile(x + sizeX-1, y + sizeY-1 + vY).collides()) return true;
		return false;
	}

	public boolean checkCollision(SubLevel level) {
		if (level.findTile(x, y).collides()) return true;
		if (level.findTile(x + sizeX-1, y).collides()) return true;
		if (level.findTile(x, y + sizeY-1).collides()) return true;
		if (level.findTile(x + sizeX-1, y + sizeY-1).collides()) return true;
		return false;
	}

	protected boolean onGround(SubLevel level) {
		if (level.findTile(x, y + sizeY + vY).collides()) return true;
		if (level.findTile(x + sizeX-1, y + sizeY + vY).collides()) return true;
		return false;
	}

	protected void setSize(int x, int y) {
		sizeX = x;
		sizeY = y;
	}
}
