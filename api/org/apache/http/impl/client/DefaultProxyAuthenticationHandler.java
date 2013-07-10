package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.132 -0400", hash_original_method = "BD7E104E787325F5148E620FC3E1650F", hash_generated_method = "0FC8DC66C07D5E2A8088944BE78BACE6")
    public  DefaultProxyAuthenticationHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.133 -0400", hash_original_method = "439F158CF98654180ED92C5B006474BF", hash_generated_method = "9F68AD4F9B147F1A50969A2BEFC3BB1A")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } 
        int status = response.getStatusLine().getStatusCode();
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904941336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904941336;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.133 -0400", hash_original_method = "006E8B6035C28019E03EDCD408C6B1B0", hash_generated_method = "2E93F8FE5F4FC73CAE4AD3F352D54719")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        Map<String, Header> varB4EAC82CA7396A68D541C85D26508E83_472498112 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } 
        Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
        varB4EAC82CA7396A68D541C85D26508E83_472498112 = parseChallenges(headers);
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_472498112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_472498112;
        
        
            
        
        
        
    }

    
}

