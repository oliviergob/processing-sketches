package drops2;

import processing.core.PVector;

public class Drop
{

	float radius;
	protected PVector location = new PVector();
	protected float velocity;
	protected Integer robakStrokeColor = null;
	protected Integer robakFillColor = null;
	protected DropsApplet parent;
	private boolean growing = true;
	private Drop center;
	boolean isAlive = false;

	public Drop(DropsApplet parent, Drop center)
	{
		super();
		this.parent = parent;
		this.center = center;

		this.velocity = (GobsProperties.DROP_MIN_VELOCITY + GobsProperties.DROP_MAX_VELOCITY) / 2;
		this.radius = parent.getRandom(GobsProperties.DROP_MIN_RADIUS, GobsProperties.DROP_MAX_RADIUS);
		this.robakStrokeColor = GobsProperties.DROP_STROKE_COLOR;
		this.robakFillColor = GobsProperties.DROP_FILL_COLOR;

	}

	public boolean move()
	{
/*		if (location.y < parent.height + GobsProperties.DROP_MAX_RADIUS)
			location.y = location.y + velocity;
		else if (location.x > GobsProperties.DROP_MAX_RADIUS * -1)
		{
			location.x = location.x - (velocity / 2);
			location.y = location.y + velocity;
		}
		else
			isAlive = false;*/
		
		location.x = location.x - (velocity / 2);
		location.y = location.y + velocity;
		if (location.x < GobsProperties.DROP_MAX_RADIUS * -1)
			isAlive = false;
		
		drawMe();

		return isAlive;
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
	
	public void init()
	{
		location.x = parent.getIntRandom(GobsProperties.DROP_X_MARGIN +100 , parent.width - GobsProperties.DROP_X_MARGIN + 200);
		location.y = GobsProperties.DROP_Y_SPACING * -1;
		
		applyNoise();
		isAlive = true;
	}
	
	
	public void applyNoise()
	{
	
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
		if (center != null)
			parent.line(location.x, location.y, center.location.x, center.location.y);

	}	
	
	

}