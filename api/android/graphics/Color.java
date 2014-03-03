package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Locale;

import android.util.MathUtils;

import droidsafe.helpers.DSUtils;

public class Color {

    /**
     * Return the alpha component of a color int. This is the same as saying
     * color >>> 24
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.581 -0500", hash_original_method = "186E870C2FD55DFF0EBE6B8A51AF560E", hash_generated_method = "89AA4190DA2CB715B8B22E620ECCBFCD")
    
public static int alpha(int color) {
        return color >>> 24;
    }

    /**
     * Return the red component of a color int. This is the same as saying
     * (color >> 16) & 0xFF
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.583 -0500", hash_original_method = "4DD589701E4616BA47B948814EEFA62E", hash_generated_method = "CDAFBC587B77D8A86F03744E5A7B44EE")
    
public static int red(int color) {
        return (color >> 16) & 0xFF;
    }

    /**
     * Return the green component of a color int. This is the same as saying
     * (color >> 8) & 0xFF
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.591 -0500", hash_original_method = "5809CEAF07E4362D00D2201A47AD6598", hash_generated_method = "4396A6EB8ADD6B1AE76CDB68A0E576C4")
    
public static int green(int color) {
        return (color >> 8) & 0xFF;
    }

    /**
     * Return the blue component of a color int. This is the same as saying
     * color & 0xFF
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.594 -0500", hash_original_method = "F7EE0AD6B5FEC8E1C17A6ECF2237A359", hash_generated_method = "530EE26BE2899B5E67FC33DA1E821FC4")
    
public static int blue(int color) {
        return color & 0xFF;
    }

    /**
     * Return a color-int from red, green, blue components.
     * The alpha component is implicity 255 (fully opaque).
     * These component values should be [0..255], but there is no
     * range check performed, so if they are out of range, the
     * returned color is undefined.
     * @param red  Red component [0..255] of the color
     * @param green Green component [0..255] of the color
     * @param blue  Blue component [0..255] of the color
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.596 -0500", hash_original_method = "7F1A78AF2C66358AFEB07F450298B658", hash_generated_method = "A9D55D095326FAFCC942AC8A70FD058E")
    
public static int rgb(int red, int green, int blue) {
        return (0xFF << 24) | (red << 16) | (green << 8) | blue;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static int argb(int alpha, int red, int green, int blue) {
		return 0;  //Value doesn't really matter
        //return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    /**
     * Returns the hue component of a color int.
     * 
     * @return A value between 0.0f and 1.0f
     * 
     * @hide Pending API council
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.602 -0500", hash_original_method = "F562985E094FAB41C0929069F7EFE8D1", hash_generated_method = "A66FF49F97066FE02C2FBBFF09D210D6")
    
public static float hue(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        int V = Math.max(b, Math.max(r, g));
        int temp = Math.min(b, Math.min(r, g));

        float H;

        if (V == temp) {
            H = 0;
        } else {
            final float vtemp = (float) (V - temp);
            final float cr = (V - r) / vtemp;
            final float cg = (V - g) / vtemp;
            final float cb = (V - b) / vtemp;

            if (r == V) {
                H = cb - cg;
            } else if (g == V) {
                H = 2 + cr - cb;
            } else {
                H = 4 + cg - cr;
            }

            H /= 6.f;
            if (H < 0) {
                H++;
            }
        }

        return H;
    }

    /**
     * Returns the saturation component of a color int.
     * 
     * @return A value between 0.0f and 1.0f
     * 
     * @hide Pending API council
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.604 -0500", hash_original_method = "E0C473B1C058E704D5BF11A300CA2D54", hash_generated_method = "D1EC474CB165D3225EAE9EC555C03136")
    
public static float saturation(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        int V = Math.max(b, Math.max(r, g));
        int temp = Math.min(b, Math.min(r, g));

        float S;

        if (V == temp) {
            S = 0;
        } else {
            S = (V - temp) / (float) V;
        }

        return S;
    }

    /**
     * Returns the brightness component of a color int.
     * 
     * @return A value between 0.0f and 1.0f
     * 
     * @hide Pending API council
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.607 -0500", hash_original_method = "D6758F319DD78E16480F6A6EAFA895B2", hash_generated_method = "6BF6E18793A2BF100ABBE32A3CDF6F4A")
    
public static float brightness(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        int V = Math.max(b, Math.max(r, g));

        return (V / 255.f);
    }

    /**
     * Parse the color string, and return the corresponding color-int.
     * If the string cannot be parsed, throws an IllegalArgumentException
     * exception. Supported formats are:
     * #RRGGBB
     * #AARRGGBB
     * 'red', 'blue', 'green', 'black', 'white', 'gray', 'cyan', 'magenta',
     * 'yellow', 'lightgray', 'darkgray'
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.875 -0500", hash_original_method = "5CE0C2D7CC9A97F7407CFA85151EC53E", hash_generated_method = "28B6A49374B219A22FA475188B5E8A2E")
    
public static int parseColor(String colorString) {
        if (colorString.charAt(0) == '#') {
            // Use a long to avoid rollovers on #ffXXXXXX
            long color = Long.parseLong(colorString.substring(1), 16);
            if (colorString.length() == 7) {
                // Set the alpha value
                color |= 0x00000000ff000000;
            } else if (colorString.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            }
            return (int)color;
        } else {
            Integer color = sColorNameMap.get(colorString.toLowerCase(Locale.US));
            if (color != null) {
                return color;
            }
        }
        throw new IllegalArgumentException("Unknown color");
    }

    /**
     * Convert HSB components to an ARGB color. Alpha set to 0xFF.
     *     hsv[0] is Hue [0 .. 1)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * If hsv values are out of range, they are pinned.
     * @param hsb  3 element array which holds the input HSB components.
     * @return the resulting argb color
     * 
     * @hide Pending API council
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.877 -0500", hash_original_method = "A6DC82312CC05525C4EDA100C7030059", hash_generated_method = "E0EB1235C5A74D15A23344DCA4CDDBF1")
    
public static int HSBtoColor(float[] hsb) {
        return HSBtoColor(hsb[0], hsb[1], hsb[2]);
    }
    
    /**
     * Convert HSB components to an ARGB color. Alpha set to 0xFF.
     *     hsv[0] is Hue [0 .. 1)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * If hsv values are out of range, they are pinned.
     * @param h Hue component
     * @param s Saturation component
     * @param b Brightness component
     * @return the resulting argb color
     * 
     * @hide Pending API council
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.880 -0500", hash_original_method = "E70811FE9C0865EEAC6AAF5133BC7797", hash_generated_method = "F1D1B2B444EC9B708082A424DEC06B8C")
    
public static int HSBtoColor(float h, float s, float b) {
        h = MathUtils.constrain(h, 0.0f, 1.0f);
        s = MathUtils.constrain(s, 0.0f, 1.0f);
        b = MathUtils.constrain(b, 0.0f, 1.0f);
        
        float red = 0.0f;
        float green = 0.0f;
        float blue = 0.0f;
        
        final float hf = (h - (int) h) * 6.0f;
        final int ihf = (int) hf;
        final float f = hf - ihf;
        final float pv = b * (1.0f - s);
        final float qv = b * (1.0f - s * f);
        final float tv = b * (1.0f - s * (1.0f - f));

        switch (ihf) {
            case 0:         // Red is the dominant color
                red = b;
                green = tv;
                blue = pv;
                break;
            case 1:         // Green is the dominant color
                red = qv;
                green = b;
                blue = pv;
                break;
            case 2:
                red = pv;
                green = b;
                blue = tv;
                break;
            case 3:         // Blue is the dominant color
                red = pv;
                green = qv;
                blue = b;
                break;
            case 4:
                red = tv;
                green = pv;
                blue = b;
                break;
            case 5:         // Red is the dominant color
                red = b;
                green = pv;
                blue = qv;
                break;
        }

        return 0xFF000000 | (((int) (red * 255.0f)) << 16) |
                (((int) (green * 255.0f)) << 8) | ((int) (blue * 255.0f));
    }

    /**
     * Convert RGB components to HSV.
     *     hsv[0] is Hue [0 .. 360)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * @param red  red component value [0..255]
     * @param green  green component value [0..255]
     * @param blue  blue component value [0..255]
     * @param hsv  3 element array which holds the resulting HSV components.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.884 -0500", hash_original_method = "A7C53B8C18974DA71D8345A9FB5FCA17", hash_generated_method = "967AB50A93E41E01104A5FA8AA950BBA")
    
public static void RGBToHSV(int red, int green, int blue, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        nativeRGBToHSV(red, green, blue, hsv);
    }

    /**
     * Convert the argb color to its HSV components.
     *     hsv[0] is Hue [0 .. 360)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * @param color the argb color to convert. The alpha component is ignored.
     * @param hsv  3 element array which holds the resulting HSV components.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.887 -0500", hash_original_method = "05D5BF6DA908F496FD007CC1987325E5", hash_generated_method = "73F79E924F5B25AEE8C8D14FE95F1BA2")
    
public static void colorToHSV(int color, float hsv[]) {
        RGBToHSV((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF, hsv);
    }

    /**
     * Convert HSV components to an ARGB color. Alpha set to 0xFF.
     *     hsv[0] is Hue [0 .. 360)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * If hsv values are out of range, they are pinned.
     * @param hsv  3 element array which holds the input HSV components.
     * @return the resulting argb color
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.889 -0500", hash_original_method = "C941C94EC2830D733291C7020E6CF834", hash_generated_method = "36A1A9638D239C97D62615392477B6E6")
    
public static int HSVToColor(float hsv[]) {
        return HSVToColor(0xFF, hsv);
    }

    /**
     * Convert HSV components to an ARGB color. The alpha component is passed
     * through unchanged.
     *     hsv[0] is Hue [0 .. 360)
     *     hsv[1] is Saturation [0...1]
     *     hsv[2] is Value [0...1]
     * If hsv values are out of range, they are pinned.
     * @param alpha the alpha component of the returned argb color.
     * @param hsv  3 element array which holds the input HSV components.
     * @return the resulting argb color
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.891 -0500", hash_original_method = "11E4D1D9F03C7C44A0CBC902A480F9CD", hash_generated_method = "14AD95AA2615FA2FF0C63374F2B31E6F")
    
public static int HSVToColor(int alpha, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        return nativeHSVToColor(alpha, hsv);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRGBToHSV(int red, int green, int blue, float hsv[]) {
        hsv[0] = (red + green + blue);
        hsv[1] = (red + green + blue);
        hsv[2] = (red + green + blue);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeHSVToColor(int alpha, float hsv[]) {
        return (int)(alpha + hsv[0] + hsv[1] + hsv[2]);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.547 -0500", hash_original_field = "40C6B57D4F537C98C100CDD3283B6A16", hash_generated_field = "5072579A5D175A2DD4305C5328287571")

    public static final int BLACK       = 0xFF000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.550 -0500", hash_original_field = "49C4DBA04C3EC54B10E2DF33C6833BAF", hash_generated_field = "B8C852650D7AE5F902A75378E28D1D47")

    public static final int DKGRAY      = 0xFF444444;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.552 -0500", hash_original_field = "BF65165B1F1FD839E69AE0E4B35A8471", hash_generated_field = "A3DCDA70E01C1CDB92B62BB9790C4D02")

    public static final int GRAY        = 0xFF888888;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.555 -0500", hash_original_field = "C4A85EBF1EE983A8288233EC16951D38", hash_generated_field = "FA9BDC1A7B25025D0B489026AAFBCDA2")

    public static final int LTGRAY      = 0xFFCCCCCC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.557 -0500", hash_original_field = "037DA2A73FD38605F9E891E42A78E6E6", hash_generated_field = "E5909B2D31AE695BFE6C777A22DC2090")

    public static final int WHITE       = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.560 -0500", hash_original_field = "68E18FD8413E9A1C53EC0BDB50386170", hash_generated_field = "FE5E4AEF33775CE96FF2D28E3B3DA1AE")

    public static final int RED         = 0xFFFF0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.562 -0500", hash_original_field = "0F6945A597965471FC34BDB10D79CCFC", hash_generated_field = "D123D6C0498127A29E26D063855EFB90")

    public static final int GREEN       = 0xFF00FF00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.564 -0500", hash_original_field = "E548B3BD040D2E1A7C292684A6833C5B", hash_generated_field = "8757960F9963054C3589C55F11331733")

    public static final int BLUE        = 0xFF0000FF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.567 -0500", hash_original_field = "7AF5B483EEF48EB3879912A8B263F132", hash_generated_field = "AE37C0C255DAC03720EA6C9409A65BAE")

    public static final int YELLOW      = 0xFFFFFF00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.569 -0500", hash_original_field = "C8E9089704C51D605E865A2E4D57DA8A", hash_generated_field = "86E348F666B1DD9D443BEB347F546AB8")

    public static final int CYAN        = 0xFF00FFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.572 -0500", hash_original_field = "BF1A426810209839D12228AEC5F32C1F", hash_generated_field = "E8A32CBE213D2FD1C781AA2CDF6EE501")

    public static final int MAGENTA     = 0xFFFF00FF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.574 -0500", hash_original_field = "5E499F3A02BE2D8A19172EE5606FCDCA", hash_generated_field = "D1E6A6F7B8292E96032F6DA425E91847")

    public static final int TRANSPARENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:23.901 -0500", hash_original_field = "211C76855DAC46B1B9C87BD8B441D16C", hash_generated_field = "498D8E53A8FACBB74E1A4ED57C16330E")

    private static  HashMap<String, Integer> sColorNameMap;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.684 -0400", hash_original_method = "34DAB7DC9B66BC3931AEC17E77DE7DFA", hash_generated_method = "34DAB7DC9B66BC3931AEC17E77DE7DFA")
    public Color ()
    {
        //Synthesized constructor
    }
    static {
        sColorNameMap = new HashMap<String, Integer>();
        sColorNameMap.put("black", BLACK);
        sColorNameMap.put("darkgray", DKGRAY);
        sColorNameMap.put("gray", GRAY);
        sColorNameMap.put("lightgray", LTGRAY);
        sColorNameMap.put("white", WHITE);
        sColorNameMap.put("red", RED);
        sColorNameMap.put("green", GREEN);
        sColorNameMap.put("blue", BLUE);
        sColorNameMap.put("yellow", YELLOW);
        sColorNameMap.put("cyan", CYAN);
        sColorNameMap.put("magenta", MAGENTA);
    }
    
}

