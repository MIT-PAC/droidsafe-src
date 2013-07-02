package android.support.v4.accessibilityservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.468 -0400", hash_original_method = "9B73EB9A9914C24E49AE97BE4E097848", hash_generated_method = "9B73EB9A9914C24E49AE97BE4E097848")
    public AccessibilityServiceInfoCompatIcs ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
        return info.getCanRetrieveWindowContent();
    }

    
        @DSModeled(DSC.SAFE)
    public static String getDescription(AccessibilityServiceInfo info) {
        return info.getDescription();
    }

    
        @DSModeled(DSC.SAFE)
    public static String getId(AccessibilityServiceInfo info) {
        return info.getId();
    }

    
        @DSModeled(DSC.SAFE)
    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
        return info.getResolveInfo();
    }

    
        @DSModeled(DSC.SAFE)
    public static String getSettingsActivityName(AccessibilityServiceInfo info) {
        return info.getSettingsActivityName();
    }

    
}

