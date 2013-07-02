package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

public interface AuthenticationHandler {

    boolean isAuthenticationRequested(
            HttpResponse response, 
            HttpContext context);
    
    Map<String, Header> getChallenges(
            HttpResponse response, 
            HttpContext context) throws MalformedChallengeException;
    
    AuthScheme selectScheme(
            Map<String, Header> challenges, 
            HttpResponse response, 
            HttpContext context) throws AuthenticationException;
    
}
