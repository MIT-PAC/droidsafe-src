package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class ViewCompatICS {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.050 -0400", hash_original_method = "216CDC7D30D86F2C2CF6BA6EB77F522A", hash_generated_method = "216CDC7D30D86F2C2CF6BA6EB77F522A")
    public ViewCompatICS ()
    {
        //Synthesized constructor
    }


    public static boolean canScrollHorizontally(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    
    public static boolean canScrollVertically(View v, int direction) {
        return v.canScrollVertically(direction);
    }

    
    public static void setAccessibilityDelegate(View v, Object delegate) {
        v.setAccessibilityDelegate((AccessibilityDelegate) delegate);
    }

    
    public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        v.onPopulateAccessibilityEvent(event);
    }

    
    public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        v.onInitializeAccessibilityEvent(event);
    }

    
    public static void onInitializeAccessibilityNodeInfo(View v, Object info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        v.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) info);
    }

    
}

