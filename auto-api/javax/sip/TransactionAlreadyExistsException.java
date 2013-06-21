package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransactionAlreadyExistsException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.259 -0400", hash_original_method = "6748172A8FDBE98EBDE794888E886227", hash_generated_method = "03AE0A4D0E3FD942DF397A578BE0B81F")
    @DSModeled(DSC.SAFE)
    public TransactionAlreadyExistsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.259 -0400", hash_original_method = "230B9A8FB8272D6B6901D384356BD5A2", hash_generated_method = "E872B4E307BCB7935E53FDB820203430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionAlreadyExistsException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.259 -0400", hash_original_method = "9199B538C593B6B8FFCCFB817BC4F480", hash_generated_method = "BA78BB21BB0D8BA32B6F681C91044349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

