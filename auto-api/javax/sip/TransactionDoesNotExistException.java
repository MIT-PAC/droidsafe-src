package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransactionDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.260 -0400", hash_original_method = "750F8F9B78D69ABAD487E00FF1714036", hash_generated_method = "B97A8DA2301BB8BC36CF55AD5F049642")
    @DSModeled(DSC.SAFE)
    public TransactionDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.260 -0400", hash_original_method = "FEB1A81DE901FC743AFE681804A1F11C", hash_generated_method = "78BE9E891B0156887B2281F69305B28D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionDoesNotExistException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.261 -0400", hash_original_method = "B970C645A776B4A2B1D89F6D22EB1C05", hash_generated_method = "7B959CDBE308D135B190C956627BAC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

