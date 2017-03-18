package robaczki.geometry;

import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public class Rectangle extends Robaki {
  public Rectangle(RobakProcessingApplet parent, LocationTracker tracker) {
		super(parent, tracker);
	}

  int rectWidth = 1;
  int rectHeight = 1; 
  
  public void drawMe()
  {
	  parent.noStroke();
	  parent.fill(robakStrokeColor);
	  parent.rectMode(RobakProcessingApplet.CENTER);
	  parent.rect(location.x, location.y,rectWidth,rectHeight);
  }

	@Override
	public int getSize() 
	{
		return rectWidth*rectHeight;
	}

	@Override
	public void interact(Robaki rabczki) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// We return an average of height and width divided by two
	public float getInteractionRadius() {
		return rectHeight + rectWidth / 4 ;
	}
}