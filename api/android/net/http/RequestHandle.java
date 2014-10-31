package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
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

    /**
     * @return Basic-scheme authentication response: BASE64(username:password).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.849 -0500", hash_original_method = "42CF1F5E7BC0AA3F1D27BA5EA0C3DD7B", hash_generated_method = "44BBEB783C5B30D25CBE0F9EC02E9174")
    
public static String computeBasicAuthResponse(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);

        // encode username:password to base64
        return new String(Base64.encodeBase64((username + ':' + password).getBytes()));
    }

    /**
     * @return The right authorization header (dependeing on whether it is a proxy or not).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.858 -0500", hash_original_method = "44C07CF943292E50FD2430DAB9E2620B", hash_generated_method = "8BD52181178B5C6D24AA08F1B68E8D85")
    
public static String authorizationHeader(boolean isProxy) {
        if (!isProxy) {
            return AUTHORIZATION_HEADER;
        } else {
            return PROXY_AUTHORIZATION_HEADER;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.811 -0500", hash_original_field = "2E052F0F119F8F6EB96E81E0404AA563", hash_generated_field = "C106D8C9CFB6EC8EB119C4D4A3AE867D")

    private final static String AUTHORIZATION_HEADER = "Authorization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.813 -0500", hash_original_field = "E17CE4D19274DA0D144FDCA5E151B960", hash_generated_field = "A4D8BBCAAE6782867BB51DD0431CE773")

    private final static String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.815 -0500", hash_original_field = "E5E5DA09768657A7E46E1F11EF68CBB2", hash_generated_field = "10E8B936E7F026B41A9464F94DC77E7F")

    public final static int MAX_REDIRECT_COUNT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.789 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String        mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.791 -0500", hash_original_field = "DB3D2BD1CF0785D6513DCE03F6FD6846", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress    mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.793 -0500", hash_original_field = "FB63EE61CA76D9C9913EC87AD6B942C6", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String        mMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.795 -0500", hash_original_field = "A7D525FA609C0F6270055E985F097B79", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.797 -0500", hash_original_field = "2CFB054BACCE225829CD65D3DF87BAA7", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue  mRequestQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.799 -0500", hash_original_field = "480419B6BBB9A26A6DD8401352CF0FEE", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request       mRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.802 -0500", hash_original_field = "00BD06F3A68F022203FBFD258BDC707D", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream   mBodyProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.804 -0500", hash_original_field = "9F97B0948BBDDDA2CDEDF84C846F0425", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int           mBodyLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.806 -0500", hash_original_field = "4AF19CA66701C1CD4BEC3D41055A9465", hash_generated_field = "7A4E35082A966BF8F9758B373DCB600C")

    private int           mRedirectCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.808 -0500", hash_original_field = "D468AD0EA1184CE89FA8A45254E2CDD6", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection    mConnection;

    /**
     * Creates a new request session.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.819 -0500", hash_original_method = "D52FB5C4B4CE262D3BDE3938D1D81A5F", hash_generated_method = "59B476798D21930EEFFD1F6F1580AB72")
    
public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request) {

        if (headers == null) {
            headers = new HashMap<String, String>();
        }
        mHeaders = headers;
        mBodyProvider = bodyProvider;
        mBodyLength = bodyLength;
        mMethod = method == null? "GET" : method;

        mUrl = url;
        mUri = uri;

        mRequestQueue = requestQueue;

        mRequest = request;
    }

    /**
     * Creates a new request session with a given Connection. This connection
     * is used during a synchronous load to handle this request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.821 -0500", hash_original_method = "8F53D2F7ECBB6A0E31E2DA5BDF5FFE63", hash_generated_method = "8B09722F8726EB6D38E4B56998AB0953")
    
public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri,
            String method, Map<String, String> headers,
            InputStream bodyProvider, int bodyLength, Request request,
            Connection conn) {
        this(requestQueue, url, uri, method, headers, bodyProvider, bodyLength,
                request);
        mConnection = conn;
    }

    /**
     * Cancels this request
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.823 -0500", hash_original_method = "971FA82A9D84F9459C5196533729906E", hash_generated_method = "1D9B0C01B4EE18D26A2FED93B269F69A")
    
public void cancel() {
        if (mRequest != null) {
            mRequest.cancel();
        }
    }

    /**
     * Pauses the loading of this request. For example, called from the WebCore thread
     * when the plugin can take no more data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.825 -0500", hash_original_method = "981EAB54F552460A30185E1B96B8DE52", hash_generated_method = "7B3F6A231442AC50542E4942604901C3")
    
public void pauseRequest(boolean pause) {
        if (mRequest != null) {
            mRequest.setLoadingPaused(pause);
        }
    }

    /**
     * Handles SSL error(s) on the way down from the user (the user
     * has already provided their feedback).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.827 -0500", hash_original_method = "2C5209A970780A5B14F30F7C2DFA5DF9", hash_generated_method = "EC869BF9FC4BCA570DC9F4A5DABCF245")
    
public void handleSslErrorResponse(boolean proceed) {
        if (mRequest != null) {
            mRequest.handleSslErrorResponse(proceed);
        }
    }

    /**
     * @return true if we've hit the max redirect count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.829 -0500", hash_original_method = "1E2E2512E5F173592E2117FB4C479261", hash_generated_method = "529527AFFEE180D40D50918A86BD53CC")
    
public boolean isRedirectMax() {
        return mRedirectCount >= MAX_REDIRECT_COUNT;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.832 -0500", hash_original_method = "3AC7970B74E2F8214DB13CA8BCAB44BF", hash_generated_method = "2E435D44E0ED540C4EDE05E6BFEC6EB2")
    
public int getRedirectCount() {
        return mRedirectCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.834 -0500", hash_original_method = "FFEBE76B00A2A9B427C3877CD59FFD71", hash_generated_method = "CE218FE1A1A226D29E7CF87D57F50E01")
    
public void setRedirectCount(int count) {
        mRedirectCount = count;
    }

    /**
     * Create and queue a redirect request.
     *
     * @param redirectTo URL to redirect to
     * @param statusCode HTTP status code returned from original request
     * @param cacheHeaders Cache header for redirect URL
     * @return true if setup succeeds, false otherwise (redirect loop
     * count exceeded, body provider unable to rewind on 307 redirect)
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.838 -0500", hash_original_method = "44F47D5B04481BCE428881C329B8D0F8", hash_generated_method = "645616829187BBBB8CF50F5BD2423D58")
    
public boolean setupRedirect(String redirectTo, int statusCode,
            Map<String, String> cacheHeaders) {
        if (HttpLog.LOGV) {
            HttpLog.v("RequestHandle.setupRedirect(): redirectCount " +
                  mRedirectCount);
        }

        // be careful and remove authentication headers, if any
        mHeaders.remove(AUTHORIZATION_HEADER);
        mHeaders.remove(PROXY_AUTHORIZATION_HEADER);

        if (++mRedirectCount == MAX_REDIRECT_COUNT) {
            // Way too many redirects -- fail out
            if (HttpLog.LOGV) HttpLog.v(
                    "RequestHandle.setupRedirect(): too many redirects " +
                    mRequest);
            mRequest.error(EventHandler.ERROR_REDIRECT_LOOP,
                           com.android.internal.R.string.httpErrorRedirectLoop);
            return false;
        }

        if (mUrl.startsWith("https:") && redirectTo.startsWith("http:")) {
            // implement http://www.w3.org/Protocols/rfc2616/rfc2616-sec15.html#sec15.1.3
            if (HttpLog.LOGV) {
                HttpLog.v("blowing away the referer on an https -> http redirect");
            }
            mHeaders.remove("Referer");
        }

        mUrl = redirectTo;
        try {
            mUri = new WebAddress(mUrl);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // update the "Cookie" header based on the redirected url
        mHeaders.remove("Cookie");
        String cookie = CookieManager.getInstance().getCookie(mUri);
        if (cookie != null && cookie.length() > 0) {
            mHeaders.put("Cookie", cookie);
        }

        if ((statusCode == 302 || statusCode == 303) && mMethod.equals("POST")) {
            if (HttpLog.LOGV) {
                HttpLog.v("replacing POST with GET on redirect to " + redirectTo);
            }
            mMethod = "GET";
        }
        /* Only repost content on a 307.  If 307, reset the body
           provider so we can replay the body */
        if (statusCode == 307) {
            try {
                if (mBodyProvider != null) mBodyProvider.reset();
            } catch (java.io.IOException ex) {
                if (HttpLog.LOGV) {
                    HttpLog.v("setupRedirect() failed to reset body provider");
                }
                return false;
            }

        } else {
            mHeaders.remove("Content-Type");
            mBodyProvider = null;
        }

        // Update the cache headers for this URL
        mHeaders.putAll(cacheHeaders);

        createAndQueueNewRequest();
        return true;
    }

    /**
     * Create and queue an HTTP authentication-response (basic) request.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.840 -0500", hash_original_method = "38ABF845B1FE2E62FC6D2FD8DBFFE504", hash_generated_method = "B1BADAF3DE0D065DA4CB1870CFCB432C")
    
public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        String response = computeBasicAuthResponse(username, password);
        if (HttpLog.LOGV) {
            HttpLog.v("setupBasicAuthResponse(): response: " + response);
        }
        mHeaders.put(authorizationHeader(isProxy), "Basic " + response);
        setupAuthResponse();
    }

    /**
     * Create and queue an HTTP authentication-response (digest) request.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.842 -0500", hash_original_method = "B5A5838E4BCFB5CBC22C9A029CA123B8", hash_generated_method = "124878F8C78541F5A906608C9EA29D04")
    
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
        if (HttpLog.LOGV) {
            HttpLog.v("setupDigestAuthResponse(): response: " + response);
        }
        mHeaders.put(authorizationHeader(isProxy), "Digest " + response);
        setupAuthResponse();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.845 -0500", hash_original_method = "671BE1071898035C0F84A86A39735052", hash_generated_method = "776827DAC91D7FD5A39B2F56127E5F28")
    
private void setupAuthResponse() {
        try {
            if (mBodyProvider != null) mBodyProvider.reset();
        } catch (java.io.IOException ex) {
            if (HttpLog.LOGV) {
                HttpLog.v("setupAuthResponse() failed to reset body provider");
            }
        }
        createAndQueueNewRequest();
    }

    /**
     * @return HTTP request method (GET, PUT, etc).
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.847 -0500", hash_original_method = "E02C2F0EA498C425350A019498EEA751", hash_generated_method = "1C2EAF92FC42C6E1A4C4DB991962A8CD")
    
public String getMethod() {
        return mMethod;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.851 -0500", hash_original_method = "8819509041D3F58366571B93CC9E3D4B", hash_generated_method = "45A69B26A5FA3C898A9821BB21614E1A")
    
public void waitUntilComplete() {
        mRequest.waitUntilComplete();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.853 -0500", hash_original_method = "420B4AD7BC25160624AF5D40CF27D44F", hash_generated_method = "D24226A77585A40164D7C40C2313BFF9")
    
public void processRequest() {
        if (mConnection != null) {
            mConnection.processRequests(mRequest);
        }
    }

    /**
     * @return Digest-scheme authentication response.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.856 -0500", hash_original_method = "21566870DD44046714482EED382208F4", hash_generated_method = "60D8916D334F405ACB538747C52F509E")
    
private String computeDigestAuthResponse(String username,
                                             String password,
                                             String realm,
                                             String nonce,
                                             String QOP,
                                             String algorithm,
                                             String opaque) {

        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        Assert.assertNotNull(realm);

        String A1 = username + ":" + realm + ":" + password;
        String A2 = mMethod  + ":" + mUrl;

        // because we do not preemptively send authorization headers, nc is always 1
        String nc = "00000001";
        String cnonce = computeCnonce();
        String digest = computeDigest(A1, A2, nonce, QOP, nc, cnonce);

        String response = "";
        response += "username=" + doubleQuote(username) + ", ";
        response += "realm="    + doubleQuote(realm)    + ", ";
        response += "nonce="    + doubleQuote(nonce)    + ", ";
        response += "uri="      + doubleQuote(mUrl)     + ", ";
        response += "response=" + doubleQuote(digest) ;

        if (opaque     != null) {
            response += ", opaque=" + doubleQuote(opaque);
        }

         if (algorithm != null) {
            response += ", algorithm=" +  algorithm;
        }

        if (QOP        != null) {
            response += ", qop=" + QOP + ", nc=" + nc + ", cnonce=" + doubleQuote(cnonce);
        }

        return response;
    }

    /**
     * @return Double-quoted MD5 digest.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.861 -0500", hash_original_method = "7BFA5C62C730E408B108712B34B74DD9", hash_generated_method = "F17F11D9C5498EE34A44618AA68578AD")
    
private String computeDigest(
        String A1, String A2, String nonce, String QOP, String nc, String cnonce) {
        if (HttpLog.LOGV) {
            HttpLog.v("computeDigest(): QOP: " + QOP);
        }

        if (QOP == null) {
            return KD(H(A1), nonce + ":" + H(A2));
        } else {
            if (QOP.equalsIgnoreCase("auth")) {
                return KD(H(A1), nonce + ":" + nc + ":" + cnonce + ":" + QOP + ":" + H(A2));
            }
        }

        return null;
    }

    /**
     * @return MD5 hash of concat(secret, ":", data).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.863 -0500", hash_original_method = "BB88C0CE3A8E823447F9A5A2F73C21EF", hash_generated_method = "50F85659DEA13CCAFEE056A850521A94")
    
private String KD(String secret, String data) {
        return H(secret + ":" + data);
    }

    /**
     * @return MD5 hash of param.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.865 -0500", hash_original_method = "ACD3D964B796417ECD09BF2089A3A365", hash_generated_method = "E08F886E24F2027701A43E15B16E27EC")
    
private String H(String param) {
        if (param != null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");

                byte[] d = md5.digest(param.getBytes());
                if (d != null) {
                    return bufferToHex(d);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    /**
     * @return HEX buffer representation.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.868 -0500", hash_original_method = "F71FFAFC3CF70E71567406DE8A9A2D97", hash_generated_method = "8DFED4BB99AB8AC9203E4DAE99D4C7E9")
    
private String bufferToHex(byte[] buffer) {
        final char hexChars[] =
            { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };

        if (buffer != null) {
            int length = buffer.length;
            if (length > 0) {
                StringBuilder hex = new StringBuilder(2 * length);

                for (int i = 0; i < length; ++i) {
                    byte l = (byte) (buffer[i] & 0x0F);
                    byte h = (byte)((buffer[i] & 0xF0) >> 4);

                    hex.append(hexChars[h]);
                    hex.append(hexChars[l]);
                }

                return hex.toString();
            } else {
                return "";
            }
        }

        return null;
    }

    /**
     * Computes a random cnonce value based on the current time.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.870 -0500", hash_original_method = "15E2F72950F37D4FA5596F6CA90D9CCE", hash_generated_method = "40216FE3F4C9B2893429DFE030BBF9D9")
    
private String computeCnonce() {
        Random rand = new Random();
        int nextInt = rand.nextInt();
        nextInt = (nextInt == Integer.MIN_VALUE) ?
                Integer.MAX_VALUE : Math.abs(nextInt);
        return Integer.toString(nextInt, 16);
    }

    /**
     * "Double-quotes" the argument.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.872 -0500", hash_original_method = "2F687A14AA3727476BB6949A7966696D", hash_generated_method = "C526E32916C0209761BD154F36DD7C08")
    
private String doubleQuote(String param) {
        if (param != null) {
            return "\"" + param + "\"";
        }

        return null;
    }

    /**
     * Creates and queues new request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.875 -0500", hash_original_method = "85265833A731D9185DA35397C2BF1AAD", hash_generated_method = "3680A25A8219A45DFCC50FEC17B62D94")
    
private void createAndQueueNewRequest() {
        // mConnection is non-null if and only if the requests are synchronous.
        if (mConnection != null) {
            RequestHandle newHandle = mRequestQueue.queueSynchronousRequest(
                    mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                    mBodyProvider, mBodyLength);
            mRequest = newHandle.mRequest;
            mConnection = newHandle.mConnection;
            newHandle.processRequest();
            return;
        }
        mRequest = mRequestQueue.queueRequest(
                mUrl, mUri, mMethod, mHeaders, mRequest.mEventHandler,
                mBodyProvider,
                mBodyLength).mRequest;
    }
}

