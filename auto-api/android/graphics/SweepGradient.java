package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SweepGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.826 -0400", hash_original_method = "64A53BB5A652BD9568EA8C5A648F5375", hash_generated_method = "5F5B71117DF197BC8214ED7E0D5EAB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SweepGradient(float cx, float cy,
                         int colors[], float positions[]) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("needs >= 2 number of colors");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "color and position arrays must be of equal length");
        } //End block
        native_instance = nativeCreate1(cx, cy, colors, positions);
        native_shader = nativePostCreate1(native_instance, cx, cy, colors, positions);
        // ---------- Original Method ----------
        //if (colors.length < 2) {
            //throw new IllegalArgumentException("needs >= 2 number of colors");
        //}
        //if (positions != null && colors.length != positions.length) {
            //throw new IllegalArgumentException(
                        //"color and position arrays must be of equal length");
        //}
        //native_instance = nativeCreate1(cx, cy, colors, positions);
        //native_shader = nativePostCreate1(native_instance, cx, cy, colors, positions);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.826 -0400", hash_original_method = "1126924377A1AF5E908D05CFB28B37FF", hash_generated_method = "1DC2B17E4E03C480B91CDDA0EA7A0506")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SweepGradient(float cx, float cy, int color0, int color1) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(color0);
        native_instance = nativeCreate2(cx, cy, color0, color1);
        native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(cx, cy, color0, color1);
        //native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
    }

    
        private static int nativeCreate1(float x, float y, int colors[], float positions[]) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreate2(float x, float y, int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativePostCreate1(int native_shader, float cx, float cy,
            int[] colors, float[] positions) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativePostCreate2(int native_shader, float cx, float cy,
            int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

