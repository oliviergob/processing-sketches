package triangles03.stairs02;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class GrowingTrianglesApplet extends PApplet 
{
	

	List<GlowingTriangle> glowingParticles = new ArrayList<>();
	int index = 0;
	
	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		smooth(8);
		
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
		
		if ( frameCount % GobsProperties.TRIANGLE_RELEASE_RATE == 0)
		{
			GlowingTriangle gt = new GlowingTriangle(this);
			glowingParticles.add(gt);
		}
		
//		for (GlowingTriangle glowingParticle : glowingParticles)
//		{
//			glowingParticle.drawMyBluryPart();
//		}
//		
//		filter( PApplet.BLUR, GobsProperties.TRIANGLE_BLUR);
		int deleteIndex = -1;
		for (int i = 0; i < glowingParticles.size(); i++)
		{
			GlowingTriangle glowingParticle = glowingParticles.get(i);
			if (! glowingParticle.drawMyNonBluryPart())
				deleteIndex = i;
		}
		if (deleteIndex >= 0)
			glowingParticles.remove(deleteIndex);
		
		
		if (GobsProperties.GIF_EXPORT)
			if (frameCount % GobsProperties.GIF_FRAME_RATIO == 0 && frameCount >= GobsProperties.GIF_START_FRAME && frameCount <= (GobsProperties.GIF_START_FRAME + (GobsProperties.GIF_NB_FRAME * GobsProperties.GIF_FRAME_RATIO )))
			{
				System.out.println("Exporting Frame "+frameCount);
				saveFrame(GobsProperties.GIF_NAME);
			}
				
		
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

    	int random = Math.round(getRandom(min,max));
    	return random;
    }
    
    public float getRandom(float min, float max)
    {
    	return min+random(max-min);
    }
    
    public PVector getDirectionBetweenVectors(PVector origin, PVector destination)
    {
    	
		PVector aboluteDirection = PVector.sub(destination, origin);

		// Reducing the direction vector to 1 pixel movement, so the speed can be handled independently
		if (PApplet.abs(aboluteDirection.y) > PApplet.abs(aboluteDirection.x))
			return new PVector(aboluteDirection.x / PApplet.abs(aboluteDirection.y), aboluteDirection.y/ PApplet.abs(aboluteDirection.y));
		else
			return new PVector(aboluteDirection.x / PApplet.abs(aboluteDirection.x), aboluteDirection.y/ PApplet.abs(aboluteDirection.x));
		
    }
    
    
    
    
}
