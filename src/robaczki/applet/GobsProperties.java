package robaczki.applet;

import processing.core.PApplet;

public class GobsProperties extends PApplet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850736190489749563L;
	
	public static final int COLOUR_WHITE = 255;
	public static final int COLOUR_DARK_BLUE = -16774616;
	public static final int COLOUR_BLACK = 0;
	public static final int COLOUR_RED = -65536;
	public static final int COLOUR_STRANGE = -3667456;

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 800;
	public static final int SCR_HEIGHT = 800;
	public static final boolean REFRESH_BG = true;
	public static final int BG_COLOR = COLOUR_BLACK;
	
	public static final int MIN_ROBAKI = 120;
	public static final int MAX_ROBAKI = 250;
	public static final int MAX_PIXEL_COVERAGE_PRCT = 85;
	public static final int MAX_VELOCITY = 1;
	public static final int MIN_VELOCITY = 1;
	public static final int MIN_RADIUS = 200;
	public static final int MAX_RADIUS = 300;
	
	public static final int MAGNETIC_FIELDS = 0;
	public static final int MAGNETIC_FIELDS_POWER = 2;
	
	public static final boolean MOUSE_MAGNETIC_FIELD = true;
	public static final int MOUSE_MAGNETIC_FIELD_RAD = 400;
	public static final int MOUSE_MAGNETIC_FIELDS_POWER = 4;
	
	
	public static final int LUCIOLA_MIN_RADIUS = 0;
	public static final int LUCIOLA_MAX_RADIUS = 4;
	public static final float LUCIOLA_RADIUS_INCREMENT = (float) 0.2;
	public static final Integer LUCIOLA_STROKE_COLOR = null;
	public static final Integer LUCIOLA_FILL_COLOR = COLOUR_WHITE;
	public static final Integer LUCIOLA_BORDER_COLOR = COLOUR_BLACK;
	public static int LUCIOLA_BORDER_SIZE = 0;


}
