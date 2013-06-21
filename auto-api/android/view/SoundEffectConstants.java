package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SoundEffectConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.290 -0400", hash_original_method = "A319F34C5C5FF8EBCB8ED9E8C1DFDB18", hash_generated_method = "16B79F2FF6A5D4209DC23CF0200A7932")
    @DSModeled(DSC.SAFE)
    private SoundEffectConstants() {
        // ---------- Original Method ----------
    }

    
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

    
    public static final int CLICK = 0;
    public static final int NAVIGATION_LEFT = 1;
    public static final int NAVIGATION_UP = 2;
    public static final int NAVIGATION_RIGHT = 3;
    public static final int NAVIGATION_DOWN = 4;
}

