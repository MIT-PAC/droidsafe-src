package org.apache.http.impl.auth;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.381 -0400", hash_original_field = "D9A22D7A8178D5B42A8750123CBFE5B1", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "34C51F903ABE689F4DFB975D927E1D44", hash_generated_method = "5ADEF4710B7BD7D06C1D20BCC3325A54")
    public  BasicScheme() {
        super();
        this.complete = false;
        // ---------- Original Method ----------
        //this.complete = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "456652B0A19A82DBC909302CFB2200F1", hash_generated_method = "58F30D81F84C497272B6F6967FAF47B1")
    public String getSchemeName() {
String varC223609D18BB55F930AA94C44D8E4264_73867107 =         "basic";
        varC223609D18BB55F930AA94C44D8E4264_73867107.addTaint(taint);
        return varC223609D18BB55F930AA94C44D8E4264_73867107;
        // ---------- Original Method ----------
        //return "basic";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "B3A99E56E7F7C8BB825E320F08AA1BAE", hash_generated_method = "C6FBF167D63BA030CF528752EDABD27D")
    @Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        addTaint(header.getTaint());
        super.processChallenge(header);
        this.complete = true;
        // ---------- Original Method ----------
        //super.processChallenge(header);
        //this.complete = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "2000A91F89DD442E06AD762821BFEEA3", hash_generated_method = "18F1A8BD172E46C64624E3CDA1D94633")
    public boolean isComplete() {
        boolean varF04431E2940FB2099EE63A9B8E626BFD_1203833680 = (this.complete);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466470716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466470716;
        // ---------- Original Method ----------
        //return this.complete;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "D2BA69CC86467B881BE3D5E0A9B16E0B")
    public boolean isConnectionBased() {
        boolean var68934A3E9455FA72420237EB05902327_1125714158 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588659518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588659518;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.382 -0400", hash_original_method = "29881E2E3CE612A2D14B025CB6CBAAB9", hash_generated_method = "47B9C54A077BF15ED05D440763F84CF1")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        addTaint(request.getTaint());
        addTaint(credentials.getTaint());
        if(credentials == null)        
        {
            IllegalArgumentException varD8A19DCE85FA03BB6CE5F603E7A4C74C_2139743302 = new IllegalArgumentException("Credentials may not be null");
            varD8A19DCE85FA03BB6CE5F603E7A4C74C_2139743302.addTaint(taint);
            throw varD8A19DCE85FA03BB6CE5F603E7A4C74C_2139743302;
        } //End block
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1692899330 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1692899330.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1692899330;
        } //End block
        String charset = AuthParams.getCredentialCharset(request.getParams());
Header var8AEE839CAE1B1C47635E3A116D25EFDD_220060510 =         authenticate(credentials, charset, isProxy());
        var8AEE839CAE1B1C47635E3A116D25EFDD_220060510.addTaint(taint);
        return var8AEE839CAE1B1C47635E3A116D25EFDD_220060510;
        // ---------- Original Method ----------
        //if (credentials == null) {
            //throw new IllegalArgumentException("Credentials may not be null");
        //}
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //String charset = AuthParams.getCredentialCharset(request.getParams());
        //return authenticate(credentials, charset, isProxy());
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

