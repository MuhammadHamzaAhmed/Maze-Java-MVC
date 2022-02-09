package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class MouseCrumb extends GameElements{
	
	public MouseCrumb(int x, int y, int size, Color color, boolean filled) {
		super(x, y, color, filled, size, size);
	}

	@Override
	public void render(Graphics2D g2) {
		g2.setColor(color);
		if (filled)
			g2.fillOval(loc.x, loc.y, width, height);
		else
			g2.drawRect(loc.x, loc.y, width, height);

	}

}
