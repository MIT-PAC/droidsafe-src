package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransportNotSupportedException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.264 -0400", hash_original_method = "A9536702FA2FD929BCAA03BE02DE378D", hash_generated_method = "E158EFA88D439F44ECE432CEE5044D3E")
    @DSModeled(DSC.SAFE)
    public TransportNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.265 -0400", hash_original_method = "72633799E19427EF47046C691F2C9C95", hash_generated_method = "E3CEE852217B57F7E5B346E742B37DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransportNotSupportedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.265 -0400", hash_original_method = "F97CF6294699591851DD663A9DDDF701", hash_generated_method = "FC28E9BBD4F4A65B8BBF24E41631CD72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransportNotSupportedException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

