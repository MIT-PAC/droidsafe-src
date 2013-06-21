package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DataFormatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.686 -0400", hash_original_method = "64C52722D8298AB468E7E3E8999CA51F", hash_generated_method = "3EAAEB4127F03FA62C0948D7293BDD0B")
    @DSModeled(DSC.SAFE)
    public DataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.686 -0400", hash_original_method = "54A194B6E0CA21D574EDE0E22D325A81", hash_generated_method = "48DC24F9FF026E0A6A918F9214AECB86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataFormatException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 2219632870893641452L;
}

