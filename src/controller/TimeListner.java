package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Location;
import view.GameBoard;

public class TimeListner implements ActionListener {
	public enum EventType {
		KEY_RIGHT, KEY_LEFT, KEY_UP, KEY_DOWN, KEY_SPACE
	}

	private GameBoard gameBoard;
	private LinkedList eventQueue;

	public TimeListner(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
		eventQueue = new LinkedList();
	}

	@Override
	public void actionPerformed(ActionEvent q) {
		while (!eventQueue.isEmpty()) {
			var e = eventQueue.getFirst();
			eventQueue.removeFirst();
			var player = gameBoard.getPlayerComposite();
			switch (e) {
			case KEY_UP:
				Location loc = new Location();
				loc.x = player.mouse.loc.x;
				loc.y = player.mouse.loc.y - 10;
				player.moveForward(loc);
				break;
			case KEY_DOWN:
				loc = new Location();
				loc.x = player.mouse.loc.x;
				loc.y = player.mouse.loc.y + 10;
				player.moveForward(loc);
				break;
			case KEY_LEFT:
				loc = new Location();
				loc.x = player.mouse.loc.x - 10;
				loc.y = player.mouse.loc.y;
				player.moveForward(loc);
				break;
			case KEY_RIGHT:
				loc = new Location();
				loc.x = player.mouse.loc.x + 10;
				loc.y = player.mouse.loc.y;
				player.moveForward(loc);
				break;
			case KEY_SPACE:
				player.moveBackward();
				break;
			}
		}
		gameBoard.getCanvas().repaint();
	}

	public LinkedList getEventQueue() {
		return eventQueue;
	}

}
