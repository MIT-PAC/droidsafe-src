package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;

class AccessibilityManagerCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.452 -0400", hash_original_method = "72B16DB5C6E2AFBDDF09192B7BE11FB7", hash_generated_method = "72B16DB5C6E2AFBDDF09192B7BE11FB7")
    public AccessibilityManagerCompatIcs ()
    {
        
    }


    public static Object newAccessibilityStateChangeListener(
            final AccessibilityStateChangeListenerBridge bridge) {
        return new AccessibilityStateChangeListener() {
            @Override
            public void onAccessibilityStateChanged(boolean enabled) {
                bridge.onAccessibilityStateChanged(enabled);
            }
        };
    }

    
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
            Object listener) {
        return manager.addAccessibilityStateChangeListener(
                (AccessibilityStateChangeListener)listener);
    }

    
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
            Object listener) {
        return manager.removeAccessibilityStateChangeListener(
                (AccessibilityStateChangeListener)listener);
    }

    
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            AccessibilityManager manager,int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
            AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    
    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }

    
    interface AccessibilityStateChangeListenerBridge {
        public void onAccessibilityStateChanged(boolean enabled);
    }
    
    
}

