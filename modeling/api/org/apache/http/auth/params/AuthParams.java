package org.apache.http.auth.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public final class AuthParams {

    /**
     * Obtains the charset for encoding
     * {@link org.apache.http.auth.Credentials}.
     * If not configured,
     * {@link HTTP#DEFAULT_PROTOCOL_CHARSET HTTP.DEFAULT_PROTOCOL_CHARSET}
     * is used instead.
     * 
     * @return The charset
     *
     * @see AuthPNames#CREDENTIAL_CHARSET
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.227 -0500", hash_original_method = "83E68A1F7212025E177C44461A8681BF", hash_generated_method = "81D4B84D1CADC581B696FD91EF64DC1F")
    
public static String getCredentialCharset(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String charset = (String) params.getParameter
            (AuthPNames.CREDENTIAL_CHARSET);
        //@@@ TODO: inconsistent with JavaDoc in AuthPNames,
        //@@@ TODO: check HTTP_ELEMENT_CHARSET first, or fix JavaDocs
        if (charset == null) {
            charset = HTTP.DEFAULT_PROTOCOL_CHARSET;
        }
        return charset;
    }

    /**
     * Sets the charset to be used when encoding
     * {@link org.apache.http.auth.Credentials}.
     * 
     * @param charset The charset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.229 -0500", hash_original_method = "0A1029E7DE52A3D6B1434265A979992C", hash_generated_method = "898E77E22A3BF38038282A5B97758360")
    
public static void setCredentialCharset(final HttpParams params, final String charset) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setParameter(AuthPNames.CREDENTIAL_CHARSET, charset);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.224 -0500", hash_original_method = "EB9D982BD9B9623A4B896B6B8960ED16", hash_generated_method = "7F4E5802A312C1007D40C42C567D1ADC")
    
private AuthParams() {
        super();
    }
    
}

