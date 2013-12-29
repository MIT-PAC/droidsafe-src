package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.pm.IPackageManager;


public class AppGlobals {
    /**
     * Return the first Application object made in the process.
     * NOTE: Only works on the main thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:21.987 -0500", hash_original_method = "615B30682586F952B352C593B075DF62", hash_generated_method = "0CCF50F7AC209376FC1F99820D1A05AE")
    public static Application getInitialApplication() {
        return ActivityThread.currentApplication();
    }
    
    /**
     * Return the package name of the first .apk loaded into the process.
     * NOTE: Only works on the main thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:21.988 -0500", hash_original_method = "A3B1FB3314BAC71CAE100390DD0225EF", hash_generated_method = "76990655FC40378EC60498AA9203ABC8")
    public static String getInitialPackage() {
        return ActivityThread.currentPackageName();
    }

    /**
     * Return the raw interface to the package manager.
     * @return The package manager.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:21.989 -0500", hash_original_method = "03A658BC1E4842F8DA4AD0A4A85FFB8B", hash_generated_method = "4D144CDA5376A1CCF5ECBDA8BE74F503")
    public static IPackageManager getPackageManager() {
        return ActivityThread.getPackageManager();
    }

    /**
     * Gets the value of an integer core setting.
     *
     * @param key The setting key.
     * @param defaultValue The setting default value.
     * @return The core settings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:21.989 -0500", hash_original_method = "D7AB7FBE9FEBD3B049AA5454BF4A405C", hash_generated_method = "9CF396C654B70B30DE8A6CF56A75B7CE")
    public static int getIntCoreSetting(String key, int defaultValue) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread != null) {
            return currentActivityThread.getIntCoreSetting(key, defaultValue);
        } else {
            return defaultValue;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.087 -0400", hash_original_method = "225CC013D111255E32A02621AE08F9A5", hash_generated_method = "225CC013D111255E32A02621AE08F9A5")
    public AppGlobals ()
    {
        //Synthesized constructor
    }

    
}

