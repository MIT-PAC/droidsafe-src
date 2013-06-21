package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProviderException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.509 -0400", hash_original_method = "4F6DF0DF8572865516F19A786749BA2D", hash_generated_method = "690751707B3E631ADDDE56F0FA341734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.509 -0400", hash_original_method = "C6FD128032A25223FCE8DF59B6440EFD", hash_generated_method = "AE2C6FE8FA1DD7754D6AAA9F0ABC68D7")
    @DSModeled(DSC.SAFE)
    public ProviderException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.509 -0400", hash_original_method = "9D8D611DA847D087295A6CFF5F4EEF0C", hash_generated_method = "F340522910FFA5886D99DF1AA5C7F196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.509 -0400", hash_original_method = "39103B62643A614FF10A8AB7735F1560", hash_generated_method = "BCAA26E358D624F984905EA68DCDD9AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5256023526693665674L;
}

