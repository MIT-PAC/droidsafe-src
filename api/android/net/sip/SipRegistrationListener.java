package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SipRegistrationListener {
    
    void onRegistering(String localProfileUri);

    
    void onRegistrationDone(String localProfileUri, long expiryTime);

    
    void onRegistrationFailed(String localProfileUri, int errorCode,
            String errorMessage);
}
