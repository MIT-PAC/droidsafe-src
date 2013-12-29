package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InterruptedIOException;




public class ConnectTimeoutException extends InterruptedIOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.167 -0500", hash_original_field = "D4F741A639DD8EE2E9609EF9815EC445", hash_generated_field = "FFCC9C888252528507A7324B2271C230")


    private static final long serialVersionUID = -4816682903149535989L;

    /**
     * Creates a ConnectTimeoutException with a <tt>null</tt> detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.168 -0500", hash_original_method = "F05E8C7090F12D1341BCD22C7103FC0B", hash_generated_method = "55A23718BF631777D8F419DD3C9C4FC9")
    public ConnectTimeoutException() {
        super();
    }

    /**
     * Creates a ConnectTimeoutException with the specified detail message.
     * 
     * @param message The exception detail message 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.169 -0500", hash_original_method = "253E079134F8C2683EC310BD65E6492A", hash_generated_method = "E58B924467A604FE4E6873F1C007AADA")
    public ConnectTimeoutException(final String message) {
        super(message);
    }
}

