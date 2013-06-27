package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DashPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.484 -0400", hash_original_method = "302355CEB1EDA8CF763D5137DB0E93A1", hash_generated_method = "3C72E9CE9318912A2EB3C0FCE964BAA2")
    public  DashPathEffect(float intervals[], float phase) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_instance = nativeCreate(intervals, phase);
        addTaint(intervals);
        addTaint(phase);
        // ---------- Original Method ----------
        //if (intervals.length < 2) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_instance = nativeCreate(intervals, phase);
    }

    
        private static int nativeCreate(float intervals[], float phase) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

