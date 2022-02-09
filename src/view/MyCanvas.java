package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.GameElements;

public class MyCanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private GameBoard gameBoard;
	private ArrayList<GameElements> gameElements = new ArrayList<>();

	public MyCanvas(GameBoard gameBoard, int width, int height) {
		this.setGameBoard(gameBoard);
		setBackground(Color.black);
		setPreferredSize(new Dimension(width, height));

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(GameElements n: gameElements) {
			n.render(g2);
		}
	}

	public ArrayList<GameElements> getGameElements() {
		return gameElements;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
}
