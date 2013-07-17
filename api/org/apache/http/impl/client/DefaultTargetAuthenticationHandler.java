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

public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.851 -0400", hash_original_method = "83B142C3BB9A0955DF4A02493E658347", hash_generated_method = "4FACE08269B9BC298D130C2482F30092")
    public  DefaultTargetAuthenticationHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.851 -0400", hash_original_method = "0F8C1618FD9AF6BE64F2E7BA50B72FEE", hash_generated_method = "8AC81A8C42636D4CE642F73F07C84D74")
    public boolean isAuthenticationRequested(
            final HttpResponse response, 
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_662083243 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_662083243.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_662083243;
        } //End block
        int status = response.getStatusLine().getStatusCode();
        boolean varEE4F31572B9D7880CB5311B68444BB37_1134158707 = (status == HttpStatus.SC_UNAUTHORIZED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513380672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513380672;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //int status = response.getStatusLine().getStatusCode();
        //return status == HttpStatus.SC_UNAUTHORIZED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.852 -0400", hash_original_method = "439347D8B5B1C5ED414F3DCFF9000C1C", hash_generated_method = "06CCA2BC6A457B8B8499352F7717891F")
    public Map<String, Header> getChallenges(
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_88708324 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_88708324.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_88708324;
        } //End block
        Header[] headers = response.getHeaders(AUTH.WWW_AUTH);
Map<String, Header> var2509FA3DA12E052D3E9CF21AA5DB9796_793860013 =         parseChallenges(headers);
        var2509FA3DA12E052D3E9CF21AA5DB9796_793860013.addTaint(taint);
        return var2509FA3DA12E052D3E9CF21AA5DB9796_793860013;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //Header[] headers = response.getHeaders(AUTH.WWW_AUTH);
        //return parseChallenges(headers);
    }

    
}

