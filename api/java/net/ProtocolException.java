package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class ProtocolException extends java.io.IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.208 -0500", hash_original_field = "D7E112AA1CFEAD6A476550293895F103", hash_generated_field = "B5FA4CEFFBB595720D8C22950D4B5E92")


    private static final long serialVersionUID = -6098449442062388080L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.209 -0500", hash_original_method = "F33E95B361A636BB80AA643BEE16494D", hash_generated_method = "CA446959492622B0791DCB3A2158101A")
    public ProtocolException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.210 -0500", hash_original_method = "8A7B1748C796BD03C7089BCC55139778", hash_generated_method = "FBCBBA947FA5D3697DF7D9EC2582A303")
    public ProtocolException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.211 -0500", hash_original_method = "8A280093AAE5F90F3CD44950672A326E", hash_generated_method = "4DC12AF268E33FE37E8AC90DCD50580C")
    public ProtocolException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

