package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.268 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.268 -0400", hash_original_method = "18D614B059705CD511AA931F33F39470", hash_generated_method = "54C850D3041D3B5C1C4E415558AD142B")
    public  RequestTargetAuthentication() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.269 -0400", hash_original_method = "08A305A51186E2C844540B93FF6C198C", hash_generated_method = "0C7965DB9A28E04CB5DB7BEF1543507F")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1709589183 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1709589183.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1709589183;
        } //End block
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_7896963 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_7896963.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_7896963;
        } //End block
    if(request.containsHeader(AUTH.WWW_AUTH_RESP))        
        {
            return;
        } //End block
        AuthState authState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
    if(authState == null)        
        {
            return;
        } //End block
        AuthScheme authScheme = authState.getAuthScheme();
    if(authScheme == null)        
        {
            return;
        } //End block
        Credentials creds = authState.getCredentials();
    if(creds == null)        
        {
            this.log.debug("User credentials not available");
            return;
        } //End block
    if(authState.getAuthScope() != null || !authScheme.isConnectionBased())        
        {
            try 
            {
                request.addHeader(authScheme.authenticate(creds, request));
            } //End block
            catch (AuthenticationException ex)
            {
    if(this.log.isErrorEnabled())                
                {
                    this.log.error("Authentication error: " + ex.getMessage());
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

