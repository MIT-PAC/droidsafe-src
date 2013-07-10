package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class BitmapShader extends Shader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.321 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "ABC07C2755FD81F115C0C28144D66BB3")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) public Bitmap mBitmap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.321 -0400", hash_original_method = "4EB08FDCAC2586A4FA6B09EB3F8E173D", hash_generated_method = "91CBABD0A045F3CA75D3DAB8AEFC47D1")
    public  BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        mBitmap = bitmap;
        final int b = bitmap.ni();
        native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
        addTaint(tileX.getTaint());
        addTaint(tileY.getTaint());
        
        
        
        
        
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

