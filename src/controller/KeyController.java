package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GameBoard;

public class KeyController implements KeyListener {
	private GameBoard gameBoard;

	public KeyController(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		var eventQueue = gameBoard.getTimer().getEventQueue();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("UP");
			eventQueue.create(TimeListner.EventType.KEY_UP);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			eventQueue.create(TimeListner.EventType.KEY_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("LEFT");
			eventQueue.create(TimeListner.EventType.KEY_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("RIGHT");
			eventQueue.create(TimeListner.EventType.KEY_RIGHT);
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("SPACE");
			eventQueue.create(TimeListner.EventType.KEY_SPACE);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }
}
