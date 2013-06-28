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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "AD4E85AF09CC6305596E8DE3A73ABA21", hash_generated_field = "7A4E35082A966BF8F9758B373DCB600C")

    private int mRedirectCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.196 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.197 -0400", hash_original_method = "D52FB5C4B4CE262D3BDE3938D1D81A5F", hash_generated_method = "F3F1D5CED65B10C65A5322626BC707F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.197 -0400", hash_original_method = "8F53D2F7ECBB6A0E31E2DA5BDF5FFE63", hash_generated_method = "1865F73EFD089C397C6EE29A9878838E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.197 -0400", hash_original_method = "971FA82A9D84F9459C5196533729906E", hash_generated_method = "B8DC4F3364076874DE3E56FBC9E5B41C")
    public void cancel() {
        {
            mRequest.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.198 -0400", hash_original_method = "981EAB54F552460A30185E1B96B8DE52", hash_generated_method = "64E5AEC4112F686D79C3149DDD6CBBF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.198 -0400", hash_original_method = "2C5209A970780A5B14F30F7C2DFA5DF9", hash_generated_method = "AA215AAF2F5C088AB202FA744ACC2877")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.198 -0400", hash_original_method = "1E2E2512E5F173592E2117FB4C479261", hash_generated_method = "A8BF3B15B58738688C23D859445DA48C")
    public boolean isRedirectMax() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791136718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791136718;
        // ---------- Original Method ----------
        //return mRedirectCount >= MAX_REDIRECT_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.198 -0400", hash_original_method = "3AC7970B74E2F8214DB13CA8BCAB44BF", hash_generated_method = "07FA6F1BA059CB85A6159BA68581AE0E")
    public int getRedirectCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921492774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921492774;
        // ---------- Original Method ----------
        //return mRedirectCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.199 -0400", hash_original_method = "FFEBE76B00A2A9B427C3877CD59FFD71", hash_generated_method = "75F6E6041180F5755B1072705080BEBF")
    public void setRedirectCount(int count) {
        mRedirectCount = count;
        // ---------- Original Method ----------
        //mRedirectCount = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.200 -0400", hash_original_method = "44F47D5B04481BCE428881C329B8D0F8", hash_generated_method = "CB90C31436545B4CA5CDF23F4A1F158C")
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
            boolean varD28027E3C8C66D5850ACF2C8E5F3A9AE_193737165 = (mUrl.startsWith("https:") && redirectTo.startsWith("http:"));
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
        String cookie = CookieManager.getInstance().getCookie(mUri);
        {
            boolean var6E2855FE1453DF0044F1B1E343DD13F2_1390340361 = (cookie != null && cookie.length() > 0);
            {
                mHeaders.put("Cookie", cookie);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF39D40D4EB771BAD1F65F2E1AED2EAA7_1775584652 = ((statusCode == 302 || statusCode == 303) && mMethod.equals("POST"));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697853624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697853624;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.201 -0400", hash_original_method = "38ABF845B1FE2E62FC6D2FD8DBFFE504", hash_generated_method = "F705F2B929521D6A539275A84D42CC47")
    public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        String response = computeBasicAuthResponse(username, password);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.201 -0400", hash_original_method = "B5A5838E4BCFB5CBC22C9A029CA123B8", hash_generated_method = "267371758B15DEEE82AA02C7AB6F574B")
    public void setupDigestAuthResponse(boolean isProxy,
                                        String username,
                                        String password,
                                        String realm,
                                        String nonce,
                                        String QOP,
                                        String algorithm,
                                        String opaque) {
        String response = computeDigestAuthResponse(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.202 -0400", hash_original_method = "671BE1071898035C0F84A86A39735052", hash_generated_method = "BDED742C89263CC4B8DD9B59171D8B71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.202 -0400", hash_original_method = "E02C2F0EA498C425350A019498EEA751", hash_generated_method = "8EE319F5B53344699D8733CC7777BC84")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1465553042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1465553042 = mMethod;
        varB4EAC82CA7396A68D541C85D26508E83_1465553042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465553042;
        // ---------- Original Method ----------
        //return mMethod;
    }

    
    public static String computeBasicAuthResponse(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        return new String(Base64.encodeBase64((username + ':' + password).getBytes()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.203 -0400", hash_original_method = "8819509041D3F58366571B93CC9E3D4B", hash_generated_method = "739C8F45FA1E2134F512E5E5B3753B74")
    public void waitUntilComplete() {
        mRequest.waitUntilComplete();
        // ---------- Original Method ----------
        //mRequest.waitUntilComplete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.203 -0400", hash_original_method = "420B4AD7BC25160624AF5D40CF27D44F", hash_generated_method = "F91A8CE46D61889C28091CE3D2FAC9BB")
    public void processRequest() {
        {
            mConnection.processRequests(mRequest);
        } //End block
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //mConnection.processRequests(mRequest);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.204 -0400", hash_original_method = "21566870DD44046714482EED382208F4", hash_generated_method = "C5AA56763D55ED245AFB99559681F6B0")
    private String computeDigestAuthResponse(String username,
                                             String password,
                                             String realm,
                                             String nonce,
                                             String QOP,
                                             String algorithm,
                                             String opaque) {
        String varB4EAC82CA7396A68D541C85D26508E83_726278664 = null; //Variable for return #1
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        Assert.assertNotNull(realm);
        String A1 = username + ":" + realm + ":" + password;
        String A2 = mMethod  + ":" + mUrl;
        String nc = "00000001";
        String cnonce = computeCnonce();
        String digest = computeDigest(A1, A2, nonce, QOP, nc, cnonce);
        String response = "";
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
        varB4EAC82CA7396A68D541C85D26508E83_726278664 = response;
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(realm.getTaint());
        addTaint(nonce.getTaint());
        addTaint(QOP.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(opaque.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_726278664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726278664;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.205 -0400", hash_original_method = "7BFA5C62C730E408B108712B34B74DD9", hash_generated_method = "08A2ADE6B9F515F963DDFE1B165639D2")
    private String computeDigest(
        String A1, String A2, String nonce, String QOP, String nc, String cnonce) {
        String varB4EAC82CA7396A68D541C85D26508E83_724345392 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2137092207 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1789188884 = null; //Variable for return #3
        {
            HttpLog.v("computeDigest(): QOP: " + QOP);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_724345392 = KD(H(A1), nonce + ":" + H(A2));
        } //End block
        {
            {
                boolean var787B3A44C2C97C691E216FE225E2DA94_1478127539 = (QOP.equalsIgnoreCase("auth"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2137092207 = KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2));
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1789188884 = null;
        addTaint(A1.getTaint());
        addTaint(A2.getTaint());
        addTaint(nonce.getTaint());
        addTaint(QOP.getTaint());
        addTaint(nc.getTaint());
        addTaint(cnonce.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1171998426; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1171998426 = varB4EAC82CA7396A68D541C85D26508E83_724345392;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1171998426 = varB4EAC82CA7396A68D541C85D26508E83_2137092207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1171998426 = varB4EAC82CA7396A68D541C85D26508E83_1789188884;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1171998426.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1171998426;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.206 -0400", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "7DD7B0B2808EA77FD0CEE48B9A79A845")
    private String KD(String secret, String data) {
        String varB4EAC82CA7396A68D541C85D26508E83_2132638973 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2132638973 = H(secret + ":" + data);
        addTaint(secret.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2132638973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132638973;
        // ---------- Original Method ----------
        //return H(secret + ":" + data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.206 -0400", hash_original_method = "ACD3D964B796417ECD09BF2089A3A365", hash_generated_method = "42E947F20AA27491C34F1103560C7678")
    private String H(String param) {
        String varB4EAC82CA7396A68D541C85D26508E83_1118314647 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1390022372 = null; //Variable for return #2
        {
            try 
            {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] d = md5.digest(param.getBytes());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1118314647 = bufferToHex(d);
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1390022372 = null;
        addTaint(param.getTaint());
        String varA7E53CE21691AB073D9660D615818899_166668184; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_166668184 = varB4EAC82CA7396A68D541C85D26508E83_1118314647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_166668184 = varB4EAC82CA7396A68D541C85D26508E83_1390022372;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_166668184.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_166668184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.207 -0400", hash_original_method = "F71FFAFC3CF70E71567406DE8A9A2D97", hash_generated_method = "47154D2BC198CE3E7A0B8D28CD9167AF")
    private String bufferToHex(byte[] buffer) {
        String varB4EAC82CA7396A68D541C85D26508E83_74595664 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_836748281 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1107790183 = null; //Variable for return #3
        final char hexChars[] = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
        {
            int length = buffer.length;
            {
                StringBuilder hex = new StringBuilder(2 * length);
                {
                    int i = 0;
                    {
                        byte l = (byte) (buffer[i] & 0x0F);
                        byte h = (byte)((buffer[i] & 0xF0) >> 4);
                        hex.append(hexChars[h]);
                        hex.append(hexChars[l]);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_74595664 = hex.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_836748281 = "";
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1107790183 = null;
        addTaint(buffer[0]);
        String varA7E53CE21691AB073D9660D615818899_1417212689; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1417212689 = varB4EAC82CA7396A68D541C85D26508E83_74595664;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1417212689 = varB4EAC82CA7396A68D541C85D26508E83_836748281;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1417212689 = varB4EAC82CA7396A68D541C85D26508E83_1107790183;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1417212689.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1417212689;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.208 -0400", hash_original_method = "15E2F72950F37D4FA5596F6CA90D9CCE", hash_generated_method = "746ACECBC079EE94D8D05D00FA7316AA")
    private String computeCnonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_1213688595 = null; //Variable for return #1
        Random rand = new Random();
        int nextInt = rand.nextInt();
        nextInt = (nextInt == Integer.MIN_VALUE) ?
                Integer.MAX_VALUE : Math.abs(nextInt);
        varB4EAC82CA7396A68D541C85D26508E83_1213688595 = Integer.toString(nextInt, 16);
        varB4EAC82CA7396A68D541C85D26508E83_1213688595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1213688595;
        // ---------- Original Method ----------
        //Random rand = new Random();
        //int nextInt = rand.nextInt();
        //nextInt = (nextInt == Integer.MIN_VALUE) ?
                //Integer.MAX_VALUE : Math.abs(nextInt);
        //return Integer.toString(nextInt, 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.209 -0400", hash_original_method = "2F687A14AA3727476BB6949A7966696D", hash_generated_method = "85C960216B3DE080EDC48F664942913C")
    private String doubleQuote(String param) {
        String varB4EAC82CA7396A68D541C85D26508E83_156910123 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1637422240 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_156910123 = "\"" + param + "\"";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1637422240 = null;
        addTaint(param.getTaint());
        String varA7E53CE21691AB073D9660D615818899_598755497; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_598755497 = varB4EAC82CA7396A68D541C85D26508E83_156910123;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_598755497 = varB4EAC82CA7396A68D541C85D26508E83_1637422240;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_598755497.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_598755497;
        // ---------- Original Method ----------
        //if (param != null) {
            //return "\"" + param + "\"";
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.210 -0400", hash_original_method = "85265833A731D9185DA35397C2BF1AAD", hash_generated_method = "B07BDE5E0A90312C5E2C7768FA7E7356")
    private void createAndQueueNewRequest() {
        {
            RequestHandle newHandle = mRequestQueue.queueSynchronousRequest(
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.210 -0400", hash_original_field = "7C8E6E744ADE74D7FCB99C3518DFFA34", hash_generated_field = "C106D8C9CFB6EC8EB119C4D4A3AE867D")

    private final static String AUTHORIZATION_HEADER = "Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.210 -0400", hash_original_field = "83E9CB9D73BDEA162C1F761E11D38582", hash_generated_field = "A4D8BBCAAE6782867BB51DD0431CE773")

    private final static String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.210 -0400", hash_original_field = "CC6051DDCF8265AA39F970CBDAF70626", hash_generated_field = "10E8B936E7F026B41A9464F94DC77E7F")

    public final static int MAX_REDIRECT_COUNT = 16;
}

