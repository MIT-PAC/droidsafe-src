package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.867 -0400", hash_original_method = "55806A67FE4596FA71F9FF04E560BE1C", hash_generated_method = "55806A67FE4596FA71F9FF04E560BE1C")
    public DefaultUserTokenHandler ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.869 -0400", hash_original_method = "C085E1B104B611601D851A47FC5A6C7D", hash_generated_method = "A0CC5EE5928B1768518C994847505C2C")
    public Object getUserToken(final HttpContext context) {
        addTaint(context.getTaint());
        Principal userPrincipal = null;
        AuthState targetAuthState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
        if(targetAuthState != null)        
        {
            userPrincipal = getAuthPrincipal(targetAuthState);
            if(userPrincipal == null)            
            {
                AuthState proxyAuthState = (AuthState) context.getAttribute(
                        ClientContext.PROXY_AUTH_STATE);
                userPrincipal = getAuthPrincipal(proxyAuthState);
            } //End block
        } //End block
        if(userPrincipal == null)        
        {
            ManagedClientConnection conn = (ManagedClientConnection) context.getAttribute(
                    ExecutionContext.HTTP_CONNECTION);
            if(conn.isOpen())            
            {
                SSLSession sslsession = conn.getSSLSession();
                if(sslsession != null)                
                {
                    userPrincipal = sslsession.getLocalPrincipal();
                } //End block
            } //End block
        } //End block
Object var0CDBC293F5686809A28657B94AD2C0FD_155878320 =         userPrincipal;
        var0CDBC293F5686809A28657B94AD2C0FD_155878320.addTaint(taint);
        return var0CDBC293F5686809A28657B94AD2C0FD_155878320;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
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

