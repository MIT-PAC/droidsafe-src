package org.apache.http.auth.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public final class AuthParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.677 -0400", hash_original_method = "EB9D982BD9B9623A4B896B6B8960ED16", hash_generated_method = "E97EEB74B9E097B6DD9930287DD2A388")
    private  AuthParams() {
        super();
        // ---------- Original Method ----------
    }

    
    public static String getCredentialCharset(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String charset = (String) params.getParameter
            (AuthPNames.CREDENTIAL_CHARSET);
        if (charset == null) {
            charset = HTTP.DEFAULT_PROTOCOL_CHARSET;
        }
        return charset;
    }

    
    public static void setCredentialCharset(final HttpParams params, final String charset) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setParameter(AuthPNames.CREDENTIAL_CHARSET, charset);
    }

    
}

