package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class LinearGradient extends Shader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.195 -0400", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "0107D408E1313735F89CD3835A5EE403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int colors[], float positions[], TileMode tile) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(tile.dsTaint);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(x1);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.196 -0400", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "7A7A66D7524BC890680E1C6465E2607A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        dsTaint.addTaint(y0);
        dsTaint.addTaint(tile.dsTaint);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(x1);
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
        // ---------- Original Method ----------
        //native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        //native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                //tile.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.196 -0400", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "380A9EFA00C5A877FD105A1F99EC8514")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.196 -0400", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "D74B43E3DE145CEF8819FD28490BFA85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(x1);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.196 -0400", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "F996DDD306A6835E2388D4C91E53D5AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode) {
        dsTaint.addTaint(positions);
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(native_shader);
        dsTaint.addTaint(x1);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.196 -0400", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "717F2BA4BC33097BE3CCDF2A098BDA1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode) {
        dsTaint.addTaint(tileMode);
        dsTaint.addTaint(y0);
        dsTaint.addTaint(y1);
        dsTaint.addTaint(color1);
        dsTaint.addTaint(x0);
        dsTaint.addTaint(color0);
        dsTaint.addTaint(native_shader);
        dsTaint.addTaint(x1);
        return dsTaint.getTaintInt();
    }

    
}


