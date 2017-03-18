package seaOfTimes2;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class SeaOfTimesApplet extends PApplet 
{
	

	List<GlowingParticle> glowingParticles = new ArrayList<>();
	List<GlowingParticle> glowingParticlesRightPool = new ArrayList<>();
	List<GlowingParticle> glowingParticlesLeftPool = new ArrayList<>();
	int index = 0;
	int poolSize = GobsProperties.PARTICULE_POOL_SIZE;
	PVector present;
	PVector topOfTheWave;
	
	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		
		present = new PVector(width/2, height/2 );
		topOfTheWave = new PVector(present.x, present.y - 50);
		
		int minY = (height/2) - GobsProperties.PARTICULE_SPAWNING_ZONE;
		int maxY = (height/2) + GobsProperties.PARTICULE_SPAWNING_ZONE;
		
		for (int i = 0; i < poolSize; i++)
		{
			/*if (i % 2 == 0)
				glowingParticlesPool.add(new GlowingParticle(0, getIntRandom(minY, maxY), this));
			else
				glowingParticlesPool.add(new GlowingParticle(width, getIntRandom(minY, maxY), this));*/
			
			glowingParticlesRightPool.add(new GlowingParticle(0, getIntRandom(minY, maxY), this, getRandom(GobsProperties.PARTICULE_SPEED_MIN, GobsProperties.PARTICULE_SPEED_MAX)));
			glowingParticlesLeftPool.add(new GlowingParticle(width, getIntRandom(minY, maxY), this, getRandom(GobsProperties.PARTICULE_SPEED_MIN, GobsProperties.PARTICULE_SPEED_MAX)));
		}
		
		
		
		smooth(8);
		
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
		
		if ( frameCount % GobsProperties.PARTICULE_RELEASE_RATE == 0)
		{
			GlowingParticle gp = (GlowingParticle) (glowingParticlesRightPool.get(index)).clone();
			glowingParticles.add(gp);
			gp.resetLocation();
			
			gp = (GlowingParticle) (glowingParticlesLeftPool.get(index)).clone();
			glowingParticles.add(gp);
			gp.resetLocation();
			
			index++;
			if (index == poolSize)
				index = 0;
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
				
		}
		
		glowingParticles = tempGlowingParticles;
		

		
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
