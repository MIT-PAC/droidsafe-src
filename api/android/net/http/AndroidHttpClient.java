package android.net.http;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class AndroidHttpClient implements HttpClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.731 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "6440DD854F4D596C0D709D30B47087FC")

    private HttpClient delegate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.731 -0400", hash_original_field = "498FE078AF0C34DADF42139EA3E05289", hash_generated_field = "D90B3D3803AFC0B006090E75019AA334")

    private RuntimeException mLeakedException = new IllegalStateException(
            "AndroidHttpClient created and never closed");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.731 -0400", hash_original_field = "813880D08B4F0B373C5506C85F431E92", hash_generated_field = "7118A8C21E158E47B1C5DDDEC5F671B3")

    private volatile LoggingConfiguration curlConfiguration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.732 -0400", hash_original_method = "D8AE79D95EB274B9A84FF0181FB0726D", hash_generated_method = "F86CEFABA527356AD4922D07F2634D31")
    private  AndroidHttpClient(ClientConnectionManager ccm, HttpParams params) {
        this.delegate = new DefaultHttpClient(ccm, params) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.731 -0400", hash_original_method = "6C76B225B446D1888A1E1537A254B656", hash_generated_method = "5E7651AF64F4D16D133C8112AF41AA94")
        @Override
        protected BasicHttpProcessor createHttpProcessor() {
            BasicHttpProcessor processor = super.createHttpProcessor();
            processor.addRequestInterceptor(sThreadCheckInterceptor);
            processor.addRequestInterceptor(new CurlLogger());
BasicHttpProcessor varCB22DE2E9E1B163F22CB9A856393418B_1275395286 =             processor;
            varCB22DE2E9E1B163F22CB9A856393418B_1275395286.addTaint(taint);
            return varCB22DE2E9E1B163F22CB9A856393418B_1275395286;
            // ---------- Original Method ----------
            //BasicHttpProcessor processor = super.createHttpProcessor();
            //processor.addRequestInterceptor(sThreadCheckInterceptor);
            //processor.addRequestInterceptor(new CurlLogger());
            //return processor;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.731 -0400", hash_original_method = "C49D4F976490FCA93E48C6E59F8BCE3A", hash_generated_method = "7ABBBD3E93B40C37599EC4E3F579C5EB")
        @Override
        protected HttpContext createHttpContext() {
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
HttpContext var4C2DD4015CB4BB3F876A587F79816595_440458386 =             context;
            var4C2DD4015CB4BB3F876A587F79816595_440458386.addTaint(taint);
            return var4C2DD4015CB4BB3F876A587F79816595_440458386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.732 -0400", hash_original_method = "B02E74BCEF0E366F496BFBC11FACA316", hash_generated_method = "732326A0DFE11A34B81AAC6BB31C368C")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(mLeakedException != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.732 -0400", hash_original_method = "5EF975DC0C48CD0E5439D816C45920DD", hash_generated_method = "9FE697B6FC992C3CF749CEAB0E394902")
    public void close() {
        if(mLeakedException != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.732 -0400", hash_original_method = "5DB032B661B95AF8C86F6F8448CB3EFD", hash_generated_method = "6108AC4D9F6FF90E0AD92688D5B147C4")
    public HttpParams getParams() {
HttpParams var58F71D00F7895AFF9FAD07E21D27F5D7_401866371 =         delegate.getParams();
        var58F71D00F7895AFF9FAD07E21D27F5D7_401866371.addTaint(taint);
        return var58F71D00F7895AFF9FAD07E21D27F5D7_401866371;
        // ---------- Original Method ----------
        //return delegate.getParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "53260AB8F43CDB4D95BC832EBA5D95FD", hash_generated_method = "F003F04043947666789462B91E1F7D2F")
    public ClientConnectionManager getConnectionManager() {
ClientConnectionManager var4BE3268C1364FD1BD22646583095ACC4_848344713 =         delegate.getConnectionManager();
        var4BE3268C1364FD1BD22646583095ACC4_848344713.addTaint(taint);
        return var4BE3268C1364FD1BD22646583095ACC4_848344713;
        // ---------- Original Method ----------
        //return delegate.getConnectionManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "0560DA2228BFB64D3B8813172C1C501C", hash_generated_method = "022986C371548DAD23A6E3AC7B8A35F9")
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        addTaint(request.getTaint());
HttpResponse varB4CF8B99FC3CD6EEC90F3B07385C4C7D_1178405020 =         delegate.execute(request);
        varB4CF8B99FC3CD6EEC90F3B07385C4C7D_1178405020.addTaint(taint);
        return varB4CF8B99FC3CD6EEC90F3B07385C4C7D_1178405020;
        // ---------- Original Method ----------
        //return delegate.execute(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "7AD2D127C26D9679F6BBE27F72FD947E", hash_generated_method = "DEDC3A1E310FDCD4329778B6BB27ECFF")
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
HttpResponse var8F3F36BC19AF3E29944BBBAB74EC28BC_1124022551 =         delegate.execute(request, context);
        var8F3F36BC19AF3E29944BBBAB74EC28BC_1124022551.addTaint(taint);
        return var8F3F36BC19AF3E29944BBBAB74EC28BC_1124022551;
        // ---------- Original Method ----------
        //return delegate.execute(request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "BD436F920432FBA2B6127A4BA2765DC7", hash_generated_method = "A2502DF621BF44FCE69C0AF544A11A1C")
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        addTaint(request.getTaint());
        addTaint(target.getTaint());
HttpResponse varD1BCB4F56C6C466E27A382C951D3B30E_1227491056 =         delegate.execute(target, request);
        varD1BCB4F56C6C466E27A382C951D3B30E_1227491056.addTaint(taint);
        return varD1BCB4F56C6C466E27A382C951D3B30E_1227491056;
        // ---------- Original Method ----------
        //return delegate.execute(target, request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "02756492F9E21421543B6A3EB2FE7DF1", hash_generated_method = "88A5795EA6B07EEAC9B14A03F6B07F13")
    public HttpResponse execute(HttpHost target, HttpRequest request,
            HttpContext context) throws IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
HttpResponse var4A5520C67A1D4012A605006600ED3E5E_420850047 =         delegate.execute(target, request, context);
        var4A5520C67A1D4012A605006600ED3E5E_420850047.addTaint(taint);
        return var4A5520C67A1D4012A605006600ED3E5E_420850047;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "EB0DDC231013D5372DD8D788C79B1E98", hash_generated_method = "35FA738DC6A9C629A1A7CD04AD9F6044")
    public <T> T execute(HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var36E49463A8C0D597D04C307A302D4311_1262386378 =         delegate.execute(request, responseHandler);
        var36E49463A8C0D597D04C307A302D4311_1262386378.addTaint(taint);
        return var36E49463A8C0D597D04C307A302D4311_1262386378;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.733 -0400", hash_original_method = "F3FC7BD600F2641741DDE041CB58993B", hash_generated_method = "59D72BC6B3BB46B510ED259297F8A5D7")
    public <T> T execute(HttpUriRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var4C992D413ECABA26DC3DF2FE56905C2B_848318443 =         delegate.execute(request, responseHandler, context);
        var4C992D413ECABA26DC3DF2FE56905C2B_848318443.addTaint(taint);
        return var4C992D413ECABA26DC3DF2FE56905C2B_848318443;
        // ---------- Original Method ----------
        //return delegate.execute(request, responseHandler, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "7CB9DE1B48678C64D58684D5D8F5CD5D", hash_generated_method = "D730D86ADEE270C3F9CECE7E250B5772")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler) throws IOException,
            ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404 =         delegate.execute(target, request, responseHandler);
        var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404.addTaint(taint);
        return var1B6735C657E1CD3BC52AB580BBCBDB6A_240690404;
        // ---------- Original Method ----------
        //return delegate.execute(target, request, responseHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "A182144DA9C7044CF91703E3B51621BD", hash_generated_method = "71D5DE14C34C768A69E29BF40AE31B8C")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var88CD165110419B2B8C92D3A1E57DA7B1_550641489 =         delegate.execute(target, request, responseHandler, context);
        var88CD165110419B2B8C92D3A1E57DA7B1_550641489.addTaint(taint);
        return var88CD165110419B2B8C92D3A1E57DA7B1_550641489;
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

    
    @DSModeled(DSC.SAFE)
    public static long getMinGzipSize(ContentResolver resolver) {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "B1B69215498581680849253AEA19542C", hash_generated_method = "AA3BC6ABD7628F8D0787E4DFDF708C47")
    public void enableCurlLogging(String name, int level) {
        if(name == null)        
        {
            NullPointerException var9AD8310F6B4E990AB41E4395C382A591_977512110 = new NullPointerException("name");
            var9AD8310F6B4E990AB41E4395C382A591_977512110.addTaint(taint);
            throw var9AD8310F6B4E990AB41E4395C382A591_977512110;
        } //End block
        if(level < Log.VERBOSE || level > Log.ASSERT)        
        {
            IllegalArgumentException var1D44EB966F584D11C789FD2B0005F40D_987071648 = new IllegalArgumentException("Level is out of range ["
                + Log.VERBOSE + ".." + Log.ASSERT + "]");
            var1D44EB966F584D11C789FD2B0005F40D_987071648.addTaint(taint);
            throw var1D44EB966F584D11C789FD2B0005F40D_987071648;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.734 -0400", hash_original_method = "ACD8C6EB71D9F6C325AF8CC21E8A00EF", hash_generated_method = "C4593E5AA16D43E72F368F7DD199C333")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "57A7D6A8967F8756CE39676B1CDDECE5")

        private int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_method = "7A9F95068D47CF60B894A5D5EE822200", hash_generated_method = "DDC2BDD6DC1614A04F536562C855C1CE")
        private  LoggingConfiguration(String tag, int level) {
            this.tag = tag;
            this.level = level;
            // ---------- Original Method ----------
            //this.tag = tag;
            //this.level = level;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_method = "B5444C1DC99A243E7A135E83B11C8EBC", hash_generated_method = "72930AEB86D8AE9248C5CB40F9575F98")
        private boolean isLoggable() {
            boolean varF6071C9114C968C92D018274AD7D4F3F_2040901877 = (Log.isLoggable(tag, level));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790271015 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_790271015;
            // ---------- Original Method ----------
            //return Log.isLoggable(tag, level);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_method = "0A6EBDDF0EE93BAA660A9D5D941C1EF5", hash_generated_method = "E742801E4D5E3C30B65E57B6B062ECF0")
        private void println(String message) {
            addTaint(message.getTaint());
            Log.println(level, tag, message);
            // ---------- Original Method ----------
            //Log.println(level, tag, message);
        }

        
    }


    
    private class CurlLogger implements HttpRequestInterceptor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.735 -0400", hash_original_method = "031D6A607DADA24E6C6F491D807252DF", hash_generated_method = "031D6A607DADA24E6C6F491D807252DF")
        public CurlLogger ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.736 -0400", hash_original_method = "548F79A85E58318C95FE6E873644EB65", hash_generated_method = "392DD9DE5F7D09482C251353CDD1155E")
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            addTaint(context.getTaint());
            addTaint(request.getTaint());
            LoggingConfiguration configuration = curlConfiguration;
            if(configuration != null
                    && configuration.isLoggable()
                    && request instanceof HttpUriRequest)            
            {
                configuration.println(toCurl((HttpUriRequest) request, false));
            } //End block
            // ---------- Original Method ----------
            //LoggingConfiguration configuration = curlConfiguration;
            //if (configuration != null
                    //&& configuration.isLoggable()
                    //&& request instanceof HttpUriRequest) {
                //configuration.println(toCurl((HttpUriRequest) request, false));
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.736 -0400", hash_original_field = "D9CA95F12AB95C01D1E4FF037197D4F3", hash_generated_field = "636A49C38E1406125087E3E229184E73")

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.736 -0400", hash_original_field = "816B5DA9E1442B79CE6BB08C3246E5DF", hash_generated_field = "AC25CF9BD92864499A69AA82F8FF1A54")

    private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.736 -0400", hash_original_field = "B130AFEA0E83CB5B14EA3CF260452B49", hash_generated_field = "97E15BF1145A52C243BF2650CF904E71")

    private static final String TAG = "AndroidHttpClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.736 -0400", hash_original_field = "32E9A22B388B1A21461D281EA9DD396D", hash_generated_field = "54659355031202ED56EB5471E883C486")

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
}

