package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PorterDuff {
    
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


