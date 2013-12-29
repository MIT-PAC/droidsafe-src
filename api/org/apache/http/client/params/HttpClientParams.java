package org.apache.http.client.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.params.HttpParams;



public class HttpClientParams {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.121 -0500", hash_original_method = "7F5EC64678F2BF99B5FC6B00C0649726", hash_generated_method = "3A3F0F1B231BB4A7783DE3BE3B1EB0F8")
    public static boolean isRedirecting(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (ClientPNames.HANDLE_REDIRECTS, true); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.122 -0500", hash_original_method = "D25A533CDBBF2DE2854A97D6ED189799", hash_generated_method = "303783B61F9AC70C54D356F35A804883")
    public static void setRedirecting(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (ClientPNames.HANDLE_REDIRECTS, value); 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.122 -0500", hash_original_method = "E99E0AD068BF86729C62F4A08E92A6D0", hash_generated_method = "722391365B5C6A3E5CC0B94E05778015")
    public static boolean isAuthenticating(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (ClientPNames.HANDLE_AUTHENTICATION, true); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.123 -0500", hash_original_method = "4EEACF51057E652FCDB49FD3B08F1869", hash_generated_method = "1A46743B616F189FEFEE3F612AC08F23")
    public static void setAuthenticating(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (ClientPNames.HANDLE_AUTHENTICATION, value); 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.124 -0500", hash_original_method = "779C85BA9BC8F624D4E0DEDE86759022", hash_generated_method = "02DF876C61E723B59DF4DAE0F76A231D")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.126 -0500", hash_original_method = "544E4BCF61ABC6424F17B17EB5E4FA3B", hash_generated_method = "729030AEE3327883720C839166706874")
    public static void setCookiePolicy(final HttpParams params, final String cookiePolicy) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setParameter(ClientPNames.COOKIE_POLICY, cookiePolicy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.120 -0500", hash_original_method = "C1A6271AA6801B961C8CB360166C77E0", hash_generated_method = "15C82D3BA2561F385477CD1643F8D62E")
    private HttpClientParams() {
        super();
    }

    
}

