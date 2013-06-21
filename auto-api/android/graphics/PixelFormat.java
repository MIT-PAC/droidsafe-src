package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PixelFormat {
    public int  bytesPerPixel;
    public int  bitsPerPixel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.524 -0400", hash_original_method = "DFDA3F231174B58FE67B0B89E0CD7CA2", hash_generated_method = "DFDA3F231174B58FE67B0B89E0CD7CA2")
        public PixelFormat ()
    {
    }


        private static void nativeClassInit() {
    }

    
        public static void getPixelFormatInfo(int format, PixelFormat info) {
    }

    
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
    @Deprecated public static final int YCbCr_422_SP= 0x10;
    @Deprecated public static final int YCbCr_420_SP= 0x11;
    @Deprecated public static final int YCbCr_422_I = 0x14;
    @Deprecated public static final int JPEG        = 0x100;
    static { nativeClassInit(); }
    
}

