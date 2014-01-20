package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class DigestScheme extends RFC2617Scheme {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.706 -0500", hash_original_method = "252E19077B2ABBDBE3896311A0C6F0E7", hash_generated_method = "5C54E299EA1AAC8B088F1E26B683997C")
    
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

    /**
     * Encodes the 128 bit (16 bytes) MD5 digest into a 32 characters long 
     * <CODE>String</CODE> according to RFC 2617.
     * 
     * @param binaryData array containing the digest
     * @return encoded MD5, or <CODE>null</CODE> if encoding failed
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.718 -0500", hash_original_method = "32C7579E7A20EFF08C798AFD17C9F8B4", hash_generated_method = "9F7BA146B87E96C0D46A707E68C625D2")
    
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

    /**
     * Creates a random cnonce value based on the current time.
     * 
     * @return The cnonce value as String.
     * @throws UnsupportedDigestAlgorithmException if MD5 algorithm is not supported.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.721 -0500", hash_original_method = "A4DA9D6458699868D83920107CCFA8FD", hash_generated_method = "468CC97B5B32B43115FE9AA120C34125")
    
public static String createCnonce() {
        String cnonce;

        MessageDigest md5Helper = createMessageDigest("MD5");

        cnonce = Long.toString(System.currentTimeMillis());
        cnonce = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(cnonce)));

        return cnonce;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.667 -0500", hash_original_field = "C7330DB3A960AFB2A9477C190A171017", hash_generated_field = "6935DD423E05BC188EBDC4FC4F36C352")

    private static final char[] HEXADECIMAL = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
        'e', 'f'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.671 -0500", hash_original_field = "EA6F31F3CC31DD9572E9CA9461F28496", hash_generated_field = "2C31BDE6F9C6C99349800C2C54D624CA")

    private static final String NC = "00000001";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.674 -0500", hash_original_field = "4CF8356E4F693C08EED4C2EEA0DDA897", hash_generated_field = "86CCA515EBD2620AA29A1DCED5FA7E9D")

    private static final int QOP_MISSING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.677 -0500", hash_original_field = "E9B34C6D810F14C435CCD87C80FCB7CE", hash_generated_field = "33AF0500E5DAF5053FCBA26E621CF903")

    private static final int QOP_AUTH_INT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.679 -0500", hash_original_field = "4CAC1E35506CD57CAB62DFADD7AB9748", hash_generated_field = "D822DF3F18281C8743CDFDE58903C2E0")

    private static final int QOP_AUTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.669 -0500", hash_original_field = "C51E6506F56B38D2FA99DED8C0973BFD", hash_generated_field = "F226924E4DACD94115C3FB4783C05FA4")

    private boolean complete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.681 -0500", hash_original_field = "0DAA7721A139829C14712DFFA240735E", hash_generated_field = "3842BF6B6403917837D5616C0B4C3C6A")

    private int qopVariant = QOP_MISSING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.683 -0500", hash_original_field = "3FC5E51B0E9C58AD59076F7008FEB0E3", hash_generated_field = "A436BD0723F1A8DF0FBA775815BA03FC")

    private String cnonce;

    /**
     * Default constructor for the digest authetication scheme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.685 -0500", hash_original_method = "7496779349A4F9577FBBD3B727B27A4A", hash_generated_method = "BE409823F44A564F2AD29E64A4C62CA9")
    
public DigestScheme() {
        super();
        this.complete = false;
    }

    /**
     * Processes the Digest challenge.
     *  
     * @param header the challenge header
     * 
     * @throws MalformedChallengeException is thrown if the authentication challenge
     * is malformed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.688 -0500", hash_original_method = "F883A5EB3B1E4D14BCFB97B586287C83", hash_generated_method = "620C993562D5F298626C05BD131EE126")
    
@Override
    public void processChallenge(
            final Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        
        if (getParameter("realm") == null) {
            throw new MalformedChallengeException("missing realm in challange");
        }
        if (getParameter("nonce") == null) {
            throw new MalformedChallengeException("missing nonce in challange");   
        }
        
        boolean unsupportedQop = false;
        // qop parsing
        String qop = getParameter("qop");
        if (qop != null) {
            StringTokenizer tok = new StringTokenizer(qop,",");
            while (tok.hasMoreTokens()) {
                String variant = tok.nextToken().trim();
                if (variant.equals("auth")) {
                    qopVariant = QOP_AUTH;
                    break; //that's our favourite, because auth-int is unsupported
                } else if (variant.equals("auth-int")) {
                    qopVariant = QOP_AUTH_INT;               
                } else {
                    unsupportedQop = true;
                }     
            }
        }
        
        if (unsupportedQop && (qopVariant == QOP_MISSING)) {
            throw new MalformedChallengeException("None of the qop methods is supported");   
        }
        // Reset cnonce
        this.cnonce = null;
        this.complete = true;
    }

    /**
     * Tests if the Digest authentication process has been completed.
     * 
     * @return <tt>true</tt> if Digest authorization has been processed,
     *   <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.691 -0500", hash_original_method = "F17D438485F30D6AF41BADA0EDB398DD", hash_generated_method = "31B46AE0A8FB4E15B2C007D27DFC9D2F")
    
public boolean isComplete() {
        String s = getParameter("stale");
        if ("true".equalsIgnoreCase(s)) {
            return false;
        } else {
            return this.complete;
        }
    }

    /**
     * Returns textual designation of the digest authentication scheme.
     * 
     * @return <code>digest</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.693 -0500", hash_original_method = "590EDC4C396D176AA70267B4181524CE", hash_generated_method = "EC1CDF4C4F65BE7EF179619AEB3ECF31")
    
public String getSchemeName() {
        return "digest";
    }

    /**
     * Returns <tt>false</tt>. Digest authentication scheme is request based.
     * 
     * @return <tt>false</tt>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.696 -0500", hash_original_method = "52FB523EE33548A5337713590AB1DF72", hash_generated_method = "2AFD9511A9C9359DA57C31C6DF79FB99")
    
public boolean isConnectionBased() {
        return false;    
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.698 -0500", hash_original_method = "53EAC8543BC193A49B7CF7E715181435", hash_generated_method = "FAD811A2EA098836F2468355AFCBF597")
    
public void overrideParamter(final String name, final String value) {
        getParameters().put(name, value);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.701 -0500", hash_original_method = "9DF20B77158B98071C5FA39937248DA7", hash_generated_method = "9D8E75736184C7E03AC93713F7901638")
    
private String getCnonce() {
        if (this.cnonce == null) {
            this.cnonce = createCnonce();
        }
        return this.cnonce; 
    }
    
    /**
     * Produces a digest authorization string for the given set of 
     * {@link Credentials}, method name and URI.
     * 
     * @param credentials A set of credentials to be used for athentication
     * @param request    The request being authenticated
     * 
     * @throws org.apache.http.auth.InvalidCredentialsException if authentication credentials
     *         are not valid or not applicable for this authentication scheme
     * @throws AuthenticationException if authorization string cannot 
     *   be generated due to an authentication failure
     * 
     * @return a digest authorization string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.703 -0500", hash_original_method = "DE78FD59B9BB87751F59177A2F51AB0F", hash_generated_method = "143402F25754E7C6FE939A8A6CE1BB17")
    
public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {

        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        
        // Add method name and request-URI to the parameter map
        getParameters().put("methodname", request.getRequestLine().getMethod());
        getParameters().put("uri", request.getRequestLine().getUri());
        String charset = getParameter("charset");
        if (charset == null) {
            charset = AuthParams.getCredentialCharset(request.getParams());
            getParameters().put("charset", charset);
        }
        String digest = createDigest(credentials);
        return createDigestHeader(credentials, digest);
    }
    
    /**
     * Creates an MD5 response digest.
     * 
     * @return The created digest as string. This will be the response tag's
     *         value in the Authentication HTTP header.
     * @throws AuthenticationException when MD5 is an unsupported algorithm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.710 -0500", hash_original_method = "EC5C003DA4A6F1C86FB6170174AAC10C", hash_generated_method = "A07A19277BBF8A8BEA40D6F91E3D9E76")
    
private String createDigest(final Credentials credentials) throws AuthenticationException {
        // Collecting required tokens
        String uri = getParameter("uri");
        String realm = getParameter("realm");
        String nonce = getParameter("nonce");
        String method = getParameter("methodname");
        String algorithm = getParameter("algorithm");
        if (uri == null) {
            throw new IllegalStateException("URI may not be null");
        }
        if (realm == null) {
            throw new IllegalStateException("Realm may not be null");
        }
        if (nonce == null) {
            throw new IllegalStateException("Nonce may not be null");
        }
        // If an algorithm is not specified, default to MD5.
        if (algorithm == null) {
            algorithm = "MD5";
        }
        // If an charset is not specified, default to ISO-8859-1.
        String charset = getParameter("charset");
        if (charset == null) {
            charset = "ISO-8859-1";
        }

        if (qopVariant == QOP_AUTH_INT) {
            throw new AuthenticationException(
                "Unsupported qop in HTTP Digest authentication");   
        }

        MessageDigest md5Helper = createMessageDigest("MD5");

        String uname = credentials.getUserPrincipal().getName();
        String pwd = credentials.getPassword();
        
        // 3.2.2.2: Calculating digest
        StringBuilder tmp = new StringBuilder(uname.length() + realm.length() + pwd.length() + 2);
        tmp.append(uname);
        tmp.append(':');
        tmp.append(realm);
        tmp.append(':');
        tmp.append(pwd);
        // unq(username-value) ":" unq(realm-value) ":" passwd
        String a1 = tmp.toString();
        
        //a1 is suitable for MD5 algorithm
        if(algorithm.equalsIgnoreCase("MD5-sess")) { // android-changed: ignore case
            // H( unq(username-value) ":" unq(realm-value) ":" passwd )
            //      ":" unq(nonce-value)
            //      ":" unq(cnonce-value)

            String cnonce = getCnonce();
            
            String tmp2=encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));
            StringBuilder tmp3 = new StringBuilder(tmp2.length() + nonce.length() + cnonce.length() + 2);
            tmp3.append(tmp2);
            tmp3.append(':');
            tmp3.append(nonce);
            tmp3.append(':');
            tmp3.append(cnonce);
            a1 = tmp3.toString();
        } else if (!algorithm.equalsIgnoreCase("MD5")) { // android-changed: ignore case
            throw new AuthenticationException("Unhandled algorithm " + algorithm + " requested");
        }
        String md5a1 = encode(md5Helper.digest(EncodingUtils.getBytes(a1, charset)));

        String a2 = null;
        if (qopVariant == QOP_AUTH_INT) {
            // Unhandled qop auth-int
            //we do not have access to the entity-body or its hash
            //TODO: add Method ":" digest-uri-value ":" H(entity-body)      
        } else {
            a2 = method + ':' + uri;
        }
        String md5a2 = encode(md5Helper.digest(EncodingUtils.getAsciiBytes(a2)));

        // 3.2.2.1
        String serverDigestValue;
        if (qopVariant == QOP_MISSING) {
            StringBuilder tmp2 = new StringBuilder(md5a1.length() + nonce.length() + md5a2.length());
            tmp2.append(md5a1);
            tmp2.append(':');
            tmp2.append(nonce);
            tmp2.append(':');
            tmp2.append(md5a2);
            serverDigestValue = tmp2.toString();
        } else {
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
        }

        String serverDigest =
            encode(md5Helper.digest(EncodingUtils.getAsciiBytes(serverDigestValue)));

        return serverDigest;
    }

    /**
     * Creates digest-response header as defined in RFC2617.
     * 
     * @param credentials User credentials
     * @param digest The response tag's value as String.
     * 
     * @return The digest-response as String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.713 -0500", hash_original_method = "C034852EE12EEF6A2A977B845769FACB", hash_generated_method = "D475DAA260B368EF490A5249CEC7163B")
    
private Header createDigestHeader(
            final Credentials credentials, 
            final String digest) throws AuthenticationException {
        
        CharArrayBuffer buffer = new CharArrayBuffer(128);
        if (isProxy()) {
            buffer.append(AUTH.PROXY_AUTH_RESP);
        } else {
            buffer.append(AUTH.WWW_AUTH_RESP);
        }
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
        
        if (qopVariant != QOP_MISSING) {
            params.add(new BasicNameValuePair("qop", getQopVariantString()));
            params.add(new BasicNameValuePair("nc", NC));
            params.add(new BasicNameValuePair("cnonce", getCnonce()));
        }
        if (algorithm != null) {
            params.add(new BasicNameValuePair("algorithm", algorithm));
        }    
        if (opaque != null) {
            params.add(new BasicNameValuePair("opaque", opaque));
        }

        for (int i = 0; i < params.size(); i++) {
            BasicNameValuePair param = params.get(i);
            if (i > 0) {
                buffer.append(", ");
            }
            boolean noQuotes = "nc".equals(param.getName()) ||
                               "qop".equals(param.getName());
            BasicHeaderValueFormatter.DEFAULT
                .formatNameValuePair(buffer, param, !noQuotes);
        }
        return new BufferedHeader(buffer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.716 -0500", hash_original_method = "4B7F5D1CEF78CAAD9B937EECFEA67886", hash_generated_method = "099E82A0A9F44C50061236929B63F866")
    
private String getQopVariantString() {
        String qopOption;
        if (qopVariant == QOP_AUTH_INT) {
            qopOption = "auth-int";   
        } else {
            qopOption = "auth";
        }
        return qopOption;            
    }
}

