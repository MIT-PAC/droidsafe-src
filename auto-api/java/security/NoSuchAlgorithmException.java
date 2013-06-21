package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchAlgorithmException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.397 -0400", hash_original_method = "8378123FC231FFDF9C6899E890D8DBB0", hash_generated_method = "4D8EBA77D27F04B90E660C0E6CE28B98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.398 -0400", hash_original_method = "BDAEA1DD03CDDD29A73CAE9E450C10A2", hash_generated_method = "6779E68168EEB1D0C958B92A65CCA975")
    @DSModeled(DSC.SAFE)
    public NoSuchAlgorithmException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.398 -0400", hash_original_method = "738326F937D05503D0FB4C9FA84CE359", hash_generated_method = "D08CE7E16B17147AC96D5CDB10ADA25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.398 -0400", hash_original_method = "24E352B1812045F462874BBBC93C9102", hash_generated_method = "7485136E24AA8D642E1BDDF4BB3EDD9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchAlgorithmException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7443947487218346562L;
}

