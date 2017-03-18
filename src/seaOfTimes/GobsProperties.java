package seaOfTimes;



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
	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public static final boolean REFRESH_BG = true;
	public static final RGBColor BG_COLOR = COLOR_BLACK;
	
	public static final boolean GIF_EXPORT = false;
	private final static String PICTURE_BASE_NAME = "particle-accelerator-720p";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.tiff";
	public static final int GIF_START_FRAME = 0;
	public static final int GIF_NB_FRAME = 10000000;
	public static final int GIF_FRAME_RATIO = 1;
	
	public static final boolean PIC_EXPORT = false;
	public static final int PIC_FRAME = 220;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";
	
	public final static float PARTICULE_SPEED_MIN = (float) 1;
	public final static float PARTICULE_SPEED_MAX = (float) 2.5;
	public final static RGBColor PARTICULE_COLOR = COLOR_WHITE;
	public final static int PARTICULE_RADIUS = 2;
	public final static int PARTICULE_RADIUS_BLUR = 3;
	public final static int PARTICULE_BLUR = 2;
	public final static int PARTICULE_SPAWNING_ZONE = 40;
	public final static boolean PARTICULE_OSCLILATION = true;
	public final static int PARTICULE_OSCLILATION_FRAME_SPAN = 40;
	public final static float PARTICULE_OSCLILATION_DIFF = (float) 0.05;
	
	public final static int PARTICULE_POOL_SIZE = 150;
	public final static int PARTICULE_RELEASE_RATE = 4;
	


}
