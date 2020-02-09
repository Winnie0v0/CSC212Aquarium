package edu.smith.cs.csc212.aquarium;
import java.util.Random;

public class Test {
	public static void main(String args[]){
		Random rand = new Random(500);
		int x = rand.nextInt(500);
		System.out.println(x);
	}
}
