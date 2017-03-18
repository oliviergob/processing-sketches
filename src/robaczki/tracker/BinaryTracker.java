package robaczki.tracker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import robaczki.geometry.Robaki;
import robaczki.geometry.RoundedLocation;

public class BinaryTracker extends LocationTracker
{


	public BinaryTracker(long totalWrittablePixels, int maxPercentWrittable) {
		super(totalWrittablePixels, maxPercentWrittable);
	}

	// Default Main color is white
	private int colorZero = 255;
	// Default Secondary color is black
	private int colorOne = 0;
	private boolean writePrimary = true;
	
	protected Set<RoundedLocation> writtenLocation = new HashSet<RoundedLocation>();

	@Override
	public void track(float x, float y, int size) 
	{
		
		if (writePrimary)
		 {
			 if (writtenLocation.add(new RoundedLocation(x, y)))
				 totalWrittenPixels+=size; 
		 }
		 else
		 {
			 if (writtenLocation.remove(new RoundedLocation(x, y)))
				 totalWrittenPixels+=size; 
		 }
		
	}

	@Override
	public void computeChanges(List<Robaki> robakis) {
		// If we reached the pixel coverage limit
		 if (totalWrittenPixels >= (totalWrittablePixels*maxPercentWrittable)/100)
		 {
			 // Toggling 
			 if (writePrimary)
				 writePrimary = false;
			 	else
			 		writePrimary = true;
			 
			 // Changing the color of all our robaki
			 for (Robaki robaki : robakis) 
			 {
				 if (writePrimary)
					 robaki.setRobakStrokeColor(colorZero);
				 else
					 robaki.setRobakStrokeColor(colorOne);
			  }
			 
			 // Setting back the written pixels to zero
			 totalWrittenPixels = totalWrittablePixels-totalWrittenPixels;
		 }
		
	}
	


}
