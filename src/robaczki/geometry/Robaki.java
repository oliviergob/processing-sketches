package robaczki.geometry;
import processing.core.PApplet;
import processing.core.PVector;
import robaczki.applet.GobsProperties;
import robaczki.applet.RobakProcessingApplet;
import robaczki.tracker.LocationTracker;

public abstract class Robaki {
  protected PVector location;
  protected int velocity;
  private PVector direction;
  protected Integer robakStrokeColor = null;
  protected Integer robakFillColor = null;
  protected RobakProcessingApplet parent;
  private LocationTracker tracker;
  
  Robaki(int p1, int p2, int maxVelocity, RobakProcessingApplet parent, LocationTracker tracker )
  {
    location = new PVector(p1,p2);
    direction = new PVector(parent.random(2)-1,parent.random(2)-1);
    this.parent = parent;
    this.tracker = tracker;
  }
  
  Robaki(RobakProcessingApplet parent, LocationTracker tracker)  
  {
    this((int)parent.random(parent.startWidth),(int)parent.random(parent.startHeight),GobsProperties.MAX_VELOCITY, parent, tracker);
  }
  
  /** This method can be overridden to reinitialize specific variables before the a move cycle starts */
  public void startMoveCycle() 
  {

  }
  
  public void move()
  {
	  if (!GobsProperties.REFRESH_BG)
	  {
		  for (int i = 0; i < velocity; i++)
		  {
			  location.add(direction);
			  if ((location.x > parent.width) || (location.x < 0)) {
				  direction.x = direction.x * -1;
			  }
			  if ((location.y > parent.height) || (location.y < 0)) {
				  direction.y = direction.y * -1;
			  }
			  
			  tracker.track(location.x, location.y, getSize());
			  drawMe();
		  }
	  }
	  else
	  {
		  location.add(PVector.mult(direction, velocity));
		  if ((location.x > parent.width) || (location.x < 0)) {
			  direction.x = direction.x * -1;
		  }
		  if ((location.y > parent.height) || (location.y < 0)) {
			  direction.y = direction.y * -1;
		  }
		  
		  tracker.track(location.x, location.y, getSize());
		  drawMe();
	  }
	  
		
  }
  
  public abstract void drawMe();
  
  public abstract int getSize();
  
  public abstract void interact(Robaki rabczki);
  
  public abstract float getInteractionRadius();
  
	public boolean isColliding(Robaki rabczki)
	{
		float deltaX = rabczki.getLocation().x - location.x;
		float deltaY = rabczki.getLocation().y - location.y;
		float centerToCenterdistance = PApplet.sqrt(deltaX*deltaX + deltaY*deltaY);
		float minDist = rabczki.getInteractionRadius() + this.getInteractionRadius();
		
		return centerToCenterdistance <= minDist;
	}
  
  public void setRobakStrokeColor(int robakColor)
  {
    this.robakStrokeColor = robakColor;
  }
  
  public void applyColor()
  {
	  if (robakStrokeColor!= null)
		  parent.stroke(robakStrokeColor);
	  else
		  parent.noStroke();
	  if (robakFillColor!= null)
		  parent.fill(robakFillColor);
	  else
		  parent.noFill();
  }

public PVector getLocation() {
	return location;
}

public void setLocation(PVector location) {
	this.location = location;
}

public int getVelocity() {
	return velocity;
}

public void setVelocity(int velocity) {
	this.velocity = velocity;
}

public int getRobakStrokeColor() {
	return robakStrokeColor;
}

public PVector getDirection() {
	return direction;
}

public void setDirection(PVector direction) {
	this.direction = direction;
}

public int getRobakFillColor() {
	return robakFillColor;
}

public void setRobakFillColor(int robakFillColor) {
	this.robakFillColor = robakFillColor;
}


  
  
}