package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DashPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.231 -0400", hash_original_method = "302355CEB1EDA8CF763D5137DB0E93A1", hash_generated_method = "395628568F83DB64A8D3F85B8481E385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DashPathEffect(float intervals[], float phase) {
        dsTaint.addTaint(intervals);
        dsTaint.addTaint(phase);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_instance = nativeCreate(intervals, phase);
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

