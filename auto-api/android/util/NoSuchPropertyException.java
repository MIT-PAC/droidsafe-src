package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchPropertyException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.296 -0400", hash_original_method = "9FBF5439C2FECDDB526E862ED7B30ADC", hash_generated_method = "F018055734CD0033D5669C5C7B82D24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchPropertyException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

