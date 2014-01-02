package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;




public class RedirectException extends ProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.085 -0500", hash_original_field = "699B057AC88B99662CD1FBC269EF0251", hash_generated_field = "FAC8F8BB112A11F76DAF47499FAE9BA5")


    private static final long serialVersionUID = 4418824536372559326L;

    /**
     * Creates a new RedirectException with a <tt>null</tt> detail message. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.087 -0500", hash_original_method = "8993A7EF0CD7BC2114A435E71DE5C46D", hash_generated_method = "A1AA69329CF0E7B747928CF9B93902E4")
    
public RedirectException() {
        super();
    }

    /**
     * Creates a new RedirectException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.091 -0500", hash_original_method = "BF4F2A0BBB2FD109EB1FCB43C3342F5C", hash_generated_method = "9FF62721B76C06749A2B6FEDB057969D")
    
public RedirectException(String message) {
        super(message);
    }

    /**
     * Creates a new RedirectException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.095 -0500", hash_original_method = "4935B20DF448DBE22DB0549C57AECB3F", hash_generated_method = "7A27DD1E065EF91F07F9938DE4EFCB45")
    
public RedirectException(String message, Throwable cause) {
        super(message, cause);
    }
}

