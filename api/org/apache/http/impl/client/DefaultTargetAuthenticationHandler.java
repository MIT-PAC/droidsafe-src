package org.apache.http.impl.client;


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

public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.598 -0400", hash_original_method = "83B142C3BB9A0955DF4A02493E658347", hash_generated_method = "4FACE08269B9BC298D130C2482F30092")
    public  DefaultTargetAuthenticationHandler() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.598 -0400", hash_original_method = "0F8C1618FD9AF6BE64F2E7BA50B72FEE", hash_generated_method = "170A54623AD5F67EBF3D77A0BAE5FE0C")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1725373246 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1725373246.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1725373246;
        } 
        int status = response.getStatusLine().getStatusCode();
        boolean varEE4F31572B9D7880CB5311B68444BB37_1776448396 = (status == HttpStatus.SC_UNAUTHORIZED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485667282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485667282;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.599 -0400", hash_original_method = "439347D8B5B1C5ED414F3DCFF9000C1C", hash_generated_method = "F5841E8C7F158A0B11C6344BAF73723D")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_846393838 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_846393838.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_846393838;
        } 
        Header[] headers = response.getHeaders(AUTH.WWW_AUTH);
Map<String, Header> var2509FA3DA12E052D3E9CF21AA5DB9796_2006956002 =         parseChallenges(headers);
        var2509FA3DA12E052D3E9CF21AA5DB9796_2006956002.addTaint(taint);
        return var2509FA3DA12E052D3E9CF21AA5DB9796_2006956002;
        
        
            
        
        
        
    }

    
}

