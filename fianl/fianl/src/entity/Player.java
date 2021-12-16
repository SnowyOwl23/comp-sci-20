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
	public String[] previousDirection;
	
	boolean onGround;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		hitBox = new Rectangle(0, 0, 48, 48);
		
		setDefaultValues();
		//getPlayerImage();
	}
	
	public void setDefaultValues() {
	
		worldX = 720;
		worldY = 400;
		speed = 4;
		direction[0] = "still";
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
	
//	public void getPlayerImage() {
//		try {
//			still = ImageIO.read(getClass().getResourceAsStream("/player/ghost_still.JPG"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void update(int count) {
		
		previousDirection = direction;
		
		if (keyH.leftPressed == true) {
			direction[0] = "left";
		
		} else if (keyH.rightPressed == true) {
			direction[0] = "right";
		
		} else if (keyH.leftPressed == false && keyH.rightPressed == false) {
			direction[0] = "still";
		}
			
		if (keyH.jump == true) {
			direction[1] = "jump";
			
		} else if (keyH.jump == false) {
			if (gp.count > 0) {
				direction[1] = "jumping";
			} else {
				direction[1] = null;
			}
			
		}
		
		collisionOn = false;
		gp.cChecker.check(this, gp.obstacle);
		
		if (collisionOn == false) {
			
			if (direction[0] == "left") {
				worldX -= speed;
				
			} else if (direction [0] == "right") {
				worldX += speed;
			}
			
			if (direction[1] == "jump") {
				if (count < 20) {
					worldY -= jumpSpeed;
					gp.count ++;
				} else {
					keyH.jump = false;
				}
			} else  {
				if (count > 0){
					worldY += jumpSpeed;
					gp.count --;
				} else {
					keyH.jump = false;
					gp.count = 0;
				}
			}

			hitBox.setBounds(worldX, worldY, 48, 48);
			
			gp.cChecker.check(this, gp.obstacle);
			
			while (collisionOn) {
				gp.cChecker.check(this, gp.obstacle);

				if (collisionOn) {
					if (gp.cChecker.check(this, gp.obstacle) == "left") {
						worldX++;
						break;
					}else if (gp.cChecker.check(this, gp.obstacle) == "right") {
						worldX--;
						break;
					} else if (gp.cChecker.check(this, gp.obstacle) == "bottom") {
						onGround = true;
					}
					if (previousDirection[1] == "jumping") {
						if (gp.cChecker.check(this, gp.obstacle) == "bottom") {
							gp.count = 0;
							keyH.jump = false;
							worldY--;
						} else if (gp.cChecker.check(this, gp.obstacle) == "top") {
							gp.count = 20;
						}
						hitBox.setBounds(worldX, worldY, 48, 48);
					}
				}
			}
		}
		
		System.out.println(collisionOn);
	}
	
	
	public void checkGravity(boolean onGround) {
		
		if (onGround == false) {
			
			while (onGround)
		}
	}
	
	public void draw(Graphics2D g2) {

		g2.setColor(Color.red);
		g2.fillRect(worldX, worldY, gp.tileSize, gp.tileSize);
		
		g2.drawRect(worldX, worldY, gp.tileSize, gp.tileSize);
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
