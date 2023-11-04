package model;

import java.awt.Color;

public class Tetromino {

	public final Color color;
	public final int id;
	public final Position startOffset;
	public final Position[][] statePositions;
	public int rotationState;
	public Position offset;

	public Tetromino(Position[][] statePositions, int id, Position startOffset) {
		this.statePositions = statePositions;
		this.id = id;
		this.startOffset = startOffset;
		this.offset = startOffset;
		this.color = switch(id) {
		case 1 -> Color.RED;
		case 2 -> Color.BLUE;
		case 3 -> Color.ORANGE;
		case 4 -> Color.YELLOW;
		case 5 -> Color.PINK;
		case 6 -> Color.CYAN;
		case 7 -> Color.GREEN;
		default -> Color.WHITE;
		};
	}

	public void move(int deltaRow, int deltaCol) {
		offset.row += deltaRow;
		offset.col += deltaCol;
	}

	public void rotateRight() {
		rotationState = (rotationState + 1) % statePositions.length;
	}

	public void rotateLeft() {
		if (rotationState == 0)
			rotationState = statePositions.length - 1;
		else
			rotationState--;
	}

	public Position[] getTetrominoPositions() {
		Position[] positions = new Position[4];
		int i = 0;
		for (Position p : statePositions[rotationState]) {
			positions[i] = new Position(p.row + offset.row, p.col + offset.col);
			i++;
		}
		return positions;
	}
}
