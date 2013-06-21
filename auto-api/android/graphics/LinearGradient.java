package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinearGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.249 -0400", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "BA4148D24FF11FA7D2292F6BFDE4DF15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int colors[], float positions[], TileMode tile) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(tile.dsTaint);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("needs >= 2 number of colors");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("color and position arrays must be of equal length");
        } //End block
        native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                tile.nativeInt);
        // ---------- Original Method ----------
        //if (colors.length < 2) {
            //throw new IllegalArgumentException("needs >= 2 number of colors");
        //}
        //if (positions != null && colors.length != positions.length) {
            //throw new IllegalArgumentException("color and position arrays must be of equal length");
        //}
        //native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        //native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.249 -0400", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "7239392C3E73F715ACF99F2A172ADEAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        dsTaint.addTaint(tile.dsTaint);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.250 -0400", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "E834B9B53DDAC154551D58D0CB0FAF2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCreate1(float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.250 -0400", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "2CCFED1614B7DEA8DE0F81BC2EE04664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.250 -0400", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "C2B216809E37E5B4D04B087B4F4F50C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        dsTaint.addTaint(native_shader);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.251 -0400", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "EBE5C9D4FC5C55134A390A9E6B9EC663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        dsTaint.addTaint(native_shader);
        return dsTaint.getTaintInt();
    }

    
}

