package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import libcore.io.Base64;
import libcore.io.DiskLruCache;
import libcore.io.IoUtils;
import libcore.io.Streams;

public final class HttpResponseCache extends ResponseCache {
    private DiskLruCache cache;
    private int writeSuccessCount;
    private int writeAbortCount;
    private int networkCount;
    private int hitCount;
    private int requestCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.269 -0400", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "25BD8A320B39ECE7F48BE7DE38138BF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpResponseCache(File directory, long maxSize) throws IOException {
        dsTaint.addTaint(directory.dsTaint);
        dsTaint.addTaint(maxSize);
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
        // ---------- Original Method ----------
        //cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.269 -0400", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "952EF57D77EB74D0FBE690449A17F26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String uriToKey(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes;
            md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            String varCD47598D8880DD6747F29E6D57904880_358098079 = (IntegralToString.bytesToHexString(md5bytes, false));
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            //return IntegralToString.bytesToHexString(md5bytes, false);
        //} catch (NoSuchAlgorithmException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.270 -0400", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "CA01EE8D500415C7839ADB7ACF013EB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        dsTaint.addTaint(requestHeaders.dsTaint);
        dsTaint.addTaint(requestMethod);
        dsTaint.addTaint(uri.dsTaint);
        String key;
        key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try 
        {
            snapshot = cache.get(key);
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } //End block
        catch (IOException e)
        { }
        {
            boolean var7D158C8C8D146A47EF280B1AAB085822_1884324209 = (!entry.matches(uri, requestMethod, requestHeaders));
            {
                snapshot.close();
            } //End block
        } //End collapsed parenthetic
        InputStream body;
        body = newBodyInputStream(snapshot);
        {
            boolean varAFD43047846F71D30DB1B68753CC52AB_346202127 = (entry.isHttps());
            Object var2CEC1569F05B9A5BE9963191CAB0417F_25048981 = (entry.newSecureCacheResponse(body));
            Object varE271EEC3D9842740FA95C19EE2AA75BF_1514924981 = (entry.newCacheResponse(body));
        } //End flattened ternary
        return (CacheResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String key = uriToKey(uri);
        //DiskLruCache.Snapshot snapshot;
        //Entry entry;
        //try {
            //snapshot = cache.get(key);
            //if (snapshot == null) {
                //return null;
            //}
            //entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        //} catch (IOException e) {
            //return null;
        //}
        //if (!entry.matches(uri, requestMethod, requestHeaders)) {
            //snapshot.close();
            //return null;
        //}
        //InputStream body = newBodyInputStream(snapshot);
        //return entry.isHttps()
                //? entry.newSecureCacheResponse(body)
                //: entry.newCacheResponse(body);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.270 -0400", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "2D79C5D99D8DB2A6C1F50A11CE54BFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        dsTaint.addTaint(snapshot.dsTaint);
        InputStream var6D7602E75EA033EB40C39568ABD340EA_1283623002 = (new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.270 -0400", hash_original_method = "99C3EE16C3080EDF2B3F33CCD793E8EA", hash_generated_method = "B732782A84D6332DF8D3EC8C0DA67E85")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void close() throws IOException {
                snapshot.close();
                super.close();
                // ---------- Original Method ----------
                //snapshot.close();
                //super.close();
            }
});
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            //@Override public void close() throws IOException {
                //snapshot.close();
                //super.close();
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.270 -0400", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "2B5B3BD43E7CD32A2C33F862C6D81E92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        dsTaint.addTaint(urlConnection.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        HttpURLConnection httpConnection;
        httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod;
        requestMethod = httpConnection.getRequestMethod();
        String key;
        key = uriToKey(uri);
        {
            boolean var0B2F5AEE4A5D54E8FD8E2859428117D5_116571196 = (requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE));
            {
                try 
                {
                    cache.remove(key);
                } //End block
                catch (IOException ignored)
                { }
            } //End block
            {
                boolean varF71487804C2D751E21461994C2134753_2077760792 = (!requestMethod.equals(HttpEngine.GET));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        HttpEngine httpEngine;
        httpEngine = getHttpEngine(httpConnection);
        ResponseHeaders response;
        response = httpEngine.getResponseHeaders();
        {
            boolean varD01FB646ABB2F9C328677DB0F2848406_844068184 = (response.hasVaryAll());
        } //End collapsed parenthetic
        RawHeaders varyHeaders;
        varyHeaders = httpEngine.getRequestHeaders().getHeaders().getAll(
                response.getVaryFields());
        Entry entry;
        entry = new Entry(uri, varyHeaders, httpConnection);
        DiskLruCache.Editor editor;
        editor = null;
        try 
        {
            editor = cache.edit(key);
            entry.writeTo(editor);
            CacheRequest varF975C9FA0DFBB129F211C12EBA8A2D45_1053579124 = (new CacheRequestImpl(editor));
        } //End block
        catch (IOException e)
        {
            try 
            {
                {
                    editor.abort();
                } //End block
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        return (CacheRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.271 -0400", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "E2DAD240059495B77CD949CF3FC80068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        dsTaint.addTaint(httpConnection.dsTaint);
        {
            HttpEngine varA52C1FF969C192D98478759E61BDAEBB_162812870 = (((HttpURLConnectionImpl) httpConnection).getHttpEngine());
        } //End block
        {
            HttpEngine var7341BDA3DBEF8438C0151D8D220B7A5B_1214606244 = (((HttpsURLConnectionImpl) httpConnection).getHttpEngine());
        } //End block
        return (HttpEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (httpConnection instanceof HttpURLConnectionImpl) {
            //return ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        //} else if (httpConnection instanceof HttpsURLConnectionImpl) {
            //return ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.271 -0400", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "282725AC2691DF39D737B5AE3BCD946A")
    @DSModeled(DSC.SAFE)
    public DiskLruCache getCache() {
        return (DiskLruCache)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.271 -0400", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "3112632D693355D3575DD156B5E1C225")
    @DSModeled(DSC.SAFE)
    public synchronized int getWriteAbortCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return writeAbortCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.271 -0400", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "60AF549F9BCE1A74BE54CD22013D9616")
    @DSModeled(DSC.SAFE)
    public synchronized int getWriteSuccessCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return writeSuccessCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.271 -0400", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "218637D1C82DE29804328014A3D53279")
    @DSModeled(DSC.SAFE)
    synchronized void trackResponse(ResponseSource source) {
        dsTaint.addTaint(source.dsTaint);
        // ---------- Original Method ----------
        //requestCount++;
        //switch (source) {
        //case CACHE:
            //hitCount++;
            //break;
        //case CONDITIONAL_CACHE:
        //case NETWORK:
            //networkCount++;
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.272 -0400", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "2CBB05F2719F07329394083BF14747F7")
    @DSModeled(DSC.SAFE)
    synchronized void trackConditionalCacheHit() {
        // ---------- Original Method ----------
        //hitCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.272 -0400", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "ADF3C4D1E12AE90BFF1D5C00A498F7DE")
    @DSModeled(DSC.SAFE)
    public synchronized int getNetworkCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return networkCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.272 -0400", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "91D69A883A38590801797EBF0492B593")
    @DSModeled(DSC.SAFE)
    public synchronized int getHitCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.272 -0400", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "3DC8F313B75A580753AC3A07B79AB5C7")
    @DSModeled(DSC.SAFE)
    public synchronized int getRequestCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return requestCount;
    }

    
    private final class CacheRequestImpl extends CacheRequest {
        private DiskLruCache.Editor editor;
        private OutputStream cacheOut;
        private boolean done;
        private OutputStream body;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.273 -0400", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "B4376CDCFF76EF54AEF3B76561D20194")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            dsTaint.addTaint(editor.dsTaint);
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.272 -0400", hash_original_method = "FD984A0F15EEBC39B69C4BE815EB630F", hash_generated_method = "CAAB0B4232C0BF0908EEEA0EF90BEBAB")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void close() throws IOException {
                    {
                        Object var74E2887A5956FAB739B88C491C5E3C62_1356472483 = (HttpResponseCache.this);
                        {
                            done = true;
                        } //End block
                    } //End collapsed parenthetic
                    super.close();
                    editor.commit();
                    // ---------- Original Method ----------
                    //synchronized (HttpResponseCache.this) {
                        //if (done) {
                            //return;
                        //}
                        //done = true;
                        //writeSuccessCount++;
                    //}
                    //super.close();
                    //editor.commit();
                }
};
            // ---------- Original Method ----------
            //this.editor = editor;
            //this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            //this.body = new FilterOutputStream(cacheOut) {
                //@Override public void close() throws IOException {
                    //synchronized (HttpResponseCache.this) {
                        //if (done) {
                            //return;
                        //}
                        //done = true;
                        //writeSuccessCount++;
                    //}
                    //super.close();
                    //editor.commit();
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.273 -0400", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "C8BEF09FFB629F2C995258E87852D20D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void abort() {
            {
                Object var51C5DD3C3DCDA8C40E73B3B67AC6A541_1637906637 = (HttpResponseCache.this);
                {
                    done = true;
                } //End block
            } //End collapsed parenthetic
            IoUtils.closeQuietly(cacheOut);
            try 
            {
                editor.abort();
            } //End block
            catch (IOException ignored)
            { }
            // ---------- Original Method ----------
            //synchronized (HttpResponseCache.this) {
                //if (done) {
                    //return;
                //}
                //done = true;
                //writeAbortCount++;
            //}
            //IoUtils.closeQuietly(cacheOut);
            //try {
                //editor.abort();
            //} catch (IOException ignored) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.273 -0400", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "DDE02A8C80090A6BC1D6010B7079FC9C")
        @DSModeled(DSC.SAFE)
        @Override
        public OutputStream getBody() throws IOException {
            return (OutputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return body;
        }

        
    }


    
    private static final class Entry {
        private String uri;
        private RawHeaders varyHeaders;
        private String requestMethod;
        private RawHeaders responseHeaders;
        private String cipherSuite;
        private Certificate[] peerCertificates;
        private Certificate[] localCertificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.274 -0400", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "1E8D3C292E934B029867AD37C6480E0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(InputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            try 
            {
                uri = Streams.readAsciiLine(in);
                requestMethod = Streams.readAsciiLine(in);
                varyHeaders = new RawHeaders();
                int varyRequestHeaderLineCount;
                varyRequestHeaderLineCount = readInt(in);
                {
                    int i;
                    i = 0;
                    {
                        varyHeaders.addLine(Streams.readAsciiLine(in));
                    } //End block
                } //End collapsed parenthetic
                responseHeaders = new RawHeaders();
                responseHeaders.setStatusLine(Streams.readAsciiLine(in));
                int responseHeaderLineCount;
                responseHeaderLineCount = readInt(in);
                {
                    int i;
                    i = 0;
                    {
                        responseHeaders.addLine(Streams.readAsciiLine(in));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varFFA211E0A88DB8D3D1C49D50249DE024_1650260084 = (isHttps());
                    {
                        String blank;
                        blank = Streams.readAsciiLine(in);
                        {
                            boolean varE57DC7EEFAD90FA932B591041168097D_1855654080 = (!blank.isEmpty());
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IOException("expected \"\" but was \"" + blank + "\"");
                            } //End block
                        } //End collapsed parenthetic
                        cipherSuite = Streams.readAsciiLine(in);
                        peerCertificates = readCertArray(in);
                        localCertificates = readCertArray(in);
                    } //End block
                    {
                        cipherSuite = null;
                        peerCertificates = null;
                        localCertificates = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                in.close();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.274 -0400", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "78D31E22EE1625674B9A346F0ACABF6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            dsTaint.addTaint(varyHeaders.dsTaint);
            dsTaint.addTaint(httpConnection.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            this.uri = uri.toString();
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());
            {
                boolean varFCAD955B043A900B307875922675107D_380337903 = (isHttps());
                {
                    HttpsURLConnection httpsConnection;
                    httpsConnection = (HttpsURLConnection) httpConnection;
                    cipherSuite = httpsConnection.getCipherSuite();
                    Certificate[] peerCertificatesNonFinal;
                    peerCertificatesNonFinal = null;
                    try 
                    {
                        peerCertificatesNonFinal = httpsConnection.getServerCertificates();
                    } //End block
                    catch (SSLPeerUnverifiedException ignored)
                    { }
                    peerCertificates = peerCertificatesNonFinal;
                    localCertificates = httpsConnection.getLocalCertificates();
                } //End block
                {
                    cipherSuite = null;
                    peerCertificates = null;
                    localCertificates = null;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.275 -0400", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "F82EAFD6E973606F88DF457375DF0866")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            dsTaint.addTaint(editor.dsTaint);
            OutputStream out;
            out = editor.newOutputStream(0);
            Writer writer;
            writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.UTF_8));
            writer.write(uri + '\n');
            writer.write(requestMethod + '\n');
            writer.write(Integer.toString(varyHeaders.length()) + '\n');
            {
                int i;
                i = 0;
                boolean var91F436A92F4865E1C76BC6FEB9045E64_893140648 = (i < varyHeaders.length());
                {
                    writer.write(varyHeaders.getFieldName(i) + ": "
                        + varyHeaders.getValue(i) + '\n');
                } //End block
            } //End collapsed parenthetic
            writer.write(responseHeaders.getStatusLine() + '\n');
            writer.write(Integer.toString(responseHeaders.length()) + '\n');
            {
                int i;
                i = 0;
                boolean varCD2269726C173194777BF60852BC28C6_1354488749 = (i < responseHeaders.length());
                {
                    writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFCAD955B043A900B307875922675107D_749938667 = (isHttps());
                {
                    writer.write('\n');
                    writer.write(cipherSuite + '\n');
                    writeCertArray(writer, peerCertificates);
                    writeCertArray(writer, localCertificates);
                } //End block
            } //End collapsed parenthetic
            writer.close();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.275 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "6CCE8496164661CBF6B9115F0E77C385")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isHttps() {
            boolean varFF3DAACE38DA6F1DB496E4B7E3303BBB_1244319639 = (uri.startsWith("https://"));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return uri.startsWith("https://");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.275 -0400", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "83F27CAF177A6D501388F3E0A1C1D055")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int readInt(InputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            String intString;
            intString = Streams.readAsciiLine(in);
            try 
            {
                int varABA47AA6CC39041115500328692BECDF_283636202 = (Integer.parseInt(intString));
            } //End block
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("expected an int but was \"" + intString + "\"");
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //String intString = Streams.readAsciiLine(in);
            //try {
                //return Integer.parseInt(intString);
            //} catch (NumberFormatException e) {
                //throw new IOException("expected an int but was \"" + intString + "\"");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.275 -0400", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "300F98FD875C01187239AB67A5ECD819")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Certificate[] readCertArray(InputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            int length;
            length = readInt(in);
            try 
            {
                CertificateFactory certificateFactory;
                certificateFactory = CertificateFactory.getInstance("X.509");
                Certificate[] result;
                result = new Certificate[length];
                {
                    int i;
                    i = 0;
                    {
                        String line;
                        line = Streams.readAsciiLine(in);
                        byte[] bytes;
                        bytes = Base64.decode(line.getBytes(Charsets.US_ASCII));
                        result[i] = certificateFactory.generateCertificate(
                            new ByteArrayInputStream(bytes));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (CertificateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } //End block
            return (Certificate[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //int length = readInt(in);
            //if (length == -1) {
                //return null;
            //}
            //try {
                //CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                //Certificate[] result = new Certificate[length];
                //for (int i = 0; i < result.length; i++) {
                    //String line = Streams.readAsciiLine(in);
                    //byte[] bytes = Base64.decode(line.getBytes(Charsets.US_ASCII));
                    //result[i] = certificateFactory.generateCertificate(
                            //new ByteArrayInputStream(bytes));
                //}
                //return result;
            //} catch (CertificateException e) {
                //throw new IOException(e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.283 -0400", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "7C80FBB6F6B590FC96915A54F92C8333")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void writeCertArray(Writer writer, Certificate[] certificates) throws IOException {
            dsTaint.addTaint(writer.dsTaint);
            dsTaint.addTaint(certificates[0].dsTaint);
            {
                writer.write("-1\n");
            } //End block
            try 
            {
                writer.write(Integer.toString(certificates.length) + '\n');
                {
                    Certificate certificate = certificates[0];
                    {
                        byte[] bytes;
                        bytes = certificate.getEncoded();
                        String line;
                        line = Base64.encode(bytes);
                        writer.write(line + '\n');
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } //End block
            // ---------- Original Method ----------
            //if (certificates == null) {
                //writer.write("-1\n");
                //return;
            //}
            //try {
                //writer.write(Integer.toString(certificates.length) + '\n');
                //for (Certificate certificate : certificates) {
                    //byte[] bytes = certificate.getEncoded();
                    //String line = Base64.encode(bytes);
                    //writer.write(line + '\n');
                //}
            //} catch (CertificateEncodingException e) {
                //throw new IOException(e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.284 -0400", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "19B87019B3C5EF467BCA0A0E86DE6502")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            dsTaint.addTaint(requestHeaders.dsTaint);
            dsTaint.addTaint(requestMethod);
            dsTaint.addTaint(uri.dsTaint);
            boolean varE71B126F6436F11D7B0403FF7EAFCF2C_407217639 = (this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return this.uri.equals(uri.toString())
                    //&& this.requestMethod.equals(requestMethod)
                    //&& new ResponseHeaders(uri, responseHeaders)
                            //.varyMatches(varyHeaders.toMultimap(), requestHeaders);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.285 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "2E6B1D5B1582794E00AC1FFBE430F151")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CacheResponse newCacheResponse(final InputStream in) {
            dsTaint.addTaint(in.dsTaint);
            CacheResponse varB24B76F6F074D41E40170956B7D76915_1029049252 = (new CacheResponse() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.285 -0400", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "0520A8EF6073FD4994549EEE697AC93F")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Map<String, List<String>> getHeaders() {
                    Map<String, List<String>> varACF6F78BCDEED8E27BE1015DC8F46D1A_1649042236 = (responseHeaders.toMultimap());
                    return (Map<String, List<String>>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return responseHeaders.toMultimap();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.285 -0400", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "AFFB87DC52EDA803AD28A88685912A48")
                @DSModeled(DSC.SAFE)
                @Override
                public InputStream getBody() {
                    return (InputStream)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return in;
                }
});
            return (CacheResponse)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CacheResponse() {
                //@Override public Map<String, List<String>> getHeaders() {
                    //return responseHeaders.toMultimap();
                //}
                //@Override public InputStream getBody() {
                    //return in;
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.288 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "5106652A75B5B3A0DD3511B5A29AA506")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            dsTaint.addTaint(in.dsTaint);
            SecureCacheResponse var860E0F1000BD19F61E404E41E62A6996_694522119 = (new SecureCacheResponse() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.286 -0400", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "6B116749F27A40ABE260818487E3FB8E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Map<String, List<String>> getHeaders() {
                    Map<String, List<String>> varACF6F78BCDEED8E27BE1015DC8F46D1A_775681034 = (responseHeaders.toMultimap());
                    return (Map<String, List<String>>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return responseHeaders.toMultimap();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.286 -0400", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "AFFB87DC52EDA803AD28A88685912A48")
                @DSModeled(DSC.SAFE)
                @Override
                public InputStream getBody() {
                    return (InputStream)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return in;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.287 -0400", hash_original_method = "D670C2680AE46E78B21CAD2B9515E8E7", hash_generated_method = "52F052EED7634633E74367D814FBE379")
                @DSModeled(DSC.SAFE)
                @Override
                public String getCipherSuite() {
                    return dsTaint.getTaintString();
                    // ---------- Original Method ----------
                    //return cipherSuite;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.287 -0400", hash_original_method = "31D74A5EDE84A239E816669DB515C06E", hash_generated_method = "CA2F537309BABE5180D273A44E9E66DC")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException(null);
                    } //End block
                    List<Certificate> varC7F6398714E2A084EC40A994F53720FC_831528144 = (Arrays.asList(peerCertificates.clone()));
                    return (List<Certificate>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (peerCertificates == null || peerCertificates.length == 0) {
                        //throw new SSLPeerUnverifiedException(null);
                    //}
                    //return Arrays.asList(peerCertificates.clone());
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.288 -0400", hash_original_method = "B0F4ED14395510FBFE1098A8134CF356", hash_generated_method = "5B45220111467F143B3D5936EC8CC6C3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException(null);
                    } //End block
                    Principal var0B4692AE9146A08451388705659D7FF6_1043593971 = (((X509Certificate) peerCertificates[0]).getSubjectX500Principal());
                    return (Principal)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (peerCertificates == null || peerCertificates.length == 0) {
                        //throw new SSLPeerUnverifiedException(null);
                    //}
                    //return ((X509Certificate) peerCertificates[0]).getSubjectX500Principal();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.288 -0400", hash_original_method = "88CD48CB7FE6E4F8F5378B409F5088BC", hash_generated_method = "EAC034B627BDC088FBDAE674BAED6171")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public List<Certificate> getLocalCertificateChain() {
                    List<Certificate> var8F6704A45DD8DF44635B36824EE92CB0_623690787 = (Arrays.asList(localCertificates.clone()));
                    return (List<Certificate>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (localCertificates == null || localCertificates.length == 0) {
                        //return null;
                    //}
                    //return Arrays.asList(localCertificates.clone());
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.288 -0400", hash_original_method = "0108FA4D241BF83AF9A8889A5D800085", hash_generated_method = "62A800E880AE77314D400038C2A38D80")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Principal getLocalPrincipal() {
                    Principal var66AAFB040905CEBFC56B64073A6945EC_1332272647 = (((X509Certificate) localCertificates[0]).getSubjectX500Principal());
                    return (Principal)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (localCertificates == null || localCertificates.length == 0) {
                        //return null;
                    //}
                    //return ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
                }
});
            return (SecureCacheResponse)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final int VERSION = 201105;
    private static final int ENTRY_METADATA = 0;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
}

