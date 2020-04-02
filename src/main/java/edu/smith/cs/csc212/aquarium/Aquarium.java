//code in aquarium class was build on existed code
//https://github.com/jjfiv/CSC212Aquarium

package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import me.jjfoley.gfx.GFX;

public class Aquarium extends GFX {
	public static int WIDTH = 500;
	public static int HEIGHT = 500;

	Snail algorithm = new Snail(100, Snail.HEIGHT, "top");
	Bubble[] bubbles = new Bubble[10];
	Fish[] fishes = new Fish[10];
	Ocean Ocean = new Ocean(-100);
	Color[] fishColor = new Color [10];
	Shark Jack = new Shark(250,250);
	
	int g1 = 100;
	boolean check = true;
	Random rand = new Random();

	public Aquarium() {
		super(WIDTH, HEIGHT);
		
		for (int i = 0; i < bubbles.length; i++) {
			int x = rand.nextInt(50)+350;
			int y = rand.nextInt(50)+450;
			int size = rand.nextInt(40)+2;
			int speedY = rand.nextInt(8)+3;
			int speedX = rand.nextInt(50)+10;
			bubbles[i] = new Bubble(x, y, size, speedY, speedX);
			}
		
		for (int i = 0; i < fishes.length; i++) {
			Color c = Color.getHSBColor(
			rand.nextFloat(), 0.8f, 0.8f);
			Color cc = c;
			boolean isLittle = rand.nextBoolean();
			int x = 50 + (i*90) % (WIDTH-100);
			int y = 50 + (i*40) % (HEIGHT-100);
			fishColor[i] = c;
			int hungry = 100;
			fishes[i] = new Fish(c, cc, x, y, isLittle, hungry);
			}
		}

	public void draw(Graphics2D g) {
		if (g1 == 100) {check = true;
		}
		else if (g1 == 250) {check = false;
		}
		
		if (check == true) {g1 += 1;
		}
		else {g1 -= 1;
		}
		
		Color myColor = new Color(0, g1, 200);
		g.setColor(myColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (check == false) {
			algorithm.draw(g, Color.black, Color.white);
			algorithm.move();
			}
		else {
			algorithm.draw(g, Color.red, Color.red);
			}
		
		for (Bubble b : bubbles) {
			b.creatBubble(g);
			}
		
		for (int i = 0; i < fishes.length; i++) {
			fishes[i].hungry(g);
			fishes[i].hungry(g);
			}
		
		Ocean.drawOcean(g);
		Ocean.creatFood(g);
		Jack.draw(g);	
	}

	public static void main(String[] args) {
		GFX app = new Aquarium();
		app.start();
	}
	
}
