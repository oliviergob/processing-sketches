package movinTriangle;

import movinTriangle.GobsProperties;
import movinTriangle.RGBColor;
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
	
	boolean newCycle = true;
	PVector dir1;
	PVector dir2;
	PVector dir3;
	private PVector centerOrigin;
	
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
		if (newCycle)
		{
			dir1 = PVector.sub(center, left);
			dir2 = PVector.sub(right, center);
			dir3 = PVector.sub(left, right);
			
			dir1.div(200);
			dir2.div(200);
			dir3.div(200);
			newCycle = false;
		}
		
		left.add(dir1);
		center.add(dir2);
		right.add(dir3);
		
		if 
		((int)left.x == (int)centerOrigin.x && (int)left.y == (int)centerOrigin.y)
		{

			PVector tempCenter = center;
			center = left;
			left = right;
			right = tempCenter;
			newCycle = true;
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
			parent.ellipse(center.x, center.y, GobsProperties.TRI_POINT_SIZE, GobsProperties.TRI_POINT_SIZE);
			
			strokeColor.fill(parent);
			parent.text(String.format("[%s,%s]", (int)left.x, (int)left.y ),left.x - 60,left.y);
			parent.text(String.format("[%s,%s]", (int)right.x, (int)right.y ),right.x - 60,right.y);
			parent.text(String.format("[%s,%s]", (int)center.x, (int)center.y ),center.x - 60,center.y);
			parent.noFill();
		}
		
		move();
	}
	
	
}
