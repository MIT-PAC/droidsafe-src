package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TooManyHopsException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.290 -0400", hash_original_method = "7059525C7D643548AACC26A1B7FECDC6", hash_generated_method = "AF59B1FD7F0919C215A47EAD9FDD1B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TooManyHopsException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.290 -0400", hash_original_method = "10941AD8E9E3A8951C3E1FF56EF96A49", hash_generated_method = "8632514544416262C1C0BFD86E5F7A46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TooManyHopsException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.290 -0400", hash_original_method = "3567ED48A659002D0FAAA891FC5B218E", hash_generated_method = "0BDEBEC4AD439C1390DBF143284508AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TooManyHopsException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

