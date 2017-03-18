package drops2;


import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class DropsApplet extends PApplet
{

	private static final long serialVersionUID = -6082159703318195489L;

	private List<Drop> dropList = new ArrayList<>();
	private List<Drop> deadLinePool = new ArrayList<>();
	private int cycleNb = GobsProperties.NB_CYCLES_BETWEEN;
	private Drop center = null;
	

	public void setup()
	{
		
		background(GobsProperties.BG_COLOR);

		if (!GobsProperties.FOR_WEB_EXPORT)
			size(GobsProperties.SCR_WIDTH, GobsProperties.SCR_HEIGHT);
		
		center = new Drop(this, null);
		for (int j = 0 ; j <= 10 ; j++)
		{
			Drop drop = new Drop(this, center);
			deadLinePool.add(drop);

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
				Drop drop = deadLinePool.remove(deadLinePool.size() -1);
				drop.init();
				dropList.add(drop);
			}
			else
			{
				Drop drop = new Drop(this, center);
				drop.init();
				dropList.add(drop);
			}
			cycleNb = 0;
		}
		cycleNb++;
		
		List<Drop> newDropList = new ArrayList<>();
		for (Drop drop : dropList)
		{
			if (!drop.move())
				deadLinePool.add(drop);
			else
				newDropList.add(drop);
		}
		dropList = newDropList;
		
		if (GobsProperties.GIF_EXPORT)
			if (frameCount % GobsProperties.GIF_FRAME_RATIO == 0 && frameCount > GobsProperties.GIF_START_FRAME && frameCount <= (GobsProperties.GIF_START_FRAME - (GobsProperties.GIF_NB_FRAME * GobsProperties.GIF_FRAME_RATIO )))
				saveFrame(GobsProperties.GIF_NAME);
		
		if (GobsProperties.PIC_EXPORT)
			if (frameCount == GobsProperties.PIC_FRAME )
				saveFrame(GobsProperties.PIC_NAME);

	}
	

	public float getRandom(float min, float max)
	{
		return min + random(max - min);
	}

	public int getIntRandom(float min, float max)
	{
		return (int) (min + random(max - min));
	}

	public boolean getBooleanRandom()
	{
		return (random(100) > 50);
	}
}
