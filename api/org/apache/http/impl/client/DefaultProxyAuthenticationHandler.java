package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.695 -0400", hash_original_method = "BD7E104E787325F5148E620FC3E1650F", hash_generated_method = "0FC8DC66C07D5E2A8088944BE78BACE6")
    public  DefaultProxyAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.696 -0400", hash_original_method = "439F158CF98654180ED92C5B006474BF", hash_generated_method = "0CD4CB15E608E230EDECD7444E7C3D66")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1868917242 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1868917242.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1868917242;
        } //End block
        int status = response.getStatusLine().getStatusCode();
        boolean varAB545FE0EA61D3DF50FB7328D017AAAE_1567386899 = (status == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200566770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200566770;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.696 -0400", hash_original_method = "006E8B6035C28019E03EDCD408C6B1B0", hash_generated_method = "484717A747D9E6DC4D68BCB6D126089C")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_851966401 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_851966401.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_851966401;
        } //End block
        Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
Map<String, Header> var2509FA3DA12E052D3E9CF21AA5DB9796_490719273 =         parseChallenges(headers);
        var2509FA3DA12E052D3E9CF21AA5DB9796_490719273.addTaint(taint);
        return var2509FA3DA12E052D3E9CF21AA5DB9796_490719273;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
        //return parseChallenges(headers);
    }

    
}

