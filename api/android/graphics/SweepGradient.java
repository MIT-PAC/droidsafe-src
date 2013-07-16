package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SweepGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.396 -0400", hash_original_method = "64A53BB5A652BD9568EA8C5A648F5375", hash_generated_method = "ABA25605C33903B2CC80933F3BB91CCF")
    public  SweepGradient(float cx, float cy,
                         int colors[], float positions[]) {
        addTaint(positions[0]);
        addTaint(colors[0]);
        addTaint(cy);
        addTaint(cx);
    if(colors.length < 2)        
        {
            IllegalArgumentException var38C288485201E20FEF77EEB0BDD8A17B_226146650 = new IllegalArgumentException("needs >= 2 number of colors");
            var38C288485201E20FEF77EEB0BDD8A17B_226146650.addTaint(taint);
            throw var38C288485201E20FEF77EEB0BDD8A17B_226146650;
        } //End block
    if(positions != null && colors.length != positions.length)        
        {
            IllegalArgumentException varFBD021BA7FC99ABEF82125BE636E6EF0_1080951232 = new IllegalArgumentException(
                        "color and position arrays must be of equal length");
            varFBD021BA7FC99ABEF82125BE636E6EF0_1080951232.addTaint(taint);
            throw varFBD021BA7FC99ABEF82125BE636E6EF0_1080951232;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.397 -0400", hash_original_method = "1126924377A1AF5E908D05CFB28B37FF", hash_generated_method = "29EFDAE02E5390F062AE386B310F4B8A")
    public  SweepGradient(float cx, float cy, int color0, int color1) {
        addTaint(color1);
        addTaint(color0);
        addTaint(cy);
        addTaint(cx);
        native_instance = nativeCreate2(cx, cy, color0, color1);
        native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(cx, cy, color0, color1);
        //native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
    }

    
    @DSModeled(DSC.SPEC)
    private static int nativeCreate1(float x, float y, int colors[], float positions[]) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate2(float x, float y, int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate1(int native_shader, float cx, float cy,
            int[] colors, float[] positions) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate2(int native_shader, float cx, float cy,
            int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

