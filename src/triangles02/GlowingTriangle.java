package triangles02;

import processing.core.PApplet;

public class GlowingTriangle extends Triangle
{
		
	public GlowingTriangle(PApplet parent) {
		super(parent);
	}
	
	
	public void drawMyBluryPart()
	{
		//parent.noStroke();
		//fillColor.fill(parent);
		//parent.ellipse(location.x, location.y, (radius + GobsProperties.PARTICULE_RADIUS_BLUR_EXTRA) * 2, (radius + GobsProperties.PARTICULE_RADIUS_BLUR_EXTRA) * 2);
		
	}
	public boolean drawMyNonBluryPart()
	{
		return drawMe();
		
	}


	
}
