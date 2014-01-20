package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PorterDuff {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.094 -0500", hash_original_method = "787C81E539A7EA8A7036FAB09EA6039E", hash_generated_method = "787C81E539A7EA8A7036FAB09EA6039E")
            
Mode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.096 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "98EAA4A55387890AE1074B767C7F1464")

        public  int nativeInt;
    }
    
}

