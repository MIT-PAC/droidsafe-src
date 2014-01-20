package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PixelFormat {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClassInit() {
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static void getPixelFormatInfo(int format, PixelFormat info) {
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.036 -0500", hash_original_method = "E67B3D46F0CB30A9037255CD015EB158", hash_generated_method = "89212E037F92B615AEC1D7571C8E0B36")
    
public static boolean formatHasAlpha(int format) {
        switch (format) {
            case PixelFormat.A_8:
            case PixelFormat.LA_88:
            case PixelFormat.RGBA_4444:
            case PixelFormat.RGBA_5551:
            case PixelFormat.RGBA_8888:
            case PixelFormat.TRANSLUCENT:
            case PixelFormat.TRANSPARENT:
                return true;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.985 -0500", hash_original_field = "A8F66825F9B3BFFF84E8E21A24CF617F", hash_generated_field = "847D4677A6A1533A543ECA012114829C")
    
    public static final int UNKNOWN     = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.987 -0500", hash_original_field = "C1925B6CE816FA0B98DC65C18CC77654", hash_generated_field = "2A1BF3C5D2FEA6DA297BC459C63AFF8C")

    public static final int TRANSLUCENT = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.989 -0500", hash_original_field = "BA587833C38E9E550B13C48771240618", hash_generated_field = "7B15A3ABECAB13081B49A0E857146AC1")
    
    public static final int TRANSPARENT = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.992 -0500", hash_original_field = "565F558879D384ACDC6D1D28E76DF73D", hash_generated_field = "FB4E8DF7BCFC0398AC6D3F92A763CA54")

    public static final int OPAQUE      = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.994 -0500", hash_original_field = "BE46C8DA088743E734996D09292F44DE", hash_generated_field = "33228119A97941756D23C90332D8D49C")

    public static final int RGBA_8888   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.997 -0500", hash_original_field = "FBE11CA28CD3B298908862FC0F0FF620", hash_generated_field = "8A97A1356A6F219BCF28C8A053393927")

    public static final int RGBX_8888   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.000 -0500", hash_original_field = "AB72520C035CB75526D05947433D783C", hash_generated_field = "920413383762E55A34A684A2266B887F")

    public static final int RGB_888     = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.002 -0500", hash_original_field = "3ADEAE7915D012B7C74EE713FBCD47E9", hash_generated_field = "DBB64F28C8D47BF582B3E7855C5B8A40")

    public static final int RGB_565     = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.004 -0500", hash_original_field = "49223F818B7A4766204CAD2DF5B34B6B", hash_generated_field = "97F001B11B6438779174070617DC4BA9")

    public static final int RGBA_5551   = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.007 -0500", hash_original_field = "64BBE4DBE93A6919E9FCA7CDE2D8B588", hash_generated_field = "5C5B8689C5FCA2A994D9F88490B59774")

    public static final int RGBA_4444   = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.009 -0500", hash_original_field = "9FF43E9C831C86D799E9FF7BE1AF6A58", hash_generated_field = "2D27FB7063DE8D1EAAA20EA22A2117F6")

    public static final int A_8         = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.011 -0500", hash_original_field = "D59ABF3659CE49F8F547C053BA754076", hash_generated_field = "FF8B6BB44CC49B1496F50EC6412519CB")

    public static final int L_8         = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.014 -0500", hash_original_field = "C79C818411A2CCE6530357420C39A5A9", hash_generated_field = "CC85036B0481B93CD6842D168B691469")

    public static final int LA_88       = 0xA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.016 -0500", hash_original_field = "64784E72D28D4872F1D00B66F08D3E3C", hash_generated_field = "833A084CD10579AD7A4483638162FE25")

    public static final int RGB_332     = 0xB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.018 -0500", hash_original_field = "D7B7C4BB9B8DFBAE7E94003DED31B788", hash_generated_field = "13D96DFF46B8367DD5FA5AA02A3E0701")

    @Deprecated
    public static final int YCbCr_422_SP= 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.021 -0500", hash_original_field = "7581800FF1F90F640E1A7259FAAA60D4", hash_generated_field = "98D095B577366590EDC875A78F9F945A")

    @Deprecated
    public static final int YCbCr_420_SP= 0x11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.023 -0500", hash_original_field = "B05FB536E279A29155E54080BA501CFC", hash_generated_field = "A6880C2298C66F9C02413A0784DCB5CA")

    @Deprecated
    public static final int YCbCr_422_I = 0x14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.027 -0500", hash_original_field = "85CCA584963BE482DC3F2573035A6D54", hash_generated_field = "C428B0316D0CF00A1BE5A9E471F5CF55")

    @Deprecated
    public static final int JPEG        = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.038 -0500", hash_original_field = "24659986FE2A7FEFEDF30D673B6A9EFA", hash_generated_field = "25CC68B225378088BC05AACA8A83059E")
    
    public int  bytesPerPixel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.041 -0500", hash_original_field = "4D95E887D60AC8FA6403B1EBA41CEE77", hash_generated_field = "EF42BD35EAC14E9D8C572895529D5A3C")

    public int  bitsPerPixel;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.631 -0400", hash_original_method = "0A480F0344E4C89067BA9E346BA03813", hash_generated_method = "0A480F0344E4C89067BA9E346BA03813")
    public PixelFormat ()
    {
        //Synthesized constructor
    }
    static { nativeClassInit(); }
    
}

