package robaczki.applet;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import robaczki.geometry.Luciola;
import robaczki.geometry.MagneticField;
import robaczki.geometry.MouseMagneticField;
import robaczki.geometry.Robaki;
import robaczki.tracker.LocationTracker;
import robaczki.tracker.SimpleTracker;

public class RobakProcessingApplet extends PApplet {

/** Serial Version UID */
private static final long serialVersionUID = 3541443012242759217L;
private List<Robaki> robaczki = new ArrayList<>();
public int startWidth = width;
public int startHeight = height;
private LocationTracker tracker;

public void setup() {

	background(GobsProperties.BG_COLOR);
 
  if (!GobsProperties.FOR_WEB_EXPORT)
	  size(GobsProperties.SCR_WIDTH,GobsProperties.SCR_HEIGHT);
  
  startWidth = width;
  startHeight = height;
  
  //tracker = new BinaryTracker(width*height, GobsProperties.MAX_PIXEL_COVERAGE_PRCT);
  tracker = new SimpleTracker(width*height, GobsProperties.MAX_PIXEL_COVERAGE_PRCT);
  
  int robakLenght = GobsProperties.MIN_ROBAKI+(int)random(GobsProperties.MAX_ROBAKI-GobsProperties.MIN_ROBAKI);
  
  for (int i = 0; i <  robakLenght; i ++ )
  {
	  robaczki.add(new Luciola(this, tracker));
	  robaczki.get(i).setVelocity(getIntRandom(GobsProperties.MIN_VELOCITY, GobsProperties.MAX_VELOCITY));
	  
	  tracker.addRobaczek(robaczki.get(i));
  }
  
  int previousSize = robaczki.size();
  
  for (int i = 0; i <  GobsProperties.MAGNETIC_FIELDS; i ++ )
  {
	  robaczki.add(new MagneticField(this, tracker));
	  robaczki.get(i+previousSize).drawMe();
	  tracker.addRobaczek(robaczki.get(i+previousSize));
  }
  
  if (GobsProperties.MOUSE_MAGNETIC_FIELD)
  {
	  Robaki mouseMagneticField = new MouseMagneticField(this, tracker);
	  robaczki.add(mouseMagneticField);
	  tracker.addRobaczek(mouseMagneticField);
  }
  
 
}

public void draw() 
{
	
	
	if (GobsProperties.REFRESH_BG)
		background(GobsProperties.BG_COLOR);
	
	 
	
super.paintComponents(getGraphics());
setMouseXY();
 tracker.move();
 tracker.computeChanges(robaczki);
 	
}


    static public void main(String args[]) {
        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "RobakProcessing" });
    }
    
    
    public int getRandomRadius()
    {
    	return GobsProperties.MIN_RADIUS+(int)random(GobsProperties.MAX_RADIUS-GobsProperties.MIN_RADIUS);
    }
    
    public float getRandom(int min, int max)
    {
    	return min+random(max-min);
    }
    
    public int getIntRandom(int min, int max)
    {
    	return (int) (min+random(max-min));
    }
    
    public boolean getBooleanRandom()
    {
    	return (random(100) > 50);
    }
    

	void setMouseXY() 
    {
    	
       	if (GobsProperties.FOR_WEB_EXPORT)
    		return;
    				
    		Point mouse, winloc;
            mouse = MouseInfo.getPointerInfo().getLocation();
            
          	  winloc = getLocationOnScreen();
            
            mouseX = mouse.x-winloc.x;
            mouseY = mouse.y-winloc.y;
    }
    
}



