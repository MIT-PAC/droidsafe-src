package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.VelocityTracker;

class VelocityTrackerCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.021 -0400", hash_original_method = "8E5E73BB0A80B2A24A6F76B320F2144B", hash_generated_method = "8E5E73BB0A80B2A24A6F76B320F2144B")
    public VelocityTrackerCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    
    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }

    
}

