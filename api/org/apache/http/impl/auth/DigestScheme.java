package org.apache.http.impl.auth;

// Droidsafe Imports
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DigestScheme extends RFC2617Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_field = "D9A22D7A8178D5B42A8750123CBFE5B1", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_field = "5A3BD9AE5985674B6AD54F2E435C5DAA", hash_generated_field = "3842BF6B6403917837D5616C0B4C3C6A")

    private int qopVariant = QOP_MISSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_field = "9DBA9637E8635A4D912075CD6EA55530", hash_generated_field = "A436BD0723F1A8DF0FBA775815BA03FC")

    private String cnonce;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_method = "7496779349A4F9577FBBD3B727B27A4A", hash_generated_method = "6FBC30D8DE91AA1878BE3E5080514294")
    public  DigestScheme() {
        super();
        this.complete = false;
        // ---------- Original Method ----------
        //this.complete = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_method = "F883A5EB3B1E4D14BCFB97B586287C83", hash_generated_method = "2172A43399EE14D5A388F8CB089F40AF")
    @Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        addTaint(header.getTaint());
        super.processChallenge(header);
        if(getParameter("realm") == null)        
        {
            MalformedChallengeException varDB9F351E01FD944462FE759A7FD69175_375313988 = new MalformedChallengeException("missing realm in challange");
            varDB9F351E01FD944462FE759A7FD69175_375313988.addTaint(taint);
            throw varDB9F351E01FD944462FE759A7FD69175_375313988;
        } //End block
        if(getParameter("nonce") == null)        
        {
            MalformedChallengeException var24548F8FCE1E51E0D86A4CB9908BB0FE_1633103341 = new MalformedChallengeException("missing nonce in challange");
            var24548F8FCE1E51E0D86A4CB9908BB0FE_1633103341.addTaint(taint);
            throw var24548F8FCE1E51E0D86A4CB9908BB0FE_1633103341;
        } //End block
        boolean unsupportedQop = false;
        String qop = getParameter("qop");
        if(qop != null)        
        {
            StringTokenizer tok = new StringTokenizer(qop,",");
            while
(tok.hasMoreTokens())            
            {
                String variant = tok.nextToken().trim();
                if(variant.equals("auth"))                
                {
                    qopVariant = QOP_AUTH;
                    break;
                } //End block
                else
                if(variant.equals("auth-int"))                
                {
                    qopVariant = QOP_AUTH_INT;
                } //End block
                else
                {
                    unsupportedQop = true;
                } //End block
            } //End block
        } //End block
        if(unsupportedQop && (qopVariant == QOP_MISSING))        
        {
            MalformedChallengeException varADA3461E891D272AFDF0F9DDF557BF82_640086981 = new MalformedChallengeException("None of the qop methods is supported");
            varADA3461E891D272AFDF0F9DDF557BF82_640086981.addTaint(taint);
            throw varADA3461E891D272AFDF0F9DDF557BF82_640086981;
        } //End block
        this.cnonce = null;
        this.complete = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.447 -0400", hash_original_method = "F17D438485F30D6AF41BADA0EDB398DD", hash_generated_method = "9D94492A610C3F39D36CD4B7519721DB")
    public boolean isComplete() {
        String s = getParameter("stale");
        if("true".equalsIgnoreCase(s))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1335823411 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287567437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_287567437;
        } //End block
        else
        {
            boolean varF04431E2940FB2099EE63A9B8E626BFD_1271565638 = (this.complete);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24497712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_24497712;
        } //End block
        // ---------- Original Method ----------
        //String s = getParameter("stale");
        //if ("true".equalsIgnoreCase(s)) {
            //return false;
        //} else {
            //return this.complete;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.448 -0400", hash_original_method = "590EDC4C396D176AA70267B4181524CE", hash_generated_method = "AD646C7D54EBD65355180769A6D29978")
    public String getSchemeName() {
String varFD1934E0BA3A06FC5A424DB3DDD067C8_1414291662 =         "digest";
        varFD1934E0BA3A06FC5A424DB3DDD067C8_1414291662.addTaint(taint);
        return varFD1934E0BA3A06FC5A424DB3DDD067C8_1414291662;
        // ---------- Original Method ----------
        //return "digest";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.448 -0400", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "8DE46514DA1C76B771A78B9FAC5CED66")
    public boolean isConnectionBased() {
        boolean var68934A3E9455FA72420237EB05902327_196055254 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047827547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047827547;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.448 -0400", hash_original_method = "53EAC8543BC193A49B7CF7E715181435", hash_generated_method = "656A2C68903F8EA8CC9B6DAE29816304")
    public void overrideParamter(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        getParameters().put(name, value);
        // ---------- Original Method ----------
        //getParameters().put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.448 -0400", hash_original_method = "9DF20B77158B98071C5FA39937248DA7", hash_generated_method = "A164DA1D8E604CABAA181CEBF83CD76A")
    private String getCnonce() {
        if(this.cnonce == null)        
        {
            this.cnonce = createCnonce();
        } //End block
String var641122BA5A01547C98FD9B09A0C087EB_2084681273 =         this.cnonce;
        var641122BA5A01547C98FD9B09A0C087EB_2084681273.addTaint(taint);
        return var641122BA5A01547C98FD9B09A0C087EB_2084681273;
        // ---------- Original Method ----------
        //if (this.cnonce == null) {
            //this.cnonce = createCnonce();
        //}
        //return this.cnonce;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.448 -0400", hash_original_method = "DE78FD59B9BB87751F59177A2F51AB0F", hash_generated_method = "42703EF4E3516579E8D7DCD9B50D88AA")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        addTaint(request.getTaint());
        addTaint(credentials.getTaint());
        if(credentials == null)        
        {
            IllegalArgumentException varD8A19DCE85FA03BB6CE5F603E7A4C74C_1014843165 = new IllegalArgumentException("Credentials may not be null");
            varD8A19DCE85FA03BB6CE5F603E7A4C74C_1014843165.addTaint(taint);
            throw varD8A19DCE85FA03BB6CE5F603E7A4C74C_1014843165;
        } //End block
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_472522969 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_472522969.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_472522969;
        } //End block
        getParameters().put("methodname", request.getRequestLine().getMethod());
        getParameters().put("uri", request.getRequestLine().getUri());
        String charset = getParameter("charset");
        if(charset == null)        
        {
            charset = AuthParams.getCredentialCharset(request.getParams());
            getParameters().put("charset", charset);
        } //End block
        String digest = createDigest(credentials);
Header varD9B43F6A543FACB6477B447D4483CEAE_1132556101 =         createDigestHeader(credentials, digest);
        varD9B43F6A543FACB6477B447D4483CEAE_1132556101.addTaint(taint);
        return varD9B43F6A543FACB6477B447D4483CEAE_1132556101;
        // ---------- Original Method ----------
        //if (credentials == null) {
            //throw new IllegalArgumentException("Credentials may not be null");
        //}
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //getParameters().put("methodname", request.getRequestLine().getMethod());
        //getParameters().put("uri", request.getRequestLine().getUri());
        //String charset = getParameter("charset");
        //if (charset == null) {
            //charset = AuthParams.getCredentialCharset(request.getParams());
            //getParameters().put("charset", charset);
        //}
        //String digest = createDigest(credentials);
        //return createDigestHeader(credentials, digest);
    }

    
    private static MessageDigest createMessageDigest(
            final String digAlg) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(digAlg);
        } catch (Exception e) {
            throw new UnsupportedDigestAlgorithmException(
              "Unsupported algorithm in HTTP Digest authentication: "
               + digAlg);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.449 -0400", hash_original_method = "EC5C003DA4A6F1C86FB6170174AAC10C", hash_generated_method = "E4CDC88CB8F82B1AF07597119BDFEE1D")
    private String createDigest(final Credentials credentials) throws AuthenticationException {
        addTaint(credentials.getTaint());
        String uri = getParameter("uri");
        String realm = getParameter("realm");
        String nonce = getParameter("nonce");
        String method = getParameter("methodname");
        String algorithm = getParameter("algorithm");
        if(uri == null)        
        {
            IllegalStateException var44C226DC35115FAC1DD8A0E2202552B7_845400319 = new IllegalStateException("URI may not be null");
            var44C226DC35115FAC1DD8A0E2202552B7_845400319.addTaint(taint);
            throw var44C226DC35115FAC1DD8A0E2202552B7_845400319;
        } //End block
        if(realm == null)        
        {
            IllegalStateException varA4256DB9F28612ADED7993BB41D5C1F8_2071328136 = new IllegalStateException("Realm may not be null");
            varA4256DB9F28612ADED7993BB41D5C1F8_2071328136.addTaint(taint);
            throw varA4256DB9F28612ADED7993BB41D5C1F8_2071328136;
        } //End block
        if(nonce == null)        
        {
            IllegalStateException varD89F411325FFFE9DFCF6D29025748491_92205364 = new IllegalStateException("Nonce may not be null");
            varD89F411325FFFE9DFCF6D29025748491_92205364.addTaint(taint);
            throw varD89F411325FFFE9DFCF6D29025748491_92205364;
        } //End block
        if(algorithm == null)        
        {
            algorithm = "MD5";
        } //End block
        String charset = getParameter("charset");
        if(charset == null)        
        {
            charset = "ISO-8859-1";
        } //End block
        if(qopVariant == QOP_AUTH_INT)        
        {
            AuthenticationException var81C6CF9B2FE38D17B908C08BFD171A05_783898845 = new AuthenticationException(
                "Unsupported qop in HTTP Digest authentication");
            var81C6CF9B2FE38D17B908C08BFD171A05_783898845.addTaint(taint);
            throw var81C6CF9B2FE38D17B908C08BFD171A05_783898845;
        } //End block
        MessageDigest md5Helper = createMessageDigest("MD5");
        String uname = credentials.getUserPrincipal().getName();
        String pwd = credentials.getPassword();
        StringBuilder tmp = new StringBuilder(uname.length() + realm.length() + pwd.length() + 2);
        tmp.append(uname);
        tmp.append(':');
        tmp.append(realm);
        tmp.append(':');
        tmp.append(pwd);
        String a1 = tmp.toString();
        if(algorithm.equalsIgnoreCase("MD5-sess"))        
        {
            String cnonce = getCnonce();
            String tmp2 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
            StringBuilder tmp3 = new StringBuilder(tmp2.length() + nonce.length() + cnonce.length() + 2);
            tmp3.append(tmp2);
            tmp3.append(':');
            tmp3.append(nonce);
            tmp3.append(':');
            tmp3.append(cnonce);
            a1 = tmp3.toString();
        } //End block
        else
        if(!algorithm.equalsIgnoreCase("MD5"))        
        {
            AuthenticationException varD46EBEA2E5DEF60C27D825E06C7BA317_1953822203 = new AuthenticationException("Unhandled algorithm " + algorithm + " requested");
            varD46EBEA2E5DEF60C27D825E06C7BA317_1953822203.addTaint(taint);
            throw varD46EBEA2E5DEF60C27D825E06C7BA317_1953822203;
        } //End block
        String md5a1 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
        String a2 = null;
        if(qopVariant == QOP_AUTH_INT)        
        {
        } //End block
        else
        {
            a2 = method + ':' + uri;
        } //End block
        String md5a2 = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(a2)));
        String serverDigestValue;
        if(qopVariant == QOP_MISSING)        
        {
            StringBuilder tmp2 = new StringBuilder(md5a1.length() + nonce.length() + md5a2.length());
            tmp2.append(md5a1);
            tmp2.append(':');
            tmp2.append(nonce);
            tmp2.append(':');
            tmp2.append(md5a2);
            serverDigestValue = tmp2.toString();
        } //End block
        else
        {
            String qopOption = getQopVariantString();
            String cnonce = getCnonce();
            StringBuilder tmp2 = new StringBuilder(md5a1.length() + nonce.length()
                + NC.length() + cnonce.length() + qopOption.length() + md5a2.length() + 5);
            tmp2.append(md5a1);
            tmp2.append(':');
            tmp2.append(nonce);
            tmp2.append(':');
            tmp2.append(NC);
            tmp2.append(':');
            tmp2.append(cnonce);
            tmp2.append(':');
            tmp2.append(qopOption);
            tmp2.append(':');
            tmp2.append(md5a2);
            serverDigestValue = tmp2.toString();
        } //End block
        String serverDigest = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(serverDigestValue)));
