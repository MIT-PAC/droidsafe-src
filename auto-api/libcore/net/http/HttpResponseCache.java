package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "8D7B3AC911505868AEA4010DF26181F8")

    private DiskLruCache cache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "11679E351AB2CDD5977DCC10C5E3BDA9", hash_generated_field = "9451CF6EB93EE29D841188FD01582E44")

    private int writeSuccessCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "4CFEE5DDB5A666111EBCE2224B5C204B", hash_generated_field = "BF027D0731613DD6EDBF7FD99E17F8D6")

    private int writeAbortCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "3D06ECB00548A4CD4B10D3412F2AB801", hash_generated_field = "843970BEE5BFFD7AF4318A1DF280F033")

    private int networkCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_field = "27F327C12CD3EA7E5A5835FCAE116C07", hash_generated_field = "AE786DEC353802DA8366A92F7929343E")

    private int requestCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.026 -0400", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "7114ADEC0E2E2766A6128D85A9988C45")
    public  HttpResponseCache(File directory, long maxSize) throws IOException {
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.027 -0400", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "A46361AF1CE03437A9CE844300BA3AF0")
    private String uriToKey(URI uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_331402793 = null; 
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            varB4EAC82CA7396A68D541C85D26508E83_331402793 = IntegralToString.bytesToHexString(md5bytes, false);
        } 
        catch (NoSuchAlgorithmException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_331402793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_331402793;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.028 -0400", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "44862DA63242CF09936789843A868DA2")
    @Override
    public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1823411104 = null; 
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1438153327 = null; 
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_2069338759 = null; 
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1771429807 = null; 
        String key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try 
        {
            snapshot = cache.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1823411104 = null;
            } 
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } 
        catch (IOException e)
        {
        	return null;
        } 
        {
            boolean var7D158C8C8D146A47EF280B1AAB085822_571608166 = (!entry.matches(uri, requestMethod, requestHeaders));
            {
                snapshot.close();
                varB4EAC82CA7396A68D541C85D26508E83_2069338759 = null;
            } 
        } 
        InputStream body = newBodyInputStream(snapshot);
        varB4EAC82CA7396A68D541C85D26508E83_1771429807 = entry.isHttps()
                ? entry.newSecureCacheResponse(body)
                : entry.newCacheResponse(body);
        addTaint(uri.getTaint());
        addTaint(requestMethod.getTaint());
        addTaint(requestHeaders.getTaint());
        CacheResponse varA7E53CE21691AB073D9660D615818899_243362894; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_243362894 = varB4EAC82CA7396A68D541C85D26508E83_1823411104;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_243362894 = varB4EAC82CA7396A68D541C85D26508E83_1438153327;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_243362894 = varB4EAC82CA7396A68D541C85D26508E83_2069338759;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_243362894 = varB4EAC82CA7396A68D541C85D26508E83_1771429807;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_243362894.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_243362894;
        
        
        
        
        
            
            
                
            
            
        
            
        
        
            
            
        
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.029 -0400", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "4F8C3EBA44DC43B927596302A74E59E0")
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1881337667 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1881337667 = new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            @Override public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
        addTaint(snapshot.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1881337667.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1881337667;
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.031 -0400", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "EF6D541749D3B59D22A5531C1958C976")
    @Override
    public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1825157658 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_2028504781 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1412267197 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1781411730 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1052263758 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1257213561 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_2098131885 = null; 
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_174128538 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1825157658 = null;
        } 
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod = httpConnection.getRequestMethod();
        String key = uriToKey(uri);
        {
            boolean var0B2F5AEE4A5D54E8FD8E2859428117D5_1397317153 = (requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE));
            {
                try 
                {
                    cache.remove(key);
                } 
                catch (IOException ignored)
                { }
                varB4EAC82CA7396A68D541C85D26508E83_2028504781 = null;
            } 
            {
                boolean varF71487804C2D751E21461994C2134753_1121708745 = (!requestMethod.equals(HttpEngine.GET));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1412267197 = null;
                } 
            } 
        } 
        HttpEngine httpEngine = getHttpEngine(httpConnection);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1781411730 = null;
        } 
        ResponseHeaders response = httpEngine.getResponseHeaders();
        {
            boolean varD01FB646ABB2F9C328677DB0F2848406_1739411229 = (response.hasVaryAll());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1052263758 = null;
            } 
        } 
        RawHeaders varyHeaders = httpEngine.getRequestHeaders().getHeaders().getAll(
                response.getVaryFields());
        Entry entry = new Entry(uri, varyHeaders, httpConnection);
        DiskLruCache.Editor editor = null;
        try 
        {
            editor = cache.edit(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1257213561 = null;
            } 
            entry.writeTo(editor);
            varB4EAC82CA7396A68D541C85D26508E83_2098131885 = new CacheRequestImpl(editor);
        } 
        catch (IOException e)
        {
            try 
            {
                {
                    editor.abort();
                } 
            } 
            catch (IOException ignored)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_174128538 = null;
        } 
        addTaint(uri.getTaint());
        addTaint(urlConnection.getTaint());
        CacheRequest varA7E53CE21691AB073D9660D615818899_905797834; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_1825157658;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_2028504781;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_1412267197;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_1781411730;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_1052263758;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_1257213561;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_2098131885;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_905797834 = varB4EAC82CA7396A68D541C85D26508E83_174128538;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_905797834.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_905797834;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.032 -0400", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "3056C55BDFDF7E3FEEB67A7489195D5E")
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_763542417 = null; 
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1621059954 = null; 
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1924485780 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_763542417 = ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1621059954 = ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1924485780 = null;
        } 
        addTaint(httpConnection.getTaint());
        HttpEngine varA7E53CE21691AB073D9660D615818899_262471200; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_262471200 = varB4EAC82CA7396A68D541C85D26508E83_763542417;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_262471200 = varB4EAC82CA7396A68D541C85D26508E83_1621059954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_262471200 = varB4EAC82CA7396A68D541C85D26508E83_1924485780;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_262471200.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_262471200;
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.032 -0400", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "E13184C6F309B6A75D18224670E6991B")
    public DiskLruCache getCache() {
        DiskLruCache varB4EAC82CA7396A68D541C85D26508E83_1004198486 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1004198486 = cache;
        varB4EAC82CA7396A68D541C85D26508E83_1004198486.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1004198486;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.032 -0400", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "4763632EABC3502EED258528F747A1D1")
    public synchronized int getWriteAbortCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139572372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139572372;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.033 -0400", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "C60BF8E20CDF90A7CF63BDC1AD822930")
    public synchronized int getWriteSuccessCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754916957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754916957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.033 -0400", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "350AC598482D79400E158FBCCA1F2AE2")
    synchronized void trackResponse(ResponseSource source) {
        addTaint(source.getTaint());
        
        
        
        
            
            
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.033 -0400", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "2CBB05F2719F07329394083BF14747F7")
    synchronized void trackConditionalCacheHit() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.033 -0400", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "0DF4FDB25EC52C041D1C1B89B71B7896")
    public synchronized int getNetworkCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136306906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136306906;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "07BEF94A2B1E425A93B8DF96C67BF596")
    public synchronized int getHitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867840339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867840339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "B155755E2226FEBABA5A3FDBA85F1854")
    public synchronized int getRequestCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652262504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652262504;
        
        
    }

    
    private final class CacheRequestImpl extends CacheRequest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_field = "5AEE9DBD2A188839105073571BEE1B1F", hash_generated_field = "473D8A10E05573BC7984E247163C640F")

        private DiskLruCache.Editor editor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_field = "233DAC44E1A87E581FCE48B9E49D555B", hash_generated_field = "008F5B15E9C0FBDACB4EED71187C2B4B")

        private OutputStream cacheOut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_field = "6B2DED51D81A4403D8A4BD25FA1E57EE", hash_generated_field = "0304A61A6DDC786F4BE08C5BF9CC08ED")

        private boolean done;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.034 -0400", hash_original_field = "841A2D689AD86BD1611447453C22C6FC", hash_generated_field = "B6D92F04843314CDB3A472363E834E04")

        private OutputStream body;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.035 -0400", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "9D67295A24A5DC7E38196D29146292F6")
        public  CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.035 -0400", hash_original_method = "FD984A0F15EEBC39B69C4BE815EB630F", hash_generated_method = "6FEEAB420ABAE5B33E5B736F5A9A710E")
                @Override
                public void close() throws IOException {
                    {
                        Object var74E2887A5956FAB739B88C491C5E3C62_1265161250 = (HttpResponseCache.this);
                        {
                            done = true;
                        } 
                    } 
                    super.close();
                    editor.commit();
                    
                    
                        
                            
                        
                        
                        
                    
                    
                    
                }
};
            
            
            
            
                
                    
                        
                            
                        
                        
                        
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.036 -0400", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "E7B09D1E187AFE19EFB7D11EBD62B455")
        @Override
        public void abort() {
            {
                Object var51C5DD3C3DCDA8C40E73B3B67AC6A541_1923727231 = (HttpResponseCache.this);
                {
                    done = true;
                } 
            } 
            IoUtils.closeQuietly(cacheOut);
            try 
            {
                editor.abort();
            } 
            catch (IOException ignored)
            { }
            
            
                
                    
                
                
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "43EC16517959440405820BFBCA270695")
        @Override
        public OutputStream getBody() throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_199606705 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_199606705 = body;
            varB4EAC82CA7396A68D541C85D26508E83_199606705.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_199606705;
            
            
        }

        
    }


    
    private static final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

        private String uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "67BE67CEB267E81A180EF0F50CE7A39E", hash_generated_field = "9921329941711204154BA08BDD062296")

        private RawHeaders varyHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "A39C78373BFA23C94B68F682C465FA3F", hash_generated_field = "9625A54A79CF15AD33875352608C66CF")

        private String requestMethod;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "D6576EAE015D49809D4E175A8DFA3DA7")

        private RawHeaders responseHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

        private String cipherSuite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "DC3CF2AC26AC99678179A5F131C32E62")

        private Certificate[] peerCertificates;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.037 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "028084B73B654EF656F50BBE0F184A93")

        private Certificate[] localCertificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.039 -0400", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "305931DDFD50BD260B0E00745417E89D")
        public  Entry(InputStream in) throws IOException {
            try 
            {
                uri = Streams.readAsciiLine(in);
                requestMethod = Streams.readAsciiLine(in);
                varyHeaders = new RawHeaders();
                int varyRequestHeaderLineCount = readInt(in);
                {
                    int i = 0;
                    {
                        varyHeaders.addLine(Streams.readAsciiLine(in));
                    } 
                } 
                responseHeaders = new RawHeaders();
                responseHeaders.setStatusLine(Streams.readAsciiLine(in));
                int responseHeaderLineCount = readInt(in);
                {
                    int i = 0;
                    {
                        responseHeaders.addLine(Streams.readAsciiLine(in));
                    } 
                } 
                {
                    boolean varFFA211E0A88DB8D3D1C49D50249DE024_1144142458 = (isHttps());
                    {
                        String blank = Streams.readAsciiLine(in);
                        {
                            boolean varE57DC7EEFAD90FA932B591041168097D_1428098523 = (!blank.isEmpty());
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IOException("expected \"\" but was \"" + blank + "\"");
                            } 
                        } 
                        cipherSuite = Streams.readAsciiLine(in);
                        peerCertificates = readCertArray(in);
                        localCertificates = readCertArray(in);
                    } 
                    {
                        cipherSuite = null;
                        peerCertificates = null;
                        localCertificates = null;
                    } 
                } 
            } 
            finally 
            {
                in.close();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.040 -0400", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "169B9D921EBD2A0BD5BE209FAE91CF2F")
        public  Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());
            {
                boolean varFCAD955B043A900B307875922675107D_438945451 = (isHttps());
                {
                    HttpsURLConnection httpsConnection = (HttpsURLConnection) httpConnection;
                    cipherSuite = httpsConnection.getCipherSuite();
                    Certificate[] peerCertificatesNonFinal = null;
                    try 
                    {
                        peerCertificatesNonFinal = httpsConnection.getServerCertificates();
                    } 
                    catch (SSLPeerUnverifiedException ignored)
                    { }
                    peerCertificates = peerCertificatesNonFinal;
                    localCertificates = httpsConnection.getLocalCertificates();
                } 
                {
                    cipherSuite = null;
                    peerCertificates = null;
                    localCertificates = null;
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.043 -0400", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "00B0C998AB1AEAFCF1DAEA8B110A2B29")
        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            OutputStream out = editor.newOutputStream(0);
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.UTF_8));
            writer.write(uri + '\n');
            writer.write(requestMethod + '\n');
            writer.write(Integer.toString(varyHeaders.length()) + '\n');
            {
                int i = 0;
                boolean var91F436A92F4865E1C76BC6FEB9045E64_3686565 = (i < varyHeaders.length());
                {
                    writer.write(varyHeaders.getFieldName(i) + ": "
                        + varyHeaders.getValue(i) + '\n');
                } 
            } 
            writer.write(responseHeaders.getStatusLine() + '\n');
            writer.write(Integer.toString(responseHeaders.length()) + '\n');
            {
                int i = 0;
                boolean varCD2269726C173194777BF60852BC28C6_855903652 = (i < responseHeaders.length());
                {
                    writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
                } 
            } 
            {
                boolean varFCAD955B043A900B307875922675107D_2056780796 = (isHttps());
                {
                    writer.write('\n');
                    writer.write(cipherSuite + '\n');
                    writeCertArray(writer, peerCertificates);
                    writeCertArray(writer, localCertificates);
                } 
            } 
            writer.close();
            addTaint(editor.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.046 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "4EDE5A246BCD7F38E0565C3D9B548DB3")
        private boolean isHttps() {
            boolean varFF3DAACE38DA6F1DB496E4B7E3303BBB_1541996309 = (uri.startsWith("https://"));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060156154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060156154;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.046 -0400", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "ADE6AB1CCF73CD7A5A1632C818489E7C")
        private int readInt(InputStream in) throws IOException {
            String intString = Streams.readAsciiLine(in);
            try 
            {
                int varABA47AA6CC39041115500328692BECDF_1092049379 = (Integer.parseInt(intString));
            } 
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("expected an int but was \"" + intString + "\"");
            } 
            addTaint(in.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164339492 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164339492;
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.047 -0400", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "7D6EEC1EC77F0DC432CCFC67FD0D1C50")
        private Certificate[] readCertArray(InputStream in) throws IOException {
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1649360097 = null; 
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_826684433 = null; 
            int length = readInt(in);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1649360097 = null;
            } 
            try 
            {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                Certificate[] result = new Certificate[length];
                {
                    int i = 0;
                    {
                        String line = Streams.readAsciiLine(in);
                        byte[] bytes = Base64.decode(line.getBytes(Charsets.US_ASCII));
                        result[i] = certificateFactory.generateCertificate(
                            new ByteArrayInputStream(bytes));
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_826684433 = result;
            } 
            catch (CertificateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } 
            addTaint(in.getTaint());
            Certificate[] varA7E53CE21691AB073D9660D615818899_251642836; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_251642836 = varB4EAC82CA7396A68D541C85D26508E83_1649360097;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_251642836 = varB4EAC82CA7396A68D541C85D26508E83_826684433;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_251642836.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_251642836;
            
            
            
                
            
            
                
                
                
                    
                    
                    
                            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.049 -0400", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "53176741DFF8216E55451D730823B262")
        private void writeCertArray(Writer writer, Certificate[] certificates) throws IOException {
            {
                writer.write("-1\n");
            } 
            try 
            {
                writer.write(Integer.toString(certificates.length) + '\n');
                {
                    Certificate certificate = certificates[0];
                    {
                        byte[] bytes = certificate.getEncoded();
                        String line = Base64.encode(bytes);
                        writer.write(line + '\n');
                    } 
                } 
            } 
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } 
            addTaint(writer.getTaint());
            addTaint(certificates[0].getTaint());
            
            
                
                
            
            
                
                
                    
                    
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.050 -0400", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "34D30606F9FFFFBCF1C2311338B911BC")
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            boolean varE71B126F6436F11D7B0403FF7EAFCF2C_1010889867 = (this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders));
            addTaint(uri.getTaint());
            addTaint(requestMethod.getTaint());
            addTaint(requestHeaders.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329466785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_329466785;
            
            
                    
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.051 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "F391E7300C995B38D37D7F3BF765DDD5")
        public CacheResponse newCacheResponse(final InputStream in) {
            CacheResponse varB4EAC82CA7396A68D541C85D26508E83_437013179 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_437013179 = new CacheResponse() {
                @Override public Map<String, List<String>> getHeaders() {
                    return responseHeaders.toMultimap();
                }
                @Override public InputStream getBody() {
                    return in;
                }
            };
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_437013179.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_437013179;
            
            
                
                    
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.053 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "4EE0F89CCA41B4868E944659FD87BD85")
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_1505789267 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1505789267 = new SecureCacheResponse() {
                @Override public Map<String, List<String>> getHeaders() {
                    return responseHeaders.toMultimap();
                }
                @Override public InputStream getBody() {
                    return in;
                }
                @Override public String getCipherSuite() {
                    return cipherSuite;
                }
                @Override public List<Certificate> getServerCertificateChain()
                        throws SSLPeerUnverifiedException {
                    if (peerCertificates == null || peerCertificates.length == 0) {
                        throw new SSLPeerUnverifiedException(null);
                    }
                    return Arrays.asList(peerCertificates.clone());
                }
                @Override public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                    if (peerCertificates == null || peerCertificates.length == 0) {
                        throw new SSLPeerUnverifiedException(null);
                    }
                    return ((X509Certificate) peerCertificates[0]).getSubjectX500Principal();
                }
                @Override public List<Certificate> getLocalCertificateChain() {
                    if (localCertificates == null || localCertificates.length == 0) {
                        return null;
                    }
                    return Arrays.asList(localCertificates.clone());
                }
                @Override public Principal getLocalPrincipal() {
                    if (localCertificates == null || localCertificates.length == 0) {
                        return null;
                    }
                    return ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
                }
            };
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1505789267.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1505789267;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.053 -0400", hash_original_field = "FBC64DE7E28C29FA7A0D298DC4B80EE9", hash_generated_field = "9B09D8AD9E5D9CB9C068F9CC40FB0395")

    private static final int VERSION = 201105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.053 -0400", hash_original_field = "4A75CD08A654B4D8DD3837B3EC053D66", hash_generated_field = "0776A45C3DD1FFCE8D2D96E47CC39786")

    private static final int ENTRY_METADATA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.053 -0400", hash_original_field = "FAC54FABB55F801B93D21B8EE66068DC", hash_generated_field = "E5113D1AEC335048014C4BFA2995DB52")

    private static final int ENTRY_BODY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.053 -0400", hash_original_field = "F9DF2C58097C8A433569D632FFA49D34", hash_generated_field = "3E63766656FB84DF97D5F150C04CFF24")

    private static final int ENTRY_COUNT = 2;
}

