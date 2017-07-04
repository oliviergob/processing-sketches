package drops;

import processing.core.PVector;

public class Drop
{

	float radius;
	protected PVector location = new PVector();
	private float initialX;
	protected float velocity;
	protected Integer robakStrokeColor = null;
	protected Integer robakFillColor = null;
	protected DropsApplet parent;
	private boolean growing = true;
	private Drop nextDrop;

	public Drop(float initialX, DropsApplet parent)
	{
		super();
		this.parent = parent;
		this.initialX = initialX;

		this.velocity = (GobsProperties.DROP_MIN_VELOCITY + GobsProperties.DROP_MAX_VELOCITY) / 2;
		this.radius = parent.getRandom(GobsProperties.DROP_MIN_RADIUS, GobsProperties.DROP_MAX_RADIUS);
		this.robakStrokeColor = GobsProperties.DROP_STROKE_COLOR;
		this.robakFillColor = GobsProperties.DROP_FILL_COLOR;

	}

	public float move()
	{
		location.y = location.y + velocity;
		drawMe();
		
		return location.y;
	}

	public void applyColor()
	{
		if (robakStrokeColor != null)
			parent.stroke(robakStrokeColor);
		else
			parent.noStroke();
		if (robakFillColor != null)
			parent.fill(robakFillColor);
		else
			parent.noFill();
	}
	
	public void reInit()
	{
		location.x = initialX;
		location.y = GobsProperties.DROP_Y_SPACING * -1;
		
		applyNoise();
	}
	
	
	public void applyNoise()
	{
		if (GobsProperties.DROP_X_RANDOM_FACTOR != 0)
			location.x += parent.getIntRandom((GobsProperties.DROP_X_SPACING/GobsProperties.DROP_X_RANDOM_FACTOR)*-1, (GobsProperties.DROP_X_SPACING/GobsProperties.DROP_X_RANDOM_FACTOR));
		
		if (GobsProperties.DROP_Y_RANDOM_FACTOR != 0)
			location.y += parent.getIntRandom((GobsProperties.DROP_Y_SPACING/GobsProperties.DROP_Y_RANDOM_FACTOR)*-1, (GobsProperties.DROP_Y_SPACING/GobsProperties.DROP_Y_RANDOM_FACTOR));
		
		if (GobsProperties.DROP_RANDOM_SPEED)
			this.velocity = parent.getRandom(GobsProperties.DROP_MIN_VELOCITY, GobsProperties.DROP_MAX_VELOCITY);
		
		
	}
	
	

	public void drawMe()
	{

		if (growing)
		{
			if (radius + GobsProperties.DROP_RADIUS_INCREMENT >= GobsProperties.DROP_MAX_RADIUS)
			{
				radius = GobsProperties.DROP_MAX_RADIUS;
				growing = false;
			}

			else
				radius += GobsProperties.DROP_RADIUS_INCREMENT;
		} else
		{
			if (radius - GobsProperties.DROP_RADIUS_INCREMENT <= GobsProperties.DROP_MIN_RADIUS)
			{
				radius = GobsProperties.DROP_MIN_RADIUS;
				growing = true;
			}

			else
				radius -= GobsProperties.DROP_RADIUS_INCREMENT;
		}

		applyColor();
		parent.ellipse(location.x, location.y, radius * 2, radius * 2);
		
		parent.stroke(GobsProperties.COLOUR_WHITE);
		if (nextDrop != null)
			parent.line(location.x, location.y, nextDrop.location.x, nextDrop.location.y);

	}

	public void setNextDrop(Drop nextDrop) 
	{
		this.nextDrop = nextDrop;
	}	
	
	

}