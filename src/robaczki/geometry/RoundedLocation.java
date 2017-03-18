package robaczki.geometry;

public class RoundedLocation 
{
	private int x = 0;
	private int y = 0;
	
	public RoundedLocation(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public RoundedLocation(float x, float y) {
		super();
		this.x = Math.round(x);
		this.y = Math.round(y);
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
    public int hashCode() {
           final int prime = 31;
           int result = 1;
           result = prime * result + new Integer(x).hashCode();
           result = prime * result + new Integer(y).hashCode();
           
           return result;
    }

	
	 public boolean equals(Object obj) {
	        if (obj == null)
	            return false;
	        if (obj == this)
	            return true;
	        if (!(obj instanceof RoundedLocation))
	            return false;
	        
	        RoundedLocation other = (RoundedLocation)obj;
	        
	        Integer a = new Integer(1);
	        a.hashCode();

	        return ((this.x == other.x) && (this.y == other.y));
	    }

	
	

}
