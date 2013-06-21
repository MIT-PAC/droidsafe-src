package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProtocolException extends java.io.IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.056 -0400", hash_original_method = "F33E95B361A636BB80AA643BEE16494D", hash_generated_method = "E9DEBF640D79AE700FB76DD1B00C9C48")
    @DSModeled(DSC.SAFE)
    public ProtocolException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.056 -0400", hash_original_method = "8A7B1748C796BD03C7089BCC55139778", hash_generated_method = "FDB27FA132DCCF46189E79B8C07AF49F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProtocolException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.057 -0400", hash_original_method = "8A280093AAE5F90F3CD44950672A326E", hash_generated_method = "1531CBC71609F13FF8648F2A698DB293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProtocolException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -6098449442062388080L;
}

