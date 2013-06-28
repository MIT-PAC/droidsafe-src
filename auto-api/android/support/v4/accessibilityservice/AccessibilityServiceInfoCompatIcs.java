package android.support.v4.accessibilityservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.468 -0400", hash_original_method = "9B73EB9A9914C24E49AE97BE4E097848", hash_generated_method = "9B73EB9A9914C24E49AE97BE4E097848")
    public AccessibilityServiceInfoCompatIcs ()
    {
        //Synthesized constructor
    }


        public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
        return info.getCanRetrieveWindowContent();
    }

    
        public static String getDescription(AccessibilityServiceInfo info) {
        return info.getDescription();
    }

    
        public static String getId(AccessibilityServiceInfo info) {
        return info.getId();
    }

    
        public static ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
        return info.getResolveInfo();
    }

    
        public static String getSettingsActivityName(AccessibilityServiceInfo info) {
        return info.getSettingsActivityName();
    }

    
}

