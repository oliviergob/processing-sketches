package triangles03.stairs02;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Triangle
{
	protected PVector top;
	protected PVector left;
	protected PVector right;
	protected PApplet parent;
	protected RGBColor strokeColor = GobsProperties.COLOR_WHITE;
	protected RGBColor fillColor = GobsProperties.COLOR_WHITE;
	protected float speed = GobsProperties.TRIANGLE_ORIGINAL_SPEED;
	protected int age = 0;
	protected float size = GobsProperties.TRIANGLE_ORIGINAL_SIZE;
	
	private final static PVector dirTop = new PVector(0,-1);
	private final static PVector dirLeft = new PVector(-1,1);
	private final static PVector dirRight = new PVector(1,1);
	
	public Triangle(PVector top, PVector left, PVector right, PApplet parent)
	{
		super();
		this.top = new PVector(top.x, top.y);
		this.left = new PVector(left.x, left.y);
		this.right = new PVector(right.x, right.y);
		this.parent = parent;
		
		if (GobsProperties.TRI_STROKE_COLOUR != null)
			strokeColor = GobsProperties.TRI_STROKE_COLOUR.clone();
		
		if (GobsProperties.TRI_FILL_COLOUR != null)
			fillColor = GobsProperties.TRI_FILL_COLOUR.clone();
		
	}
	
	public Triangle(PApplet parent)
	{
		
		this(new PVector(Math.round(parent.width / 2), Math.round(parent.height / 2)) , 
				new PVector(Math.round(parent.width / 2), Math.round(parent.height / 2)),
				new PVector(Math.round(parent.width / 2), Math.round(parent.height / 2)), parent);
	}
	
	
	public void applyColor()
	{
		if (strokeColor != null)
			strokeColor.stroke(parent);
		else
			parent.noStroke();

		if (fillColor != null)
			fillColor.fill(parent);
		else
			parent.noFill();
	}
	
	public boolean move()
	{
		left.x += ( dirLeft.x * speed * GobsProperties.TRIANGLE_WIDTH_RATIO);
		left.y += ( dirLeft.y * speed);
		right.x += ( dirRight.x * speed * GobsProperties.TRIANGLE_WIDTH_RATIO);
		right.y += ( dirRight.y * speed);
		top.x += ( dirTop.x * speed);
		top.y += ( dirTop.y * speed);
		
		size+=GobsProperties.TRIANGLE_SIZE_INCREMENT;
		speed+= GobsProperties.TRIANGLE_SPEED_INCREMENT;
		age++;
		
		return (age < GobsProperties.TRIANGLE_LIFE_SPAN) ;
	}
	
	public boolean drawMe()
	{
		applyColor();
		
		parent.beginShape();
		// Exterior part of shape
		parent.vertex(top.x, top.y);
		parent.vertex(left.x, left.y);
		parent.vertex(right.x, right.y);
		// Interior part of shape
		parent.endShape(PConstants.CLOSE);
		
		GobsProperties.BG_COLOR.fill(parent);
		parent.beginShape();
		parent.vertex(top.x, top.y + size);
		parent.vertex(left.x + (size*2), left.y - size);
		parent.vertex(right.x - (size*2), right.y - size);
		parent.endShape(PConstants.CLOSE);
		
				
		return move();
	}
}
