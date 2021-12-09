package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	int jumpSpeed = 6;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		hitBox = new Rectangle(0, 0, 48, 48);
		
		setDefaultValues();
		//getPlayerImage();
	}
	
	public void setDefaultValues() {
	
		x = 720;
		y = 400;
		speed = 4;
		direction = "still";
	}
	
//	public void getPlayerImage() {
//		try {
//			still = ImageIO.read(getClass().getResourceAsStream("/player/ghost_still.JPG"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void update(int count) {
		
		
		
		if (keyH.upPressed == true) {
			//direction = "still";
			y -= speed;
			
		} else if (keyH.leftPressed == true) {
			direction = "still";
			x -= speed;
		
		} else if (keyH.rightPressed == true) {
			direction = "still";
			x += speed;
		
		}  
			
		if (keyH.jump == true) {
			if (count < 20) {
				y -= jumpSpeed;
				gp.count ++;
			} else {
				keyH.jump = false;
			}
		} else if (keyH.jump == false) {
			if (count > 0){
				y += jumpSpeed;
				gp.count --;
			} else {
				keyH.jump = false;
				gp.count = 0;
			}
		}
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
	}
	
	public void draw(Graphics2D g2) {

		g2.setColor(Color.red);
		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		g2.drawRect(x, y, gp.tileSize, gp.tileSize);
//		BufferedImage image = null;
//		
//		switch(direction) {
//			case "still":
//				image = still;
//				break;
//		}
//		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
}
