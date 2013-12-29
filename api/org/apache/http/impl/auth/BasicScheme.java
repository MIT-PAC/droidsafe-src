package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;






public class BasicScheme extends RFC2617Scheme {
    
    /**
     * Returns a basic <tt>Authorization</tt> header value for the given 
     * {@link Credentials} and charset.
     * 
     * @param credentials The credentials to encode.
     * @param charset The charset to use for encoding the credentials
     * 
     * @return a basic authorization header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.195 -0500", hash_original_method = "89C676068719473CE74FFF06348E4F41", hash_generated_method = "75796DC6F277B176DCAF2177AE57B335")
    public static Header authenticate(
            final Credentials credentials, 
            final String charset, 
            boolean proxy) {
        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null"); 
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset may not be null");
        }

        StringBuilder tmp = new StringBuilder();
        tmp.append(credentials.getUserPrincipal().getName());
        tmp.append(":");
        tmp.append((credentials.getPassword() == null) ? "null" : credentials.getPassword());

        byte[] base64password = Base64.encodeBase64(
                EncodingUtils.getBytes(tmp.toString(), charset));
        
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        if (proxy) {
            buffer.append(AUTH.PROXY_AUTH_RESP);
        } else {
            buffer.append(AUTH.WWW_AUTH_RESP);
        }
        buffer.append(": Basic ");
        buffer.append(base64password, 0, base64password.length);
        
        return new BufferedHeader(buffer);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.189 -0500", hash_original_field = "C51E6506F56B38D2FA99DED8C0973BFD", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    
    /**
     * Default constructor for the basic authetication scheme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.190 -0500", hash_original_method = "34C51F903ABE689F4DFB975D927E1D44", hash_generated_method = "7E698B321E9117B4B56D78F5DF699EBE")
    public BasicScheme() {
        super();
        this.complete = false;
    }

    /**
     * Returns textual designation of the basic authentication scheme.
     * 
     * @return <code>basic</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.191 -0500", hash_original_method = "456652B0A19A82DBC909302CFB2200F1", hash_generated_method = "219E61D29C3B60261ABA492391FC0B7D")
    public String getSchemeName() {
        return "basic";
    }

    /**
     * Processes the Basic challenge.
     *  
     * @param header the challenge header
     * 
     * @throws MalformedChallengeException is thrown if the authentication challenge
     * is malformed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.192 -0500", hash_original_method = "B3A99E56E7F7C8BB825E320F08AA1BAE", hash_generated_method = "E9E81C8510DBE10CC53C82CAA8344CAE")
    @Override
public void processChallenge(
            final Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    /**
     * Tests if the Basic authentication process has been completed.
     * 
     * @return <tt>true</tt> if Basic authorization has been processed,
     *   <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.192 -0500", hash_original_method = "2000A91F89DD442E06AD762821BFEEA3", hash_generated_method = "6580BADA867DF5458EDFF68BF25A56B3")
    public boolean isComplete() {
        return this.complete;
    }

    /**
     * Returns <tt>false</tt>. Basic authentication scheme is request based.
     * 
     * @return <tt>false</tt>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.193 -0500", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "2AFD9511A9C9359DA57C31C6DF79FB99")
    public boolean isConnectionBased() {
        return false;    
    }

    /**
     * Produces basic authorization header for the given set of {@link Credentials}.
     * 
     * @param credentials The set of credentials to be used for athentication
     * @param request The request being authenticated
     * @throws org.apache.http.auth.InvalidCredentialsException if authentication credentials
     *         are not valid or not applicable for this authentication scheme
     * @throws AuthenticationException if authorization string cannot 
     *   be generated due to an authentication failure
     * 
     * @return a basic authorization string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.194 -0500", hash_original_method = "29881E2E3CE612A2D14B025CB6CBAAB9", hash_generated_method = "73189CB0BF0ED0C322E2573686274826")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {

        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        
        String charset = AuthParams.getCredentialCharset(request.getParams());
        return authenticate(credentials, charset, isProxy());
    }

    
}

