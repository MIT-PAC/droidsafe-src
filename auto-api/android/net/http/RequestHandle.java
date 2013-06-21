package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.ParseException;
import android.net.WebAddress;
import junit.framework.Assert;
import android.webkit.CookieManager;
import org.apache.commons.codec.binary.Base64;
import java.io.InputStream;
import java.lang.Math;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RequestHandle {
    private String        mUrl;
    private WebAddress    mUri;
    private String        mMethod;
    private Map<String, String> mHeaders;
    private RequestQueue  mRequestQueue;
    private Request       mRequest;
    private InputStream   mBodyProvider;
    private int           mBodyLength;
    private int           mRedirectCount = 0;
    private Connection    mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.014 -0400", hash_original_method = "D52FB5C4B4CE262D3BDE3938D1D81A5F", hash_generated_method = "A80A9F49673240F9FCF22DF4247E5ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(requestQueue.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(url);
        {
            headers = new HashMap<String, String>();
        } //End block
        mMethod = method == null? "GET" : method;
        // ---------- Original Method ----------
        //if (headers == null) {
            //headers = new HashMap<String, String>();
        //}
        //mHeaders = headers;
        //mBodyProvider = bodyProvider;
        //mBodyLength = bodyLength;
        //mMethod = method == null? "GET" : method;
        //mUrl = url;
        //mUri = uri;
        //mRequestQueue = requestQueue;
        //mRequest = request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.014 -0400", hash_original_method = "8F53D2F7ECBB6A0E31E2DA5BDF5FFE63", hash_generated_method = "1A0DEE484FC5581D090FAB0083510C13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request,
            Connection conn) {
        this(requestQueue, url, uri, method, headers, bodyProvider, bodyLength,
                request);
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(requestQueue.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
        //mConnection = conn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.015 -0400", hash_original_method = "971FA82A9D84F9459C5196533729906E", hash_generated_method = "B8DC4F3364076874DE3E56FBC9E5B41C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            mRequest.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.015 -0400", hash_original_method = "981EAB54F552460A30185E1B96B8DE52", hash_generated_method = "C023CF95D999AE90CC32331D6A2A1FFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pauseRequest(boolean pause) {
        dsTaint.addTaint(pause);
        {
            mRequest.setLoadingPaused(pause);
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.setLoadingPaused(pause);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.015 -0400", hash_original_method = "2C5209A970780A5B14F30F7C2DFA5DF9", hash_generated_method = "1FA89F809906994ED811C2B0F7C1977B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleSslErrorResponse(boolean proceed) {
        dsTaint.addTaint(proceed);
        {
            mRequest.handleSslErrorResponse(proceed);
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.handleSslErrorResponse(proceed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.015 -0400", hash_original_method = "1E2E2512E5F173592E2117FB4C479261", hash_generated_method = "7C07F6F0F65CF14BC51BDCB4C7FF8481")
    @DSModeled(DSC.SAFE)
    public boolean isRedirectMax() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRedirectCount >= MAX_REDIRECT_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.016 -0400", hash_original_method = "3AC7970B74E2F8214DB13CA8BCAB44BF", hash_generated_method = "13AC0A5A45903A07F3A397DDD657E930")
    @DSModeled(DSC.SAFE)
    public int getRedirectCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRedirectCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.016 -0400", hash_original_method = "FFEBE76B00A2A9B427C3877CD59FFD71", hash_generated_method = "F4AC95AD9B7D25DD6C0FF10F9B54AD8E")
    @DSModeled(DSC.SAFE)
    public void setRedirectCount(int count) {
        dsTaint.addTaint(count);
        // ---------- Original Method ----------
        //mRedirectCount = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.016 -0400", hash_original_method = "44F47D5B04481BCE428881C329B8D0F8", hash_generated_method = "5EF560ECA0E495AFA26C786BD686DC8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setupRedirect(String redirectTo, int statusCode,
            Map<String, String> cacheHeaders) {
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(redirectTo);
        dsTaint.addTaint(cacheHeaders.dsTaint);
        {
            HttpLog.v("RequestHandle.setupRedirect(): redirectCount " +
                  mRedirectCount);
        } //End block
        mHeaders.remove(AUTHORIZATION_HEADER);
        mHeaders.remove(PROXY_AUTHORIZATION_HEADER);
        {
            HttpLog.v(
                    "RequestHandle.setupRedirect(): too many redirects " +
                    mRequest);
            mRequest.error(EventHandler.ERROR_REDIRECT_LOOP,
                           com.android.internal.R.string.httpErrorRedirectLoop);
        } //End block
        {
            boolean varD28027E3C8C66D5850ACF2C8E5F3A9AE_1801267532 = (mUrl.startsWith("https:") && redirectTo.startsWith("http:"));
            {
                {
                    HttpLog.v("blowing away the referer on an https -> http redirect");
                } //End block
                mHeaders.remove("Referer");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            mUri = new WebAddress(mUrl);
        } //End block
        catch (ParseException e)
        {
            e.printStackTrace();
        } //End block
        mHeaders.remove("Cookie");
        String cookie;
        cookie = CookieManager.getInstance().getCookie(mUri);
        {
            boolean var6E2855FE1453DF0044F1B1E343DD13F2_75297414 = (cookie != null && cookie.length() > 0);
            {
                mHeaders.put("Cookie", cookie);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF39D40D4EB771BAD1F65F2E1AED2EAA7_692423270 = ((statusCode == 302 || statusCode == 303) && mMethod.equals("POST"));
            {
                {
                    HttpLog.v("replacing POST with GET on redirect to " + redirectTo);
                } //End block
                mMethod = "GET";
            } //End block
        } //End collapsed parenthetic
        {
            try 
            {
                mBodyProvider.reset();
            } //End block
            catch (java.io.IOException ex)
            {
                {
                    HttpLog.v("setupRedirect() failed to reset body provider");
                } //End block
            } //End block
        } //End block
        {
            mHeaders.remove("Content-Type");
            mBodyProvider = null;
        } //End block
        mHeaders.putAll(cacheHeaders);
        createAndQueueNewRequest();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.017 -0400", hash_original_method = "38ABF845B1FE2E62FC6D2FD8DBFFE504", hash_generated_method = "90C095888A2F650D921476BE6ABD35F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(isProxy);
        dsTaint.addTaint(password);
        String response;
        response = computeBasicAuthResponse(username, password);
        {
            HttpLog.v("setupBasicAuthResponse(): response: " + response);
        } //End block
        mHeaders.put(authorizationHeader(isProxy), "Basic " + response);
        setupAuthResponse();
        // ---------- Original Method ----------
        //String response = computeBasicAuthResponse(username, password);
        //if (HttpLog.LOGV) {
            //HttpLog.v("setupBasicAuthResponse(): response: " + response);
        //}
        //mHeaders.put(authorizationHeader(isProxy), "Basic " + response);
        //setupAuthResponse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.017 -0400", hash_original_method = "B5A5838E4BCFB5CBC22C9A029CA123B8", hash_generated_method = "27F4EFA6BBB623F02A3600AE46D5AA59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setupDigestAuthResponse(boolean isProxy,
                                        String username,
                                        String password,
                                        String realm,
                                        String nonce,
                                        String QOP,
                                        String algorithm,
                                        String opaque) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(nonce);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(opaque);
        dsTaint.addTaint(isProxy);
        dsTaint.addTaint(QOP);
        dsTaint.addTaint(password);
        dsTaint.addTaint(algorithm);
        String response;
        response = computeDigestAuthResponse(
                username, password, realm, nonce, QOP, algorithm, opaque);
        {
            HttpLog.v("setupDigestAuthResponse(): response: " + response);
        } //End block
        mHeaders.put(authorizationHeader(isProxy), "Digest " + response);
        setupAuthResponse();
        // ---------- Original Method ----------
        //String response = computeDigestAuthResponse(
                //username, password, realm, nonce, QOP, algorithm, opaque);
        //if (HttpLog.LOGV) {
            //HttpLog.v("setupDigestAuthResponse(): response: " + response);
        //}
        //mHeaders.put(authorizationHeader(isProxy), "Digest " + response);
        //setupAuthResponse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.018 -0400", hash_original_method = "671BE1071898035C0F84A86A39735052", hash_generated_method = "BDED742C89263CC4B8DD9B59171D8B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupAuthResponse() {
        try 
        {
            mBodyProvider.reset();
        } //End block
        catch (java.io.IOException ex)
        {
            {
                HttpLog.v("setupAuthResponse() failed to reset body provider");
            } //End block
        } //End block
        createAndQueueNewRequest();
        // ---------- Original Method ----------
        //try {
            //if (mBodyProvider != null) mBodyProvider.reset();
        //} catch (java.io.IOException ex) {
            //if (HttpLog.LOGV) {
                //HttpLog.v("setupAuthResponse() failed to reset body provider");
            //}
        //}
        //createAndQueueNewRequest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.018 -0400", hash_original_method = "E02C2F0EA498C425350A019498EEA751", hash_generated_method = "62949885DA7AA8A8610A072FDCE708A8")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMethod;
    }

    
        public static String computeBasicAuthResponse(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        return new String(Base64.encodeBase64((username + ':' + password).getBytes()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.018 -0400", hash_original_method = "8819509041D3F58366571B93CC9E3D4B", hash_generated_method = "739C8F45FA1E2134F512E5E5B3753B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void waitUntilComplete() {
        mRequest.waitUntilComplete();
        // ---------- Original Method ----------
        //mRequest.waitUntilComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.019 -0400", hash_original_method = "420B4AD7BC25160624AF5D40CF27D44F", hash_generated_method = "F91A8CE46D61889C28091CE3D2FAC9BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processRequest() {
        {
            mConnection.processRequests(mRequest);
        } //End block
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //mConnection.processRequests(mRequest);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.019 -0400", hash_original_method = "21566870DD44046714482EED382208F4", hash_generated_method = "C059D81C852A1617239C1E2ED9AE13CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String computeDigestAuthResponse(String username,
                                             String password,
                                             String realm,
                                             String nonce,
                                             String QOP,
                                             String algorithm,
                                             String opaque) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(nonce);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(opaque);
        dsTaint.addTaint(QOP);
        dsTaint.addTaint(password);
        dsTaint.addTaint(algorithm);
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        Assert.assertNotNull(realm);
        String A1;
        A1 = username + ":" + realm + ":" + password;
        String A2;
        A2 = mMethod  + ":" + mUrl;
        String nc;
        nc = "00000001";
        String cnonce;
        cnonce = computeCnonce();
        String digest;
        digest = computeDigest(A1, A2, nonce, QOP, nc, cnonce);
        String response;
        response = "";
        response += "username=" + doubleQuote(username) + ", ";
        response += "realm="    + doubleQuote(realm)    + ", ";
        response += "nonce="    + doubleQuote(nonce)    + ", ";
        response += "uri="      + doubleQuote(mUrl)     + ", ";
        response += "response=" + doubleQuote(digest);
        {
            response += ", opaque=" + doubleQuote(opaque);
        } //End block
        {
            response += ", algorithm=" +  algorithm;
        } //End block
        {
            response += ", qop=" + QOP + ", nc=" + nc + ", cnonce=" + doubleQuote(cnonce);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String authorizationHeader(boolean isProxy) {
        if (!isProxy) {
            return AUTHORIZATION_HEADER;
        } else {
            return PROXY_AUTHORIZATION_HEADER;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.020 -0400", hash_original_method = "7BFA5C62C730E408B108712B34B74DD9", hash_generated_method = "D56C793EE4C37E04E966361AA43F8BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String computeDigest(
        String A1, String A2, String nonce, String QOP, String nc, String cnonce) {
        dsTaint.addTaint(A2);
        dsTaint.addTaint(cnonce);
        dsTaint.addTaint(A1);
        dsTaint.addTaint(nc);
        dsTaint.addTaint(nonce);
        dsTaint.addTaint(QOP);
        {
            HttpLog.v("computeDigest(): QOP: " + QOP);
        } //End block
        {
            String varA3F178392AF7441E3A3E394389BC64CA_1816024310 = (KD(H(A1), nonce + ":" + H(A2)));
        } //End block
        {
            {
                boolean var787B3A44C2C97C691E216FE225E2DA94_1578278696 = (QOP.equalsIgnoreCase("auth"));
                {
                    String varDECF3639F39E7C3F5F1373126A9FD2D5_805059209 = (KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("computeDigest(): QOP: " + QOP);
        //}
        //if (QOP == null) {
            //return KD(H(A1), nonce + ":" + H(A2));
        //} else {
            //if (QOP.equalsIgnoreCase("auth")) {
                //return KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2));
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.020 -0400", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "B31CE0134BAE3BA80D18F53DC2220373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String KD(String secret, String data) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(secret);
        String var554E18952A7E679E1C9B747C9E6F1FF4_1314860048 = (H(secret + ":" + data));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return H(secret + ":" + data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.021 -0400", hash_original_method = "ACD3D964B796417ECD09BF2089A3A365", hash_generated_method = "BC0D36B59C841C77F81241829C6777D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String H(String param) {
        dsTaint.addTaint(param);
        {
            try 
            {
                MessageDigest md5;
                md5 = MessageDigest.getInstance("MD5");
                byte[] d;
                d = md5.digest(param.getBytes());
                {
                    String var490E26CE609F98A607B96BB89B2C5C4C_2001223472 = (bufferToHex(d));
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (param != null) {
            //try {
                //MessageDigest md5 = MessageDigest.getInstance("MD5");
                //byte[] d = md5.digest(param.getBytes());
                //if (d != null) {
                    //return bufferToHex(d);
                //}
            //} catch (NoSuchAlgorithmException e) {
                //throw new RuntimeException(e);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.021 -0400", hash_original_method = "F71FFAFC3CF70E71567406DE8A9A2D97", hash_generated_method = "DC5576B98C58FA73A4C15EE979DF11FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String bufferToHex(byte[] buffer) {
        dsTaint.addTaint(buffer[0]);
        char hexChars[];
        {
            int length;
            length = buffer.length;
            {
                StringBuilder hex;
                hex = new StringBuilder(2 * length);
                {
                    int i;
                    i = 0;
                    {
                        byte l;
                        l = (byte) (buffer[i] & 0x0F);
                        byte h;
                        h = (byte)((buffer[i] & 0xF0) >> 4);
                        hex.append(hexChars[h]);
                        hex.append(hexChars[l]);
                    } //End block
                } //End collapsed parenthetic
                String var5B4319ECE144FE94C5014928E0AF4C4C_468783191 = (hex.toString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final char hexChars[] =
            //{ '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
        //if (buffer != null) {
            //int length = buffer.length;
            //if (length > 0) {
                //StringBuilder hex = new StringBuilder(2 * length);
                //for (int i = 0; i < length; ++i) {
                    //byte l = (byte) (buffer[i] & 0x0F);
                    //byte h = (byte)((buffer[i] & 0xF0) >> 4);
                    //hex.append(hexChars[h]);
                    //hex.append(hexChars[l]);
                //}
                //return hex.toString();
            //} else {
                //return "";
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.022 -0400", hash_original_method = "15E2F72950F37D4FA5596F6CA90D9CCE", hash_generated_method = "308C94B742FFCD1E10C6C4A714C0CB10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String computeCnonce() {
        Random rand;
        rand = new Random();
        int nextInt;
        nextInt = rand.nextInt();
        nextInt = (nextInt == Integer.MIN_VALUE) ?
                Integer.MAX_VALUE : Math.abs(nextInt);
        String varC35997D032E6FADF93B91696D80914F3_410394985 = (Integer.toString(nextInt, 16));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Random rand = new Random();
        //int nextInt = rand.nextInt();
        //nextInt = (nextInt == Integer.MIN_VALUE) ?
                //Integer.MAX_VALUE : Math.abs(nextInt);
        //return Integer.toString(nextInt, 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.022 -0400", hash_original_method = "2F687A14AA3727476BB6949A7966696D", hash_generated_method = "60E165E5742F94A44F9669036C4C81E3")
    @DSModeled(DSC.SAFE)
    private String doubleQuote(String param) {
        dsTaint.addTaint(param);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (param != null) {
            //return "\"" + param + "\"";
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.022 -0400", hash_original_method = "85265833A731D9185DA35397C2BF1AAD", hash_generated_method = "1E0D72EFD58DC7560AD8C6398A57547E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createAndQueueNewRequest() {
        {
            RequestHandle newHandle;
            newHandle = mRequestQueue.queueSynchronousRequest(
                    mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                    mBodyProvider, mBodyLength);
            mRequest = newHandle.mRequest;
            mConnection = newHandle.mConnection;
            newHandle.processRequest();
        } //End block
        mRequest = mRequestQueue.queueRequest(
                mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                mBodyProvider,
                mBodyLength).mRequest;
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //RequestHandle newHandle = mRequestQueue.queueSynchronousRequest(
                    //mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                    //mBodyProvider, mBodyLength);
            //mRequest = newHandle.mRequest;
            //mConnection = newHandle.mConnection;
            //newHandle.processRequest();
            //return;
        //}
        //mRequest = mRequestQueue.queueRequest(
                //mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                //mBodyProvider,
                //mBodyLength).mRequest;
    }

    
    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final static String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    public final static int MAX_REDIRECT_COUNT = 16;
}

