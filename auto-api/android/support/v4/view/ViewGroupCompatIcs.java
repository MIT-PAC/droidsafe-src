package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ViewGroupCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.149 -0400", hash_original_method = "AFC480F7DB19E0FA759518D4ECDB4097", hash_generated_method = "AFC480F7DB19E0FA759518D4ECDB4097")
    public ViewGroupCompatIcs ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child,
            AccessibilityEvent event) {
        
        return group.onRequestSendAccessibilityEvent(child, event);
    }

    
}

