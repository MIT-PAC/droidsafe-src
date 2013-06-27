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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "8D7B3AC911505868AEA4010DF26181F8")

    private DiskLruCache cache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "11679E351AB2CDD5977DCC10C5E3BDA9", hash_generated_field = "9451CF6EB93EE29D841188FD01582E44")

    private int writeSuccessCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "4CFEE5DDB5A666111EBCE2224B5C204B", hash_generated_field = "BF027D0731613DD6EDBF7FD99E17F8D6")

    private int writeAbortCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "3D06ECB00548A4CD4B10D3412F2AB801", hash_generated_field = "843970BEE5BFFD7AF4318A1DF280F033")

    private int networkCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.270 -0400", hash_original_field = "27F327C12CD3EA7E5A5835FCAE116C07", hash_generated_field = "AE786DEC353802DA8366A92F7929343E")

    private int requestCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.281 -0400", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "7114ADEC0E2E2766A6128D85A9988C45")
    public  HttpResponseCache(File directory, long maxSize) throws IOException {
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
        // ---------- Original Method ----------
        //cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.281 -0400", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "82081D2EF6338E2A8DB62D2FFC3A6478")
    private String uriToKey(URI uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1810278461 = null; //Variable for return #1
        try 
        {
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes;
            md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            varB4EAC82CA7396A68D541C85D26508E83_1810278461 = IntegralToString.bytesToHexString(md5bytes, false);
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1810278461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1810278461;
        // ---------- Original Method ----------
        //try {
            //MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            //return IntegralToString.bytesToHexString(md5bytes, false);
        //} catch (NoSuchAlgorithmException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.291 -0400", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "088E803A79342228D84FF7A2A0ECDE3E")
    @Override
    public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1676535232 = null; //Variable for return #1
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_427442295 = null; //Variable for return #2
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_181802167 = null; //Variable for return #3
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_2084023920 = null; //Variable for return #4
        String key;
        key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try 
        {
            snapshot = cache.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1676535232 = null;
            } //End block
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_427442295 = null;
        } //End block
        {
            boolean var7D158C8C8D146A47EF280B1AAB085822_484398350 = (!entry.matches(uri, requestMethod, requestHeaders));
            {
                snapshot.close();
                varB4EAC82CA7396A68D541C85D26508E83_181802167 = null;
            } //End block
        } //End collapsed parenthetic
        InputStream body;
        body = newBodyInputStream(snapshot);
        varB4EAC82CA7396A68D541C85D26508E83_2084023920 = entry.isHttps()
                ? entry.newSecureCacheResponse(body)
                : entry.newCacheResponse(body);
        addTaint(uri.getTaint());
        addTaint(requestMethod.getTaint());
        addTaint(requestHeaders.getTaint());
        CacheResponse varA7E53CE21691AB073D9660D615818899_1921632942; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1921632942 = varB4EAC82CA7396A68D541C85D26508E83_1676535232;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1921632942 = varB4EAC82CA7396A68D541C85D26508E83_427442295;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1921632942 = varB4EAC82CA7396A68D541C85D26508E83_181802167;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1921632942 = varB4EAC82CA7396A68D541C85D26508E83_2084023920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1921632942.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1921632942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.292 -0400", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "531F2B50F94B3542E6D379451DBBF4EB")
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_633644754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_633644754 = new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            @Override public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
        addTaint(snapshot.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_633644754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_633644754;
        // ---------- Original Method ----------
        //return new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            //@Override public void close() throws IOException {
                //snapshot.close();
                //super.close();
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.297 -0400", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "BC624236E424791AB1D4580FBE9CEF5A")
    @Override
    public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_349856925 = null; //Variable for return #1
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1376369330 = null; //Variable for return #2
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1889674978 = null; //Variable for return #3
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1160193049 = null; //Variable for return #4
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1672515178 = null; //Variable for return #5
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1820250386 = null; //Variable for return #6
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_201841002 = null; //Variable for return #7
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1080160895 = null; //Variable for return #8
        {
            varB4EAC82CA7396A68D541C85D26508E83_349856925 = null;
        } //End block
        HttpURLConnection httpConnection;
        httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod;
        requestMethod = httpConnection.getRequestMethod();
        String key;
        key = uriToKey(uri);
        {
            boolean var0B2F5AEE4A5D54E8FD8E2859428117D5_1189254975 = (requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE));
            {
                try 
                {
                    cache.remove(key);
                } //End block
                catch (IOException ignored)
                { }
                varB4EAC82CA7396A68D541C85D26508E83_1376369330 = null;
            } //End block
            {
                boolean varF71487804C2D751E21461994C2134753_1843088086 = (!requestMethod.equals(HttpEngine.GET));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1889674978 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        HttpEngine httpEngine;
        httpEngine = getHttpEngine(httpConnection);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1160193049 = null;
        } //End block
        ResponseHeaders response;
        response = httpEngine.getResponseHeaders();
        {
            boolean varD01FB646ABB2F9C328677DB0F2848406_796582374 = (response.hasVaryAll());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1672515178 = null;
            } //End block
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_1820250386 = null;
            } //End block
            entry.writeTo(editor);
            varB4EAC82CA7396A68D541C85D26508E83_201841002 = new CacheRequestImpl(editor);
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
            varB4EAC82CA7396A68D541C85D26508E83_1080160895 = null;
        } //End block
        addTaint(uri.getTaint());
        addTaint(urlConnection.getTaint());
        CacheRequest varA7E53CE21691AB073D9660D615818899_278530622; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_349856925;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1376369330;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1889674978;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1160193049;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1672515178;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1820250386;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_201841002;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_278530622 = varB4EAC82CA7396A68D541C85D26508E83_1080160895;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_278530622.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_278530622;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.299 -0400", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "6CB22D358C133DF60F0EBC411DB4F400")
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1474498489 = null; //Variable for return #1
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1844735834 = null; //Variable for return #2
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1424197068 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1474498489 = ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1844735834 = ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1424197068 = null;
        } //End block
        addTaint(httpConnection.getTaint());
        HttpEngine varA7E53CE21691AB073D9660D615818899_217171599; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_217171599 = varB4EAC82CA7396A68D541C85D26508E83_1474498489;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_217171599 = varB4EAC82CA7396A68D541C85D26508E83_1844735834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_217171599 = varB4EAC82CA7396A68D541C85D26508E83_1424197068;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_217171599.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_217171599;
        // ---------- Original Method ----------
        //if (httpConnection instanceof HttpURLConnectionImpl) {
            //return ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        //} else if (httpConnection instanceof HttpsURLConnectionImpl) {
            //return ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.299 -0400", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "FB0E9F534287000F5E0CD9A433190A6C")
    public DiskLruCache getCache() {
        DiskLruCache varB4EAC82CA7396A68D541C85D26508E83_1688721419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1688721419 = cache;
        varB4EAC82CA7396A68D541C85D26508E83_1688721419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1688721419;
        // ---------- Original Method ----------
        //return cache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.300 -0400", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "6005BAD514F7020FF3C1027CFAAD3302")
    public synchronized int getWriteAbortCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225501928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225501928;
        // ---------- Original Method ----------
        //return writeAbortCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.310 -0400", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "40455C3E00FDAF528C6CFAD5FE79DB73")
    public synchronized int getWriteSuccessCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341269562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341269562;
        // ---------- Original Method ----------
        //return writeSuccessCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.310 -0400", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "350AC598482D79400E158FBCCA1F2AE2")
    synchronized void trackResponse(ResponseSource source) {
        addTaint(source.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.310 -0400", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "2CBB05F2719F07329394083BF14747F7")
    synchronized void trackConditionalCacheHit() {
        // ---------- Original Method ----------
        //hitCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.311 -0400", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "6B0CED2F8425F005248F386980557C34")
    public synchronized int getNetworkCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797542705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797542705;
        // ---------- Original Method ----------
        //return networkCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.316 -0400", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "00C8D30F2E20B35BA737CAC92DC21155")
    public synchronized int getHitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039765581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039765581;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.317 -0400", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "C2443DB3C1D452067399F1C0762EFE74")
    public synchronized int getRequestCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363621605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363621605;
        // ---------- Original Method ----------
        //return requestCount;
    }

    
    private final class CacheRequestImpl extends CacheRequest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.317 -0400", hash_original_field = "5AEE9DBD2A188839105073571BEE1B1F", hash_generated_field = "473D8A10E05573BC7984E247163C640F")

        private DiskLruCache.Editor editor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.317 -0400", hash_original_field = "233DAC44E1A87E581FCE48B9E49D555B", hash_generated_field = "008F5B15E9C0FBDACB4EED71187C2B4B")

        private OutputStream cacheOut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.317 -0400", hash_original_field = "6B2DED51D81A4403D8A4BD25FA1E57EE", hash_generated_field = "0304A61A6DDC786F4BE08C5BF9CC08ED")

        private boolean done;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.317 -0400", hash_original_field = "841A2D689AD86BD1611447453C22C6FC", hash_generated_field = "B6D92F04843314CDB3A472363E834E04")

        private OutputStream body;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.319 -0400", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "154ED93AC3F26C0412523F0D8B76AC12")
        public  CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.318 -0400", hash_original_method = "FD984A0F15EEBC39B69C4BE815EB630F", hash_generated_method = "AB9EBE6B54C581C530A7D58883CCFD82")
                @Override
                public void close() throws IOException {
                    {
                        Object var74E2887A5956FAB739B88C491C5E3C62_575025959 = (HttpResponseCache.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.329 -0400", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "1F0F8F92F1142593324C9F78E9E7CAE2")
        @Override
        public void abort() {
            {
                Object var51C5DD3C3DCDA8C40E73B3B67AC6A541_2060144860 = (HttpResponseCache.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "4B053A7A35BD018BA9E47A1E50D9E605")
        @Override
        public OutputStream getBody() throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_448340216 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_448340216 = body;
            varB4EAC82CA7396A68D541C85D26508E83_448340216.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_448340216;
            // ---------- Original Method ----------
            //return body;
        }

        
    }


    
    private static final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

        private String uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "67BE67CEB267E81A180EF0F50CE7A39E", hash_generated_field = "9921329941711204154BA08BDD062296")

        private RawHeaders varyHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "A39C78373BFA23C94B68F682C465FA3F", hash_generated_field = "9625A54A79CF15AD33875352608C66CF")

        private String requestMethod;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "D6576EAE015D49809D4E175A8DFA3DA7")

        private RawHeaders responseHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

        private String cipherSuite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "DC3CF2AC26AC99678179A5F131C32E62")

        private Certificate[] peerCertificates;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.330 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "028084B73B654EF656F50BBE0F184A93")

        private Certificate[] localCertificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.337 -0400", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "52C2DC926C05081ED2B388249E8D065C")
        public  Entry(InputStream in) throws IOException {
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
                    boolean varFFA211E0A88DB8D3D1C49D50249DE024_39184275 = (isHttps());
                    {
                        String blank;
                        blank = Streams.readAsciiLine(in);
                        {
                            boolean varE57DC7EEFAD90FA932B591041168097D_1838019126 = (!blank.isEmpty());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.348 -0400", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "C5EADC3021A3B1E891108CA3BAEB9CD4")
        public  Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());
            {
                boolean varFCAD955B043A900B307875922675107D_1187461775 = (isHttps());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.349 -0400", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "2DABEDF8A4D9DEC1071D84A6E666E08E")
        public void writeTo(DiskLruCache.Editor editor) throws IOException {
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
                boolean var91F436A92F4865E1C76BC6FEB9045E64_1123702618 = (i < varyHeaders.length());
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
                boolean varCD2269726C173194777BF60852BC28C6_1515188340 = (i < responseHeaders.length());
                {
                    writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFCAD955B043A900B307875922675107D_791673797 = (isHttps());
                {
                    writer.write('\n');
                    writer.write(cipherSuite + '\n');
                    writeCertArray(writer, peerCertificates);
                    writeCertArray(writer, localCertificates);
                } //End block
            } //End collapsed parenthetic
            writer.close();
            addTaint(editor.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.349 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "E63C6A48947C66B20BA7E05CBE41E089")
        private boolean isHttps() {
            boolean varFF3DAACE38DA6F1DB496E4B7E3303BBB_1644578414 = (uri.startsWith("https://"));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281327572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281327572;
            // ---------- Original Method ----------
            //return uri.startsWith("https://");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.353 -0400", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "8D9E0CA1093D492B6C411ADF0834E802")
        private int readInt(InputStream in) throws IOException {
            String intString;
            intString = Streams.readAsciiLine(in);
            try 
            {
                int varABA47AA6CC39041115500328692BECDF_335625862 = (Integer.parseInt(intString));
            } //End block
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("expected an int but was \"" + intString + "\"");
            } //End block
            addTaint(in.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070368796 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070368796;
            // ---------- Original Method ----------
            //String intString = Streams.readAsciiLine(in);
            //try {
                //return Integer.parseInt(intString);
            //} catch (NumberFormatException e) {
                //throw new IOException("expected an int but was \"" + intString + "\"");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.354 -0400", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "001033676FDB93DAD652382800A611BB")
        private Certificate[] readCertArray(InputStream in) throws IOException {
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2107133518 = null; //Variable for return #1
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1631517261 = null; //Variable for return #2
            int length;
            length = readInt(in);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2107133518 = null;
            } //End block
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
                varB4EAC82CA7396A68D541C85D26508E83_1631517261 = result;
            } //End block
            catch (CertificateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } //End block
            addTaint(in.getTaint());
            Certificate[] varA7E53CE21691AB073D9660D615818899_1855860312; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1855860312 = varB4EAC82CA7396A68D541C85D26508E83_2107133518;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1855860312 = varB4EAC82CA7396A68D541C85D26508E83_1631517261;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1855860312.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1855860312;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.457 -0400", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "64DD978A74C693FC3C536C2666AB89FF")
        private void writeCertArray(Writer writer, Certificate[] certificates) throws IOException {
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
            addTaint(writer.getTaint());
            addTaint(certificates[0].getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.458 -0400", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "963D8C46308B3C554090F26AE35BF733")
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            boolean varE71B126F6436F11D7B0403FF7EAFCF2C_1647489622 = (this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders));
            addTaint(uri.getTaint());
            addTaint(requestMethod.getTaint());
            addTaint(requestHeaders.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061269741 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061269741;
            // ---------- Original Method ----------
            //return this.uri.equals(uri.toString())
                    //&& this.requestMethod.equals(requestMethod)
                    //&& new ResponseHeaders(uri, responseHeaders)
                            //.varyMatches(varyHeaders.toMultimap(), requestHeaders);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.473 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "AC53860D5B69415719091DD347FA79C7")
        public CacheResponse newCacheResponse(final InputStream in) {
            CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1867911524 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1867911524 = new CacheResponse() {
                @Override public Map<String, List<String>> getHeaders() {
                    return responseHeaders.toMultimap();
                }
                @Override public InputStream getBody() {
                    return in;
                }
            };
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1867911524.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1867911524;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.474 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "E900B89E9123149EEB7F2EB4D389BC75")
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_1071054657 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1071054657 = new SecureCacheResponse() {
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
            varB4EAC82CA7396A68D541C85D26508E83_1071054657.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1071054657;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.474 -0400", hash_original_field = "FBC64DE7E28C29FA7A0D298DC4B80EE9", hash_generated_field = "486EB5B3E3205E6879EA7661BA0683BC")

    private static int VERSION = 201105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.474 -0400", hash_original_field = "4A75CD08A654B4D8DD3837B3EC053D66", hash_generated_field = "A274E44E5D2CB130ABF5BC3A099EC289")

    private static int ENTRY_METADATA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.474 -0400", hash_original_field = "FAC54FABB55F801B93D21B8EE66068DC", hash_generated_field = "B2A93A499CFEE4B42D55D59BFF5C05AA")

    private static int ENTRY_BODY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.474 -0400", hash_original_field = "F9DF2C58097C8A433569D632FFA49D34", hash_generated_field = "FEE6FEA6BA8B19F17305CAA6B276B3D8")

    private static int ENTRY_COUNT = 2;
}

