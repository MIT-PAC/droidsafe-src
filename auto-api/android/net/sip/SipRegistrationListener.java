package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SipRegistrationListener {
    
    void onRegistering(String localProfileUri);

    
    void onRegistrationDone(String localProfileUri, long expiryTime);

    
    void onRegistrationFailed(String localProfileUri, int errorCode,
            String errorMessage);
}
