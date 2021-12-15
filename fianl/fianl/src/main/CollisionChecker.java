package main;

import java.awt.Rectangle;

import entity.Entity;

public class CollisionChecker {

	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public String check(Entity entity, Entity entity2) {
		
		int entityBottom = entity.hitBox.y + entity.hitBox.height;
		int entityTop = entity.hitBox.y;
		int entityLeft = entity.hitBox.x;
		int entityRight = entity.hitBox.x + entity.hitBox.width;
		
		int entityMiddleAcross = entity.hitBox.height/2;  
		int entityMiddleUp = entity.hitBox.width/2;
		
		int entity2Bottom = entity2.hitBox.y + entity2.hitBox.height;
		int entity2Top = entity2.hitBox.y;
		int entity2Left = entity2.hitBox.x;
		int entity2Right = entity2.hitBox.x + entity2.hitBox.width;
		
		int entity2MiddleAcross = entity2.hitBox.height/2;  
		int entity2MiddleUp = entity2.hitBox.width/2;
		
		
		if (entity.hitBox.intersects(500, 400, 48, 48)) {
			entity.collisionOn = true;
			if (entityBottom > entity2Top && entityBottom < entity2Bottom) {
				return "bottom";
			} else if (entityTop < entity2Bottom && entityTop > entity2Top) {
				return "top";
			} else {
				return null;
			}
		} else {
			entity.collisionOn = false;
			return null;
		}
	}
	
	
}
