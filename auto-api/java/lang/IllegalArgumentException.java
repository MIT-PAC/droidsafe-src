package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalArgumentException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.739 -0400", hash_original_method = "BA7A8F41F569FABF17AACC9F2A0F75BC", hash_generated_method = "34523DED6BE79748F7A3DCC271CA5F6C")
    @DSModeled(DSC.SAFE)
    public IllegalArgumentException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.739 -0400", hash_original_method = "D7D337F40643B35AC799AE8640B0B8F6", hash_generated_method = "95D873915D9CE7E34B97BE0D88C3B7F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.739 -0400", hash_original_method = "7E098EA3EF50B45CC4772F0CD835FBB7", hash_generated_method = "5913AEEB7D133A781744EFD68D362430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.739 -0400", hash_original_method = "F1590E7EC4D7642CCEBCDC7875206A8D", hash_generated_method = "B68CC5A1D751C857F70A01DC2924E0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5365630128856068164L;
}

