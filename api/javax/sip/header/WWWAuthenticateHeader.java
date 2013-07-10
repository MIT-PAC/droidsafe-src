package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.URI;

public interface WWWAuthenticateHeader extends AuthorizationHeader {
    String NAME = "WWW-Authenticate";

    
    URI getURI();

    
    void setURI(URI uri);
}
