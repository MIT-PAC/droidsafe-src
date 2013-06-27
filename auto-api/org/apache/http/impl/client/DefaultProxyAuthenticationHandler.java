package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.378 -0400", hash_original_method = "BD7E104E787325F5148E620FC3E1650F", hash_generated_method = "0FC8DC66C07D5E2A8088944BE78BACE6")
    public  DefaultProxyAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.378 -0400", hash_original_method = "439F158CF98654180ED92C5B006474BF", hash_generated_method = "B01BF08A5047ACCC509246AA6228B7BA")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        int status;
        status = response.getStatusLine().getStatusCode();
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569202048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_569202048;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.379 -0400", hash_original_method = "006E8B6035C28019E03EDCD408C6B1B0", hash_generated_method = "5BCC0E15B738D69F994FCC6900AC9B57")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        Map<String, Header> varB4EAC82CA7396A68D541C85D26508E83_2091522837 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        Header[] headers;
        headers = response.getHeaders(AUTH.PROXY_AUTH);
        varB4EAC82CA7396A68D541C85D26508E83_2091522837 = parseChallenges(headers);
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2091522837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091522837;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
        //return parseChallenges(headers);
    }

    
}

