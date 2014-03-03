package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class DashPathEffect extends PathEffect {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate(float intervals[], float phase) {
        return (int)(phase + intervals[0] + intervals.getTaintInt());
    }

    /**
     * The intervals array must contain an even number of entries (>=2), with
     * the even indices specifying the "on" intervals, and the odd indices
     * specifying the "off" intervals. phase is an offset into the intervals
     * array (mod the sum of all of the intervals). The intervals array
     * controls the length of the dashes. The paint's strokeWidth controls the
     * thickness of the dashes.
     * Note: this patheffect only affects drawing with the paint's style is set
     * to STROKE or STROKE_AND_FILL. It is ignored if the drawing is done with
     * style == FILL.
     * @param intervals array of ON and OFF distances
     * @param phase offset into the intervals array
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.096 -0500", hash_original_method = "302355CEB1EDA8CF763D5137DB0E93A1", hash_generated_method = "3D66E37A69227B620BE1EC89EE565D3E")
    
public DashPathEffect(float intervals[], float phase) {
        if (intervals.length < 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_instance = nativeCreate(intervals, phase);
    }
    
}

