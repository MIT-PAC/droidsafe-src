package org.apache.http.client.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;

public class RequestTargetAuthentication implements HttpRequestInterceptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.878 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.878 -0400", hash_original_method = "18D614B059705CD511AA931F33F39470", hash_generated_method = "54C850D3041D3B5C1C4E415558AD142B")
    public  RequestTargetAuthentication() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.879 -0400", hash_original_method = "08A305A51186E2C844540B93FF6C198C", hash_generated_method = "97D4862E093B6DA17271C35A94A91BEC")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } 
        {
            boolean var23577B78091CD3812B9078F41C45BB03_1991528999 = (request.containsHeader(AUTH.WWW_AUTH_RESP));
        } 
        AuthState authState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials creds = authState.getCredentials();
        {
            this.log.debug("User credentials not available");
        } 
        {
            boolean var73CC55FE287FD82949D5517028158444_1229325048 = (authState.getAuthScope() != null || !authScheme.isConnectionBased());
            {
                try 
                {
                    request.addHeader(authScheme.authenticate(creds, request));
                } 
                catch (AuthenticationException ex)
                {
                    {
                        boolean varCC1F3FA71CB16F8E717B30D522A0DAFD_229886065 = (this.log.isErrorEnabled());
                        {
                            this.log.error("Authentication error: " + ex.getMessage());
                        } 
                    } 
                } 
            } 
        } 
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        
        
    }

    
}

