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
    private HttpClient delegate;
    private RuntimeException mLeakedException = new IllegalStateException(
            "AndroidHttpClient created and never closed");
    private volatile LoggingConfiguration curlConfiguration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.675 -0400", hash_original_method = "D8AE79D95EB274B9A84FF0181FB0726D", hash_generated_method = "12A94767897AD8876FF7C65744A244D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AndroidHttpClient(ClientConnectionManager ccm, HttpParams params) {
        dsTaint.addTaint(ccm.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        this.delegate = new DefaultHttpClient(ccm, params) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.674 -0400", hash_original_method = "6C76B225B446D1888A1E1537A254B656", hash_generated_method = "662F0B4808F30A3526D61C418E5208BA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor processor;
                processor = super.createHttpProcessor();
                processor.addRequestInterceptor(sThreadCheckInterceptor);
                processor.addRequestInterceptor(new CurlLogger());
                return (BasicHttpProcessor)dsTaint.getTaint();
                // ---------- Original Method ----------
                //BasicHttpProcessor processor = super.createHttpProcessor();
                //processor.addRequestInterceptor(sThreadCheckInterceptor);
                //processor.addRequestInterceptor(new CurlLogger());
                //return processor;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.674 -0400", hash_original_method = "C49D4F976490FCA93E48C6E59F8BCE3A", hash_generated_method = "74151C27AB7753983FFD7659144B1119")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected HttpContext createHttpContext() {
                HttpContext context;
                context = new BasicHttpContext();
                context.setAttribute(
                        ClientContext.AUTHSCHEME_REGISTRY,
                        getAuthSchemes());
                context.setAttribute(
                        ClientContext.COOKIESPEC_REGISTRY,
                        getCookieSpecs());
                context.setAttribute(
                        ClientContext.CREDS_PROVIDER,
                        getCredentialsProvider());
                return (HttpContext)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.675 -0400", hash_original_method = "B02E74BCEF0E366F496BFBC11FACA316", hash_generated_method = "747D613A9559AD446B0F0E8D62F30AFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.676 -0400", hash_original_method = "5EF975DC0C48CD0E5439D816C45920DD", hash_generated_method = "CAC673E2A69CDA6DF27B93848E45272A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.677 -0400", hash_original_method = "5DB032B661B95AF8C86F6F8448CB3EFD", hash_generated_method = "F9A67707E5E5EE5A76D9786F6299F4F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpParams getParams() {
        HttpParams var51B401DCEF2FE1B9EEDB3982777CD388_627715187 = (delegate.getParams());
        return (HttpParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.677 -0400", hash_original_method = "53260AB8F43CDB4D95BC832EBA5D95FD", hash_generated_method = "4860247DAB685E24F73D18053A16826D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientConnectionManager getConnectionManager() {
        ClientConnectionManager varCDA405CA36664E21CF9A0E9A7192237E_52944722 = (delegate.getConnectionManager());
        return (ClientConnectionManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.getConnectionManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.678 -0400", hash_original_method = "0560DA2228BFB64D3B8813172C1C501C", hash_generated_method = "29CC50DC3B0DEB1558B72DD12069F4F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        dsTaint.addTaint(request.dsTaint);
        HttpResponse var2971598CA8E88E14C0421F58BA32708E_501231578 = (delegate.execute(request));
        return (HttpResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.679 -0400", hash_original_method = "7AD2D127C26D9679F6BBE27F72FD947E", hash_generated_method = "BEF19A282CF0E5E99DD90C0A2AEBD8A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        HttpResponse varCA30BA04819DE7AD23333EE97DD5EB49_1813289680 = (delegate.execute(request, context));
        return (HttpResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.679 -0400", hash_original_method = "BD436F920432FBA2B6127A4BA2765DC7", hash_generated_method = "22EF84327ECE509FFFCE055DDDBDD829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        HttpResponse varB5DCE3DB1CBBF0AECC4F9F275CF98A6F_1697096278 = (delegate.execute(target, request));
        return (HttpResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(target, request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.679 -0400", hash_original_method = "02756492F9E21421543B6A3EB2FE7DF1", hash_generated_method = "46FE8ECBF0B0D6B8D613535DAF96B681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpResponse execute(HttpHost target, HttpRequest request,
            HttpContext context) throws IOException {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        HttpResponse varA93C34D436B96E93228E1DC0780AFB51_73430376 = (delegate.execute(target, request, context));
        return (HttpResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(target, request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.680 -0400", hash_original_method = "EB0DDC231013D5372DD8D788C79B1E98", hash_generated_method = "F9AB9EEA5F55A9EBB7BA8DCD5281FB0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T execute(HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        dsTaint.addTaint(responseHandler.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        T var9DC92F915AD150FD03A2A544F5A73400_440075692 = (delegate.execute(request, responseHandler));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.680 -0400", hash_original_method = "F3FC7BD600F2641741DDE041CB58993B", hash_generated_method = "84B803A77BD0F5C34B3834A2A715BFE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T execute(HttpUriRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        dsTaint.addTaint(responseHandler.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        T var6A2DE942B8466F401B39F3483770666A_1833393278 = (delegate.execute(request, responseHandler, context));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.680 -0400", hash_original_method = "7CB9DE1B48678C64D58684D5D8F5CD5D", hash_generated_method = "12654452C7EEB9BEF92F477070CFE9E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler) throws IOException,
            ClientProtocolException {
        dsTaint.addTaint(responseHandler.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        T var30C818505D6DFAD29F891E80EDF32FC5_2079025778 = (delegate.execute(target, request, responseHandler));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.680 -0400", hash_original_method = "A182144DA9C7044CF91703E3B51621BD", hash_generated_method = "32BC6656F7EDEE300D25087BA389F519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        dsTaint.addTaint(responseHandler.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        T varA4B80F24BA47BD15D392A802386C8161_1095916705 = (delegate.execute(target, request, responseHandler, context));
        return (T)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.681 -0400", hash_original_method = "B1B69215498581680849253AEA19542C", hash_generated_method = "97AF604BA7DC70E46221BAB0F3DEEA82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableCurlLogging(String name, int level) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.681 -0400", hash_original_method = "ACD8C6EB71D9F6C325AF8CC21E8A00EF", hash_generated_method = "C4593E5AA16D43E72F368F7DD199C333")
    @DSModeled(DSC.SAFE)
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
        private String tag;
        private int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.682 -0400", hash_original_method = "7A9F95068D47CF60B894A5D5EE822200", hash_generated_method = "353E41902E74E87148DBD8CE31E1BE4C")
        @DSModeled(DSC.SAFE)
        private LoggingConfiguration(String tag, int level) {
            dsTaint.addTaint(level);
            dsTaint.addTaint(tag);
            // ---------- Original Method ----------
            //this.tag = tag;
            //this.level = level;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.682 -0400", hash_original_method = "B5444C1DC99A243E7A135E83B11C8EBC", hash_generated_method = "200032B4136C6CBC7F3FE77FE6608872")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isLoggable() {
            boolean varE5787261DEF50602463A867E1AEB2C4B_1599943149 = (Log.isLoggable(tag, level));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return Log.isLoggable(tag, level);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.683 -0400", hash_original_method = "0A6EBDDF0EE93BAA660A9D5D941C1EF5", hash_generated_method = "5A36D0B756581CE5740499391EF5E2CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void println(String message) {
            dsTaint.addTaint(message);
            Log.println(level, tag, message);
            // ---------- Original Method ----------
            //Log.println(level, tag, message);
        }

        
    }


    
    private class CurlLogger implements HttpRequestInterceptor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.683 -0400", hash_original_method = "7D38DE4B3F9CC5D27240C377F6CE4081", hash_generated_method = "7D38DE4B3F9CC5D27240C377F6CE4081")
                public CurlLogger ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.683 -0400", hash_original_method = "548F79A85E58318C95FE6E873644EB65", hash_generated_method = "F70DDD12CF7F8E7091E17A96CA6E484E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            LoggingConfiguration configuration;
            configuration = curlConfiguration;
            {
                boolean var4EBC5DB080ADA8F5710E136849F404CD_502757089 = (configuration != null
                    && configuration.isLoggable()
                    && request instanceof HttpUriRequest);
                {
                    configuration.println(toCurl((HttpUriRequest) request, false));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //LoggingConfiguration configuration = curlConfiguration;
            //if (configuration != null
                    //&& configuration.isLoggable()
                    //&& request instanceof HttpUriRequest) {
                //configuration.println(toCurl((HttpUriRequest) request, false));
            //}
        }

        
    }


    
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
    private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
    private static final String TAG = "AndroidHttpClient";
    private static String[] textContentTypes = new String[] {
            "text/",
            "application/xml",
            "application/json"
    };
    private static final HttpRequestInterceptor sThreadCheckInterceptor = new HttpRequestInterceptor() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.683 -0400", hash_original_method = "82488743491E15B672495C04E860DCD3", hash_generated_method = "3DC9CE45233D132C23CBB1A8C0DEAAA5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void process(HttpRequest request, HttpContext context) {
            dsTaint.addTaint(request.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            {
                boolean var5F91D8D0363907F7130FA08B3E7B5671_566289139 = (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper());
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This thread forbids HTTP requests");
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper() ) {
                //throw new RuntimeException("This thread forbids HTTP requests");
            //}
        }

        
}; //Transformed anonymous class
}

