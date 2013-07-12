package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.275 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "10F140AB3529378738DBDEC5DAB46D42")

    protected HttpURLConnectionImpl policy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.275 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "B3D99257499D27549F028C5AD75C86B0", hash_generated_field = "F290F176FDAB7CFB2CA524D383F761B2")

    private ResponseSource responseSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "75AB93228F6DCAE1755313947EC33E63")

    protected HttpConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "69CDF51B14212ECA16FCCC826AB99D52", hash_generated_field = "933C36367DBB638C304659EC3CE47516")

    private InputStream socketIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "E4EF4FCDDB2EB2FC355EEED04D1696B4", hash_generated_field = "39983E65AC7A55E9EA11E4F742E77B1E")

    private OutputStream requestOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "53CE5C37EA7680F830110251466C44CD", hash_generated_field = "C2D66FBA681404DC7AF350EE623C0860")

    private AbstractHttpOutputStream requestBodyOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "D46EABEC025443DFEFD6A04BAC15947A", hash_generated_field = "3B099B70D4FFF6286391C7CE8061D62D")

    private InputStream responseBodyIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "54287229D483AC3CA3E8EB5C4A736F16", hash_generated_field = "1F19E961A3B4F1C13A1EF03108380C81")

    private final ResponseCache responseCache = ResponseCache.getDefault();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "6453E8CAAF9350A66BD46394D5A6CE08", hash_generated_field = "AD49865A8688A75CE7F76CFDCE3EF6E0")

    private CacheResponse cacheResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "58E157FA6A49A1EC60FEBC3530BD26A5", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.276 -0400", hash_original_field = "D93E4E0D5913F802E2DBC0259518E915", hash_generated_field = "56E6E961645E2EBB7A5C3DD20FD9692C")

    private long sentRequestMillis = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "4816879B2302A4B54773D1E40854FDA6", hash_generated_field = "4EBB07D2648B3D849030D220C4A105C6")

    private boolean transparentGzip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "0C4F4D11DD2B8C6B56EE801110ADB9B0", hash_generated_field = "28AC40F22099010DD7EC3C28A2701903")

    boolean sendChunked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "D2013170F9870890E8C8E9E0851CA83E", hash_generated_field = "080B467195B9452EC670BEC2B6B507A0")

    private RequestHeaders requestHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "88AD2D36D7618A24DA38DA33CE55CF56")

    private ResponseHeaders responseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.277 -0400", hash_original_field = "5C96D0EB75A935F303BE7B89E1F4F8C8", hash_generated_field = "FFEE168D4CB4772A0F008367723F4DCB")

    private ResponseHeaders cachedResponseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.279 -0400", hash_original_field = "70639960D7DCB2C7D1392C0333153519", hash_generated_field = "9AC6636989AABA65466C0761ABE1A1EE")

    private InputStream cachedResponseBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.279 -0400", hash_original_field = "5979C14BCFBBC58C6232B38F5526796E", hash_generated_field = "583B8E5019F7D6ABD319DE61C9CB145F")

    private boolean automaticallyReleaseConnectionToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.279 -0400", hash_original_field = "C290CDC8785F6260FD3F82BED8FFC733", hash_generated_field = "0385A75ADFAFB5B890C6C920CD19DE25")

    private boolean connectionReleased;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.281 -0400", hash_original_method = "40A41D57A5E6AC75A04C66EEBA0108AA", hash_generated_method = "E6C466BD58C00DE05E705EC2BFC9BC4F")
    public  HttpEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBodyOut) throws IOException {
        this.policy = policy;
        this.method = method;
        this.connection = connection;
        this.requestBodyOut = requestBodyOut;
        try 
        {
            uri = policy.getURL().toURILenient();
        } 
        catch (URISyntaxException e)
        {
            IOException var0AFB0468CE17165C7EF7344B3E18B39B_1072318207 = new IOException(e);
            var0AFB0468CE17165C7EF7344B3E18B39B_1072318207.addTaint(taint);
            throw var0AFB0468CE17165C7EF7344B3E18B39B_1072318207;
        } 
        this.requestHeaders = new RequestHeaders(uri, new RawHeaders(requestHeaders));
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.282 -0400", hash_original_method = "B90EC93300E2D6FABAAF6B3D0678EFB4", hash_generated_method = "276C1B16E9FFC73A037ED34458F25A88")
    public final void sendRequest() throws IOException {
    if(responseSource != null)        
        {
            return;
        } 
        prepareRawRequestHeaders();
        initResponseSource();
    if(responseCache instanceof HttpResponseCache)        
        {
            ((HttpResponseCache) responseCache).trackResponse(responseSource);
        } 
    if(requestHeaders.isOnlyIfCached() && responseSource.requiresConnection())        
        {
    if(responseSource == ResponseSource.CONDITIONAL_CACHE)            
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } 
            this.responseSource = ResponseSource.CACHE;
            this.cacheResponse = BAD_GATEWAY_RESPONSE;
            RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(cacheResponse.getHeaders());
            setResponse(new ResponseHeaders(uri, rawResponseHeaders), cacheResponse.getBody());
        } 
    if(responseSource.requiresConnection())        
        {
            sendSocketRequest();
        } 
        else
    if(connection != null)        
        {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.283 -0400", hash_original_method = "F2FA78DDC7B88A7A9FD4B961BDAA52C1", hash_generated_method = "F6792073282F389C1871B6B69A4C6854")
    private void initResponseSource() throws IOException {
        responseSource = ResponseSource.NETWORK;
    if(!policy.getUseCaches() || responseCache == null)        
        {
            return;
        } 
        CacheResponse candidate = responseCache.get(uri, method,
                requestHeaders.getHeaders().toMultimap());
    if(candidate == null)        
        {
            return;
        } 
        Map<String, List<String>> responseHeadersMap = candidate.getHeaders();
        cachedResponseBody = candidate.getBody();
    if(!acceptCacheResponseType(candidate)
                || responseHeadersMap == null
                || cachedResponseBody == null)        
        {
            IoUtils.closeQuietly(cachedResponseBody);
            return;
        } 
        RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(responseHeadersMap);
        cachedResponseHeaders = new ResponseHeaders(uri, rawResponseHeaders);
        long now = System.currentTimeMillis();
        this.responseSource = cachedResponseHeaders.chooseResponseSource(now, requestHeaders);
    if(responseSource == ResponseSource.CACHE)        
        {
            this.cacheResponse = candidate;
            setResponse(cachedResponseHeaders, cachedResponseBody);
        } 
        else
    if(responseSource == ResponseSource.CONDITIONAL_CACHE)        
        {
            this.cacheResponse = candidate;
        } 
        else
    if(responseSource == ResponseSource.NETWORK)        
        {
            IoUtils.closeQuietly(cachedResponseBody);
        } 
        else
        {
            AssertionError varA81442E36297E737EB908877E58260E8_880044384 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_880044384.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_880044384;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.284 -0400", hash_original_method = "22FB1B3BCF67C2C3EB9ADF307D5A559C", hash_generated_method = "C9B1D9C58044F17196953A2BA072FAA4")
    private void sendSocketRequest() throws IOException {
    if(connection == null)        
        {
            connect();
        } 
    if(socketOut != null || requestOut != null || socketIn != null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_568711898 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_568711898.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_568711898;
        } 
        socketOut = connection.getOutputStream();
        requestOut = socketOut;
        socketIn = connection.getInputStream();
    if(hasRequestBody())        
        {
            initRequestBodyOut();
        } 
        
        
            
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.284 -0400", hash_original_method = "2D119148BD5E3059D34FC5038B3E143C", hash_generated_method = "5AB6D55BFD0CFA7609F8F0FBC67C438B")
    protected void connect() throws IOException {
    if(connection == null)        
        {
            connection = openSocketConnection();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.285 -0400", hash_original_method = "191E23F5B6629C7E64418EFD4A3F2A23", hash_generated_method = "AD130D506BE6264C3791033AC33482FE")
    protected final HttpConnection openSocketConnection() throws IOException {
        HttpConnection result = HttpConnection.connect(
                uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        Proxy proxy = result.getAddress().getProxy();
    if(proxy != null)        
        {
            policy.setProxy(proxy);
        } 
        result.setSoTimeout(policy.getReadTimeout());
HttpConnection varDC838461EE2FA0CA4C9BBB70A15456B0_8088906 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_8088906.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_8088906;
        
        
                
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.286 -0400", hash_original_method = "54D96F75BB859B6FCC0E9DF779F84B99", hash_generated_method = "850EC211AAFF634B7ABD4F00065DE255")
    protected void initRequestBodyOut() throws IOException {
        int chunkLength = policy.getChunkLength();
    if(chunkLength > 0 || requestHeaders.isChunked())        
        {
            sendChunked = true;
    if(chunkLength == -1)            
            {
                chunkLength = DEFAULT_CHUNK_LENGTH;
            } 
        } 
    if(socketOut == null)        
        {
            IllegalStateException varE127A39FD6F2C7433080153C389658F8_698886019 = new IllegalStateException("No socket to write to; was a POST cached?");
            varE127A39FD6F2C7433080153C389658F8_698886019.addTaint(taint);
            throw varE127A39FD6F2C7433080153C389658F8_698886019;
        } 
    if(httpMinorVersion == 0)        
        {
            sendChunked = false;
        } 
        int fixedContentLength = policy.getFixedContentLength();
    if(requestBodyOut != null)        
        {
        } 
        else
    if(fixedContentLength != -1)        
        {
            writeRequestHeaders(fixedContentLength);
            requestBodyOut = new FixedLengthOutputStream(requestOut, fixedContentLength);
        } 
        else
    if(sendChunked)        
        {
            writeRequestHeaders(-1);
            requestBodyOut = new ChunkedOutputStream(requestOut, chunkLength);
        } 
        else
    if(requestHeaders.getContentLength() != -1)        
        {
            writeRequestHeaders(requestHeaders.getContentLength());
            requestBodyOut = new RetryableOutputStream(requestHeaders.getContentLength());
        } 
        else
        {
            requestBodyOut = new RetryableOutputStream();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.287 -0400", hash_original_method = "5E913F4CB8B308A1D4F5DA7B9ED80F77", hash_generated_method = "F318698F230ED81AF2AB010C04CCBF92")
    private void setResponse(ResponseHeaders headers, InputStream body) throws IOException {
        addTaint(body.getTaint());
    if(this.responseBodyIn != null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_36502780 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_36502780.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_36502780;
        } 
        this.responseHeaders = headers;
        this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
    if(body != null)        
        {
            initContentStream(body);
        } 
        
        
            
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.288 -0400", hash_original_method = "A2A25877F13CAB8F3B2570F0DD573D04", hash_generated_method = "863AE80409E810917F173217431030C8")
    private boolean hasRequestBody() {
        boolean var7BF322D53CABE151F96748E495E6F498_2129723469 = (method == POST || method == PUT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889087076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889087076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.288 -0400", hash_original_method = "C7FD66AD45D049BA30B9133E737F62A7", hash_generated_method = "C92AFA44EE9370DA5172298D4EA4AAC2")
    public final OutputStream getRequestBody() {
    if(responseSource == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_129459214 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_129459214.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_129459214;
        } 
OutputStream var9DC46B2BACB0B01C659B74CD62B00382_620483990 =         requestBodyOut;
        var9DC46B2BACB0B01C659B74CD62B00382_620483990.addTaint(taint);
        return var9DC46B2BACB0B01C659B74CD62B00382_620483990;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.288 -0400", hash_original_method = "9AE95190B8E2C9C0E3A7C6677534EAD2", hash_generated_method = "9AAC59D5DB4BCDF9A97BA11D59B936E1")
    public final boolean hasResponse() {
        boolean var1E9A7D6C9864EED2DD7331E4D534613E_979714728 = (responseHeaders != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954051423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954051423;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.289 -0400", hash_original_method = "22C8454720634D9B77E5CFB8983F80A0", hash_generated_method = "3EFB7B5C1EF559BF6B3A6D13FAE8F71D")
    public final RequestHeaders getRequestHeaders() {
RequestHeaders var865DB0B8CD374F1022AF1F2AA435EB1D_1076301780 =         requestHeaders;
        var865DB0B8CD374F1022AF1F2AA435EB1D_1076301780.addTaint(taint);
        return var865DB0B8CD374F1022AF1F2AA435EB1D_1076301780;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.289 -0400", hash_original_method = "4093002B56979B81D9123217E2215EFB", hash_generated_method = "89F587FC810C37AD58EFDA6B4D6CA98E")
    public final ResponseHeaders getResponseHeaders() {
    if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_56809789 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_56809789.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_56809789;
        } 
ResponseHeaders var028B03401730B4B2430034F8F93178D6_1873342641 =         responseHeaders;
        var028B03401730B4B2430034F8F93178D6_1873342641.addTaint(taint);
        return var028B03401730B4B2430034F8F93178D6_1873342641;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.289 -0400", hash_original_method = "6C8D632B120ECD201D125D0086576F82", hash_generated_method = "ADBBE1D902DDC202AEE8AF41B45B6BD2")
    public final int getResponseCode() {
    if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2029249725 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2029249725.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2029249725;
        } 
        int var1D38D2E5D714633D7016AA7186B7C917_1299535101 = (responseHeaders.getHeaders().getResponseCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398543088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398543088;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.290 -0400", hash_original_method = "FBE346C8B51CB8E76028C21E64D6BD0A", hash_generated_method = "2CEEA293D169E75B4B9842D6C5F4EAC0")
    public final InputStream getResponseBody() {
    if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_629409649 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_629409649.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_629409649;
        } 
InputStream var32C44555E939E90398BD43EABC877C1F_597859180 =         responseBodyIn;
        var32C44555E939E90398BD43EABC877C1F_597859180.addTaint(taint);
        return var32C44555E939E90398BD43EABC877C1F_597859180;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.290 -0400", hash_original_method = "2250F4C87B4A22443F60D9654505E9D2", hash_generated_method = "AF8C6A3C5B60016ABB7C633D996330B4")
    public final CacheResponse getCacheResponse() {
    if(responseHeaders == null)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1768325679 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1768325679.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1768325679;
        } 
CacheResponse varABFB30EDCA8832B555B64AC56016D834_1207653961 =         cacheResponse;
        varABFB30EDCA8832B555B64AC56016D834_1207653961.addTaint(taint);
        return varABFB30EDCA8832B555B64AC56016D834_1207653961;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.291 -0400", hash_original_method = "9105CAFA0117096F163A50885E7429CB", hash_generated_method = "6A4AB500197A0ABBBFEC28F809BA7E86")
    public final HttpConnection getConnection() {
HttpConnection var9911BB1C5F1522C1630847C40E8BC67E_680380749 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_680380749.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_680380749;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.291 -0400", hash_original_method = "A7591895A9BC485B929D9D45A1C9BC76", hash_generated_method = "5E58FC8B2B60D9247D69B43246E5938F")
    protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        addTaint(cacheResponse.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_39621496 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057705860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057705860;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.291 -0400", hash_original_method = "E0679987436CD4859195D8429BAB78FF", hash_generated_method = "8305E80E9454B8B4E0D7284DD7CE6D76")
    private void maybeCache() throws IOException {
    if(!policy.getUseCaches() || responseCache == null)        
        {
            return;
        } 
    if(!responseHeaders.isCacheable(requestHeaders))        
        {
            return;
        } 
        cacheRequest = responseCache.put(uri, getHttpConnectionToCache());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.292 -0400", hash_original_method = "CA4844B1B3E4576C0EA18E04D34BB6CE", hash_generated_method = "1D0ED8B19D3FE2F501F85DDA956BD0B3")
    protected HttpURLConnection getHttpConnectionToCache() {
HttpURLConnection var2938A9ABA11B2DDD5ADB24059ADA8326_330933119 =         policy;
        var2938A9ABA11B2DDD5ADB24059ADA8326_330933119.addTaint(taint);
        return var2938A9ABA11B2DDD5ADB24059ADA8326_330933119;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.292 -0400", hash_original_method = "5482932EB1112689442580A552BBCA6A", hash_generated_method = "472F6C8958D34A11E52660BF79414A2D")
    public final void automaticallyReleaseConnectionToPool() {
        automaticallyReleaseConnectionToPool = true;
    if(connection != null && connectionReleased)        
        {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.293 -0400", hash_original_method = "648343BC3C2ABC6FA7BF932A2F48012C", hash_generated_method = "F6BC79D9FF841B43C794A9551679B515")
    public final void release(boolean reusable) {
        addTaint(reusable);
    if(responseBodyIn == cachedResponseBody)        
        {
            IoUtils.closeQuietly(responseBodyIn);
        } 
    if(!connectionReleased && connection != null)        
        {
            connectionReleased = true;
    if(requestBodyOut != null && !requestBodyOut.closed)            
            {
                reusable = false;
            } 
    if(hasConnectionCloseHeader())            
            {
                reusable = false;
            } 
    if(responseBodyIn instanceof UnknownLengthHttpInputStream)            
            {
                reusable = false;
            } 
    if(reusable && responseBodyIn != null)            
            {
                try 
                {
                    Streams.skipAll(responseBodyIn);
                } 
                catch (IOException e)
                {
                    reusable = false;
                } 
            } 
    if(!reusable)            
            {
                connection.closeSocketAndStreams();
                connection = null;
            } 
            else
    if(automaticallyReleaseConnectionToPool)            
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.294 -0400", hash_original_method = "EC59FCFED738418E26EF637931185263", hash_generated_method = "FC69546D250ABB82477413E1BB635A2D")
    private void initContentStream(InputStream transferStream) throws IOException {
    if(transparentGzip && responseHeaders.isContentEncodingGzip())        
        {
            responseHeaders.stripContentEncoding();
            responseBodyIn = new GZIPInputStream(transferStream);
        } 
        else
        {
            responseBodyIn = transferStream;
        } 
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.295 -0400", hash_original_method = "1AB921196A345CEE857EE600A5FD99DD", hash_generated_method = "3856D722D3DA96E64B8D194A89417ECE")
    private InputStream getTransferStream() throws IOException {
    if(!hasResponseBody())        
        {
InputStream varD4DA5D12471E107E08025939F8ECE54C_2062824023 =             new FixedLengthInputStream(socketIn, cacheRequest, this, 0);
            varD4DA5D12471E107E08025939F8ECE54C_2062824023.addTaint(taint);
            return varD4DA5D12471E107E08025939F8ECE54C_2062824023;
        } 
    if(responseHeaders.isChunked())        
        {
InputStream var96AA5673A64CAABFA4727C17C63F498B_869189186 =             new ChunkedInputStream(socketIn, cacheRequest, this);
            var96AA5673A64CAABFA4727C17C63F498B_869189186.addTaint(taint);
            return var96AA5673A64CAABFA4727C17C63F498B_869189186;
        } 
    if(responseHeaders.getContentLength() != -1)        
        {
InputStream var98822C7C607BC835C446A1B22D9F0684_863108762 =             new FixedLengthInputStream(socketIn, cacheRequest, this,
                    responseHeaders.getContentLength());
            var98822C7C607BC835C446A1B22D9F0684_863108762.addTaint(taint);
            return var98822C7C607BC835C446A1B22D9F0684_863108762;
        } 
InputStream var57DE3C7FFFE9F62D1BD7BCCB2F749217_407998022 =         new UnknownLengthHttpInputStream(socketIn, cacheRequest, this);
        var57DE3C7FFFE9F62D1BD7BCCB2F749217_407998022.addTaint(taint);
        return var57DE3C7FFFE9F62D1BD7BCCB2F749217_407998022;
        
        
            
        
        
            
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.296 -0400", hash_original_method = "E5EB74DB686CEF76B63FEE327FA34FC3", hash_generated_method = "AE5F354E12FD886A3F3E8823367762B1")
    private void readResponseHeaders() throws IOException {
        RawHeaders headers;
        do {
            {
                headers = new RawHeaders();
                headers.setStatusLine(Streams.readAsciiLine(socketIn));
                readHeaders(headers);
            } 
} while (headers.getResponseCode() == HTTP_CONTINUE);
        setResponse(new ResponseHeaders(uri, headers), null);
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.296 -0400", hash_original_method = "C50EFF03D3756AF141D5513AF20FE391", hash_generated_method = "27BA468DF120ADE9D881648D3C0ACEC9")
    public final boolean hasResponseBody() {
        int responseCode = responseHeaders.getHeaders().getResponseCode();
    if(method != HEAD
                && method != CONNECT
                && (responseCode < HTTP_CONTINUE || responseCode >= 200)
                && responseCode != HttpURLConnectionImpl.HTTP_NO_CONTENT
                && responseCode != HttpURLConnectionImpl.HTTP_NOT_MODIFIED)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_816456223 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371488237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371488237;
        } 
    if(responseHeaders.getContentLength() != -1 || responseHeaders.isChunked())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1555781508 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839840845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839840845;
        } 
        boolean var68934A3E9455FA72420237EB05902327_824430253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392338584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392338584;
        
        
        
                
                
                
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.297 -0400", hash_original_method = "017F163869C61C64FB5708C2B3013CCB", hash_generated_method = "F672A3A361C8D11DFA099C224F5A5D25")
    final void readTrailers() throws IOException {
        readHeaders(responseHeaders.getHeaders());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.297 -0400", hash_original_method = "814E7EB33C3A4672039AF7BE1F530F36", hash_generated_method = "62BEDC62121F07AA264B6585F7BB649F")
    private void readHeaders(RawHeaders headers) throws IOException {
        addTaint(headers.getTaint());
        String line;
        while
(!(line = Streams.readAsciiLine(socketIn)).isEmpty())        
        {
            headers.addLine(line);
        } 
        CookieHandler cookieHandler = CookieHandler.getDefault();
    if(cookieHandler != null)        
        {
            cookieHandler.put(uri, headers.toMultimap());
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.298 -0400", hash_original_method = "6D117EBD96F306FC6CE6929186DDBA19", hash_generated_method = "7CC539AAB5AB65BFC1226C951AC5B54C")
    private void writeRequestHeaders(int contentLength) throws IOException {
    if(sentRequestMillis != -1)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2034617181 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2034617181.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2034617181;
        } 
        RawHeaders headersToSend = getNetworkRequestHeaders();
        byte[] bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);
    if(contentLength != -1 && bytes.length + contentLength <= MAX_REQUEST_BUFFER_LENGTH)        
        {
            requestOut = new BufferedOutputStream(socketOut, bytes.length + contentLength);
        } 
        sentRequestMillis = System.currentTimeMillis();
        requestOut.write(bytes);
        
        
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.298 -0400", hash_original_method = "E663539B4C2FF814BF16D6A04E975935", hash_generated_method = "83C7303CBA7B1DCB8F42FB83CA19051A")
    protected RawHeaders getNetworkRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        int fixedContentLength = policy.getFixedContentLength();
    if(fixedContentLength != -1)        
        {
            requestHeaders.setContentLength(fixedContentLength);
        } 
        else
    if(sendChunked)        
        {
            requestHeaders.setChunked();
        } 
        else
    if(requestBodyOut instanceof RetryableOutputStream)        
        {
            int contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            requestHeaders.setContentLength(contentLength);
        } 
RawHeaders var519CFA10080DFE28BEEEB2CBF346A2C7_1245092529 =         requestHeaders.getHeaders();
        var519CFA10080DFE28BEEEB2CBF346A2C7_1245092529.addTaint(taint);
        return var519CFA10080DFE28BEEEB2CBF346A2C7_1245092529;
        
        
        
        
            
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.299 -0400", hash_original_method = "9965AB400B31D225B507F0BE101C0DB2", hash_generated_method = "AC1470CEEF0B1C13B561ED8DE71AE61E")
    private void prepareRawRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
    if(requestHeaders.getUserAgent() == null)        
        {
            requestHeaders.setUserAgent(getDefaultUserAgent());
        } 
    if(requestHeaders.getHost() == null)        
        {
            requestHeaders.setHost(getOriginAddress(policy.getURL()));
        } 
    if(httpMinorVersion > 0 && requestHeaders.getConnection() == null)        
        {
            requestHeaders.setConnection("Keep-Alive");
        } 
    if(requestHeaders.getAcceptEncoding() == null)        
        {
            transparentGzip = true;
            requestHeaders.setAcceptEncoding("gzip");
        } 
    if(hasRequestBody() && requestHeaders.getContentType() == null)        
        {
            requestHeaders.setContentType("application/x-www-form-urlencoded");
        } 
        long ifModifiedSince = policy.getIfModifiedSince();
    if(ifModifiedSince != 0)        
        {
            requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        } 
        CookieHandler cookieHandler = CookieHandler.getDefault();
    if(cookieHandler != null)        
        {
            requestHeaders.addCookies(
                    cookieHandler.get(uri, requestHeaders.getHeaders().toMultimap()));
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.300 -0400", hash_original_method = "6DB81453AD78E43D72799E90FBF820CD", hash_generated_method = "5699093CC132128A9F6CC52880F36DF8")
    private String getRequestLine() {
        String protocol = (httpMinorVersion == 0) ? "HTTP/1.0" : "HTTP/1.1";
String var354790A4CDCD0E4790130001D198CEE6_1598873662 =         method + " " + requestString() + " " + protocol;
        var354790A4CDCD0E4790130001D198CEE6_1598873662.addTaint(taint);
        return var354790A4CDCD0E4790130001D198CEE6_1598873662;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.300 -0400", hash_original_method = "579F0C1DEDB2C71B061424762EDA3D6F", hash_generated_method = "4977431D665362E17C33EC115D177859")
    private String requestString() {
        URL url = policy.getURL();
    if(includeAuthorityInRequestLine())        
        {
String var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1402795662 =             url.toString();
            var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1402795662.addTaint(taint);
            return var6F1AA6A20537DBEE6EBCEC4D599BD4C1_1402795662;
        } 
        else
        {
            String fileOnly = url.getFile();
    if(fileOnly == null)            
            {
                fileOnly = "/";
            } 
            else
    if(!fileOnly.startsWith("/"))            
            {
                fileOnly = "/" + fileOnly;
            } 
String var8F11DF4CD82F23DA56825A33AFAD48E3_1182824229 =             fileOnly;
            var8F11DF4CD82F23DA56825A33AFAD48E3_1182824229.addTaint(taint);
            return var8F11DF4CD82F23DA56825A33AFAD48E3_1182824229;
        } 
        
        
        
            
        
            
            
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.301 -0400", hash_original_method = "A86C65F03AA643F0D379154D6D12D2B7", hash_generated_method = "372DB79A651DD2FA0504C474A7F2DA2B")
    protected boolean includeAuthorityInRequestLine() {
        boolean var7A8C17F3484750D3A640DBB738A600A2_1033743315 = (policy.usingProxy());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911794768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911794768;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.301 -0400", hash_original_method = "B0560F32D5938C3FB1E508A1DA2A4958", hash_generated_method = "4CF4107731029EA963B478062D75EC9A")
    protected final String getDefaultUserAgent() {
        String agent = System.getProperty("http.agent");
String var168860BF941C60021F0D3FD4053F3575_783580296 =         agent != null ? agent : ("Java" + System.getProperty("java.version"));
        var168860BF941C60021F0D3FD4053F3575_783580296.addTaint(taint);
        return var168860BF941C60021F0D3FD4053F3575_783580296;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.301 -0400", hash_original_method = "0A452E6BAC82BB82543FC0DC64DC1250", hash_generated_method = "334BD55B279D6D7BD871EAC52272867D")
    private boolean hasConnectionCloseHeader() {
        boolean var3AB3A1EC01D9127625B8032ED2758C32_2085523414 = ((responseHeaders != null && responseHeaders.hasConnectionClose())
                || requestHeaders.hasConnectionClose());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93185114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93185114;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.302 -0400", hash_original_method = "71D2D2A43E6B9B2FCF0835DDEF471DCE", hash_generated_method = "D83AD9D842EEA6BF2C1BCB93E3D4E8DF")
    protected final String getOriginAddress(URL url) {
        addTaint(url.getTaint());
        int port = url.getPort();
        String result = url.getHost();
    if(port > 0 && port != policy.getDefaultPort())        
        {
            result = result + ":" + port;
        } 
String varDC838461EE2FA0CA4C9BBB70A15456B0_642911945 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_642911945.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_642911945;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.302 -0400", hash_original_method = "E79001B5362EC94E0060C3FC14A22DCF", hash_generated_method = "984D1F8FE088A4C6DC645B68D998D284")
    protected boolean requiresTunnel() {
        boolean var68934A3E9455FA72420237EB05902327_1929221616 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403303058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403303058;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.303 -0400", hash_original_method = "1EEDE20F378BB56816783AF0AAE8D8C5", hash_generated_method = "96FAF2965196FE1DBDA433418678DB7D")
    public final void readResponse() throws IOException {
    if(hasResponse())        
        {
            return;
        } 
    if(responseSource == null)        
        {
            IllegalStateException var0DD186E17D5EDC68102F66A69CB92EE1_1545947769 = new IllegalStateException("readResponse() without sendRequest()");
            var0DD186E17D5EDC68102F66A69CB92EE1_1545947769.addTaint(taint);
            throw var0DD186E17D5EDC68102F66A69CB92EE1_1545947769;
        } 
    if(!responseSource.requiresConnection())        
        {
            return;
        } 
    if(sentRequestMillis == -1)        
        {
            int contentLength = requestBodyOut instanceof RetryableOutputStream
                    ? ((RetryableOutputStream) requestBodyOut).contentLength()
                    : -1;
            writeRequestHeaders(contentLength);
        } 
    if(requestBodyOut != null)        
        {
            requestBodyOut.close();
    if(requestBodyOut instanceof RetryableOutputStream)            
            {
                ((RetryableOutputStream) requestBodyOut).writeToSocket(requestOut);
            } 
        } 
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
                } 
                release(true);
                setResponse(cachedResponseHeaders.combine(responseHeaders), cachedResponseBody);
                return;
            } 
            else
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } 
        } 
    if(hasResponseBody())        
        {
            maybeCache();
        } 
        initContentStream(getTransferStream());
        
        
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.303 -0400", hash_original_field = "C4FBD0DC576130A8CE5C84CD8120C301", hash_generated_field = "7F4ADBCA37973EB3682CE87E78171DEC")

    private static final int MAX_REQUEST_BUFFER_LENGTH = 32768;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "0F6E221759F88F702CA321737E37EE2B", hash_generated_field = "526B3DFF23C5F0AAA59C478051D61F5E")

    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "A9C3E01E9DC38700D201ECEB5C3B7EB0", hash_generated_field = "24A290CCF11DC3C02C7E5FA56409A521")

    public static final String OPTIONS = "OPTIONS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "2DEC4577BDE1A481702BFAD8DD379E31", hash_generated_field = "C8F8EB1723A4F1459E76ECA7A1B4FFEB")

    public static final String GET = "GET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "0EB023115E6339B995AD6B7D689A9F93", hash_generated_field = "9D4D54DDE764894645FC52FC91277E50")

    public static final String HEAD = "HEAD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "2E41B8A44613DFC2DC7D9ABDD9A54F71", hash_generated_field = "E1CC0B0C363C6ED3911B7D42106C6309")

    public static final String POST = "POST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "36CA0BF57B18F565791F4CC64085CB13", hash_generated_field = "0C7FB5010BE834F9DA1BFD4988D58338")

    public static final String PUT = "PUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "193E03171E9BC50666674B4CA37F5468", hash_generated_field = "1B51986BA354384092C9D21D57469B62")

    public static final String DELETE = "DELETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "572ABF572D6328607FDF99B6029F366B", hash_generated_field = "0B4C0DE7A5C62D773DAD965884CD9ABC")

    public static final String TRACE = "TRACE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "E35ADA7E7F709AFF425FE40F47A697E8", hash_generated_field = "6A7F1D2ACB0C8D38F6BE4D6916E1666A")

    public static final String CONNECT = "CONNECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "FE1B4FE715B9F02FFE1E6B9B4788F1B7", hash_generated_field = "8107271903E3CAA2DAF157178E86D883")

    public static final int HTTP_CONTINUE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.304 -0400", hash_original_field = "CCE4730ADCD6D37765227D59B7F1A593", hash_generated_field = "B2E878E710839ED7576796ECBCA1C49C")

    public static final int MAX_REDIRECTS = 5;
}

