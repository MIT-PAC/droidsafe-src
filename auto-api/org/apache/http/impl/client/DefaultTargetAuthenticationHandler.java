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

public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.431 -0400", hash_original_method = "83B142C3BB9A0955DF4A02493E658347", hash_generated_method = "4FACE08269B9BC298D130C2482F30092")
    public  DefaultTargetAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.432 -0400", hash_original_method = "0F8C1618FD9AF6BE64F2E7BA50B72FEE", hash_generated_method = "1D105963B96C5DA91234EF4BD438F4ED")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134282799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134282799;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status == HttpStatus.SC_UNAUTHORIZED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.440 -0400", hash_original_method = "439347D8B5B1C5ED414F3DCFF9000C1C", hash_generated_method = "881B52A7371F33ED7FA6DE46682AB96A")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        Map<String, Header> varB4EAC82CA7396A68D541C85D26508E83_503349712 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        Header[] headers;
        headers = response.getHeaders(AUTH.WWW_AUTH);
        varB4EAC82CA7396A68D541C85D26508E83_503349712 = parseChallenges(headers);
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_503349712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503349712;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //Header[] headers = response.getHeaders(AUTH.WWW_AUTH);
        //return parseChallenges(headers);
    }

    
}

