package main;

import java.awt.Graphics;

/**
 * @author coreybuchanan
 *
 */
public class Gameplay {
	
	private int NUMBER_OF_ROWS = 40;
	private int NUMBER_OF_COLUMNS = 40;
	
	private Cell[][] cells;

	public Gameplay () {
		
		cells = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]; 
		
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				cells[row][column] = new Cell();
			}
		}
		
	}
	
	public void spaceClicked(double x, double y) {
		int row = (int) x / (new Cell().getSize());
		int column = (int) y / (new Cell().getSize());
		
		try {
			cells[column][row].toggleStatus();
		} catch (Exception e) {
			// Do nothing
		}
		
	}
	
	public void draw(Graphics g) {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				cells[row][column].draw(g, row, column);
			}
		}
	}
	
	public void updateBoard() {
		
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				cells[row][column].updateStatus(countNeighbors(row, column));
			}
		}
		
	}
	
	public int countNeighbors(int row, int column) {
		int count = 0;
		
		if (row > 0) {
			if (column > 0) {
				if (cells[row - 1][column - 1].getStatus()) count++;
			}
			
			if (cells[row - 1][column].getStatus()) count++;
			
			if (column < NUMBER_OF_COLUMNS - 1) {
				if (cells[row - 1][column + 1].getStatus()) count++;
			}
		}
		
		if (column > 0) {
			if (cells[row][column - 1].getStatus()) count++;

		}
		
		if (column < NUMBER_OF_COLUMNS - 1) {
			if (cells[row][column + 1].getStatus()) count++;
		}

		if (row < NUMBER_OF_ROWS - 1) {
			if (column > 0) {
				if (cells[row + 1][column - 1].getStatus()) count++;
			}
			
			if (cells[row + 1][column].getStatus()) count++;
			
			if (column < NUMBER_OF_COLUMNS - 1) {
				if (cells[row + 1][column + 1].getStatus()) count++;
			}
		}
		
		return count;
	}

}
