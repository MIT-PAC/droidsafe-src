package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchProviderException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.399 -0400", hash_original_method = "3C5B15FD24DC972B9113D489948D5082", hash_generated_method = "7C62CC2F2AB9D8C12E84ECDA97DC7458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchProviderException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.399 -0400", hash_original_method = "1FDB64EF55F9EB878F5C396A65C339B8", hash_generated_method = "5A5F1EF7E3BC459EED9DE2EE9A1DDE35")
    @DSModeled(DSC.SAFE)
    public NoSuchProviderException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 8488111756688534474L;
}

