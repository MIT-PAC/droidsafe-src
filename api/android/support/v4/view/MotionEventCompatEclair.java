package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.MotionEvent;




class MotionEventCompatEclair {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.188 -0500", hash_original_method = "4532F0A9C8412F2F18F248FA9DC36704", hash_generated_method = "07394EB775CDD65867A9302D3C85D64A")
    public static int findPointerIndex(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.189 -0500", hash_original_method = "0313DEEDC2C2EBC5612C0D1F7EE1D400", hash_generated_method = "A64F52BCDA66FABECF4DB57D2C1DD113")
    public static int getPointerId(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.190 -0500", hash_original_method = "71037EC82E25334B8658FE7CAF74254C", hash_generated_method = "2A62E5EB8B53070140816646ABF8B82F")
    public static float getX(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.191 -0500", hash_original_method = "E6751B9CCEB4AE9E9D1DFA2B571CCFF4", hash_generated_method = "F2EA8628AE2361A523076152891B6FF4")
    public static float getY(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.192 -0500", hash_original_method = "35653BBE54B1920FB4D0E64EA7E26E6C", hash_generated_method = "DE1B0BA5CE673EAA99F15BF6532BB078")
    public static int getPointerCount(MotionEvent event) {
        return event.getPointerCount();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.302 -0400", hash_original_method = "5ACF9ABC04422C9663D1A845A64C1366", hash_generated_method = "5ACF9ABC04422C9663D1A845A64C1366")
    public MotionEventCompatEclair ()
    {
        //Synthesized constructor
    }

    
}

