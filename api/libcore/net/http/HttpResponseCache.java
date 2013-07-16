package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "8D7B3AC911505868AEA4010DF26181F8")

    private DiskLruCache cache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "11679E351AB2CDD5977DCC10C5E3BDA9", hash_generated_field = "9451CF6EB93EE29D841188FD01582E44")

    private int writeSuccessCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "4CFEE5DDB5A666111EBCE2224B5C204B", hash_generated_field = "BF027D0731613DD6EDBF7FD99E17F8D6")

    private int writeAbortCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "3D06ECB00548A4CD4B10D3412F2AB801", hash_generated_field = "843970BEE5BFFD7AF4318A1DF280F033")

    private int networkCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.392 -0400", hash_original_field = "27F327C12CD3EA7E5A5835FCAE116C07", hash_generated_field = "AE786DEC353802DA8366A92F7929343E")

    private int requestCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.393 -0400", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "7114ADEC0E2E2766A6128D85A9988C45")
    public  HttpResponseCache(File directory, long maxSize) throws IOException {
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
        // ---------- Original Method ----------
        //cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.393 -0400", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "ABEF9B15042BA02048E6B15758FCD649")
    private String uriToKey(URI uri) {
        addTaint(uri.getTaint());
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
String var82C9B5BC7FA60F6DCC8553D2D26588E9_1206080320 =             IntegralToString.bytesToHexString(md5bytes, false);
            var82C9B5BC7FA60F6DCC8553D2D26588E9_1206080320.addTaint(taint);
            return var82C9B5BC7FA60F6DCC8553D2D26588E9_1206080320;
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1089051015 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1089051015.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1089051015;
        } //End block
        // ---------- Original Method ----------
        //try {
            //MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            //return IntegralToString.bytesToHexString(md5bytes, false);
        //} catch (NoSuchAlgorithmException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.394 -0400", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "3176658A5BECCDCC46B6B1F40B7E9D1F")
    @Override
    public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        addTaint(requestHeaders.getTaint());
        addTaint(requestMethod.getTaint());
        addTaint(uri.getTaint());
        String key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try 
        {
            snapshot = cache.get(key);
    if(snapshot == null)            
            {
CacheResponse var540C13E9E156B687226421B24F2DF178_859835728 =                 null;
                var540C13E9E156B687226421B24F2DF178_859835728.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_859835728;
            } //End block
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } //End block
        catch (IOException e)
        {
CacheResponse var540C13E9E156B687226421B24F2DF178_268086432 =             null;
            var540C13E9E156B687226421B24F2DF178_268086432.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_268086432;
        } //End block
    if(!entry.matches(uri, requestMethod, requestHeaders))        
        {
            snapshot.close();
CacheResponse var540C13E9E156B687226421B24F2DF178_1374782938 =             null;
            var540C13E9E156B687226421B24F2DF178_1374782938.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1374782938;
        } //End block
        InputStream body = newBodyInputStream(snapshot);
CacheResponse var1901008CAF5259B3F7C1937589ACF437_72006804 =         entry.isHttps()
                ? entry.newSecureCacheResponse(body)
                : entry.newCacheResponse(body);
        var1901008CAF5259B3F7C1937589ACF437_72006804.addTaint(taint);
        return var1901008CAF5259B3F7C1937589ACF437_72006804;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.395 -0400", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "D2283D38295DF958B768AC08E48DF3B9")
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        addTaint(snapshot.getTaint());
InputStream var0E745B4527042622C7751CC8FF15D1F0_1527038642 =         new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.395 -0400", hash_original_method = "99C3EE16C3080EDF2B3F33CCD793E8EA", hash_generated_method = "B732782A84D6332DF8D3EC8C0DA67E85")
        @Override
        public void close() throws IOException {
            snapshot.close();
            super.close();
            // ---------- Original Method ----------
            //snapshot.close();
            //super.close();
        }
};
        var0E745B4527042622C7751CC8FF15D1F0_1527038642.addTaint(taint);
        return var0E745B4527042622C7751CC8FF15D1F0_1527038642;
        // ---------- Original Method ----------
        //return new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            //@Override public void close() throws IOException {
                //snapshot.close();
                //super.close();
            //}
        //};
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.396 -0400", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "674582AEE59893CCAA969CE7578C2E71")
    @Override
    public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        addTaint(urlConnection.getTaint());
        addTaint(uri.getTaint());
    if(!(urlConnection instanceof HttpURLConnection))        
        {
CacheRequest var540C13E9E156B687226421B24F2DF178_41422874 =             null;
            var540C13E9E156B687226421B24F2DF178_41422874.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_41422874;
        } //End block
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod = httpConnection.getRequestMethod();
        String key = uriToKey(uri);
    if(requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE))        
        {
            try 
            {
                cache.remove(key);
            } //End block
            catch (IOException ignored)
            {
            } //End block
CacheRequest var540C13E9E156B687226421B24F2DF178_430892428 =             null;
            var540C13E9E156B687226421B24F2DF178_430892428.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_430892428;
        } //End block
        else
    if(!requestMethod.equals(HttpEngine.GET))        
        {
CacheRequest var540C13E9E156B687226421B24F2DF178_1675776798 =             null;
            var540C13E9E156B687226421B24F2DF178_1675776798.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1675776798;
        } //End block
        HttpEngine httpEngine = getHttpEngine(httpConnection);
    if(httpEngine == null)        
        {
CacheRequest var540C13E9E156B687226421B24F2DF178_2107522060 =             null;
            var540C13E9E156B687226421B24F2DF178_2107522060.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2107522060;
        } //End block
        ResponseHeaders response = httpEngine.getResponseHeaders();
    if(response.hasVaryAll())        
        {
CacheRequest var540C13E9E156B687226421B24F2DF178_1639252590 =             null;
            var540C13E9E156B687226421B24F2DF178_1639252590.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1639252590;
        } //End block
        RawHeaders varyHeaders = httpEngine.getRequestHeaders().getHeaders().getAll(
                response.getVaryFields());
        Entry entry = new Entry(uri, varyHeaders, httpConnection);
        DiskLruCache.Editor editor = null;
        try 
        {
            editor = cache.edit(key);
    if(editor == null)            
            {
CacheRequest var540C13E9E156B687226421B24F2DF178_1628702069 =                 null;
                var540C13E9E156B687226421B24F2DF178_1628702069.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1628702069;
            } //End block
            entry.writeTo(editor);
CacheRequest var1BBFC2C5BD51A5DA65BD8826D479B6A2_597222774 =             new CacheRequestImpl(editor);
            var1BBFC2C5BD51A5DA65BD8826D479B6A2_597222774.addTaint(taint);
            return var1BBFC2C5BD51A5DA65BD8826D479B6A2_597222774;
        } //End block
        catch (IOException e)
        {
            try 
            {
    if(editor != null)                
                {
                    editor.abort();
                } //End block
            } //End block
            catch (IOException ignored)
            {
            } //End block
CacheRequest var540C13E9E156B687226421B24F2DF178_2083250588 =             null;
            var540C13E9E156B687226421B24F2DF178_2083250588.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2083250588;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.397 -0400", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "82C65A3A4856CFB190D3AD1136E340F0")
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        addTaint(httpConnection.getTaint());
    if(httpConnection instanceof HttpURLConnectionImpl)        
        {
HttpEngine varC84CBC9F4B0D4D54AD84C73111F8FD35_2041913178 =             ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
            varC84CBC9F4B0D4D54AD84C73111F8FD35_2041913178.addTaint(taint);
            return varC84CBC9F4B0D4D54AD84C73111F8FD35_2041913178;
        } //End block
        else
    if(httpConnection instanceof HttpsURLConnectionImpl)        
        {
HttpEngine varAA6A40F4EFBBA585B173F06D634754B7_399408282 =             ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
            varAA6A40F4EFBBA585B173F06D634754B7_399408282.addTaint(taint);
            return varAA6A40F4EFBBA585B173F06D634754B7_399408282;
        } //End block
        else
        {
HttpEngine var540C13E9E156B687226421B24F2DF178_210088857 =             null;
            var540C13E9E156B687226421B24F2DF178_210088857.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_210088857;
        } //End block
        // ---------- Original Method ----------
        //if (httpConnection instanceof HttpURLConnectionImpl) {
            //return ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        //} else if (httpConnection instanceof HttpsURLConnectionImpl) {
            //return ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.397 -0400", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "ED7C316932FA549BCAD474DF6F83F9F8")
    public DiskLruCache getCache() {
DiskLruCache var02A6FDEB64F19DB584E60A103B9AE5CB_1779045493 =         cache;
        var02A6FDEB64F19DB584E60A103B9AE5CB_1779045493.addTaint(taint);
        return var02A6FDEB64F19DB584E60A103B9AE5CB_1779045493;
        // ---------- Original Method ----------
        //return cache;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.397 -0400", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "718980038DE0EA345598255C7E80067E")
    public synchronized int getWriteAbortCount() {
        int var4CFEE5DDB5A666111EBCE2224B5C204B_1368709292 = (writeAbortCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555598368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555598368;
        // ---------- Original Method ----------
        //return writeAbortCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.398 -0400", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "DF614D91BBAA21BFF1005C5F77E01D47")
    public synchronized int getWriteSuccessCount() {
        int var11679E351AB2CDD5977DCC10C5E3BDA9_761321116 = (writeSuccessCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396074059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396074059;
        // ---------- Original Method ----------
        //return writeSuccessCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.398 -0400", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "982331C993FF0C35A247764B922A7D7F")
    synchronized void trackResponse(ResponseSource source) {
        addTaint(source.getTaint());
        requestCount++;
switch(source){
        case CACHE:
        hitCount++;
        break;
        case CONDITIONAL_CACHE:
        case NETWORK:
        networkCount++;
        break;
}
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.398 -0400", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "DED87D8EE049228E5DD63E04F46EE83E")
    synchronized void trackConditionalCacheHit() {
        hitCount++;
        // ---------- Original Method ----------
        //hitCount++;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.398 -0400", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "4010C31F794925C4644888B34574988C")
    public synchronized int getNetworkCount() {
        int var3D06ECB00548A4CD4B10D3412F2AB801_168163597 = (networkCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530171807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530171807;
        // ---------- Original Method ----------
        //return networkCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "3202A832E3E017EF5671E30B3A043CEE")
    public synchronized int getHitCount() {
        int var5BBBCEBEEA805F9664B2979FBACE5699_1160486418 = (hitCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743678815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743678815;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "23DF6462D3662E484367B812CA1E7092")
    public synchronized int getRequestCount() {
        int var27F327C12CD3EA7E5A5835FCAE116C07_1714600575 = (requestCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578490401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578490401;
        // ---------- Original Method ----------
        //return requestCount;
    }

    
    private final class CacheRequestImpl extends CacheRequest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_field = "5AEE9DBD2A188839105073571BEE1B1F", hash_generated_field = "473D8A10E05573BC7984E247163C640F")

        private DiskLruCache.Editor editor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_field = "233DAC44E1A87E581FCE48B9E49D555B", hash_generated_field = "008F5B15E9C0FBDACB4EED71187C2B4B")

        private OutputStream cacheOut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_field = "6B2DED51D81A4403D8A4BD25FA1E57EE", hash_generated_field = "0304A61A6DDC786F4BE08C5BF9CC08ED")

        private boolean done;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.399 -0400", hash_original_field = "841A2D689AD86BD1611447453C22C6FC", hash_generated_field = "B6D92F04843314CDB3A472363E834E04")

        private OutputStream body;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.401 -0400", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "A6E3A495675C4D5C1679506A82C5119D")
        public  CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.400 -0400", hash_original_method = "FD984A0F15EEBC39B69C4BE815EB630F", hash_generated_method = "63A770D8D71A5CB4C75A282665CC0030")
            @Override
            public void close() throws IOException {
                synchronized
(HttpResponseCache.this)                {
    if(done)                    
                    {
                        return;
                    } //End block
                    done = true;
                    writeSuccessCount++;
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.401 -0400", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "135DDBAD43F88A04D483010F63DF2D26")
        @Override
        public void abort() {
            synchronized
(HttpResponseCache.this)            {
    if(done)                
                {
                    return;
                } //End block
                done = true;
                writeAbortCount++;
            } //End block
            IoUtils.closeQuietly(cacheOut);
            try 
            {
                editor.abort();
            } //End block
            catch (IOException ignored)
            {
            } //End block
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.401 -0400", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "942C822D40C072E99CFCE9A8986B4809")
        @Override
        public OutputStream getBody() throws IOException {
OutputStream var6B09DDA67C9E13A10143225BB06C76A0_2060889025 =             body;
            var6B09DDA67C9E13A10143225BB06C76A0_2060889025.addTaint(taint);
            return var6B09DDA67C9E13A10143225BB06C76A0_2060889025;
            // ---------- Original Method ----------
            //return body;
        }

        
    }


    
    private static final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

        private String uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "67BE67CEB267E81A180EF0F50CE7A39E", hash_generated_field = "9921329941711204154BA08BDD062296")

        private RawHeaders varyHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "A39C78373BFA23C94B68F682C465FA3F", hash_generated_field = "9625A54A79CF15AD33875352608C66CF")

        private String requestMethod;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "D6576EAE015D49809D4E175A8DFA3DA7")

        private RawHeaders responseHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

        private String cipherSuite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "DC3CF2AC26AC99678179A5F131C32E62")

        private Certificate[] peerCertificates;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.402 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "028084B73B654EF656F50BBE0F184A93")

        private Certificate[] localCertificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.404 -0400", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "992CEF04CF4F8B44F2C9CC09B933FE5E")
        public  Entry(InputStream in) throws IOException {
            try 
            {
                uri = Streams.readAsciiLine(in);
                requestMethod = Streams.readAsciiLine(in);
                varyHeaders = new RawHeaders();
                int varyRequestHeaderLineCount = readInt(in);
for(int i = 0;i < varyRequestHeaderLineCount;i++)
                {
                    varyHeaders.addLine(Streams.readAsciiLine(in));
                } //End block
                responseHeaders = new RawHeaders();
                responseHeaders.setStatusLine(Streams.readAsciiLine(in));
                int responseHeaderLineCount = readInt(in);
for(int i = 0;i < responseHeaderLineCount;i++)
                {
                    responseHeaders.addLine(Streams.readAsciiLine(in));
                } //End block
    if(isHttps())                
                {
                    String blank = Streams.readAsciiLine(in);
    if(!blank.isEmpty())                    
                    {
                        IOException varD9172FC781F87ED1A8A07E8F30B0CF7D_2117572602 = new IOException("expected \"\" but was \"" + blank + "\"");
                        varD9172FC781F87ED1A8A07E8F30B0CF7D_2117572602.addTaint(taint);
                        throw varD9172FC781F87ED1A8A07E8F30B0CF7D_2117572602;
                    } //End block
                    cipherSuite = Streams.readAsciiLine(in);
                    peerCertificates = readCertArray(in);
                    localCertificates = readCertArray(in);
                } //End block
                else
                {
                    cipherSuite = null;
                    peerCertificates = null;
                    localCertificates = null;
                } //End block
            } //End block
            finally 
            {
                in.close();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.405 -0400", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "4FC61995C091E9EAA1AE368408756DB4")
        public  Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());
    if(isHttps())            
            {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) httpConnection;
                cipherSuite = httpsConnection.getCipherSuite();
                Certificate[] peerCertificatesNonFinal = null;
                try 
                {
                    peerCertificatesNonFinal = httpsConnection.getServerCertificates();
                } //End block
                catch (SSLPeerUnverifiedException ignored)
                {
                } //End block
                peerCertificates = peerCertificatesNonFinal;
                localCertificates = httpsConnection.getLocalCertificates();
            } //End block
            else
            {
                cipherSuite = null;
                peerCertificates = null;
                localCertificates = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.406 -0400", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "A38105188FED9CF78836521772F0E951")
        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            addTaint(editor.getTaint());
            OutputStream out = editor.newOutputStream(0);
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.UTF_8));
            writer.write(uri + '\n');
            writer.write(requestMethod + '\n');
            writer.write(Integer.toString(varyHeaders.length()) + '\n');
for(int i = 0;i < varyHeaders.length();i++)
            {
                writer.write(varyHeaders.getFieldName(i) + ": "
                        + varyHeaders.getValue(i) + '\n');
            } //End block
            writer.write(responseHeaders.getStatusLine() + '\n');
            writer.write(Integer.toString(responseHeaders.length()) + '\n');
for(int i = 0;i < responseHeaders.length();i++)
            {
                writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
            } //End block
    if(isHttps())            
            {
                writer.write('\n');
                writer.write(cipherSuite + '\n');
                writeCertArray(writer, peerCertificates);
                writeCertArray(writer, localCertificates);
            } //End block
            writer.close();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.406 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "848272E070709D37E53B2BA027B92F9A")
        private boolean isHttps() {
            boolean var84590F99892941EEBA41F98A1FDD816B_283707799 = (uri.startsWith("https://"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913092584 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_913092584;
            // ---------- Original Method ----------
            //return uri.startsWith("https://");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.407 -0400", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "E9FD6C5023007C15E27844BDBF0C6924")
        private int readInt(InputStream in) throws IOException {
            addTaint(in.getTaint());
            String intString = Streams.readAsciiLine(in);
            try 
            {
                int varDF2DE15CD60D5D4F0E12A720C4701AB3_1944424722 = (Integer.parseInt(intString));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841143423 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841143423;
            } //End block
            catch (NumberFormatException e)
            {
                IOException var26EBC959D2B44321205902CC049AC06A_2085995193 = new IOException("expected an int but was \"" + intString + "\"");
                var26EBC959D2B44321205902CC049AC06A_2085995193.addTaint(taint);
                throw var26EBC959D2B44321205902CC049AC06A_2085995193;
            } //End block
            // ---------- Original Method ----------
            //String intString = Streams.readAsciiLine(in);
            //try {
                //return Integer.parseInt(intString);
            //} catch (NumberFormatException e) {
                //throw new IOException("expected an int but was \"" + intString + "\"");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.407 -0400", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "A28716F6D280E47253F1F0126AC1ED63")
        private Certificate[] readCertArray(InputStream in) throws IOException {
            addTaint(in.getTaint());
            int length = readInt(in);
    if(length == -1)            
            {
Certificate[] var540C13E9E156B687226421B24F2DF178_1647409788 =                 null;
                var540C13E9E156B687226421B24F2DF178_1647409788.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1647409788;
            } //End block
            try 
            {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                Certificate[] result = new Certificate[length];
for(int i = 0;i < result.length;i++)
                {
                    String line = Streams.readAsciiLine(in);
                    byte[] bytes = Base64.decode(line.getBytes(Charsets.US_ASCII));
                    result[i] = certificateFactory.generateCertificate(
                            new ByteArrayInputStream(bytes));
                } //End block
Certificate[] varDC838461EE2FA0CA4C9BBB70A15456B0_54577028 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_54577028.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_54577028;
            } //End block
            catch (CertificateException e)
            {
                IOException var0AFB0468CE17165C7EF7344B3E18B39B_208672673 = new IOException(e);
                var0AFB0468CE17165C7EF7344B3E18B39B_208672673.addTaint(taint);
                throw var0AFB0468CE17165C7EF7344B3E18B39B_208672673;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.408 -0400", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "61BB549662CE778D830E1FF8B85808B5")
        private void writeCertArray(Writer writer, Certificate[] certificates) throws IOException {
            addTaint(certificates[0].getTaint());
            addTaint(writer.getTaint());
    if(certificates == null)            
            {
                writer.write("-1\n");
                return;
            } //End block
            try 
            {
                writer.write(Integer.toString(certificates.length) + '\n');
for(Certificate certificate : certificates)
                {
                    byte[] bytes = certificate.getEncoded();
                    String line = Base64.encode(bytes);
                    writer.write(line + '\n');
                } //End block
            } //End block
            catch (CertificateEncodingException e)
            {
                IOException var0AFB0468CE17165C7EF7344B3E18B39B_1878770415 = new IOException(e);
                var0AFB0468CE17165C7EF7344B3E18B39B_1878770415.addTaint(taint);
                throw var0AFB0468CE17165C7EF7344B3E18B39B_1878770415;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.409 -0400", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "74C2F95CA080787C46F2C7464CEB9591")
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            addTaint(requestHeaders.getTaint());
            addTaint(requestMethod.getTaint());
            addTaint(uri.getTaint());
            boolean varB0F8EB40BA977898BEF0889E011BA196_993214424 = (this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750756338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_750756338;
            // ---------- Original Method ----------
            //return this.uri.equals(uri.toString())
                    //&& this.requestMethod.equals(requestMethod)
                    //&& new ResponseHeaders(uri, responseHeaders)
                            //.varyMatches(varyHeaders.toMultimap(), requestHeaders);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.410 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "0FFA0967905F2B93B5D06AE9528D745B")
        public CacheResponse newCacheResponse(final InputStream in) {
            addTaint(in.getTaint());
CacheResponse var290A606B2E179EF78FC04FCFE9A15A2D_665088924 =             new CacheResponse() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.409 -0400", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "ADE1D1713FD3B8B3FE2B47809BA60018")
            @Override
            public Map<String, List<String>> getHeaders() {
Map<String, List<String>> var0919DB83F382E960ABF31AD5831D30F0_123314796 =                 responseHeaders.toMultimap();
                var0919DB83F382E960ABF31AD5831D30F0_123314796.addTaint(taint);
                return var0919DB83F382E960ABF31AD5831D30F0_123314796;
                // ---------- Original Method ----------
                //return responseHeaders.toMultimap();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.410 -0400", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "F5C5E207D4A2FEA73573808DB39BE359")
            @Override
            public InputStream getBody() {
InputStream var091D3B9C0C9CE73F019D8ED2F738F1B8_58429801 =                 in;
                var091D3B9C0C9CE73F019D8ED2F738F1B8_58429801.addTaint(taint);
                return var091D3B9C0C9CE73F019D8ED2F738F1B8_58429801;
                // ---------- Original Method ----------
                //return in;
            }
};
            var290A606B2E179EF78FC04FCFE9A15A2D_665088924.addTaint(taint);
            return var290A606B2E179EF78FC04FCFE9A15A2D_665088924;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.412 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "77801AAF362813965661C1B91F13CFAB")
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            addTaint(in.getTaint());
SecureCacheResponse varD331870BD359303242F080E81225CD8A_1745525667 =             new SecureCacheResponse() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.410 -0400", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "4A789E206BC2ECE722187546808BDC14")
            @Override
            public Map<String, List<String>> getHeaders() {
Map<String, List<String>> var0919DB83F382E960ABF31AD5831D30F0_1930361972 =                 responseHeaders.toMultimap();
                var0919DB83F382E960ABF31AD5831D30F0_1930361972.addTaint(taint);
                return var0919DB83F382E960ABF31AD5831D30F0_1930361972;
                // ---------- Original Method ----------
                //return responseHeaders.toMultimap();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.411 -0400", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "921F2DB20BD156B8B4E7B6912CD69D44")
            @Override
            public InputStream getBody() {
InputStream var091D3B9C0C9CE73F019D8ED2F738F1B8_52010861 =                 in;
                var091D3B9C0C9CE73F019D8ED2F738F1B8_52010861.addTaint(taint);
                return var091D3B9C0C9CE73F019D8ED2F738F1B8_52010861;
                // ---------- Original Method ----------
                //return in;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.411 -0400", hash_original_method = "D670C2680AE46E78B21CAD2B9515E8E7", hash_generated_method = "6CFD097B6E45523D78054EE384A53D95")
            @Override
            public String getCipherSuite() {
String var40C8215E3932EC890F412FE48280D7DD_1223590066 =                 cipherSuite;
                var40C8215E3932EC890F412FE48280D7DD_1223590066.addTaint(taint);
                return var40C8215E3932EC890F412FE48280D7DD_1223590066;
                // ---------- Original Method ----------
                //return cipherSuite;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.411 -0400", hash_original_method = "31D74A5EDE84A239E816669DB515C06E", hash_generated_method = "1F6A72CED8AF2E466334A431178AA543")
            @Override
            public List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException {
    if(peerCertificates == null || peerCertificates.length == 0)                
                {
                    SSLPeerUnverifiedException var15B56F829F223096E3D03A2273DF8459_1652551649 = new SSLPeerUnverifiedException(null);
                    var15B56F829F223096E3D03A2273DF8459_1652551649.addTaint(taint);
                    throw var15B56F829F223096E3D03A2273DF8459_1652551649;
                } //End block
List<Certificate> var44D8B809DE3BE19E12B27A7BA0626027_900347277 =                 Arrays.asList(peerCertificates.clone());
                var44D8B809DE3BE19E12B27A7BA0626027_900347277.addTaint(taint);
                return var44D8B809DE3BE19E12B27A7BA0626027_900347277;
                // ---------- Original Method ----------
                //if (peerCertificates == null || peerCertificates.length == 0) {
                        //throw new SSLPeerUnverifiedException(null);
                    //}
                //return Arrays.asList(peerCertificates.clone());
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.412 -0400", hash_original_method = "B0F4ED14395510FBFE1098A8134CF356", hash_generated_method = "3A0056AF571D8C25EA32F41EC877122E")
            @Override
            public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
    if(peerCertificates == null || peerCertificates.length == 0)                
                {
                    SSLPeerUnverifiedException var15B56F829F223096E3D03A2273DF8459_860025853 = new SSLPeerUnverifiedException(null);
                    var15B56F829F223096E3D03A2273DF8459_860025853.addTaint(taint);
                    throw var15B56F829F223096E3D03A2273DF8459_860025853;
                } //End block
Principal varB8DD06744980BE3D902166440D839E34_1984543634 =                 ((X509Certificate) peerCertificates[0]).getSubjectX500Principal();
                varB8DD06744980BE3D902166440D839E34_1984543634.addTaint(taint);
                return varB8DD06744980BE3D902166440D839E34_1984543634;
                // ---------- Original Method ----------
                //if (peerCertificates == null || peerCertificates.length == 0) {
                        //throw new SSLPeerUnverifiedException(null);
                    //}
                //return ((X509Certificate) peerCertificates[0]).getSubjectX500Principal();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.412 -0400", hash_original_method = "88CD48CB7FE6E4F8F5378B409F5088BC", hash_generated_method = "3AFBFD9F0DCFAF120EF5AAF8876AE494")
            @Override
            public List<Certificate> getLocalCertificateChain() {
    if(localCertificates == null || localCertificates.length == 0)                
                {
List<Certificate> var540C13E9E156B687226421B24F2DF178_1188820350 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1188820350.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1188820350;
                } //End block
List<Certificate> var45416A2952A04A8B80CD9AF35BE9677F_1740517981 =                 Arrays.asList(localCertificates.clone());
                var45416A2952A04A8B80CD9AF35BE9677F_1740517981.addTaint(taint);
                return var45416A2952A04A8B80CD9AF35BE9677F_1740517981;
                // ---------- Original Method ----------
                //if (localCertificates == null || localCertificates.length == 0) {
                        //return null;
                    //}
                //return Arrays.asList(localCertificates.clone());
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.412 -0400", hash_original_method = "0108FA4D241BF83AF9A8889A5D800085", hash_generated_method = "F83117EE6EC5B30F253EA6064803558C")
            @Override
            public Principal getLocalPrincipal() {
    if(localCertificates == null || localCertificates.length == 0)                
                {
Principal var540C13E9E156B687226421B24F2DF178_1304540138 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1304540138.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1304540138;
                } //End block
Principal varEAA5F94E34353445CB8976FBCACEF8E9_1148990758 =                 ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
                varEAA5F94E34353445CB8976FBCACEF8E9_1148990758.addTaint(taint);
                return varEAA5F94E34353445CB8976FBCACEF8E9_1148990758;
                // ---------- Original Method ----------
                //if (localCertificates == null || localCertificates.length == 0) {
                        //return null;
                    //}
                //return ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
            }
};
            varD331870BD359303242F080E81225CD8A_1745525667.addTaint(taint);
            return varD331870BD359303242F080E81225CD8A_1745525667;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.413 -0400", hash_original_field = "FBC64DE7E28C29FA7A0D298DC4B80EE9", hash_generated_field = "9B09D8AD9E5D9CB9C068F9CC40FB0395")

    private static final int VERSION = 201105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.413 -0400", hash_original_field = "4A75CD08A654B4D8DD3837B3EC053D66", hash_generated_field = "0776A45C3DD1FFCE8D2D96E47CC39786")

    private static final int ENTRY_METADATA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.413 -0400", hash_original_field = "FAC54FABB55F801B93D21B8EE66068DC", hash_generated_field = "E5113D1AEC335048014C4BFA2995DB52")

    private static final int ENTRY_BODY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.413 -0400", hash_original_field = "F9DF2C58097C8A433569D632FFA49D34", hash_generated_field = "3E63766656FB84DF97D5F150C04CFF24")

    private static final int ENTRY_COUNT = 2;
}

