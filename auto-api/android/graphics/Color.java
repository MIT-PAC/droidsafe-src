package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.MathUtils;
import java.util.HashMap;
import java.util.Locale;

public class Color {
    public static final int BLACK       = 0xFF000000;
    public static final int DKGRAY      = 0xFF444444;
    public static final int GRAY        = 0xFF888888;
    public static final int LTGRAY      = 0xFFCCCCCC;
    public static final int WHITE       = 0xFFFFFFFF;
    public static final int RED         = 0xFFFF0000;
    public static final int GREEN       = 0xFF00FF00;
    public static final int BLUE        = 0xFF0000FF;
    public static final int YELLOW      = 0xFFFFFF00;
    public static final int CYAN        = 0xFF00FFFF;
    public static final int MAGENTA     = 0xFFFF00FF;
    public static final int TRANSPARENT = 0;
    private static final HashMap<String, Integer> sColorNameMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "186E870C2FD55DFF0EBE6B8A51AF560E", hash_generated_method = "89AA4190DA2CB715B8B22E620ECCBFCD")
    public static int alpha(int color) {
        return color >>> 24;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "4DD589701E4616BA47B948814EEFA62E", hash_generated_method = "CDAFBC587B77D8A86F03744E5A7B44EE")
    public static int red(int color) {
        return (color >> 16) & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "5809CEAF07E4362D00D2201A47AD6598", hash_generated_method = "4396A6EB8ADD6B1AE76CDB68A0E576C4")
    public static int green(int color) {
        return (color >> 8) & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "F7EE0AD6B5FEC8E1C17A6ECF2237A359", hash_generated_method = "530EE26BE2899B5E67FC33DA1E821FC4")
    public static int blue(int color) {
        return color & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "7F1A78AF2C66358AFEB07F450298B658", hash_generated_method = "A9D55D095326FAFCC942AC8A70FD058E")
    public static int rgb(int red, int green, int blue) {
        return (0xFF << 24) | (red << 16) | (green << 8) | blue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "E9E5A1EEE7C04648C972ABDF10B63B33", hash_generated_method = "BF01FB48C23E8A4B3D28C29EC47F4C6E")
    public static int argb(int alpha, int red, int green, int blue) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.017 -0400", hash_original_method = "F562985E094FAB41C0929069F7EFE8D1", hash_generated_method = "A66FF49F97066FE02C2FBBFF09D210D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "E0C473B1C058E704D5BF11A300CA2D54", hash_generated_method = "D1EC474CB165D3225EAE9EC555C03136")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "D6758F319DD78E16480F6A6EAFA895B2", hash_generated_method = "6BF6E18793A2BF100ABBE32A3CDF6F4A")
    public static float brightness(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        int V = Math.max(b, Math.max(r, g));
        return (V / 255.f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "5CE0C2D7CC9A97F7407CFA85151EC53E", hash_generated_method = "413DCE093FC3CB210DFAAE454773993E")
    public static int parseColor(String colorString) {
        if (colorString.charAt(0) == '#') {
            long color = Long.parseLong(colorString.substring(1), 16);
            if (colorString.length() == 7) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "A6DC82312CC05525C4EDA100C7030059", hash_generated_method = "E0EB1235C5A74D15A23344DCA4CDDBF1")
    public static int HSBtoColor(float[] hsb) {
        return HSBtoColor(hsb[0], hsb[1], hsb[2]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "E70811FE9C0865EEAC6AAF5133BC7797", hash_generated_method = "2E6CC05F61C3ABF74E783B54C41644CC")
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
            case 0:         
                red = b;
                green = tv;
                blue = pv;
                break;
            case 1:         
                red = qv;
                green = b;
                blue = pv;
                break;
            case 2:
                red = pv;
                green = b;
                blue = tv;
                break;
            case 3:         
                red = pv;
                green = qv;
                blue = b;
                break;
            case 4:
                red = tv;
                green = pv;
                blue = b;
                break;
            case 5:         
                red = b;
                green = pv;
                blue = qv;
                break;
        }
        return 0xFF000000 | (((int) (red * 255.0f)) << 16) |
                (((int) (green * 255.0f)) << 8) | ((int) (blue * 255.0f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "A7C53B8C18974DA71D8345A9FB5FCA17", hash_generated_method = "967AB50A93E41E01104A5FA8AA950BBA")
    public static void RGBToHSV(int red, int green, int blue, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        nativeRGBToHSV(red, green, blue, hsv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "05D5BF6DA908F496FD007CC1987325E5", hash_generated_method = "73F79E924F5B25AEE8C8D14FE95F1BA2")
    public static void colorToHSV(int color, float hsv[]) {
        RGBToHSV((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF, hsv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.018 -0400", hash_original_method = "C941C94EC2830D733291C7020E6CF834", hash_generated_method = "36A1A9638D239C97D62615392477B6E6")
    public static int HSVToColor(float hsv[]) {
        return HSVToColor(0xFF, hsv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.019 -0400", hash_original_method = "11E4D1D9F03C7C44A0CBC902A480F9CD", hash_generated_method = "14AD95AA2615FA2FF0C63374F2B31E6F")
    public static int HSVToColor(int alpha, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        return nativeHSVToColor(alpha, hsv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.019 -0400", hash_original_method = "9A1F2FC1B6129A49478BCF684C4ABD3E", hash_generated_method = "95B96F5B480A902B8A30F850D184EA4D")
    private static void nativeRGBToHSV(int red, int greed, int blue, float hsv[]) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.019 -0400", hash_original_method = "DB38BA81D20D8D6ED161666F4B33032A", hash_generated_method = "EDFAD2753CEBE130047FB95BC66E1D89")
    private static int nativeHSVToColor(int alpha, float hsv[]) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
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


