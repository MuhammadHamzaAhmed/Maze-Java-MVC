package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.KeyController;
import controller.TimeListner;
import model.WallComposite;
import model.playerComposition;

public class GameBoard {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;
	
	private JFrame window;
	private MyCanvas canvas;
	private Timer timer;
	private TimeListner timerListener;
	private WallComposite walls;
	private playerComposition player;
	
	public GameBoard(JFrame window) {
		this.window = window;
	}
	
	public void init() {
		Container cp = window.getContentPane();

		canvas = new MyCanvas(this, WIDTH, HEIGHT);
		cp.add(BorderLayout.CENTER, canvas);
		canvas.addKeyListener(new KeyController(this));
		canvas.requestFocusInWindow();
		canvas.setFocusable(true);

		JButton quitButton = new JButton("Quit");
		quitButton.setFocusable(false);

		JPanel southPanel = new JPanel();
		southPanel.add(quitButton);
		cp.add(BorderLayout.SOUTH, southPanel);

		timerListener = new TimeListner(this);
		timer = new Timer(1, timerListener);
		walls = new WallComposite();
		player = new playerComposition(walls);
		canvas.getGameElements().add(walls);
		canvas.getGameElements().add(player);
		timer.start();

		quitButton.addActionListener(event -> System.exit(0));

	}

	public MyCanvas getCanvas() {
		return canvas;
	}

	public TimeListner getTimer() {
		return timerListener;
	}
	
	public playerComposition getPlayerComposite(){
		return player;
	}

}
