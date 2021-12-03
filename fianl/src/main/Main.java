package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		//Change this later
		window.setTitle("Game");
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		gamePanel.startGameThread();
		
	}
}
