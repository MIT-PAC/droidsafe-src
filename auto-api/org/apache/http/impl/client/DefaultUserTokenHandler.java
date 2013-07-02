package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

public class DefaultUserTokenHandler implements UserTokenHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.268 -0400", hash_original_method = "55806A67FE4596FA71F9FF04E560BE1C", hash_generated_method = "55806A67FE4596FA71F9FF04E560BE1C")
    public DefaultUserTokenHandler ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.272 -0400", hash_original_method = "C085E1B104B611601D851A47FC5A6C7D", hash_generated_method = "EA987F566B0C4BB5200CA12C69736EB5")
    public Object getUserToken(final HttpContext context) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1161344180 = null; 
        Principal userPrincipal = null;
        AuthState targetAuthState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
        {
            userPrincipal = getAuthPrincipal(targetAuthState);
            {
                AuthState proxyAuthState = (AuthState) context.getAttribute(
                        ClientContext.PROXY_AUTH_STATE);
                userPrincipal = getAuthPrincipal(proxyAuthState);
            } 
        } 
        {
            ManagedClientConnection conn = (ManagedClientConnection) context.getAttribute(
                    ExecutionContext.HTTP_CONNECTION);
            {
                boolean var00AF467373E67E3980C8A55D3501BD16_1019272460 = (conn.isOpen());
                {
                    SSLSession sslsession = conn.getSSLSession();
                    {
                        userPrincipal = sslsession.getLocalPrincipal();
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1161344180 = userPrincipal;
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1161344180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1161344180;
        
        
    }

    
    private static Principal getAuthPrincipal(final AuthState authState) {
        AuthScheme scheme = authState.getAuthScheme();
        if (scheme != null && scheme.isComplete() && scheme.isConnectionBased()) {
            Credentials creds = authState.getCredentials();
            if (creds != null) {
                return creds.getUserPrincipal(); 
            }
        }
        return null;
    }

    
}

