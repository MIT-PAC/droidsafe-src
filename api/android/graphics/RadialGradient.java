package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class RadialGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.853 -0400", hash_original_method = "AAECBEFB54B4ACCFD5CA83A095E16729", hash_generated_method = "DAE33B760F590BD70A0412E53A1E1207")
    public  RadialGradient(float x, float y, float radius,
                          int colors[], float positions[], TileMode tile) {
        addTaint(tile.getTaint());
        addTaint(positions[0]);
        addTaint(colors[0]);
        addTaint(radius);
        addTaint(y);
        addTaint(x);
    if(radius <= 0)        
        {
            IllegalArgumentException var4A478BF5F9D4AD251A0D27D1E6AD0AC2_271878021 = new IllegalArgumentException("radius must be > 0");
            var4A478BF5F9D4AD251A0D27D1E6AD0AC2_271878021.addTaint(taint);
            throw var4A478BF5F9D4AD251A0D27D1E6AD0AC2_271878021;
        } //End block
    if(colors.length < 2)        
        {
            IllegalArgumentException var38C288485201E20FEF77EEB0BDD8A17B_1266361373 = new IllegalArgumentException("needs >= 2 number of colors");
            var38C288485201E20FEF77EEB0BDD8A17B_1266361373.addTaint(taint);
            throw var38C288485201E20FEF77EEB0BDD8A17B_1266361373;
        } //End block
    if(positions != null && colors.length != positions.length)        
        {
            IllegalArgumentException varFBD021BA7FC99ABEF82125BE636E6EF0_1650853781 = new IllegalArgumentException("color and position arrays must be of equal length");
            varFBD021BA7FC99ABEF82125BE636E6EF0_1650853781.addTaint(taint);
            throw varFBD021BA7FC99ABEF82125BE636E6EF0_1650853781;
        } //End block
        native_instance = nativeCreate1(x, y, radius, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x, y, radius, colors, positions,
                tile.nativeInt);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.857 -0400", hash_original_method = "967A1FFF1D78A377DCB1552FAD26240E", hash_generated_method = "9E0C09B86AD2DB056EADD7FAF04C5DD1")
    public  RadialGradient(float x, float y, float radius,
                          int color0, int color1, TileMode tile) {
        addTaint(tile.getTaint());
        addTaint(color1);
        addTaint(color0);
        addTaint(radius);
        addTaint(y);
        addTaint(x);
    if(radius <= 0)        
        {
            IllegalArgumentException var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1172385487 = new IllegalArgumentException("radius must be > 0");
            var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1172385487.addTaint(taint);
            throw var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1172385487;
        } //End block
        native_instance = nativeCreate2(x, y, radius, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x, y, radius, color0, color1,
                tile.nativeInt);
        // ---------- Original Method ----------
        //if (radius <= 0) {
            //throw new IllegalArgumentException("radius must be > 0");
        //}
        //native_instance = nativeCreate2(x, y, radius, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x, y, radius, color0, color1,
                //tile.nativeInt);
    }

    
    @DSModeled(DSC.SPEC)
    private static int nativeCreate1(float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate2(float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SPEC)
    private static int nativePostCreate1(int native_shader, float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate2(int native_shader, float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

