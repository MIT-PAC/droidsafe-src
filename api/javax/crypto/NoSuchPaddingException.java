package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;




public class NoSuchPaddingException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.245 -0500", hash_original_field = "08967469B6971DB2B1D55A938CD09CE5", hash_generated_field = "F7C5C54BD2F1DBD310D5E8F7775DD1AB")

    private static final long serialVersionUID = -4572885201200175466L;

    /**
     * Creates a new {@code NoSuchPaddingException} with the specified
     * message.
     *
     * @param msg
     *            the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.249 -0500", hash_original_method = "CC6456B5182239A839E31575FEF026A1", hash_generated_method = "831D54D5386D8B66B009396DB2798A74")
    
public NoSuchPaddingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code NoSuchPaddingException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.253 -0500", hash_original_method = "5F9DD48C6EA25CAA15AA1C916D0EC0F1", hash_generated_method = "DA2E5DC365F989A4EF84EC4E539EC826")
    
public NoSuchPaddingException() {
    }
}

