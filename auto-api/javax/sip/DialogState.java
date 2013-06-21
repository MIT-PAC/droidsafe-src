package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public enum DialogState {
    EARLY,
    CONFIRMED,
    TERMINATED;
    public static final int _EARLY = EARLY.ordinal();
    public static final int _CONFIRMED = CONFIRMED.ordinal();
    public static final int _TERMINATED = TERMINATED.ordinal();
    public static DialogState getObject(int state) {
        try {
            return values()[state];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    "Invalid dialog state: " + state);
        }
    }
    public int getValue() {
        return ordinal();
    }
}
