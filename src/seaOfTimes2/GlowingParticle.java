package seaOfTimes2;

import processing.core.PApplet;
import processing.core.PVector;

public class GlowingParticle
{
	
	private PVector originalLocation;
	private PVector location;
	private PVector direction;
	private SeaOfTimesApplet parent;
	private RGBColor fillColor = null;
	private float speed;
	private float originalSpeed;
	private float radius;
	private boolean ascendingPhase = true;
	private boolean isOscillating = GobsProperties.PARTICULE_OSCLILATION;
	private boolean isRotating = false;
	private boolean leftSide;
	private int rotatingLife = 0;
	
	

	
	public GlowingParticle(float x, float y, SeaOfTimesApplet parent, float speed)
	{
		super();
		this.location = new PVector(x, y);
		this.originalLocation = new PVector(x, y);
		this.parent = parent;
		fillColor = GobsProperties.PARTICULE_COLOR;
		this.originalSpeed = speed;
		
		
	}
	
	protected GlowingParticle clone()
	{
		return new GlowingParticle(originalLocation.x, originalLocation.y,parent, originalSpeed);
	}
	
	public void resetLocation()
	{
		this.radius = GobsProperties.PARTICULE_RADIUS;
		location.x = originalLocation.x;
		location.y = originalLocation.y;
		speed = originalSpeed;
		rotatingLife = 0;
		isRotating = false;
		isOscillating = GobsProperties.PARTICULE_OSCLILATION;
		
		direction = parent.getDirectionToPresent(location);
		leftSide =  direction.x >0;
		direction.y = GobsProperties.PARTICULE_Y_OSCLILATION_MAX_ABS_VALUE / 2;
		if (ascendingPhase)
			direction.y = direction.y * -1;
	}


	public boolean move()
	{
		location.x += direction.x * speed;
		location.y += direction.y;
		
		// Oscillations
		if (isOscillating)
		{
			if (ascendingPhase)
				direction.y -= GobsProperties.PARTICULE_OSCLILATION_DIFF;
			
			else
				direction.y += GobsProperties.PARTICULE_OSCLILATION_DIFF;
			
			if (PApplet.abs(direction.y) > GobsProperties.PARTICULE_Y_OSCLILATION_MAX_ABS_VALUE)
			{
				if (ascendingPhase)
					ascendingPhase = false;
				else
					ascendingPhase = true;
			}
			
		}
		
		// if we reached the cutting point
		 if (isRotating || (leftSide && location.x > parent.present.x  ) || (!leftSide && location.x < parent.present.x  ) ) 
		{
			isRotating = true;
			isOscillating = false;
			direction.rotate((float)0.04 );
			rotatingLife++;
		}// if we reached the cutting point
		else if ( ( leftSide && location.x > parent.present.x - GobsProperties.LEFT_CUTTING_POINT_MARGIN) || ( !leftSide && location.x < parent.present.x + GobsProperties.LEFT_CUTTING_POINT_MARGIN))
		{
			
			PVector dirToPrenset;
			if (leftSide)
				dirToPrenset = parent.getDirectionBetweenVectors(location, parent.topOfTheWave);
			else 
				dirToPrenset = parent.getDirectionBetweenVectors(location, parent.present);
			float yDiff = dirToPrenset.y - direction.y;
			
			direction.y +=  yDiff/2;
		}
		 
		 
		// Let's enter the dying mode
		if (rotatingLife > GobsProperties.ROTATING_LIFE_SPAN)
		{
			if (radius >= 0.01)
				radius -= 0.01;
		}
		
		return (radius > 0.5);
	}
	
	
	public void drawMyBluryPart()
	{
		parent.noStroke();
		fillColor.fill(parent);
		parent.ellipse(location.x, location.y, (radius + GobsProperties.PARTICULE_RADIUS_BLUR_EXTRA) * 2, (radius + GobsProperties.PARTICULE_RADIUS_BLUR_EXTRA) * 2);
		
	}
	public boolean drawMyNonBluryPart()
	{
		parent.ellipse(location.x, location.y, radius * 2, radius * 2);
		
		return move();
	}

	public PVector getLocation()
	{
		return location;
	}

	public float getInteractionRadius()
	{
		return radius;
	}

	public PVector getDirection()
	{
		return direction;
	}
	
	
	
	
}
