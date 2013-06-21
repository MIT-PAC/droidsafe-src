package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class GeneralSecurityException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.318 -0400", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "2E49416D3938BA603FAB424CFBBFD649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.318 -0400", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "CD715F134D1B1C417AE32EC947980940")
    @DSModeled(DSC.SAFE)
    public GeneralSecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.318 -0400", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "0AB7DFAF9A0D7B6364B22F26DDBCFB37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.319 -0400", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "27EB1DF06C71939527F8DC58EF966ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralSecurityException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 894798122053539237L;
}

