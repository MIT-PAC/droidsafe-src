package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IllegalMonitorStateException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.580 -0500", hash_original_field = "D814A341D0C7ADC6CABE3831D03DA7DE", hash_generated_field = "0BB0A250975987D9B0100EE2A72E1F4E")

    private static final long serialVersionUID = 3713306369498869069L;

    /**
     * Constructs a new {@code IllegalMonitorStateException} that includes the
     * current stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.582 -0500", hash_original_method = "A830880207AC191B3684BF337F5E0247", hash_generated_method = "153F38E90620A252A3BF0FC88F4C3616")
    
public IllegalMonitorStateException() {
    }

    /**
     * Constructs a new {@code IllegalArgumentException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.585 -0500", hash_original_method = "1591087F36D115C0B3CDF3D9C0FC50C3", hash_generated_method = "BFA362C19E4CD2A6C309452CC95BB050")
    
public IllegalMonitorStateException(String detailMessage) {
        super(detailMessage);
    }
}

