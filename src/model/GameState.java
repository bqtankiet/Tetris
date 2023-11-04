package model;

public class GameState {

	public Tetromino currentTetromino;
	public GameGrid gameGrid;
	public boolean gameOver;

	public GameState() {
		this.gameGrid = new GameGrid(20, 10);
		this.currentTetromino = TetrominoFactory.randomTetromino();
	}

	public void moveTetrominoLeft() {
		currentTetromino.move(0, -1);
		if (!isValid()) {
			currentTetromino.move(0, 1);
		}
	}

	public void moveTetrominoRight() {
		currentTetromino.move(0, 1);
		if (!isValid()) {
			currentTetromino.move(0, -1);
		}
	}

	public void moveTetrominoDown() {
		currentTetromino.move(1, 0);
		if (!isValid()) {
			currentTetromino.move(-1, 0);
			placeTetromino();
		}
	}

	public void rotateTetromino() {
		currentTetromino.rotateRight();
		if (!isValid()) {
			currentTetromino.rotateLeft();
		}
	}

	public void placeTetromino() {
		for (Position p : currentTetromino.getTetrominoPositions()) {
			gameGrid.data[p.row][p.col] = currentTetromino.id;
		}
		gameGrid.clearAndDrop();
		currentTetromino = TetrominoFactory.randomTetromino();
		if (!isValid())
			gameOver = true;

//		currentTetromino = TetrominoFactory.createTetromino_I();
	}

	public boolean isValid() {
		for (Position p : currentTetromino.getTetrominoPositions()) {
			boolean isInside = gameGrid.isInside(p.row, p.col);
			boolean isEmpty = gameGrid.isEmpty(p.row, p.col);
			if (!(isInside && isEmpty)) {
				return false;
			}
		}
		return true;
	}
}
