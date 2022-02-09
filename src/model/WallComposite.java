package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WallComposite extends GameElements{
	public static final int WALL_SIZE = 20;

	private ArrayList<ArrayList<GameElements>> rows;
	private int maze[][];

	public WallComposite() {
		maze =getMaze();
		rows = new ArrayList<>();
		for (int r = 0; r < 15; r++) {
			var oneRow = new ArrayList<GameElements>();
			rows.add(oneRow);
			for (int c = 0; c < 30; c++) {
				if(maze[r][c] == 1)
					oneRow.add(new Wall(c * WALL_SIZE , r * WALL_SIZE , WALL_SIZE, Color.lightGray, true));
			}
		}
	}

	private int[][] getMaze() {
		Random rand =new Random();
		int [][] maze = new int[15][30];
		String s="Maze2.txt";
		try {
			FileInputStream fin=new FileInputStream(new File(s));
			Scanner sc=new Scanner(fin);
			int i=0;
			while(sc.hasNextLine()) {
				int j=0;
				String str = sc.nextLine();
				StringTokenizer token=new StringTokenizer(str);
				while(token.hasMoreTokens()) {
					maze[i][j++] = Integer.parseInt(token.nextToken());
				}
				i++;
			}
			fin.close();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return maze;
	}

	@Override
	public void render(Graphics2D g2) {
		for (var r : rows) {
			for (var e : r) {
				e.render(g2);
			}
		}
	}

	public ArrayList<ArrayList<GameElements>> getEnemy(){
		return rows;
	}
	
	public int[][] maze() {
		return maze;
	}

	public boolean process(MouseCrumb mouse) {
		for(var r:rows) 
			for(var c:r) 
				if(c.collideWith(mouse)) 
					return true;
		return false;
	}
}
