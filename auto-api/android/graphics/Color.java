package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.MathUtils;
import java.util.HashMap;
import java.util.Locale;

public class Color {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.869 -0400", hash_original_method = "34DAB7DC9B66BC3931AEC17E77DE7DFA", hash_generated_method = "34DAB7DC9B66BC3931AEC17E77DE7DFA")
    public Color ()
    {
        //Synthesized constructor
    }


        public static int alpha(int color) {
        return color >>> 24;
    }

    
        public static int red(int color) {
        return (color >> 16) & 0xFF;
    }

    
        public static int green(int color) {
        return (color >> 8) & 0xFF;
    }

    
        public static int blue(int color) {
        return color & 0xFF;
    }

    
        public static int rgb(int red, int green, int blue) {
        return (0xFF << 24) | (red << 16) | (green << 8) | blue;
    }

    
        public static int argb(int alpha, int red, int green, int blue) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    
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

    
        public static float brightness(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        int V = Math.max(b, Math.max(r, g));
        return (V / 255.f);
    }

    
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

    
        public static int HSBtoColor(float[] hsb) {
        return HSBtoColor(hsb[0], hsb[1], hsb[2]);
    }

    
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

    
        public static void RGBToHSV(int red, int green, int blue, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        nativeRGBToHSV(red, green, blue, hsv);
    }

    
        public static void colorToHSV(int color, float hsv[]) {
        RGBToHSV((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF, hsv);
    }

    
        public static int HSVToColor(float hsv[]) {
        return HSVToColor(0xFF, hsv);
    }

    
        public static int HSVToColor(int alpha, float hsv[]) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        return nativeHSVToColor(alpha, hsv);
    }

    
        private static void nativeRGBToHSV(int red, int greed, int blue, float hsv[]) {
    }

    
        private static int nativeHSVToColor(int alpha, float hsv[]) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.903 -0400", hash_original_field = "1C74640C2388295DA44E834656E8B3FB", hash_generated_field = "5072579A5D175A2DD4305C5328287571")

    public static final int BLACK       = 0xFF000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "DEFD65D7258B8101686036FD2B26AE1F", hash_generated_field = "B8C852650D7AE5F902A75378E28D1D47")

    public static final int DKGRAY      = 0xFF444444;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "396F4379577CFF11C28B805386700D6F", hash_generated_field = "A3DCDA70E01C1CDB92B62BB9790C4D02")

    public static final int GRAY        = 0xFF888888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "E580179C29E89368EB9C9F39C689F942", hash_generated_field = "FA9BDC1A7B25025D0B489026AAFBCDA2")

    public static final int LTGRAY      = 0xFFCCCCCC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "2F075C53002601903DD21884834B9A06", hash_generated_field = "E5909B2D31AE695BFE6C777A22DC2090")

    public static final int WHITE       = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "9AE657A5CF63AD7650314E5ABAE62F39", hash_generated_field = "FE5E4AEF33775CE96FF2D28E3B3DA1AE")

    public static final int RED         = 0xFFFF0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "0774F929EE3B620FB823F7DF25C68AC5", hash_generated_field = "D123D6C0498127A29E26D063855EFB90")

    public static final int GREEN       = 0xFF00FF00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "8A21AA3E3983158DF0A7BD9561243140", hash_generated_field = "8757960F9963054C3589C55F11331733")

    public static final int BLUE        = 0xFF0000FF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "3C8A06DEBAEE6C6C501A2DF460FF8ADC", hash_generated_field = "AE37C0C255DAC03720EA6C9409A65BAE")

    public static final int YELLOW      = 0xFFFFFF00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "FF3634988F89E6B1F8046F9E189FCF3D", hash_generated_field = "86E348F666B1DD9D443BEB347F546AB8")

    public static final int CYAN        = 0xFF00FFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.904 -0400", hash_original_field = "AE9C1B536EBEEA213A4E2EA91BC8AF5D", hash_generated_field = "E8A32CBE213D2FD1C781AA2CDF6EE501")

    public static final int MAGENTA     = 0xFFFF00FF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.905 -0400", hash_original_field = "1A7AD544E40AE202A08C600913DF9DBE", hash_generated_field = "D1E6A6F7B8292E96032F6DA425E91847")

    public static final int TRANSPARENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.905 -0400", hash_original_field = "749639BAC2C4D0A3E461B28A27AEB889", hash_generated_field = "498D8E53A8FACBB74E1A4ED57C16330E")

    private static HashMap<String, Integer> sColorNameMap;
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

