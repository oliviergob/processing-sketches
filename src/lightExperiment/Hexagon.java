package lightExperiment;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Hexagon
{
	
	private PVector center;
	private PApplet parent;
	private int size;
	private RGBColor strokeColor = null;
	private RGBColor fillColor = null;
	private PVector[] points = new PVector[6]; 
	
	public Hexagon(PVector center, PApplet parent)
	{
		super();
		this.center = center;
		this.parent = parent;
		
		if (GobsProperties.HEX_STROKE_COLOUR != null)
			strokeColor = GobsProperties.HEX_STROKE_COLOUR.clone();
		
		if (GobsProperties.HEX_FILL_COLOUR != null)
			fillColor = GobsProperties.HEX_FILL_COLOUR.clone();
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
		if (strokeColor != null)
			strokeColor.stroke(parent);
		else
			parent.noStroke();
		
		if (fillColor != null)
			fillColor.fill(parent);
		else
			parent.noFill();
	}
	
	public void drawMe()
	{
		applyColor();
		
		for (int i = 1; i< 6 ; i ++)
		{
			//parent.line(points[i-1].x,points[i-1].y,points[i].x, points[i].y);
			
			if (fillColor != null)
			{
					parent.triangle(points[i-1].x,points[i-1].y,points[i].x, points[i].y, center.x, center.y);
				
				if (i == 5)
				{
					parent.triangle(points[0].x,points[0].y,points[i].x, points[i].y, center.x, center.y);
				}
				
			}
			
		}
		
	}
	
	
	

}
