package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.*;



import droidsafe.helpers.DSUtils;

public class DashPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.198 -0400", hash_original_method = "302355CEB1EDA8CF763D5137DB0E93A1", hash_generated_method = "CF8DD8A22C8DC0BFD29E11C5C35E224C")
    public  DashPathEffect(float intervals[], float phase) {
        addTaint(phase);
        addTaint(intervals[0]);
        if(intervals.length < 2)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1232739038 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1232739038.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1232739038;
        } //End block
        native_instance = nativeCreate(intervals, phase);
        // ---------- Original Method ----------
        //if (intervals.length < 2) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_instance = nativeCreate(intervals, phase);
    }

    
    @DSModeled(DSC.SPEC)
    private static int nativeCreate(float intervals[], float phase) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

