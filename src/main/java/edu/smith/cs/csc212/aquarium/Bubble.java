package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Bubble {
	int x;
	int y;
	int size;
	Color color;
	Random rand = new Random();
	Bubble[] bubbles;
	int speedY;
	int speedX;
		
	public Bubble(int x, int y, int size, int speedY, int speedX) {
		this.y = y;
		this.x = x;
		this.size = size;
		this.speedY = speedY;
		this.speedX = speedX;
	}
		
	public void drift() {
		this.y -= this.speedY;
		if (this.y < -100) {
			this.y = 600;
		}
		if (this.x % this.speedX >= this.speedX/2) {
			this.x -=1;
		}
		else {
			this.x +=1;
		}
	}
		
	public void creatBubble(Graphics2D g) {
		this.drift();
		Shape bubble = new Ellipse2D.Double(this.x, this.y, this.size, this.size);
		g.setColor(Color.blue);
		g.fill(bubble);
		g.setColor(Color.white);
		g.draw(bubble);
	}
	
}
