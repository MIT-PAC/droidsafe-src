package gov.nist.javax.sip.clientauthutils;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.StackLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestAlgorithm {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.616 -0400", hash_original_method = "867FE15D3C49C82AA29712975204D9D1", hash_generated_method = "867FE15D3C49C82AA29712975204D9D1")
    public MessageDigestAlgorithm ()
    {
        
    }


        static String calculateResponse(String algorithm, String hashUserNameRealmPasswd,
            String nonce_value, String nc_value, String cnonce_value,
            String method, String digest_uri_value, String entity_body, String qop_value,
            StackLogger stackLogger) {
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

    
        private static String H(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return toHexString(digest.digest(data.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Failed to instantiate an MD5 algorithm", ex);
        }
    }

    
        private static String KD(String secret, String data) {
        return H(secret + ":" + data);
    }

    
        private static String toHexString(byte b[]) {
        int pos = 0;
        char[] c = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            c[pos++] = toHex[(b[i] >> 4) & 0x0F];
            c[pos++] = toHex[b[i] & 0x0f];
        }
        return new String(c);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.618 -0400", hash_original_field = "AE6F89DC8E13D1AB97EC10B40F16B520", hash_generated_field = "D08ABC333720B6C25B9902ED84803CDE")

    private static final char[] toHex = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
}

