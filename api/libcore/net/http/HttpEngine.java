package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import libcore.io.IoUtils;
import libcore.io.Streams;
import libcore.util.EmptyArray;





public class HttpEngine {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "60701D148EA544EC619E42C145DBE5D2", hash_generated_field = "70D4CCFAF8B3B7A40157E10CDA810E11")

    private static final CacheResponse BAD_GATEWAY_RESPONSE = new CacheResponse() {        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.900 -0400", hash_original_method = "298484AFDF3A781562203CC307227E59", hash_generated_method = "4AC198B3799A4E6C153BB0E3767B570C")
        @Override
        public Map<String, List<String>> getHeaders() throws IOException {
            Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1311695048 = null; 
            Map<String, List<String>> result = new HashMap<String, List<String>>();
            result.put(null, Collections.singletonList("HTTP/1.1 502 Bad Gateway"));
            varB4EAC82CA7396A68D541C85D26508E83_1311695048 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1311695048.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1311695048;
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_method = "2EDDCBB89487588B780135D7543EF20D", hash_generated_method = "62660BC4776DC3DF42BA4F8532D0F964")
        @Override
        public InputStream getBody() throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_819456721 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_819456721 = new ByteArrayInputStream(EmptyArray.BYTE);
            varB4EAC82CA7396A68D541C85D26508E83_819456721.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_819456721;
            
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.745 -0500", hash_original_field = "71E4A1B61996B4714B21AC880E6573CF", hash_generated_field = "7F4ADBCA37973EB3682CE87E78171DEC")

    private static final int MAX_REQUEST_BUFFER_LENGTH = 32768;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.748 -0500", hash_original_field = "2E3E1427D0A87617587C5718D1AC9576", hash_generated_field = "526B3DFF23C5F0AAA59C478051D61F5E")


    public static final int DEFAULT_CHUNK_LENGTH = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.751 -0500", hash_original_field = "2BFCDBC4D15A8D2D0DD4C25CACC26DAF", hash_generated_field = "24A290CCF11DC3C02C7E5FA56409A521")


    public static final String OPTIONS = "OPTIONS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.753 -0500", hash_original_field = "10AF61422A24A378ED95F1EF687B9A1F", hash_generated_field = "C8F8EB1723A4F1459E76ECA7A1B4FFEB")

    public static final String GET = "GET";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.756 -0500", hash_original_field = "4AA81810FACC66D6279BC28A2F968515", hash_generated_field = "9D4D54DDE764894645FC52FC91277E50")

    public static final String HEAD = "HEAD";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.758 -0500", hash_original_field = "328F6D727B6CE1392BE795C362FE8E1F", hash_generated_field = "E1CC0B0C363C6ED3911B7D42106C6309")

    public static final String POST = "POST";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.761 -0500", hash_original_field = "8CD68EE517FFA09A5FA8E258E0CBE9C4", hash_generated_field = "0C7FB5010BE834F9DA1BFD4988D58338")

    public static final String PUT = "PUT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.764 -0500", hash_original_field = "58BC25436877D6D8162996AFB7AE05FE", hash_generated_field = "1B51986BA354384092C9D21D57469B62")

    public static final String DELETE = "DELETE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.766 -0500", hash_original_field = "A9DE25AC279C7B0BBA91FB382CE62389", hash_generated_field = "0B4C0DE7A5C62D773DAD965884CD9ABC")

    public static final String TRACE = "TRACE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.769 -0500", hash_original_field = "515C39A5956A94CA3F057718F987A789", hash_generated_field = "6A7F1D2ACB0C8D38F6BE4D6916E1666A")

    public static final String CONNECT = "CONNECT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.771 -0500", hash_original_field = "6FD7E4F4D3D86B82BA90F88DABB4D35C", hash_generated_field = "8107271903E3CAA2DAF157178E86D883")


    public static final int HTTP_CONTINUE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.774 -0500", hash_original_field = "A17A4C4D7278FA812EB1A67C7FB9397B", hash_generated_field = "B2E878E710839ED7576796ECBCA1C49C")

    public static final int MAX_REDIRECTS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.776 -0500", hash_original_field = "BC2F63A3FB82E1A74A51D912075DAD68", hash_generated_field = "10F140AB3529378738DBDEC5DAB46D42")


    protected  HttpURLConnectionImpl policy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.779 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")


    protected  String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.781 -0500", hash_original_field = "924F241A914C4F1BE86C8DF9352806E2", hash_generated_field = "F290F176FDAB7CFB2CA524D383F761B2")


    private ResponseSource responseSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.783 -0500", hash_original_field = "AE38A985D619D0F31E0BB6FB9A666A33", hash_generated_field = "75AB93228F6DCAE1755313947EC33E63")


    protected HttpConnection connection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.785 -0500", hash_original_field = "E609FD18DA0EEC4EBA859423D528B226", hash_generated_field = "933C36367DBB638C304659EC3CE47516")

    private InputStream socketIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.787 -0500", hash_original_field = "E040E41AD170B59C0C0B918B5BFE7983", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.789 -0500", hash_original_field = "5ECB718907C7239E28173E0EE18D4BA6", hash_generated_field = "39983E65AC7A55E9EA11E4F742E77B1E")

    private OutputStream requestOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.792 -0500", hash_original_field = "F8E0C17D2A8C8C239AD479623A6C507B", hash_generated_field = "C2D66FBA681404DC7AF350EE623C0860")

    private AbstractHttpOutputStream requestBodyOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.794 -0500", hash_original_field = "5ED4CB8177056011DDD45274602E42A4", hash_generated_field = "3B099B70D4FFF6286391C7CE8061D62D")


    private InputStream responseBodyIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.797 -0500", hash_original_field = "F32BE2E33EB97B2FBBF8B367FA8E92EC", hash_generated_field = "1F19E961A3B4F1C13A1EF03108380C81")


    private final ResponseCache responseCache = ResponseCache.getDefault();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.799 -0500", hash_original_field = "415C41BDC07E9E1383745C36A187F5BC", hash_generated_field = "AD49865A8688A75CE7F76CFDCE3EF6E0")

    private CacheResponse cacheResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.801 -0500", hash_original_field = "97A12F2DE32E30A9797715E5B9BFAAFA", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.803 -0500", hash_original_field = "25AE3A7BA95196031213EED5388863F4", hash_generated_field = "56E6E961645E2EBB7A5C3DD20FD9692C")

    private long sentRequestMillis = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.806 -0500", hash_original_field = "34ABDB33EFC7B7E80AF155018C329827", hash_generated_field = "4EBB07D2648B3D849030D220C4A105C6")

    private boolean transparentGzip;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.808 -0500", hash_original_field = "28AC40F22099010DD7EC3C28A2701903", hash_generated_field = "28AC40F22099010DD7EC3C28A2701903")


    boolean sendChunked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.810 -0500", hash_original_field = "7BCAE6967DFDC448294B4940D749F7DF", hash_generated_field = "FA5FD96433C1E24F45D753FFBAA35249")

    // TODO: is HTTP minor version tracked across HttpEngines?
    private int httpMinorVersion = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.813 -0500", hash_original_field = "1154143EF3A042E6515BD6D5B42C64B6", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")


    private  URI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.815 -0500", hash_original_field = "1F81110C7E45C57EBE0824043088AAA4", hash_generated_field = "080B467195B9452EC670BEC2B6B507A0")


    private  RequestHeaders requestHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.817 -0500", hash_original_field = "5CFE3D9E08F1D0C335CC4F61BC07F951", hash_generated_field = "88AD2D36D7618A24DA38DA33CE55CF56")

    private ResponseHeaders responseHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.820 -0500", hash_original_field = "334780DD9969EFDBBB82DFCEBB0BAF55", hash_generated_field = "FFEE168D4CB4772A0F008367723F4DCB")

    private ResponseHeaders cachedResponseHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.822 -0500", hash_original_field = "E355BFD76E46CBC15EEE735A407BA2CD", hash_generated_field = "9AC6636989AABA65466C0761ABE1A1EE")

    private InputStream cachedResponseBody;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.824 -0500", hash_original_field = "8339FBAF1E3FDA35FCFAE8B5D14A313C", hash_generated_field = "583B8E5019F7D6ABD319DE61C9CB145F")

    private boolean automaticallyReleaseConnectionToPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.827 -0500", hash_original_field = "75D631072BB2C268C3A5C80C3DC9E1D9", hash_generated_field = "0385A75ADFAFB5B890C6C920CD19DE25")

    private boolean connectionReleased;

    /**
     * @param requestHeaders the client's supplied request headers. This class
     *     creates a private copy that it can mutate.
     * @param connection the connection used for an intermediate response
     *     immediately prior to this request/response pair, such as a same-host
     *     redirect. This engine assumes ownership of the connection and must
     *     release it when it is unneeded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.830 -0500", hash_original_method = "40A41D57A5E6AC75A04C66EEBA0108AA", hash_generated_method = "0FC203CBCFF1F7FADBA1F6392B2DB407")
    
public HttpEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBodyOut) throws IOException {
        this.policy = policy;
        this.method = method;
        this.connection = connection;
        this.requestBodyOut = requestBodyOut;

        try {
            uri = policy.getURL().toURILenient();
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }

        this.requestHeaders = new RequestHeaders(uri, new RawHeaders(requestHeaders));
    }

    /**
     * Figures out what the response source will be, and opens a socket to that
     * source if necessary. Prepares the request headers and gets ready to start
     * writing the request body if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.833 -0500", hash_original_method = "B90EC93300E2D6FABAAF6B3D0678EFB4", hash_generated_method = "BF697BEF0C89754BDCE10554BD503811")
    
public final void sendRequest() throws IOException {
        if (responseSource != null) {
            return;
        }

        prepareRawRequestHeaders();
        initResponseSource();
        if (responseCache instanceof HttpResponseCache) {
            ((HttpResponseCache) responseCache).trackResponse(responseSource);
        }

        /*
         * The raw response source may require the network, but the request
         * headers may forbid network use. In that case, dispose of the network
         * response and use a BAD_GATEWAY response instead.
         */
        if (requestHeaders.isOnlyIfCached() && responseSource.requiresConnection()) {
            if (responseSource == ResponseSource.CONDITIONAL_CACHE) {
                IoUtils.closeQuietly(cachedResponseBody);
            }
            this.responseSource = ResponseSource.CACHE;
            this.cacheResponse = BAD_GATEWAY_RESPONSE;
            RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(cacheResponse.getHeaders());
            setResponse(new ResponseHeaders(uri, rawResponseHeaders), cacheResponse.getBody());
        }

        if (responseSource.requiresConnection()) {
            sendSocketRequest();
        } else if (connection != null) {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        }
    }

    /**
     * Initialize the source for this response. It may be corrected later if the
     * request headers forbids network use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.836 -0500", hash_original_method = "F2FA78DDC7B88A7A9FD4B961BDAA52C1", hash_generated_method = "63BBF6DB5D50663DB139C7C5EBEDDCFA")
    
private void initResponseSource() throws IOException {
        responseSource = ResponseSource.NETWORK;
        if (!policy.getUseCaches() || responseCache == null) {
            return;
        }

        CacheResponse candidate = responseCache.get(uri, method,
                requestHeaders.getHeaders().toMultimap());
        if (candidate == null) {
            return;
        }

        Map<String, List<String>> responseHeadersMap = candidate.getHeaders();
        cachedResponseBody = candidate.getBody();
        if (!acceptCacheResponseType(candidate)
                || responseHeadersMap == null
                || cachedResponseBody == null) {
            IoUtils.closeQuietly(cachedResponseBody);
            return;
        }

        RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(responseHeadersMap);
        cachedResponseHeaders = new ResponseHeaders(uri, rawResponseHeaders);
        long now = System.currentTimeMillis();
        this.responseSource = cachedResponseHeaders.chooseResponseSource(now, requestHeaders);
        if (responseSource == ResponseSource.CACHE) {
            this.cacheResponse = candidate;
            setResponse(cachedResponseHeaders, cachedResponseBody);
        } else if (responseSource == ResponseSource.CONDITIONAL_CACHE) {
            this.cacheResponse = candidate;
        } else if (responseSource == ResponseSource.NETWORK) {
            IoUtils.closeQuietly(cachedResponseBody);
        } else {
            throw new AssertionError();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.838 -0500", hash_original_method = "22FB1B3BCF67C2C3EB9ADF307D5A559C", hash_generated_method = "69B7F3F2C95A5D965750F8E338F9A51C")
    
private void sendSocketRequest() throws IOException {
        if (connection == null) {
            connect();
        }

        if (socketOut != null || requestOut != null || socketIn != null) {
            throw new IllegalStateException();
        }

        socketOut = connection.getOutputStream();
        requestOut = socketOut;
        socketIn = connection.getInputStream();

        if (hasRequestBody()) {
            initRequestBodyOut();
        }
    }

    /**
     * Connect to the origin server either directly or via a proxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.841 -0500", hash_original_method = "2D119148BD5E3059D34FC5038B3E143C", hash_generated_method = "176F3D8C6FE354AE4D70B93F612E0F6F")
    
protected void connect() throws IOException {
        if (connection == null) {
            connection = openSocketConnection();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.843 -0500", hash_original_method = "191E23F5B6629C7E64418EFD4A3F2A23", hash_generated_method = "C831D921BACD25A91FAC3976B25B07EF")
    
protected final HttpConnection openSocketConnection() throws IOException {
        HttpConnection result = HttpConnection.connect(
                uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        Proxy proxy = result.getAddress().getProxy();
        if (proxy != null) {
            policy.setProxy(proxy);
        }
        result.setSoTimeout(policy.getReadTimeout());
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.846 -0500", hash_original_method = "54D96F75BB859B6FCC0E9DF779F84B99", hash_generated_method = "F80D04149E181930BD22469683C1F1AF")
    
protected void initRequestBodyOut() throws IOException {
        int chunkLength = policy.getChunkLength();
        if (chunkLength > 0 || requestHeaders.isChunked()) {
            sendChunked = true;
            if (chunkLength == -1) {
                chunkLength = DEFAULT_CHUNK_LENGTH;
            }
        }

        if (socketOut == null) {
            throw new IllegalStateException("No socket to write to; was a POST cached?");
        }

        if (httpMinorVersion == 0) {
            sendChunked = false;
        }

        int fixedContentLength = policy.getFixedContentLength();
        if (requestBodyOut != null) {
            // request body was already initialized by the predecessor HTTP engine
        } else if (fixedContentLength != -1) {
            writeRequestHeaders(fixedContentLength);
            requestBodyOut = new FixedLengthOutputStream(requestOut, fixedContentLength);
        } else if (sendChunked) {
            writeRequestHeaders(-1);
            requestBodyOut = new ChunkedOutputStream(requestOut, chunkLength);
        } else if (requestHeaders.getContentLength() != -1) {
            writeRequestHeaders(requestHeaders.getContentLength());
            requestBodyOut = new RetryableOutputStream(requestHeaders.getContentLength());
        } else {
            requestBodyOut = new RetryableOutputStream();
        }
    }

    /**
     * @param body the response body, or null if it doesn't exist or isn't
     *     available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.849 -0500", hash_original_method = "5E913F4CB8B308A1D4F5DA7B9ED80F77", hash_generated_method = "E6E4CF9CD9194BB7901961E73910EF6E")
    
private void setResponse(ResponseHeaders headers, InputStream body) throws IOException {
        if (this.responseBodyIn != null) {
            throw new IllegalStateException();
        }
        this.responseHeaders = headers;
        this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
        if (body != null) {
            initContentStream(body);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.851 -0500", hash_original_method = "A2A25877F13CAB8F3B2570F0DD573D04", hash_generated_method = "1B1480E1DE1241B9E592429EF05A5860")
    
private boolean hasRequestBody() {
        return method == POST || method == PUT;
    }

    /**
     * Returns the request body or null if this request doesn't have a body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.853 -0500", hash_original_method = "C7FD66AD45D049BA30B9133E737F62A7", hash_generated_method = "53BF77AF6A8691BA92C8F88155595322")
    
public final OutputStream getRequestBody() {
        if (responseSource == null) {
            throw new IllegalStateException();
        }
        return requestBodyOut;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.855 -0500", hash_original_method = "9AE95190B8E2C9C0E3A7C6677534EAD2", hash_generated_method = "A9D168ADC2EF072958C23D95839E002A")
    
public final boolean hasResponse() {
        return responseHeaders != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.858 -0500", hash_original_method = "22C8454720634D9B77E5CFB8983F80A0", hash_generated_method = "02F41DF7F7A1858962FA13981BDAC846")
    
public final RequestHeaders getRequestHeaders() {
        return requestHeaders;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.860 -0500", hash_original_method = "4093002B56979B81D9123217E2215EFB", hash_generated_method = "F9693C6061E36D95D0309B311F2ED75F")
    
public final ResponseHeaders getResponseHeaders() {
        if (responseHeaders == null) {
            throw new IllegalStateException();
        }
        return responseHeaders;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.863 -0500", hash_original_method = "6C8D632B120ECD201D125D0086576F82", hash_generated_method = "AAB82CAFB7994A6188AD7916C188EF54")
    
public final int getResponseCode() {
        if (responseHeaders == null) {
            throw new IllegalStateException();
        }
        return responseHeaders.getHeaders().getResponseCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.866 -0500", hash_original_method = "FBE346C8B51CB8E76028C21E64D6BD0A", hash_generated_method = "47815E2B7D18C2A2B3BC3DE0A267E2F9")
    
public final InputStream getResponseBody() {
        if (responseHeaders == null) {
            throw new IllegalStateException();
        }
        return responseBodyIn;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.868 -0500", hash_original_method = "2250F4C87B4A22443F60D9654505E9D2", hash_generated_method = "22CE870DF0278216D05BA2DA1EB45DBA")
    
public final CacheResponse getCacheResponse() {
        if (responseHeaders == null) {
            throw new IllegalStateException();
        }
        return cacheResponse;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.871 -0500", hash_original_method = "9105CAFA0117096F163A50885E7429CB", hash_generated_method = "6A520A14FC52B7C6F450740896192E16")
    
public final HttpConnection getConnection() {
        return connection;
    }

    /**
     * Returns true if {@code cacheResponse} is of the right type. This
     * condition is necessary but not sufficient for the cached response to
     * be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.873 -0500", hash_original_method = "A7591895A9BC485B929D9D45A1C9BC76", hash_generated_method = "35467ED1C5B936AB1F038E4E05D70FC5")
    
protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.875 -0500", hash_original_method = "E0679987436CD4859195D8429BAB78FF", hash_generated_method = "E23E9C4FC4CF9C5F8A3C46AE4B172F18")
    
private void maybeCache() throws IOException {
        // Are we caching at all?
        if (!policy.getUseCaches() || responseCache == null) {
            return;
        }

        // Should we cache this response for this request?
        if (!responseHeaders.isCacheable(requestHeaders)) {
            return;
        }

        // Offer this request to the cache.
        cacheRequest = responseCache.put(uri, getHttpConnectionToCache());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.877 -0500", hash_original_method = "CA4844B1B3E4576C0EA18E04D34BB6CE", hash_generated_method = "0CB7E2BECC7A563C74D8F00B395779E9")
    
protected HttpURLConnection getHttpConnectionToCache() {
        return policy;
    }

    /**
     * Cause the socket connection to be released to the connection pool when
     * it is no longer needed. If it is already unneeded, it will be pooled
     * immediately.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.879 -0500", hash_original_method = "5482932EB1112689442580A552BBCA6A", hash_generated_method = "A4DC5A2D85DC90524D819CAEFED47975")
    
public final void automaticallyReleaseConnectionToPool() {
        automaticallyReleaseConnectionToPool = true;
        if (connection != null && connectionReleased) {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        }
    }

    /**
     * Releases this engine so that its resources may be either reused or
     * closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.882 -0500", hash_original_method = "648343BC3C2ABC6FA7BF932A2F48012C", hash_generated_method = "6162AA3C31C04BACE391181FBC2BC931")
    
public final void release(boolean reusable) {
        // If the response body comes from the cache, close it.
        if (responseBodyIn == cachedResponseBody) {
            IoUtils.closeQuietly(responseBodyIn);
        }

        if (!connectionReleased && connection != null) {
            connectionReleased = true;

            // We cannot reuse sockets that have incomplete output.
            if (requestBodyOut != null && !requestBodyOut.closed) {
                reusable = false;
            }

            // If the headers specify that the connection shouldn't be reused, don't reuse it.
            if (hasConnectionCloseHeader()) {
                reusable = false;
            }

            if (responseBodyIn instanceof UnknownLengthHttpInputStream) {
                reusable = false;
            }

            if (reusable && responseBodyIn != null) {
                // We must discard the response body before the connection can be reused.
                try {
                    Streams.skipAll(responseBodyIn);
                } catch (IOException e) {
                    reusable = false;
                }
            }

            if (!reusable) {
                connection.closeSocketAndStreams();
                connection = null;
            } else if (automaticallyReleaseConnectionToPool) {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.884 -0500", hash_original_method = "EC59FCFED738418E26EF637931185263", hash_generated_method = "47CEDA878E29E8253FD896EB41564424")
    
private void initContentStream(InputStream transferStream) throws IOException {
        if (transparentGzip && responseHeaders.isContentEncodingGzip()) {
            /*
             * If the response was transparently gzipped, remove the gzip header field
             * so clients don't double decompress. http://b/3009828
             */
            responseHeaders.stripContentEncoding();
            responseBodyIn = new GZIPInputStream(transferStream);
        } else {
            responseBodyIn = transferStream;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.887 -0500", hash_original_method = "1AB921196A345CEE857EE600A5FD99DD", hash_generated_method = "D1494369BCA92FC7C8183D9EC8CE750F")
    
private InputStream getTransferStream() throws IOException {
        if (!hasResponseBody()) {
            return new FixedLengthInputStream(socketIn, cacheRequest, this, 0);
        }

        if (responseHeaders.isChunked()) {
            return new ChunkedInputStream(socketIn, cacheRequest, this);
        }

        if (responseHeaders.getContentLength() != -1) {
            return new FixedLengthInputStream(socketIn, cacheRequest, this,
                    responseHeaders.getContentLength());
        }

        /*
         * Wrap the input stream from the HttpConnection (rather than
         * just returning "socketIn" directly here), so that we can control
         * its use after the reference escapes.
         */
        return new UnknownLengthHttpInputStream(socketIn, cacheRequest, this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.890 -0500", hash_original_method = "E5EB74DB686CEF76B63FEE327FA34FC3", hash_generated_method = "4C599CD8FC75AF1A95F875902AB76F4A")
    
private void readResponseHeaders() throws IOException {
        RawHeaders headers;
        do {
            headers = new RawHeaders();
            headers.setStatusLine(Streams.readAsciiLine(socketIn));
            readHeaders(headers);
        } while (headers.getResponseCode() == HTTP_CONTINUE);
        setResponse(new ResponseHeaders(uri, headers), null);
    }

    /**
     * Returns true if the response must have a (possibly 0-length) body.
     * See RFC 2616 section 4.3.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.893 -0500", hash_original_method = "C50EFF03D3756AF141D5513AF20FE391", hash_generated_method = "3D009BCAD09D69EB922B16BA96223D20")
    
public final boolean hasResponseBody() {
        int responseCode = responseHeaders.getHeaders().getResponseCode();
        if (method != HEAD
                && method != CONNECT
                && (responseCode < HTTP_CONTINUE || responseCode >= 200)
                && responseCode != HttpURLConnectionImpl.HTTP_NO_CONTENT
                && responseCode != HttpURLConnectionImpl.HTTP_NOT_MODIFIED) {
            return true;
        }

        /*
         * If the Content-Length or Transfer-Encoding headers disagree with the
         * response code, the response is malformed. For best compatibility, we
         * honor the headers.
         */
        if (responseHeaders.getContentLength() != -1 || responseHeaders.isChunked()) {
            return true;
        }

        return false;
    }

    /**
     * Trailers are headers included after the last chunk of a response encoded
     * with chunked encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.895 -0500", hash_original_method = "017F163869C61C64FB5708C2B3013CCB", hash_generated_method = "23842DFC2EE1BA3D3D8EF3AC7EB6023B")
    
final void readTrailers() throws IOException {
        readHeaders(responseHeaders.getHeaders());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.897 -0500", hash_original_method = "814E7EB33C3A4672039AF7BE1F530F36", hash_generated_method = "899A3C425D4215569CC5ED663430C294")
    
private void readHeaders(RawHeaders headers) throws IOException {
        // parse the result headers until the first blank line
        String line;
        while (!(line = Streams.readAsciiLine(socketIn)).isEmpty()) {
            headers.addLine(line);
        }

        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler != null) {
            cookieHandler.put(uri, headers.toMultimap());
        }
    }

    /**
     * Prepares the HTTP headers and sends them to the server.
     *
     * <p>For streaming requests with a body, headers must be prepared
     * <strong>before</strong> the output stream has been written to. Otherwise
     * the body would need to be buffered!
     *
     * <p>For non-streaming requests with a body, headers must be prepared
     * <strong>after</strong> the output stream has been written to and closed.
     * This ensures that the {@code Content-Length} header field receives the
     * proper value.
     *
     * @param contentLength the number of bytes in the request body, or -1 if
     *      the request body length is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.900 -0500", hash_original_method = "6D117EBD96F306FC6CE6929186DDBA19", hash_generated_method = "A1300E06E07F3E1D0ECF99305EFB4230")
    
private void writeRequestHeaders(int contentLength) throws IOException {
        if (sentRequestMillis != -1) {
            throw new IllegalStateException();
        }

        RawHeaders headersToSend = getNetworkRequestHeaders();
        byte[] bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);

        if (contentLength != -1 && bytes.length + contentLength <= MAX_REQUEST_BUFFER_LENGTH) {
            requestOut = new BufferedOutputStream(socketOut, bytes.length + contentLength);
        }

        sentRequestMillis = System.currentTimeMillis();
        requestOut.write(bytes);
    }

    /**
     * Returns the headers to send on a network request.
     *
     * <p>This adds the content length and content-type headers, which are
     * neither needed nor known when querying the response cache.
     *
     * <p>It updates the status line, which may need to be fully qualified if
     * the connection is using a proxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.902 -0500", hash_original_method = "E663539B4C2FF814BF16D6A04E975935", hash_generated_method = "F94017F1AB6F0CC8453665762FC1862F")
    
protected RawHeaders getNetworkRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());

        int fixedContentLength = policy.getFixedContentLength();
        if (fixedContentLength != -1) {
            requestHeaders.setContentLength(fixedContentLength);
        } else if (sendChunked) {
            requestHeaders.setChunked();
        } else if (requestBodyOut instanceof RetryableOutputStream) {
            int contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            requestHeaders.setContentLength(contentLength);
        }

        return requestHeaders.getHeaders();
    }

    /**
     * Populates requestHeaders with defaults and cookies.
     *
     * <p>This client doesn't specify a default {@code Accept} header because it
     * doesn't know what content types the application is interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.905 -0500", hash_original_method = "9965AB400B31D225B507F0BE101C0DB2", hash_generated_method = "BAE49C2465FE93C8550CC3FA50741AF8")
    
private void prepareRawRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());

        if (requestHeaders.getUserAgent() == null) {
            requestHeaders.setUserAgent(getDefaultUserAgent());
        }

        if (requestHeaders.getHost() == null) {
            requestHeaders.setHost(getOriginAddress(policy.getURL()));
        }

        if (httpMinorVersion > 0 && requestHeaders.getConnection() == null) {
            requestHeaders.setConnection("Keep-Alive");
        }

        if (requestHeaders.getAcceptEncoding() == null) {
            transparentGzip = true;
            requestHeaders.setAcceptEncoding("gzip");
        }

        if (hasRequestBody() && requestHeaders.getContentType() == null) {
            requestHeaders.setContentType("application/x-www-form-urlencoded");
        }

        long ifModifiedSince = policy.getIfModifiedSince();
        if (ifModifiedSince != 0) {
            requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        }

        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler != null) {
            requestHeaders.addCookies(
                    cookieHandler.get(uri, requestHeaders.getHeaders().toMultimap()));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.908 -0500", hash_original_method = "6DB81453AD78E43D72799E90FBF820CD", hash_generated_method = "99935E76614634899FAE8E3E6BF8CD13")
    
private String getRequestLine() {
        String protocol = (httpMinorVersion == 0) ? "HTTP/1.0" : "HTTP/1.1";
        return method + " " + requestString() + " " + protocol;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.911 -0500", hash_original_method = "579F0C1DEDB2C71B061424762EDA3D6F", hash_generated_method = "CFEC65D01096D2FCEADA1422D22DB130")
    
private String requestString() {
        URL url = policy.getURL();
        if (includeAuthorityInRequestLine()) {
            return url.toString();
        } else {
            String fileOnly = url.getFile();
            if (fileOnly == null) {
                fileOnly = "/";
            } else if (!fileOnly.startsWith("/")) {
                fileOnly = "/" + fileOnly;
            }
            return fileOnly;
        }
    }

    /**
     * Returns true if the request line should contain the full URL with host
     * and port (like "GET http://android.com/foo HTTP/1.1") or only the path
     * (like "GET /foo HTTP/1.1").
     *
     * <p>This is non-final because for HTTPS it's never necessary to supply the
     * full URL, even if a proxy is in use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.913 -0500", hash_original_method = "A86C65F03AA643F0D379154D6D12D2B7", hash_generated_method = "1C1F5D545DAF534BA47E913D76165DCF")
    
protected boolean includeAuthorityInRequestLine() {
        return policy.usingProxy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.916 -0500", hash_original_method = "B0560F32D5938C3FB1E508A1DA2A4958", hash_generated_method = "F16995F29F854CF2B97D81F8D6D1923F")
    
protected final String getDefaultUserAgent() {
        String agent = System.getProperty("http.agent");
        return agent != null ? agent : ("Java" + System.getProperty("java.version"));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.918 -0500", hash_original_method = "0A452E6BAC82BB82543FC0DC64DC1250", hash_generated_method = "F749B570B6C1329E0571D63E1B99B8AE")
    
private boolean hasConnectionCloseHeader() {
        return (responseHeaders != null && responseHeaders.hasConnectionClose())
                || requestHeaders.hasConnectionClose();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.921 -0500", hash_original_method = "71D2D2A43E6B9B2FCF0835DDEF471DCE", hash_generated_method = "3C387EC3CDF42DD90C8B366178B39E33")
    
protected final String getOriginAddress(URL url) {
        int port = url.getPort();
        String result = url.getHost();
        if (port > 0 && port != policy.getDefaultPort()) {
            result = result + ":" + port;
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.923 -0500", hash_original_method = "E79001B5362EC94E0060C3FC14A22DCF", hash_generated_method = "F1CE8C3BEB04A349888B6E5B003820D8")
    
protected boolean requiresTunnel() {
        return false;
    }

    /**
     * Flushes the remaining request header and body, parses the HTTP response
     * headers and starts reading the HTTP response body if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.926 -0500", hash_original_method = "1EEDE20F378BB56816783AF0AAE8D8C5", hash_generated_method = "2AE5A6AC1EB7B311A9443C8F45DCAEBC")
    
public final void readResponse() throws IOException {
        if (hasResponse()) {
            return;
        }

        if (responseSource == null) {
            throw new IllegalStateException("readResponse() without sendRequest()");
        }

        if (!responseSource.requiresConnection()) {
            return;
        }

        if (sentRequestMillis == -1) {
            int contentLength = requestBodyOut instanceof RetryableOutputStream
                    ? ((RetryableOutputStream) requestBodyOut).contentLength()
                    : -1;
            writeRequestHeaders(contentLength);
        }

        if (requestBodyOut != null) {
            requestBodyOut.close();
            if (requestBodyOut instanceof RetryableOutputStream) {
                ((RetryableOutputStream) requestBodyOut).writeToSocket(requestOut);
            }
        }

        requestOut.flush();
        requestOut = socketOut;

        readResponseHeaders();
        responseHeaders.setLocalTimestamps(sentRequestMillis, System.currentTimeMillis());

        if (responseSource == ResponseSource.CONDITIONAL_CACHE) {
            if (cachedResponseHeaders.validate(responseHeaders)) {
                if (responseCache instanceof HttpResponseCache) {
                    ((HttpResponseCache) responseCache).trackConditionalCacheHit();
                }
                // Discard the network response body. Combine the headers.
                release(true);
                setResponse(cachedResponseHeaders.combine(responseHeaders), cachedResponseBody);
                return;
            } else {
                IoUtils.closeQuietly(cachedResponseBody);
            }
        }

        if (hasResponseBody()) {
            maybeCache(); // reentrant. this calls into user code which may call back into this!
        }

        initContentStream(getTransferStream());
    }
}

