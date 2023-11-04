package model;

public class GameGrid {

	public int rows, cols;
	public int[][] data;

	public GameGrid(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.data = new int[rows][cols];
	}

	public boolean isInside(int r, int c) {
		return (r >= 0 && r < rows && c >= 0 && c < cols);
	}

	public boolean isEmpty(int r, int c) {
		if(!isInside(r, c)) return false;
		return data[r][c] == 0;
	}

	public boolean isEmptyRow(int r) {
		for (int c = 0; c < cols; c++) {
			if (!isEmpty(r, c))
				return false;
		}
		return true;
	}

	public boolean isFullRow(int r) {
		for (int c = 0; c < cols; c++) {
			if (isEmpty(r, c)) {
				return false;
			}
		}
		return true;
	}

	public void clearRow(int r) {
		for (int c = 0; c < cols; c++) {
			data[r][c] = 0;
		}
	}

	public void dropRow(int r, int offset) {
		for (int c = 0; c < cols; c++) {
			data[r + offset][c] = data[r][c];
			data[r][c] = 0;
		}
	}

	public void clearAndDrop() {
		int r = rows - 1;
		int cleared = 0;
		while (!isEmptyRow(r) && r >= 0) {
			if (isFullRow(r)) {
				clearRow(r);
				cleared++;
			} else if (cleared > 0) {
				dropRow(r, cleared);
			}
			r--;
		}
	}

}
