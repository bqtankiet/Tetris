package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import model.GameState;
import view.GameFrame;

public class GameController extends KeyAdapter {

	GameState gameState;
	GameFrame gameFrame;

	public GameController(GameState gameState, GameFrame gameFrame) {
		this.gameState = gameState;
		this.gameFrame = gameFrame;
		startGameLoop();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP -> {
			gameState.rotateTetromino();
		}
		case KeyEvent.VK_LEFT -> {
			gameState.moveTetrominoLeft();
		}
		case KeyEvent.VK_RIGHT -> {
			gameState.moveTetrominoRight();
		}
		case KeyEvent.VK_DOWN -> {
			gameState.moveTetrominoDown();
		}
		}
		gameFrame.repaint();
	}

	public void startGameLoop() {
		new Thread(() -> {
			final double TIME_PER_FRAME = 1_000_000_000 / 60;
			int delayFrames = 15;
			int frameCounter = 0;
			long lastTime = System.nanoTime();
			while (!gameState.gameOver) {
				long currentTime = System.nanoTime();
				if (currentTime - lastTime >= TIME_PER_FRAME) {
					lastTime = currentTime;
					frameCounter++;
				}
				if (frameCounter >= delayFrames) {
					frameCounter = 0;
					gameState.moveTetrominoDown();
					gameFrame.repaint();
				}
			}
			gameFrame.setFocusable(false);
			JOptionPane.showMessageDialog(gameFrame, "Game Over");
			System.exit(0);
		}).start();
	}

}
