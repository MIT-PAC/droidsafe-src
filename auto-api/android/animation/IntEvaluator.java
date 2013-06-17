package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IntEvaluator implements TypeEvaluator<Integer> {
    @DSModeled(DSC.SAFE)
    public IntEvaluator() {
    	//Synthesized method
    }
	
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 15:25:18.380 -0400", hash_original_method = "6401BD46F7D1EA9F5782F720B53B51D0", hash_generated_method = "E4A4D77D7B65760B9CD9909E85460449")
    @DSModeled(DSC.SAFE)
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        dsTaint.addTaint(endValue.dsTaint);
        dsTaint.addTaint(startValue.dsTaint);
        dsTaint.addTaint(fraction);
        int startInt;
        startInt = startValue;
        return (Integer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int startInt = startValue;
        //return (int)(startInt + fraction * (endValue - startInt));
    }

    
}

