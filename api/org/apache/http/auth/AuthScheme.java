package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HttpRequest;

public interface AuthScheme {

    
    void processChallenge(final Header header) throws MalformedChallengeException;
    
    
    String getSchemeName();

    
    String getParameter(final String name);

    
    String getRealm();
    
    
    boolean isConnectionBased();    
    
    
    boolean isComplete();    

    
    Header authenticate(Credentials credentials, HttpRequest request) 
            throws AuthenticationException;
    
}
