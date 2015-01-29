package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;

public class MalformedChallengeException extends ProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.107 -0500", hash_original_field = "48A226D7B52117EB5075E5060FB4AEAB", hash_generated_field = "AFA1C979014CF4804525DA715B9B4C42")

    private static final long serialVersionUID = 814586927989932284L;

    /**
     * Creates a new MalformedChallengeException with a <tt>null</tt> detail message. 
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.110 -0500", hash_original_method = "67DFA658E3AD1AB9DCC34A02D12F48C7", hash_generated_method = "7A24B9E3A7FB1E35014CB1AEFE3BD934")
    
public MalformedChallengeException() {
        super();
    }

    /**
     * Creates a new MalformedChallengeException with the specified message.
     * 
     * @param message the exception detail message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.112 -0500", hash_original_method = "E77F68EE2D3DB39201883D122D0ED2C1", hash_generated_method = "BD0599F28851807EB8394F23663BDC66")
    
public MalformedChallengeException(String message) {
        super(message);
    }

    /**
     * Creates a new MalformedChallengeException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.115 -0500", hash_original_method = "58A10F22323B4B8503459506A12E3479", hash_generated_method = "1D95BBC61498E5F4C57C445376D1F116")
    
public MalformedChallengeException(String message, Throwable cause) {
        super(message, cause);
    }
}

