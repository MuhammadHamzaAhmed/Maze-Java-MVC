package model;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import model.Interface.Stack;

public class playerComposition extends GameElements {
	public static final int SIZE = 20;
	public MouseCrumb mouse;
	private MouseCrumb crumbs;
	private Stack stack;
	private WallComposite com;

	public playerComposition(WallComposite com) {
		this.com = com;
		int[][] maze = com.maze();
		stack = new StackLinkedList();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 30; j++) {
				if (maze[i][j] == 2)
					mouse = new MouseCrumb(j * SIZE+2, i * SIZE+3, SIZE-5, Color.GREEN, true);
				if (maze[i][j] == 3)
					crumbs = new MouseCrumb(j * SIZE, i * SIZE, SIZE, Color.RED, true);
			}
		}
	}

	public void moveForward(Location loc) {
		// if stack is not empty and loc is equal to top loc then don't move
		// check if mouse collides with crumbs
		// push current location of mouse to stack
		// move mouse to next location
		// check if next condition collides with walls then don't move
		if (!stack.isEmpty()) {
			Location l = stack.pop();
			stack.push(l);
			if (loc.x == l.x && loc.y == l.y)
				return;
		}
		if (mouse.collideWith(crumbs)) {
			JOptionPane.showMessageDialog(null, "You won the game");
			System.exit(0);
		}
		stack.push(this.mouse.loc);
		this.mouse.loc = loc;
		if (com.process(mouse)) {
			Location l = stack.pop();
			this.mouse.loc = l;
		}
	}

	public void moveBackward() {
		// pop location from stack
		// if location is null then don't move
		// else move back
		Location loc = stack.pop();
		if (loc != null) {
			this.mouse.loc = loc;
		}
	}

	@Override
	public void render(Graphics2D g2) {
		mouse.render(g2);
		crumbs.render(g2);

	}

}
