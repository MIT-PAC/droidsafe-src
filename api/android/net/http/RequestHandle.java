package android.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;

import android.net.ParseException;
import android.net.WebAddress;
import android.webkit.CookieManager;





public class RequestHandle {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.484 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.484 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.484 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "AD4E85AF09CC6305596E8DE3A73ABA21", hash_generated_field = "7A4E35082A966BF8F9758B373DCB600C")

    private int mRedirectCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.503 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "D52FB5C4B4CE262D3BDE3938D1D81A5F", hash_generated_method = "4114049E94DDE0F7E9634DC51B2E7D83")
    public  RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request) {
        if(headers == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "8F53D2F7ECBB6A0E31E2DA5BDF5FFE63", hash_generated_method = "67E345A2765639EB4D3F432B2F5705EC")
    public  RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request,
            Connection conn) {
        this(requestQueue, url, uri, method, headers, bodyProvider, bodyLength,
                request);
        addTaint(request.getTaint());
        addTaint(bodyLength);
        addTaint(bodyProvider.getTaint());
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(url.getTaint());
        addTaint(requestQueue.getTaint());
        mConnection = conn;
        // ---------- Original Method ----------
        //mConnection = conn;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "971FA82A9D84F9459C5196533729906E", hash_generated_method = "6AE939C06120ED8C23F94606DF68DFEC")
    public void cancel() {
        if(mRequest != null)        
        {
            mRequest.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.cancel();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "981EAB54F552460A30185E1B96B8DE52", hash_generated_method = "C92FEAF252960534BA9B0AD42F228FC3")
    public void pauseRequest(boolean pause) {
        addTaint(pause);
        if(mRequest != null)        
        {
            mRequest.setLoadingPaused(pause);
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.setLoadingPaused(pause);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "2C5209A970780A5B14F30F7C2DFA5DF9", hash_generated_method = "E8477B4F359CE64CB4CA30CA10362D7A")
    public void handleSslErrorResponse(boolean proceed) {
        addTaint(proceed);
        if(mRequest != null)        
        {
            mRequest.handleSslErrorResponse(proceed);
        } //End block
        // ---------- Original Method ----------
        //if (mRequest != null) {
            //mRequest.handleSslErrorResponse(proceed);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.504 -0400", hash_original_method = "1E2E2512E5F173592E2117FB4C479261", hash_generated_method = "DE11008A5A90D0A4A103FA521AACF0DC")
    public boolean isRedirectMax() {
        boolean varE59A16454EBA0506B8807ACFE87505C0_1901546934 = (mRedirectCount >= MAX_REDIRECT_COUNT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481124377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481124377;
        // ---------- Original Method ----------
        //return mRedirectCount >= MAX_REDIRECT_COUNT;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.505 -0400", hash_original_method = "3AC7970B74E2F8214DB13CA8BCAB44BF", hash_generated_method = "DEA44C88027A7873051FB74BF028090B")
    public int getRedirectCount() {
        int var5C719A8BE232C682CF3CBD6C1D4CA4E2_1612376767 = (mRedirectCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637488731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637488731;
        // ---------- Original Method ----------
        //return mRedirectCount;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.505 -0400", hash_original_method = "FFEBE76B00A2A9B427C3877CD59FFD71", hash_generated_method = "75F6E6041180F5755B1072705080BEBF")
    public void setRedirectCount(int count) {
        mRedirectCount = count;
        // ---------- Original Method ----------
        //mRedirectCount = count;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.505 -0400", hash_original_method = "44F47D5B04481BCE428881C329B8D0F8", hash_generated_method = "FBA471C8EC30A224BA91F15E39CF5536")
    public boolean setupRedirect(String redirectTo, int statusCode,
            Map<String, String> cacheHeaders) {
        addTaint(cacheHeaders.getTaint());
        addTaint(statusCode);
        if(HttpLog.LOGV)        
        {
            HttpLog.v("RequestHandle.setupRedirect(): redirectCount " +
                  mRedirectCount);
        } //End block
        mHeaders.remove(AUTHORIZATION_HEADER);
        mHeaders.remove(PROXY_AUTHORIZATION_HEADER);
        if(++mRedirectCount == MAX_REDIRECT_COUNT)        
        {
            if(HttpLog.LOGV)            
            HttpLog.v(
                    "RequestHandle.setupRedirect(): too many redirects " +
                    mRequest);
            mRequest.error(EventHandler.ERROR_REDIRECT_LOOP,
                           com.android.internal.R.string.httpErrorRedirectLoop);
            boolean var68934A3E9455FA72420237EB05902327_561999706 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137968478 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137968478;
        } //End block
        if(mUrl.startsWith("https:") && redirectTo.startsWith("http:"))        
        {
            if(HttpLog.LOGV)            
            {
                HttpLog.v("blowing away the referer on an https -> http redirect");
            } //End block
            mHeaders.remove("Referer");
        } //End block
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
        if(cookie != null && cookie.length() > 0)        
        {
            mHeaders.put("Cookie", cookie);
        } //End block
        if((statusCode == 302 || statusCode == 303) && mMethod.equals("POST"))        
        {
            if(HttpLog.LOGV)            
            {
                HttpLog.v("replacing POST with GET on redirect to " + redirectTo);
            } //End block
            mMethod = "GET";
        } //End block
        if(statusCode == 307)        
        {
            try 
            {
                if(mBodyProvider != null)                
                mBodyProvider.reset();
            } //End block
            catch (java.io.IOException ex)
            {
                if(HttpLog.LOGV)                
                {
                    HttpLog.v("setupRedirect() failed to reset body provider");
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_1776775851 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071236626 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071236626;
            } //End block
        } //End block
        else
        {
            mHeaders.remove("Content-Type");
            mBodyProvider = null;
        } //End block
        mHeaders.putAll(cacheHeaders);
        createAndQueueNewRequest();
        boolean varB326B5062B2F0E69046810717534CB09_85840114 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867347928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867347928;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.506 -0400", hash_original_method = "38ABF845B1FE2E62FC6D2FD8DBFFE504", hash_generated_method = "699DDDF0CFDB4063358F71CE3345BCBF")
    public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(isProxy);
        String response = computeBasicAuthResponse(username, password);
        if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.506 -0400", hash_original_method = "B5A5838E4BCFB5CBC22C9A029CA123B8", hash_generated_method = "BD748A60921D9EE33C6848578E6E4BB8")
    public void setupDigestAuthResponse(boolean isProxy,
                                        String username,
                                        String password,
                                        String realm,
                                        String nonce,
                                        String QOP,
                                        String algorithm,
                                        String opaque) {
        addTaint(opaque.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(QOP.getTaint());
        addTaint(nonce.getTaint());
        addTaint(realm.getTaint());
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(isProxy);
        String response = computeDigestAuthResponse(
                username, password, realm, nonce, QOP, algorithm, opaque);
        if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.506 -0400", hash_original_method = "671BE1071898035C0F84A86A39735052", hash_generated_method = "CE59BB3623DB558A429D15C7FCEF113F")
    private void setupAuthResponse() {
        try 
        {
            if(mBodyProvider != null)            
            mBodyProvider.reset();
        } //End block
        catch (java.io.IOException ex)
        {
            if(HttpLog.LOGV)            
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.506 -0400", hash_original_method = "E02C2F0EA498C425350A019498EEA751", hash_generated_method = "94330865D2B69EAC8E013BDCA3522BDA")
    public String getMethod() {
String var4E41053965FCD154582D303800DDC3B2_1031530164 =         mMethod;
        var4E41053965FCD154582D303800DDC3B2_1031530164.addTaint(taint);
        return var4E41053965FCD154582D303800DDC3B2_1031530164;
        // ---------- Original Method ----------
        //return mMethod;
    }

    
    @DSModeled(DSC.BAN)
    public static String computeBasicAuthResponse(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        return new String(Base64.encodeBase64((username + ':' + password).getBytes()));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.506 -0400", hash_original_method = "8819509041D3F58366571B93CC9E3D4B", hash_generated_method = "739C8F45FA1E2134F512E5E5B3753B74")
    public void waitUntilComplete() {
        mRequest.waitUntilComplete();
        // ---------- Original Method ----------
        //mRequest.waitUntilComplete();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.507 -0400", hash_original_method = "420B4AD7BC25160624AF5D40CF27D44F", hash_generated_method = "1B3B0D7106989F16033C678CA91170A5")
    public void processRequest() {
        if(mConnection != null)        
        {
            mConnection.processRequests(mRequest);
        } //End block
        // ---------- Original Method ----------
        //if (mConnection != null) {
            //mConnection.processRequests(mRequest);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.507 -0400", hash_original_method = "21566870DD44046714482EED382208F4", hash_generated_method = "DD4666E03B2EFA26A4C3BEAD9AAFDA0D")
    private String computeDigestAuthResponse(String username,
                                             String password,
                                             String realm,
                                             String nonce,
                                             String QOP,
                                             String algorithm,
                                             String opaque) {
        addTaint(opaque.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(QOP.getTaint());
        addTaint(nonce.getTaint());
        addTaint(realm.getTaint());
        addTaint(password.getTaint());
        addTaint(username.getTaint());
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
        if(opaque     != null)        
        {
            response += ", opaque=" + doubleQuote(opaque);
        } //End block
        if(algorithm != null)        
        {
            response += ", algorithm=" +  algorithm;
        } //End block
        if(QOP        != null)        
        {
            response += ", qop=" + QOP + ", nc=" + nc + ", cnonce=" + doubleQuote(cnonce);
        } //End block
String var2A1114F4272D753FE23A36E3D68CD293_987571034 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_987571034.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_987571034;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    public static String authorizationHeader(boolean isProxy) {
        if (!isProxy) {
            return AUTHORIZATION_HEADER;
        } else {
            return PROXY_AUTHORIZATION_HEADER;
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.508 -0400", hash_original_method = "7BFA5C62C730E408B108712B34B74DD9", hash_generated_method = "7F49DB11B561D243B1B781D45F470B94")
    private String computeDigest(
        String A1, String A2, String nonce, String QOP, String nc, String cnonce) {
        addTaint(cnonce.getTaint());
        addTaint(nc.getTaint());
        addTaint(QOP.getTaint());
        addTaint(nonce.getTaint());
        addTaint(A2.getTaint());
        addTaint(A1.getTaint());
        if(HttpLog.LOGV)        
        {
            HttpLog.v("computeDigest(): QOP: " + QOP);
        } //End block
        if(QOP == null)        
        {
String varBACC119C2FE5C504D92AB62D7F5EA510_2087243579 =             KD(H(A1), nonce + ":" + H(A2));
            varBACC119C2FE5C504D92AB62D7F5EA510_2087243579.addTaint(taint);
            return varBACC119C2FE5C504D92AB62D7F5EA510_2087243579;
        } //End block
        else
        {
            if(QOP.equalsIgnoreCase("auth"))            
            {
String var5E3449934C3AE858D8B440B5E65AE8BE_1316786774 =                 KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2));
                var5E3449934C3AE858D8B440B5E65AE8BE_1316786774.addTaint(taint);
                return var5E3449934C3AE858D8B440B5E65AE8BE_1316786774;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1051745648 =         null;
        var540C13E9E156B687226421B24F2DF178_1051745648.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1051745648;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.508 -0400", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "A36985067FEDCB73019ABB8AD7CA10F3")
    private String KD(String secret, String data) {
        addTaint(data.getTaint());
        addTaint(secret.getTaint());
String var76709ED9029AE93F2064A644EBA98F42_562725922 =         H(secret + ":" + data);
        var76709ED9029AE93F2064A644EBA98F42_562725922.addTaint(taint);
        return var76709ED9029AE93F2064A644EBA98F42_562725922;
        // ---------- Original Method ----------
        //return H(secret + ":" + data);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.508 -0400", hash_original_method = "ACD3D964B796417ECD09BF2089A3A365", hash_generated_method = "137F10664846ABEEEDC8A9B38D8D22E1")
    private String H(String param) {
        addTaint(param.getTaint());
        if(param != null)        
        {
            try 
            {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] d = md5.digest(param.getBytes());
                if(d != null)                
                {
String varFB7740F29172D304438A7CADAC1E8E80_246264436 =                     bufferToHex(d);
                    varFB7740F29172D304438A7CADAC1E8E80_246264436.addTaint(taint);
                    return varFB7740F29172D304438A7CADAC1E8E80_246264436;
                } //End block
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_2028170536 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_2028170536.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_2028170536;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_209407530 =         null;
        var540C13E9E156B687226421B24F2DF178_209407530.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_209407530;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_method = "F71FFAFC3CF70E71567406DE8A9A2D97", hash_generated_method = "045E67A75D624B415F591299241E06C6")
    private String bufferToHex(byte[] buffer) {
        addTaint(buffer[0]);
        final char hexChars[] = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
        if(buffer != null)        
        {
            int length = buffer.length;
            if(length > 0)            
            {
                StringBuilder hex = new StringBuilder(2 * length);
for(int i = 0;i < length;++i)
                {
                    byte l = (byte) (buffer[i] & 0x0F);
                    byte h = (byte)((buffer[i] & 0xF0) >> 4);
                    hex.append(hexChars[h]);
                    hex.append(hexChars[l]);
                } //End block
String varC16D6258A520FA38B307E45818772E68_1650031186 =                 hex.toString();
                varC16D6258A520FA38B307E45818772E68_1650031186.addTaint(taint);
                return varC16D6258A520FA38B307E45818772E68_1650031186;
            } //End block
            else
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_259707481 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_259707481.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_259707481;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_489464904 =         null;
        var540C13E9E156B687226421B24F2DF178_489464904.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_489464904;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_method = "15E2F72950F37D4FA5596F6CA90D9CCE", hash_generated_method = "BEE71CB25FE4AFAB0D5C90B46958CD2A")
    private String computeCnonce() {
        Random rand = new Random();
        int nextInt = rand.nextInt();
        nextInt = (nextInt == Integer.MIN_VALUE) ?
                Integer.MAX_VALUE : Math.abs(nextInt);
String var8C0C5094D0DCD3B77EA8304A17184C2B_1005609648 =         Integer.toString(nextInt, 16);
        var8C0C5094D0DCD3B77EA8304A17184C2B_1005609648.addTaint(taint);
        return var8C0C5094D0DCD3B77EA8304A17184C2B_1005609648;
        // ---------- Original Method ----------
        //Random rand = new Random();
        //int nextInt = rand.nextInt();
        //nextInt = (nextInt == Integer.MIN_VALUE) ?
                //Integer.MAX_VALUE : Math.abs(nextInt);
        //return Integer.toString(nextInt, 16);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_method = "2F687A14AA3727476BB6949A7966696D", hash_generated_method = "DDE7A79E60AC02569B5A3C73729C9BF0")
    private String doubleQuote(String param) {
        addTaint(param.getTaint());
        if(param != null)        
        {
String var3D10E606FCF443A3E81B3E215B7F39EB_1743352018 =             "\"" + param + "\"";
            var3D10E606FCF443A3E81B3E215B7F39EB_1743352018.addTaint(taint);
            return var3D10E606FCF443A3E81B3E215B7F39EB_1743352018;
        } //End block
String var540C13E9E156B687226421B24F2DF178_1650653515 =         null;
        var540C13E9E156B687226421B24F2DF178_1650653515.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1650653515;
        // ---------- Original Method ----------
        //if (param != null) {
            //return "\"" + param + "\"";
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_method = "85265833A731D9185DA35397C2BF1AAD", hash_generated_method = "2CF04E688B0D741F649E42844C4F44DD")
    private void createAndQueueNewRequest() {
        if(mConnection != null)        
        {
            RequestHandle newHandle = mRequestQueue.queueSynchronousRequest(
                    mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                    mBodyProvider, mBodyLength);
            mRequest = newHandle.mRequest;
            mConnection = newHandle.mConnection;
            newHandle.processRequest();
            return;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_field = "7C8E6E744ADE74D7FCB99C3518DFFA34", hash_generated_field = "C106D8C9CFB6EC8EB119C4D4A3AE867D")

    private final static String AUTHORIZATION_HEADER = "Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_field = "83E9CB9D73BDEA162C1F761E11D38582", hash_generated_field = "A4D8BBCAAE6782867BB51DD0431CE773")

    private final static String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.509 -0400", hash_original_field = "CC6051DDCF8265AA39F970CBDAF70626", hash_generated_field = "10E8B936E7F026B41A9464F94DC77E7F")

    public final static int MAX_REDIRECT_COUNT = 16;
}

