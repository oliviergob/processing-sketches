package triangles;



public class GobsProperties
{
	
	public static final RGBColor COLOR_WHITE = new RGBColor(255, 255, 255);
	public static final RGBColor COLOR_DARK_BLUE = new RGBColor(0, 0, 102);
	public static final RGBColor COLOR_BLACK = new RGBColor(0, 0, 0);
	public static final int COLOR_RED = -65536;
	public static final int COLOR_STRANGE = -3667456;
	public static final RGBColor COLOR_BLUE = new RGBColor(0, 128, 255);
	public static final RGBColor COLOR_YELLOWISH = new RGBColor(243, 197, 90);
	public static final RGBColor COLOR_YELLOWISH_TRANS = new RGBColor(243, 197, 90, 150);

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 500;
	public static final int SCR_HEIGHT = 320;
	public static final boolean REFRESH_BG = true;
	public static final RGBColor BG_COLOR = COLOR_BLACK;
	
	public static final boolean GIF_EXPORT = false;
	private final static String PICTURE_BASE_NAME = "sea-of-time-01-";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.gif";
	public static final int GIF_START_FRAME = 2000;
	public static final int GIF_NB_FRAME = 66;
	public static final int GIF_FRAME_RATIO = 1;
	
	public static final boolean PIC_EXPORT = false;
	public static final int PIC_FRAME = 220;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";
	
	public final static float PARTICULE_SPEED_MIN = (float) 0.5;
	public final static float PARTICULE_SPEED_MAX = (float) 1.2;
	public final static RGBColor TRI_STROKE_COLOUR = COLOR_WHITE;
	public final static RGBColor TRI_FILL_COLOUR = null;
	
	public final static int TRIANGLE_RELEASE_RATE = 50;
	public final static int TRIANGLE_BLUR = 1;
	public final static int TRIANGLE_SPEED = 3;
	public final static int TRIANGLE_LIFE_SPAN = 1200;
	
	protected static final float TRIANGLE_ORIGINAL_SPEED = (float) 0.1;
	protected static final float TRIANGLE_SPEED_INCREMENT = (float) 0.001;
	
	public final static int LEFT_CUTTING_POINT_MARGIN = 70;
	

}
