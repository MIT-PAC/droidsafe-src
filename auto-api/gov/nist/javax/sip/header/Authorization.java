package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import javax.sip.header.*;

public class Authorization extends gov.nist.javax.sip.header.AuthenticationHeader implements javax.sip.header.AuthorizationHeader, AuthorizationHeaderIms {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.824 -0400", hash_original_method = "390B0B8BBF60F6FD3586C13C265D073D", hash_generated_method = "AD8D70E330952B9379E225330ADC6836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Authorization() {
        super(AuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8897770321892281348L;
}

