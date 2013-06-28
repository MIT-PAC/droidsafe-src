package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AccountsException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.459 -0400", hash_original_method = "99F952DCE8BA4518D0E18051C88ACAE6", hash_generated_method = "0AB72CE026EED9BAA38D74A54C2A0C16")
    public  AccountsException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.460 -0400", hash_original_method = "BE6623EBDA21E425CA18A18688AD132F", hash_generated_method = "AF40F58066E5BF8AB044BD65C8147500")
    public  AccountsException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.461 -0400", hash_original_method = "0930C541FB340F31959DB9765F7013EF", hash_generated_method = "EEB6C383F67CB2AA8CAEE0439DB02CF8")
    public  AccountsException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.462 -0400", hash_original_method = "E58C6CF199CBA33C60361DD431731963", hash_generated_method = "5279A5DC5218AFF2452572A73CA515DA")
    public  AccountsException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

