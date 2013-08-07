package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Date;

public interface SetCookie extends Cookie {

    void setValue(String value);
    
    
    void setComment(String comment);

    
    void setExpiryDate (Date expiryDate);

    
    void setDomain(String domain);

    
    void setPath(String path);

    
    void setSecure (boolean secure);

    
    void setVersion(int version);

}
