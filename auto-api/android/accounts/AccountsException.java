package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AccountsException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.497 -0400", hash_original_method = "99F952DCE8BA4518D0E18051C88ACAE6", hash_generated_method = "0AB72CE026EED9BAA38D74A54C2A0C16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountsException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.498 -0400", hash_original_method = "BE6623EBDA21E425CA18A18688AD132F", hash_generated_method = "16E95D6D4F7924D59C27316EAF1246F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountsException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.499 -0400", hash_original_method = "0930C541FB340F31959DB9765F7013EF", hash_generated_method = "53A1441425925A05C734E3FD59740DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountsException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.499 -0400", hash_original_method = "E58C6CF199CBA33C60361DD431731963", hash_generated_method = "9EF681FB9172AACEA783028C55F13ADC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountsException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

