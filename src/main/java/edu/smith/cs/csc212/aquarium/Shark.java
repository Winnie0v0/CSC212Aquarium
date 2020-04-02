//code in Shark class was build on existed code @author jfoley 
//https://github.com/jjfiv/CSC212Aquarium

package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Shark {
	int x;
	int y;
	int destX;
	int destY;
	boolean facingLeft;

	Random rand = new Random();
	
	public Shark(int startX, int startY) {
		this.x = startX;
		this.y = startY;

		this.destX = rand.nextInt(500);
		this.destY = rand.nextInt(500);
	}
	
	public void swim() {
		if (Math.abs(this.x - this.destX) < 10 && Math.abs(this.y - this.destY) < 10) {
			this.destX = rand.nextInt(500);
			this.destY = rand.nextInt(500);
		}
		if (this.y < this.destY) {
			this.y += 1;
		}
		else if (this.y > this.destY) {
			this.y -= 1;
		}
		if (this.x < this.destX) {
			facingLeft = false;
			this.x += 1;
		}
		else if (this.x > this.destX) {
			facingLeft = true;
			this.x -= 1;
		}
	}
	
	public void draw(Graphics2D g) {
		this.swim();
		if (this.facingLeft){
			DrawFish.facingLeft(g, Color.black, this.x, this.y);}
		else {
			DrawFish.facingRight(g, Color.black, this.x, this.y);}
	}

}
