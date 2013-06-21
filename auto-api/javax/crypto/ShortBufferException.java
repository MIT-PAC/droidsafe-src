package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class ShortBufferException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.992 -0400", hash_original_method = "B367994EA3C91134C8AE078ED740A290", hash_generated_method = "BDA0D976FEF2407015396BA5D8F349C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShortBufferException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.992 -0400", hash_original_method = "05E1544DF68BDE9AA8F5198F627D7727", hash_generated_method = "83333DD006AC3C65758F9A113F150A4A")
    @DSModeled(DSC.SAFE)
    public ShortBufferException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 8427718640832943747L;
}

