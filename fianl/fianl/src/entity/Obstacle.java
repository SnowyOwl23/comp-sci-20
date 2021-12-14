package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import tile.TileManager;

public class Obstacle extends Entity {
	GamePanel gp;

	public Obstacle(GamePanel gp) {

		this.gp = gp;

		hitBox = new Rectangle(0, 0, 48, 48);

		setDefaultValues();
	}
	
	public void setDefaultValues() {
		
		worldX = 500;
		worldY = 400;
	}
	
	
	public void draw(Graphics2D g2) {

		g2.setColor(Color.blue);
		g2.fillRect(worldX, worldY, gp.tileSize, gp.tileSize);
		g2.drawRect(worldX, worldY, gp.tileSize, gp.tileSize);
	}

}
