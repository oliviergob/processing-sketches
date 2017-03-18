package seaOfTimes2;


import processing.core.PApplet;

public class MagneticField extends Circle
{
	
	protected float magneticPower = PApplet.radians(GobsProperties.MAGNETIC_FIELDS_POWER);
	
	  
	public MagneticField(float x, float y, SeaOfTimesApplet parent) 
	{
		super(x, y, parent, GobsProperties.MAGNETIC_RADIUS);
	}
	
	public MagneticField(float x, float y, SeaOfTimesApplet parent, float radius) 
	{
		super(x, y, parent, radius);
	}


	public boolean isColliding(GlowingParticle glowingParticle)
	{
		float deltaX = glowingParticle.getLocation().x - location.x;
		float deltaY = glowingParticle.getLocation().y - location.y;
		float centerToCenterdistance = PApplet.sqrt(deltaX*deltaX + deltaY*deltaY);
		float minDist = glowingParticle.getInteractionRadius() + this.getInteractionRadius();
		
		return centerToCenterdistance <= minDist;
	}
	
	public void interact(GlowingParticle glowingParticle)
	{
		
		if (isColliding(glowingParticle))
		{
			
			// Absolute angle Particle to Magnet
			float absolute1 = PApplet.atan2(location.x - glowingParticle.getLocation().x, location.y - glowingParticle.getLocation().y);
			// Direction's absolute angle
			float absolute2 = PApplet.atan2(glowingParticle.getDirection().x, glowingParticle.getDirection().y);
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
						glowingParticle.getDirection().rotate(magneticPower);
					}
					else
					{
						glowingParticle.getDirection().rotate(magneticPower * -1);
					}
					
				}
				else 
				{
					glowingParticle.getDirection().rotate(relative);
				}
				
			}
			
			
			
		}
			
		
	}
}