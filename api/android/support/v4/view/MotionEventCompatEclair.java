package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.MotionEvent;




class MotionEventCompatEclair {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.302 -0400", hash_original_method = "5ACF9ABC04422C9663D1A845A64C1366", hash_generated_method = "5ACF9ABC04422C9663D1A845A64C1366")
    public MotionEventCompatEclair ()
    {
        //Synthesized constructor
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

