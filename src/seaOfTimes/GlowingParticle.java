package seaOfTimes;

import processing.core.PApplet;
import processing.core.PVector;

public class GlowingParticle
{
	
	private PVector originalLocation;
	private PVector location;
	private PVector direction;
	private PApplet parent;
	private RGBColor fillColor = null;
	private float speed;
	private float radius;
	private int oscilationFrameCount = GobsProperties.PARTICULE_OSCLILATION_FRAME_SPAN / 2;
	private boolean ascendingPhase = true;
	
	

	
	public GlowingParticle(float x, float y, SeaOfTimesApplet parent)
	{
		super();
		this.location = new PVector(x, y);
		this.originalLocation = new PVector(x, y);
		this.parent = parent;
		
		direction = parent.getDirectionToPresent(location);
		speed = parent.getRandom(GobsProperties.PARTICULE_SPEED_MIN, GobsProperties.PARTICULE_SPEED_MAX);
		fillColor = GobsProperties.PARTICULE_COLOR;
		this.radius = GobsProperties.PARTICULE_RADIUS;
		ascendingPhase = parent.getBooleanRandom();
		
		System.out.println("Direction "+direction);
	}
	
	public void resetLocation()
	{
		location.x = originalLocation.x;
		location.y = originalLocation.y;
	}


	public boolean move()
	{
		location.x += direction.x * speed;
		location.y += direction.y * speed;
		
		if (GobsProperties.PARTICULE_OSCLILATION)
		{
			if (ascendingPhase)
			{
				direction.y -= GobsProperties.PARTICULE_OSCLILATION_DIFF;
				oscilationFrameCount++;
				
				if (oscilationFrameCount >= GobsProperties.PARTICULE_OSCLILATION_FRAME_SPAN)
				{
					oscilationFrameCount=0;
					ascendingPhase = false;
				}
			}
			else
			{
				direction.y += GobsProperties.PARTICULE_OSCLILATION_DIFF;
				oscilationFrameCount++;
				
				if (oscilationFrameCount >= GobsProperties.PARTICULE_OSCLILATION_FRAME_SPAN)
				{
					oscilationFrameCount=0;
					ascendingPhase = true;
				}
			}
		}
		
		return location.x < parent.width + (GobsProperties.PARTICULE_RADIUS_BLUR * 2);
	}
	
	
	public void drawMyBluryPart()
	{
		parent.noStroke();
		fillColor.fill(parent);
		parent.ellipse(location.x, location.y, GobsProperties.PARTICULE_RADIUS_BLUR * 2, GobsProperties.PARTICULE_RADIUS_BLUR * 2);
		
	}
	public boolean drawMyNonBluryPart()
	{
		parent.ellipse(location.x, location.y, radius * 2, radius * 2);
		
		return move();
	}
}
