package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import javax.sip.header.*;

public class Authorization extends gov.nist.javax.sip.header.AuthenticationHeader implements javax.sip.header.AuthorizationHeader, AuthorizationHeaderIms {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.050 -0400", hash_original_method = "390B0B8BBF60F6FD3586C13C265D073D", hash_generated_method = "AD8D70E330952B9379E225330ADC6836")
    public  Authorization() {
        super(AuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.050 -0400", hash_original_field = "4C9A4D291CA45295D5BEF72361F9212A", hash_generated_field = "F76FF683AEE537F30B650148F7B18ED3")

    private static final long serialVersionUID = -8897770321892281348L;
}

