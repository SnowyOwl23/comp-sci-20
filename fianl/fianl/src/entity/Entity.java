package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage still;
	public String[] direction = new String[2];
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle hitBox;
	public boolean collisionOn = false;
	
}
