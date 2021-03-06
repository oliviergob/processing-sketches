package seaOfTimes2;

import processing.core.PVector;

public class Circle {
	
	float radius;
	private SeaOfTimesApplet parent;
	protected PVector location;
	  
	
	public Circle(float x, float y, SeaOfTimesApplet parent, float radius) 
	{
		this.parent = parent;
		this.radius = radius;
		this.location = new PVector(x, y);
	}

	public void drawMe()
	{
		parent.ellipse(location.x, location.y, radius*2, radius*2);
	}

	public int getSize() 
	{
		return 0;
	}


	public float getInteractionRadius() {
		return radius;
	}

	public PVector getLocation()
	{
		return location;
	}
	
	

}