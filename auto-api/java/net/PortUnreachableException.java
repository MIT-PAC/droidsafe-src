package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PortUnreachableException extends SocketException {
    private static final long serialVersionUID = 8462541992376507323L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.262 -0400", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "5FB67310C76A5D36FF53D4D067617131")
    @DSModeled(DSC.SAFE)
    public PortUnreachableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.262 -0400", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "CC022E2E9170FECD002B057052D060FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PortUnreachableException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.262 -0400", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "AF3809BCD133BDF412506D027481DA82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


