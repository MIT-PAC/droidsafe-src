package android.support.v4.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityEventCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.418 -0400", hash_original_method = "069BFECEEC392A14639D69FB687BE2FC", hash_generated_method = "069BFECEEC392A14639D69FB687BE2FC")
    public AccessibilityEventCompatIcs ()
    {
        //Synthesized constructor
    }


    public static int getRecordCount(AccessibilityEvent event) {
        return event.getRecordCount();
    }

    
    public static void appendRecord(AccessibilityEvent event, Object record) {
        event.appendRecord((AccessibilityRecord) record);
    }

    
    public static Object getRecord(AccessibilityEvent event, int index) {
        return event.getRecord(index);
    }

    
}

