package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;

import android.graphics.Bitmap;

import droidsafe.helpers.DSUtils;

public final class GLUtils {

    /**
     * return the internal format as defined by OpenGL ES of the supplied bitmap.
     * @param bitmap
     * @return the internal format of the bitmap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.449 -0500", hash_original_method = "B6B481F20C06158B7B2683399A01F45A", hash_generated_method = "B083C1A85AF000F8EF87832B426CA4F2")
    
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

    /**
     * Return the type as defined by OpenGL ES of the supplied bitmap, if there
     * is one. If the bitmap is stored in a compressed format, it may not have
     * a valid OpenGL ES type.
     * @throws IllegalArgumentException if the bitmap does not have a type.
     * @param bitmap
     * @return the OpenGL ES type of the bitmap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.452 -0500", hash_original_method = "7F321909DE884C965D7AD4908EC024EC", hash_generated_method = "7DDAAEF9A95CA0DF572BAAB7A4A70EC5")
    
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

    /**
     * Calls glTexImage2D() on the current OpenGL context. If no context is
     * current the behavior is the same as calling glTexImage2D() with  no
     * current context, that is, eglGetError() will return the appropriate
     * error.
     * Unlike glTexImage2D() bitmap cannot be null and will raise an exception
     * in that case.
     * All other parameters are identical to those used for glTexImage2D().
     *
     * NOTE: this method doesn't change GL_UNPACK_ALIGNMENT, you must make
     * sure to set it properly according to the supplied bitmap.
     *
     * Whether or not bitmap can have non power of two dimensions depends on
     * the current OpenGL context. Always check glGetError() some time
     * after calling this method, just like when using OpenGL directly.
     *
     * @param target
     * @param level
     * @param internalformat
     * @param bitmap
     * @param border
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.455 -0500", hash_original_method = "38C936AC38AFD26040EB8F9B2F19DF90", hash_generated_method = "CD433681E925C9A62AE6DFE6F257F83F")
    
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

    /**
     * A version of texImage2D() that takes an explicit type parameter
     * as defined by the OpenGL ES specification. The actual type and
     * internalformat of the bitmap must be compatible with the specified
     * type and internalformat parameters.
     *
     * @param target
     * @param level
     * @param internalformat
     * @param bitmap
     * @param type
     * @param border
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.458 -0500", hash_original_method = "78B79386B22FD4127FF455D43CC33AA2", hash_generated_method = "D32DEA26871E894FDE1AF0D71CB19DF8")
    
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

    /**
     * A version of texImage2D that determines the internalFormat and type
     * automatically.
     *
     * @param target
     * @param level
     * @param bitmap
     * @param border
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.460 -0500", hash_original_method = "54245E5C92D815A48A8550C075E1277A", hash_generated_method = "05D189ABED035A5E95EAE8A96DBA368D")
    
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

    /**
     * Calls glTexSubImage2D() on the current OpenGL context. If no context is
     * current the behavior is the same as calling glTexSubImage2D() with  no
     * current context, that is, eglGetError() will return the appropriate
     * error.
     * Unlike glTexSubImage2D() bitmap cannot be null and will raise an exception
     * in that case.
     * All other parameters are identical to those used for glTexSubImage2D().
     *
     * NOTE: this method doesn't change GL_UNPACK_ALIGNMENT, you must make
     * sure to set it properly according to the supplied bitmap.
     *
     * Whether or not bitmap can have non power of two dimensions depends on
     * the current OpenGL context. Always check glGetError() some time
     * after calling this method, just like when using OpenGL directly.
     *
     * @param target
     * @param level
     * @param xoffset
     * @param yoffset
     * @param bitmap
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.463 -0500", hash_original_method = "8C0A16DEFCA17DC4A60E066564CB56D3", hash_generated_method = "024FF416E0F94E29C981CA21E5CEAFB9")
    
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

    /**
     * A version of texSubImage2D() that takes an explicit type parameter
     * as defined by the OpenGL ES specification.
     *
     * @param target
     * @param level
     * @param xoffset
     * @param yoffset
     * @param bitmap
     * @param type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.466 -0500", hash_original_method = "F6FE0C69971F26CF832691677B050FE2", hash_generated_method = "2161DDDE7E6B631F673E5960EC2F3860")
    
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

    /**
     * Return a string for the EGL error code, or the hex representation
     * if the error is unknown.
     * 
     * @param error The EGL error to convert into a String.
     * 
     * @return An error string corresponding to the EGL error code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.469 -0500", hash_original_method = "4A75296C27DF89363E5071AFCCE0DA22", hash_generated_method = "94E82E0D7C757E1E539FE45B49C33D8E")
    
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
    
    private static void nativeClassInit() {
    }
    
    private static int native_getInternalFormat(Bitmap bitmap) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int native_getType(Bitmap bitmap) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int native_texImage2D(int target, int level, int internalformat,
            Bitmap bitmap, int type, int border) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int native_texSubImage2D(int target, int level, int xoffset, int yoffset,
            Bitmap bitmap, int format, int type) {
        return DSUtils.UNKNOWN_INT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.446 -0500", hash_original_method = "A98AAD2DCE964D3E8867B0B125C8757B", hash_generated_method = "CEB5D41780BD88C7CD574549EFDBB1F5")
    
private GLUtils() {
    }
    
    static {
        nativeClassInit();
    }
    
}

