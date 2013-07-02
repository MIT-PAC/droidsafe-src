package org.apache.http.impl.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class BasicScheme extends RFC2617Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.778 -0400", hash_original_field = "D9A22D7A8178D5B42A8750123CBFE5B1", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.778 -0400", hash_original_method = "34C51F903ABE689F4DFB975D927E1D44", hash_generated_method = "5ADEF4710B7BD7D06C1D20BCC3325A54")
    public  BasicScheme() {
        super();
        this.complete = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.779 -0400", hash_original_method = "456652B0A19A82DBC909302CFB2200F1", hash_generated_method = "EFDB29AD9C5D4A9E1818DC99826B363E")
    public String getSchemeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_512928584 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_512928584 = "basic";
        varB4EAC82CA7396A68D541C85D26508E83_512928584.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_512928584;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.779 -0400", hash_original_method = "B3A99E56E7F7C8BB825E320F08AA1BAE", hash_generated_method = "2FCEB54F452373293180EED341394523")
    @Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
        addTaint(header.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.779 -0400", hash_original_method = "2000A91F89DD442E06AD762821BFEEA3", hash_generated_method = "4E9CD7796E7B08FDC1CFC68675D4EF9F")
    public boolean isComplete() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140833588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140833588;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.780 -0400", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "6A7B1DEE023F585B878F92247FC26899")
    public boolean isConnectionBased() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961880810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961880810;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.780 -0400", hash_original_method = "29881E2E3CE612A2D14B025CB6CBAAB9", hash_generated_method = "81562CAA5E69A6478D4DBC6B08F4B326")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        Header varB4EAC82CA7396A68D541C85D26508E83_106641564 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Credentials may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        String charset = AuthParams.getCredentialCharset(request.getParams());
        varB4EAC82CA7396A68D541C85D26508E83_106641564 = authenticate(credentials, charset, isProxy());
        addTaint(credentials.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_106641564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_106641564;
        
        
            
        
        
            
        
        
        
    }

    
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

    
}

