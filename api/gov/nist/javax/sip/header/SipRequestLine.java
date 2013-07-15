package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.address.URI;

public interface SipRequestLine {

    
    public abstract URI getUri();

    
    public abstract String getMethod();

    
    public abstract String getSipVersion();

    
    public abstract void setUri(URI uri);

    
    public abstract void setMethod(String method);

    
    public abstract void setSipVersion(String version);

    
    public abstract String getVersionMajor();

    
    public abstract String getVersionMinor();

}
