package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Obstacle;
import entity.Player;
import surfaces.SurfaceManager;
import surfaces.Tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements Runnable {
	
	

	
	
	
	
	public int panel = 1;
	BufferedImage bg;
	
	
	
	
	
	
	
	public final int tileSize = 48;
	final int screenWidth = 960;
	final int screenHeight = 540;

	int FPS = 60;
	
	public SurfaceManager surfaceM = new SurfaceManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public GravityChecker gChecker = new GravityChecker(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	Player player = new Player(this, keyH);
	public Obstacle obstacle = new Obstacle(this, 500, 400, 48, 48);
	
	int playerX = 100;
	int playerY = 500;
	int playerSpeed = 4;
	public int count = -1;
	
	public BufferedImage bg(int panel, BufferedImage i) {
		
		if (panel == 1) {
			try {
				i = ImageIO.read(getClass().getResourceAsStream("/tiles/Background.jpg"));
				return i;
			} catch (IOException e) {
				e.printStackTrace();
				return i;
			}
		} else {
			return i;
		}
		
		
	}
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
//		this.(bg, 0, 0, screenWidth, screenHeight, null);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	public void update() { 
		
		player.update(count);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		surfaceM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
