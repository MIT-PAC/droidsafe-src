package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class RadialGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.684 -0400", hash_original_method = "AAECBEFB54B4ACCFD5CA83A095E16729", hash_generated_method = "68921116356D1265850E7F563C95FF80")
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
            IllegalArgumentException var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1982375204 = new IllegalArgumentException("radius must be > 0");
            var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1982375204.addTaint(taint);
            throw var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1982375204;
        } //End block
        if(colors.length < 2)        
        {
            IllegalArgumentException var38C288485201E20FEF77EEB0BDD8A17B_608807366 = new IllegalArgumentException("needs >= 2 number of colors");
            var38C288485201E20FEF77EEB0BDD8A17B_608807366.addTaint(taint);
            throw var38C288485201E20FEF77EEB0BDD8A17B_608807366;
        } //End block
        if(positions != null && colors.length != positions.length)        
        {
            IllegalArgumentException varFBD021BA7FC99ABEF82125BE636E6EF0_959798686 = new IllegalArgumentException("color and position arrays must be of equal length");
            varFBD021BA7FC99ABEF82125BE636E6EF0_959798686.addTaint(taint);
            throw varFBD021BA7FC99ABEF82125BE636E6EF0_959798686;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.685 -0400", hash_original_method = "967A1FFF1D78A377DCB1552FAD26240E", hash_generated_method = "7A974AC2BC429FED4761BAC5F17E1A8D")
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
            IllegalArgumentException var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1856169519 = new IllegalArgumentException("radius must be > 0");
            var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1856169519.addTaint(taint);
            throw var4A478BF5F9D4AD251A0D27D1E6AD0AC2_1856169519;
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

