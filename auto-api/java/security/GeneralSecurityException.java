package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class GeneralSecurityException extends Exception {
    private static final long serialVersionUID = 894798122053539237L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.603 -0400", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "9CF89DAEAA22AB864F241148EFB80093")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.604 -0400", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "B1450D43124AA36BAE520C187F8706FB")
    @DSModeled(DSC.SAFE)
    public GeneralSecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.604 -0400", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "36096E00D6C7664B2AE8B26137140A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.604 -0400", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "7D9E445FC7B506FFDFA85C1CC090ED30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


