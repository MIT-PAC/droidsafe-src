package javax.sip.header;

// Droidsafe Imports
import javax.sip.address.URI;

public interface WWWAuthenticateHeader extends AuthorizationHeader {
    String NAME = "WWW-Authenticate";

    
    URI getURI();

    
    void setURI(URI uri);
}
