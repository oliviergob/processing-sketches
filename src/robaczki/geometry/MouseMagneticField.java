package robaczki.geometry;

import processing.core.PApplet;
import robaczki.applet.GobsProperties;
import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public class MouseMagneticField extends MagneticField 
{
	
	protected float magneticPower = PApplet.radians(GobsProperties.MOUSE_MAGNETIC_FIELDS_POWER);

	public MouseMagneticField(RobakProcessingApplet parent, LocationTracker tracker) 
	{
		super(parent, tracker);
		this.radius = GobsProperties.MOUSE_MAGNETIC_FIELD_RAD;
	}
	
	@Override
	// This magnet follow the mouse
	public void move()
	{
		this.location.x = parent.mouseX;
		this.location.y = parent.mouseY;
		
		drawMe();
	}
	
	@Override
	public void interact(Robaki rabczki)
	{
		// Do not interact if mouse outside of the window
		if (location.x < 0 || location.x > parent.width || location.y < 0 || location.y > parent.width)
			return;
		
		super.interact(rabczki);
	}
	

}
