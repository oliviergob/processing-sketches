package drops;

import java.util.ArrayList;
import java.util.List;

public class DropLine 
{
	private float minY = 0;
	List<Drop> dropList = new ArrayList<>();
	private DropsApplet parent;
	int index = -1;
	boolean isAlive = false;
	
	
	
	public DropLine(DropsApplet parent) 
	{
		super();
		this.parent = parent;
		
		for (int i = parent.getIntRandom(0, GobsProperties.DROP_X_SPACING) - GobsProperties.DROP_X_SPACING; i <= parent.width + GobsProperties.DROP_X_SPACING; i += GobsProperties.DROP_X_SPACING )
		{
			Drop drop = new Drop(i, parent);
			drop.applyNoise();
			addDrop(drop);
		}
		
	}
	
	
	public void init()
	{
		for (Drop drop : dropList)
		{
			drop.reInit();
		}
		isAlive = true;
	}

	private void addDrop(Drop drop)
	{
		if (dropList.size() >= 1)
			drop.setNextDrop(dropList.get(dropList.size()-1));
		dropList.add(drop);
		
	}
	
	public boolean move()
	{
		if (!isAlive)
			return isAlive;
		
		minY = 999999;
		for (Drop drop : dropList)
		{
			float yLocation = drop.move();
			if (yLocation < minY)
				minY = yLocation;
		}
		
		if (minY >= parent.height)
			isAlive = false;
		
		return isAlive;
	}

}
