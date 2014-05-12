package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

import android.content.ContentResolver;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;

import com.android.internal.http.HttpDateTime;

import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class AndroidHttpClient implements HttpClient {

    /**
     * Create a new HttpClient with reasonable defaults (which you can update).
     *
     * @param userAgent to report in your HTTP requests
     * @param context to use for caching SSL sessions (may be null for no caching)
     * @return AndroidHttpClient for you to use for all your requests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.252 -0500", hash_original_method = "8C3214A0C48FDFFD8AB05D4DDD8B0479", hash_generated_method = "776C289EE7AF764259C1C6D8553F0C8A")
    
public static AndroidHttpClient newInstance(String userAgent, Context context) {
        HttpParams params = new BasicHttpParams();

        // Turn off stale checking.  Our connections break all the time anyway,
        // and it's not worth it to pay the penalty of checking every time.
        HttpConnectionParams.setStaleCheckingEnabled(params, false);

        HttpConnectionParams.setConnectionTimeout(params, SOCKET_OPERATION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, SOCKET_OPERATION_TIMEOUT);
        HttpConnectionParams.setSocketBufferSize(params, 8192);

        // Don't handle redirects -- return them to the caller.  Our code
        // often wants to re-POST after a redirect, which we must do ourselves.
        HttpClientParams.setRedirecting(params, false);

        // Use a session cache for SSL sockets
        SSLSessionCache sessionCache = context == null ? null : new SSLSessionCache(context);

        // Set the specified user agent and register standard protocols.
        HttpProtocolParams.setUserAgent(params, userAgent);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http",
                PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https",
                SSLCertificateSocketFactory.getHttpSocketFactory(
                SOCKET_OPERATION_TIMEOUT, sessionCache), 443));

        ClientConnectionManager manager =
                new ThreadSafeClientConnManager(params, schemeRegistry);

        // We use a factory method to modify superclass initialization
        // parameters without the funny call-a-static-method dance.
        return new AndroidHttpClient(manager, params);
    }

    /**
     * Create a new HttpClient with reasonable defaults (which you can update).
     * @param userAgent to report in your HTTP requests.
     * @return AndroidHttpClient for you to use for all your requests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.254 -0500", hash_original_method = "2C3172373C11B75B4FA9213153A6C85C", hash_generated_method = "D890C9DEA68AA972AD35B056A68FF470")
    
public static AndroidHttpClient newInstance(String userAgent) {
        return newInstance(userAgent, null /* session cache */);
    }

    /**
     * Modifies a request to indicate to the server that we would like a
     * gzipped response.  (Uses the "Accept-Encoding" HTTP header.)
     * @param request the request to modify
     * @see #getUngzippedContent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.271 -0500", hash_original_method = "5BE818A223A96394C31CAF6E13D4DDEA", hash_generated_method = "94EB0F268A15AE6A6DF2A5D9518C61C6")
    
public static void modifyRequestToAcceptGzipResponse(HttpRequest request) {
        request.addHeader("Accept-Encoding", "gzip");
    }

    /**
     * Gets the input stream from a response entity.  If the entity is gzipped
     * then this will get a stream over the uncompressed data.
     *
     * @param entity the entity whose content should be read
     * @return the input stream to read from
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.273 -0500", hash_original_method = "964573E8C621F247ED91825729B77207", hash_generated_method = "26D5FE1B9932CD763FA127FD8079F868")
    
public static InputStream getUngzippedContent(HttpEntity entity)
            throws IOException {
        InputStream responseStream = entity.getContent();
        if (responseStream == null) return responseStream;
        Header header = entity.getContentEncoding();
        if (header == null) return responseStream;
        String contentEncoding = header.getValue();
        if (contentEncoding == null) return responseStream;
        if (contentEncoding.contains("gzip")) responseStream
                = new GZIPInputStream(responseStream);
        return responseStream;
    }

    /**
     * Compress data to send to server.
     * Creates a Http Entity holding the gzipped data.
     * The data will not be compressed if it is too short.
     * @param data The bytes to compress
     * @return Entity holding the data
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.305 -0500", hash_original_method = "586A4DE9A7BEA0D61F483CA95951D7E7", hash_generated_method = "1F03825B8352BD0C2FBFC0CD948614D3")
    
public static AbstractHttpEntity getCompressedEntity(byte data[], ContentResolver resolver)
            throws IOException {
        AbstractHttpEntity entity;
        if (data.length < getMinGzipSize(resolver)) {
            entity = new ByteArrayEntity(data);
        } else {
            ByteArrayOutputStream arr = new ByteArrayOutputStream();
            OutputStream zipper = new GZIPOutputStream(arr);
            zipper.write(data);
            zipper.close();
            entity = new ByteArrayEntity(arr.toByteArray());
            entity.setContentEncoding("gzip");
        }
        return entity;
    }

    /**
     * Retrieves the minimum size for compressing data.
     * Shorter data will not be compressed.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.307 -0500", hash_original_method = "00A5E5473EE4C9FC1A353D8B3CCE7E3C", hash_generated_method = "8B574BF026C27475130E8DE9C55EC22D")
    
public static long getMinGzipSize(ContentResolver resolver) {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;  // For now, this is just a constant.
    }

    /**
     * Generates a cURL command equivalent to the given request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.336 -0500", hash_original_method = "16B8910DE162C0278D0CD4C3C9C4634A", hash_generated_method = "80F3BCDCD6365473887F76B59C915276")
    
private static String toCurl(HttpUriRequest request, boolean logAuthToken) throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append("curl ");

        for (Header header: request.getAllHeaders()) {
            if (!logAuthToken
                    && (header.getName().equals("Authorization") ||
                        header.getName().equals("Cookie"))) {
                continue;
            }
            builder.append("--header \"");
            builder.append(header.toString().trim());
            builder.append("\" ");
        }

        URI uri = request.getURI();

        // If this is a wrapped request, use the URI from the original
        // request instead. getURI() on the wrapper seems to return a
        // relative URI. We want an absolute URI.
        if (request instanceof RequestWrapper) {
            HttpRequest original = ((RequestWrapper) request).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) original).getURI();
            }
        }

        builder.append("\"");
        builder.append(uri);
        builder.append("\"");

        if (request instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest entityRequest =
                    (HttpEntityEnclosingRequest) request;
            HttpEntity entity = entityRequest.getEntity();
            if (entity != null && entity.isRepeatable()) {
                if (entity.getContentLength() < 1024) {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    entity.writeTo(stream);

                    if (isBinaryContent(request)) {
                        String base64 = Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP);
                        builder.insert(0, "echo '" + base64 + "' | base64 -d > /tmp/$$.bin; ");
                        builder.append(" --data-binary @/tmp/$$.bin");
                    } else {
                        String entityString = stream.toString();
                        builder.append(" --data-ascii \"")
                                .append(entityString)
                                .append("\"");
                    }
                } else {
                    builder.append(" [TOO MUCH DATA TO INCLUDE]");
                }
            }
        }

        return builder.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.339 -0500", hash_original_method = "C081DBB0102899837B3CACC5437B7254", hash_generated_method = "4907C2A7E92D737A7FB1E80CF3F6AE29")
    
private static boolean isBinaryContent(HttpUriRequest request) {
        Header[] headers;
        headers = request.getHeaders(Headers.CONTENT_ENCODING);
        if (headers != null) {
            for (Header header : headers) {
                if ("gzip".equalsIgnoreCase(header.getValue())) {
                    return true;
                }
            }
        }

        headers = request.getHeaders(Headers.CONTENT_TYPE);
        if (headers != null) {
            for (Header header : headers) {
                for (String contentType : textContentTypes) {
                    if (header.getValue().startsWith(contentType)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Returns the date of the given HTTP date string. This method can identify
     * and parse the date formats emitted by common HTTP servers, such as
     * <a href="http://www.ietf.org/rfc/rfc0822.txt">RFC 822</a>,
     * <a href="http://www.ietf.org/rfc/rfc0850.txt">RFC 850</a>,
     * <a href="http://www.ietf.org/rfc/rfc1036.txt">RFC 1036</a>,
     * <a href="http://www.ietf.org/rfc/rfc1123.txt">RFC 1123</a> and
     * <a href="http://www.opengroup.org/onlinepubs/007908799/xsh/asctime.html">ANSI
     * C's asctime()</a>.
     *
     * @return the number of milliseconds since Jan. 1, 1970, midnight GMT.
     * @throws IllegalArgumentException if {@code dateString} is not a date or
     *     of an unsupported format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.341 -0500", hash_original_method = "B69FF22D5176CDABC95151E4DBF25303", hash_generated_method = "864F07A78B4E136B5334492F1D2210E8")
    
public static long parseDate(String dateString) {
        return HttpDateTime.parse(dateString);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.236 -0500", hash_original_field = "3C873A49917D36261FD169F61964F485", hash_generated_field = "636A49C38E1406125087E3E229184E73")

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.238 -0500", hash_original_field = "42C95DA2F91DFF401680FF6EBD524A1D", hash_generated_field = "AC25CF9BD92864499A69AA82F8FF1A54")

    private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.241 -0500", hash_original_field = "9E882CC25FF177A28DE199808E3CB091", hash_generated_field = "97E15BF1145A52C243BF2650CF904E71")

    private static final String TAG = "AndroidHttpClient";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.243 -0500", hash_original_field = "D1CC47B238067AE15E4F6117D18F07C7", hash_generated_field = "54659355031202ED56EB5471E883C486")

    private static String[] textContentTypes = new String[] {
            "text/",
            "application/xml",
            "application/json"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_field = "818E65CB14B87D8E416C8C7F03D08E33", hash_generated_field = "49866EA4554E82423D987597C366A705")

    private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_method = "82488743491E15B672495C04E860DCD3", hash_generated_method = "0ADE7C3DF4C38FBA18E3A03AD013C296")
        public void process(HttpRequest request, HttpContext context) {
            {
                boolean var5F91D8D0363907F7130FA08B3E7B5671_1688427908 = (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper());
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This thread forbids HTTP requests");
                } 
            } 
            addTaint(request.getTaint());
            addTaint(context.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.256 -0500", hash_original_field = "35F25CF219FD88ECBF4946CA26E98F46", hash_generated_field = "6440DD854F4D596C0D709D30B47087FC")

    private  HttpClient delegate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.258 -0500", hash_original_field = "77B262ABD2AFAC93252C1D694917184D", hash_generated_field = "D90B3D3803AFC0B006090E75019AA334")

    private RuntimeException mLeakedException = new IllegalStateException(
            "AndroidHttpClient created and never closed");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.323 -0500", hash_original_field = "BBEC2B4A1219D67AFC49FB653FBBD9AC", hash_generated_field = "7118A8C21E158E47B1C5DDDEC5F671B3")

    private volatile LoggingConfiguration curlConfiguration;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.267 -0500", hash_original_method = "D8AE79D95EB274B9A84FF0181FB0726D", hash_generated_method = "CFB34A0D7D67A5D43C228BBF702E06B4")
    
private AndroidHttpClient(ClientConnectionManager ccm, HttpParams params) {
        this.delegate = new DefaultHttpClient(ccm, params) {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @Override
            protected BasicHttpProcessor createHttpProcessor() {
                // Add interceptor to prevent making requests from main thread.
                BasicHttpProcessor processor = super.createHttpProcessor();
                processor.addRequestInterceptor(sThreadCheckInterceptor);
                processor.addRequestInterceptor(new CurlLogger());

                return processor;
            }

            @Override
            protected HttpContext createHttpContext() {
                // Same as DefaultHttpClient.createHttpContext() minus the
                // cookie store.
                HttpContext context = new BasicHttpContext();
                context.setAttribute(
                        ClientContext.AUTHSCHEME_REGISTRY,
                        getAuthSchemes());
                context.setAttribute(
                        ClientContext.COOKIESPEC_REGISTRY,
                        getCookieSpecs());
                context.setAttribute(
                        ClientContext.CREDS_PROVIDER,
                        getCredentialsProvider());
                return context;
            }
        };
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.269 -0500", hash_original_method = "B02E74BCEF0E366F496BFBC11FACA316", hash_generated_method = "EF64E39B8DE68F660EA6B89C4EC7D643")
    
@Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (mLeakedException != null) {
            Log.e(TAG, "Leak found", mLeakedException);
            mLeakedException = null;
        }
    }

    /**
     * Release resources associated with this client.  You must call this,
     * or significant resources (sockets and memory) may be leaked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.277 -0500", hash_original_method = "5EF975DC0C48CD0E5439D816C45920DD", hash_generated_method = "64CF60264CD962C6A039EE0F4B72446C")
    
public void close() {
        if (mLeakedException != null) {
            getConnectionManager().shutdown();
            mLeakedException = null;
        }
    }

    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.279 -0500", hash_original_method = "5DB032B661B95AF8C86F6F8448CB3EFD", hash_generated_method = "6F0967296B644E5446E333F783A95E72")
    
public HttpParams getParams() {
        return delegate.getParams();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.281 -0500", hash_original_method = "53260AB8F43CDB4D95BC832EBA5D95FD", hash_generated_method = "5F4D78440F220D2DB6534D9486F68957")
    
public ClientConnectionManager getConnectionManager() {
        return delegate.getConnectionManager();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.287 -0500", hash_original_method = "0560DA2228BFB64D3B8813172C1C501C", hash_generated_method = "2755D23677BF957916CE7C6AB73E4989")
    
public HttpResponse execute(HttpUriRequest request) throws IOException {
        return delegate.execute(request);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.290 -0500", hash_original_method = "7AD2D127C26D9679F6BBE27F72FD947E", hash_generated_method = "4FD1BE7DD9E960D77321FF372926E083")
    
public HttpResponse execute(HttpUriRequest request, HttpContext context)
            throws IOException {
        return delegate.execute(request, context);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.292 -0500", hash_original_method = "BD436F920432FBA2B6127A4BA2765DC7", hash_generated_method = "E06175DE68ABFEEE9B170D7D7474E12A")
    
public HttpResponse execute(HttpHost target, HttpRequest request)
            throws IOException {
        return delegate.execute(target, request);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.294 -0500", hash_original_method = "02756492F9E21421543B6A3EB2FE7DF1", hash_generated_method = "E992EC59CEAEBBF293214B0E2C84EC00")
    
public HttpResponse execute(HttpHost target, HttpRequest request,
            HttpContext context) throws IOException {
        return delegate.execute(target, request, context);
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "EB0DDC231013D5372DD8D788C79B1E98", hash_generated_method = "35FA738DC6A9C629A1A7CD04AD9F6044")
    public <T> T execute(HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var36E49463A8C0D597D04C307A302D4311_1262386378 =         delegate.execute(request, responseHandler);
        var36E49463A8C0D597D04C307A302D4311_1262386378.addTaint(getTaint());
        return var36E49463A8C0D597D04C307A302D4311_1262386378;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler);
    }
    
    private static class LoggingConfiguration {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.310 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private  String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.312 -0500", hash_original_field = "6C23DC7E65CEAB9FBA953CF49B6B6875", hash_generated_field = "57A7D6A8967F8756CE39676B1CDDECE5")

        private  int level;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.314 -0500", hash_original_method = "7A9F95068D47CF60B894A5D5EE822200", hash_generated_method = "28F5F436CD5D05FDBCD52DCA10A3231A")
        
private LoggingConfiguration(String tag, int level) {
            this.tag = tag;
            this.level = level;
        }

        /**
         * Returns true if logging is turned on for this configuration.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.316 -0500", hash_original_method = "B5444C1DC99A243E7A135E83B11C8EBC", hash_generated_method = "87226959DF4E37DE7AA84EE43652034D")
        
private boolean isLoggable() {
            return Log.isLoggable(tag, level);
        }

        /**
         * Prints a message using this configuration.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.318 -0500", hash_original_method = "0A6EBDDF0EE93BAA660A9D5D941C1EF5", hash_generated_method = "88CB13882D0A251122308F5D591C75C0")
        
private void println(String message) {
            Log.println(level, tag, message);
        }
        
    }
    
    private class CurlLogger implements HttpRequestInterceptor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_method = "031D6A607DADA24E6C6F491D807252DF", hash_generated_method = "031D6A607DADA24E6C6F491D807252DF")
        public CurlLogger ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.331 -0500", hash_original_method = "548F79A85E58318C95FE6E873644EB65", hash_generated_method = "AF4D4A7CFDBE0C18AFBC81285B4A0CBB")
        
public void process(HttpRequest request, HttpContext context)
                throws HttpException, IOException {
            LoggingConfiguration configuration = curlConfiguration;
            if (configuration != null
                    && configuration.isLoggable()
                    && request instanceof HttpUriRequest) {
                // Never print auth token -- we used to check ro.secure=0 to
                // enable that, but can't do that in unbundled code.
                configuration.println(toCurl((HttpUriRequest) request, false));
            }
        }
        
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "F3FC7BD600F2641741DDE041CB58993B", hash_generated_method = "59D72BC6B3BB46B510ED259297F8A5D7")
    public <T> T execute(HttpUriRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var4C992D413ECABA26DC3DF2FE56905C2B_848318443 =         delegate.execute(request, responseHandler, context);
        var4C992D413ECABA26DC3DF2FE56905C2B_848318443.addTaint(getTaint());
        return var4C992D413ECABA26DC3DF2FE56905C2B_848318443;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler, context);
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "7CB9DE1B48678C64D58684D5D8F5CD5D", hash_generated_method = "D730D86ADEE270C3F9CECE7E250B5772")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler) throws IOException,
            ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404 =         delegate.execute(target, request, responseHandler);
        var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404.addTaint(getTaint());
        return var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler);
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "A182144DA9C7044CF91703E3B51621BD", hash_generated_method = "71D5DE14C34C768A69E29BF40AE31B8C")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var88CD165110419B2B8C92D3A1E57DA7B1_550641489 =         delegate.execute(target, request, responseHandler, context);
        var88CD165110419B2B8C92D3A1E57DA7B1_550641489.addTaint(getTaint());
        return var88CD165110419B2B8C92D3A1E57DA7B1_550641489;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler, context);
    }

    /**
     * Enables cURL request logging for this client.
     *
     * @param name to log messages with
     * @param level at which to log messages (see {@link android.util.Log})
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.325 -0500", hash_original_method = "B1B69215498581680849253AEA19542C", hash_generated_method = "138FAB472E897503CC0DB6167736C36C")
    
public void enableCurlLogging(String name, int level) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        if (level < Log.VERBOSE || level > Log.ASSERT) {
            throw new IllegalArgumentException("Level is out of range ["
                + Log.VERBOSE + ".." + Log.ASSERT + "]");
        }

        curlConfiguration = new LoggingConfiguration(name, level);
    }

    /**
     * Disables cURL logging for this client.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:12.328 -0500", hash_original_method = "ACD8C6EB71D9F6C325AF8CC21E8A00EF", hash_generated_method = "A8D3FAD76122181118088323A43DA948")
    
public void disableCurlLogging() {
        curlConfiguration = null;
    }
}

