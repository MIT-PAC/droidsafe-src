package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public interface PCalledPartyIDHeader extends HeaderAddress, Parameters, Header {

    
    public final static String NAME = "P-Called-Party-ID";

}
