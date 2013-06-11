package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.SystemProperties;

public class DisplayMetrics {
    public static final int DENSITY_LOW = 120;
    public static final int DENSITY_MEDIUM = 160;
    public static final int DENSITY_TV = 213;
    public static final int DENSITY_HIGH = 240;
    public static final int DENSITY_XHIGH = 320;
    public static final int DENSITY_DEFAULT = DENSITY_MEDIUM;
    public static final int DENSITY_DEVICE = getDeviceDensity();
    public int widthPixels;
    public int heightPixels;
    public float density;
    public int densityDpi;
    public float scaledDensity;
    public float xdpi;
    public float ydpi;
    public int noncompatWidthPixels;
    public int noncompatHeightPixels;
    public float noncompatDensity;
    public float noncompatScaledDensity;
    public float noncompatXdpi;
    public float noncompatYdpi;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.598 -0400", hash_original_method = "72B3D95037FCF3814777C19051FFD99D", hash_generated_method = "F1CBE159DA7C5627929690F2B8BDA786")
    @DSModeled(DSC.SAFE)
    public DisplayMetrics() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.598 -0400", hash_original_method = "D037FDEFC3DBB26170014E91328ECE75", hash_generated_method = "5E5771687E9088B8643B8C0BD4B5B340")
    @DSModeled(DSC.SAFE)
    public void setTo(DisplayMetrics o) {
        dsTaint.addTaint(o.dsTaint);
        widthPixels = o.widthPixels;
        heightPixels = o.heightPixels;
        density = o.density;
        densityDpi = o.densityDpi;
        scaledDensity = o.scaledDensity;
        xdpi = o.xdpi;
        ydpi = o.ydpi;
        noncompatWidthPixels = o.noncompatWidthPixels;
        noncompatHeightPixels = o.noncompatHeightPixels;
        noncompatDensity = o.noncompatDensity;
        noncompatScaledDensity = o.noncompatScaledDensity;
        noncompatXdpi = o.noncompatXdpi;
        noncompatYdpi = o.noncompatYdpi;
        // ---------- Original Method ----------
        //widthPixels = o.widthPixels;
        //heightPixels = o.heightPixels;
        //density = o.density;
        //densityDpi = o.densityDpi;
        //scaledDensity = o.scaledDensity;
        //xdpi = o.xdpi;
        //ydpi = o.ydpi;
        //noncompatWidthPixels = o.noncompatWidthPixels;
        //noncompatHeightPixels = o.noncompatHeightPixels;
        //noncompatDensity = o.noncompatDensity;
        //noncompatScaledDensity = o.noncompatScaledDensity;
        //noncompatXdpi = o.noncompatXdpi;
        //noncompatYdpi = o.noncompatYdpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.598 -0400", hash_original_method = "31EFDB43C431C1F23D54785D2F7319F2", hash_generated_method = "E7EADC1BC4F495010DDCCF6BCC9DD548")
    @DSModeled(DSC.SAFE)
    public void setToDefaults() {
        widthPixels = 0;
        heightPixels = 0;
        density = DENSITY_DEVICE / (float) DENSITY_DEFAULT;
        densityDpi = DENSITY_DEVICE;
        scaledDensity = density;
        xdpi = DENSITY_DEVICE;
        ydpi = DENSITY_DEVICE;
        noncompatWidthPixels = 0;
        noncompatHeightPixels = 0;
        // ---------- Original Method ----------
        //widthPixels = 0;
        //heightPixels = 0;
        //density = DENSITY_DEVICE / (float) DENSITY_DEFAULT;
        //densityDpi = DENSITY_DEVICE;
        //scaledDensity = density;
        //xdpi = DENSITY_DEVICE;
        //ydpi = DENSITY_DEVICE;
        //noncompatWidthPixels = 0;
        //noncompatHeightPixels = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.598 -0400", hash_original_method = "C565A2D49552DFC4E4E40856CD671AE3", hash_generated_method = "F93C578FB55B3687B4082DBDCE5D2ADC")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "DisplayMetrics{density=" + density + ", width=" + widthPixels +
            //", height=" + heightPixels + ", scaledDensity=" + scaledDensity +
            //", xdpi=" + xdpi + ", ydpi=" + ydpi + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.598 -0400", hash_original_method = "427067A59EEF5F2F4D6A0F2044964D8B", hash_generated_method = "8F99D23EFD98C06DE0DFC2176678054B")
    private static int getDeviceDensity() {
        return SystemProperties.getInt("qemu.sf.lcd_density",
                SystemProperties.getInt("ro.sf.lcd_density", DENSITY_DEFAULT));
    }

    
}


