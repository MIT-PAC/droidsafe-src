package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.ClientTransaction;
import javax.sip.SipException;
import javax.sip.SipProvider;
import javax.sip.message.Request;
import javax.sip.message.Response;

public interface AuthenticationHelper {

    
    public abstract ClientTransaction handleChallenge(Response challenge,
            ClientTransaction challengedTransaction,
            SipProvider transactionCreator, int cacheTime ) throws SipException,
             NullPointerException;

    
    public abstract void setAuthenticationHeaders(Request request) ;

    
    public abstract void removeCachedAuthenticationHeaders(String callId);
}
