package triangles03.stairs02;

import processing.core.PApplet;

public class Test extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -630532450687040318L;
	
	
	public void setup() 
	{
		size(100, 100);
	}
	
	public void draw() 
	{
		
		translate(50, 50);
		stroke(255, 0, 0);
		beginShape();
		// Exterior part of shape
		vertex(-40, -40);
		vertex(40, -40);
		vertex(40, 40);
		vertex(-40, 40);
		// Interior part of shape
		beginContour();
		vertex(-20, -20);
		vertex(20, -20);
		vertex(20, 20);
		vertex(-20, 20);
		endContour();
		endShape(CLOSE);

	}
	
}
