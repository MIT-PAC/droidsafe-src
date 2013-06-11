package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IllegalArgumentException extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.015 -0400", hash_original_method = "BA7A8F41F569FABF17AACC9F2A0F75BC", hash_generated_method = "9BABC65BBB58711E59C28C997D234FA2")
    @DSModeled(DSC.SAFE)
    public IllegalArgumentException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.020 -0400", hash_original_method = "D7D337F40643B35AC799AE8640B0B8F6", hash_generated_method = "FFB0101465A9E73FCC853EE43E801289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.024 -0400", hash_original_method = "7E098EA3EF50B45CC4772F0CD835FBB7", hash_generated_method = "E83DB99068DAC723BB8CB34FE30C2DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.037 -0400", hash_original_method = "F1590E7EC4D7642CCEBCDC7875206A8D", hash_generated_method = "C6580CD8066784D2E23E7AFD0B3BBFC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalArgumentException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


