package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class SocketException extends IOException {
    private static final long serialVersionUID = -5935874303556886934L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.299 -0400", hash_original_method = "6370438F3E8FDAC390DBF5D95BB547E6", hash_generated_method = "A4B6B074495D1434DCB9C409BDB4C921")
    @DSModeled(DSC.SAFE)
    public SocketException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.299 -0400", hash_original_method = "1136B1CF147D460660A0A79DDF1D5C0A", hash_generated_method = "8F0DB0734FB257F6B4DB3E93C55FD5E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.299 -0400", hash_original_method = "001E874571014D08FBFC41C7A23D02C6", hash_generated_method = "7C8F96B85674D6A0FEFF9DD0032302E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.299 -0400", hash_original_method = "1ACC59770DF5E02FD5C6C8AE56F288AE", hash_generated_method = "10F72268B3767BAE34508752C153587C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


