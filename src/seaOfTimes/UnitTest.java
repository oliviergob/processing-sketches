package seaOfTimes;

import java.util.Random;

import processing.core.PApplet;

public class UnitTest
{
	
	static PApplet pApplet = new PApplet();

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	
		
		for (int i= 0; i < 500; i++)
		{
			System.out.println(getIntRandom(0,2));
			//System.out.println(pApplet.random(1));
		}
		
		

	}
	
	
	static public boolean getBooleanRandom()
    {
    	return (pApplet.random(100) > 50);
    }
	
	static public boolean getJavaBooleanRandom()
	{
		Random random = new Random();
		return random.nextBoolean();
	}
	
	static public boolean oneInNChance(int n)
    {
    	int random = (int) pApplet.random(n);
    	int test = (int) (n/2);
    	return (random == test);
    }
	
	static public int getIntRandom(int min, int max)
    {

    	int random = Math.round(getRandom(min,max));
    	return random;
    }
    
	static public float getRandom(float min, float max)
    {
    	return min+pApplet.random(max-min);
    }
    

}
