package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SoundEffectConstants {
    public static final int CLICK = 0;
    public static final int NAVIGATION_LEFT = 1;
    public static final int NAVIGATION_UP = 2;
    public static final int NAVIGATION_RIGHT = 3;
    public static final int NAVIGATION_DOWN = 4;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.527 -0400", hash_original_method = "A319F34C5C5FF8EBCB8ED9E8C1DFDB18", hash_generated_method = "CBFEE9D6C0E8FE011B96C80069142231")
    @DSModeled(DSC.SAFE)
    private SoundEffectConstants() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.528 -0400", hash_original_method = "975CB3430388B53E2334113DC7870A4A", hash_generated_method = "1809AE194BC69154A7C4FD122CC41E61")
    public static int getContantForFocusDirection(int direction) {
        switch (direction) {
            case View.FOCUS_RIGHT:
                return SoundEffectConstants.NAVIGATION_RIGHT;
            case View.FOCUS_FORWARD:
            case View.FOCUS_DOWN:
                return SoundEffectConstants.NAVIGATION_DOWN;
            case View.FOCUS_LEFT:
                return SoundEffectConstants.NAVIGATION_LEFT;
            case View.FOCUS_BACKWARD:
            case View.FOCUS_UP:
                return SoundEffectConstants.NAVIGATION_UP;
        }
        throw new IllegalArgumentException("direction must be one of "
                + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    
}


