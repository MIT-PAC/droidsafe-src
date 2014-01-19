package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class ViewCompatICS {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.453 -0500", hash_original_method = "C0522BEF843F9666532A0434F680BA88", hash_generated_method = "648BD5B5BBEE5B1A7F8F78DB2F04EA13")
    
public static boolean canScrollHorizontally(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.455 -0500", hash_original_method = "47177EB6AD2EB35EE6530B0FBC1A2441", hash_generated_method = "8263C89B6362088CFA64D0F78E763182")
    
public static boolean canScrollVertically(View v, int direction) {
        return v.canScrollVertically(direction);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.457 -0500", hash_original_method = "C38D781B3ABC8EC09DCBB566904A04E2", hash_generated_method = "F65664608C88027274EBD1A17E341D54")
    
public static void setAccessibilityDelegate(View v, Object delegate) {
        v.setAccessibilityDelegate((AccessibilityDelegate) delegate);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.460 -0500", hash_original_method = "F785B9CD5EFB49103109F2E8CAD4C2DC", hash_generated_method = "8312C85B74BFA052A53612212A6ED418")
    
public static void onPopulateAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onPopulateAccessibilityEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.462 -0500", hash_original_method = "AB0A34721D25ED8020B2C8629C68DFE1", hash_generated_method = "A01ADB9A6A4DDF4CAAEFFF82DC0ABF1C")
    
public static void onInitializeAccessibilityEvent(View v, AccessibilityEvent event) {
        v.onInitializeAccessibilityEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:20.464 -0500", hash_original_method = "FDCB72B5F6180C9070E7E85AB4DFD30A", hash_generated_method = "7AF2CD0858ABC4C808934260AE0BE59C")
    
public static void onInitializeAccessibilityNodeInfo(View v, Object info) {
        v.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) info);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.384 -0400", hash_original_method = "216CDC7D30D86F2C2CF6BA6EB77F522A", hash_generated_method = "216CDC7D30D86F2C2CF6BA6EB77F522A")
    public ViewCompatICS ()
    {
        //Synthesized constructor
    }
    
}

