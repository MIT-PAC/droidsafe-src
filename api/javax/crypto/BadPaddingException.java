package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;




public class BadPaddingException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.121 -0500", hash_original_field = "9CAAF9A8273F0D296173AD89CD38C75C", hash_generated_field = "AE932C213DC4932CB87AEA34232F7CC8")

    private static final long serialVersionUID = -5315033893984728443L;

    /**
     * Creates a new instance of {@code BadPaddingException} with a message.
     *
     * @param msg
     *            the message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.127 -0500", hash_original_method = "09CEF21DE4AE127050E57B3AC6E4EB54", hash_generated_method = "EDE5C1B892264EC16ECACD2BEC68C77D")
    
public BadPaddingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new instance of {@code BadPaddingException} with no message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.131 -0500", hash_original_method = "93AC86C418E78DB07C3A1E0229C09FBC", hash_generated_method = "594391F64BAE0FBA19219C221CC665EC")
    
public BadPaddingException() {
    }
}

