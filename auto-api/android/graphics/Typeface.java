package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.AssetManager;
import java.io.File;

public class Typeface {
    public static final Typeface DEFAULT;
    public static final Typeface DEFAULT_BOLD;
    public static final Typeface SANS_SERIF;
    public static final Typeface SERIF;
    public static final Typeface MONOSPACE;
    static Typeface[] sDefaults;
    int native_instance;
    public static final int NORMAL = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;
    public static final int BOLD_ITALIC = 3;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.475 -0400", hash_original_method = "A1E0C89A80599EF6E13C90B8B8945AA4", hash_generated_method = "5B33F36F7D45ABA895A096B3EF004E5E")
    @DSModeled(DSC.SAFE)
    private Typeface(int ni) {
        dsTaint.addTaint(ni);
        {
            throw new RuntimeException("native typeface cannot be made");
        } //End block
        // ---------- Original Method ----------
        //if (0 == ni) {
            //throw new RuntimeException("native typeface cannot be made");
        //}
        //native_instance = ni;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "49E10597FC0BC827A75ECB0B721408FD", hash_generated_method = "F52CB0406539D55C2E0BA72B61913F15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStyle() {
        int varCC8146FE37057C783852ABB31B70890B_1687925406 = (nativeGetStyle(native_instance));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetStyle(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "F9C5D984693E715CACA8B421F6CE6BD8", hash_generated_method = "E5E91634859504D66797C75E28983E8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isBold() {
        boolean varAC449BBC6E6FF967A98988CD6BC036E4_885530125 = ((getStyle() & BOLD) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getStyle() & BOLD) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "55AE9D2665222680CD04F733708ADD28", hash_generated_method = "17B0BA732D42DE27E9FE713A0FEB25A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isItalic() {
        boolean varC18F23FAAD9335DAC1AAA5AFA8F49D10_1526562878 = ((getStyle() & ITALIC) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getStyle() & ITALIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "17B527703375EC0E18C6C2B14F73239B", hash_generated_method = "978A8D227C75F06C0F72123179F370E8")
    public static Typeface create(String familyName, int style) {
        return new Typeface(nativeCreate(familyName, style));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "440330E00D63CA8C46C2D2C8DF2C6AC6", hash_generated_method = "6ADE5CB6ADC5D7A39E399D5D4E6783C5")
    public static Typeface create(Typeface family, int style) {
        int ni = 0;
        if (family != null) {
            ni = family.native_instance;
        }
        return new Typeface(nativeCreateFromTypeface(ni, style));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "B06912E79E41E10797503036CC965799", hash_generated_method = "9D914BF564A8989D727B0640BD894E02")
    public static Typeface defaultFromStyle(int style) {
        return sDefaults[style];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "B7B625088F029DD3EB2D5292E983F6DF", hash_generated_method = "0A54A29A95BB9391FFC250FC66E26A42")
    public static Typeface createFromAsset(AssetManager mgr, String path) {
        return new Typeface(nativeCreateFromAsset(mgr, path));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "75B14133CB489027D77A424630AF754B", hash_generated_method = "35F35D443F4F1C8CEBFB68A43EE62BD6")
    public static Typeface createFromFile(File path) {
        return new Typeface(nativeCreateFromFile(path.getAbsolutePath()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "41766EA6657E21C45E368553CD429F56", hash_generated_method = "F2ECF31D59A09C57439120926468258C")
    public static Typeface createFromFile(String path) {
        return new Typeface(nativeCreateFromFile(path));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.476 -0400", hash_original_method = "365BC48BBC32364F202A52D242C543E7", hash_generated_method = "5DC080D04FA64529F0A6ACBDB7B636DC")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        super.finalize();
        nativeUnref(native_instance);
        // ---------- Original Method ----------
        //super.finalize();
        //nativeUnref(native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "AECA93EE1E74230109E5D40863E367B5", hash_generated_method = "25E80E039B64D4F79101A89F47225180")
    private static int nativeCreate(String familyName, int style) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "BA08E25700225C22375A5A91D6E9167C", hash_generated_method = "D1E0B3AB334265211045A926F88A29E5")
    private static int nativeCreateFromTypeface(int native_instance, int style) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "A94763C4883A26DBA88C2F056A3B8A34", hash_generated_method = "03028C35F7CFFDAC6991617E3B7281CC")
    private static void nativeUnref(int native_instance) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "1BF2A4E37617F777C398CA339C4457E1", hash_generated_method = "85565332F9F7E6ACA735EDF752667D07")
    private static int nativeGetStyle(int native_instance) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "C129326312649AA388CAA949617ABA1E", hash_generated_method = "9373BB44568E02CBCA254DF006E7A730")
    private static int nativeCreateFromAsset(AssetManager mgr, String path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "6ADB458B35FAC6F1A42AD6CE038AB448", hash_generated_method = "1FF48DB16CA7875574C1BC8BCCBEE758")
    private static int nativeCreateFromFile(String path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.477 -0400", hash_original_method = "2C08949F6CA5703FB74C76199B27CDFD", hash_generated_method = "2FBC3E772F7352BAA8976D073DF69629")
    public static void setGammaForText(float blackGamma, float whiteGamma) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
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


