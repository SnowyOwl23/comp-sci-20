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
		
		if (direction[0] != "still") {
			previousDirection = direction;
		}
		
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
		
		
		checkCollisions(count);
		
		checkGravity(count);

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
	
	public void checkCollisions(int count) {

		collisionOn = false;
		gp.cChecker.checkCollisions(this, gp.surfaceM.tile[0]);
		
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
			
			gp.cChecker.checkCollisions(this, gp.surfaceM.tile[0]);
			
			while (collisionOn) {
				gp.cChecker.checkCollisions(this, gp.surfaceM.tile[0]);

				if (collisionOn) {
					if (previousDirection[0] == "left") {
						worldX++;
					} else if (previousDirection[0] == "right") {
						worldX--;
					}
					hitBox.setBounds(worldX, worldY, 48, 48);
					
					if (previousDirection[1] == "jumping") {
						if (gp.cChecker.checkCollisions(this, gp.surfaceM.tile[0]) == "bottom") {
							gp.count = 0;
							keyH.jump = false;
							worldY--;
						} else if (gp.cChecker.checkCollisions(this, gp.surfaceM.tile[0]) == "top") {
							gp.count = 20;
						}
						hitBox.setBounds(worldX, worldY, 48, 48);
					}
				}
			}
		}
	}

	public void checkGravity(int count) {
		
		if (gp.gChecker.checkGravity(this, gp.surfaceM.tile[0]) == false && count == 0) {
			while (gp.gChecker.checkGravity(this, gp.surfaceM.tile[0]) == false) {
				worldY++;
			}
		}
	}
}
