package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class SSLPeerUnverifiedException extends SSLException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.968 -0500", hash_original_field = "1840497BCAECF28F3D720133E446144B", hash_generated_field = "529865C8061FB502ADFD15F514107B36")


    private static final long serialVersionUID = -8919512675000600547L;

    /**
     * Creates a new {@code SSLPeerUnverifiedException} with the specified
     * message.
     *
     * @param reason
     *            the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:28.969 -0500", hash_original_method = "198A20ABB6370047567C4951E56F9C8C", hash_generated_method = "CCF7AE9607782F82A6787E37239F092B")
    public SSLPeerUnverifiedException(String reason) {
        super(reason);
    }
}

