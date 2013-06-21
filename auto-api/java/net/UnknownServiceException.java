package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class UnknownServiceException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.443 -0400", hash_original_method = "ADBD30E20976E5F84799D2EDCA6E8AB1", hash_generated_method = "9EE874687BEB0AAD14D021865ADF7D88")
    @DSModeled(DSC.SAFE)
    public UnknownServiceException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.444 -0400", hash_original_method = "7690A99261A8975258177F18AE9D9AC2", hash_generated_method = "402B6FBECDBF318FD810FBEB628EE10A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownServiceException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.444 -0400", hash_original_method = "E3B2640B549BA587BAC4EC77E8C4280A", hash_generated_method = "3D5F16C7FEFF74384550ED66495E842F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownServiceException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4169033248853639508L;
}

