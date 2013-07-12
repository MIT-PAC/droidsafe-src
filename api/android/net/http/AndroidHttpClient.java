package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.848 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "6440DD854F4D596C0D709D30B47087FC")

    private HttpClient delegate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.848 -0400", hash_original_field = "498FE078AF0C34DADF42139EA3E05289", hash_generated_field = "D90B3D3803AFC0B006090E75019AA334")

    private RuntimeException mLeakedException = new IllegalStateException(
            "AndroidHttpClient created and never closed");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.848 -0400", hash_original_field = "813880D08B4F0B373C5506C85F431E92", hash_generated_field = "7118A8C21E158E47B1C5DDDEC5F671B3")

    private volatile LoggingConfiguration curlConfiguration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.850 -0400", hash_original_method = "D8AE79D95EB274B9A84FF0181FB0726D", hash_generated_method = "AED23902127D9043F6D6F3A9638F8450")
    private  AndroidHttpClient(ClientConnectionManager ccm, HttpParams params) {
        this.delegate = new DefaultHttpClient(ccm, params) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.849 -0400", hash_original_method = "6C76B225B446D1888A1E1537A254B656", hash_generated_method = "98B15407EC07FD8F8A6A5DC0D5C15D2B")
        @Override
        protected BasicHttpProcessor createHttpProcessor() {
            BasicHttpProcessor processor = super.createHttpProcessor();
            processor.addRequestInterceptor(sThreadCheckInterceptor);
            processor.addRequestInterceptor(new CurlLogger());
BasicHttpProcessor varCB22DE2E9E1B163F22CB9A856393418B_1389425308 =             processor;
            varCB22DE2E9E1B163F22CB9A856393418B_1389425308.addTaint(taint);
            return varCB22DE2E9E1B163F22CB9A856393418B_1389425308;
            
            
            
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.850 -0400", hash_original_method = "C49D4F976490FCA93E48C6E59F8BCE3A", hash_generated_method = "459FE3F9B5375D764345AE54E2470F60")
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
HttpContext var4C2DD4015CB4BB3F876A587F79816595_1631897573 =             context;
            var4C2DD4015CB4BB3F876A587F79816595_1631897573.addTaint(taint);
            return var4C2DD4015CB4BB3F876A587F79816595_1631897573;
            
            
            
                        
                        
            
                        
                        
            
                        
                        
            
        }
};
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.851 -0400", hash_original_method = "B02E74BCEF0E366F496BFBC11FACA316", hash_generated_method = "732326A0DFE11A34B81AAC6BB31C368C")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    if(mLeakedException != null)        
        {
            mLeakedException = null;
        } 
        
        
        
            
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.852 -0400", hash_original_method = "5EF975DC0C48CD0E5439D816C45920DD", hash_generated_method = "9FE697B6FC992C3CF749CEAB0E394902")
    public void close() {
    if(mLeakedException != null)        
        {
            getConnectionManager().shutdown();
            mLeakedException = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.853 -0400", hash_original_method = "5DB032B661B95AF8C86F6F8448CB3EFD", hash_generated_method = "E9953EA7B6B4BEE920D319678A16CDF5")
    public HttpParams getParams() {
HttpParams var58F71D00F7895AFF9FAD07E21D27F5D7_1068935582 =         delegate.getParams();
        var58F71D00F7895AFF9FAD07E21D27F5D7_1068935582.addTaint(taint);
        return var58F71D00F7895AFF9FAD07E21D27F5D7_1068935582;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.853 -0400", hash_original_method = "53260AB8F43CDB4D95BC832EBA5D95FD", hash_generated_method = "DC6F307EDBE70F9F78724AB65AF6BEE2")
    public ClientConnectionManager getConnectionManager() {
ClientConnectionManager var4BE3268C1364FD1BD22646583095ACC4_1930482091 =         delegate.getConnectionManager();
        var4BE3268C1364FD1BD22646583095ACC4_1930482091.addTaint(taint);
        return var4BE3268C1364FD1BD22646583095ACC4_1930482091;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.853 -0400", hash_original_method = "0560DA2228BFB64D3B8813172C1C501C", hash_generated_method = "A92E0EEA344CF3267058578E87882C24")
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        addTaint(request.getTaint());
HttpResponse varB4CF8B99FC3CD6EEC90F3B07385C4C7D_80493851 =         delegate.execute(request);
        varB4CF8B99FC3CD6EEC90F3B07385C4C7D_80493851.addTaint(taint);
        return varB4CF8B99FC3CD6EEC90F3B07385C4C7D_80493851;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.853 -0400", hash_original_method = "7AD2D127C26D9679F6BBE27F72FD947E", hash_generated_method = "AFD5967801A005952832978797CA7073")
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
HttpResponse var8F3F36BC19AF3E29944BBBAB74EC28BC_1356023 =         delegate.execute(request, context);
        var8F3F36BC19AF3E29944BBBAB74EC28BC_1356023.addTaint(taint);
        return var8F3F36BC19AF3E29944BBBAB74EC28BC_1356023;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.854 -0400", hash_original_method = "BD436F920432FBA2B6127A4BA2765DC7", hash_generated_method = "E55087D95827E585A267DF132FE4F6F7")
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        addTaint(request.getTaint());
        addTaint(target.getTaint());
HttpResponse varD1BCB4F56C6C466E27A382C951D3B30E_386024781 =         delegate.execute(target, request);
        varD1BCB4F56C6C466E27A382C951D3B30E_386024781.addTaint(taint);
        return varD1BCB4F56C6C466E27A382C951D3B30E_386024781;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.854 -0400", hash_original_method = "02756492F9E21421543B6A3EB2FE7DF1", hash_generated_method = "E6AFD26ED269E611B2CE821F969E71D6")
    public HttpResponse execute(HttpHost target, HttpRequest request,
            HttpContext context) throws IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
HttpResponse var4A5520C67A1D4012A605006600ED3E5E_1660579970 =         delegate.execute(target, request, context);
        var4A5520C67A1D4012A605006600ED3E5E_1660579970.addTaint(taint);
        return var4A5520C67A1D4012A605006600ED3E5E_1660579970;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.854 -0400", hash_original_method = "EB0DDC231013D5372DD8D788C79B1E98", hash_generated_method = "7AF4C9759884BBA3B4E025A6FB595AD8")
    public <T> T execute(HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var36E49463A8C0D597D04C307A302D4311_514412043 =         delegate.execute(request, responseHandler);
        var36E49463A8C0D597D04C307A302D4311_514412043.addTaint(taint);
        return var36E49463A8C0D597D04C307A302D4311_514412043;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.855 -0400", hash_original_method = "F3FC7BD600F2641741DDE041CB58993B", hash_generated_method = "35E9F4498350FFDFB7C58607A217679E")
    public <T> T execute(HttpUriRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T var4C992D413ECABA26DC3DF2FE56905C2B_320641339 =         delegate.execute(request, responseHandler, context);
        var4C992D413ECABA26DC3DF2FE56905C2B_320641339.addTaint(taint);
        return var4C992D413ECABA26DC3DF2FE56905C2B_320641339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.855 -0400", hash_original_method = "7CB9DE1B48678C64D58684D5D8F5CD5D", hash_generated_method = "FBA659F228E5C773EF13BB7C99C41D7F")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler) throws IOException,
            ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var1B6735C657E1CD3BC52AB580BBCBDB6A_1141384865 =         delegate.execute(target, request, responseHandler);
        var1B6735C657E1CD3BC52AB580BBCBDB6A_1141384865.addTaint(taint);
        return var1B6735C657E1CD3BC52AB580BBCBDB6A_1141384865;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.855 -0400", hash_original_method = "A182144DA9C7044CF91703E3B51621BD", hash_generated_method = "C34280C57D63E08BCF74EB1CDA6359C0")
    public <T> T execute(HttpHost target, HttpRequest request,
            ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T var88CD165110419B2B8C92D3A1E57DA7B1_926421714 =         delegate.execute(target, request, responseHandler, context);
        var88CD165110419B2B8C92D3A1E57DA7B1_926421714.addTaint(taint);
        return var88CD165110419B2B8C92D3A1E57DA7B1_926421714;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.856 -0400", hash_original_method = "B1B69215498581680849253AEA19542C", hash_generated_method = "68BDAA4F081407C9C38CFF93DF253D38")
    public void enableCurlLogging(String name, int level) {
    if(name == null)        
        {
            NullPointerException var9AD8310F6B4E990AB41E4395C382A591_412947043 = new NullPointerException("name");
            var9AD8310F6B4E990AB41E4395C382A591_412947043.addTaint(taint);
            throw var9AD8310F6B4E990AB41E4395C382A591_412947043;
        } 
    if(level < Log.VERBOSE || level > Log.ASSERT)        
        {
            IllegalArgumentException var1D44EB966F584D11C789FD2B0005F40D_483824472 = new IllegalArgumentException("Level is out of range ["
                + Log.VERBOSE + ".." + Log.ASSERT + "]");
            var1D44EB966F584D11C789FD2B0005F40D_483824472.addTaint(taint);
            throw var1D44EB966F584D11C789FD2B0005F40D_483824472;
        } 
        curlConfiguration = new LoggingConfiguration(name, level);
        
        
            
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.857 -0400", hash_original_method = "ACD8C6EB71D9F6C325AF8CC21E8A00EF", hash_generated_method = "C4593E5AA16D43E72F368F7DD199C333")
    public void disableCurlLogging() {
        curlConfiguration = null;
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.858 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.858 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "57A7D6A8967F8756CE39676B1CDDECE5")

        private int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.858 -0400", hash_original_method = "7A9F95068D47CF60B894A5D5EE822200", hash_generated_method = "DDC2BDD6DC1614A04F536562C855C1CE")
        private  LoggingConfiguration(String tag, int level) {
            this.tag = tag;
            this.level = level;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.859 -0400", hash_original_method = "B5444C1DC99A243E7A135E83B11C8EBC", hash_generated_method = "C80DF24F5DF878ADE10F96158444D789")
        private boolean isLoggable() {
            boolean varF6071C9114C968C92D018274AD7D4F3F_1434162461 = (Log.isLoggable(tag, level));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900660760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900660760;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.859 -0400", hash_original_method = "0A6EBDDF0EE93BAA660A9D5D941C1EF5", hash_generated_method = "E742801E4D5E3C30B65E57B6B062ECF0")
        private void println(String message) {
            addTaint(message.getTaint());
            Log.println(level, tag, message);
            
            
        }

        
    }


    
    private class CurlLogger implements HttpRequestInterceptor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.859 -0400", hash_original_method = "031D6A607DADA24E6C6F491D807252DF", hash_generated_method = "031D6A607DADA24E6C6F491D807252DF")
        public CurlLogger ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.859 -0400", hash_original_method = "548F79A85E58318C95FE6E873644EB65", hash_generated_method = "392DD9DE5F7D09482C251353CDD1155E")
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            addTaint(context.getTaint());
            addTaint(request.getTaint());
            LoggingConfiguration configuration = curlConfiguration;
    if(configuration != null
                    && configuration.isLoggable()
                    && request instanceof HttpUriRequest)            
            {
                configuration.println(toCurl((HttpUriRequest) request, false));
            } 
            
            
            
                    
                    
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.859 -0400", hash_original_field = "D9CA95F12AB95C01D1E4FF037197D4F3", hash_generated_field = "636A49C38E1406125087E3E229184E73")

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.860 -0400", hash_original_field = "816B5DA9E1442B79CE6BB08C3246E5DF", hash_generated_field = "AC25CF9BD92864499A69AA82F8FF1A54")

    private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.860 -0400", hash_original_field = "B130AFEA0E83CB5B14EA3CF260452B49", hash_generated_field = "97E15BF1145A52C243BF2650CF904E71")

    private static final String TAG = "AndroidHttpClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.860 -0400", hash_original_field = "32E9A22B388B1A21461D281EA9DD396D", hash_generated_field = "54659355031202ED56EB5471E883C486")

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

