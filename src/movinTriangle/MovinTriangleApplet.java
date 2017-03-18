package movinTriangle;

import processing.core.PApplet;


@SuppressWarnings("serial")
public class MovinTriangleApplet extends PApplet 
{
	
	Triangle movinTriangle;


	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		
		movinTriangle = new Triangle(this);				
		
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
		movinTriangle.drawMe();

		
		if (GobsProperties.GIF_EXPORT)
			if (frameCount % GobsProperties.GIF_FRAME_RATIO == 0 && frameCount >= GobsProperties.GIF_START_FRAME && frameCount <= (GobsProperties.GIF_START_FRAME + (GobsProperties.GIF_NB_FRAME * GobsProperties.GIF_FRAME_RATIO )))
				saveFrame(GobsProperties.GIF_NAME);
		
		if (GobsProperties.PIC_EXPORT)
			if (frameCount == GobsProperties.PIC_FRAME )
				saveFrame(GobsProperties.PIC_NAME);
	}
	
	public boolean getBooleanRandom()
    {
    	return (random(100) > 50);
    }
	
	public boolean oneInNChance(int n)
    {
    	int random = (int) random(n);
    	int test = (int) (n/2);
    	return (random == test);
    }
	
    public int getIntRandom(int min, int max)
    {

    	int random = (int) (min+random(max-min));
    	return random;
    }
}
