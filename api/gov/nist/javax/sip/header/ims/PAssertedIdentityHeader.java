package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;

public interface PAssertedIdentityHeader extends HeaderAddress, Header {

    
    public final static String NAME = "P-Asserted-Identity";

}
