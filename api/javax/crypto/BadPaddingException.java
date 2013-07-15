package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.GeneralSecurityException;

public class BadPaddingException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.551 -0400", hash_original_method = "09CEF21DE4AE127050E57B3AC6E4EB54", hash_generated_method = "F7E799E6576C2B1A6A5BFBA4E1F45A42")
    public  BadPaddingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.551 -0400", hash_original_method = "93AC86C418E78DB07C3A1E0229C09FBC", hash_generated_method = "BEC10E384823F5A0EB6660587E005727")
    public  BadPaddingException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.551 -0400", hash_original_field = "2B1C3642820E0C45F89278246615CDDB", hash_generated_field = "AE932C213DC4932CB87AEA34232F7CC8")

    private static final long serialVersionUID = -5315033893984728443L;
}

