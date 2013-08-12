package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;

public enum DialogState {
    EARLY,
    CONFIRMED,
    TERMINATED;
    public static final int _EARLY = EARLY.ordinal();
    public static final int _CONFIRMED = CONFIRMED.ordinal();
    public static final int _TERMINATED = TERMINATED.ordinal();
    @DSModeled(DSC.SAFE)
    public static DialogState getObject(int state) {
        try {
            return values()[state];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    "Invalid dialog state: " + state);
        }
    }
    @DSModeled(DSC.SAFE)
    public int getValue() {
        return ordinal();
    }
}
