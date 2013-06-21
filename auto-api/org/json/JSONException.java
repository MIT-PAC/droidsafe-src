package org.json;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JSONException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.146 -0400", hash_original_method = "D7D56E71DBC1CB75BB9A8A89BF06234E", hash_generated_method = "6BC09A961E316DE276908656061E6799")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JSONException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

