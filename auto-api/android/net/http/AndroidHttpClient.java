package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.http.HttpDateTime;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.BasicHttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.net.URI;
import android.content.Context;
import android.content.ContentResolver;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;

public final class AndroidHttpClient implements HttpClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.499 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "6440DD854F4D596C0D709D30B47087FC")

    private HttpClient delegate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.499 -0400", hash_original_field = "498FE078AF0C34DADF42139EA3E05289", hash_generated_field = "D90B3D3803AFC0B006090E75019AA334")

    private RuntimeException mLeakedException = new IllegalStateException(
            "AndroidHttpClient created and never closed");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.499 -0400", hash_original_field = "813880D08B4F0B373C5506C85F431E92", hash_generated_field = "7118A8C21E158E47B1C5DDDEC5F671B3")

    private volatile LoggingConfiguration curlConfiguration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.501 -0400", hash_original_method = "D8AE79D95EB274B9A84FF0181FB0726D", hash_generated_method = "D0E46774529034293706A7ADE440CCAB")
    private  AndroidHttpClient(ClientConnectionManager ccm, HttpParams params) {
        this.delegate = new DefaultHttpClient(ccm, params) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.500 -0400", hash_original_method = "6C76B225B446D1888A1E1537A254B656", hash_generated_method = "5D71FD5E50EA6241A53D165BD6FB30D4")
            @Override
            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor varB4EAC82CA7396A68D541C85D26508E83_187909678 = null; //Variable for return #1
                BasicHttpProcessor processor = super.createHttpProcessor();
                processor.addRequestInterceptor(sThreadCheckInterceptor);
                processor.addRequestInterceptor(new CurlLogger());
                varB4EAC82CA7396A68D541C85D26508E83_187909678 = processor;
                varB4EAC82CA7396A68D541C85D26508E83_187909678.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_187909678;
                // ---------- Original Method ----------
                //BasicHttpProcessor processor = super.createHttpProcessor();
                //processor.addRequestInterceptor(sThreadCheckInterceptor);
                //processor.addRequestInterceptor(new CurlLogger());
                //return processor;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.501 -0400", hash_original_method = "C49D4F976490FCA93E48C6E59F8BCE3A", hash_generated_method = "FBD290BBD2F352EBF5AC69035C68F764")
            @Override
            protected HttpContext createHttpContext() {
                HttpContext varB4EAC82CA7396A68D541C85D26508E83_338991350 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_338991350 = context;
                varB4EAC82CA7396A68D541C85D26508E83_338991350.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_338991350;
                // ---------- Original Method ----------
                //HttpContext context = new BasicHttpContext();
                //context.setAttribute(
                        //ClientContext.AUTHSCHEME_REGISTRY,
                        //getAuthSchemes());
                //context.setAttribute(
                        //ClientContext.COOKIESPEC_REGISTRY,
                        //getCookieSpecs());
                //context.setAttribute(
                        //ClientContext.CREDS_PROVIDER,
                        //getCredentialsProvider());
                //return context;
            }
};
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static AndroidHttpClient newInstance(String userAgent, Context context) {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(params, false);
        HttpConnectionParams.setConnectionTimeout(params, SOCKET_OPERATION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, SOCKET_OPERATION_TIMEOUT);
        HttpConnectionParams.setSocketBufferSize(params, 8192);
        HttpClientParams.setRedirecting(params, false);
        SSLSessionCache sessionCache = context == null ? null : new SSLSessionCache(context);
        HttpProtocolParams.setUserAgent(params, userAgent);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http",
                PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https",
                SSLCertificateSocketFactory.getHttpSocketFactory(
                SOCKET_OPERATION_TIMEOUT, sessionCache), 443));
        ClientConnectionManager manager =
                new ThreadSafeClientConnManager(params, schemeRegistry);
        return new AndroidHttpClient(manager, params);
    }

    
        public static AndroidHttpClient newInstance(String userAgent) {
        return newInstance(userAgent, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.503 -0400", hash_original_method = "B02E74BCEF0E366F496BFBC11FACA316", hash_generated_method = "747D613A9559AD446B0F0E8D62F30AFC")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        {
            mLeakedException = null;
        } //End block
        // ---------- Original Method ----------
        //super.finalize();
        //if (mLeakedException != null) {
            //Log.e(TAG, "Leak found", mLeakedException);
            //mLeakedException = null;
        //}
    }

    
        public static void modifyRequestToAcceptGzipResponse(HttpRequest request) {
        request.addHeader("Accept-Encoding", "gzip");
    }

    
        public static InputStream getUngzippedContent(HttpEntity entity) throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.504 -0400", hash_original_method = "5EF975DC0C48CD0E5439D816C45920DD", hash_generated_method = "CAC673E2A69CDA6DF27B93848E45272A")
    public void close() {
        {
            getConnectionManager().shutdown();
            mLeakedException = null;
        } //End block
        // ---------- Original Method ----------
        //if (mLeakedException != null) {
            //getConnectionManager().shutdown();
            //mLeakedException = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.504 -0400", hash_original_method = "5DB032B661B95AF8C86F6F8448CB3EFD", hash_generated_method = "5ECB1F3A3256D42F09DF95DDB60AF528")
    public HttpParams getParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_113663673 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_113663673 = delegate.getParams();
        varB4EAC82CA7396A68D541C85D26508E83_113663673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113663673;
        // ---------- Original Method ----------
        //return delegate.getParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.505 -0400", hash_original_method = "53260AB8F43CDB4D95BC832EBA5D95FD", hash_generated_method = "EC455BCEAEA3157AEF8C401B6B1BA24C")
    public ClientConnectionManager getConnectionManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_19953107 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_19953107 = delegate.getConnectionManager();
        varB4EAC82CA7396A68D541C85D26508E83_19953107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_19953107;
        // ---------- Original Method ----------
        //return delegate.getConnectionManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.505 -0400", hash_original_method = "0560DA2228BFB64D3B8813172C1C501C", hash_generated_method = "A9FA05CB4499BF29D6B59C60EF159C1E")
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_297972270 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_297972270 = delegate.execute(request);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_297972270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297972270;
        // ---------- Original Method ----------
        //return delegate.execute(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.506 -0400", hash_original_method = "7AD2D127C26D9679F6BBE27F72FD947E", hash_generated_method = "81C0D4AC34334D98C639105F17A59B96")
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1215080211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1215080211 = delegate.execute(request, context);
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1215080211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1215080211;
        // ---------- Original Method ----------
        //return delegate.execute(request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.506 -0400", hash_original_method = "BD436F920432FBA2B6127A4BA2765DC7", hash_generated_method = "AC37DDA80E66CCC14405DD7ACB715B29")
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_227487613 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_227487613 = delegate.execute(target, request);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_227487613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_227487613;
        // ---------- Original Method ----------
        //return delegate.execute(target, request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.507 -0400", hash_original_method = "02756492F9E21421543B6A3EB2FE7DF1", hash_generated_method = "4AE32B387EB66A923F908EDE93BEE883")
    public HttpResponse execute(HttpHost target, HttpRequest request,
            HttpContext context) throws IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1387765039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387765039 = delegate.execute(target, request, context);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1387765039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387765039;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.507 -0400", hash_original_method = "EB0DDC231013D5372DD8D788C79B1E98", hash_generated_method = "2517B4AA4FA66EA3FD52B4C14042084F")
    public <T> T execute(HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_708490916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_708490916 = delegate.execute(request, responseHandler);
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_708490916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708490916;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.508 -0400", hash_original_method = "F3FC7BD600F2641741DDE041CB58993B", hash_generated_method = "FAF9151A3F18934A99D2BA07082E2882")
    public <T> T execute(HttpUriRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_891626984 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_891626984 = delegate.execute(request, responseHandler, context);
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_891626984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_891626984;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.508 -0400", hash_original_method = "7CB9DE1B48678C64D58684D5D8F5CD5D", hash_generated_method = "74677490ED0A8F7A42B75C2F0D756178")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler) throws IOException,
            ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_85328287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_85328287 = delegate.execute(target, request, responseHandler);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_85328287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_85328287;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.509 -0400", hash_original_method = "A182144DA9C7044CF91703E3B51621BD", hash_generated_method = "C4D0EC3CB71E65A7D3C012D9281D4C7D")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_443602860 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_443602860 = delegate.execute(target, request, responseHandler, context);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_443602860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443602860;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler, context);
    }

    
        public static AbstractHttpEntity getCompressedEntity(byte data[], ContentResolver resolver) throws IOException {
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

    
        public static long getMinGzipSize(ContentResolver resolver) {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.510 -0400", hash_original_method = "B1B69215498581680849253AEA19542C", hash_generated_method = "CBA3DDC198353BBAA56B795793C048B1")
    public void enableCurlLogging(String name, int level) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Level is out of range ["
                + Log.VERBOSE + ".." + Log.ASSERT + "]");
        } //End block
        curlConfiguration = new LoggingConfiguration(name, level);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name");
        //}
        //if (level < Log.VERBOSE || level > Log.ASSERT) {
            //throw new IllegalArgumentException("Level is out of range ["
                //+ Log.VERBOSE + ".." + Log.ASSERT + "]");
        //}
        //curlConfiguration = new LoggingConfiguration(name, level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.511 -0400", hash_original_method = "ACD8C6EB71D9F6C325AF8CC21E8A00EF", hash_generated_method = "C4593E5AA16D43E72F368F7DD199C333")
    public void disableCurlLogging() {
        curlConfiguration = null;
        // ---------- Original Method ----------
        //curlConfiguration = null;
    }

    
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

    
        public static long parseDate(String dateString) {
        return HttpDateTime.parse(dateString);
    }

    
    private static class LoggingConfiguration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.512 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.513 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "57A7D6A8967F8756CE39676B1CDDECE5")

        private int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.514 -0400", hash_original_method = "7A9F95068D47CF60B894A5D5EE822200", hash_generated_method = "DDC2BDD6DC1614A04F536562C855C1CE")
        private  LoggingConfiguration(String tag, int level) {
            this.tag = tag;
            this.level = level;
            // ---------- Original Method ----------
            //this.tag = tag;
            //this.level = level;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.514 -0400", hash_original_method = "B5444C1DC99A243E7A135E83B11C8EBC", hash_generated_method = "7D690AE101A9E2B104F061BA37EE7A4D")
        private boolean isLoggable() {
            boolean varE5787261DEF50602463A867E1AEB2C4B_1012296361 = (Log.isLoggable(tag, level));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8090477 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8090477;
            // ---------- Original Method ----------
            //return Log.isLoggable(tag, level);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.515 -0400", hash_original_method = "0A6EBDDF0EE93BAA660A9D5D941C1EF5", hash_generated_method = "86C85ECEF4A2E4CDFEECF7ACE4AF1C72")
        private void println(String message) {
            Log.println(level, tag, message);
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            //Log.println(level, tag, message);
        }

        
    }


    
    private class CurlLogger implements HttpRequestInterceptor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.515 -0400", hash_original_method = "031D6A607DADA24E6C6F491D807252DF", hash_generated_method = "031D6A607DADA24E6C6F491D807252DF")
        public CurlLogger ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.515 -0400", hash_original_method = "548F79A85E58318C95FE6E873644EB65", hash_generated_method = "A26AB7472A59509731D25A69F17BF311")
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            LoggingConfiguration configuration = curlConfiguration;
            {
                boolean var4EBC5DB080ADA8F5710E136849F404CD_48560898 = (configuration != null
                    && configuration.isLoggable()
                    && request instanceof HttpUriRequest);
                {
                    configuration.println(toCurl((HttpUriRequest) request, false));
                } //End block
            } //End collapsed parenthetic
            addTaint(request.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //LoggingConfiguration configuration = curlConfiguration;
            //if (configuration != null
                    //&& configuration.isLoggable()
                    //&& request instanceof HttpUriRequest) {
                //configuration.println(toCurl((HttpUriRequest) request, false));
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_field = "D9CA95F12AB95C01D1E4FF037197D4F3", hash_generated_field = "636A49C38E1406125087E3E229184E73")

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_field = "816B5DA9E1442B79CE6BB08C3246E5DF", hash_generated_field = "AC25CF9BD92864499A69AA82F8FF1A54")

    private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_field = "B130AFEA0E83CB5B14EA3CF260452B49", hash_generated_field = "97E15BF1145A52C243BF2650CF904E71")

    private static final String TAG = "AndroidHttpClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.516 -0400", hash_original_field = "32E9A22B388B1A21461D281EA9DD396D", hash_generated_field = "54659355031202ED56EB5471E883C486")

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
                } //End block
            } //End collapsed parenthetic
            addTaint(request.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper() ) {
                //throw new RuntimeException("This thread forbids HTTP requests");
            //}
        }

        
};
}

