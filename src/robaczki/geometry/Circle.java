package robaczki.geometry;

import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public class Circle extends Robaki {
	
	float radius;
	  
	public Circle(RobakProcessingApplet parent, LocationTracker tracker) 
	{
		super(parent, tracker);
		this.radius = parent.getRandomRadius();
	}
	
	public Circle(RobakProcessingApplet parent, LocationTracker tracker, float radius) 
	{
		super(parent, tracker);
		this.radius = radius;
	}

	@Override
	public void drawMe()
	{
		applyColor();
		parent.ellipse(location.x, location.y, radius*2, radius*2);
	}

	@Override
	public int getSize() 
	{
		return 0;
	}

	@Override
	public void interact(Robaki rabczki) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public float getInteractionRadius() {
		return radius;
	}

}