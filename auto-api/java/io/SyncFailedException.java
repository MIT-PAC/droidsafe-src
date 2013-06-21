package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SyncFailedException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.349 -0400", hash_original_method = "B401EEC06D6A312F5D3599A2F76A49BA", hash_generated_method = "634F59D701D7ACEB668F82EC295F08DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncFailedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -2353342684412443330L;
}

