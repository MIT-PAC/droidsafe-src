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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.448 -0400", hash_original_method = "BD7E104E787325F5148E620FC3E1650F", hash_generated_method = "0FC8DC66C07D5E2A8088944BE78BACE6")
    public  DefaultProxyAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.449 -0400", hash_original_method = "439F158CF98654180ED92C5B006474BF", hash_generated_method = "99A5E78DC0C05D1C601F8A7497B40355")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_718531628 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_718531628.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_718531628;
        } //End block
        int status = response.getStatusLine().getStatusCode();
        boolean varAB545FE0EA61D3DF50FB7328D017AAAE_423339636 = (status == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766245924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766245924;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.450 -0400", hash_original_method = "006E8B6035C28019E03EDCD408C6B1B0", hash_generated_method = "662FA2539D43AA71BF438D79409FADD0")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_283419326 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_283419326.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_283419326;
        } //End block
        Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
Map<String, Header> var2509FA3DA12E052D3E9CF21AA5DB9796_1984429479 =         parseChallenges(headers);
        var2509FA3DA12E052D3E9CF21AA5DB9796_1984429479.addTaint(taint);
        return var2509FA3DA12E052D3E9CF21AA5DB9796_1984429479;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //Header[] headers = response.getHeaders(AUTH.PROXY_AUTH);
        //return parseChallenges(headers);
    }

    
}

