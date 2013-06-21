package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidRuntimeException;

public class BadParcelableException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.335 -0400", hash_original_method = "C5F204DF0C7D13038C37380E12FE2000", hash_generated_method = "213039E111EB27F24B54E4260B7A51CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BadParcelableException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.335 -0400", hash_original_method = "9DC5C45DC709D8D31247431851AD50BB", hash_generated_method = "EC008B932521B7B307AB965EAC5DA676")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BadParcelableException(Exception cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

