package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.IPackageManager;

public class AppGlobals {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.510 -0400", hash_original_method = "49E661FE1E7E5458348589D881533201", hash_generated_method = "49E661FE1E7E5458348589D881533201")
        public AppGlobals ()
    {
    }


        public static Application getInitialApplication() {
        return ActivityThread.currentApplication();
    }

    
        public static String getInitialPackage() {
        return ActivityThread.currentPackageName();
    }

    
        public static IPackageManager getPackageManager() {
        return ActivityThread.getPackageManager();
    }

    
        public static int getIntCoreSetting(String key, int defaultValue) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread != null) {
            return currentActivityThread.getIntCoreSetting(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    
}

