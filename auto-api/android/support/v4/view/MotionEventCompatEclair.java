package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.MotionEvent;

class MotionEventCompatEclair {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.460 -0400", hash_original_method = "5ACF9ABC04422C9663D1A845A64C1366", hash_generated_method = "5ACF9ABC04422C9663D1A845A64C1366")
    public MotionEventCompatEclair ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static int findPointerIndex(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPointerId(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }

    
    @DSModeled(DSC.SAFE)
    public static float getX(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }

    
    @DSModeled(DSC.SAFE)
    public static float getY(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPointerCount(MotionEvent event) {
        return event.getPointerCount();
    }

    
}

