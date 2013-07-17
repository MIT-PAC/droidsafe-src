package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PixelFormat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.631 -0400", hash_original_field = "C79C8A122EB0B40BB95012C1344026C6", hash_generated_field = "25CC68B225378088BC05AACA8A83059E")

    public int bytesPerPixel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.631 -0400", hash_original_field = "E3D2DDF068E6BCF15EC1779CE9CCEEF5", hash_generated_field = "EF42BD35EAC14E9D8C572895529D5A3C")

    public int bitsPerPixel;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.631 -0400", hash_original_method = "0A480F0344E4C89067BA9E346BA03813", hash_generated_method = "0A480F0344E4C89067BA9E346BA03813")
    public PixelFormat ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void getPixelFormatInfo(int format, PixelFormat info) {
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "847D4677A6A1533A543ECA012114829C")

    public static final int UNKNOWN     = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "5D3A148871E3BA6C5D4940DC7744ABDA", hash_generated_field = "2A1BF3C5D2FEA6DA297BC459C63AFF8C")

    public static final int TRANSLUCENT = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "D36DBE30CE6159C82BB48F094DD78ABB", hash_generated_field = "7B15A3ABECAB13081B49A0E857146AC1")

    public static final int TRANSPARENT = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "9709849E15BF5C6513E56780E2C49F84", hash_generated_field = "FB4E8DF7BCFC0398AC6D3F92A763CA54")

    public static final int OPAQUE      = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "339DCC3133D1C5A2C6A2F3A0751D63A4", hash_generated_field = "33228119A97941756D23C90332D8D49C")

    public static final int RGBA_8888   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "DD3200ED23F0703659A9BCE85F49F65D", hash_generated_field = "8A97A1356A6F219BCF28C8A053393927")

    public static final int RGBX_8888   = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "6C971529D5986BA31A144BFF71886713", hash_generated_field = "920413383762E55A34A684A2266B887F")

    public static final int RGB_888     = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "D538C59BF6CD73A7472CE6DCC488840A", hash_generated_field = "DBB64F28C8D47BF582B3E7855C5B8A40")

    public static final int RGB_565     = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "1318DCB28C7F548C59D0C8DFA7D91681", hash_generated_field = "97F001B11B6438779174070617DC4BA9")

    public static final int RGBA_5551   = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "4343D985258CA71F387B5850963A1344", hash_generated_field = "5C5B8689C5FCA2A994D9F88490B59774")

    public static final int RGBA_4444   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "04D20E9E309D35C6363832DEE4FAAC68", hash_generated_field = "2D27FB7063DE8D1EAAA20EA22A2117F6")

    public static final int A_8         = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "33F5A00289137D1BF8FD1135D8B98F28", hash_generated_field = "FF8B6BB44CC49B1496F50EC6412519CB")

    public static final int L_8         = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "A8B86002A24FEE04D8E45FD433C95370", hash_generated_field = "CC85036B0481B93CD6842D168B691469")

    public static final int LA_88       = 0xA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.632 -0400", hash_original_field = "930ABE453A76D9126969ED6BAD5B7504", hash_generated_field = "833A084CD10579AD7A4483638162FE25")

    public static final int RGB_332     = 0xB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.633 -0400", hash_original_field = "59CB58689C1DB8E96C2CFF0F85D1625B", hash_generated_field = "13D96DFF46B8367DD5FA5AA02A3E0701")

    @Deprecated
    public static final int YCbCr_422_SP= 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.633 -0400", hash_original_field = "EFB08E36B5DAE1226D528F2D68F95EC8", hash_generated_field = "98D095B577366590EDC875A78F9F945A")

    @Deprecated
    public static final int YCbCr_420_SP= 0x11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.633 -0400", hash_original_field = "7198C8FD35C2EA37D1F8514C40B29906", hash_generated_field = "A6880C2298C66F9C02413A0784DCB5CA")

    @Deprecated
    public static final int YCbCr_422_I = 0x14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.633 -0400", hash_original_field = "2E22182686D263DD068799E1D2E79BA8", hash_generated_field = "C428B0316D0CF00A1BE5A9E471F5CF55")

    @Deprecated
    public static final int JPEG        = 0x100;
    static { nativeClassInit(); }
    
}

