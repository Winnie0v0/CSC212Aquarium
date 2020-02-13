package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ocean {
	
	public Ocean() {	
		
	}
	
	public void drawOcean(Graphics2D g) {

	Shape shell3 = new Ellipse2D.Double(385, 485, 30, 30);
	Shape shell2 = new Ellipse2D.Double(370, 470, 60, 60);
	Shape shell1 = new Ellipse2D.Double(350, 450, 100, 100);

	g.setColor(Color.black);
	g.fill(shell1);
	g.setColor(Color.white);
	g.draw(shell1);
	g.setColor(Color.black);
	g.fill(shell2);
	g.setColor(Color.white);
	g.draw(shell2);
	g.setColor(Color.black);
	g.fill(shell3);
	g.setColor(Color.white);
	g.draw(shell3);
	
	int x = 0;
	
	for (int i = 0; i < 7; i++) {
		x += 30;
		int y = 500;
		for (int ii = 0; ii < 6; ii++) {
			y -= 40;
			Shape seaweed = new Ellipse2D.Double(x, y, 10, 40);
			g.setColor(Color.green);
			g.fill(seaweed);
			g.setColor(Color.black);
			g.draw(seaweed);
		}
	}
	
	
	
	}
	
}
