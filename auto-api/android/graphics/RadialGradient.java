package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class RadialGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.042 -0400", hash_original_method = "AAECBEFB54B4ACCFD5CA83A095E16729", hash_generated_method = "570885902269523E6310927567EFBB94")
    public  RadialGradient(float x, float y, float radius,
                          int colors[], float positions[], TileMode tile) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("radius must be > 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("needs >= 2 number of colors");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("color and position arrays must be of equal length");
        } //End block
        native_instance = nativeCreate1(x, y, radius, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x, y, radius, colors, positions,
                tile.nativeInt);
        addTaint(x);
        addTaint(y);
        addTaint(radius);
        addTaint(colors);
        addTaint(positions);
        addTaint(tile.getTaint());
        // ---------- Original Method ----------
        //if (radius <= 0) {
            //throw new IllegalArgumentException("radius must be > 0");
        //}
        //if (colors.length < 2) {
            //throw new IllegalArgumentException("needs >= 2 number of colors");
        //}
        //if (positions != null && colors.length != positions.length) {
            //throw new IllegalArgumentException("color and position arrays must be of equal length");
        //}
        //native_instance = nativeCreate1(x, y, radius, colors, positions, tile.nativeInt);
        //native_shader = nativePostCreate1(native_instance, x, y, radius, colors, positions,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.059 -0400", hash_original_method = "967A1FFF1D78A377DCB1552FAD26240E", hash_generated_method = "7A9B9E9D28EDF43AD76F32AEB5767CDA")
    public  RadialGradient(float x, float y, float radius,
                          int color0, int color1, TileMode tile) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("radius must be > 0");
        } //End block
        native_instance = nativeCreate2(x, y, radius, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x, y, radius, color0, color1,
                tile.nativeInt);
        addTaint(x);
        addTaint(y);
        addTaint(radius);
        addTaint(color0);
        addTaint(color1);
        addTaint(tile.getTaint());
        // ---------- Original Method ----------
        //if (radius <= 0) {
            //throw new IllegalArgumentException("radius must be > 0");
        //}
        //native_instance = nativeCreate2(x, y, radius, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x, y, radius, color0, color1,
                //tile.nativeInt);
    }

    
        private static int nativeCreate1(float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreate2(float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativePostCreate1(int native_shader, float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativePostCreate2(int native_shader, float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

