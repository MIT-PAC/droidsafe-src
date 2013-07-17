package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PorterDuff {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.662 -0400", hash_original_method = "2DF832AFFC44E839897834B5EF3E55EC", hash_generated_method = "2DF832AFFC44E839897834B5EF3E55EC")
    public PorterDuff ()
    {
        //Synthesized constructor
    }


    public enum Mode {
        CLEAR       (0),
        SRC         (1),
        DST         (2),
        SRC_OVER    (3),
        DST_OVER    (4),
        SRC_IN      (5),
        DST_IN      (6),
        SRC_OUT     (7),
        DST_OUT     (8),
        SRC_ATOP    (9),
        DST_ATOP    (10),
        XOR         (11),
        DARKEN      (12),
        LIGHTEN     (13),
        MULTIPLY    (14),
        SCREEN      (15),
        ADD         (16),
        OVERLAY     (17);
        Mode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
}

