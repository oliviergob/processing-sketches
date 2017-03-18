package seaOfTimes;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class SeaOfTimesApplet extends PApplet 
{
	

	List<GlowingParticle> glowingParticles = new ArrayList<>();
	List<GlowingParticle> glowingParticlesPool = new ArrayList<>();
	PVector present;
	
	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		
		present = new PVector(width/2, height/2 );
		
		int minY = (height/2) - GobsProperties.PARTICULE_SPAWNING_ZONE;
		int maxY = (height/2) + GobsProperties.PARTICULE_SPAWNING_ZONE;
		
		for (int i = 0; i < GobsProperties.PARTICULE_POOL_SIZE; i++)
		{
			glowingParticlesPool.add(new GlowingParticle(0, getIntRandom(minY, maxY), this));
		}
		
		
		
		smooth(8);
		
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
		if (glowingParticlesPool.size() != 0 && frameCount % GobsProperties.PARTICULE_RELEASE_RATE == 0)
		{
			GlowingParticle gp = glowingParticlesPool.remove(glowingParticlesPool.size()-1);
			glowingParticles.add(gp);
			gp.resetLocation();
		}
		
		for (GlowingParticle glowingParticle : glowingParticles)
		{
			glowingParticle.drawMyBluryPart();
		}
		List<GlowingParticle> tempGlowingParticles = new ArrayList<>();
		filter( PApplet.BLUR, GobsProperties.PARTICULE_BLUR);
		
		for (GlowingParticle glowingParticle : glowingParticles)
		{
			if ( glowingParticle.drawMyNonBluryPart())
				tempGlowingParticles.add(glowingParticle);
			else
				glowingParticlesPool.add(glowingParticle);
				
		}
		

		
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

    	int random = Math.round(getRandom(min,max));
    	return random;
    }
    
    public float getRandom(float min, float max)
    {
    	return min+random(max-min);
    }
    
    public PVector getPresent()
    {
    	return present;
    }
    
    public PVector getDirectionToPresent(PVector origin)
    {
    	return getDirectionBetweenVectors(origin, present);
    	
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
