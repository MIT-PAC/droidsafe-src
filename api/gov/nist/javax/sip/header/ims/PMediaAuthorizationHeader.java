package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.Header;

public interface PMediaAuthorizationHeader extends Header
{

    
    public final static String NAME = "P-Media-Authorization";

    
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException;

    
    public String getToken();


}
