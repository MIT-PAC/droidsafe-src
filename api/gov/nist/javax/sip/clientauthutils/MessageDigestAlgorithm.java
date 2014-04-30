package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.StackLogger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestAlgorithm {
    /**
     * Calculates an http authentication response in accordance with rfc2617.
     * <p>
     * 
     * @param algorithm a string indicating a pair of algorithms (MD5 (default), or MD5-sess) used
     *        to produce the digest and a checksum.
     * @param hashUserNameRealmPasswd MD5 hash of (username:realm:password)
     * @param nonce_value A server-specified data string provided in the challenge.
     * @param cnonce_value an optional client-chosen value whose purpose is to foil chosen
     *        plaintext attacks.
     * @param method the SIP method of the request being challenged.
     * @param digest_uri_value the value of the "uri" directive on the Authorization header in the
     *        request.
     * @param entity_body the entity-body
     * @param qop_value Indicates what "quality of protection" the client has applied to the
     *        message.
     * @param nc_value the hexadecimal count of the number of requests (including the current
     *        request) that the client has sent with the nonce value in this request.
     * @return a digest response as defined in rfc2617
     * @throws NullPointerException in case of incorrectly null parameters.
     */
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.919 -0500", hash_original_method = "0859014C9C2A58304C2260E63DE25724", hash_generated_method = "B26144A06FDD5921E083B96E0109D1EF")
    
static String calculateResponse(String algorithm, String hashUserNameRealmPasswd,
            String nonce_value, String nc_value, String cnonce_value,
            String method, String digest_uri_value, String entity_body, String qop_value,
            StackLogger stackLogger)  {
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("trying to authenticate using : " + algorithm + ", "+
                    hashUserNameRealmPasswd + ", " + nonce_value + ", "
                    + nc_value + ", " + cnonce_value + ", " + method + ", " + digest_uri_value
                    + ", " + entity_body + ", " + qop_value);
        }
        
        if (hashUserNameRealmPasswd == null || method == null
                || digest_uri_value == null || nonce_value == null)
            throw new NullPointerException(
                    "Null parameter to MessageDigestAlgorithm.calculateResponse()");

        // The following follows closely the algorithm for generating a response
        // digest as specified by rfc2617
        
        if (cnonce_value == null || cnonce_value.length() == 0)
                throw new NullPointerException(
                        "cnonce_value may not be absent for MD5-Sess algorithm.");
     
        String A2 = null;
        if (qop_value == null || qop_value.trim().length() == 0
                || qop_value.trim().equalsIgnoreCase("auth")) {
            A2 = method + ":" + digest_uri_value;
        } else {
            if (entity_body == null)
                entity_body = "";
            A2 = method + ":" + digest_uri_value + ":" + H(entity_body);
        }

        String request_digest = null;

        if (cnonce_value != null && qop_value != null && nc_value != null
                && (qop_value.equalsIgnoreCase("auth") || qop_value.equalsIgnoreCase("auth-int")))

        {
            request_digest = KD(hashUserNameRealmPasswd, nonce_value + ":" + nc_value + ":" + cnonce_value + ":"
                    + qop_value + ":" + H(A2));

        } else {
            request_digest = KD(hashUserNameRealmPasswd, nonce_value + ":" + H(A2));
        }

        return request_digest;
        
    }

    /**
     * Calculates an http authentication response in accordance with rfc2617.
     * <p>
     * 
     * @param algorithm a string indicating a pair of algorithms (MD5 (default), or MD5-sess) used
     *        to produce the digest and a checksum.
     * @param username_value username_value (see rfc2617)
     * @param realm_value A string that has been displayed to the user in order to determine the
     *        context of the username and password to use.
     * @param passwd the password to encode in the challenge response.
     * @param nonce_value A server-specified data string provided in the challenge.
     * @param cnonce_value an optional client-chosen value whose purpose is to foil chosen
     *        plaintext attacks.
     * @param method the SIP method of the request being challenged.
     * @param digest_uri_value the value of the "uri" directive on the Authorization header in the
     *        request.
     * @param entity_body the entity-body
     * @param qop_value Indicates what "quality of protection" the client has applied to the
     *        message.
     * @param nc_value the hexadecimal count of the number of requests (including the current
     *        request) that the client has sent with the nonce value in this request.
     * @return a digest response as defined in rfc2617
     * @throws NullPointerException in case of incorrectly null parameters.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.923 -0500", hash_original_method = "07C0079BF2F96BA7A92F94B983D4C2AC", hash_generated_method = "F80200D97F01813E3D660C511F1F4EE3")
    
static String calculateResponse(String algorithm, String username_value, String realm_value,
            String passwd, String nonce_value, String nc_value, String cnonce_value,
            String method, String digest_uri_value, String entity_body, String qop_value,
            StackLogger stackLogger) {
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("trying to authenticate using : " + algorithm + ", "
                    + username_value + ", " + realm_value + ", "
                    + (passwd != null && passwd.trim().length() > 0) + ", " + nonce_value + ", "
                    + nc_value + ", " + cnonce_value + ", " + method + ", " + digest_uri_value
                    + ", " + entity_body + ", " + qop_value);
        }

        if (username_value == null || realm_value == null || passwd == null || method == null
                || digest_uri_value == null || nonce_value == null)
            throw new NullPointerException(
                    "Null parameter to MessageDigestAlgorithm.calculateResponse()");

        // The following follows closely the algorithm for generating a response
        // digest as specified by rfc2617
        String A1 = null;

        if (algorithm == null || algorithm.trim().length() == 0
                || algorithm.trim().equalsIgnoreCase("MD5")) {
            A1 = username_value + ":" + realm_value + ":" + passwd;
        } else {
            if (cnonce_value == null || cnonce_value.length() == 0)
                throw new NullPointerException(
                        "cnonce_value may not be absent for MD5-Sess algorithm.");

            A1 = H(username_value + ":" + realm_value + ":" + passwd) + ":" + nonce_value + ":"
                    + cnonce_value;
        }

        String A2 = null;
        if (qop_value == null || qop_value.trim().length() == 0
                || qop_value.trim().equalsIgnoreCase("auth")) {
            A2 = method + ":" + digest_uri_value;
        } else {
            if (entity_body == null)
                entity_body = "";
            A2 = method + ":" + digest_uri_value + ":" + H(entity_body);
        }

        String request_digest = null;

        if (cnonce_value != null && qop_value != null && nc_value != null
                && (qop_value.equalsIgnoreCase("auth") || qop_value.equalsIgnoreCase("auth-int")))

        {
            request_digest = KD(H(A1), nonce_value + ":" + nc_value + ":" + cnonce_value + ":"
                    + qop_value + ":" + H(A2));

        } else {
            request_digest = KD(H(A1), nonce_value + ":" + H(A2));
        }

        return request_digest;
    }

    /**
     * Defined in rfc 2617 as H(data) = MD5(data);
     * 
     * @param data data
     * @return MD5(data)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.927 -0500", hash_original_method = "7B8469B0AAC5ED28F7A0B3958D69BFB4", hash_generated_method = "73B92C22D9B5CF4BE324DB60001EE529")
    
private static String H(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            return toHexString(digest.digest(data.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            // shouldn't happen
            throw new RuntimeException("Failed to instantiate an MD5 algorithm", ex);
        }
    }

    /**
     * Defined in rfc 2617 as KD(secret, data) = H(concat(secret, ":", data))
     * 
     * @param data data
     * @param secret secret
     * @return H(concat(secret, ":", data));
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.930 -0500", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "DF9A814AAF225F544A6AC46306B744BC")
    
private static String KD(String secret, String data) {
        return H(secret + ":" + data);
    }

    /**
     * Converts b[] to hex string.
     * 
     * @param b the bte array to convert
     * @return a Hex representation of b.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.936 -0500", hash_original_method = "CAF32B6D436555758214A0AC3F1F5894", hash_generated_method = "6C81B083B68686955D287B63805BA3F2")
    
private static String toHexString(byte b[]) {
        int pos = 0;
        char[] c = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            c[pos++] = toHex[(b[i] >> 4) & 0x0F];
            c[pos++] = toHex[b[i] & 0x0f];
        }
        return new String(c);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:40.933 -0500", hash_original_field = "8D139981331595450D79D39F36281B87", hash_generated_field = "5B94293AD88E841972DD6EAC13087224")

    // messenger (its author is Olivier Deruelle). Thanks for making it public!
    /**
     * to hex converter
     */
    private static final char[] toHex = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.562 -0400", hash_original_method = "867FE15D3C49C82AA29712975204D9D1", hash_generated_method = "867FE15D3C49C82AA29712975204D9D1")
    public MessageDigestAlgorithm ()
    {
        //Synthesized constructor
    }
}

