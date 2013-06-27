package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.461 -0400", hash_original_method = "55806A67FE4596FA71F9FF04E560BE1C", hash_generated_method = "55806A67FE4596FA71F9FF04E560BE1C")
    public DefaultUserTokenHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.462 -0400", hash_original_method = "C085E1B104B611601D851A47FC5A6C7D", hash_generated_method = "B40C1435189E1E20D93C0CE73260C8B1")
    public Object getUserToken(final HttpContext context) {
        Object varB4EAC82CA7396A68D541C85D26508E83_551272053 = null; //Variable for return #1
        Principal userPrincipal;
        userPrincipal = null;
        AuthState targetAuthState;
        targetAuthState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
        {
            userPrincipal = getAuthPrincipal(targetAuthState);
            {
                AuthState proxyAuthState;
                proxyAuthState = (AuthState) context.getAttribute(
                        ClientContext.PROXY_AUTH_STATE);
                userPrincipal = getAuthPrincipal(proxyAuthState);
            } //End block
        } //End block
        {
            ManagedClientConnection conn;
            conn = (ManagedClientConnection) context.getAttribute(
                    ExecutionContext.HTTP_CONNECTION);
            {
                boolean var00AF467373E67E3980C8A55D3501BD16_1032425944 = (conn.isOpen());
                {
                    SSLSession sslsession;
                    sslsession = conn.getSSLSession();
                    {
                        userPrincipal = sslsession.getLocalPrincipal();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_551272053 = userPrincipal;
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_551272053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_551272053;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

