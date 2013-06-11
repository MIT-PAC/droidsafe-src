package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InterruptedIOException;

public class SocketTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -8846654841826352300L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "4A11638BF238EC4AAC97B2692C051A84", hash_generated_method = "62F9ADFF8EFD597CFEF6955C42C07C23")
    @DSModeled(DSC.SAFE)
    public SocketTimeoutException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "09713AE8E462C0BAD085649F546AAF7D", hash_generated_method = "104AFDE50C9E502A92F2F81A8B6CB466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "154D3A6011E860B522250E3541FB283D", hash_generated_method = "AE8471161BC017B53B7036AA7C3B8811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(Throwable cause) {
        super(null, cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "A2F64A06EC646B0B6CC4F19E5E317D3C", hash_generated_method = "16D55208E57C8872A7045854DD22DD91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


