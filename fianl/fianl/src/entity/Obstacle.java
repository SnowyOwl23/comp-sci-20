package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public class Obstacle extends Entity {
	GamePanel gp;

	public Obstacle(GamePanel gp, int x, int y, int width, int height) {

		this.gp = gp;

		hitBox = new Rectangle(x, y, width, height);

		worldX = x;
		worldY = y;
	}
	
	public void draw(Graphics2D g2) {

		g2.setColor(Color.blue);
		g2.fillRect(worldX, worldY, gp.tileSize, gp.tileSize);
		g2.drawRect(worldX, worldY, gp.tileSize, gp.tileSize);
	}

}
