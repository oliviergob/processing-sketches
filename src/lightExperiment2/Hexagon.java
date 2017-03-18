package lightExperiment2;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Hexagon
{
	
	private PVector center;
	private PApplet parent;
	private int size;
	private RGBColor fillColor = null;
	private PVector[] points = new PVector[6];
	private List<Hexagon> neighbors = new ArrayList<>();
	
	public Hexagon(PVector center, PApplet parent)
	{
		super();
		this.center = center;
		this.parent = parent;
		
		
		size = GobsProperties.HEX_SIZE;
		
		for (int i = 0; i < 6 ; i++)
		{
			double angle = (2 * PConstants.PI / 6 * (i + 0.5));
			float x = PApplet.round(center.x + size * PApplet.cos((float) angle));
			float y = PApplet.round((int) center.y + size * PApplet.sin((float) angle));
			
			points[i] = new PVector(x,y);
		}
	}
	
	public void enLight(RGBColor rgbColor, Integer index)
	{
		if (fillColor == null)
			fillColor = rgbColor.clone();
		else
			fillColor.addColor(rgbColor);
		
		RGBColor darkerColor = rgbColor.clone();
		if (darkerColor.makeDarker(GobsProperties.RGB_TRANSMISSION_DECREMENT) && !darkerColor.isBlack())
		{
			if (index == null)
			for (int i=0; i<neighbors.size(); i++)
			{
				Hexagon hexagon = neighbors.get(i);
				hexagon.enLight(darkerColor, i);
			}
			else if (neighbors.size() > index)
			{
				neighbors.get(index).enLight(darkerColor, index);
			}
		}
		
		
	}
	
	public void applyColor()
	{
		
		if (fillColor != null)
		{
			fillColor.fill(parent);
			fillColor.stroke(parent);
		}
		else
			parent.noFill();
	}
	
	public void drawMe()
	{
		applyColor();
		if (fillColor != null)
		{
			for (int i = 1; i< 6 ; i ++)
			{
				parent.triangle(points[i-1].x,points[i-1].y,points[i].x, points[i].y, center.x, center.y);
				parent.strokeWeight(2);
				parent.line(points[i-1].x,points[i-1].y, center.x, center.y);
				parent.strokeWeight(1);
				
				if (i == 5)
				{
					parent.triangle(points[0].x,points[0].y,points[i].x, points[i].y, center.x, center.y);
					parent.strokeWeight(2);
					parent.line(points[i].x,points[i].y, center.x, center.y);
					parent.strokeWeight(1);
				}
						
			}
			
			if (!fillColor.makeDarker(GobsProperties.RGB_DECREMENT))
				fillColor = null;
		}
		
	}
	
	public void addNeighBor(Hexagon neighbor)
	{
		if (!neighbors.contains(neighbor))
			neighbors.add(neighbor);
		
		neighbor.neighbors.add(this);
	}
	
	
	

}
