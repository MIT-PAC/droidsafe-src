package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class InputEvent implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.714 -0500", hash_original_field = "D353F508F6AA39751F118E1F09F69910", hash_generated_field = "62C44C836E8114E8865353F1FB18E80F")

    protected static final int PARCEL_TOKEN_MOTION_EVENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.717 -0500", hash_original_field = "897FCB30765A2140F90B149415B69C3D", hash_generated_field = "1AF89CAACCDFDF81F11811438489CC29")

    protected static final int PARCEL_TOKEN_KEY_EVENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.020 -0400", hash_original_field = "04B291F0A19F70F4DCABF30040F87AB0", hash_generated_field = "DFF9DB35F1A192334CC0B98EE577AF20")

    public static final Parcelable.Creator<InputEvent> CREATOR
            = new Parcelable.Creator<InputEvent>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.747 -0500", hash_original_method = "1E6CF60294C8C01670FD09697A2C8F1E", hash_generated_method = "87540945CBD4744CD14608731AB18576")
        
public InputEvent createFromParcel(Parcel in) {
            int token = in.readInt();
            if (token == PARCEL_TOKEN_KEY_EVENT) {
                return KeyEvent.createFromParcelBody(in);
            } else if (token == PARCEL_TOKEN_MOTION_EVENT) {
                return MotionEvent.createFromParcelBody(in);
            } else {
                throw new IllegalStateException("Unexpected input event type token in parcel.");
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.749 -0500", hash_original_method = "7DD87234BD0A6395014BBD1487432510", hash_generated_method = "ECE0600CF37782308682555D96F3A227")
        
public InputEvent[] newArray(int size) {
            return new InputEvent[size];
        }
    };
    
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.719 -0500", hash_original_method = "5E30BC92EB346FB6C373466BBBDCD9C6", hash_generated_method = "5E30BC92EB346FB6C373466BBBDCD9C6")
    
InputEvent() {
    }

    /**
     * Gets the id for the device that this event came from.  An id of
     * zero indicates that the event didn't come from a physical device
     * and maps to the default keymap.  The other numbers are arbitrary and
     * you shouldn't depend on the values.
     * 
     * @return The device id.
     * @see InputDevice#getDevice
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.722 -0500", hash_original_method = "4664318C4E5CEE2F2231757C2DC4118A", hash_generated_method = "3B14757130AFF8B8E9C371FA9EA594F7")
    
public abstract int getDeviceId();

    /**
     * Gets the device that this event came from.
     * 
     * @return The device, or null if unknown.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.724 -0500", hash_original_method = "65C564B77C92C924B4A35B510EAEB2C6", hash_generated_method = "D82E2F4292D188F31702A7D0E9F338EC")
    
public final InputDevice getDevice() {
        return InputDevice.getDevice(getDeviceId());
    }

    /**
     * Gets the source of the event.
     * 
     * @return The event source or {@link InputDevice#SOURCE_UNKNOWN} if unknown.
     * @see InputDevice#getSourceInfo
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.727 -0500", hash_original_method = "31DA09D399170337D011C7ABAD120D1F", hash_generated_method = "0C97D3321F33F5C733A0CBF04E67E523")
    
public abstract int getSource();

    /**
     * Modifies the source of the event.
     *
     * @param source The new source.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.729 -0500", hash_original_method = "96375597F88BD2D6F4E68958C44C8C4D", hash_generated_method = "50377F54DE8931FCC46FFA58C5F141CC")
    
public abstract void setSource(int source);

    /**
     * Copies the event.
     *
     * @return A deep copy of the event.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.732 -0500", hash_original_method = "9DDDBCB38C8769B564E2198A8E8FC6D9", hash_generated_method = "63D1EA3AC9E722B24271F7B18B02D29A")
    
public abstract InputEvent copy();

    /**
     * Recycles the event.
     * This method should only be used by the system since applications do not
     * expect {@link KeyEvent} objects to be recycled, although {@link MotionEvent}
     * objects are fine.  See {@link KeyEvent#recycle()} for details.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.734 -0500", hash_original_method = "F236C92B3FC5E7319EEC9571B181713B", hash_generated_method = "75E6A8511076D858E3DA9D0FA62A4E42")
    
public abstract void recycle();

    /**
     * Gets a private flag that indicates when the system has detected that this input event
     * may be inconsistent with respect to the sequence of previously delivered input events,
     * such as when a key up event is sent but the key was not down or when a pointer
     * move event is sent but the pointer is not down.
     *
     * @return True if this event is tainted.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.737 -0500", hash_original_method = "530E6412340D3E4B3C470540E9517380", hash_generated_method = "1510C9D6576E8DB584D28D0F35796077")
    
public abstract boolean isTainted();

    /**
     * Sets a private flag that indicates when the system has detected that this input event
     * may be inconsistent with respect to the sequence of previously delivered input events,
     * such as when a key up event is sent but the key was not down or when a pointer
     * move event is sent but the pointer is not down.
     *
     * @param tainted True if this event is tainted.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.739 -0500", hash_original_method = "AE64E77C1EFE9C9FB95B01CB9D173429", hash_generated_method = "F2E2FBA0DD500051814C9FAFA0209B0C")
    
public abstract void setTainted(boolean tainted);

    /**
     * Returns the time (in ns) when this specific event was generated.
     * The value is in nanosecond precision but it may not have nanosecond accuracy.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.741 -0500", hash_original_method = "D0D9806AE353526032A1C17B8A5FD0F3", hash_generated_method = "70288428E8ED14988681B539AF1289E9")
    
public abstract long getEventTimeNano();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.744 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public InputEvent createFromParcel(Parcel in) {
            int token = in.readInt();
            if (token == PARCEL_TOKEN_KEY_EVENT) {
                return KeyEvent.createFromParcelBody(in);
            } else if (token == PARCEL_TOKEN_MOTION_EVENT) {
                return MotionEvent.createFromParcelBody(in);
            } else {
                throw new IllegalStateException("Unexpected input event type token in parcel.");
            }
        }
    
    // orphaned legacy method
    public InputEvent[] newArray(int size) {
            return new InputEvent[size];
        }
    
}

