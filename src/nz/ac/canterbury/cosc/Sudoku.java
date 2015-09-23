package nz.ac.canterbury.cosc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Sudoku {
	public static int Totalcounter = 0;
	static int N = 9;
	static int grid[][] = new int[9][9];

	static class Cell {

		int row, col;

		public Cell(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + "]";
		}
	};

	static boolean isValid(Cell cell, int value) {

		if (grid[cell.row][cell.col] != 0) {
			throw new RuntimeException(
					"Cannot call for cell which already has a value");
		}

		for (int c = 0; c < 9; c++) {
			if (grid[cell.row][c] == value)
				return false;
		}

		for (int r = 0; r < 9; r++) {
			if (grid[r][cell.col] == value)
				return false;
		}

		int x1 = 3 * (cell.row / 3);
		int y1 = 3 * (cell.col / 3);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++)
			for (int y = y1; y <= y2; y++)
				if (grid[x][y] == value)
					return false;

		return true;
	}

	static Cell getNextCell(Cell cur) {

		int row = cur.row;
		int col = cur.col;

		col++;

		if (col > 8) {
			col = 0;
			row++;
		}

		if (row > 8)
			return null; // reached end

		Cell next = new Cell(row, col);
		return next;
	}

	static boolean solve(Cell cur) {

		if (cur == null)
			return true;

		if (grid[cur.row][cur.col] != 0) {
			return solve(getNextCell(cur));
		}

		for (int i = 1; i <= 9; i++) {
			boolean valid = isValid(cur, i);

			if (!valid) // i not valid for this cell, try other values
				continue;

			grid[cur.row][cur.col] = i;

			boolean solved = solve(getNextCell(cur));
			if (solved) {
				Totalcounter++;
				return true;
			}
			grid[cur.row][cur.col] = 0; // reset
		}
		return false;
	}

	public static void main(String[] args) {

		int i=0, j=0;
		int[][] arr = new int[9][9];
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println(args[0] + " does not exist.");
			return;
		}
		if (!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + " cannot be read from.");
			return;
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			char current;
			while (fis.available() > 0) {
				current = (char) fis.read();
				if (current=='\n') {
					i++;
					j=0;
					continue;
				}
				arr[i][j] = (int)current-48;
				j++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		grid = arr;
		printGrid(grid);
		boolean solved = solve(new Cell(0, 0));
		System.out.println("Total possible solutions-" + Totalcounter);

	}

	static void printGrid(int grid[][]) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++)
				System.out.print(grid[row][col]);
			System.out.println();
		}
	}
}
