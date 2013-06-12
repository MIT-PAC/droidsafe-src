package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Bitmap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;

public final class GLUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.503 -0400", hash_original_method = "A98AAD2DCE964D3E8867B0B125C8757B", hash_generated_method = "48C0F6601EFDC807566D7C93E9A1645E")
    @DSModeled(DSC.SAFE)
    private GLUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.503 -0400", hash_original_method = "B6B481F20C06158B7B2683399A01F45A", hash_generated_method = "B083C1A85AF000F8EF87832B426CA4F2")
    public static int getInternalFormat(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("getInternalFormat can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        int result = native_getInternalFormat(bitmap);
        if (result < 0) {
            throw new IllegalArgumentException("Unknown internalformat");
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.503 -0400", hash_original_method = "7F321909DE884C965D7AD4908EC024EC", hash_generated_method = "7DDAAEF9A95CA0DF572BAAB7A4A70EC5")
    public static int getType(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("getType can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        int result = native_getType(bitmap);
        if (result < 0) {
            throw new IllegalArgumentException("Unknown type");
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.503 -0400", hash_original_method = "38C936AC38AFD26040EB8F9B2F19DF90", hash_generated_method = "CD433681E925C9A62AE6DFE6F257F83F")
    public static void texImage2D(int target, int level, int internalformat,
            Bitmap bitmap, int border) {
        if (bitmap == null) {
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        if (native_texImage2D(target, level, internalformat, bitmap, -1, border)!=0) {
            throw new IllegalArgumentException("invalid Bitmap format");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.503 -0400", hash_original_method = "78B79386B22FD4127FF455D43CC33AA2", hash_generated_method = "D32DEA26871E894FDE1AF0D71CB19DF8")
    public static void texImage2D(int target, int level, int internalformat,
            Bitmap bitmap, int type, int border) {
        if (bitmap == null) {
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        if (native_texImage2D(target, level, internalformat, bitmap, type, border)!=0) {
            throw new IllegalArgumentException("invalid Bitmap format");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "54245E5C92D815A48A8550C075E1277A", hash_generated_method = "05D189ABED035A5E95EAE8A96DBA368D")
    public static void texImage2D(int target, int level, Bitmap bitmap,
            int border) {
        if (bitmap == null) {
            throw new NullPointerException("texImage2D can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        if (native_texImage2D(target, level, -1, bitmap, -1, border)!=0) {
            throw new IllegalArgumentException("invalid Bitmap format");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "8C0A16DEFCA17DC4A60E066564CB56D3", hash_generated_method = "024FF416E0F94E29C981CA21E5CEAFB9")
    public static void texSubImage2D(int target, int level, int xoffset, int yoffset,
            Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("texSubImage2D can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        int type = getType(bitmap);
        if (native_texSubImage2D(target, level, xoffset, yoffset, bitmap, -1, type)!=0) {
            throw new IllegalArgumentException("invalid Bitmap format");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "F6FE0C69971F26CF832691677B050FE2", hash_generated_method = "2161DDDE7E6B631F673E5960EC2F3860")
    public static void texSubImage2D(int target, int level, int xoffset, int yoffset,
            Bitmap bitmap, int format, int type) {
        if (bitmap == null) {
            throw new NullPointerException("texSubImage2D can't be used with a null Bitmap");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recycled");
        }
        if (native_texSubImage2D(target, level, xoffset, yoffset, bitmap, format, type)!=0) {
            throw new IllegalArgumentException("invalid Bitmap format");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "4A75296C27DF89363E5071AFCCE0DA22", hash_generated_method = "94E82E0D7C757E1E539FE45B49C33D8E")
    public static String getEGLErrorString(int error) {
        switch (error) {
            case EGL10.EGL_SUCCESS:
                return "EGL_SUCCESS";
            case EGL10.EGL_NOT_INITIALIZED:
                return "EGL_NOT_INITIALIZED";
            case EGL10.EGL_BAD_ACCESS:
                return "EGL_BAD_ACCESS";
            case EGL10.EGL_BAD_ALLOC:
                return "EGL_BAD_ALLOC";
            case EGL10.EGL_BAD_ATTRIBUTE:
                return "EGL_BAD_ATTRIBUTE";
            case EGL10.EGL_BAD_CONFIG:
                return "EGL_BAD_CONFIG";
            case EGL10.EGL_BAD_CONTEXT:
                return "EGL_BAD_CONTEXT";
            case EGL10.EGL_BAD_CURRENT_SURFACE:
                return "EGL_BAD_CURRENT_SURFACE";
            case EGL10.EGL_BAD_DISPLAY:
                return "EGL_BAD_DISPLAY";
            case EGL10.EGL_BAD_MATCH:
                return "EGL_BAD_MATCH";
            case EGL10.EGL_BAD_NATIVE_PIXMAP:
                return "EGL_BAD_NATIVE_PIXMAP";
            case EGL10.EGL_BAD_NATIVE_WINDOW:
                return "EGL_BAD_NATIVE_WINDOW";
            case EGL10.EGL_BAD_PARAMETER:
                return "EGL_BAD_PARAMETER";
            case EGL10.EGL_BAD_SURFACE:
                return "EGL_BAD_SURFACE";
            case EGL11.EGL_CONTEXT_LOST:
                return "EGL_CONTEXT_LOST";
            default:
                return "0x" + Integer.toHexString(error);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "D7A6F441E801CC1928318AEDAA360C85", hash_generated_method = "DC26CA34987AA03D680F128BB06D48D9")
    private static int native_getInternalFormat(Bitmap bitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "70508A4AA495E8E72B724137B94EF162", hash_generated_method = "FEA8F6C9CDAAD987DA9C3C522A6F0BE3")
    private static int native_getType(Bitmap bitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "C72BE07C69251A6FFA4F71AD75FC3B37", hash_generated_method = "810312668AA47A878C139B0154283C87")
    private static int native_texImage2D(int target, int level, int internalformat,
            Bitmap bitmap, int type, int border) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.504 -0400", hash_original_method = "5FB0A93D6E9709D3DD15E9B07C889D05", hash_generated_method = "09C5B00EC570D74816ED9735AB85707D")
    private static int native_texSubImage2D(int target, int level, int xoffset, int yoffset,
            Bitmap bitmap, int format, int type) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    static {
        nativeClassInit();
    }
    
}


