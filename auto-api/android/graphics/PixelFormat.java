package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PixelFormat {
    public static final int UNKNOWN     = 0;
    public static final int TRANSLUCENT = -3;
    public static final int TRANSPARENT = -2;
    public static final int OPAQUE      = -1;
    public static final int RGBA_8888   = 1;
    public static final int RGBX_8888   = 2;
    public static final int RGB_888     = 3;
    public static final int RGB_565     = 4;
    public static final int RGBA_5551   = 6;
    public static final int RGBA_4444   = 7;
    public static final int A_8         = 8;
    public static final int L_8         = 9;
    public static final int LA_88       = 0xA;
    public static final int RGB_332     = 0xB;
    @Deprecated
    public static final int YCbCr_422_SP= 0x10;
    @Deprecated
    public static final int YCbCr_420_SP= 0x11;
    @Deprecated
    public static final int YCbCr_422_I = 0x14;
    @Deprecated
    public static final int JPEG        = 0x100;
    public int  bytesPerPixel;
    public int  bitsPerPixel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.302 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.302 -0400", hash_original_method = "B6B4C622D784BE7A7B503DD767B9572A", hash_generated_method = "A0ED1033D8764D179777112A600F25EB")
    public static void getPixelFormatInfo(int format, PixelFormat info) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.302 -0400", hash_original_method = "E67B3D46F0CB30A9037255CD015EB158", hash_generated_method = "89212E037F92B615AEC1D7571C8E0B36")
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

    
    static { nativeClassInit(); }
    
}


