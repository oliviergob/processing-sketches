package robaczki.geometry;

import processing.core.PApplet;
import robaczki.applet.GobsProperties;
import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public class MagneticField extends Circle 
{
	
	protected float magneticPower = PApplet.radians(GobsProperties.MAGNETIC_FIELDS_POWER);

	  
	public MagneticField(RobakProcessingApplet parent, LocationTracker tracker) 
	{
		super(parent, tracker);
	}
	
	public MagneticField(RobakProcessingApplet parent, LocationTracker tracker, float radius) 
	{
		super(parent, tracker, radius);
	}


	@Override
	public void move()
	{
		// Magnetic fields are not moving
	}

	@Override
	public int getSize() 
	{
		return 0;
	}
	
	@Override
	public void interact(Robaki rabczki)
	{
		
		if (isColliding(rabczki))
		{
			
			// Absolute angle Robaczki to Magnet
			float absolute1 = PApplet.atan2(location.x - rabczki.getLocation().x, location.y - rabczki.getLocation().y);
			// Direction's absolute agnle
			float absolute2 = PApplet.atan2(rabczki.getDirection().x, rabczki.getDirection().y);
			// Relative angle between the two
			float relative =  absolute2 - absolute1;

			if (PApplet.degrees(relative) != 0.0)
			{
				
				// If the angle is bigger than the magnetic power
				// Just apply the magnetic power
				if (PApplet.abs(relative) > magneticPower)
				{
					if (relative > 0)
					{
						rabczki.getDirection().rotate(magneticPower);
					}
					else
					{
						rabczki.getDirection().rotate(magneticPower * -1);
					}
					
				}
				else 
				{
					rabczki.getDirection().rotate(relative);
				}
				
			}
			
			
			
		}
			
		
	}
}