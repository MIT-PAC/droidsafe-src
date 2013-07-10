package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class ViewCompatICS {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.050 -0400", hash_original_method = "216CDC7D30D86F2C2CF6BA6EB77F522A", hash_generated_method = "216CDC7D30D86F2C2CF6BA6EB77F522A")
    public ViewCompatICS ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static boolean canScrollHorizontally(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean canScrollVertically(View v, int direction) {
        return v.canScrollVertically(direction);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setAccessibilityDelegate(View v, Object delegate) {
        v.setAccessibilityDelegate((AccessibilityDelegate) delegate);
    }

    
    @DSModeled(DSC.SAFE)
    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        
        v.onPopulateAccessibilityEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        
        v.onInitializeAccessibilityEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    public static void onInitializeAccessibilityNodeInfo(View v, Object info) {
        
        v.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) info);
    }

    
}

