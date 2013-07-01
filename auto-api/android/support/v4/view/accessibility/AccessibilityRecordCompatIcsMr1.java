package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatIcsMr1 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.845 -0400", hash_original_method = "E8F783614F9BEB8A42DD8A4A1EDC26FF", hash_generated_method = "E8F783614F9BEB8A42DD8A4A1EDC26FF")
    public AccessibilityRecordCompatIcsMr1 ()
    {
        //Synthesized constructor
    }


    public static int getMaxScrollX(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollX();
    }

    
    public static int getMaxScrollY(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollY();
    }

    
    public static void setMaxScrollX(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    
    public static void setMaxScrollY(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }

    
}

