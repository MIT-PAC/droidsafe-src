package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.AssetManager;
import java.io.File;

public class Typeface {
    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.833 -0400", hash_original_method = "A1E0C89A80599EF6E13C90B8B8945AA4", hash_generated_method = "E19E2B2AC00E589859B5CF3D56E5FAA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Typeface(int ni) {
        dsTaint.addTaint(ni);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("native typeface cannot be made");
        } //End block
        // ---------- Original Method ----------
        //if (0 == ni) {
            //throw new RuntimeException("native typeface cannot be made");
        //}
        //native_instance = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.833 -0400", hash_original_method = "49E10597FC0BC827A75ECB0B721408FD", hash_generated_method = "D6CE27D133F580AF70482EB139B63EE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStyle() {
        int varCC8146FE37057C783852ABB31B70890B_1837920766 = (nativeGetStyle(native_instance));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetStyle(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.833 -0400", hash_original_method = "F9C5D984693E715CACA8B421F6CE6BD8", hash_generated_method = "883E6F674AB23B43B1ED2145D0E59E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isBold() {
        boolean varAC449BBC6E6FF967A98988CD6BC036E4_901762517 = ((getStyle() & BOLD) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getStyle() & BOLD) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.834 -0400", hash_original_method = "55AE9D2665222680CD04F733708ADD28", hash_generated_method = "915F33DEE5B121A0A2EC80C9A98B872E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isItalic() {
        boolean varC18F23FAAD9335DAC1AAA5AFA8F49D10_1328585853 = ((getStyle() & ITALIC) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getStyle() & ITALIC) != 0;
    }

    
        public static Typeface create(String familyName, int style) {
        return new Typeface(nativeCreate(familyName, style));
    }

    
        public static Typeface create(Typeface family, int style) {
        int ni = 0;
        if (family != null) {
            ni = family.native_instance;
        }
        return new Typeface(nativeCreateFromTypeface(ni, style));
    }

    
        public static Typeface defaultFromStyle(int style) {
        return sDefaults[style];
    }

    
        public static Typeface createFromAsset(AssetManager mgr, String path) {
        return new Typeface(nativeCreateFromAsset(mgr, path));
    }

    
        public static Typeface createFromFile(File path) {
        return new Typeface(nativeCreateFromFile(path.getAbsolutePath()));
    }

    
        public static Typeface createFromFile(String path) {
        return new Typeface(nativeCreateFromFile(path));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.835 -0400", hash_original_method = "365BC48BBC32364F202A52D242C543E7", hash_generated_method = "542BA0200575B34094B0AA4D80DE2CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        super.finalize();
        nativeUnref(native_instance);
        // ---------- Original Method ----------
        //super.finalize();
        //nativeUnref(native_instance);
    }

    
        private static int nativeCreate(String familyName, int style) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreateFromTypeface(int native_instance, int style) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeUnref(int native_instance) {
    }

    
        private static int nativeGetStyle(int native_instance) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreateFromAsset(AssetManager mgr, String path) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreateFromFile(String path) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void setGammaForText(float blackGamma, float whiteGamma) {
    }

    
    public static final Typeface DEFAULT;
    public static final Typeface DEFAULT_BOLD;
    public static final Typeface SANS_SERIF;
    public static final Typeface SERIF;
    public static final Typeface MONOSPACE;
    static Typeface[] sDefaults;
    public static final int NORMAL = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;
    public static final int BOLD_ITALIC = 3;
    static {
        DEFAULT         = create((String)null, 0);
        DEFAULT_BOLD    = create((String)null, Typeface.BOLD);
        SANS_SERIF      = create("sans-serif", 0);
        SERIF           = create("serif", 0);
        MONOSPACE       = create("monospace", 0);
        sDefaults = new Typeface[] {
            DEFAULT,
            DEFAULT_BOLD,
            create((String)null, Typeface.ITALIC),
            create((String)null, Typeface.BOLD_ITALIC),
        };
    }
    
}

