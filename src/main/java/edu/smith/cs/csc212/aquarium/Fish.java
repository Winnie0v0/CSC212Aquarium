package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	Color originalColor;

	int destX;
	int destY;
	int hungry;
	int a;
	int b;
	
	Random rand = new Random();
	
	public Fish(Color c, Color oC, int startX, int startY, boolean isLittle, int hungry) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.hungry = hungry;
		this.originalColor = oC;
		
		this.destX = rand.nextInt(400)+50;
		this.destY = rand.nextInt(400)+50;
		
		a = rand.nextInt(50);
		b = rand.nextInt(50) + 450;
	}
	
	public void swim() {
		if (Math.abs(this.x - this.destX) < 10 && Math.abs(this.y - this.destY) < 10) {
			this.destX = rand.nextInt(400)+50;
			this.destY = rand.nextInt(400)+50;
		}
		if (this.y < this.destY) {
			this.y += 1;
		}
		else if (this.y > this.destY) {
			this.y -= 1;
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
	
	public void hungry(Graphics2D g) {
		if (this.x <= 200 && this.y >= 300) {
			if (this.hungry >= 1)
				this.hungry -= 5;
		}
		else {
			this.hungry += 1;
		}
			
		if (this.hungry >= 200) {
			this.color = Color.red;
			this.destX = a;
			this.destY = b;
			this.draw(g);
		}
		else {
			this.color = this.originalColor;
			this.draw(g);
		}
	}
	
	public void draw(Graphics2D g) {
		this.swim();
		if (this.isLittle && this.facingLeft) {
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);}
		else if (this.isLittle && !this.facingLeft){
			DrawFish.smallFacingRight(g, this.color, this.x, this.y);}
		else if (!this.isLittle && this.facingLeft){
			DrawFish.facingLeft(g, this.color, this.x, this.y);}
		else {
			DrawFish.facingRight(g, this.color, this.x, this.y);}
	}

}
