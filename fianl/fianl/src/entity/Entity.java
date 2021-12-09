package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int x, y;
	public int speed;
	
	public BufferedImage still;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle hitBox;
	public boolean collisionOn = false;
	
}
