package robaczki.tracker;

import java.util.ArrayList;
import java.util.List;

import robaczki.geometry.Robaki;


public abstract class LocationTracker 
{
	
	protected long totalWrittablePixels = 0;
	protected long totalWrittenPixels = 0;
	protected int maxPercentWrittable= 0;
	protected List<Robaki> trackedRobaczki = new ArrayList<>();
	
	public void addRobaczek(Robaki robaczek)
	{
		trackedRobaczki.add(robaczek);
	}
	
	public LocationTracker(long totalWrittablePixels, int maxPercentWrittable) 
	{
		super();
		this.totalWrittablePixels = totalWrittablePixels;
		this.maxPercentWrittable = maxPercentWrittable;
	}

	public abstract void track(float x, float y, int size);
	
	public void move()
	{
		for (int i = 0; i < trackedRobaczki.size(); i ++) 
		 {
			 trackedRobaczki.get(i).startMoveCycle();
		 }
		
		// Painting all the robaczki
		 for (int i = 0; i < trackedRobaczki.size(); i ++) 
		 {
			 trackedRobaczki.get(i).move();
			 
			 for (int j = 0; j < trackedRobaczki.size(); j ++) 
			 {
				 if (j != i)
					 trackedRobaczki.get(j).interact(trackedRobaczki.get(i));
			 }
		 }
	}
	
	public abstract void computeChanges(List<Robaki> robakis) ;

	public void setTotalWrittablePixels(long totalWrittablePixels) 
	{
		this.totalWrittablePixels = totalWrittablePixels;
	}
	
	

}
