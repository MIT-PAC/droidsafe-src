package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FormatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.807 -0400", hash_original_method = "19906B432E20947B07A71D239CA16EA4", hash_generated_method = "48A5F362D262A9A6FDB97D1CD90A6C9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FormatException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.807 -0400", hash_original_method = "E158CC912978354EA0BE368A340B0E91", hash_generated_method = "11EED666B0ACE253C7FF3456E1445225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FormatException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

