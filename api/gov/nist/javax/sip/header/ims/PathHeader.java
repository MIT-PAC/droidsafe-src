package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public interface PathHeader extends HeaderAddress, Parameters, Header {

    
    public final static String NAME = "Path";

}
