package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.AssetManager;
import java.io.File;

public class Typeface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.201 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.202 -0400", hash_original_method = "A1E0C89A80599EF6E13C90B8B8945AA4", hash_generated_method = "A11C4C141B825233B826624D242E9E37")
    private  Typeface(int ni) {
        if(0 == ni)        
        {
            RuntimeException var6E6EF9A75208BA676FC2CA96D7988D82_1650114445 = new RuntimeException("native typeface cannot be made");
            var6E6EF9A75208BA676FC2CA96D7988D82_1650114445.addTaint(taint);
            throw var6E6EF9A75208BA676FC2CA96D7988D82_1650114445;
        } //End block
        native_instance = ni;
        // ---------- Original Method ----------
        //if (0 == ni) {
            //throw new RuntimeException("native typeface cannot be made");
        //}
        //native_instance = ni;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.202 -0400", hash_original_method = "49E10597FC0BC827A75ECB0B721408FD", hash_generated_method = "C6515AE723B1CF5C057F7ECAA48C2F00")
    public int getStyle() {
        int varB7050576F2925C21EF90B7165C471A32_1418690738 = (nativeGetStyle(native_instance));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1339950234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1339950234;
        // ---------- Original Method ----------
        //return nativeGetStyle(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.203 -0400", hash_original_method = "F9C5D984693E715CACA8B421F6CE6BD8", hash_generated_method = "C493E411038B6E89FA4E25244D78EF82")
    public final boolean isBold() {
        boolean var22FB91444A43EC94B14A455A2BAAC963_1441694835 = ((getStyle() & BOLD) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_561825386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_561825386;
        // ---------- Original Method ----------
        //return (getStyle() & BOLD) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.203 -0400", hash_original_method = "55AE9D2665222680CD04F733708ADD28", hash_generated_method = "88148EA2AC94580890039C1F2E5EAC27")
    public final boolean isItalic() {
        boolean var31DE17569930B7690D33C8D6EEF228C7_855282288 = ((getStyle() & ITALIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501364687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501364687;
        // ---------- Original Method ----------
        //return (getStyle() & ITALIC) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface create(String familyName, int style) {
        return new Typeface(nativeCreate(familyName, style));
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface create(Typeface family, int style) {
        int ni = 0;
        if (family != null) {
            ni = family.native_instance;
        }
        return new Typeface(nativeCreateFromTypeface(ni, style));
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface defaultFromStyle(int style) {
        return sDefaults[style];
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface createFromAsset(AssetManager mgr, String path) {
        return new Typeface(nativeCreateFromAsset(mgr, path));
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface createFromFile(File path) {
        return new Typeface(nativeCreateFromFile(path.getAbsolutePath()));
    }

    
    @DSModeled(DSC.SAFE)
    public static Typeface createFromFile(String path) {
        return new Typeface(nativeCreateFromFile(path));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.208 -0400", hash_original_method = "365BC48BBC32364F202A52D242C543E7", hash_generated_method = "542BA0200575B34094B0AA4D80DE2CA4")
    protected void finalize() throws Throwable {
        super.finalize();
        nativeUnref(native_instance);
        // ---------- Original Method ----------
        //super.finalize();
        //nativeUnref(native_instance);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(String familyName, int style) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromTypeface(int native_instance, int style) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeUnref(int native_instance) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetStyle(int native_instance) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromAsset(AssetManager mgr, String path) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromFile(String path) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setGammaForText(float blackGamma, float whiteGamma) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.210 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "EAAEB39A9889FCB1FDC0EC40769D0C01")

    public static final Typeface DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.210 -0400", hash_original_field = "353741717F00CF3908EEA6D517B508C3", hash_generated_field = "0864579E3FFFBA69C4776858C5FC13D8")

    public static final Typeface DEFAULT_BOLD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "9195E6994AE866B9B4CD76760190FFB5", hash_generated_field = "8B9E2FBB8CEFBEF22A32A866C41C7EE6")

    public static final Typeface SANS_SERIF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "4F5DE0AC9E414DB58C967BDE1B1360CF", hash_generated_field = "DC98C4A2132833D255BFE9E517AB21A8")

    public static final Typeface SERIF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "15915AE6BBCD77C253328799A737A63E", hash_generated_field = "788C2738B628C73ED6B9231C7000049C")

    public static final Typeface MONOSPACE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "0DF2279D3839D1426C10DA6A22B83F46", hash_generated_field = "6FEC825196C265DC8D36C397F8A05A7D")

    static Typeface[] sDefaults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "6EEF77DD7E71AFC1618553884BAAF8AD", hash_generated_field = "A4C87F852072D72C29870CFCB6AD7CC6")

    public static final int NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "D815EF1E93D29786DE81A2E248F768CB", hash_generated_field = "89D7140D7EB752A6C7528F551B43007D")

    public static final int BOLD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.211 -0400", hash_original_field = "42DCBB7CA4A479BEBC3CA5636616A04E", hash_generated_field = "AAC914EC5529D3EFA7515451CA579C98")

    public static final int ITALIC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.212 -0400", hash_original_field = "43AC3FE4CAE8220AB00CAEFE286EDDAB", hash_generated_field = "ACD97265A92F699022D5C7173259C9A9")

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

