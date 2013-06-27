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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.716 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.716 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "AD4E85AF09CC6305596E8DE3A73ABA21", hash_generated_field = "7A4E35082A966BF8F9758B373DCB600C")

    private int mRedirectCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.717 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.732 -0400", hash_original_method = "D52FB5C4B4CE262D3BDE3938D1D81A5F", hash_generated_method = "F3F1D5CED65B10C65A5322626BC707F9")
    public  RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request) {
        {
            headers = new HashMap<String, String>();
        } //End block
        mHeaders = headers;
        mBodyProvider = bodyProvider;
        mBodyLength = bodyLength;
        mMethod = method == null? "GET" : method;
        mUrl = url;
        mUri = uri;
        mRequestQueue = requestQueue;
        mRequest = request;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.734 -0400", hash_original_method = "8F53D2F7ECBB6A0E31E2DA5BDF5FFE63", hash_generated_method = "1865F73EFD089C397C6EE29A9878838E")
    public  RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request,
            Connection conn) {
        this(requestQueue, url, uri, method, headers, bodyProvider, bodyLength,
                request);
        mConnection = conn;
        addTaint(requestQueue.getTaint());
        addTaint(url.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //mConnection = conn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.742 -0400", hash_original_method = "971FA82A9D84F9459C5196533729906E", hash_generated_method = "B8DC4F3364076874DE3E56FBC9E5B41C")
    public void cancel() {
        {
            mRequest.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.743 -0400", hash_original_method = "981EAB54F552460A30185E1B96B8DE52", hash_generated_method = "64E5AEC4112F686D79C3149DDD6CBBF1")
    public void pauseRequest(boolean pause) {
        {
            mRequest.setLoadingPaused(pause);
        } //End block
        addTaint(pause);
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.setLoadingPaused(pause);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.745 -0400", hash_original_method = "2C5209A970780A5B14F30F7C2DFA5DF9", hash_generated_method = "AA215AAF2F5C088AB202FA744ACC2877")
    public void handleSslErrorResponse(boolean proceed) {
        {
            mRequest.handleSslErrorResponse(proceed);
        } //End block
        addTaint(proceed);
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.handleSslErrorResponse(proceed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.745 -0400", hash_original_method = "1E2E2512E5F173592E2117FB4C479261", hash_generated_method = "3BB2249824FB1DE1A8BA3AB8A369D247")
    public boolean isRedirectMax() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814736574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814736574;
        // ---------- Original Method ----------
        //return mRedirectCount >= MAX_REDIRECT_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.766 -0400", hash_original_method = "3AC7970B74E2F8214DB13CA8BCAB44BF", hash_generated_method = "431612D853EA514FD076858595E61E95")
    public int getRedirectCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376612233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376612233;
        // ---------- Original Method ----------
        //return mRedirectCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.767 -0400", hash_original_method = "FFEBE76B00A2A9B427C3877CD59FFD71", hash_generated_method = "75F6E6041180F5755B1072705080BEBF")
    public void setRedirectCount(int count) {
        mRedirectCount = count;
        // ---------- Original Method ----------
        //mRedirectCount = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.799 -0400", hash_original_method = "44F47D5B04481BCE428881C329B8D0F8", hash_generated_method = "07BD74AE97DB8FC7B9C5C848CC55C170")
    public boolean setupRedirect(String redirectTo, int statusCode,
            Map<String, String> cacheHeaders) {
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
            boolean varD28027E3C8C66D5850ACF2C8E5F3A9AE_1951554501 = (mUrl.startsWith("https:") && redirectTo.startsWith("http:"));
            {
                {
                    HttpLog.v("blowing away the referer on an https -> http redirect");
                } //End block
                mHeaders.remove("Referer");
            } //End block
        } //End collapsed parenthetic
        mUrl = redirectTo;
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
            boolean var6E2855FE1453DF0044F1B1E343DD13F2_145788882 = (cookie != null && cookie.length() > 0);
            {
                mHeaders.put("Cookie", cookie);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF39D40D4EB771BAD1F65F2E1AED2EAA7_39207440 = ((statusCode == 302 || statusCode == 303) && mMethod.equals("POST"));
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
        addTaint(statusCode);
        addTaint(cacheHeaders.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868869822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868869822;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.800 -0400", hash_original_method = "38ABF845B1FE2E62FC6D2FD8DBFFE504", hash_generated_method = "BDA1DFD3D41967B9A70186B64C7DB0D6")
    public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        String response;
        response = computeBasicAuthResponse(username, password);
        {
            HttpLog.v("setupBasicAuthResponse(): response: " + response);
        } //End block
        mHeaders.put(authorizationHeader(isProxy), "Basic " + response);
        setupAuthResponse();
        addTaint(isProxy);
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //String response = computeBasicAuthResponse(username, password);
        //if (HttpLog.LOGV) {
            //HttpLog.v("setupBasicAuthResponse(): response: " + response);
        //}
        //mHeaders.put(authorizationHeader(isProxy), "Basic " + response);
        //setupAuthResponse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.804 -0400", hash_original_method = "B5A5838E4BCFB5CBC22C9A029CA123B8", hash_generated_method = "3C38947BCB1283ABC681DD76DC7A29D7")
    public void setupDigestAuthResponse(boolean isProxy,
                                        String username,
                                        String password,
                                        String realm,
                                        String nonce,
                                        String QOP,
                                        String algorithm,
                                        String opaque) {
        String response;
        response = computeDigestAuthResponse(
                username, password, realm, nonce, QOP, algorithm, opaque);
        {
            HttpLog.v("setupDigestAuthResponse(): response: " + response);
        } //End block
        mHeaders.put(authorizationHeader(isProxy), "Digest " + response);
        setupAuthResponse();
        addTaint(isProxy);
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(realm.getTaint());
        addTaint(nonce.getTaint());
        addTaint(QOP.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(opaque.getTaint());
        // ---------- Original Method ----------
        //String response = computeDigestAuthResponse(
                //username, password, realm, nonce, QOP, algorithm, opaque);
        //if (HttpLog.LOGV) {
            //HttpLog.v("setupDigestAuthResponse(): response: " + response);
        //}
        //mHeaders.put(authorizationHeader(isProxy), "Digest " + response);
        //setupAuthResponse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.806 -0400", hash_original_method = "671BE1071898035C0F84A86A39735052", hash_generated_method = "BDED742C89263CC4B8DD9B59171D8B71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.807 -0400", hash_original_method = "E02C2F0EA498C425350A019498EEA751", hash_generated_method = "1FBF8248E2BE85C73F326FE2BD77F980")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_35569739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_35569739 = mMethod;
        varB4EAC82CA7396A68D541C85D26508E83_35569739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_35569739;
        // ---------- Original Method ----------
        //return mMethod;
    }

    
        public static String computeBasicAuthResponse(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        return new String(Base64.encodeBase64((username + ':' + password).getBytes()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.808 -0400", hash_original_method = "8819509041D3F58366571B93CC9E3D4B", hash_generated_method = "739C8F45FA1E2134F512E5E5B3753B74")
    public void waitUntilComplete() {
        mRequest.waitUntilComplete();
        // ---------- Original Method ----------
        //mRequest.waitUntilComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.808 -0400", hash_original_method = "420B4AD7BC25160624AF5D40CF27D44F", hash_generated_method = "F91A8CE46D61889C28091CE3D2FAC9BB")
    public void processRequest() {
        {
            mConnection.processRequests(mRequest);
        } //End block
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //mConnection.processRequests(mRequest);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.839 -0400", hash_original_method = "21566870DD44046714482EED382208F4", hash_generated_method = "2C2FB854D1F9B6D8E3AC77679D191CCB")
    private String computeDigestAuthResponse(String username,
                                             String password,
                                             String realm,
                                             String nonce,
                                             String QOP,
                                             String algorithm,
                                             String opaque) {
        String varB4EAC82CA7396A68D541C85D26508E83_1095906042 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1095906042 = response;
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(realm.getTaint());
        addTaint(nonce.getTaint());
        addTaint(QOP.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(opaque.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1095906042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1095906042;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.853 -0400", hash_original_method = "7BFA5C62C730E408B108712B34B74DD9", hash_generated_method = "D4D0C3CBAEC6964B82831D2AE2FB72E0")
    private String computeDigest(
        String A1, String A2, String nonce, String QOP, String nc, String cnonce) {
        String varB4EAC82CA7396A68D541C85D26508E83_1053453842 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1705383553 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_124836401 = null; //Variable for return #3
        {
            HttpLog.v("computeDigest(): QOP: " + QOP);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1053453842 = KD(H(A1), nonce + ":" + H(A2));
        } //End block
        {
            {
                boolean var787B3A44C2C97C691E216FE225E2DA94_931238564 = (QOP.equalsIgnoreCase("auth"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1705383553 = KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2));
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_124836401 = null;
        addTaint(A1.getTaint());
        addTaint(A2.getTaint());
        addTaint(nonce.getTaint());
        addTaint(QOP.getTaint());
        addTaint(nc.getTaint());
        addTaint(cnonce.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1427559919; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1427559919 = varB4EAC82CA7396A68D541C85D26508E83_1053453842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1427559919 = varB4EAC82CA7396A68D541C85D26508E83_1705383553;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1427559919 = varB4EAC82CA7396A68D541C85D26508E83_124836401;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1427559919.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1427559919;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.866 -0400", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "40F24243FB3606D9CACC1A96801B4D7A")
    private String KD(String secret, String data) {
        String varB4EAC82CA7396A68D541C85D26508E83_511658602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_511658602 = H(secret + ":" + data);
        addTaint(secret.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_511658602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511658602;
        // ---------- Original Method ----------
        //return H(secret + ":" + data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.878 -0400", hash_original_method = "ACD3D964B796417ECD09BF2089A3A365", hash_generated_method = "8FAB6DCC72CD8A6763FF9F5DFAC39337")
    private String H(String param) {
        String varB4EAC82CA7396A68D541C85D26508E83_158315884 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_444547341 = null; //Variable for return #2
        {
            try 
            {
                MessageDigest md5;
                md5 = MessageDigest.getInstance("MD5");
                byte[] d;
                d = md5.digest(param.getBytes());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_158315884 = bufferToHex(d);
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_444547341 = null;
        addTaint(param.getTaint());
        String varA7E53CE21691AB073D9660D615818899_370734984; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_370734984 = varB4EAC82CA7396A68D541C85D26508E83_158315884;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_370734984 = varB4EAC82CA7396A68D541C85D26508E83_444547341;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_370734984.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_370734984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.897 -0400", hash_original_method = "F71FFAFC3CF70E71567406DE8A9A2D97", hash_generated_method = "A086A7F7FBDECF835E0065AE3DFCA9CA")
    private String bufferToHex(byte[] buffer) {
        String varB4EAC82CA7396A68D541C85D26508E83_443452869 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_588130395 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_176741272 = null; //Variable for return #3
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
                varB4EAC82CA7396A68D541C85D26508E83_443452869 = hex.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_588130395 = "";
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_176741272 = null;
        addTaint(buffer[0]);
        String varA7E53CE21691AB073D9660D615818899_186827990; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_186827990 = varB4EAC82CA7396A68D541C85D26508E83_443452869;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_186827990 = varB4EAC82CA7396A68D541C85D26508E83_588130395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_186827990 = varB4EAC82CA7396A68D541C85D26508E83_176741272;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_186827990.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_186827990;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.898 -0400", hash_original_method = "15E2F72950F37D4FA5596F6CA90D9CCE", hash_generated_method = "3ADE438A288D0AD0B6BA511A4BEC1A50")
    private String computeCnonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1556259198 = null; //Variable for return #1
        Random rand;
        rand = new Random();
        int nextInt;
        nextInt = rand.nextInt();
        nextInt = (nextInt == Integer.MIN_VALUE) ?
                Integer.MAX_VALUE : Math.abs(nextInt);
        varB4EAC82CA7396A68D541C85D26508E83_1556259198 = Integer.toString(nextInt, 16);
        varB4EAC82CA7396A68D541C85D26508E83_1556259198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1556259198;
        // ---------- Original Method ----------
        //Random rand = new Random();
        //int nextInt = rand.nextInt();
        //nextInt = (nextInt == Integer.MIN_VALUE) ?
                //Integer.MAX_VALUE : Math.abs(nextInt);
        //return Integer.toString(nextInt, 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.917 -0400", hash_original_method = "2F687A14AA3727476BB6949A7966696D", hash_generated_method = "10B3ED1BE8BD8720E39A4A8629EEDB88")
    private String doubleQuote(String param) {
        String varB4EAC82CA7396A68D541C85D26508E83_896609708 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1162324385 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_896609708 = "\"" + param + "\"";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1162324385 = null;
        addTaint(param.getTaint());
        String varA7E53CE21691AB073D9660D615818899_737545155; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_737545155 = varB4EAC82CA7396A68D541C85D26508E83_896609708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_737545155 = varB4EAC82CA7396A68D541C85D26508E83_1162324385;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_737545155.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_737545155;
        // ---------- Original Method ----------
        //if (param != null) {
            //return "\"" + param + "\"";
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.918 -0400", hash_original_method = "85265833A731D9185DA35397C2BF1AAD", hash_generated_method = "1E0D72EFD58DC7560AD8C6398A57547E")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.918 -0400", hash_original_field = "7C8E6E744ADE74D7FCB99C3518DFFA34", hash_generated_field = "AF65CBC112AA6C1E2E348DC93D5BB6F1")

    private static String AUTHORIZATION_HEADER = "Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.918 -0400", hash_original_field = "83E9CB9D73BDEA162C1F761E11D38582", hash_generated_field = "95199902CB1B0CA3F9512C960D5AB924")

    private static String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.919 -0400", hash_original_field = "CC6051DDCF8265AA39F970CBDAF70626", hash_generated_field = "10E8B936E7F026B41A9464F94DC77E7F")

    public final static int MAX_REDIRECT_COUNT = 16;
}

