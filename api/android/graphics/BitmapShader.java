package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class BitmapShader extends Shader {
    
    private static int nativeCreate(int native_bitmap, int shaderTileModeX,
            int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativePostCreate(int native_shader, int native_bitmap,
            int shaderTileModeX, int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.177 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "ABC07C2755FD81F115C0C28144D66BB3")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    public  Bitmap mBitmap;

    /**
     * Call this to create a new shader that will draw with a bitmap.
     *
     * @param bitmap            The bitmap to use inside the shader
     * @param tileX             The tiling mode for x to draw the bitmap in.
     * @param tileY             The tiling mode for y to draw the bitmap in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.181 -0500", hash_original_method = "4EB08FDCAC2586A4FA6B09EB3F8E173D", hash_generated_method = "71297A08305F3A63904ABFBBCA6DDC5C")
    
public BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        mBitmap = bitmap;
        final int b = bitmap.ni();
        native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
    }
    
}

