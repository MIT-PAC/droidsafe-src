package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.876 -0400", hash_original_field = "F4AF8B5789576C000CE9105B25609BD6", hash_generated_field = "10F140AB3529378738DBDEC5DAB46D42")

    protected HttpURLConnectionImpl policy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.876 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.876 -0400", hash_original_field = "B3D99257499D27549F028C5AD75C86B0", hash_generated_field = "F290F176FDAB7CFB2CA524D383F761B2")

    private ResponseSource responseSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.876 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "75AB93228F6DCAE1755313947EC33E63")

    protected HttpConnection connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "69CDF51B14212ECA16FCCC826AB99D52", hash_generated_field = "933C36367DBB638C304659EC3CE47516")

    private InputStream socketIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "E4EF4FCDDB2EB2FC355EEED04D1696B4", hash_generated_field = "39983E65AC7A55E9EA11E4F742E77B1E")

    private OutputStream requestOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "53CE5C37EA7680F830110251466C44CD", hash_generated_field = "C2D66FBA681404DC7AF350EE623C0860")

    private AbstractHttpOutputStream requestBodyOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "D46EABEC025443DFEFD6A04BAC15947A", hash_generated_field = "3B099B70D4FFF6286391C7CE8061D62D")

    private InputStream responseBodyIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "54287229D483AC3CA3E8EB5C4A736F16", hash_generated_field = "1F19E961A3B4F1C13A1EF03108380C81")

    private final ResponseCache responseCache = ResponseCache.getDefault();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "6453E8CAAF9350A66BD46394D5A6CE08", hash_generated_field = "AD49865A8688A75CE7F76CFDCE3EF6E0")

    private CacheResponse cacheResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "58E157FA6A49A1EC60FEBC3530BD26A5", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "D93E4E0D5913F802E2DBC0259518E915", hash_generated_field = "56E6E961645E2EBB7A5C3DD20FD9692C")

    private long sentRequestMillis = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "4816879B2302A4B54773D1E40854FDA6", hash_generated_field = "4EBB07D2648B3D849030D220C4A105C6")

    private boolean transparentGzip;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "0C4F4D11DD2B8C6B56EE801110ADB9B0", hash_generated_field = "28AC40F22099010DD7EC3C28A2701903")

    boolean sendChunked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "D2013170F9870890E8C8E9E0851CA83E", hash_generated_field = "080B467195B9452EC670BEC2B6B507A0")

    private RequestHeaders requestHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "88AD2D36D7618A24DA38DA33CE55CF56")

    private ResponseHeaders responseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "5C96D0EB75A935F303BE7B89E1F4F8C8", hash_generated_field = "FFEE168D4CB4772A0F008367723F4DCB")

    private ResponseHeaders cachedResponseHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "70639960D7DCB2C7D1392C0333153519", hash_generated_field = "9AC6636989AABA65466C0761ABE1A1EE")

    private InputStream cachedResponseBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "5979C14BCFBBC58C6232B38F5526796E", hash_generated_field = "583B8E5019F7D6ABD319DE61C9CB145F")

    private boolean automaticallyReleaseConnectionToPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_field = "C290CDC8785F6260FD3F82BED8FFC733", hash_generated_field = "0385A75ADFAFB5B890C6C920CD19DE25")

    private boolean connectionReleased;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.877 -0400", hash_original_method = "40A41D57A5E6AC75A04C66EEBA0108AA", hash_generated_method = "14B9D2C934FFE29773C88AE0A9E6FEDE")
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
            if (DroidSafeAndroidRuntime.control) throw new IOException(e);
        } 
        this.requestHeaders = new RequestHeaders(uri, new RawHeaders(requestHeaders));
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.878 -0400", hash_original_method = "B90EC93300E2D6FABAAF6B3D0678EFB4", hash_generated_method = "75ED05CD3587D24D0485193C7FC2B538")
    public final void sendRequest() throws IOException {
        prepareRawRequestHeaders();
        initResponseSource();
        {
            ((HttpResponseCache) responseCache).trackResponse(responseSource);
        } 
        {
            boolean varFBE2A77EEB4D706301E2FE921CE84321_1702405917 = (requestHeaders.isOnlyIfCached() && responseSource.requiresConnection());
            {
                {
                    IoUtils.closeQuietly(cachedResponseBody);
                } 
                this.responseSource = ResponseSource.CACHE;
                this.cacheResponse = BAD_GATEWAY_RESPONSE;
                RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(cacheResponse.getHeaders());
                setResponse(new ResponseHeaders(uri, rawResponseHeaders), cacheResponse.getBody());
            } 
        } 
        {
            boolean varBB6B3912BFA49F0FFE4473A1165959CB_497176555 = (responseSource.requiresConnection());
            {
                sendSocketRequest();
            } 
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.879 -0400", hash_original_method = "F2FA78DDC7B88A7A9FD4B961BDAA52C1", hash_generated_method = "BFABB8979E090B5BDD20BAFFC3CE2FD2")
    private void initResponseSource() throws IOException {
        responseSource = ResponseSource.NETWORK;
        {
            boolean varCF9C7755EC0347CCE315779743B81752_1962892113 = (!policy.getUseCaches() || responseCache == null);
        } 
        CacheResponse candidate = responseCache.get(uri, method,
                requestHeaders.getHeaders().toMultimap());
        Map<String, List<String>> responseHeadersMap = candidate.getHeaders();
        cachedResponseBody = candidate.getBody();
        {
            boolean varF3C166F25D6AF03A45E6B9396B5E5848_1649687371 = (!acceptCacheResponseType(candidate)
                || responseHeadersMap == null
                || cachedResponseBody == null);
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } 
        } 
        RawHeaders rawResponseHeaders = RawHeaders.fromMultimap(responseHeadersMap);
        cachedResponseHeaders = new ResponseHeaders(uri, rawResponseHeaders);
        long now = System.currentTimeMillis();
        this.responseSource = cachedResponseHeaders.chooseResponseSource(now, requestHeaders);
        {
            this.cacheResponse = candidate;
            setResponse(cachedResponseHeaders, cachedResponseBody);
        } 
        {
            this.cacheResponse = candidate;
        } 
        {
            IoUtils.closeQuietly(cachedResponseBody);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.879 -0400", hash_original_method = "22FB1B3BCF67C2C3EB9ADF307D5A559C", hash_generated_method = "44D848AA49A7501CB55DFF8C39145BA6")
    private void sendSocketRequest() throws IOException {
        {
            connect();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        socketOut = connection.getOutputStream();
        requestOut = socketOut;
        socketIn = connection.getInputStream();
        {
            boolean var1E309B5C7C83E5613B25B397F1F4B685_1088338710 = (hasRequestBody());
            {
                initRequestBodyOut();
            } 
        } 
        
        
            
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.880 -0400", hash_original_method = "2D119148BD5E3059D34FC5038B3E143C", hash_generated_method = "174956E94091229760C1A1BF47C286CB")
    protected void connect() throws IOException {
        {
            connection = openSocketConnection();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.881 -0400", hash_original_method = "191E23F5B6629C7E64418EFD4A3F2A23", hash_generated_method = "2154703376942DAFCD258D3FC457A232")
    protected final HttpConnection openSocketConnection() throws IOException {
        HttpConnection varB4EAC82CA7396A68D541C85D26508E83_824163768 = null; 
        HttpConnection result = HttpConnection.connect(
                uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        Proxy proxy = result.getAddress().getProxy();
        {
            policy.setProxy(proxy);
        } 
        result.setSoTimeout(policy.getReadTimeout());
        varB4EAC82CA7396A68D541C85D26508E83_824163768 = result;
        varB4EAC82CA7396A68D541C85D26508E83_824163768.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_824163768;
        
        
                
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.882 -0400", hash_original_method = "54D96F75BB859B6FCC0E9DF779F84B99", hash_generated_method = "45732372E0AD96D870668739F0EF9230")
    protected void initRequestBodyOut() throws IOException {
        int chunkLength = policy.getChunkLength();
        {
            boolean var282D0275BACDE3AD4651EABBE1047DEF_1592960971 = (chunkLength > 0 || requestHeaders.isChunked());
            {
                sendChunked = true;
                {
                    chunkLength = DEFAULT_CHUNK_LENGTH;
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No socket to write to; was a POST cached?");
        } 
        {
            sendChunked = false;
        } 
        int fixedContentLength = policy.getFixedContentLength();
        {
            writeRequestHeaders(fixedContentLength);
            requestBodyOut = new FixedLengthOutputStream(requestOut, fixedContentLength);
        } 
        {
            writeRequestHeaders(-1);
            requestBodyOut = new ChunkedOutputStream(requestOut, chunkLength);
        } 
        {
            boolean var0BC04E4137F90E46C21B3D3E7622D123_9234356 = (requestHeaders.getContentLength() != -1);
            {
                writeRequestHeaders(requestHeaders.getContentLength());
                requestBodyOut = new RetryableOutputStream(requestHeaders.getContentLength());
            } 
            {
                requestBodyOut = new RetryableOutputStream();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.883 -0400", hash_original_method = "5E913F4CB8B308A1D4F5DA7B9ED80F77", hash_generated_method = "9E324034C21E859240EBF404BBD0C8E2")
    private void setResponse(ResponseHeaders headers, InputStream body) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        this.responseHeaders = headers;
        this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
        {
            initContentStream(body);
        } 
        addTaint(body.getTaint());
        
        
            
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.883 -0400", hash_original_method = "A2A25877F13CAB8F3B2570F0DD573D04", hash_generated_method = "9B17052E81F9CC436DB1A10A389888F3")
    private boolean hasRequestBody() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61793044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61793044;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.883 -0400", hash_original_method = "C7FD66AD45D049BA30B9133E737F62A7", hash_generated_method = "92D8213356DC65B1110068D221E292DD")
    public final OutputStream getRequestBody() {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_164955296 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_164955296 = requestBodyOut;
        varB4EAC82CA7396A68D541C85D26508E83_164955296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_164955296;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.883 -0400", hash_original_method = "9AE95190B8E2C9C0E3A7C6677534EAD2", hash_generated_method = "3309337FCE283C2B4280338D538D89F0")
    public final boolean hasResponse() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740183830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_740183830;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.884 -0400", hash_original_method = "22C8454720634D9B77E5CFB8983F80A0", hash_generated_method = "73FC1A03854672304D90475E2DCA30B5")
    public final RequestHeaders getRequestHeaders() {
        RequestHeaders varB4EAC82CA7396A68D541C85D26508E83_876663770 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_876663770 = requestHeaders;
        varB4EAC82CA7396A68D541C85D26508E83_876663770.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_876663770;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.884 -0400", hash_original_method = "4093002B56979B81D9123217E2215EFB", hash_generated_method = "AC975FC356BA72797577047EB7559BAE")
    public final ResponseHeaders getResponseHeaders() {
        ResponseHeaders varB4EAC82CA7396A68D541C85D26508E83_941091100 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_941091100 = responseHeaders;
        varB4EAC82CA7396A68D541C85D26508E83_941091100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_941091100;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.884 -0400", hash_original_method = "6C8D632B120ECD201D125D0086576F82", hash_generated_method = "F76DE6D456DEFCB9A626463513FF54AA")
    public final int getResponseCode() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        int var2629811C8400B32F9159279AF605E2F7_964943625 = (responseHeaders.getHeaders().getResponseCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037947660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037947660;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.885 -0400", hash_original_method = "FBE346C8B51CB8E76028C21E64D6BD0A", hash_generated_method = "17643F4027AFE5E2D11E64684A79E2F0")
    public final InputStream getResponseBody() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_557657998 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_557657998 = responseBodyIn;
        varB4EAC82CA7396A68D541C85D26508E83_557657998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_557657998;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.885 -0400", hash_original_method = "2250F4C87B4A22443F60D9654505E9D2", hash_generated_method = "E6C2A9FC4737306438532767829ECD0D")
    public final CacheResponse getCacheResponse() {
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1705081703 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1705081703 = cacheResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1705081703.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1705081703;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.886 -0400", hash_original_method = "9105CAFA0117096F163A50885E7429CB", hash_generated_method = "3F17CAD7548747EBBF88CD4FEFDB9692")
    public final HttpConnection getConnection() {
        HttpConnection varB4EAC82CA7396A68D541C85D26508E83_416470554 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_416470554 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_416470554.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_416470554;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.886 -0400", hash_original_method = "A7591895A9BC485B929D9D45A1C9BC76", hash_generated_method = "E8090501926668CE727D7A9FD5B39BB2")
    protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        addTaint(cacheResponse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881380824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881380824;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.886 -0400", hash_original_method = "E0679987436CD4859195D8429BAB78FF", hash_generated_method = "30B120116B3B589F27AE112984B0D7FC")
    private void maybeCache() throws IOException {
        {
            boolean varCF9C7755EC0347CCE315779743B81752_1292681884 = (!policy.getUseCaches() || responseCache == null);
        } 
        {
            boolean varCF80C2CFACFAD16BF0AB9ECDD125AC65_544335458 = (!responseHeaders.isCacheable(requestHeaders));
        } 
        cacheRequest = responseCache.put(uri, getHttpConnectionToCache());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.887 -0400", hash_original_method = "CA4844B1B3E4576C0EA18E04D34BB6CE", hash_generated_method = "FE58A130B71EDF8A862183284D606082")
    protected HttpURLConnection getHttpConnectionToCache() {
        HttpURLConnection varB4EAC82CA7396A68D541C85D26508E83_783956425 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_783956425 = policy;
        varB4EAC82CA7396A68D541C85D26508E83_783956425.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_783956425;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.887 -0400", hash_original_method = "5482932EB1112689442580A552BBCA6A", hash_generated_method = "8191FA30785F3E7B288A408F3AEC1135")
    public final void automaticallyReleaseConnectionToPool() {
        automaticallyReleaseConnectionToPool = true;
        {
            HttpConnectionPool.INSTANCE.recycle(connection);
            connection = null;
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.887 -0400", hash_original_method = "648343BC3C2ABC6FA7BF932A2F48012C", hash_generated_method = "5D78387661B25A7C6198DAD828157E88")
    public final void release(boolean reusable) {
        {
            IoUtils.closeQuietly(responseBodyIn);
        } 
        {
            connectionReleased = true;
            {
                reusable = false;
            } 
            {
                boolean varD474EBB65768A4B4B9F0FA0189BD2051_1547486550 = (hasConnectionCloseHeader());
                {
                    reusable = false;
                } 
            } 
            {
                reusable = false;
            } 
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
            {
                connection.closeSocketAndStreams();
                connection = null;
            } 
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } 
        } 
        addTaint(reusable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.888 -0400", hash_original_method = "EC59FCFED738418E26EF637931185263", hash_generated_method = "2E64A01E0C94EE55902177CF5D0EF6D9")
    private void initContentStream(InputStream transferStream) throws IOException {
        {
            boolean var10B7C508D1ED1B70DBB8B231FF168A18_1711226827 = (transparentGzip && responseHeaders.isContentEncodingGzip());
            {
                responseHeaders.stripContentEncoding();
                responseBodyIn = new GZIPInputStream(transferStream);
            } 
            {
                responseBodyIn = transferStream;
            } 
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.889 -0400", hash_original_method = "1AB921196A345CEE857EE600A5FD99DD", hash_generated_method = "D85C597EC7A96482510513E2678C6424")
    private InputStream getTransferStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1820928070 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1586852664 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_306479437 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1629367610 = null; 
        {
            boolean var222131CC331E330F9818A633D062A21E_429787832 = (!hasResponseBody());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1820928070 = new FixedLengthInputStream(socketIn, cacheRequest, this, 0);
            } 
        } 
        {
            boolean varCD2BBE67147BEB5C75571A22581AC678_1141332765 = (responseHeaders.isChunked());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1586852664 = new ChunkedInputStream(socketIn, cacheRequest, this);
            } 
        } 
        {
            boolean var27B191FB2EEF5BA2EB481257DC1DE119_1678164433 = (responseHeaders.getContentLength() != -1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_306479437 = new FixedLengthInputStream(socketIn, cacheRequest, this,
                    responseHeaders.getContentLength());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1629367610 = new UnknownLengthHttpInputStream(socketIn, cacheRequest, this);
        InputStream varA7E53CE21691AB073D9660D615818899_1938089657; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1938089657 = varB4EAC82CA7396A68D541C85D26508E83_1820928070;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1938089657 = varB4EAC82CA7396A68D541C85D26508E83_1586852664;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1938089657 = varB4EAC82CA7396A68D541C85D26508E83_306479437;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1938089657 = varB4EAC82CA7396A68D541C85D26508E83_1629367610;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1938089657.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1938089657;
        
        
            
        
        
            
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.889 -0400", hash_original_method = "E5EB74DB686CEF76B63FEE327FA34FC3", hash_generated_method = "446658C3700D65C349512DB76324F8D0")
    private void readResponseHeaders() throws IOException {
        RawHeaders headers;
        {
            headers = new RawHeaders();
            headers.setStatusLine(Streams.readAsciiLine(socketIn));
            readHeaders(headers);
        } 
        {
            boolean var61D8834F94DDCE7B9BEA9340DAA8CA93_1690272039 = (headers.getResponseCode() == HTTP_CONTINUE);
        } 
        setResponse(new ResponseHeaders(uri, headers), null);
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.890 -0400", hash_original_method = "C50EFF03D3756AF141D5513AF20FE391", hash_generated_method = "80E917E4AD06D14D5807CCD73972099B")
    public final boolean hasResponseBody() {
        int responseCode = responseHeaders.getHeaders().getResponseCode();
        {
            boolean var59F09BC6BA7895465F5EFC6A4E22007A_1776708430 = (responseHeaders.getContentLength() != -1 || responseHeaders.isChunked());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716702757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716702757;
        
        
        
                
                
                
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.890 -0400", hash_original_method = "017F163869C61C64FB5708C2B3013CCB", hash_generated_method = "F672A3A361C8D11DFA099C224F5A5D25")
    final void readTrailers() throws IOException {
        readHeaders(responseHeaders.getHeaders());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.891 -0400", hash_original_method = "814E7EB33C3A4672039AF7BE1F530F36", hash_generated_method = "2C16783A8EB7110CBE5A8AD99282AA94")
    private void readHeaders(RawHeaders headers) throws IOException {
        String line;
        {
            boolean var5764D7F705BA70AC3824F177622814D6_396227401 = (!(line = Streams.readAsciiLine(socketIn)).isEmpty());
            {
                headers.addLine(line);
            } 
        } 
        CookieHandler cookieHandler = CookieHandler.getDefault();
        {
            cookieHandler.put(uri, headers.toMultimap());
        } 
        addTaint(headers.getTaint());
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.892 -0400", hash_original_method = "6D117EBD96F306FC6CE6929186DDBA19", hash_generated_method = "4C3B222904DA8AFDB28212B0F49A7EC6")
    private void writeRequestHeaders(int contentLength) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        RawHeaders headersToSend = getNetworkRequestHeaders();
        byte[] bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);
        {
            requestOut = new BufferedOutputStream(socketOut, bytes.length + contentLength);
        } 
        sentRequestMillis = System.currentTimeMillis();
        requestOut.write(bytes);
        
        
            
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.893 -0400", hash_original_method = "E663539B4C2FF814BF16D6A04E975935", hash_generated_method = "53FB7C96725FA698ADB87ED07A950AEF")
    protected RawHeaders getNetworkRequestHeaders() throws IOException {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1381515078 = null; 
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        int fixedContentLength = policy.getFixedContentLength();
        {
            requestHeaders.setContentLength(fixedContentLength);
        } 
        {
            requestHeaders.setChunked();
        } 
        {
            int contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            requestHeaders.setContentLength(contentLength);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1381515078 = requestHeaders.getHeaders();
        varB4EAC82CA7396A68D541C85D26508E83_1381515078.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1381515078;
        
        
        
        
            
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.895 -0400", hash_original_method = "9965AB400B31D225B507F0BE101C0DB2", hash_generated_method = "A3B2B02EC5C74BAF70BC912DDD2D2792")
    private void prepareRawRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        {
            boolean var75B557150EA37168C28CB4A9730262F2_2130936973 = (requestHeaders.getUserAgent() == null);
            {
                requestHeaders.setUserAgent(getDefaultUserAgent());
            } 
        } 
        {
            boolean var9A46A7B18C684B3219ECA2964BB9FEE9_1542694064 = (requestHeaders.getHost() == null);
            {
                requestHeaders.setHost(getOriginAddress(policy.getURL()));
            } 
        } 
        {
            boolean varFF80AC1E5EB2B33915C57816332F2C2C_894948655 = (httpMinorVersion > 0 && requestHeaders.getConnection() == null);
            {
                requestHeaders.setConnection("Keep-Alive");
            } 
        } 
        {
            boolean var936092B0BC6CD864A641D62AF63A0F52_415587579 = (requestHeaders.getAcceptEncoding() == null);
            {
                transparentGzip = true;
                requestHeaders.setAcceptEncoding("gzip");
            } 
        } 
        {
            boolean var8F2B459197C3E9895D68A20592341CBB_173286240 = (hasRequestBody() && requestHeaders.getContentType() == null);
            {
                requestHeaders.setContentType("application/x-www-form-urlencoded");
            } 
        } 
        long ifModifiedSince = policy.getIfModifiedSince();
        {
            requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        } 
        CookieHandler cookieHandler = CookieHandler.getDefault();
        {
            requestHeaders.addCookies(
                    cookieHandler.get(uri, requestHeaders.getHeaders().toMultimap()));
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.895 -0400", hash_original_method = "6DB81453AD78E43D72799E90FBF820CD", hash_generated_method = "BD2F9170E6C992769588EBCADA20512B")
    private String getRequestLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1022831599 = null; 
        String protocol;
        protocol = "HTTP/1.0";
        protocol = "HTTP/1.1";
        varB4EAC82CA7396A68D541C85D26508E83_1022831599 = method + " " + requestString() + " " + protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1022831599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1022831599;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.896 -0400", hash_original_method = "579F0C1DEDB2C71B061424762EDA3D6F", hash_generated_method = "18CC54732824F7D60659C0BDA1EA947C")
    private String requestString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1969294170 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_29712814 = null; 
        URL url = policy.getURL();
        {
            boolean var77817063686EB8BBF3B76684926C979F_764368004 = (includeAuthorityInRequestLine());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1969294170 = url.toString();
            } 
            {
                String fileOnly = url.getFile();
                {
                    fileOnly = "/";
                } 
                {
                    boolean var496B9AC6AE68C834F2257095ECFB439C_576891609 = (!fileOnly.startsWith("/"));
                    {
                        fileOnly = "/" + fileOnly;
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_29712814 = fileOnly;
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_97959729; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_97959729 = varB4EAC82CA7396A68D541C85D26508E83_1969294170;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_97959729 = varB4EAC82CA7396A68D541C85D26508E83_29712814;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_97959729.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_97959729;
        
        
        
            
        
            
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.896 -0400", hash_original_method = "A86C65F03AA643F0D379154D6D12D2B7", hash_generated_method = "06B866F0B280423D5B3B3D801BB83EF9")
    protected boolean includeAuthorityInRequestLine() {
        boolean var19169BA9F9D3DE0B973D11E6A9633BBA_1785805132 = (policy.usingProxy());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421668337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421668337;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.897 -0400", hash_original_method = "B0560F32D5938C3FB1E508A1DA2A4958", hash_generated_method = "48D5D1AB920B82EB80E33A44A92DCEF7")
    protected final String getDefaultUserAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_39153709 = null; 
        String agent = System.getProperty("http.agent");
        varB4EAC82CA7396A68D541C85D26508E83_39153709 = agent != null ? agent : ("Java" + System.getProperty("java.version"));
        varB4EAC82CA7396A68D541C85D26508E83_39153709.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_39153709;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.897 -0400", hash_original_method = "0A452E6BAC82BB82543FC0DC64DC1250", hash_generated_method = "33A0053F8FAFF6489FD8315FB77812D5")
    private boolean hasConnectionCloseHeader() {
        boolean var69DD3B4AFE294E58876FCBB469D2F6A7_1767708369 = ((responseHeaders != null && responseHeaders.hasConnectionClose())
                || requestHeaders.hasConnectionClose());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329083735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329083735;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.898 -0400", hash_original_method = "71D2D2A43E6B9B2FCF0835DDEF471DCE", hash_generated_method = "1A318DA3E79F8D2C6FF45C5E7A981717")
    protected final String getOriginAddress(URL url) {
        String varB4EAC82CA7396A68D541C85D26508E83_377159980 = null; 
        int port = url.getPort();
        String result = url.getHost();
        {
            boolean varB9D32AA0ECABB77CA151A9D1AAA54613_2096187099 = (port > 0 && port != policy.getDefaultPort());
            {
                result = result + ":" + port;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_377159980 = result;
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_377159980.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_377159980;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.898 -0400", hash_original_method = "E79001B5362EC94E0060C3FC14A22DCF", hash_generated_method = "FB1728E301893E67ECBF591C9DA4E393")
    protected boolean requiresTunnel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242760795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242760795;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.899 -0400", hash_original_method = "1EEDE20F378BB56816783AF0AAE8D8C5", hash_generated_method = "A34D0755ED8A3EC11CDBA86BCD45B67F")
    public final void readResponse() throws IOException {
        {
            boolean varDF0268D132F74D014F3F570E15869B14_1607399672 = (hasResponse());
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("readResponse() without sendRequest()");
        } 
        {
            boolean var0D46027BF2368CE745271684E7C45B4D_920697866 = (!responseSource.requiresConnection());
        } 
        {
            int contentLength;
            contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            contentLength = -1;
            writeRequestHeaders(contentLength);
        } 
        {
            requestBodyOut.close();
            {
                ((RetryableOutputStream) requestBodyOut).writeToSocket(requestOut);
            } 
        } 
        requestOut.flush();
        requestOut = socketOut;
        readResponseHeaders();
        responseHeaders.setLocalTimestamps(sentRequestMillis, System.currentTimeMillis());
        {
            {
                boolean varDFDD7081C0807C56635421D271187FE6_1026984555 = (cachedResponseHeaders.validate(responseHeaders));
                {
                    {
                        ((HttpResponseCache) responseCache).trackConditionalCacheHit();
                    } 
                    release(true);
                    setResponse(cachedResponseHeaders.combine(responseHeaders), cachedResponseBody);
                } 
                {
                    IoUtils.closeQuietly(cachedResponseBody);
                } 
            } 
        } 
        {
            boolean varB52E59AE5848B0CFF2208EFF6ABF11C4_1503006587 = (hasResponseBody());
            {
                maybeCache();
            } 
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "C4FBD0DC576130A8CE5C84CD8120C301", hash_generated_field = "7F4ADBCA37973EB3682CE87E78171DEC")

    private static final int MAX_REQUEST_BUFFER_LENGTH = 32768;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "0F6E221759F88F702CA321737E37EE2B", hash_generated_field = "526B3DFF23C5F0AAA59C478051D61F5E")

    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "A9C3E01E9DC38700D201ECEB5C3B7EB0", hash_generated_field = "24A290CCF11DC3C02C7E5FA56409A521")

    public static final String OPTIONS = "OPTIONS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "2DEC4577BDE1A481702BFAD8DD379E31", hash_generated_field = "C8F8EB1723A4F1459E76ECA7A1B4FFEB")

    public static final String GET = "GET";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "0EB023115E6339B995AD6B7D689A9F93", hash_generated_field = "9D4D54DDE764894645FC52FC91277E50")

    public static final String HEAD = "HEAD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "2E41B8A44613DFC2DC7D9ABDD9A54F71", hash_generated_field = "E1CC0B0C363C6ED3911B7D42106C6309")

    public static final String POST = "POST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "36CA0BF57B18F565791F4CC64085CB13", hash_generated_field = "0C7FB5010BE834F9DA1BFD4988D58338")

    public static final String PUT = "PUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "193E03171E9BC50666674B4CA37F5468", hash_generated_field = "1B51986BA354384092C9D21D57469B62")

    public static final String DELETE = "DELETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "572ABF572D6328607FDF99B6029F366B", hash_generated_field = "0B4C0DE7A5C62D773DAD965884CD9ABC")

    public static final String TRACE = "TRACE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "E35ADA7E7F709AFF425FE40F47A697E8", hash_generated_field = "6A7F1D2ACB0C8D38F6BE4D6916E1666A")

    public static final String CONNECT = "CONNECT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "FE1B4FE715B9F02FFE1E6B9B4788F1B7", hash_generated_field = "8107271903E3CAA2DAF157178E86D883")

    public static final int HTTP_CONTINUE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.901 -0400", hash_original_field = "CCE4730ADCD6D37765227D59B7F1A593", hash_generated_field = "B2E878E710839ED7576796ECBCA1C49C")

    public static final int MAX_REDIRECTS = 5;
}

