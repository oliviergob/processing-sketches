package lightExperiment3;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class HexagonalLights extends PApplet 
{

	private ArrayList<Hexagon> hexagonList = new ArrayList<>();


	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
				
		
		int rowStart = 0;
		ArrayList<Hexagon> currentRow = null;
		ArrayList<Hexagon> previousRow = null;

		for (int j = 0 ; j <= height + GobsProperties.HEX_SIZE; j+= GobsProperties.HEX_Y_SPACING )
		{
			if (rowStart == 0)
				rowStart = (int) ((sqrt(3)/2 * GobsProperties.HEX_SIZE * 2) / 2);
			else rowStart = 0;
			
			currentRow = new ArrayList<>();
			
			for (int i = rowStart; i <= width + GobsProperties.HEX_SIZE; i+= (sqrt(3)/2 * GobsProperties.HEX_SIZE * 2))
			{
				Hexagon hexagon = new Hexagon(new PVector(i,j), this);
				if (hexagonList.size() > 0)
					hexagon.addNeighBor(hexagonList.get(hexagonList.size() - 1));
					
				hexagonList.add(hexagon);
				currentRow.add(hexagon);
				
				if (previousRow!= null)
				{
					if (rowStart != 0)
					{
						if (previousRow.size() > currentRow.size() )
							hexagon.addNeighBor(previousRow.get(currentRow.size()));
					}
					else
					{
						if (currentRow.size()>1)
							hexagon.addNeighBor(previousRow.get(currentRow.size() - 2));
					}
						
					if (previousRow.size() >= currentRow.size() )
						hexagon.addNeighBor(previousRow.get(currentRow.size() - 1));
					
				}
					
			}
			
			previousRow = currentRow;
		}
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
/*		if (oneInNChance(GobsProperties.HEX_SPAWN_CHANCE))
		{
			Hexagon hexagon = hexagonList.get(getIntRandom(0, hexagonList.size() - 1));
			hexagon.enLight(GobsProperties.HEX_FILL_COLOUR, null);
		}*/
		

		for (Hexagon hexagon : hexagonList)
		{
				hexagon.drawMe();
		}
		
		if (GobsProperties.GIF_EXPORT)
			if (frameCount % GobsProperties.GIF_FRAME_RATIO == 0 && frameCount > GobsProperties.GIF_START_FRAME && frameCount <= (GobsProperties.GIF_START_FRAME + (GobsProperties.GIF_NB_FRAME * GobsProperties.GIF_FRAME_RATIO )))
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
