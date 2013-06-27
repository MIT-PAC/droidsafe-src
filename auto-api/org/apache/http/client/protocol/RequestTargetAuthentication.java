package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.033 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.033 -0400", hash_original_method = "18D614B059705CD511AA931F33F39470", hash_generated_method = "54C850D3041D3B5C1C4E415558AD142B")
    public  RequestTargetAuthentication() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.034 -0400", hash_original_method = "08A305A51186E2C844540B93FF6C198C", hash_generated_method = "515A8F5E6B4D378F5BB5B5653CEB26C3")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        {
            boolean var23577B78091CD3812B9078F41C45BB03_1209289719 = (request.containsHeader(AUTH.WWW_AUTH_RESP));
        } //End collapsed parenthetic
        AuthState authState;
        authState = (AuthState) context.getAttribute(
                ClientContext.TARGET_AUTH_STATE);
        AuthScheme authScheme;
        authScheme = authState.getAuthScheme();
        Credentials creds;
        creds = authState.getCredentials();
        {
            this.log.debug("User credentials not available");
        } //End block
        {
            boolean var73CC55FE287FD82949D5517028158444_1493251999 = (authState.getAuthScope() != null || !authScheme.isConnectionBased());
            {
                try 
                {
                    request.addHeader(authScheme.authenticate(creds, request));
                } //End block
                catch (AuthenticationException ex)
                {
                    {
                        boolean varCC1F3FA71CB16F8E717B30D522A0DAFD_34704163 = (this.log.isErrorEnabled());
                        {
                            this.log.error("Authentication error: " + ex.getMessage());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

