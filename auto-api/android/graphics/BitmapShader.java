package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class BitmapShader extends Shader {
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    public /* final */ Bitmap mBitmap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.961 -0400", hash_original_method = "4EB08FDCAC2586A4FA6B09EB3F8E173D", hash_generated_method = "586A839AE4B1B57AA3554E25C840B12A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        dsTaint.addTaint(tileY.dsTaint);
        dsTaint.addTaint(tileX.dsTaint);
        dsTaint.addTaint(bitmap.dsTaint);
        final int b;
        b = bitmap.ni();
        native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
        // ---------- Original Method ----------
        //mBitmap = bitmap;
        //final int b = bitmap.ni();
        //native_instance = nativeCreate(b, tileX.nativeInt, tileY.nativeInt);
        //native_shader = nativePostCreate(native_instance, b, tileX.nativeInt, tileY.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.962 -0400", hash_original_method = "84693F0D8DC88E10F05CAECC65ECC4A4", hash_generated_method = "DD2CCF9F251DE5512925A9CD6F411B8C")
    private static int nativeCreate(int native_bitmap, int shaderTileModeX,
            int shaderTileModeY) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.962 -0400", hash_original_method = "9ECD899208A54B41AFB4505D5EF04B78", hash_generated_method = "7DCF39EC90A2FCF930DEA31F76919853")
    private static int nativePostCreate(int native_shader, int native_bitmap,
            int shaderTileModeX, int shaderTileModeY) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
}


