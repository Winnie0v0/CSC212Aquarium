package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// Every fish has a x which is an int
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	//every fish has a destination: (x,y)
	int destX;
	int destY;
	
	Random rand = new Random();
	
	public Fish(Color c, int startX, int startY, boolean isLittle) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		//this.facingLeft = facingLeft;
		
		this.destX = rand.nextInt(500);
		this.destY = rand.nextInt(500);
		System.out.println(destX);
		System.out.println(destY);
		
	}
	
	public void swim() {
		if (this.y < this.destY) {
			this.y += 1;
		}
		else if (this.y > this.destY) {
			this.y -= 1;
		}
		else {
			
		}
		if (this.x < this.destX) {
			this.facingLeft = false;
			this.x += 1;
		}
		else if (this.x > this.destX) {
			this.facingLeft = true;
			this.x -= 1;
		}
		else {

		}
	}
	
	public void draw(Graphics2D g) {
		this.swim();
		//fish face left and are small
		// smallFacingRight, facingLeft, and facingRight
		if (this.isLittle) {
			if (this.facingLeft) {
				DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
			}
			else {
				DrawFish.smallFacingRight(g, this.color, this.x, this.y);
			}
		}
		else {
			if (this.facingLeft) {
				DrawFish.facingLeft(g, this.color, this.x, this.y);
			}
			else {
				DrawFish.facingRight(g, this.color, this.x, this.y);
			}
		}
		
	}

}
