package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AccountsException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.061 -0400", hash_original_method = "99F952DCE8BA4518D0E18051C88ACAE6", hash_generated_method = "0AB72CE026EED9BAA38D74A54C2A0C16")
    public  AccountsException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.063 -0400", hash_original_method = "BE6623EBDA21E425CA18A18688AD132F", hash_generated_method = "AF40F58066E5BF8AB044BD65C8147500")
    public  AccountsException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.066 -0400", hash_original_method = "0930C541FB340F31959DB9765F7013EF", hash_generated_method = "A7A5A1B5DAECCF31E7B74C8DE4E0954D")
    public  AccountsException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.069 -0400", hash_original_method = "E58C6CF199CBA33C60361DD431731963", hash_generated_method = "5279A5DC5218AFF2452572A73CA515DA")
    public  AccountsException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

