package android.support.v4.view;

// Droidsafe Imports
import android.view.VelocityTracker;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class VelocityTrackerCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.340 -0400", hash_original_method = "8E5E73BB0A80B2A24A6F76B320F2144B", hash_generated_method = "8E5E73BB0A80B2A24A6F76B320F2144B")
    public VelocityTrackerCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    
    @DSModeled(DSC.SPEC)
    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }

    
}

