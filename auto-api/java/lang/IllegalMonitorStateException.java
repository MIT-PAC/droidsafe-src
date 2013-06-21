package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalMonitorStateException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.740 -0400", hash_original_method = "A830880207AC191B3684BF337F5E0247", hash_generated_method = "0C4EAA93E01B549DF2002FFF068D6996")
    @DSModeled(DSC.SAFE)
    public IllegalMonitorStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.740 -0400", hash_original_method = "1591087F36D115C0B3CDF3D9C0FC50C3", hash_generated_method = "C184B6D203423BFC85C1387645FA8668")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalMonitorStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3713306369498869069L;
}

