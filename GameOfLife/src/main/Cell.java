package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author coreybuchanan
 *
 */
public class Cell {

	private boolean isAlive;
	
	private static final int IMAGE_SIZE = 10;
	
	private static final BufferedImage deadImage = loadImage("white_square.png"); 
	private static final BufferedImage liveImage = loadImage("black_square.png");
	
	private static BufferedImage loadImage(String imageName) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("src/main/" + imageName));
		} catch (IOException e) {
			System.out.println("Tile image not found");
			System.exit(0);
		}
		
		return img;
		
	}
	
	public Cell() {
		isAlive = false;
	}
	
	public boolean getStatus() {
		return isAlive;
	}
	
	public void spawn() {
		isAlive = true;
	}
	
	public void kill() {
		isAlive = false;
	}
	
	public int getSize() {
		return IMAGE_SIZE;
	}
	
	public void updateStatus(int numberOfNeighbors) {
		
		if (numberOfNeighbors < 2) {
			kill();
		} else if (numberOfNeighbors == 3) {
			spawn();
		} else if (numberOfNeighbors > 3) {
			kill();
		}
		
	}
	
	public void toggleStatus() {
		isAlive = !isAlive;
	}
	
	public void draw(Graphics g, int row, int column) {
		
		if (isAlive) {
			g.drawImage(liveImage, column * IMAGE_SIZE, row * IMAGE_SIZE + 100, null);
		} else {
			g.drawImage(deadImage, column * IMAGE_SIZE, row * IMAGE_SIZE + 100, null);
		}
		
		
	}

}
