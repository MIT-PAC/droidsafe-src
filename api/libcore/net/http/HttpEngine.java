package libcore.net.http;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.246 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "10F140AB3529378738DBDEC5DAB46D42")

    protected HttpURLConnectionImpl policy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.246 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.246 -0400", hash_original_field = "B3D99257499D27549F028C5AD75C86B0", hash_generated_field = "F290F176FDAB7CFB2CA524D383F761B2")

    private ResponseSource responseSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.246 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "75AB93228F6DCAE1755313947EC33E63")

    protected HttpConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "69CDF51B14212ECA16FCCC826AB99D52", hash_generated_field = "933C36367DBB638C304659EC3CE47516")

    private InputStream socketIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "E4EF4FCDDB2EB2FC355EEED04D1696B4", hash_generated_field = "39983E65AC7A55E9EA11E4F742E77B1E")

    private OutputStream requestOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "53CE5C37EA7680F830110251466C44CD", hash_generated_field = "C2D66FBA681404DC7AF350EE623C0860")

    private AbstractHttpOutputStream requestBodyOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "D46EABEC025443DFEFD6A04BAC15947A", hash_generated_field = "3B099B70D4FFF6286391C7CE8061D62D")

    private InputStream responseBodyIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "54287229D483AC3CA3E8EB5C4A736F16", hash_generated_field = "1F19E961A3B4F1C13A1EF03108380C81")

    private final ResponseCache responseCache = ResponseCache.getDefault();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "6453E8CAAF9350A66BD46394D5A6CE08", hash_generated_field = "AD49865A8688A75CE7F76CFDCE3EF6E0")

    private CacheResponse cacheResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "58E157FA6A49A1EC60FEBC3530BD26A5", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "D93E4E0D5913F802E2DBC0259518E915", hash_generated_field = "56E6E961645E2EBB7A5C3DD20FD9692C")

    private long sentRequestMillis = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "4816879B2302A4B54773D1E40854FDA6", hash_generated_field = "4EBB07D2648B3D849030D220C4A105C6")

    private boolean transparentGzip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "0C4F4D11DD2B8C6B56EE801110ADB9B0", hash_generated_field = "28AC40F22099010DD7EC3C28A2701903")

    boolean sendChunked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "D2013170F9870890E8C8E9E0851CA83E", hash_generated_field = "080B467195B9452EC670BEC2B6B507A0")

    private RequestHeaders requestHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "88AD2D36D7618A24DA38DA33CE55CF56")

    private ResponseHeaders responseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "5C96D0EB75A935F303BE7B89E1F4F8C8", hash_generated_field = "FFEE168D4CB4772A0F008367723F4DCB")

    private ResponseHeaders cachedResponseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "70639960D7DCB2C7D1392C0333153519", hash_generated_field = "9AC6636989AABA65466C0761ABE1A1EE")

    private InputStream cachedResponseBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "5979C14BCFBBC58C6232B38F5526796E", hash_generated_field = "583B8E5019F7D6ABD319DE61C9CB145F")

    private boolean automaticallyReleaseConnectionToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.247 -0400", hash_original_field = "C290CDC8785F6260FD3F82BED8FFC733", hash_generated_field = "0385A75ADFAFB5B890C6C920CD19DE25")

    private boolean connectionReleased;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.249 -0400", hash_original_method = "40A41D57A5E6AC75A04C66EEBA0108AA", hash_generated_method = "20BF045D4E876F4DCB0AF8EE34332B70")
    public  HttpEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBodyOut) throws IOException {
        this.policy = policy;
        this.method = method;
        this.connection = connection;
        this.requestBodyOut = requestBodyOut;
        try 
        {
            uri = policy.getURL().toURILenient();
        } //End block
        catch (URISyntaxException e)
        {
            IOException var0AFB0468CE17165C7EF7344B3E18B39B_1438408467 = new IOException(e);
            var0AFB0468CE17165C7EF7344B3E18B39B_1438408467.addTaint(taint);
            throw var0AFB0468CE17165C7EF7344B3E18B39B_1438408467;
        } //End block
        this.requestHeaders = new RequestHeaders(uri, new RawHeaders(requestHeaders));
        // ---------- Original Method ----------
        //this.policy = policy;
        //this.method = method;
        //this.connection = connection;
        //this.requestBodyOut = requestBodyOut;
        //try {
            //uri = policy.getURL().toURILenient();
        //} catch (URISyntaxException e) {
            //throw new IOException(e);
        //}
        //this.requestHeaders = new RequestHeaders(uri, new RawHeaders(requestHeaders));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.250 -0400", hash_original_method = "B90EC93300E2D6FABAAF6B3D0678EFB4", hash_generated_method = "276C1B16E9FFC73A037ED34458F25A88")
    public final void sendRequest() throws IOException {
        if(responseSource != null)        
        {
            return;
        } //End block
        prepareRawRequestHeaders();
        initResponseSource();
        if(responseCache instanceof HttpResponseCache)        
        {
            ((HttpResponseCache) responseCache).trackResponse(responseSource);
        } //End block
        if(requestHeaders.isOnlyIfCached() && responseSource.requiresConnection())        
        {
            if(responseSource == ResponseSource.CONDITIONAL_CACHE)            
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } //End block
            this.responseSource = ResponseSource.CACHE;
            this.cacheResponse = BAD_GATEWAY_RESPONSE;
            RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(cacheResponse.getHeaders());
            setResponse(new ResponseHeaders(uri, rawResponseHeaders), cacheResponse.getBody());
        } //End block
        if(responseSource.requiresConnection())        
        {
            sendSocketRequest();
        } //End block
        else
        if(connection != null)        
        {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.252 -0400", hash_original_method = "F2FA78DDC7B88A7A9FD4B961BDAA52C1", hash_generated_method = "66F8FD9EC7B4705189E9EC336895AAA1")
    private void initResponseSource() throws IOException {
        responseSource = ResponseSource.NETWORK;
        if(!policy.getUseCaches() || responseCache == null)        
        {
            return;
        } //End block
        CacheResponse candidate = responseCache.get(uri, method,
                requestHeaders.getHeaders().toMultimap());
        if(candidate == null)        
        {
            return;
        } //End block
        Map<String, List<String>> responseHeadersMap = candidate.getHeaders();
        cachedResponseBody = candidate.getBody();
        if(!acceptCacheResponseType(candidate)
                || responseHeadersMap == null
                || cachedResponseBody == null)        
        {
            IoUtils.closeQuietly(cachedResponseBody);
            return;
        } //End block
        RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(responseHeadersMap);
        cachedResponseHeaders = new ResponseHeaders(uri, rawResponseHeaders);
        long now = System.currentTimeMillis();
        this.responseSource = cachedResponseHeaders.chooseResponseSource(now, requestHeaders);
        if(responseSource == ResponseSource.CACHE)        
        {
            this.cacheResponse = candidate;
            setResponse(cachedResponseHeaders, cachedResponseBody);
        } //End block
        else
        if(responseSource == ResponseSource.CONDITIONAL_CACHE)        
        {
            this.cacheResponse = candidate;
        } //End block
        else
        if(responseSource == ResponseSource.NETWORK)        
        {
            IoUtils.closeQuietly(cachedResponseBody);
        } //End block
        else
        {
            AssertionError varA81442E36297E737EB908877E58260E8_409628112 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_409628112.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_409628112;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.253 -0400", hash_original_method = "22FB1B3BCF67C2C3EB9ADF307D5A559C", hash_generated_method = "47A6EE06D9F2E2521F546BE68B17D17E")
    private void sendSocketRequest() throws IOException {
        if(connection == null)        
        {
            connect();
        } //End block
        if(socketOut != null || requestOut != null || socketIn != null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_185020825 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_185020825.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_185020825;
        } //End block
        socketOut = connection.getOutputStream();
        requestOut = socketOut;
        socketIn = connection.getInputStream();
        if(hasRequestBody())        
        {
            initRequestBodyOut();
        } //End block
        // ---------- Original Method ----------
        //if (connection == null) {
            //connect();
        //}
        //if (socketOut != null || requestOut != null || socketIn != null) {
            //throw new IllegalStateException();
        //}
        //socketOut = connection.getOutputStream();
        //requestOut = socketOut;
        //socketIn = connection.getInputStream();
        //if (hasRequestBody()) {
            //initRequestBodyOut();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.253 -0400", hash_original_method = "2D119148BD5E3059D34FC5038B3E143C", hash_generated_method = "5AB6D55BFD0CFA7609F8F0FBC67C438B")
    protected void connect() throws IOException {
        if(connection == null)        
        {
            connection = openSocketConnection();
        } //End block
        // ---------- Original Method ----------
        //if (connection == null) {
            //connection = openSocketConnection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.253 -0400", hash_original_method = "191E23F5B6629C7E64418EFD4A3F2A23", hash_generated_method = "66770ED2D3AAC9D7A72531ADAEFB592B")
    protected final HttpConnection openSocketConnection() throws IOException {
        HttpConnection result = HttpConnection.connect(
                uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        Proxy proxy = result.getAddress().getProxy();
        if(proxy != null)        
        {
            policy.setProxy(proxy);
        } //End block
        result.setSoTimeout(policy.getReadTimeout());
HttpConnection varDC838461EE2FA0CA4C9BBB70A15456B0_655131338 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_655131338.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_655131338;
        // ---------- Original Method ----------
        //HttpConnection result = HttpConnection.connect(
                //uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        //Proxy proxy = result.getAddress().getProxy();
        //if (proxy != null) {
            //policy.setProxy(proxy);
        //}
        //result.setSoTimeout(policy.getReadTimeout());
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.255 -0400", hash_original_method = "54D96F75BB859B6FCC0E9DF779F84B99", hash_generated_method = "7E5BE7A43F846C9F5026CE924B378DC2")
    protected void initRequestBodyOut() throws IOException {
        int chunkLength = policy.getChunkLength();
        if(chunkLength > 0 || requestHeaders.isChunked())        
        {
            sendChunked = true;
            if(chunkLength == -1)            
            {
                chunkLength = DEFAULT_CHUNK_LENGTH;
            } //End block
        } //End block
        if(socketOut == null)        
        {
            IllegalStateException varE127A39FD6F2C7433080153C389658F8_454541759 = new IllegalStateException("No socket to write to; was a POST cached?");
            varE127A39FD6F2C7433080153C389658F8_454541759.addTaint(taint);
            throw varE127A39FD6F2C7433080153C389658F8_454541759;
        } //End block
        if(httpMinorVersion == 0)        
        {
            sendChunked = false;
        } //End block
        int fixedContentLength = policy.getFixedContentLength();
        if(requestBodyOut != null)        
        {
        } //End block
        else
        if(fixedContentLength != -1)        
        {
            writeRequestHeaders(fixedContentLength);
            requestBodyOut = new FixedLengthOutputStream(requestOut, fixedContentLength);
        } //End block
        else
        if(sendChunked)        
        {
            writeRequestHeaders(-1);
            requestBodyOut = new ChunkedOutputStream(requestOut, chunkLength);
        } //End block
        else
        if(requestHeaders.getContentLength() != -1)        
        {
            writeRequestHeaders(requestHeaders.getContentLength());
            requestBodyOut = new RetryableOutputStream(requestHeaders.getContentLength());
        } //End block
        else
        {
            requestBodyOut = new RetryableOutputStream();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.256 -0400", hash_original_method = "5E913F4CB8B308A1D4F5DA7B9ED80F77", hash_generated_method = "D37FDEAFD80E35C277D845F83C061B47")
    private void setResponse(ResponseHeaders headers, InputStream body) throws IOException {
        addTaint(body.getTaint());
        if(this.responseBodyIn != null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1951353012 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1951353012.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1951353012;
        } //End block
        this.responseHeaders = headers;
        this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
        if(body != null)        
        {
            initContentStream(body);
        } //End block
        // ---------- Original Method ----------
        //if (this.responseBodyIn != null) {
            //throw new IllegalStateException();
        //}
        //this.responseHeaders = headers;
        //this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
        //if (body != null) {
            //initContentStream(body);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.256 -0400", hash_original_method = "A2A25877F13CAB8F3B2570F0DD573D04", hash_generated_method = "FB00469FFF70623DC4C3DD787BF88645")
    private boolean hasRequestBody() {
        boolean var7BF322D53CABE151F96748E495E6F498_1803548446 = (method == POST || method == PUT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040743553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040743553;
        // ---------- Original Method ----------
        //return method == POST || method == PUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.256 -0400", hash_original_method = "C7FD66AD45D049BA30B9133E737F62A7", hash_generated_method = "BEDBC944E73091F040E63DB63BCDEC95")
    public final OutputStream getRequestBody() {
        if(responseSource == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_799739580 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_799739580.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_799739580;
        } //End block
OutputStream var9DC46B2BACB0B01C659B74CD62B00382_2004533098 =         requestBodyOut;
        var9DC46B2BACB0B01C659B74CD62B00382_2004533098.addTaint(taint);
        return var9DC46B2BACB0B01C659B74CD62B00382_2004533098;
        // ---------- Original Method ----------
        //if (responseSource == null) {
            //throw new IllegalStateException();
        //}
        //return requestBodyOut;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "9AE95190B8E2C9C0E3A7C6677534EAD2", hash_generated_method = "F2AE775793C1BE64CFB26A10C2AC004B")
    public final boolean hasResponse() {
        boolean var1E9A7D6C9864EED2DD7331E4D534613E_170524951 = (responseHeaders != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788150900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788150900;
        // ---------- Original Method ----------
        //return responseHeaders != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "22C8454720634D9B77E5CFB8983F80A0", hash_generated_method = "7FB97CFAB4DF0240CAD0987C4B310F84")
    public final RequestHeaders getRequestHeaders() {
RequestHeaders var865DB0B8CD374F1022AF1F2AA435EB1D_236599764 =         requestHeaders;
        var865DB0B8CD374F1022AF1F2AA435EB1D_236599764.addTaint(taint);
        return var865DB0B8CD374F1022AF1F2AA435EB1D_236599764;
        // ---------- Original Method ----------
        //return requestHeaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "4093002B56979B81D9123217E2215EFB", hash_generated_method = "5597958A63DAC8D21BBFFDA56D235BDB")
    public final ResponseHeaders getResponseHeaders() {
        if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_894913439 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_894913439.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_894913439;
        } //End block
ResponseHeaders var028B03401730B4B2430034F8F93178D6_924950138 =         responseHeaders;
        var028B03401730B4B2430034F8F93178D6_924950138.addTaint(taint);
        return var028B03401730B4B2430034F8F93178D6_924950138;
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseHeaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "6C8D632B120ECD201D125D0086576F82", hash_generated_method = "60BEC7E89AAA5D08AB9A7C8B6ACBFEDF")
    public final int getResponseCode() {
        if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1771202983 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1771202983.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1771202983;
        } //End block
        int var1D38D2E5D714633D7016AA7186B7C917_1359931957 = (responseHeaders.getHeaders().getResponseCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022798722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022798722;
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseHeaders.getHeaders().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "FBE346C8B51CB8E76028C21E64D6BD0A", hash_generated_method = "8EF350746F3E249A269C91EFC6376633")
    public final InputStream getResponseBody() {
        if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_91950534 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_91950534.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_91950534;
        } //End block
InputStream var32C44555E939E90398BD43EABC877C1F_1791287351 =         responseBodyIn;
        var32C44555E939E90398BD43EABC877C1F_1791287351.addTaint(taint);
        return var32C44555E939E90398BD43EABC877C1F_1791287351;
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseBodyIn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.257 -0400", hash_original_method = "2250F4C87B4A22443F60D9654505E9D2", hash_generated_method = "4B4EE89CADEDF58003A5E0097C22423E")
    public final CacheResponse getCacheResponse() {
        if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1446115019 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1446115019.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1446115019;
        } //End block
CacheResponse varABFB30EDCA8832B555B64AC56016D834_1186160410 =         cacheResponse;
        varABFB30EDCA8832B555B64AC56016D834_1186160410.addTaint(taint);
        return varABFB30EDCA8832B555B64AC56016D834_1186160410;
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return cacheResponse;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.258 -0400", hash_original_method = "9105CAFA0117096F163A50885E7429CB", hash_generated_method = "D97384D9AEA018F310685420CF3EB1DF")
    public final HttpConnection getConnection() {
HttpConnection var9911BB1C5F1522C1630847C40E8BC67E_917867346 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_917867346.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_917867346;
        // ---------- Original Method ----------
        //return connection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.258 -0400", hash_original_method = "A7591895A9BC485B929D9D45A1C9BC76", hash_generated_method = "8BC328483E3C3C8B3E603436DE4C6177")
    protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        addTaint(cacheResponse.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_848881072 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911029157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911029157;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.258 -0400", hash_original_method = "E0679987436CD4859195D8429BAB78FF", hash_generated_method = "8305E80E9454B8B4E0D7284DD7CE6D76")
    private void maybeCache() throws IOException {
        if(!policy.getUseCaches() || responseCache == null)        
        {
            return;
        } //End block
        if(!responseHeaders.isCacheable(requestHeaders))        
        {
            return;
        } //End block
        cacheRequest = responseCache.put(uri, getHttpConnectionToCache());
        // ---------- Original Method ----------
        //if (!policy.getUseCaches() || responseCache == null) {
            //return;
        //}
        //if (!responseHeaders.isCacheable(requestHeaders)) {
            //return;
        //}
        //cacheRequest = responseCache.put(uri, getHttpConnectionToCache());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.259 -0400", hash_original_method = "CA4844B1B3E4576C0EA18E04D34BB6CE", hash_generated_method = "8DB69679072400B6D4A4E642234CD1BE")
    protected HttpURLConnection getHttpConnectionToCache() {
HttpURLConnection var2938A9ABA11B2DDD5ADB24059ADA8326_1006016533 =         policy;
        var2938A9ABA11B2DDD5ADB24059ADA8326_1006016533.addTaint(taint);
        return var2938A9ABA11B2DDD5ADB24059ADA8326_1006016533;
        // ---------- Original Method ----------
        //return policy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.259 -0400", hash_original_method = "5482932EB1112689442580A552BBCA6A", hash_generated_method = "472F6C8958D34A11E52660BF79414A2D")
    public final void automaticallyReleaseConnectionToPool() {
        automaticallyReleaseConnectionToPool = true;
        if(connection != null && connectionReleased)        
        {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        } //End block
        // ---------- Original Method ----------
        //automaticallyReleaseConnectionToPool = true;
        //if (connection != null && connectionReleased) {
            //HttpConnectionPool.INSTANCE.recycle(connection);
            //connection = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.260 -0400", hash_original_method = "648343BC3C2ABC6FA7BF932A2F48012C", hash_generated_method = "F6BC79D9FF841B43C794A9551679B515")
    public final void release(boolean reusable) {
        addTaint(reusable);
        if(responseBodyIn == cachedResponseBody)        
        {
            IoUtils.closeQuietly(responseBodyIn);
        } //End block
        if(!connectionReleased && connection != null)        
        {
            connectionReleased = true;
            if(requestBodyOut != null && !requestBodyOut.closed)            
            {
                reusable = false;
            } //End block
            if(hasConnectionCloseHeader())            
            {
                reusable = false;
            } //End block
            if(responseBodyIn instanceof UnknownLengthHttpInputStream)            
            {
                reusable = false;
            } //End block
            if(reusable && responseBodyIn != null)            
            {
                try 
                {
                    Streams.skipAll(responseBodyIn);
                } //End block
                catch (IOException e)
                {
                    reusable = false;
                } //End block
            } //End block
            if(!reusable)            
            {
                connection.closeSocketAndStreams();
                connection = null;
            } //End block
            else
            if(automaticallyReleaseConnectionToPool)            
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.261 -0400", hash_original_method = "EC59FCFED738418E26EF637931185263", hash_generated_method = "FC69546D250ABB82477413E1BB635A2D")
    private void initContentStream(InputStream transferStream) throws IOException {
        if(transparentGzip && responseHeaders.isContentEncodingGzip())        
        {
            responseHeaders.stripContentEncoding();
            responseBodyIn = new GZIPInputStream(transferStream);
        } //End block
        else
        {
            responseBodyIn = transferStream;
        } //End block
        // ---------- Original Method ----------
        //if (transparentGzip && responseHeaders.isContentEncodingGzip()) {
            //responseHeaders.stripContentEncoding();
            //responseBodyIn = new GZIPInputStream(transferStream);
        //} else {
            //responseBodyIn = transferStream;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.261 -0400", hash_original_method = "1AB921196A345CEE857EE600A5FD99DD", hash_generated_method = "4AFD2006929FBD93106425640575599F")
    private InputStream getTransferStream() throws IOException {
        if(!hasResponseBody())        
        {
InputStream varD4DA5D12471E107E08025939F8ECE54C_658637632 =             new FixedLengthInputStream(socketIn, cacheRequest, this, 0);
            varD4DA5D12471E107E08025939F8ECE54C_658637632.addTaint(taint);
            return varD4DA5D12471E107E08025939F8ECE54C_658637632;
        } //End block
        if(responseHeaders.isChunked())        
        {
InputStream var96AA5673A64CAABFA4727C17C63F498B_1277582295 =             new ChunkedInputStream(socketIn, cacheRequest, this);
            var96AA5673A64CAABFA4727C17C63F498B_1277582295.addTaint(taint);
            return var96AA5673A64CAABFA4727C17C63F498B_1277582295;
        } //End block
        if(responseHeaders.getContentLength() != -1)        
        {
InputStream var98822C7C607BC835C446A1B22D9F0684_1174824608 =             new FixedLengthInputStream(socketIn, cacheRequest, this,
                    responseHeaders.getContentLength());
            var98822C7C607BC835C446A1B22D9F0684_1174824608.addTaint(taint);
            return var98822C7C607BC835C446A1B22D9F0684_1174824608;
        } //End block
InputStream var57DE3C7FFFE9F62D1BD7BCCB2F749217_1332258182 =         new UnknownLengthHttpInputStream(socketIn, cacheRequest, this);
        var57DE3C7FFFE9F62D1BD7BCCB2F749217_1332258182.addTaint(taint);
        return var57DE3C7FFFE9F62D1BD7BCCB2F749217_1332258182;
        // ---------- Original Method ----------
        //if (!hasResponseBody()) {
            //return new FixedLengthInputStream(socketIn, cacheRequest, this, 0);
        //}
        //if (responseHeaders.isChunked()) {
            //return new ChunkedInputStream(socketIn, cacheRequest, this);
        //}
        //if (responseHeaders.getContentLength() != -1) {
            //return new FixedLengthInputStream(socketIn, cacheRequest, this,
                    //responseHeaders.getContentLength());
        //}
        //return new UnknownLengthHttpInputStream(socketIn, cacheRequest, this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.262 -0400", hash_original_method = "E5EB74DB686CEF76B63FEE327FA34FC3", hash_generated_method = "AE5F354E12FD886A3F3E8823367762B1")
    private void readResponseHeaders() throws IOException {
        RawHeaders headers;
        do {
            {
                headers = new RawHeaders();
                headers.setStatusLine(Streams.readAsciiLine(socketIn));
                readHeaders(headers);
            } //End block
} while (headers.getResponseCode() == HTTP_CONTINUE);
        setResponse(new ResponseHeaders(uri, headers), null);
        // ---------- Original Method ----------
        //RawHeaders headers;
        //do {
            //headers = new RawHeaders();
            //headers.setStatusLine(Streams.readAsciiLine(socketIn));
            //readHeaders(headers);
        //} while (headers.getResponseCode() == HTTP_CONTINUE);
        //setResponse(new ResponseHeaders(uri, headers), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.263 -0400", hash_original_method = "C50EFF03D3756AF141D5513AF20FE391", hash_generated_method = "B7CC078BC010813C1F766B56655823DC")
    public final boolean hasResponseBody() {
        int responseCode = responseHeaders.getHeaders().getResponseCode();
        if(method != HEAD
                && method != CONNECT
                && (responseCode < HTTP_CONTINUE || responseCode >= 200)
                && responseCode != HttpURLConnectionImpl.HTTP_NO_CONTENT
                && responseCode != HttpURLConnectionImpl.HTTP_NOT_MODIFIED)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_736928639 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829743235 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_829743235;
        } //End block
        if(responseHeaders.getContentLength() != -1 || responseHeaders.isChunked())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_762127451 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321490428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_321490428;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1808427372 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523914200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523914200;
        // ---------- Original Method ----------
        //int responseCode = responseHeaders.getHeaders().getResponseCode();
        //if (method != HEAD
                //&& method != CONNECT
                //&& (responseCode < HTTP_CONTINUE || responseCode >= 200)
                //&& responseCode != HttpURLConnectionImpl.HTTP_NO_CONTENT
                //&& responseCode != HttpURLConnectionImpl.HTTP_NOT_MODIFIED) {
            //return true;
        //}
        //if (responseHeaders.getContentLength() != -1 || responseHeaders.isChunked()) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.263 -0400", hash_original_method = "017F163869C61C64FB5708C2B3013CCB", hash_generated_method = "F672A3A361C8D11DFA099C224F5A5D25")
    final void readTrailers() throws IOException {
        readHeaders(responseHeaders.getHeaders());
        // ---------- Original Method ----------
        //readHeaders(responseHeaders.getHeaders());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.264 -0400", hash_original_method = "814E7EB33C3A4672039AF7BE1F530F36", hash_generated_method = "62BEDC62121F07AA264B6585F7BB649F")
    private void readHeaders(RawHeaders headers) throws IOException {
        addTaint(headers.getTaint());
        String line;
        while
(!(line = Streams.readAsciiLine(socketIn)).isEmpty())        
        {
            headers.addLine(line);
        } //End block
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if(cookieHandler != null)        
        {
            cookieHandler.put(uri, headers.toMultimap());
        } //End block
        // ---------- Original Method ----------
        //String line;
        //while (!(line = Streams.readAsciiLine(socketIn)).isEmpty()) {
            //headers.addLine(line);
        //}
        //CookieHandler cookieHandler = CookieHandler.getDefault();
        //if (cookieHandler != null) {
            //cookieHandler.put(uri, headers.toMultimap());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.265 -0400", hash_original_method = "6D117EBD96F306FC6CE6929186DDBA19", hash_generated_method = "1875B3F6607D8D31F87969B9A2CD7CAB")
    private void writeRequestHeaders(int contentLength) throws IOException {
        if(sentRequestMillis != -1)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1976521817 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1976521817.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1976521817;
        } //End block
        RawHeaders headersToSend = getNetworkRequestHeaders();
        byte[] bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);
        if(contentLength != -1 && bytes.length + contentLength <= MAX_REQUEST_BUFFER_LENGTH)        
        {
            requestOut = new BufferedOutputStream(socketOut, bytes.length + contentLength);
        } //End block
        sentRequestMillis = System.currentTimeMillis();
        requestOut.write(bytes);
        // ---------- Original Method ----------
        //if (sentRequestMillis != -1) {
            //throw new IllegalStateException();
        //}
        //RawHeaders headersToSend = getNetworkRequestHeaders();
        //byte[] bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);
        //if (contentLength != -1 && bytes.length + contentLength <= MAX_REQUEST_BUFFER_LENGTH) {
            //requestOut = new BufferedOutputStream(socketOut, bytes.length + contentLength);
        //}
        //sentRequestMillis = System.currentTimeMillis();
        //requestOut.write(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.265 -0400", hash_original_method = "E663539B4C2FF814BF16D6A04E975935", hash_generated_method = "2BE347B3A8D4E914D6250E8DD3CD75C2")
    protected RawHeaders getNetworkRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        int fixedContentLength = policy.getFixedContentLength();
        if(fixedContentLength != -1)        
        {
            requestHeaders.setContentLength(fixedContentLength);
        } //End block
        else
        if(sendChunked)        
        {
            requestHeaders.setChunked();
        } //End block
        else
        if(requestBodyOut instanceof RetryableOutputStream)        
        {
            int contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            requestHeaders.setContentLength(contentLength);
        } //End block
RawHeaders var519CFA10080DFE28BEEEB2CBF346A2C7_330517518 =         requestHeaders.getHeaders();
        var519CFA10080DFE28BEEEB2CBF346A2C7_330517518.addTaint(taint);
        return var519CFA10080DFE28BEEEB2CBF346A2C7_330517518;
        // ---------- Original Method ----------
        //requestHeaders.getHeaders().setStatusLine(getRequestLine());
        //int fixedContentLength = policy.getFixedContentLength();
        //if (fixedContentLength != -1) {
            //requestHeaders.setContentLength(fixedContentLength);
        //} else if (sendChunked) {
            //requestHeaders.setChunked();
        //} else if (requestBodyOut instanceof RetryableOutputStream) {
            //int contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            //requestHeaders.setContentLength(contentLength);
        //}
        //return requestHeaders.getHeaders();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.265 -0400", hash_original_method = "9965AB400B31D225B507F0BE101C0DB2", hash_generated_method = "AC1470CEEF0B1C13B561ED8DE71AE61E")
    private void prepareRawRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        if(requestHeaders.getUserAgent() == null)        
        {
            requestHeaders.setUserAgent(getDefaultUserAgent());
        } //End block
        if(requestHeaders.getHost() == null)        
        {
            requestHeaders.setHost(getOriginAddress(policy.getURL()));
        } //End block
        if(httpMinorVersion > 0 && requestHeaders.getConnection() == null)        
        {
            requestHeaders.setConnection("Keep-Alive");
        } //End block
        if(requestHeaders.getAcceptEncoding() == null)        
        {
            transparentGzip = true;
            requestHeaders.setAcceptEncoding("gzip");
        } //End block
        if(hasRequestBody() && requestHeaders.getContentType() == null)        
        {
            requestHeaders.setContentType("application/x-www-form-urlencoded");
        } //End block
        long ifModifiedSince = policy.getIfModifiedSince();
        if(ifModifiedSince != 0)        
        {
            requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        } //End block
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if(cookieHandler != null)        
        {
            requestHeaders.addCookies(
                    cookieHandler.get(uri, requestHeaders.getHeaders().toMultimap()));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.265 -0400", hash_original_method = "6DB81453AD78E43D72799E90FBF820CD", hash_generated_method = "F3E891182A4B4A9B17A621F790742610")
    private String getRequestLine() {
        String protocol = (httpMinorVersion == 0) ? "HTTP/1.0" : "HTTP/1.1";
String var354790A4CDCD0E4790130001D198CEE6_1814833093 =         method + " " + requestString() + " " + protocol;
        var354790A4CDCD0E4790130001D198CEE6_1814833093.addTaint(taint);
        return var354790A4CDCD0E4790130001D198CEE6_1814833093;
        // ---------- Original Method ----------
        //String protocol = (httpMinorVersion == 0) ? "HTTP/1.0" : "HTTP/1.1";
        //return method + " " + requestString() + " " + protocol;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "579F0C1DEDB2C71B061424762EDA3D6F", hash_generated_method = "EA0315930FEE409775C7DADC60B358EF")
    private String requestString() {
        URL url = policy.getURL();
        if(includeAuthorityInRequestLine())        
        {
String var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1366918374 =             url.toString();
            var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1366918374.addTaint(taint);
            return var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1366918374;
        } //End block
        else
        {
            String fileOnly = url.getFile();
            if(fileOnly == null)            
            {
                fileOnly = "/";
            } //End block
            else
            if(!fileOnly.startsWith("/"))            
            {
                fileOnly = "/" + fileOnly;
            } //End block
String var8F11DF4CD82F23DA56825A33AFAD48E3_1669849512 =             fileOnly;
            var8F11DF4CD82F23DA56825A33AFAD48E3_1669849512.addTaint(taint);
            return var8F11DF4CD82F23DA56825A33AFAD48E3_1669849512;
        } //End block
        // ---------- Original Method ----------
        //URL url = policy.getURL();
        //if (includeAuthorityInRequestLine()) {
            //return url.toString();
        //} else {
            //String fileOnly = url.getFile();
            //if (fileOnly == null) {
                //fileOnly = "/";
            //} else if (!fileOnly.startsWith("/")) {
                //fileOnly = "/" + fileOnly;
            //}
            //return fileOnly;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "A86C65F03AA643F0D379154D6D12D2B7", hash_generated_method = "D1D0F03DAF0F0D940A3317A0ACA6F75E")
    protected boolean includeAuthorityInRequestLine() {
        boolean var7A8C17F3484750D3A640DBB738A600A2_1835333093 = (policy.usingProxy());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576048100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_576048100;
        // ---------- Original Method ----------
        //return policy.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "B0560F32D5938C3FB1E508A1DA2A4958", hash_generated_method = "5FC53F4951D5AD9391ACA9156A596338")
    protected final String getDefaultUserAgent() {
        String agent = System.getProperty("http.agent");
String var168860BF941C60021F0D3FD4053F3575_438277089 =         agent != null ? agent : ("Java" + System.getProperty("java.version"));
        var168860BF941C60021F0D3FD4053F3575_438277089.addTaint(taint);
        return var168860BF941C60021F0D3FD4053F3575_438277089;
        // ---------- Original Method ----------
        //String agent = System.getProperty("http.agent");
        //return agent != null ? agent : ("Java" + System.getProperty("java.version"));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "0A452E6BAC82BB82543FC0DC64DC1250", hash_generated_method = "AD28BA9DA84FE5B9422D2E5C75D5E462")
    private boolean hasConnectionCloseHeader() {
        boolean var3AB3A1EC01D9127625B8032ED2758C32_1315639149 = ((responseHeaders != null && responseHeaders.hasConnectionClose())
                || requestHeaders.hasConnectionClose());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297638588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297638588;
        // ---------- Original Method ----------
        //return (responseHeaders != null && responseHeaders.hasConnectionClose())
                //|| requestHeaders.hasConnectionClose();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "71D2D2A43E6B9B2FCF0835DDEF471DCE", hash_generated_method = "ABD2A3C4B85F47A1B00E6D1EDA67F1E4")
    protected final String getOriginAddress(URL url) {
        addTaint(url.getTaint());
        int port = url.getPort();
        String result = url.getHost();
        if(port > 0 && port != policy.getDefaultPort())        
        {
            result = result + ":" + port;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_719683558 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_719683558.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_719683558;
        // ---------- Original Method ----------
        //int port = url.getPort();
        //String result = url.getHost();
        //if (port > 0 && port != policy.getDefaultPort()) {
            //result = result + ":" + port;
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.266 -0400", hash_original_method = "E79001B5362EC94E0060C3FC14A22DCF", hash_generated_method = "2E6A2D0F094584C70E8D32DB9919FF84")
    protected boolean requiresTunnel() {
        boolean var68934A3E9455FA72420237EB05902327_453802486 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255201939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255201939;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_method = "1EEDE20F378BB56816783AF0AAE8D8C5", hash_generated_method = "0A7A4F62D9B47CEFB59DEBAB1A4C9084")
    public final void readResponse() throws IOException {
        if(hasResponse())        
        {
            return;
        } //End block
        if(responseSource == null)        
        {
            IllegalStateException var0DD186E17D5EDC68102F66A69CB92EE1_907322549 = new IllegalStateException("readResponse() without sendRequest()");
            var0DD186E17D5EDC68102F66A69CB92EE1_907322549.addTaint(taint);
            throw var0DD186E17D5EDC68102F66A69CB92EE1_907322549;
        } //End block
        if(!responseSource.requiresConnection())        
        {
            return;
        } //End block
        if(sentRequestMillis == -1)        
        {
            int contentLength = requestBodyOut instanceof RetryableOutputStream
                    ? ((RetryableOutputStream) requestBodyOut).contentLength()
                    : -1;
            writeRequestHeaders(contentLength);
        } //End block
        if(requestBodyOut != null)        
        {
            requestBodyOut.close();
            if(requestBodyOut instanceof RetryableOutputStream)            
            {
                ((RetryableOutputStream) requestBodyOut).writeToSocket(requestOut);
            } //End block
        } //End block
        requestOut.flush();
        requestOut = socketOut;
        readResponseHeaders();
        responseHeaders.setLocalTimestamps(sentRequestMillis, System.currentTimeMillis());
        if(responseSource == ResponseSource.CONDITIONAL_CACHE)        
        {
            if(cachedResponseHeaders.validate(responseHeaders))            
            {
                if(responseCache instanceof HttpResponseCache)                
                {
                    ((HttpResponseCache) responseCache).trackConditionalCacheHit();
                } //End block
                release(true);
                setResponse(cachedResponseHeaders.combine(responseHeaders), cachedResponseBody);
                return;
            } //End block
            else
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } //End block
        } //End block
        if(hasResponseBody())        
        {
            maybeCache();
        } //End block
        initContentStream(getTransferStream());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "60701D148EA544EC619E42C145DBE5D2", hash_generated_field = "70D4CCFAF8B3B7A40157E10CDA810E11")

    private static final CacheResponse BAD_GATEWAY_RESPONSE = new CacheResponse() {        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_method = "2EDDCBB89487588B780135D7543EF20D", hash_generated_method = "62660BC4776DC3DF42BA4F8532D0F964")
        @Override
        public InputStream getBody() throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_819456721 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_819456721 = new ByteArrayInputStream(EmptyArray.BYTE);
            varB4EAC82CA7396A68D541C85D26508E83_819456721.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_819456721;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "C4FBD0DC576130A8CE5C84CD8120C301", hash_generated_field = "7F4ADBCA37973EB3682CE87E78171DEC")

    private static final int MAX_REQUEST_BUFFER_LENGTH = 32768;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "0F6E221759F88F702CA321737E37EE2B", hash_generated_field = "526B3DFF23C5F0AAA59C478051D61F5E")

    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "A9C3E01E9DC38700D201ECEB5C3B7EB0", hash_generated_field = "24A290CCF11DC3C02C7E5FA56409A521")

    public static final String OPTIONS = "OPTIONS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "2DEC4577BDE1A481702BFAD8DD379E31", hash_generated_field = "C8F8EB1723A4F1459E76ECA7A1B4FFEB")

    public static final String GET = "GET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "0EB023115E6339B995AD6B7D689A9F93", hash_generated_field = "9D4D54DDE764894645FC52FC91277E50")

    public static final String HEAD = "HEAD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "2E41B8A44613DFC2DC7D9ABDD9A54F71", hash_generated_field = "E1CC0B0C363C6ED3911B7D42106C6309")

    public static final String POST = "POST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "36CA0BF57B18F565791F4CC64085CB13", hash_generated_field = "0C7FB5010BE834F9DA1BFD4988D58338")

    public static final String PUT = "PUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "193E03171E9BC50666674B4CA37F5468", hash_generated_field = "1B51986BA354384092C9D21D57469B62")

    public static final String DELETE = "DELETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "572ABF572D6328607FDF99B6029F366B", hash_generated_field = "0B4C0DE7A5C62D773DAD965884CD9ABC")

    public static final String TRACE = "TRACE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "E35ADA7E7F709AFF425FE40F47A697E8", hash_generated_field = "6A7F1D2ACB0C8D38F6BE4D6916E1666A")

    public static final String CONNECT = "CONNECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "FE1B4FE715B9F02FFE1E6B9B4788F1B7", hash_generated_field = "8107271903E3CAA2DAF157178E86D883")

    public static final int HTTP_CONTINUE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.267 -0400", hash_original_field = "CCE4730ADCD6D37765227D59B7F1A593", hash_generated_field = "B2E878E710839ED7576796ECBCA1C49C")

    public static final int MAX_REDIRECTS = 5;
}

