package org.apache.http.client.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public class HttpClientParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.988 -0400", hash_original_method = "C1A6271AA6801B961C8CB360166C77E0", hash_generated_method = "3ABEB5187B9BC90F9E9381CD590B61B4")
    private  HttpClientParams() {
        super();
        // ---------- Original Method ----------
    }

    
        public static boolean isRedirecting(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (ClientPNames.HANDLE_REDIRECTS, true);
    }

    
        public static void setRedirecting(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (ClientPNames.HANDLE_REDIRECTS, value);
    }

    
        public static boolean isAuthenticating(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (ClientPNames.HANDLE_AUTHENTICATION, true);
    }

    
        public static void setAuthenticating(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (ClientPNames.HANDLE_AUTHENTICATION, value);
    }

    
        public static String getCookiePolicy(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String cookiePolicy = (String)
            params.getParameter(ClientPNames.COOKIE_POLICY);
        if (cookiePolicy == null) {
            return CookiePolicy.BEST_MATCH;
        }
        return cookiePolicy;
    }

    
        public static void setCookiePolicy(final HttpParams params, final String cookiePolicy) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setParameter(ClientPNames.COOKIE_POLICY, cookiePolicy);
    }

    
}

