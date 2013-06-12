package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NoSuchProviderException extends GeneralSecurityException {
    private static final long serialVersionUID = 8488111756688534474L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "3C5B15FD24DC972B9113D489948D5082", hash_generated_method = "136791280B492D12AC71EEBC8A83A0FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchProviderException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.613 -0400", hash_original_method = "1FDB64EF55F9EB878F5C396A65C339B8", hash_generated_method = "8A7288F126B45316F23701B5EB775DE7")
    @DSModeled(DSC.SAFE)
    public NoSuchProviderException() {
        // ---------- Original Method ----------
    }

    
}


