package main;

import java.awt.Rectangle;

import entity.Entity;
import surfaces.Tile;

public class GravityChecker {

	GamePanel gp;
	
	public GravityChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public boolean checkGravity(Entity entity, Tile entity2) {
		
//		int entityBottom = entity.hitBox.y + entity.hitBox.height;
//		int entityTop = entity.hitBox.y;
//		
//		int entityMiddleAcross = entity.hitBox.height/2;  
//		int entityMiddleUp = entity.hitBox.width/2;
//		
//		int entity2Bottom = entity2.hitBox.y + entity2.hitBox.height;
//		int entity2Top = entity2.hitBox.y;
//		
//		int entity2MiddleAcross = entity2.hitBox.height/2;  
//		int entity2MiddleUp = entity2.hitBox.width/2;
		
		Rectangle entityTest = entity.hitBox;
		entityTest.setBounds(entityTest.x, entityTest.y++, entityTest.width, entityTest.height);
		
		if (entityTest.intersects(entity2.hitBox)) {
			return true;	
		} else {
			return false;
		}
	
	}
}
