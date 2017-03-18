package bouncyTriangle;

import processing.core.PApplet;
import processing.core.PVector;

public class Triangle
{
	private PVector top;
	private PVector left;
	private PVector right;
	private PVector center;
	private PApplet parent;
	private RGBColor strokeColor = null;
	private RGBColor fillColor = null;
	
	private boolean stuckToMouse = false;
	private float lastDistance;
	private PVector direction;
	private float speed = 0;
	private PVector centerOrigin;
	boolean mouseHover = false;
	
	public Triangle(PVector top, PVector left, PVector right, PApplet parent)
	{
		super();
		this.top = top;
		this.left = left;
		this.right = right;
		this.parent = parent;
		
		if (GobsProperties.TRI_STROKE_COLOUR != null)
			strokeColor = GobsProperties.TRI_STROKE_COLOUR.clone();
		
		if (GobsProperties.TRI_FILL_COLOUR != null)
			fillColor = GobsProperties.TRI_FILL_COLOUR.clone();
		
		center = new PVector(top.x, ((left.y - top.y) / 3 )*2 + top.y);
		centerOrigin = new PVector(center.x, center.y);
	}
	
	public Triangle(PApplet parent)
	{
		this(new PVector(parent.width / 2, GobsProperties.TRI_MARGIN), new PVector(GobsProperties.TRI_MARGIN, parent.height - GobsProperties.TRI_MARGIN ), 
				new PVector(parent.width- GobsProperties.TRI_MARGIN, parent.height - GobsProperties.TRI_MARGIN ), parent);
	}
	
	
	public void applyColor()
	{
		if (strokeColor != null)
			strokeColor.stroke(parent);
		else
			parent.noStroke();

			parent.noFill();
	}
	
	public void move()
	{
		
		// Is the mouse over the center?
		if (parent.mouseX <= center.x + GobsProperties.TRI_MOUSE_RADIUS && parent.mouseX >= center.x - GobsProperties.TRI_MOUSE_RADIUS 
				&& parent.mouseY <= center.y + GobsProperties.TRI_MOUSE_RADIUS && parent.mouseY >= center.y - 5)
		{
			// If the user click, let's stick the center to the mouse
			if (parent.mousePressed && !stuckToMouse)
				stuckToMouse = true;
			mouseHover = true;
			parent.cursor(PApplet.HAND);
		}
		else
		{
			mouseHover = false;
			parent.cursor(PApplet.ARROW);
		}
			


		// Is the center being released?
		if (stuckToMouse && !parent.mousePressed)
		{
			stuckToMouse = false;
			
			// Calculating the speed, distance and direction
			PVector aboluteDirection = PVector.sub(centerOrigin, center);
			lastDistance = PApplet.dist(center.x, center.y, centerOrigin.x, centerOrigin.y);
			speed = (lastDistance/GobsProperties.TRI_INITIAL_SPEED_RATIO);
			
			
			// Reducing the direction vector to 1 pixel movement, the speed will be handled independently
			if (PApplet.abs(aboluteDirection.y) > PApplet.abs(aboluteDirection.x))
				direction = new PVector(aboluteDirection.x / PApplet.abs(aboluteDirection.y), aboluteDirection.y/ PApplet.abs(aboluteDirection.y));
			else
				direction = new PVector(aboluteDirection.x / PApplet.abs(aboluteDirection.x), aboluteDirection.y/ PApplet.abs(aboluteDirection.x));
			
			
		}
			
		
		// If the center is stuck to the mouse, let's follow it
		if (stuckToMouse)
		{
			center.x = parent.mouseX;
			center.y = parent.mouseY;
		}
		// Otherwise if the center still have some speed, let it move
		else if (speed != 0)
		{

			float distance = PApplet.dist(center.x, center.y, centerOrigin.x, centerOrigin.y);
			
			// If the speed is minimal close to the center, let's kill the movement
			if (PApplet.abs(speed)<0.01 && distance <2 )
			{
				speed=0;
				center.x = centerOrigin.x;
				center.y = centerOrigin.y;
				return;
			}
			
			// Incrementing or decrementing the speed depending on the distance from its original point
			if (distance <= lastDistance )
			{
				if (speed>0)
					speed += distance/GobsProperties.TRI_DISTANCE_SPEED_RATIO;
				else
					speed -= distance/GobsProperties.TRI_DISTANCE_SPEED_RATIO;
			}
				
			else
			{
				if (speed>0)
					speed -= distance/GobsProperties.TRI_DISTANCE_SPEED_RATIO;
				else
					speed += distance/GobsProperties.TRI_DISTANCE_SPEED_RATIO;
			}
				
			
			lastDistance = distance;
			
			// Perpetuum Mobile does not exists on earth so let's lose some speed
			if ((GobsProperties.TRI_DISTANCE_SPEED_LOSS * distance) < PApplet.abs(speed))
				if (speed>0)
					speed -= (GobsProperties.TRI_DISTANCE_SPEED_LOSS * distance);
				else
					speed += (GobsProperties.TRI_DISTANCE_SPEED_LOSS * distance);
			
			center.x += (direction.x * speed);
			center.y += (direction.y * speed);
			
		}
		
			
		
	}
	
	public void drawMe()
	{
		applyColor();
		
		parent.triangle(top.x, top.y, left.x, left.y, right.x, right.y);
		parent.line(top.x, top.y, center.x, center.y);
		parent.line(left.x, left.y, center.x, center.y);
		parent.line(right.x, right.y, center.x, center.y);
		
		
		if (fillColor != null)
		{
			fillColor.fill(parent);
			parent.ellipse(top.x, top.y, GobsProperties.TRI_POINT_SIZE, GobsProperties.TRI_POINT_SIZE);
			parent.ellipse(left.x, left.y, GobsProperties.TRI_POINT_SIZE, GobsProperties.TRI_POINT_SIZE);
			parent.ellipse(right.x, right.y, GobsProperties.TRI_POINT_SIZE, GobsProperties.TRI_POINT_SIZE);
			if (mouseHover)
				parent.ellipse(center.x, center.y, GobsProperties.TRI_POINT_HOVER_SIZE, GobsProperties.TRI_POINT_HOVER_SIZE);
			else
				parent.ellipse(center.x, center.y, GobsProperties.TRI_POINT_SIZE, GobsProperties.TRI_POINT_SIZE);

		}
		
		move();
	}
	
	
}
