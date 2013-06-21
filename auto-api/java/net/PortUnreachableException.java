package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PortUnreachableException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.055 -0400", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "833DA25EB598A13A50D06C4855FB8EF4")
    @DSModeled(DSC.SAFE)
    public PortUnreachableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.055 -0400", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "29441FF868CEBC51C5290ABB0DA29D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PortUnreachableException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.055 -0400", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "7BA4D2BC3A5474679CC2C1EBCC764787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 8462541992376507323L;
}

