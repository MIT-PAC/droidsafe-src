package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class ProtocolException extends HttpException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.678 -0500", hash_original_field = "95B4E72D019CC987F27F1D51B7EDEE44", hash_generated_field = "603123FC7B49D9879A4E5B0588BA5212")


    private static final long serialVersionUID = -2143571074341228994L;
    
    /**
     * Creates a new ProtocolException with a <tt>null</tt> detail message. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.679 -0500", hash_original_method = "CB5496AEB6C4A3E562F8F77722FABABF", hash_generated_method = "8B6696BF29FAAB0012126FB460B9E25B")
    public ProtocolException() {
        super();
    }

    /**
     * Creates a new ProtocolException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.680 -0500", hash_original_method = "4EA2FDECEBB843A0FFF4778186BBC741", hash_generated_method = "954604A616CA94114D25DB22D29E9C2A")
    public ProtocolException(String message) {
        super(message);
    }

    /**
     * Creates a new ProtocolException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.681 -0500", hash_original_method = "3D82246BF1BA99079EA7B971F6EA0CE7", hash_generated_method = "6D7C0D8734C2BF95479EC8BFF7C48A84")
    public ProtocolException(String message, Throwable cause) {
        super(message, cause);
    }
}

