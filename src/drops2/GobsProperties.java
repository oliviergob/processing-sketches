package drops2;


public class GobsProperties
{
	
	public static final int COLOUR_WHITE = 255;
	public static final int COLOUR_DARK_BLUE = -16774616;
	public static final int COLOUR_BLACK = 0;
	public static final int COLOUR_RED = -65536;
	public static final int COLOUR_STRANGE = -3667456;

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 780;
	public static final int SCR_HEIGHT = 450;
	public static final boolean REFRESH_BG = true;
	public static final int BG_COLOR = COLOUR_BLACK;
	
	private final static String PICTURE_BASE_NAME = "electric-drop";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.tif";
	public static final boolean GIF_EXPORT = false;
	public static final int GIF_START_FRAME = 200;
	public static final int GIF_NB_FRAME = 30;
	public static final int GIF_FRAME_RATIO = 4;
	
	public static final boolean PIC_EXPORT = true;
	public static final int PIC_FRAME = 200;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";

	
	public static final int DROP_X_SPACING = 100;
	public static final int DROP_X_MARGIN = 50;
	public static final int DROP_Y_SPACING = 100;
	
	
	public static final int DROP_MIN_RADIUS = 2;
	public static final int DROP_MAX_RADIUS = 6;
	public static final int DROP_X_RANDOM_FACTOR = 3;
	public static final int DROP_Y_RANDOM_FACTOR = 2;
	public static final boolean DROP_RANDOM_SPEED = true;
	public static final float DROP_MIN_VELOCITY = (float) 4;
	public static final float DROP_MAX_VELOCITY = 6;
	public static final float DROP_RADIUS_INCREMENT = (float) 0.1;
	public static final Integer DROP_STROKE_COLOR = null;
	public static final Integer DROP_FILL_COLOR = COLOUR_WHITE;
	public static int DROP_BORDER_SIZE = 0;
	public static final int NB_CYCLES_BETWEEN = 5;
	


}
