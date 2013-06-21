package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface UserCredentialHash {
    
    
    public String getUserName();
    
    
    
    public String getSipDomain();
    
    
    
    public String getHashUserDomainPassword();

}
