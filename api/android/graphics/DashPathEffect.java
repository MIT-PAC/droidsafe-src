package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DashPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.242 -0400", hash_original_method = "302355CEB1EDA8CF763D5137DB0E93A1", hash_generated_method = "7B578DC266C01EDC906CBA5ABFC1C1DB")
    public  DashPathEffect(float intervals[], float phase) {
        addTaint(phase);
        addTaint(intervals[0]);
    if(intervals.length < 2)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_827280248 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_827280248.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_827280248;
        } 
        native_instance = nativeCreate(intervals, phase);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    private static int nativeCreate(float intervals[], float phase) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

