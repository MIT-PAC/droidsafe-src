package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class DigestScheme extends RFC2617Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.262 -0400", hash_original_field = "D9A22D7A8178D5B42A8750123CBFE5B1", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.272 -0400", hash_original_field = "5A3BD9AE5985674B6AD54F2E435C5DAA", hash_generated_field = "3842BF6B6403917837D5616C0B4C3C6A")

    private int qopVariant = QOP_MISSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.272 -0400", hash_original_field = "9DBA9637E8635A4D912075CD6EA55530", hash_generated_field = "A436BD0723F1A8DF0FBA775815BA03FC")

    private String cnonce;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.272 -0400", hash_original_method = "7496779349A4F9577FBBD3B727B27A4A", hash_generated_method = "6FBC30D8DE91AA1878BE3E5080514294")
    public  DigestScheme() {
        super();
        this.complete = false;
        // ---------- Original Method ----------
        //this.complete = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.286 -0400", hash_original_method = "F883A5EB3B1E4D14BCFB97B586287C83", hash_generated_method = "03D8A1D15DAB1347265708D18FD36805")
    @Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        {
            boolean varB518C50C24DA45919BC97DD2331266CA_1312720256 = (getParameter("realm") == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("missing realm in challange");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var00FABE96FECB9100DDCB41444DF53139_1828211070 = (getParameter("nonce") == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("missing nonce in challange");
            } //End block
        } //End collapsed parenthetic
        boolean unsupportedQop;
        unsupportedQop = false;
        String qop;
        qop = getParameter("qop");
        {
            StringTokenizer tok;
            tok = new StringTokenizer(qop,",");
            {
                boolean var5A30417AAEC95B980B8C63A0D4458269_1332419181 = (tok.hasMoreTokens());
                {
                    String variant;
                    variant = tok.nextToken().trim();
                    {
                        boolean var1C7F26E4E08EA2C75E4C8C422886B96D_1666697536 = (variant.equals("auth"));
                        {
                            qopVariant = QOP_AUTH;
                        } //End block
                        {
                            boolean varC2465AE7835FF3137D782DCD667573FC_1419511654 = (variant.equals("auth-int"));
                            {
                                qopVariant = QOP_AUTH_INT;
                            } //End block
                            {
                                unsupportedQop = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("None of the qop methods is supported");
        } //End block
        this.cnonce = null;
        this.complete = true;
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.287 -0400", hash_original_method = "F17D438485F30D6AF41BADA0EDB398DD", hash_generated_method = "FD94B492A1C1B3B3FE0FF9D5993A9A89")
    public boolean isComplete() {
        String s;
        s = getParameter("stale");
        {
            boolean varB983BC005A6E66731B2A7EAFC25F1B76_1627812240 = ("true".equalsIgnoreCase(s));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115390273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115390273;
        // ---------- Original Method ----------
        //String s = getParameter("stale");
        //if ("true".equalsIgnoreCase(s)) {
            //return false;
        //} else {
            //return this.complete;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.287 -0400", hash_original_method = "590EDC4C396D176AA70267B4181524CE", hash_generated_method = "5463853241A369306170534DC0F9458C")
    public String getSchemeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1595216893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1595216893 = "digest";
        varB4EAC82CA7396A68D541C85D26508E83_1595216893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1595216893;
        // ---------- Original Method ----------
        //return "digest";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.287 -0400", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "B52E08C9A1B0ADB7ECC9471B74703472")
    public boolean isConnectionBased() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616112074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616112074;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.288 -0400", hash_original_method = "53EAC8543BC193A49B7CF7E715181435", hash_generated_method = "EB309994B9A291AEB8E3F9FECBF79D95")
    public void overrideParamter(final String name, final String value) {
        getParameters().put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //getParameters().put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.288 -0400", hash_original_method = "9DF20B77158B98071C5FA39937248DA7", hash_generated_method = "BA0607B4D6545551296135B41C5C7C7B")
    private String getCnonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_230945877 = null; //Variable for return #1
        {
            this.cnonce = createCnonce();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_230945877 = this.cnonce;
        varB4EAC82CA7396A68D541C85D26508E83_230945877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230945877;
        // ---------- Original Method ----------
        //if (this.cnonce == null) {
            //this.cnonce = createCnonce();
        //}
        //return this.cnonce;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.289 -0400", hash_original_method = "DE78FD59B9BB87751F59177A2F51AB0F", hash_generated_method = "D6B563CD97E4502763F8C29C648C7C1F")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        Header varB4EAC82CA7396A68D541C85D26508E83_249245609 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Credentials may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        getParameters().put("methodname", request.getRequestLine().getMethod());
        getParameters().put("uri", request.getRequestLine().getUri());
        String charset;
        charset = getParameter("charset");
        {
            charset = AuthParams.getCredentialCharset(request.getParams());
            getParameters().put("charset", charset);
        } //End block
        String digest;
        digest = createDigest(credentials);
        varB4EAC82CA7396A68D541C85D26508E83_249245609 = createDigestHeader(credentials, digest);
        addTaint(credentials.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_249245609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_249245609;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.309 -0400", hash_original_method = "EC5C003DA4A6F1C86FB6170174AAC10C", hash_generated_method = "9DAC22603BC8764290FE91A7FA87CC23")
    private String createDigest(final Credentials credentials) throws AuthenticationException {
        String varB4EAC82CA7396A68D541C85D26508E83_2016754958 = null; //Variable for return #1
        String uri;
        uri = getParameter("uri");
        String realm;
        realm = getParameter("realm");
        String nonce;
        nonce = getParameter("nonce");
        String method;
        method = getParameter("methodname");
        String algorithm;
        algorithm = getParameter("algorithm");
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("URI may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Realm may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Nonce may not be null");
        } //End block
        {
            algorithm = "MD5";
        } //End block
        String charset;
        charset = getParameter("charset");
        {
            charset = "ISO-8859-1";
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AuthenticationException(
                "Unsupported qop in HTTP Digest authentication");
        } //End block
        MessageDigest md5Helper;
        md5Helper = createMessageDigest("MD5");
        String uname;
        uname = credentials.getUserPrincipal().getName();
        String pwd;
        pwd = credentials.getPassword();
        StringBuilder tmp;
        tmp = new StringBuilder(uname.length() + realm.length() + pwd.length() + 2);
        tmp.append(uname);
        tmp.append(':');
        tmp.append(realm);
        tmp.append(':');
        tmp.append(pwd);
        String a1;
        a1 = tmp.toString();
        {
            boolean var9A323FE2D4093DE847DBC2C61427986A_1297891362 = (algorithm.equalsIgnoreCase("MD5-sess"));
            {
                String cnonce;
                cnonce = getCnonce();
                String tmp2;
                tmp2 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
                StringBuilder tmp3;
                tmp3 = new StringBuilder(tmp2.length() + nonce.length() + cnonce.length() + 2);
                tmp3.append(tmp2);
                tmp3.append(':');
                tmp3.append(nonce);
                tmp3.append(':');
                tmp3.append(cnonce);
                a1 = tmp3.toString();
            } //End block
            {
                boolean var93593B6D05D8F0C556A656FE5696494F_1893773500 = (!algorithm.equalsIgnoreCase("MD5"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new AuthenticationException("Unhandled algorithm " + algorithm + " requested");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        String md5a1;
        md5a1 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
        String a2;
        a2 = null;
        {
            a2 = method + ':' + uri;
        } //End block
        String md5a2;
        md5a2 = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(a2)));
        String serverDigestValue;
        {
            StringBuilder tmp2;
            tmp2 = new StringBuilder(md5a1.length() + nonce.length() + md5a2.length());
            tmp2.append(md5a1);
            tmp2.append(':');
            tmp2.append(nonce);
            tmp2.append(':');
            tmp2.append(md5a2);
            serverDigestValue = tmp2.toString();
        } //End block
        {
            String qopOption;
            qopOption = getQopVariantString();
            String cnonce;
            cnonce = getCnonce();
            StringBuilder tmp2;
            tmp2 = new StringBuilder(md5a1.length() + nonce.length()
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
        String serverDigest;
        serverDigest = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(serverDigestValue)));
        varB4EAC82CA7396A68D541C85D26508E83_2016754958 = serverDigest;
        addTaint(credentials.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2016754958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016754958;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.323 -0400", hash_original_method = "C034852EE12EEF6A2A977B845769FACB", hash_generated_method = "86A4E9EAB611DE48AA74C921B90D05FE")
    private Header createDigestHeader(
            final Credentials credentials, 
            final String digest) throws AuthenticationException {
        Header varB4EAC82CA7396A68D541C85D26508E83_1100870636 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(128);
        {
            boolean var0D47185A0D32DD28D63E82CE34A14458_1893725561 = (isProxy());
            {
                buffer.append(AUTH.PROXY_AUTH_RESP);
            } //End block
            {
                buffer.append(AUTH.WWW_AUTH_RESP);
            } //End block
        } //End collapsed parenthetic
        buffer.append(": Digest ");
        String uri;
        uri = getParameter("uri");
        String realm;
        realm = getParameter("realm");
        String nonce;
        nonce = getParameter("nonce");
        String opaque;
        opaque = getParameter("opaque");
        String response;
        response = digest;
        String algorithm;
        algorithm = getParameter("algorithm");
        String uname;
        uname = credentials.getUserPrincipal().getName();
        List<BasicNameValuePair> params;
        params = new ArrayList<BasicNameValuePair>(20);
        params.add(new BasicNameValuePair("username", uname));
        params.add(new BasicNameValuePair("realm", realm));
        params.add(new BasicNameValuePair("nonce", nonce));
        params.add(new BasicNameValuePair("uri", uri));
        params.add(new BasicNameValuePair("response", response));
        {
            params.add(new BasicNameValuePair("qop", getQopVariantString()));
            params.add(new BasicNameValuePair("nc", NC));
            params.add(new BasicNameValuePair("cnonce", getCnonce()));
        } //End block
        {
            params.add(new BasicNameValuePair("algorithm", algorithm));
        } //End block
        {
            params.add(new BasicNameValuePair("opaque", opaque));
        } //End block
        {
            int i;
            i = 0;
            boolean var41B38B8299B0C96B0545ADBE0A9274EC_274422872 = (i < params.size());
            {
                BasicNameValuePair param;
                param = params.get(i);
                {
                    buffer.append(", ");
                } //End block
                boolean noQuotes;
                noQuotes = "nc".equals(param.getName()) ||
                               "qop".equals(param.getName());
                BasicHeaderValueFormatter.DEFAULT
                .formatNameValuePair(buffer, param, !noQuotes);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1100870636 = new BufferedHeader(buffer);
        addTaint(credentials.getTaint());
        addTaint(digest.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1100870636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1100870636;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.324 -0400", hash_original_method = "4B7F5D1CEF78CAAD9B937EECFEA67886", hash_generated_method = "D79602FCC752A8E192DC068F5F7D6535")
    private String getQopVariantString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1802508693 = null; //Variable for return #1
        String qopOption;
        {
            qopOption = "auth-int";
        } //End block
        {
            qopOption = "auth";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1802508693 = qopOption;
        varB4EAC82CA7396A68D541C85D26508E83_1802508693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802508693;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.325 -0400", hash_original_field = "F7D8830866BD67517862140230F751E2", hash_generated_field = "0E7EAD0EC9D2D7DC5686BAF9F7144B6E")

    private static char[] HEXADECIMAL = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
        'e', 'f'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.325 -0400", hash_original_field = "ADA7972328A77782718F3684A00C1F3B", hash_generated_field = "B5B223D455EE12850C2F1374AB5DE1F9")

    private static String NC = "00000001";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.325 -0400", hash_original_field = "DF808FC1E99F7D3929CA338656EC3B51", hash_generated_field = "9E766AA0744B349E1FD1CB2ACFC2B1A8")

    private static int QOP_MISSING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.325 -0400", hash_original_field = "501256FDC0D3D79D30693D098788AA70", hash_generated_field = "FC2A708812DA060ED0124C934BEDA1EB")

    private static int QOP_AUTH_INT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.325 -0400", hash_original_field = "C4759F1A948E06530AA939B8020E3333", hash_generated_field = "89105F532E8F55C53CD42B5F9770FF4A")

    private static int QOP_AUTH = 2;
}

