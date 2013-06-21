package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BindException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.745 -0400", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "C638B86E6197A90D0C5D3DF2A4972BCE")
    @DSModeled(DSC.SAFE)
    public BindException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.745 -0400", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "8354F0507D0A57ED989E9032F8E053AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BindException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.745 -0400", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "1B3CEC5C7B600139A7E6DE2545044A0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5945005768251722951L;
}

