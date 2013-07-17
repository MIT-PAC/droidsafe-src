package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class GeneralSecurityException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.836 -0400", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "3808F422C9EE0B77734A8D8D72E3B4ED")
    public  GeneralSecurityException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.836 -0400", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "CD715F134D1B1C417AE32EC947980940")
    public  GeneralSecurityException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.836 -0400", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "6D1BE60812A6C08FE585F111C97B65D7")
    public  GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.837 -0400", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "20B3DB8B345E6C6818669A454961C1D8")
    public  GeneralSecurityException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.837 -0400", hash_original_field = "4FEB438EE36320242663420945A9E2BD", hash_generated_field = "F3DAE821DA81007CC901C8C9F2AFD853")

    private static final long serialVersionUID = 894798122053539237L;
}

