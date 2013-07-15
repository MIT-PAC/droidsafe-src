package gov.nist.javax.sip.clientauthutils;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import java.util.Collection;
import javax.sip.ClientTransaction;
import javax.sip.InvalidArgumentException;
import javax.sip.SipException;
import javax.sip.SipProvider;
import javax.sip.header.AuthorizationHeader;
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
