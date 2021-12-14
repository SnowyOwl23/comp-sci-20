package main;

import java.awt.Rectangle;

import entity.Entity;

public class CollisionChecker {

	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void check(Entity entity, Entity entity2) {
		
		int entityLeftWorldX = entity.worldX + entity.hitBox.x;
		int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
		int entityTopWorldY = entity.worldY + entity.hitBox.y;
		int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;
		
		int entityLeftColumn = entityLeftWorldX/gp.tileSize;
		int entityRightColumn = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int entity2LeftWorldX = entity2.worldX + entity2.hitBox.x;
		int entity2RightWorldX = entity2.worldX + entity2.hitBox.x + entity2.hitBox.width;
		int entity2TopWorldY = entity.worldY + entity.hitBox.y;
		int entity2BottomWorldY = entity2.worldY + entity2.hitBox.y + entity2.hitBox.height;
		
		int entity2LeftColumn = entity2LeftWorldX/gp.tileSize;
		int entity2RightColumn = entity2RightWorldX/gp.tileSize;
		int entity2TopRow = entity2TopWorldY/gp.tileSize;
		int entity2BottomRow = entity2BottomWorldY/gp.tileSize;
		
		if (entity.hitBox.intersects(entity2.hitBox)) {
			entity.collisionOn = true;
//			if (entityTopRow < entity2TopRow) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
		}
	}
	
	
}
