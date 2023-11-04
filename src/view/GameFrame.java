package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GamePanel gamePanel;
	public GameFrame(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		setLayout(new BorderLayout());
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(gamePanel,BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
}
