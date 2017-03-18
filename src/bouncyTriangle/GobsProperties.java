package bouncyTriangle;



public class GobsProperties
{
	
	public static final RGBColor COLOUR_WHITE = new RGBColor(255, 255, 255);
	public static final RGBColor COLOUR_DARK_BLUE = new RGBColor(0, 0, 102);
	public static final RGBColor COLOUR_BLACK = new RGBColor(0, 0, 0);
	public static final int COLOUR_RED = -65536;
	public static final int COLOUR_STRANGE = -3667456;
	public static final RGBColor COLOUR_BLUE = new RGBColor(0, 128, 255);
	public static final RGBColor COLOUR_YELLOWISH = new RGBColor(243, 197, 90);
	public static final RGBColor COLOUR_YELLOWISH_TRANS = new RGBColor(243, 197, 90, 150);

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 500;
	public static final int SCR_HEIGHT = 400;
	public static final boolean REFRESH_BG = true;
	public static final RGBColor BG_COLOR = COLOUR_BLACK;
	
	public static final boolean GIF_EXPORT = false;
	private final static String PICTURE_BASE_NAME = "movin-triangle-01";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.gif";
	public static final int GIF_START_FRAME = 0;
	public static final int GIF_NB_FRAME = 60;
	public static final int GIF_FRAME_RATIO = 4;
	
	public static final boolean PIC_EXPORT = false;
	public static final int PIC_FRAME = 220;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";

	public static final RGBColor TRI_STROKE_COLOUR = COLOUR_YELLOWISH_TRANS;
	public static final RGBColor TRI_FILL_COLOUR = COLOUR_YELLOWISH;
	public static final int TRI_MARGIN = 50;
	public static final int TRI_POINT_SIZE = 6;
	public static final int TRI_POINT_HOVER_SIZE = 10;
	

	
	public static final int TRI_DISTANCE_SPEED_RATIO = 20;
	public static final float TRI_DISTANCE_SPEED_LOSS = (float) 0.01;
	public static final int TRI_INITIAL_SPEED_RATIO = 10;
	public static final int TRI_MOUSE_RADIUS = 5;
	


}
