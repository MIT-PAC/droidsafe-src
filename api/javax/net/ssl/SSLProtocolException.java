package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class SSLProtocolException extends SSLException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.255 -0500", hash_original_field = "7BD2EF1A671A3A3FA133FB51EE92D298", hash_generated_field = "6C50D38407180FECBFC4FCDCF44B613A")


    private static final long serialVersionUID = 5445067063799134928L;

    /**
     * Creates a new {@code SSLProtocolException} with the specified message.
     *
     * @param reason
     *            the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.258 -0500", hash_original_method = "980B3B5BE05602C62F726F0E6039DCA2", hash_generated_method = "4157D0202135A1ED6905CB502ECF13F1")
    
public SSLProtocolException(String reason) {
        super(reason);
    }
}

