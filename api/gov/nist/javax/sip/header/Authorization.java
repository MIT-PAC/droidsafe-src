package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;

import javax.sip.header.AuthorizationHeader;






public class Authorization extends gov.nist.javax.sip.header.AuthenticationHeader implements javax.sip.header.AuthorizationHeader, AuthorizationHeaderIms {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.816 -0500", hash_original_field = "194208C15A695D927DC98089A89342AD", hash_generated_field = "F76FF683AEE537F30B650148F7B18ED3")

    private static final long serialVersionUID = -8897770321892281348L;

    /** Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:56.817 -0500", hash_original_method = "390B0B8BBF60F6FD3586C13C265D073D", hash_generated_method = "89B68796C5F72C5B98CAC615B0B36E2C")
    public Authorization() {
        super(AuthorizationHeader.NAME);
    }
}

