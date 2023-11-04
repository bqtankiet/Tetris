package model;

public abstract class TetrominoFactory {

	public static Tetromino createTetromino_L1() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 2), new Position(1, 0), new Position(1, 1), new Position(1, 2) },
				{ new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(2, 2) },
				{ new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 0) },
				{ new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(2, 1) } };
		return new Tetromino(STATE_POSITIONS, 1, new Position(0, 3));
	}

	public static Tetromino createTetromino_L2() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(1, 2) },
				{ new Position(0, 1), new Position(0, 2), new Position(1, 1), new Position(2, 1) },
				{ new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 2) },
				{ new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(2, 0) } };

		return new Tetromino(STATE_POSITIONS, 2, new Position(0, 3));
	}

	public static Tetromino createTetromino_I() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(1, 3) },
				{ new Position(0, 2), new Position(1, 2), new Position(2, 2), new Position(3, 2) },
				{ new Position(2, 0), new Position(2, 1), new Position(2, 2), new Position(2, 3) },
				{ new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(3, 1) } };

		return new Tetromino(STATE_POSITIONS, 3, new Position(-1, 3));
	}

	public static Tetromino createTetromino_O() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1) } };

		return new Tetromino(STATE_POSITIONS, 4, new Position(0, 4));
	}

	public static Tetromino createTetromino_T() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(1, 2) },
				{ new Position(0, 1), new Position(1, 1), new Position(1, 2), new Position(2, 1) },
				{ new Position(1, 0), new Position(1, 1), new Position(1, 2), new Position(2, 1) },
				{ new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(2, 1) } };

		return new Tetromino(STATE_POSITIONS, 5, new Position(0, 3));
	}

	public static Tetromino createTetromino_Z1() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(1, 2) },
				{ new Position(0, 2), new Position(1, 1), new Position(1, 2), new Position(2, 1) },
				{ new Position(1, 0), new Position(1, 1), new Position(2, 1), new Position(2, 2) },
				{ new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(2, 0) } };

		return new Tetromino(STATE_POSITIONS, 6, new Position(0, 3));
	}

	public static Tetromino createTetromino_Z2() {
		final Position[][] STATE_POSITIONS = {
				{ new Position(0, 1), new Position(0, 2), new Position(1, 0), new Position(1, 1) },
				{ new Position(0, 1), new Position(1, 1), new Position(1, 2), new Position(2, 2) },
				{ new Position(1, 1), new Position(1, 2), new Position(2, 0), new Position(2, 1) },
				{ new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 1) } };

		return new Tetromino(STATE_POSITIONS, 7, new Position(0, 3));
	}

	public static Tetromino randomTetromino() {
		Tetromino result = null;
		int randNumber = (int) (Math.random() * 7);
		switch (randNumber) {
		case 0 -> result = createTetromino_O();
		case 1 -> result = createTetromino_L1();
		case 2 -> result = createTetromino_L2();
		case 3 -> result = createTetromino_Z1();
		case 4 -> result = createTetromino_Z2();
		case 5 -> result = createTetromino_I();
		case 6 -> result = createTetromino_T();
		}
		return result;
	}
}
