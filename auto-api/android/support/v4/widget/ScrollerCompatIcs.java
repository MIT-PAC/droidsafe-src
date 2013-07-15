package android.support.v4.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.widget.Scroller;

class ScrollerCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.353 -0400", hash_original_method = "D8E033F480AC7CF1A3A03900958CEC21", hash_generated_method = "D8E033F480AC7CF1A3A03900958CEC21")
    public ScrollerCompatIcs ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static float getCurrVelocity(Scroller scroller) {
        return scroller.getCurrVelocity();
    }

    
}

