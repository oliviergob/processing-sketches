package movinTriangle2;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;


@SuppressWarnings("serial")
public class MovinTriangleApplet extends PApplet 
{
	List<Triangle> movinTriangles = new ArrayList<>();

	public void setup() 
	{
		background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		
		float triangleWidth = width / GobsProperties.TRIANGLE_PER_ROW;
		float triangleHeight = height / GobsProperties.TRIANGLE_PER_COLLUM;
		
		List<PVector> currentRow = null;
		List<PVector> previousRow = null;
		boolean evenRow = true;
		
		// For each row
		for (float rowY = 0; rowY<= height; rowY+=triangleHeight)
		{
			// Let's save the previous row
			if (currentRow != null)
				previousRow = currentRow;
			
			// Let's differentiate odd and even rows
			float columnX = 0;
			if (evenRow)
			{
				columnX = 0;
				evenRow = false;
			}
			else
			{
				columnX = (triangleWidth / 2) * -1;
				evenRow = true;
			}
			
			// Let's construct a row
			currentRow = new ArrayList<>();
			for (; columnX<= width + (triangleWidth / 2); columnX+=triangleWidth)
			{
				currentRow.add(new PVector(columnX, rowY));
			}
			
			if (previousRow != null)
			{
				
				if (!evenRow)
					for (int i = 0; i < currentRow.size() && i+1 < previousRow.size(); i++)
					{
						movinTriangles.add(new Triangle(currentRow.get(i), previousRow.get(i), previousRow.get(i + 1), this));
						if (i > 0)
							movinTriangles.add(new Triangle(previousRow.get(i), currentRow.get(i), currentRow.get(i -1), this));
					}
				else
					for (int i = 0; i < previousRow.size() && i+1 < currentRow.size(); i++)
					{
						movinTriangles.add(new Triangle(previousRow.get(i), currentRow.get(i + 1), currentRow.get(i), this));
						if (i > 0)
							movinTriangles.add(new Triangle(currentRow.get(i), previousRow.get(i -1), previousRow.get(i), this));
					}
						
			}	
		}				
		
		smooth(4);
	}

	public void draw() 
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR.getRed(), GobsProperties.BG_COLOR.getGreen(), GobsProperties.BG_COLOR.getBlue());
		
		for (Triangle movinTriangle : movinTriangles)
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
