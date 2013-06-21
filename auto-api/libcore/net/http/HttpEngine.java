package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected HttpURLConnectionImpl policy;
    protected String method;
    private ResponseSource responseSource;
    protected HttpConnection connection;
    private InputStream socketIn;
    private OutputStream socketOut;
    private OutputStream requestOut;
    private AbstractHttpOutputStream requestBodyOut;
    private InputStream responseBodyIn;
    private ResponseCache responseCache = ResponseCache.getDefault();
    private CacheResponse cacheResponse;
    private CacheRequest cacheRequest;
    private long sentRequestMillis = -1;
    private boolean transparentGzip;
    boolean sendChunked;
    private int httpMinorVersion = 1;
    private URI uri;
    private RequestHeaders requestHeaders;
    private ResponseHeaders responseHeaders;
    private ResponseHeaders cachedResponseHeaders;
    private InputStream cachedResponseBody;
    private boolean automaticallyReleaseConnectionToPool;
    private boolean connectionReleased;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.168 -0400", hash_original_method = "40A41D57A5E6AC75A04C66EEBA0108AA", hash_generated_method = "AF92FC028B32318505B813CB33759CC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpEngine(HttpURLConnectionImpl policy, String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBodyOut) throws IOException {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(requestHeaders.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(policy.dsTaint);
        dsTaint.addTaint(requestBodyOut.dsTaint);
        try 
        {
            uri = policy.getURL().toURILenient();
        } //End block
        catch (URISyntaxException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.169 -0400", hash_original_method = "B90EC93300E2D6FABAAF6B3D0678EFB4", hash_generated_method = "6F211207B6D8EC4F169FD10867352839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void sendRequest() throws IOException {
        prepareRawRequestHeaders();
        initResponseSource();
        {
            ((HttpResponseCache) responseCache).trackResponse(responseSource);
        } //End block
        {
            boolean varFBE2A77EEB4D706301E2FE921CE84321_1281248496 = (requestHeaders.isOnlyIfCached() && responseSource.requiresConnection());
            {
                {
                    IoUtils.closeQuietly(cachedResponseBody);
                } //End block
                this.responseSource = ResponseSource.CACHE;
                this.cacheResponse = BAD_GATEWAY_RESPONSE;
                RawHeaders rawResponseHeaders;
                rawResponseHeaders = RawHeaders.fromMultimap(cacheResponse.getHeaders());
                setResponse(new ResponseHeaders(uri, rawResponseHeaders), cacheResponse.getBody());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB6B3912BFA49F0FFE4473A1165959CB_147599947 = (responseSource.requiresConnection());
            {
                sendSocketRequest();
            } //End block
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.169 -0400", hash_original_method = "F2FA78DDC7B88A7A9FD4B961BDAA52C1", hash_generated_method = "20B1895B39356E4ADE7D5267467E7EFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initResponseSource() throws IOException {
        responseSource = ResponseSource.NETWORK;
        {
            boolean varCF9C7755EC0347CCE315779743B81752_1040111413 = (!policy.getUseCaches() || responseCache == null);
        } //End collapsed parenthetic
        CacheResponse candidate;
        candidate = responseCache.get(uri, method,
                requestHeaders.getHeaders().toMultimap());
        Map<String, List<String>> responseHeadersMap;
        responseHeadersMap = candidate.getHeaders();
        cachedResponseBody = candidate.getBody();
        {
            boolean varF3C166F25D6AF03A45E6B9396B5E5848_404660367 = (!acceptCacheResponseType(candidate)
                || responseHeadersMap == null
                || cachedResponseBody == null);
            {
                IoUtils.closeQuietly(cachedResponseBody);
            } //End block
        } //End collapsed parenthetic
        RawHeaders rawResponseHeaders;
        rawResponseHeaders = RawHeaders.fromMultimap(responseHeadersMap);
        cachedResponseHeaders = new ResponseHeaders(uri, rawResponseHeaders);
        long now;
        now = System.currentTimeMillis();
        this.responseSource = cachedResponseHeaders.chooseResponseSource(now, requestHeaders);
        {
            this.cacheResponse = candidate;
            setResponse(cachedResponseHeaders, cachedResponseBody);
        } //End block
        {
            this.cacheResponse = candidate;
        } //End block
        {
            IoUtils.closeQuietly(cachedResponseBody);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.169 -0400", hash_original_method = "22FB1B3BCF67C2C3EB9ADF307D5A559C", hash_generated_method = "6D96E51830E7120E4F14D7580DC1FFD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendSocketRequest() throws IOException {
        {
            connect();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        socketOut = connection.getOutputStream();
        requestOut = socketOut;
        socketIn = connection.getInputStream();
        {
            boolean var1E309B5C7C83E5613B25B397F1F4B685_1168660321 = (hasRequestBody());
            {
                initRequestBodyOut();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.170 -0400", hash_original_method = "2D119148BD5E3059D34FC5038B3E143C", hash_generated_method = "174956E94091229760C1A1BF47C286CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void connect() throws IOException {
        {
            connection = openSocketConnection();
        } //End block
        // ---------- Original Method ----------
        //if (connection == null) {
            //connection = openSocketConnection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.170 -0400", hash_original_method = "191E23F5B6629C7E64418EFD4A3F2A23", hash_generated_method = "F58B7CB47BDFC3F4E3F91165797A6D2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final HttpConnection openSocketConnection() throws IOException {
        HttpConnection result;
        result = HttpConnection.connect(
                uri, policy.getProxy(), requiresTunnel(), policy.getConnectTimeout());
        Proxy proxy;
        proxy = result.getAddress().getProxy();
        {
            policy.setProxy(proxy);
        } //End block
        result.setSoTimeout(policy.getReadTimeout());
        return (HttpConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.170 -0400", hash_original_method = "54D96F75BB859B6FCC0E9DF779F84B99", hash_generated_method = "0C41091E23206E44A7E33358A7F4EC9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initRequestBodyOut() throws IOException {
        int chunkLength;
        chunkLength = policy.getChunkLength();
        {
            boolean var282D0275BACDE3AD4651EABBE1047DEF_1645281493 = (chunkLength > 0 || requestHeaders.isChunked());
            {
                sendChunked = true;
                {
                    chunkLength = DEFAULT_CHUNK_LENGTH;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No socket to write to; was a POST cached?");
        } //End block
        {
            sendChunked = false;
        } //End block
        int fixedContentLength;
        fixedContentLength = policy.getFixedContentLength();
        {
            writeRequestHeaders(fixedContentLength);
            requestBodyOut = new FixedLengthOutputStream(requestOut, fixedContentLength);
        } //End block
        {
            writeRequestHeaders(-1);
            requestBodyOut = new ChunkedOutputStream(requestOut, chunkLength);
        } //End block
        {
            boolean var0BC04E4137F90E46C21B3D3E7622D123_1602327004 = (requestHeaders.getContentLength() != -1);
            {
                writeRequestHeaders(requestHeaders.getContentLength());
                requestBodyOut = new RetryableOutputStream(requestHeaders.getContentLength());
            } //End block
            {
                requestBodyOut = new RetryableOutputStream();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.170 -0400", hash_original_method = "5E913F4CB8B308A1D4F5DA7B9ED80F77", hash_generated_method = "1431520ADFC36B7EBDECB6E67730E4AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setResponse(ResponseHeaders headers, InputStream body) throws IOException {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(body.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        this.httpMinorVersion = responseHeaders.getHeaders().getHttpMinorVersion();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "A2A25877F13CAB8F3B2570F0DD573D04", hash_generated_method = "61D3DFCD3BBEE3A2127E5D25BFBBF2B2")
    @DSModeled(DSC.SAFE)
    private boolean hasRequestBody() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return method == POST || method == PUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "C7FD66AD45D049BA30B9133E737F62A7", hash_generated_method = "289A3515F2094FC32EF6BA42DC102CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final OutputStream getRequestBody() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (responseSource == null) {
            //throw new IllegalStateException();
        //}
        //return requestBodyOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "9AE95190B8E2C9C0E3A7C6677534EAD2", hash_generated_method = "9F28326FB361A13439D868D8447950F6")
    @DSModeled(DSC.SAFE)
    public final boolean hasResponse() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return responseHeaders != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "22C8454720634D9B77E5CFB8983F80A0", hash_generated_method = "688313DA03C20E2282CF3595B6667313")
    @DSModeled(DSC.SAFE)
    public final RequestHeaders getRequestHeaders() {
        return (RequestHeaders)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return requestHeaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "4093002B56979B81D9123217E2215EFB", hash_generated_method = "A36D03703078452A936EED6EE25715A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ResponseHeaders getResponseHeaders() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return (ResponseHeaders)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseHeaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.171 -0400", hash_original_method = "6C8D632B120ECD201D125D0086576F82", hash_generated_method = "3A45A824CEBF530918DCBD6E680BFB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getResponseCode() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        int var2629811C8400B32F9159279AF605E2F7_1655441168 = (responseHeaders.getHeaders().getResponseCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseHeaders.getHeaders().getResponseCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "FBE346C8B51CB8E76028C21E64D6BD0A", hash_generated_method = "7E9C22B5B712BAA9F2E8F33ABF9DAB2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream getResponseBody() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return responseBodyIn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "2250F4C87B4A22443F60D9654505E9D2", hash_generated_method = "FACA0B391FE119290948F653AC3A4CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CacheResponse getCacheResponse() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return (CacheResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (responseHeaders == null) {
            //throw new IllegalStateException();
        //}
        //return cacheResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "9105CAFA0117096F163A50885E7429CB", hash_generated_method = "F7ACFEF58AEFD73E5822258258418CB0")
    @DSModeled(DSC.SAFE)
    public final HttpConnection getConnection() {
        return (HttpConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "A7591895A9BC485B929D9D45A1C9BC76", hash_generated_method = "1ADA4C6213B37DF2E4F576E2CD999923")
    @DSModeled(DSC.SAFE)
    protected boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        dsTaint.addTaint(cacheResponse.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "E0679987436CD4859195D8429BAB78FF", hash_generated_method = "02E244DDBBCD14DC91A16B42A63BE324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void maybeCache() throws IOException {
        {
            boolean varCF9C7755EC0347CCE315779743B81752_2042423135 = (!policy.getUseCaches() || responseCache == null);
        } //End collapsed parenthetic
        {
            boolean varCF80C2CFACFAD16BF0AB9ECDD125AC65_1302205346 = (!responseHeaders.isCacheable(requestHeaders));
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.172 -0400", hash_original_method = "CA4844B1B3E4576C0EA18E04D34BB6CE", hash_generated_method = "C631157B5A75C917EF7325DA172514F6")
    @DSModeled(DSC.SAFE)
    protected HttpURLConnection getHttpConnectionToCache() {
        return (HttpURLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return policy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.173 -0400", hash_original_method = "5482932EB1112689442580A552BBCA6A", hash_generated_method = "8191FA30785F3E7B288A408F3AEC1135")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void automaticallyReleaseConnectionToPool() {
        automaticallyReleaseConnectionToPool = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.173 -0400", hash_original_method = "648343BC3C2ABC6FA7BF932A2F48012C", hash_generated_method = "2A97017CB9FE6C60429DEC2183682F4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void release(boolean reusable) {
        dsTaint.addTaint(reusable);
        {
            IoUtils.closeQuietly(responseBodyIn);
        } //End block
        {
            connectionReleased = true;
            {
                reusable = false;
            } //End block
            {
                boolean varD474EBB65768A4B4B9F0FA0189BD2051_572641652 = (hasConnectionCloseHeader());
                {
                    reusable = false;
                } //End block
            } //End collapsed parenthetic
            {
                reusable = false;
            } //End block
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
            {
                connection.closeSocketAndStreams();
                connection = null;
            } //End block
            {
                HttpConnectionPool.INSTANCE.recycle(connection);
                connection = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.173 -0400", hash_original_method = "EC59FCFED738418E26EF637931185263", hash_generated_method = "2FBB5850694862BE5E1CE0DA801A43E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initContentStream(InputStream transferStream) throws IOException {
        dsTaint.addTaint(transferStream.dsTaint);
        {
            boolean var10B7C508D1ED1B70DBB8B231FF168A18_960415130 = (transparentGzip && responseHeaders.isContentEncodingGzip());
            {
                responseHeaders.stripContentEncoding();
                responseBodyIn = new GZIPInputStream(transferStream);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (transparentGzip && responseHeaders.isContentEncodingGzip()) {
            //responseHeaders.stripContentEncoding();
            //responseBodyIn = new GZIPInputStream(transferStream);
        //} else {
            //responseBodyIn = transferStream;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.174 -0400", hash_original_method = "1AB921196A345CEE857EE600A5FD99DD", hash_generated_method = "3FF4C15EB49B67B427FB9AB531641791")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InputStream getTransferStream() throws IOException {
        {
            boolean var222131CC331E330F9818A633D062A21E_755040900 = (!hasResponseBody());
            {
                InputStream var78CAF3468D4EB95B5C8E1E392FA30308_1921412064 = (new FixedLengthInputStream(socketIn, cacheRequest, this, 0));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCD2BBE67147BEB5C75571A22581AC678_1905508527 = (responseHeaders.isChunked());
            {
                InputStream var3316EF1B3F03A8C8164F6C78F33DF1EB_661581425 = (new ChunkedInputStream(socketIn, cacheRequest, this));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var27B191FB2EEF5BA2EB481257DC1DE119_1979362668 = (responseHeaders.getContentLength() != -1);
            {
                InputStream varAC2575CA79A9ED24D4619A25ACB261CD_1248745022 = (new FixedLengthInputStream(socketIn, cacheRequest, this,
                    responseHeaders.getContentLength()));
            } //End block
        } //End collapsed parenthetic
        InputStream var315F76FC8EC5F301C929D8A373DD9202_140835734 = (new UnknownLengthHttpInputStream(socketIn, cacheRequest, this));
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.174 -0400", hash_original_method = "E5EB74DB686CEF76B63FEE327FA34FC3", hash_generated_method = "1120043CCE25AD5A5D4925DD8E6BE3D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readResponseHeaders() throws IOException {
        RawHeaders headers;
        {
            headers = new RawHeaders();
            headers.setStatusLine(Streams.readAsciiLine(socketIn));
            readHeaders(headers);
        } //End block
        {
            boolean var61D8834F94DDCE7B9BEA9340DAA8CA93_1943125086 = (headers.getResponseCode() == HTTP_CONTINUE);
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.174 -0400", hash_original_method = "C50EFF03D3756AF141D5513AF20FE391", hash_generated_method = "E3726A02E6209F08FD4D998FB34F3F78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasResponseBody() {
        int responseCode;
        responseCode = responseHeaders.getHeaders().getResponseCode();
        {
            boolean var59F09BC6BA7895465F5EFC6A4E22007A_2102658496 = (responseHeaders.getContentLength() != -1 || responseHeaders.isChunked());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.174 -0400", hash_original_method = "017F163869C61C64FB5708C2B3013CCB", hash_generated_method = "F672A3A361C8D11DFA099C224F5A5D25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void readTrailers() throws IOException {
        readHeaders(responseHeaders.getHeaders());
        // ---------- Original Method ----------
        //readHeaders(responseHeaders.getHeaders());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.175 -0400", hash_original_method = "814E7EB33C3A4672039AF7BE1F530F36", hash_generated_method = "AE5CAA6CB4B873C8EC2FBB6A89EBB7FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readHeaders(RawHeaders headers) throws IOException {
        dsTaint.addTaint(headers.dsTaint);
        String line;
        {
            boolean var5764D7F705BA70AC3824F177622814D6_1294519950 = (!(line = Streams.readAsciiLine(socketIn)).isEmpty());
            {
                headers.addLine(line);
            } //End block
        } //End collapsed parenthetic
        CookieHandler cookieHandler;
        cookieHandler = CookieHandler.getDefault();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.175 -0400", hash_original_method = "6D117EBD96F306FC6CE6929186DDBA19", hash_generated_method = "213CA50976652C059DE5CAE7E3BC84D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeRequestHeaders(int contentLength) throws IOException {
        dsTaint.addTaint(contentLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        RawHeaders headersToSend;
        headersToSend = getNetworkRequestHeaders();
        byte[] bytes;
        bytes = headersToSend.toHeaderString().getBytes(Charsets.ISO_8859_1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.175 -0400", hash_original_method = "E663539B4C2FF814BF16D6A04E975935", hash_generated_method = "7128DC83FE11765DA341119F03C072EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected RawHeaders getNetworkRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        int fixedContentLength;
        fixedContentLength = policy.getFixedContentLength();
        {
            requestHeaders.setContentLength(fixedContentLength);
        } //End block
        {
            requestHeaders.setChunked();
        } //End block
        {
            int contentLength;
            contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            requestHeaders.setContentLength(contentLength);
        } //End block
        RawHeaders varED8B32E34282D869EB6A06F9628571EA_1735776684 = (requestHeaders.getHeaders());
        return (RawHeaders)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.176 -0400", hash_original_method = "9965AB400B31D225B507F0BE101C0DB2", hash_generated_method = "EA6BEF544D1C504B967B005DBC1D756C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void prepareRawRequestHeaders() throws IOException {
        requestHeaders.getHeaders().setStatusLine(getRequestLine());
        {
            boolean var75B557150EA37168C28CB4A9730262F2_391148433 = (requestHeaders.getUserAgent() == null);
            {
                requestHeaders.setUserAgent(getDefaultUserAgent());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9A46A7B18C684B3219ECA2964BB9FEE9_1259242489 = (requestHeaders.getHost() == null);
            {
                requestHeaders.setHost(getOriginAddress(policy.getURL()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFF80AC1E5EB2B33915C57816332F2C2C_699542342 = (httpMinorVersion > 0 && requestHeaders.getConnection() == null);
            {
                requestHeaders.setConnection("Keep-Alive");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var936092B0BC6CD864A641D62AF63A0F52_1749816854 = (requestHeaders.getAcceptEncoding() == null);
            {
                transparentGzip = true;
                requestHeaders.setAcceptEncoding("gzip");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8F2B459197C3E9895D68A20592341CBB_1468503586 = (hasRequestBody() && requestHeaders.getContentType() == null);
            {
                requestHeaders.setContentType("application/x-www-form-urlencoded");
            } //End block
        } //End collapsed parenthetic
        long ifModifiedSince;
        ifModifiedSince = policy.getIfModifiedSince();
        {
            requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        } //End block
        CookieHandler cookieHandler;
        cookieHandler = CookieHandler.getDefault();
        {
            requestHeaders.addCookies(
                    cookieHandler.get(uri, requestHeaders.getHeaders().toMultimap()));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.176 -0400", hash_original_method = "6DB81453AD78E43D72799E90FBF820CD", hash_generated_method = "F6F57C87D270FEADCC7DFDBFFD711837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getRequestLine() {
        String protocol;
        protocol = "HTTP/1.0";
        protocol = "HTTP/1.1";
        String var37EAD76C11912D1F7A2790DA1ECEA209_1345777702 = (method + " " + requestString() + " " + protocol);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String protocol = (httpMinorVersion == 0) ? "HTTP/1.0" : "HTTP/1.1";
        //return method + " " + requestString() + " " + protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.176 -0400", hash_original_method = "579F0C1DEDB2C71B061424762EDA3D6F", hash_generated_method = "4E47CF46A9618CDDF273A58719DD4D95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String requestString() {
        URL url;
        url = policy.getURL();
        {
            boolean var77817063686EB8BBF3B76684926C979F_386346190 = (includeAuthorityInRequestLine());
            {
                String var796FFBDBB0D389BF6F6A355E1846EFEC_384458148 = (url.toString());
            } //End block
            {
                String fileOnly;
                fileOnly = url.getFile();
                {
                    fileOnly = "/";
                } //End block
                {
                    boolean var496B9AC6AE68C834F2257095ECFB439C_1172883421 = (!fileOnly.startsWith("/"));
                    {
                        fileOnly = "/" + fileOnly;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.176 -0400", hash_original_method = "A86C65F03AA643F0D379154D6D12D2B7", hash_generated_method = "EF79E252703190BB734D94EDEBFE9322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean includeAuthorityInRequestLine() {
        boolean var19169BA9F9D3DE0B973D11E6A9633BBA_2124587285 = (policy.usingProxy());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return policy.usingProxy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.208 -0400", hash_original_method = "B0560F32D5938C3FB1E508A1DA2A4958", hash_generated_method = "992C808903B0CBF7F290D4C6FE16DEC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final String getDefaultUserAgent() {
        String agent;
        agent = System.getProperty("http.agent");
        {
            Object varC7AFBCB24737DF8974814C0C649E26A5_1726690435 = (("Java" + System.getProperty("java.version")));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String agent = System.getProperty("http.agent");
        //return agent != null ? agent : ("Java" + System.getProperty("java.version"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.208 -0400", hash_original_method = "0A452E6BAC82BB82543FC0DC64DC1250", hash_generated_method = "B78AAFDA0F8F0B3F209D160AC76BFAAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasConnectionCloseHeader() {
        boolean var69DD3B4AFE294E58876FCBB469D2F6A7_14289471 = ((responseHeaders != null && responseHeaders.hasConnectionClose())
                || requestHeaders.hasConnectionClose());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (responseHeaders != null && responseHeaders.hasConnectionClose())
                //|| requestHeaders.hasConnectionClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.208 -0400", hash_original_method = "71D2D2A43E6B9B2FCF0835DDEF471DCE", hash_generated_method = "5AE78750C9D2DB6076EB682095AA5590")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final String getOriginAddress(URL url) {
        dsTaint.addTaint(url.dsTaint);
        int port;
        port = url.getPort();
        String result;
        result = url.getHost();
        {
            boolean varB9D32AA0ECABB77CA151A9D1AAA54613_611195598 = (port > 0 && port != policy.getDefaultPort());
            {
                result = result + ":" + port;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int port = url.getPort();
        //String result = url.getHost();
        //if (port > 0 && port != policy.getDefaultPort()) {
            //result = result + ":" + port;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.208 -0400", hash_original_method = "E79001B5362EC94E0060C3FC14A22DCF", hash_generated_method = "99FD5A3B7DC4C5F7655FDDA7E661BD8D")
    @DSModeled(DSC.SAFE)
    protected boolean requiresTunnel() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.209 -0400", hash_original_method = "1EEDE20F378BB56816783AF0AAE8D8C5", hash_generated_method = "95D61B2B8F262AA6689ACDC75EAE857B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readResponse() throws IOException {
        {
            boolean varDF0268D132F74D014F3F570E15869B14_132023604 = (hasResponse());
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("readResponse() without sendRequest()");
        } //End block
        {
            boolean var0D46027BF2368CE745271684E7C45B4D_289498807 = (!responseSource.requiresConnection());
        } //End collapsed parenthetic
        {
            int contentLength;
            contentLength = ((RetryableOutputStream) requestBodyOut).contentLength();
            contentLength = -1;
            writeRequestHeaders(contentLength);
        } //End block
        {
            requestBodyOut.close();
            {
                ((RetryableOutputStream) requestBodyOut).writeToSocket(requestOut);
            } //End block
        } //End block
        requestOut.flush();
        requestOut = socketOut;
        readResponseHeaders();
        responseHeaders.setLocalTimestamps(sentRequestMillis, System.currentTimeMillis());
        {
            {
                boolean varDFDD7081C0807C56635421D271187FE6_406206553 = (cachedResponseHeaders.validate(responseHeaders));
                {
                    {
                        ((HttpResponseCache) responseCache).trackConditionalCacheHit();
                    } //End block
                    release(true);
                    setResponse(cachedResponseHeaders.combine(responseHeaders), cachedResponseBody);
                } //End block
                {
                    IoUtils.closeQuietly(cachedResponseBody);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varB52E59AE5848B0CFF2208EFF6ABF11C4_1438850996 = (hasResponseBody());
            {
                maybeCache();
            } //End block
        } //End collapsed parenthetic
        initContentStream(getTransferStream());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final CacheResponse BAD_GATEWAY_RESPONSE = new CacheResponse() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.209 -0400", hash_original_method = "298484AFDF3A781562203CC307227E59", hash_generated_method = "1383CDB25EE564076E3C108200E01D9C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Map<String, List<String>> getHeaders() throws IOException {
            Map<String, List<String>> result;
            result = new HashMap<String, List<String>>();
            result.put(null, Collections.singletonList("HTTP/1.1 502 Bad Gateway"));
            return (Map<String, List<String>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Map<String, List<String>> result = new HashMap<String, List<String>>();
            //result.put(null, Collections.singletonList("HTTP/1.1 502 Bad Gateway"));
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.209 -0400", hash_original_method = "2EDDCBB89487588B780135D7543EF20D", hash_generated_method = "C000B35F5383D79B9546E59954C951B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputStream getBody() throws IOException {
            InputStream varFBA2895C06FE3394F4387F911173F0A6_261907029 = (new ByteArrayInputStream(EmptyArray.BYTE));
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ByteArrayInputStream(EmptyArray.BYTE);
        }

        
}; //Transformed anonymous class
    private static final int MAX_REQUEST_BUFFER_LENGTH = 32768;
    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    public static final String OPTIONS = "OPTIONS";
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String TRACE = "TRACE";
    public static final String CONNECT = "CONNECT";
    public static final int HTTP_CONTINUE = 100;
    public static final int MAX_REDIRECTS = 5;
}

