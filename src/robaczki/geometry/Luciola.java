package robaczki.geometry;

import robaczki.applet.GobsProperties;
import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public class Luciola extends Circle 
{
	
	private boolean growing = true;
	private boolean bounced = false;

	public boolean isBounced() {
		return bounced;
	}


	public Luciola(RobakProcessingApplet parent, LocationTracker tracker) 
	{
		super(parent, tracker);
		this.radius = parent.getRandom(GobsProperties.LUCIOLA_MIN_RADIUS, GobsProperties.LUCIOLA_MAX_RADIUS);
		growing = parent.getBooleanRandom();
		robakStrokeColor = GobsProperties.LUCIOLA_STROKE_COLOR;
		robakFillColor = GobsProperties.LUCIOLA_FILL_COLOR;
	}
	
	
	@Override
	public void drawMe()
	{
		
		if (growing)
		{
			if (radius + GobsProperties.LUCIOLA_RADIUS_INCREMENT >= GobsProperties.LUCIOLA_MAX_RADIUS)
			{
				radius = GobsProperties.LUCIOLA_MAX_RADIUS;
				growing = false;
			}
				
			else
				radius += GobsProperties.LUCIOLA_RADIUS_INCREMENT;
		}
		else
		{
			if (radius - GobsProperties.LUCIOLA_RADIUS_INCREMENT <= GobsProperties.LUCIOLA_MIN_RADIUS)
			{
				radius = GobsProperties.LUCIOLA_MIN_RADIUS;
				growing = true;
			}
				
			else
				radius -= GobsProperties.LUCIOLA_RADIUS_INCREMENT;
		}
		
		
		drowBorder();
		super.drawMe();
		
	}
	
	private void drowBorder()
	{
		if (GobsProperties.LUCIOLA_BORDER_SIZE == 0)
			return;
		
		parent.fill(GobsProperties.COLOUR_BLACK);
		parent.noStroke();
		parent.ellipse(location.x, location.y, (radius+GobsProperties.LUCIOLA_BORDER_SIZE)*2, (radius+GobsProperties.LUCIOLA_BORDER_SIZE)*2);
	}
	
	@Override
	public void startMoveCycle() 
	{
		bounced = false;
	}
	
}
