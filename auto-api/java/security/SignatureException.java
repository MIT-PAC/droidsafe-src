package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SignatureException extends GeneralSecurityException {
    private static final long serialVersionUID = 7509989324975124438L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.736 -0400", hash_original_method = "1A64E23BD4BC60E25E0621B283BA1364", hash_generated_method = "89FEFCFBD4193E3EC20BBD1C3E604C63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.736 -0400", hash_original_method = "FC81C3C47A9C38543897BA92BDE9ED63", hash_generated_method = "1E4C5D51192B065AB4E353C343EBF5D0")
    @DSModeled(DSC.SAFE)
    public SignatureException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.736 -0400", hash_original_method = "016680A93C61AAA9E83AF67D8C91F93A", hash_generated_method = "1ACE2DDE6FEA00F9C861A9D79DBDA85A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.736 -0400", hash_original_method = "3352DA5C6676595EED2C0C966A19B61C", hash_generated_method = "E735B654540141EC1354B760BEE2897C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


