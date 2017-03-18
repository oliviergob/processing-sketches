package lightExperiment;

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
	
}
