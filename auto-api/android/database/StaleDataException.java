package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StaleDataException extends java.lang.RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.214 -0400", hash_original_method = "0B77138B0532969AEB67E7DB9731EFEE", hash_generated_method = "CA11876DF9991FF914361FBFA8E0B2B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaleDataException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.214 -0400", hash_original_method = "4D539F55BE24816442AFE115AFCF4654", hash_generated_method = "D352B24AA1FF0D6213078C97903AA6D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StaleDataException(String description) {
        super(description);
        dsTaint.addTaint(description);
        // ---------- Original Method ----------
    }

    
}

