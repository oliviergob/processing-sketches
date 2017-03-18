package robaczki.geometry;

import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

class Kropki extends Robaki {
	  
	Kropki(RobakProcessingApplet parent, LocationTracker tracker) 
	{
		super(parent, tracker);
	}

	public void drawMe()
	{
		applyColor();
		parent.point(location.x, location.y);
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
	/* We assume the point is a circle of daiameter 1 */
	public float getInteractionRadius() {
		return 1/2;
	}

}