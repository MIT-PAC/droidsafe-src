package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatIcsMr1 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.845 -0400", hash_original_method = "E8F783614F9BEB8A42DD8A4A1EDC26FF", hash_generated_method = "E8F783614F9BEB8A42DD8A4A1EDC26FF")
    public AccessibilityRecordCompatIcsMr1 ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static int getMaxScrollX(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollX();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getMaxScrollY(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollY();
    }

    
    @DSModeled(DSC.SAFE)
    public static void setMaxScrollX(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setMaxScrollY(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }

    
}

