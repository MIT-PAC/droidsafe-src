package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class NoSuchPaddingException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.990 -0400", hash_original_method = "CC6456B5182239A839E31575FEF026A1", hash_generated_method = "92190AC96AFF03CF49AD01C54424BE0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchPaddingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.990 -0400", hash_original_method = "5F9DD48C6EA25CAA15AA1C916D0EC0F1", hash_generated_method = "B8D5082D9F33AC5995CD41DEC14F9A50")
    @DSModeled(DSC.SAFE)
    public NoSuchPaddingException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4572885201200175466L;
}