String var2EC6C72AFD08A9E52823FFE883A36622_214640521 =         serverDigest;
        var2EC6C72AFD08A9E52823FFE883A36622_214640521.addTaint(taint);
        return var2EC6C72AFD08A9E52823FFE883A36622_214640521;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.450 -0400", hash_original_method = "C034852EE12EEF6A2A977B845769FACB", hash_generated_method = "A2C436A6DF8DCA9366374CD9D9A4C956")
    private Header createDigestHeader(
            final Credentials credentials, 
            final String digest) throws AuthenticationException {
        addTaint(digest.getTaint());
        addTaint(credentials.getTaint());
        CharArrayBuffer buffer = new CharArrayBuffer(128);
        if(isProxy())        
        {
            buffer.append(AUTH.PROXY_AUTH_RESP);
        } //End block
        else
        {
            buffer.append(AUTH.WWW_AUTH_RESP);
        } //End block
        buffer.append(": Digest ");
        String uri = getParameter("uri");
        String realm = getParameter("realm");
        String nonce = getParameter("nonce");
        String opaque = getParameter("opaque");
        String response = digest;
        String algorithm = getParameter("algorithm");
        String uname = credentials.getUserPrincipal().getName();
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(20);
        params.add(new BasicNameValuePair("username", uname));
        params.add(new BasicNameValuePair("realm", realm));
        params.add(new BasicNameValuePair("nonce", nonce));
        params.add(new BasicNameValuePair("uri", uri));
        params.add(new BasicNameValuePair("response", response));
        if(qopVariant != QOP_MISSING)        
        {
            params.add(new BasicNameValuePair("qop", getQopVariantString()));
            params.add(new BasicNameValuePair("nc", NC));
            params.add(new BasicNameValuePair("cnonce", getCnonce()));
        } //End block
        if(algorithm != null)        
        {
            params.add(new BasicNameValuePair("algorithm", algorithm));
        } //End block
        if(opaque != null)        
        {
            params.add(new BasicNameValuePair("opaque", opaque));
        } //End block
for(int i = 0;i < params.size();i++)
        {
            BasicNameValuePair param = params.get(i);
            if(i > 0)            
            {
                buffer.append(", ");
            } //End block
            boolean noQuotes = "nc".equals(param.getName()) ||
                               "qop".equals(param.getName());
            BasicHeaderValueFormatter.DEFAULT
                .formatNameValuePair(buffer, param, !noQuotes);
        } //End block
Header varA538F19AF489509DED0A3819B3004747_1672079264 =         new BufferedHeader(buffer);
        varA538F19AF489509DED0A3819B3004747_1672079264.addTaint(taint);
        return varA538F19AF489509DED0A3819B3004747_1672079264;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.450 -0400", hash_original_method = "4B7F5D1CEF78CAAD9B937EECFEA67886", hash_generated_method = "E984C935B3A33A2414CB78D57A342B79")
    private String getQopVariantString() {
        String qopOption;
        if(qopVariant == QOP_AUTH_INT)        
        {
            qopOption = "auth-int";
        } //End block
        else
        {
            qopOption = "auth";
        } //End block
String varA9B2AEB85CC9079FF2659ECC6AA29225_437063021 =         qopOption;
        varA9B2AEB85CC9079FF2659ECC6AA29225_437063021.addTaint(taint);
        return varA9B2AEB85CC9079FF2659ECC6AA29225_437063021;
        // ---------- Original Method ----------
        //String qopOption;
        //if (qopVariant == QOP_AUTH_INT) {
            //qopOption = "auth-int";   
        //} else {
            //qopOption = "auth";
        //}
        //return qopOption;
    }

    
    private static String encode(byte[] binaryData) {
        if (binaryData.length != 16) {
            return null;
        }
        char[] buffer = new char[32];
        for (int i = 0; i < 16; i++) {
            int low = (binaryData[i] & 0x0f);
            int high = ((binaryData[i] & 0xf0) >> 4);
            buffer[i * 2] = HEXADECIMAL[high];
            buffer[(i * 2) + 1] = HEXADECIMAL[low];
        }
        return new String(buffer);
    }

    
    public static String createCnonce() {
        String cnonce;
        MessageDigest md5Helper = createMessageDigest("MD5");
        cnonce = Long.toString(System.currentTimeMillis());
        cnonce = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(cnonce)));
        return cnonce;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.465 -0400", hash_original_field = "F7D8830866BD67517862140230F751E2", hash_generated_field = "6935DD423E05BC188EBDC4FC4F36C352")

    private static final char[] HEXADECIMAL = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
        'e', 'f'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.465 -0400", hash_original_field = "ADA7972328A77782718F3684A00C1F3B", hash_generated_field = "2C31BDE6F9C6C99349800C2C54D624CA")

    private static final String NC = "00000001";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.465 -0400", hash_original_field = "DF808FC1E99F7D3929CA338656EC3B51", hash_generated_field = "86CCA515EBD2620AA29A1DCED5FA7E9D")

    private static final int QOP_MISSING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.465 -0400", hash_original_field = "501256FDC0D3D79D30693D098788AA70", hash_generated_field = "33AF0500E5DAF5053FCBA26E621CF903")

    private static final int QOP_AUTH_INT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.465 -0400", hash_original_field = "C4759F1A948E06530AA939B8020E3333", hash_generated_field = "D822DF3F18281C8743CDFDE58903C2E0")

    private static final int QOP_AUTH = 2;
}

