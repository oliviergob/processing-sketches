package lightExperiment2;

import processing.core.PApplet;

public class RGBColor
{
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
	private int opacity = 255;
	
	public RGBColor(int red, int green, int blue) 
	{
		this(red, green, blue, 255);
	}

	public RGBColor(int red, int green, int blue, int opacity) 
	{
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.opacity = opacity;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}
	
	public void fill(PApplet pApplet)
	{
		pApplet.fill(red, green, blue, opacity);
	}
	
	public void stroke(PApplet pApplet)
	{
		pApplet.stroke(red, green, blue, opacity);
	}
	
	protected RGBColor clone()
	{
		return new RGBColor(red, green, blue, opacity);
	}
	
	public boolean makeDarker(int decrement)
	{
		boolean returnValue = false;
		if (red > 0)
		{
			red -= decrement;
			returnValue = true;
		}
		if (green > 0)
		{
			green -= decrement;
			returnValue = true;
		}
		if (blue > 0)
		{
			blue -= decrement;
			returnValue = true;
		}
		
		return returnValue;
	}
	
	public boolean addColor(RGBColor increment)
	{
		boolean returnValue = false;
		if (red < 255)
		{
			red += increment.red;
			returnValue = true;
		}
		if (green < 255)
		{
			green += increment.green;
			returnValue = true;
		}
		if (blue < 255)
		{
			blue += increment.blue;
			returnValue = true;
		}
		
		return returnValue;
	}
	
	public boolean isBlack()
	{
		return ( red==0 && green==0 && blue==0); 
	}
	
}
