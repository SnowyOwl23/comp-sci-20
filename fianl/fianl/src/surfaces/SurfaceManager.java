package surfaces;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Obstacle;
import main.GamePanel;

public class SurfaceManager {

	GamePanel gp;
	public Tile[] tile;
	
	public SurfaceManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[1];
		
		getTileImage();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tester.jpg"));
			tile[0].hitBox.setBounds(500, 400, 48, 48);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(tile[0].image, 500, 400, gp.tileSize, gp.tileSize, null);
	}
	
}
