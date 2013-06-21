package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BitmapShader extends Shader {
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) public Bitmap mBitmap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.123 -0400", hash_original_method = "4EB08FDCAC2586A4FA6B09EB3F8E173D", hash_generated_method = "823A28ABA90FE4FADE36C5980D854256")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        dsTaint.addTaint(tileY.dsTaint);
        dsTaint.addTaint(tileX.dsTaint);
        dsTaint.addTaint(bitmap.dsTaint);
        int b;
        b = bitmap.ni();
        native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
        // ---------- Original Method ----------
        //mBitmap = bitmap;
        //final int b = bitmap.ni();
        //native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        //native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
    }

    
        private static int nativeCreate(int native_bitmap, int shaderTileModeX,
            int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativePostCreate(int native_shader, int native_bitmap,
            int shaderTileModeX, int shaderTileModeY) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

