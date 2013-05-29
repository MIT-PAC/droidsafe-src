package android.util;
import droidsafe.annotations.*;
import droidsafe.helpers.*;
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
    
	@DSModeled(DSC.SAFE)
    public DisplayMetrics() {
    }
    
	@DSModeled(DSC.SAFE)
    public void setTo(DisplayMetrics o) {
        dsTaint.addTaint(o.dsTaint);
    }
    
	@DSModeled(DSC.SAFE)
    public void setToDefaults() {
    }
    @Override
	@DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
    }
    
	@DSModeled(DSC.SAFE)
    private static int getDeviceDensity() {
        return 0;
    }
}
