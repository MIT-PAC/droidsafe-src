package android.net.sip;

// Droidsafe Imports

public interface SipRegistrationListener {
    
    void onRegistering(String localProfileUri);

    
    void onRegistrationDone(String localProfileUri, long expiryTime);

    
    void onRegistrationFailed(String localProfileUri, int errorCode,
            String errorMessage);
}
