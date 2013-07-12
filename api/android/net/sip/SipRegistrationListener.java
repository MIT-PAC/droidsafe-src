package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SipRegistrationListener {
    
    void onRegistering(String localProfileUri);

    
    void onRegistrationDone(String localProfileUri, long expiryTime);

    
    void onRegistrationFailed(String localProfileUri, int errorCode,
            String errorMessage);
}
