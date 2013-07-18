package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemProperties;

public class DisplayMetrics {
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
    
    @DSModeled(DSC.SAFE)
    public DisplayMetrics() {
    }

    
    @DSModeled(DSC.SAFE)
    public void setTo(DisplayMetrics o) {
        addTaint(o.getTaint());
    }

    
    @DSModeled(DSC.SAFE)
    public void setToDefaults() {
    }

    
    @Override
	@DSModeled(DSC.SAFE)
    public String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getDeviceDensity() {
        return 0;
    }

    
    public static final int DENSITY_LOW = 120;
    public static final int DENSITY_MEDIUM = 160;
    public static final int DENSITY_TV = 213;
    public static final int DENSITY_HIGH = 240;
    public static final int DENSITY_XHIGH = 320;
    public static final int DENSITY_DEFAULT = DENSITY_MEDIUM;
    public static final int DENSITY_DEVICE = getDeviceDensity();
}

