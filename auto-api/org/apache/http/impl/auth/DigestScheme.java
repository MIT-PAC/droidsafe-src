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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.843 -0400", hash_original_field = "D9A22D7A8178D5B42A8750123CBFE5B1", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.843 -0400", hash_original_field = "5A3BD9AE5985674B6AD54F2E435C5DAA", hash_generated_field = "3842BF6B6403917837D5616C0B4C3C6A")

    private int qopVariant = QOP_MISSING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.843 -0400", hash_original_field = "9DBA9637E8635A4D912075CD6EA55530", hash_generated_field = "A436BD0723F1A8DF0FBA775815BA03FC")

    private String cnonce;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.844 -0400", hash_original_method = "7496779349A4F9577FBBD3B727B27A4A", hash_generated_method = "6FBC30D8DE91AA1878BE3E5080514294")
    public  DigestScheme() {
        super();
        this.complete = false;
        // ---------- Original Method ----------
        //this.complete = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.844 -0400", hash_original_method = "F883A5EB3B1E4D14BCFB97B586287C83", hash_generated_method = "A0874524153DE4F4187B6AE856951987")
    @Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        {
            boolean varB518C50C24DA45919BC97DD2331266CA_974209835 = (getParameter("realm") == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("missing realm in challange");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var00FABE96FECB9100DDCB41444DF53139_1723768668 = (getParameter("nonce") == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("missing nonce in challange");
            } //End block
        } //End collapsed parenthetic
        boolean unsupportedQop = false;
        String qop = getParameter("qop");
        {
            StringTokenizer tok = new StringTokenizer(qop,",");
            {
                boolean var5A30417AAEC95B980B8C63A0D4458269_750642831 = (tok.hasMoreTokens());
                {
                    String variant = tok.nextToken().trim();
                    {
                        boolean var1C7F26E4E08EA2C75E4C8C422886B96D_850387460 = (variant.equals("auth"));
                        {
                            qopVariant = QOP_AUTH;
                        } //End block
                        {
                            boolean varC2465AE7835FF3137D782DCD667573FC_1802759805 = (variant.equals("auth-int"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.845 -0400", hash_original_method = "F17D438485F30D6AF41BADA0EDB398DD", hash_generated_method = "982DF1A8BB6F7A25BDF36A89186A1DEE")
    public boolean isComplete() {
        String s = getParameter("stale");
        {
            boolean varB983BC005A6E66731B2A7EAFC25F1B76_1055639637 = ("true".equalsIgnoreCase(s));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320182000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320182000;
        // ---------- Original Method ----------
        //String s = getParameter("stale");
        //if ("true".equalsIgnoreCase(s)) {
            //return false;
        //} else {
            //return this.complete;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.845 -0400", hash_original_method = "590EDC4C396D176AA70267B4181524CE", hash_generated_method = "05ABDC6D72DA10CA44F7A1FA82963D10")
    public String getSchemeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2029993028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2029993028 = "digest";
        varB4EAC82CA7396A68D541C85D26508E83_2029993028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029993028;
        // ---------- Original Method ----------
        //return "digest";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.845 -0400", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "1FAF8CB04B8A81BC756B15CC8E9D79EC")
    public boolean isConnectionBased() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666641786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666641786;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.846 -0400", hash_original_method = "53EAC8543BC193A49B7CF7E715181435", hash_generated_method = "EB309994B9A291AEB8E3F9FECBF79D95")
    public void overrideParamter(final String name, final String value) {
        getParameters().put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //getParameters().put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.846 -0400", hash_original_method = "9DF20B77158B98071C5FA39937248DA7", hash_generated_method = "1AA5FD23F57FF49C04FDE693FD4A558B")
    private String getCnonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1289577724 = null; //Variable for return #1
        {
            this.cnonce = createCnonce();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1289577724 = this.cnonce;
        varB4EAC82CA7396A68D541C85D26508E83_1289577724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1289577724;
        // ---------- Original Method ----------
        //if (this.cnonce == null) {
            //this.cnonce = createCnonce();
        //}
        //return this.cnonce;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.848 -0400", hash_original_method = "DE78FD59B9BB87751F59177A2F51AB0F", hash_generated_method = "AB9D120F568205D1BB0F3296130A4AAC")
    public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        Header varB4EAC82CA7396A68D541C85D26508E83_1487050148 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Credentials may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        getParameters().put("methodname", request.getRequestLine().getMethod());
        getParameters().put("uri", request.getRequestLine().getUri());
        String charset = getParameter("charset");
        {
            charset = AuthParams.getCredentialCharset(request.getParams());
            getParameters().put("charset", charset);
        } //End block
        String digest = createDigest(credentials);
        varB4EAC82CA7396A68D541C85D26508E83_1487050148 = createDigestHeader(credentials, digest);
        addTaint(credentials.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1487050148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1487050148;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.850 -0400", hash_original_method = "EC5C003DA4A6F1C86FB6170174AAC10C", hash_generated_method = "F5639DD6AAC3A47E8562FACECED64346")
    private String createDigest(final Credentials credentials) throws AuthenticationException {
        String varB4EAC82CA7396A68D541C85D26508E83_269862990 = null; //Variable for return #1
        String uri = getParameter("uri");
        String realm = getParameter("realm");
        String nonce = getParameter("nonce");
        String method = getParameter("methodname");
        String algorithm = getParameter("algorithm");
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
        String charset = getParameter("charset");
        {
            charset = "ISO-8859-1";
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AuthenticationException(
                "Unsupported qop in HTTP Digest authentication");
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
        {
            boolean var9A323FE2D4093DE847DBC2C61427986A_210433354 = (algorithm.equalsIgnoreCase("MD5-sess"));
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
            {
                boolean var93593B6D05D8F0C556A656FE5696494F_1133249200 = (!algorithm.equalsIgnoreCase("MD5"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new AuthenticationException("Unhandled algorithm " + algorithm + " requested");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        String md5a1 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
        String a2 = null;
        {
            a2 = method + ':' + uri;
        } //End block
        String md5a2 = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(a2)));
        String serverDigestValue;
        {
            StringBuilder tmp2 = new StringBuilder(md5a1.length() + nonce.length() + md5a2.length());
            tmp2.append(md5a1);
            tmp2.append(':');
            tmp2.append(nonce);
            tmp2.append(':');
            tmp2.append(md5a2);
            serverDigestValue = tmp2.toString();
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_269862990 = serverDigest;
        addTaint(credentials.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_269862990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_269862990;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.851 -0400", hash_original_method = "C034852EE12EEF6A2A977B845769FACB", hash_generated_method = "26D08B84081C9F62E3B0593F96873113")
    private Header createDigestHeader(
            final Credentials credentials, 
            final String digest) throws AuthenticationException {
        Header varB4EAC82CA7396A68D541C85D26508E83_1009412518 = null; //Variable for return #1
        CharArrayBuffer buffer = new CharArrayBuffer(128);
        {
            boolean var0D47185A0D32DD28D63E82CE34A14458_81126808 = (isProxy());
            {
                buffer.append(AUTH.PROXY_AUTH_RESP);
            } //End block
            {
                buffer.append(AUTH.WWW_AUTH_RESP);
            } //End block
        } //End collapsed parenthetic
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
            int i = 0;
            boolean var41B38B8299B0C96B0545ADBE0A9274EC_34907981 = (i < params.size());
            {
                BasicNameValuePair param = params.get(i);
                {
                    buffer.append(", ");
                } //End block
                boolean noQuotes = "nc".equals(param.getName()) ||
                               "qop".equals(param.getName());
                BasicHeaderValueFormatter.DEFAULT
                .formatNameValuePair(buffer, param, !noQuotes);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1009412518 = new BufferedHeader(buffer);
        addTaint(credentials.getTaint());
        addTaint(digest.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1009412518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1009412518;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.852 -0400", hash_original_method = "4B7F5D1CEF78CAAD9B937EECFEA67886", hash_generated_method = "B22083EB19BD9E36C2B42541BF140E0A")
    private String getQopVariantString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166643595 = null; //Variable for return #1
        String qopOption;
        {
            qopOption = "auth-int";
        } //End block
        {
            qopOption = "auth";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1166643595 = qopOption;
        varB4EAC82CA7396A68D541C85D26508E83_1166643595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166643595;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.853 -0400", hash_original_field = "F7D8830866BD67517862140230F751E2", hash_generated_field = "6935DD423E05BC188EBDC4FC4F36C352")

    private static final char[] HEXADECIMAL = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
        'e', 'f'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.853 -0400", hash_original_field = "ADA7972328A77782718F3684A00C1F3B", hash_generated_field = "2C31BDE6F9C6C99349800C2C54D624CA")

    private static final String NC = "00000001";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.853 -0400", hash_original_field = "DF808FC1E99F7D3929CA338656EC3B51", hash_generated_field = "86CCA515EBD2620AA29A1DCED5FA7E9D")

    private static final int QOP_MISSING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.853 -0400", hash_original_field = "501256FDC0D3D79D30693D098788AA70", hash_generated_field = "33AF0500E5DAF5053FCBA26E621CF903")

    private static final int QOP_AUTH_INT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.853 -0400", hash_original_field = "C4759F1A948E06530AA939B8020E3333", hash_generated_field = "D822DF3F18281C8743CDFDE58903C2E0")

    private static final int QOP_AUTH = 2;
}

