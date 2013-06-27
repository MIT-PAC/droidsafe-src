package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SoundEffectConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.068 -0400", hash_original_method = "A319F34C5C5FF8EBCB8ED9E8C1DFDB18", hash_generated_method = "16B79F2FF6A5D4209DC23CF0200A7932")
    private  SoundEffectConstants() {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.069 -0400", hash_original_field = "2FC44226DF29F5F6CD72BA6227E74B5C", hash_generated_field = "842011BA204767E970B6FF04330AC6F7")

    public static final int CLICK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.069 -0400", hash_original_field = "FAB801A719FE6C1AA03655B8A057C93C", hash_generated_field = "46B8495A67E10249C4EEB9EC55DBA5FB")

    public static final int NAVIGATION_LEFT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.069 -0400", hash_original_field = "E2D7D8D2D5D6F01E487C9E20CEFA2CAF", hash_generated_field = "D84D0C65CA4D7F96B230BC929FB4712A")

    public static final int NAVIGATION_UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.069 -0400", hash_original_field = "279D181FD0B3A03687A77A7D28CEDC6A", hash_generated_field = "8EE0B662BC7D73676FD543978DA23BBE")

    public static final int NAVIGATION_RIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.069 -0400", hash_original_field = "ABE2B681E345E485CC31F84CFD8E852B", hash_generated_field = "EE4649B90CD478CCF358B3C657EE8B88")

    public static final int NAVIGATION_DOWN = 4;
}

