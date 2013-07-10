package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.pm.IPackageManager;

public class AppGlobals {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.201 -0400", hash_original_method = "225CC013D111255E32A02621AE08F9A5", hash_generated_method = "225CC013D111255E32A02621AE08F9A5")
    public AppGlobals ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static Application getInitialApplication() {
        return ActivityThread.currentApplication();
    }

    
    @DSModeled(DSC.SAFE)
    public static String getInitialPackage() {
        return ActivityThread.currentPackageName();
    }

    
    @DSModeled(DSC.SAFE)
    public static IPackageManager getPackageManager() {
        return ActivityThread.getPackageManager();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getIntCoreSetting(String key, int defaultValue) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread != null) {
            return currentActivityThread.getIntCoreSetting(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    
}

