package drops;


import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class DropsApplet extends PApplet
{

	private static final long serialVersionUID = -6082159703318195489L;

	private List<DropLine> dropLineList = new ArrayList<>();
	private List<DropLine> deadLinePool = new ArrayList<>();
	private int cycleNb = GobsProperties.NB_CYCLES_BETWEEN;
	

	public void setup()
	{
		
		background(GobsProperties.BG_COLOR);

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		for (int j = 0 ; j <= 5 ; j++)
		{
			DropLine dropLine = new DropLine(this);
			deadLinePool.add(dropLine);

		}

	}

	public void draw()
	{
		if (GobsProperties.REFRESH_BG)
			background(GobsProperties.BG_COLOR);
		if (cycleNb >= GobsProperties.NB_CYCLES_BETWEEN)
		{
			if (deadLinePool.size() >= 1)
			{
				DropLine dropLine = deadLinePool.remove(deadLinePool.size() -1);
				dropLine.init();
				dropLineList.add(dropLine);
			}
			else
			{
				DropLine dropLine = new DropLine(this);
				dropLine.init();
				dropLineList.add(dropLine);
			}
			cycleNb = 0;
		}
		cycleNb++;
		
		List newDropLineList = new ArrayList<>();
		for (DropLine dropline : dropLineList)
		{
			if (!dropline.move())
				deadLinePool.add(dropline);
			else
				newDropLineList.add(dropline);
		}
		dropLineList = newDropLineList;
		
		if ((this.frameCount % 1) == 0)
			saveFrame("drop-######.jpg");
	}
	

	public float getRandom(float min, float max)
	{
		return min + random(max - min);
	}

	public int getIntRandom(int min, int max)
	{
		return (int) (min + random(max - min));
	}

	public boolean getBooleanRandom()
	{
		return (random(100) > 50);
	}
}
