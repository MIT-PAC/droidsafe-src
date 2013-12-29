package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.640 -0500", hash_original_field = "F96FDB20E90DE6136BFF430E7DA1B43C", hash_generated_field = "E7B811CC0F7FBE05DC02261FB6EB070A")


    private static final long serialVersionUID = -7898874842020245128L;

    /**
     * Creates a ConnectTimeoutException with a <tt>null</tt> detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.641 -0500", hash_original_method = "1DCDBD8202B02F10B12F065EF60143EE", hash_generated_method = "71A8491FD15CC48A6A994868E429A1DC")
    public ConnectionPoolTimeoutException() {
        super();
    }

    /**
     * Creates a ConnectTimeoutException with the specified detail message.
     * 
     * @param message The exception detail message 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:17.642 -0500", hash_original_method = "6FAEC3D93E1C94116A1DCC64CCDF43BD", hash_generated_method = "9677B7DCA56FC9B0977C3DDB70FB4B9B")
    public ConnectionPoolTimeoutException(String message) {
        super(message);
    }
}

