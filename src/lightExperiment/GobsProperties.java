package lightExperiment;



public class GobsProperties
{
	
	public static final RGBColor COLOUR_WHITE = new RGBColor(255, 255, 255);
	public static final RGBColor COLOUR_DARK_BLUE = new RGBColor(0, 0, 102);
	public static final RGBColor COLOUR_BLACK = new RGBColor(0, 0, 0);
	public static final int COLOUR_RED = -65536;
	public static final int COLOUR_STRANGE = -3667456;
	public static final RGBColor COLOUR_BLUE = new RGBColor(0, 128, 255);

	
	public static final boolean FOR_WEB_EXPORT = false;
	public static final int SCR_WIDTH = 500;
	public static final int SCR_HEIGHT = 350;
	public static final boolean REFRESH_BG = true;
	public static final RGBColor BG_COLOR = COLOUR_BLACK;
	
	public static final boolean GIF_EXPORT = true;
	private final static String PICTURE_BASE_NAME = "hexagon-dance-04";
	public final static String GIF_NAME = PICTURE_BASE_NAME +"-####.tif";
	public static final int GIF_START_FRAME = 0;
	public static final int GIF_NB_FRAME = 30;
	public static final int GIF_FRAME_RATIO = 1;
	
	public static final boolean PIC_EXPORT = false;
	public static final int PIC_FRAME = 200;
	public final static String PIC_NAME = PICTURE_BASE_NAME +"web-####.jpg";

	
	public static final RGBColor HEX_FILL_COLOUR = COLOUR_BLUE;
	public static final RGBColor HEX_STROKE_COLOUR = null;
	public static final int HEX_SIZE = 20;
	public static final int HEX_Y_SPACING = ( GobsProperties.HEX_SIZE * 2) * 3/ 4;
	public static final int HEX_SPACING_VARIATION = 12;
	public static final float HEX_INCREMENT = (float) 1;
	

}
