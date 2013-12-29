package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;




public class AuthenticationException extends ProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.546 -0500", hash_original_field = "6BF02D8782E0C45905064B2F5764C15B", hash_generated_field = "3DEC0A489DB670A71940A7B9CE08226B")


    private static final long serialVersionUID = -6794031905674764776L;

    /**
     * Creates a new AuthenticationException with a <tt>null</tt> detail message. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.547 -0500", hash_original_method = "013088ABC431C6F3F4CF96BA31947D05", hash_generated_method = "589B79B769FA1AE4B40AF25F9E862625")
    public AuthenticationException() {
        super();
    }

    /**
     * Creates a new AuthenticationException with the specified message.
     * 
     * @param message the exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.548 -0500", hash_original_method = "42EE7D04E120D0BA05395B903F4DA9F5", hash_generated_method = "92F7E12BC4612F2A7DFCF0C8EB87515A")
    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * Creates a new AuthenticationException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.549 -0500", hash_original_method = "E1E933639B5521F15D3C671D186FDEA6", hash_generated_method = "8AA381DB12CD16743FC05C7A7A1825CA")
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

