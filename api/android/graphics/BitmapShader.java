package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class BitmapShader extends Shader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.882 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "ABC07C2755FD81F115C0C28144D66BB3")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) public Bitmap mBitmap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.882 -0400", hash_original_method = "4EB08FDCAC2586A4FA6B09EB3F8E173D", hash_generated_method = "76C78F9777E6673654CDB9F9C21F6196")
    public  BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        addTaint(tileY.getTaint());
        addTaint(tileX.getTaint());
        mBitmap = bitmap;
        final int b = bitmap.ni();
        native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(int native_bitmap, int shaderTileModeX,
            int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate(int native_shader, int native_bitmap,
            int shaderTileModeX, int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

