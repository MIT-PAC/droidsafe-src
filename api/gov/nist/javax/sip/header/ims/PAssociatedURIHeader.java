package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;
import javax.sip.address.URI;

public interface PAssociatedURIHeader
    extends HeaderAddress, Parameters, Header
{

    
    public final static String NAME = "P-Associated-URI";


    
    public void setAssociatedURI(URI associatedURI) throws NullPointerException;

    
    public URI getAssociatedURI();

    
    




}
