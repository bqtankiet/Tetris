package testcase;

import controller.GameController;
import model.GameState;
import view.GameFrame;
import view.GamePanel;

public class Main {
	public static void main(String[] args) {
		GameState gameState = new GameState();
		GamePanel gamePanel = new GamePanel(gameState);
		GameFrame gameFrame = new GameFrame(gamePanel);
		GameController controller = new GameController(gameState, gameFrame);
		gamePanel.addKeyListener(controller);
		gamePanel.setFocusable(true);
		gameFrame.setVisible(true);
	}
}
