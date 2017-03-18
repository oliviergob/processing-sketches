package hexagonallights;



public class GobsProperties
{
	
	public static final int COLOUR_WHITE = 255;
	public static final int COLOUR_DARK_BLUE = -16774616;
	public static final int COLOUR_BLACK = 0;
	public static final int COLOUR_RED = -65536;
	public static final int COLOUR_STRANGE = -3667456;
	public static final int COLOUR_BLUE = -13395457;

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 500;
	public static final int SCR_HEIGHT = 350;
	public static final boolean REFRESH_BG = true;
	public static final int BG_COLOR = COLOUR_BLACK;
	
	public static final boolean GIF_EXPORT = false;
	private final static String PICTURE_BASE_NAME = "hexagon-dance";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.jpg";
	public static final int GIF_START_FRAME = 0;
	public static final int GIF_NB_FRAME = 30;
	public static final int GIF_FRAME_RATIO = 1;
	
	public static final boolean PIC_EXPORT = false;
	public static final int PIC_FRAME = 200;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";

	
	public static final int HEX_FILL_COLOUR = COLOUR_BLUE;
	public static final int HEX_STROKE_COLOUR = COLOUR_DARK_BLUE;
	public static final int HEX_SIZE = 20;
	public static final int HEX_Y_SPACING = ( GobsProperties.HEX_SIZE * 2) * 3/ 4;
	public static final int HEX_SPACING_VARIATION = 12;
	public static final float HEX_INCREMENT = (float) 1;
	
	
	


}
