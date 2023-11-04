package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameState;
import model.Position;
import model.Tetromino;

public class GamePanel extends JPanel {
	public static final int BLOCK_SIZE = 30;
	public GameState gameState;

	public GamePanel(GameState gameState) {
		this.gameState = gameState;
		init();
	}

	private void init() {
		int height = gameState.gameGrid.rows * BLOCK_SIZE + 1;
		int width = gameState.gameGrid.cols * BLOCK_SIZE + 1;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
	}

	public void drawCurrentTetromino(Graphics g) {
		Tetromino tetromino = gameState.currentTetromino;
		g.setColor(tetromino.color);
		for (Position position : tetromino.getTetrominoPositions()) {
			int x = (position.col) * BLOCK_SIZE;
			int y = (position.row) * BLOCK_SIZE;
			g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
		}
	}

	public void drawGrid(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		for (int r = 0; r < gameState.gameGrid.rows; r++) {
			int y = r * BLOCK_SIZE;
			for (int c = 0; c < gameState.gameGrid.cols; c++) {
				int x = c * BLOCK_SIZE;
				g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
			}
		}
	}

	public void drawPlacedTetrominos(Graphics g) {
		int r = gameState.gameGrid.rows - 1;
		while (!gameState.gameGrid.isEmptyRow(r) && r >= 0) {
			for (int c = 0; c < gameState.gameGrid.cols; c++) {
				int id = gameState.gameGrid.data[r][c];
				if(id == 0) continue;
				g.setColor(switch (id) {
				case 1 -> Color.RED;
				case 2 -> Color.BLUE;
				case 3 -> Color.ORANGE;
				case 4 -> Color.YELLOW;
				case 5 -> Color.PINK;
				case 6 -> Color.CYAN;
				case 7 -> Color.GREEN;
				default -> Color.WHITE;
				});
				g.fillRect(c*BLOCK_SIZE, r*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
			}
			r--;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCurrentTetromino(g);
		drawPlacedTetrominos(g);
		drawGrid(g);
	}

}
