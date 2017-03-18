package hexagonallights;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Hexagon
{
	
	private PVector center;
	private PApplet parent;
	private int size;
	private int strokeColor = -1;
	private int fillColor = -1;
	private int triangleOff = 0;
	private PVector[] points = new PVector[6]; 
	
	public Hexagon(PVector center, PApplet parent, int triangleOff)
	{
		super();
		this.center = center;
		this.parent = parent;
		this.triangleOff = triangleOff;
		strokeColor = GobsProperties.HEX_STROKE_COLOUR;
		fillColor = GobsProperties.HEX_FILL_COLOUR;
		size = GobsProperties.HEX_SIZE;
		
		for (int i = 0; i < 6 ; i++)
		{
			double angle = (2 * PConstants.PI / 6 * (i + 0.5));
			float x = center.x + size * PApplet.cos((float) angle);
			float y = center.y + size * PApplet.sin((float) angle);
			
			points[i] = new PVector(x,y);
		}
	}
	
	
	public void applyColor()
	{
		if (strokeColor != -1)
			parent.stroke(strokeColor);
		else
			parent.noStroke();
		if (fillColor != -1)
			parent.fill(fillColor);
		else
			parent.noFill();
	}
	
	public void drawMe()
	{
		applyColor();
		
		for (int i = 1; i< 6 ; i ++)
		{
			parent.line(points[i-1].x,points[i-1].y,points[i].x, points[i].y);
			
			if (fillColor != -1)
			{
				if (triangleOff != i)
					parent.triangle(points[i-1].x,points[i-1].y,points[i].x, points[i].y, center.x, center.y);
				
				if (i == 5 && triangleOff != 0)
				{
					parent.triangle(points[0].x,points[0].y,points[i].x, points[i].y, center.x, center.y);
				}
				
			}
			
		}
		
		if (parent.frameCount % 4 == 0)
		{
			if (triangleOff>= 5)
				triangleOff = 0;
			else
				triangleOff++;
		}
		
	}
	
	
	

}
