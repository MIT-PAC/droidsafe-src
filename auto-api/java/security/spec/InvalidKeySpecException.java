package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class InvalidKeySpecException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.663 -0400", hash_original_method = "DB6EC4555D24FA0B7F53C3D0CF9817D1", hash_generated_method = "B833F765B87996E8430B7DCB5ED58421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeySpecException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.663 -0400", hash_original_method = "62E7948E21963822758AD86C4EE61479", hash_generated_method = "375CBDDC3236D67BD233F634A596B6E0")
    @DSModeled(DSC.SAFE)
    public InvalidKeySpecException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.663 -0400", hash_original_method = "164335802BFF46F4D28D2A0D3E3265D8", hash_generated_method = "3BA053B7D1B6397E2D0DD7264AE049B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeySpecException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.663 -0400", hash_original_method = "64F8C7884589B108D58D14C2DB6A45FC", hash_generated_method = "E505FBC31FBC75A27EEA2B996065BCBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidKeySpecException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3546139293998810778L;
}

