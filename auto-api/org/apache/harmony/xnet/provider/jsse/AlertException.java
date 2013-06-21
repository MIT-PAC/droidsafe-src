package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class AlertException extends RuntimeException {
    private SSLException reason;
    private byte description;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.514 -0400", hash_original_method = "76164594E21D6CE99D1A0A90A760CF7A", hash_generated_method = "A082F1AB74F85BEAA9C8339610893AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertException(byte description, SSLException reason) {
        super(reason);
        dsTaint.addTaint(reason.dsTaint);
        dsTaint.addTaint(description);
        // ---------- Original Method ----------
        //this.reason = reason;
        //this.description = description;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.515 -0400", hash_original_method = "5B702ECC4BAE0D4CD4DED59A097CDBFC", hash_generated_method = "E8E4842D3E070B2111D357BBAD6E9550")
    @DSModeled(DSC.SAFE)
    protected SSLException getReason() {
        return (SSLException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.515 -0400", hash_original_method = "4016638ED8025AA5C043B11675AF3321", hash_generated_method = "E4EECBF33CDCB19CCBFA7C3F195245E8")
    @DSModeled(DSC.SAFE)
    protected byte getDescriptionCode() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return description;
    }

    
    private static final long serialVersionUID = -4448327177165687581L;
}

