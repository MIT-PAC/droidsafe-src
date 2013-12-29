package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public class EventObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:53.278 -0500", hash_original_field = "FCFD693445D5C91823A585314B80016E", hash_generated_field = "7EDA1B54A84BB88DBCC9E4ADB18207F4")


    private static final long serialVersionUID = 5516075349620653480L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:53.279 -0500", hash_original_field = "B1F1A09178B285CE5A5A0F0FA17DB436", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")


    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    protected transient Object source;

    /**
     * Constructs a new instance of this class.
     *
     * @param source
     *            the object which fired the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:53.280 -0500", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "31254B198F68157457014067B2589821")
    public EventObject(Object source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        this.source = source;
    }

    /**
     * Returns the object which fired the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:53.281 -0500", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "3D28168EFE76736511F32DF40C7D247E")
    public Object getSource() {
        return source;
    }

    /**
     * Returns the string representation of this {@code EventObject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:53.282 -0500", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "2A2B8D705213FD04B84EB4BB1F536CF0")
    @Override
public String toString() {
        return getClass().getName() + "[source=" + source + ']';
    }
}

