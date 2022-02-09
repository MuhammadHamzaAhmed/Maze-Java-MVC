package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class GameElements {
	public Location loc;
	public Color color;
	public boolean filled;
	public int width;
	public int height;

	public GameElements(int x, int y, Color color, boolean filled, int width, int height) {
		this.loc = new Location();
		this.loc.x = x;
		this.loc.y = y;
		this.color = color;
		this.filled = filled;
		this.width = width;
		this.height = height;
	}

	public GameElements() {
		this(0, 0, Color.white, false, 0, 0);
	}

	public GameElements(int x, int y, int width, int height) {
		this(x, y, Color.white, false, width, height);
	}

	public boolean collideWith(GameElements another) {
		if (another.loc.x > loc.x + width || loc.x > another.loc.x + another.width || loc.y + height < another.loc.y
				|| loc.y > another.loc.y + another.height) {
				return false;
		} else {
			return true;
		}
	}

	public abstract void render(Graphics2D g2);

}