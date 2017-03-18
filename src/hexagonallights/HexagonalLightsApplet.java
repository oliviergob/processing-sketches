package hexagonallights;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class HexagonalLightsApplet extends PApplet 
{

	private ArrayList<Hexagon> hexagonList = new ArrayList<>();


	public void setup() 
	{
		
		//noLoop();
		
		background(GobsProperties.BG_COLOR);

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
				
		
		int rowStart = 0;
		
		for (int j = 0 ; j <= height + GobsProperties.HEX_SIZE; j+= GobsProperties.HEX_Y_SPACING )
		{
			int triangleOff = 0;
			if (rowStart == 0)
				rowStart = (int) ((sqrt(3)/2 * GobsProperties.HEX_SIZE * 2) / 2);
			else rowStart = 0;
			
			for (int i = rowStart; i <= width + GobsProperties.HEX_SIZE; i+= (sqrt(3)/2 * GobsProperties.HEX_SIZE * 2))
			{
				hexagonList.add(new Hexagon(new PVector(i,j), this, triangleOff));
				
				if (triangleOff>= 5)
					triangleOff = 0;
				else
					triangleOff++;
				
			}
		}
		
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR);

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
}
