package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InterruptedIOException;

public class SocketTimeoutException extends InterruptedIOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.139 -0400", hash_original_method = "4A11638BF238EC4AAC97B2692C051A84", hash_generated_method = "AA146E7357A4622B881D9BB8D6E998AE")
    @DSModeled(DSC.SAFE)
    public SocketTimeoutException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.139 -0400", hash_original_method = "09713AE8E462C0BAD085649F546AAF7D", hash_generated_method = "7CB262B0FD33167E0A65C04FAB53BFF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.139 -0400", hash_original_method = "154D3A6011E860B522250E3541FB283D", hash_generated_method = "98F3C04C7DAEBEEE1009B15378F68C4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(Throwable cause) {
        super(null, cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.139 -0400", hash_original_method = "A2F64A06EC646B0B6CC4F19E5E317D3C", hash_generated_method = "03E26552A4004F9DB5EECDD5D933E323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketTimeoutException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8846654841826352300L;
}

