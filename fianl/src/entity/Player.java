package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	int jumpSpeed = 6;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
	
		x = 720;
		y = 400;
		speed = 4;
	}
	
	public void update(int count) {
		
		if (keyH.upPressed == true) {
			y -= speed;
			
		} else if (keyH.leftPressed == true) {
			x -= speed;
		
		} else if (keyH.rightPressed == true) {
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
	}
	
	public void draw(Graphics2D g2) {

		g2.setColor(Color.white);
		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
	}
}
