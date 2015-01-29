package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.VelocityTracker;

class VelocityTrackerCompatHoneycomb {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.633 -0500", hash_original_method = "11082224BD0B510ACDA84C36C46CDACD", hash_generated_method = "4983E11F8353DE595546EB66F53C17B3")
    
public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.635 -0500", hash_original_method = "18C022B6D8DDF782A044ADA2C56769B8", hash_generated_method = "5FDED2BDEF0520D01BDE337D87DE5BD3")
    
public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.340 -0400", hash_original_method = "8E5E73BB0A80B2A24A6F76B320F2144B", hash_generated_method = "8E5E73BB0A80B2A24A6F76B320F2144B")
    public VelocityTrackerCompatHoneycomb ()
    {
        //Synthesized constructor
    }
    
}

