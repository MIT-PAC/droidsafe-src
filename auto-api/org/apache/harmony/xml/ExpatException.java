package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class ExpatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.064 -0400", hash_original_method = "0929E937B15E2591C534268B5A2E4F52", hash_generated_method = "6BA1296FB555A14F4F3A0314AB10A50F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpatException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

