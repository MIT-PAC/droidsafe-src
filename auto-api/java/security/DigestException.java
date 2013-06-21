package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DigestException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.316 -0400", hash_original_method = "5DAAB61061CBFECD5A1E1A61BC7BAA88", hash_generated_method = "344FA56C7450E29D5A3D858E81FA2B05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DigestException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.316 -0400", hash_original_method = "4BFD0A9812571E805B2B692917954A18", hash_generated_method = "32516E3A03E7277423B9AFF8010A7A86")
    @DSModeled(DSC.SAFE)
    public DigestException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.316 -0400", hash_original_method = "BCC7846DF9BFB7C5F5EA1087695CCF8F", hash_generated_method = "503DAF5C65F39793678037A9515BBB1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DigestException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.316 -0400", hash_original_method = "57079B2A067E95F6018E75F3448CD9E3", hash_generated_method = "8A859D6245FAD2B636346F3F2F3DAA7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DigestException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5821450303093652515L;
}

