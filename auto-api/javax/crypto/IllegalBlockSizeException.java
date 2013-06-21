package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class IllegalBlockSizeException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.971 -0400", hash_original_method = "861F6F81DB957F4D77B1EC6AAE4C23A3", hash_generated_method = "CBE031AD1E5269D0FC5A649253173617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalBlockSizeException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.971 -0400", hash_original_method = "1121F9F47707C37345E2BF72D04B622E", hash_generated_method = "61CD53D6E952A5BE6116CCCB75B86933")
    @DSModeled(DSC.SAFE)
    public IllegalBlockSizeException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1965144811953540392L;
}

