package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class GeneralSecurityException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.136 -0400", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "3808F422C9EE0B77734A8D8D72E3B4ED")
    public  GeneralSecurityException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.136 -0400", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "CD715F134D1B1C417AE32EC947980940")
    public  GeneralSecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.136 -0400", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "C52D853A11D7D68037934921C3AC743A")
    public  GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.143 -0400", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "20B3DB8B345E6C6818669A454961C1D8")
    public  GeneralSecurityException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.143 -0400", hash_original_field = "4FEB438EE36320242663420945A9E2BD", hash_generated_field = "7E823A3C71F237076DE8F2D19EE9BD5E")

    private static long serialVersionUID = 894798122053539237L;
}

