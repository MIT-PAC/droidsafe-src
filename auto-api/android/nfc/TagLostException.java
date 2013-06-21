package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class TagLostException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.101 -0400", hash_original_method = "CBC103EF7AC32AEF91409A49527DDCFB", hash_generated_method = "25C1E25DA00F6A263E31CB53D6E1A15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TagLostException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.101 -0400", hash_original_method = "239642EC7BB7F7E7C0FD631CE1F9537C", hash_generated_method = "E9E8261FF8EE3B22210614915332D646")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TagLostException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

