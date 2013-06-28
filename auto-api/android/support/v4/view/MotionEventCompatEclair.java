package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MotionEvent;

class MotionEventCompatEclair {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.630 -0400", hash_original_method = "5ACF9ABC04422C9663D1A845A64C1366", hash_generated_method = "5ACF9ABC04422C9663D1A845A64C1366")
    public MotionEventCompatEclair ()
    {
        //Synthesized constructor
    }


        public static int findPointerIndex(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }

    
        public static int getPointerId(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }

    
        public static float getX(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }

    
        public static float getY(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }

    
        public static int getPointerCount(MotionEvent event) {
        return event.getPointerCount();
    }

    
}

