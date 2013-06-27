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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.104 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "8D7B3AC911505868AEA4010DF26181F8")

    private DiskLruCache cache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.104 -0400", hash_original_field = "11679E351AB2CDD5977DCC10C5E3BDA9", hash_generated_field = "9451CF6EB93EE29D841188FD01582E44")

    private int writeSuccessCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.105 -0400", hash_original_field = "4CFEE5DDB5A666111EBCE2224B5C204B", hash_generated_field = "BF027D0731613DD6EDBF7FD99E17F8D6")

    private int writeAbortCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.105 -0400", hash_original_field = "3D06ECB00548A4CD4B10D3412F2AB801", hash_generated_field = "843970BEE5BFFD7AF4318A1DF280F033")

    private int networkCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.105 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.105 -0400", hash_original_field = "27F327C12CD3EA7E5A5835FCAE116C07", hash_generated_field = "AE786DEC353802DA8366A92F7929343E")

    private int requestCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.122 -0400", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "7114ADEC0E2E2766A6128D85A9988C45")
    public  HttpResponseCache(File directory, long maxSize) throws IOException {
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
        // ---------- Original Method ----------
        //cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.123 -0400", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "58F023E4D878087542CF7564301D08AA")
    private String uriToKey(URI uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_608636102 = null; //Variable for return #1
        try 
        {
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes;
            md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            varB4EAC82CA7396A68D541C85D26508E83_608636102 = IntegralToString.bytesToHexString(md5bytes, false);
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_608636102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_608636102;
        // ---------- Original Method ----------
        //try {
            //MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            //return IntegralToString.bytesToHexString(md5bytes, false);
        //} catch (NoSuchAlgorithmException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.125 -0400", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "534167E247F38D9708AC670CA375DCD4")
    @Override
    public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_599373040 = null; //Variable for return #1
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1335674966 = null; //Variable for return #2
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1582507863 = null; //Variable for return #3
        CacheResponse varB4EAC82CA7396A68D541C85D26508E83_1798446681 = null; //Variable for return #4
        String key;
        key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try 
        {
            snapshot = cache.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_599373040 = null;
            } //End block
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1335674966 = null;
        } //End block
        {
            boolean var7D158C8C8D146A47EF280B1AAB085822_1745123904 = (!entry.matches(uri, requestMethod, requestHeaders));
            {
                snapshot.close();
                varB4EAC82CA7396A68D541C85D26508E83_1582507863 = null;
            } //End block
        } //End collapsed parenthetic
        InputStream body;
        body = newBodyInputStream(snapshot);
        varB4EAC82CA7396A68D541C85D26508E83_1798446681 = entry.isHttps()
                ? entry.newSecureCacheResponse(body)
                : entry.newCacheResponse(body);
        addTaint(uri.getTaint());
        addTaint(requestMethod.getTaint());
        addTaint(requestHeaders.getTaint());
        CacheResponse varA7E53CE21691AB073D9660D615818899_1363234910; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1363234910 = varB4EAC82CA7396A68D541C85D26508E83_599373040;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1363234910 = varB4EAC82CA7396A68D541C85D26508E83_1335674966;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1363234910 = varB4EAC82CA7396A68D541C85D26508E83_1582507863;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1363234910 = varB4EAC82CA7396A68D541C85D26508E83_1798446681;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1363234910.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1363234910;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.133 -0400", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "BADA2AD152ED9185AC1BF1B062E31A49")
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1788169229 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1788169229 = new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            @Override public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
        addTaint(snapshot.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1788169229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1788169229;
        // ---------- Original Method ----------
        //return new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            //@Override public void close() throws IOException {
                //snapshot.close();
                //super.close();
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.150 -0400", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "FAEA0F0F58ACC4F7754B543368698021")
    @Override
    public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_447444966 = null; //Variable for return #1
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_839770411 = null; //Variable for return #2
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1136618539 = null; //Variable for return #3
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_1207568138 = null; //Variable for return #4
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_354858876 = null; //Variable for return #5
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_797310858 = null; //Variable for return #6
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_727927447 = null; //Variable for return #7
        CacheRequest varB4EAC82CA7396A68D541C85D26508E83_539560899 = null; //Variable for return #8
        {
            varB4EAC82CA7396A68D541C85D26508E83_447444966 = null;
        } //End block
        HttpURLConnection httpConnection;
        httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod;
        requestMethod = httpConnection.getRequestMethod();
        String key;
        key = uriToKey(uri);
        {
            boolean var0B2F5AEE4A5D54E8FD8E2859428117D5_331050071 = (requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE));
            {
                try 
                {
                    cache.remove(key);
                } //End block
                catch (IOException ignored)
                { }
                varB4EAC82CA7396A68D541C85D26508E83_839770411 = null;
            } //End block
            {
                boolean varF71487804C2D751E21461994C2134753_181888831 = (!requestMethod.equals(HttpEngine.GET));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1136618539 = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        HttpEngine httpEngine;
        httpEngine = getHttpEngine(httpConnection);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1207568138 = null;
        } //End block
        ResponseHeaders response;
        response = httpEngine.getResponseHeaders();
        {
            boolean varD01FB646ABB2F9C328677DB0F2848406_313818985 = (response.hasVaryAll());
            {
                varB4EAC82CA7396A68D541C85D26508E83_354858876 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_797310858 = null;
            } //End block
            entry.writeTo(editor);
            varB4EAC82CA7396A68D541C85D26508E83_727927447 = new CacheRequestImpl(editor);
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
            varB4EAC82CA7396A68D541C85D26508E83_539560899 = null;
        } //End block
        addTaint(uri.getTaint());
        addTaint(urlConnection.getTaint());
        CacheRequest varA7E53CE21691AB073D9660D615818899_280994776; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_447444966;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_839770411;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_1136618539;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_1207568138;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_354858876;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_797310858;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_727927447;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_280994776 = varB4EAC82CA7396A68D541C85D26508E83_539560899;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_280994776.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_280994776;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.151 -0400", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "FC490453BCFA68F918EFBC28206C9FBD")
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_422704375 = null; //Variable for return #1
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_1411113995 = null; //Variable for return #2
        HttpEngine varB4EAC82CA7396A68D541C85D26508E83_655918050 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_422704375 = ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1411113995 = ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_655918050 = null;
        } //End block
        addTaint(httpConnection.getTaint());
        HttpEngine varA7E53CE21691AB073D9660D615818899_263074326; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_263074326 = varB4EAC82CA7396A68D541C85D26508E83_422704375;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_263074326 = varB4EAC82CA7396A68D541C85D26508E83_1411113995;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_263074326 = varB4EAC82CA7396A68D541C85D26508E83_655918050;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_263074326.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_263074326;
        // ---------- Original Method ----------
        //if (httpConnection instanceof HttpURLConnectionImpl) {
            //return ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        //} else if (httpConnection instanceof HttpsURLConnectionImpl) {
            //return ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.152 -0400", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "596255585EE30A2076F6C496F4BEAAE9")
    public DiskLruCache getCache() {
        DiskLruCache varB4EAC82CA7396A68D541C85D26508E83_38450508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_38450508 = cache;
        varB4EAC82CA7396A68D541C85D26508E83_38450508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_38450508;
        // ---------- Original Method ----------
        //return cache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.152 -0400", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "7936DAC68F90BC0879FDE562F489ADE9")
    public synchronized int getWriteAbortCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960861827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960861827;
        // ---------- Original Method ----------
        //return writeAbortCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.171 -0400", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "AF5F9D2D729E3FA49C1227949826A67D")
    public synchronized int getWriteSuccessCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616501651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616501651;
        // ---------- Original Method ----------
        //return writeSuccessCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.172 -0400", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "350AC598482D79400E158FBCCA1F2AE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.172 -0400", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "2CBB05F2719F07329394083BF14747F7")
    synchronized void trackConditionalCacheHit() {
        // ---------- Original Method ----------
        //hitCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.172 -0400", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "7CC900F6671BD3608182A916F998A2DC")
    public synchronized int getNetworkCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390002330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390002330;
        // ---------- Original Method ----------
        //return networkCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.172 -0400", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "52F7FEA33FCD3A1241F8D6FC3C38029E")
    public synchronized int getHitCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60624561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60624561;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.173 -0400", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "A5CBB834B3E3365BB2159D40CCD152F0")
    public synchronized int getRequestCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247452938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247452938;
        // ---------- Original Method ----------
        //return requestCount;
    }

    
    private final class CacheRequestImpl extends CacheRequest {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.173 -0400", hash_original_field = "5AEE9DBD2A188839105073571BEE1B1F", hash_generated_field = "473D8A10E05573BC7984E247163C640F")

        private DiskLruCache.Editor editor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.173 -0400", hash_original_field = "233DAC44E1A87E581FCE48B9E49D555B", hash_generated_field = "008F5B15E9C0FBDACB4EED71187C2B4B")

        private OutputStream cacheOut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.173 -0400", hash_original_field = "6B2DED51D81A4403D8A4BD25FA1E57EE", hash_generated_field = "0304A61A6DDC786F4BE08C5BF9CC08ED")

        private boolean done;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.173 -0400", hash_original_field = "841A2D689AD86BD1611447453C22C6FC", hash_generated_field = "B6D92F04843314CDB3A472363E834E04")

        private OutputStream body;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.181 -0400", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "DDF69F0BD19E5BF9A68B5CF8FA967716")
        public  CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.181 -0400", hash_original_method = "FD984A0F15EEBC39B69C4BE815EB630F", hash_generated_method = "8B41282BBAB028D94A98051E48A5B84C")
                @Override
                public void close() throws IOException {
                    {
                        Object var74E2887A5956FAB739B88C491C5E3C62_1503604367 = (HttpResponseCache.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.182 -0400", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "E8A570AD86B89A8708F5B64303574923")
        @Override
        public void abort() {
            {
                Object var51C5DD3C3DCDA8C40E73B3B67AC6A541_901519063 = (HttpResponseCache.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.182 -0400", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "074D416FC72BEA512B18FFFC040F0AFA")
        @Override
        public OutputStream getBody() throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_799251071 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_799251071 = body;
            varB4EAC82CA7396A68D541C85D26508E83_799251071.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_799251071;
            // ---------- Original Method ----------
            //return body;
        }

        
    }


    
    private static final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

        private String uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "67BE67CEB267E81A180EF0F50CE7A39E", hash_generated_field = "9921329941711204154BA08BDD062296")

        private RawHeaders varyHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "A39C78373BFA23C94B68F682C465FA3F", hash_generated_field = "9625A54A79CF15AD33875352608C66CF")

        private String requestMethod;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "E70F9E6634E2D14F02C4A4A366D3F40D", hash_generated_field = "D6576EAE015D49809D4E175A8DFA3DA7")

        private RawHeaders responseHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

        private String cipherSuite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "DC3CF2AC26AC99678179A5F131C32E62")

        private Certificate[] peerCertificates;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.199 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "028084B73B654EF656F50BBE0F184A93")

        private Certificate[] localCertificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.201 -0400", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "E04879D28B21F87B18C39CA7CEBF1492")
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
                    boolean varFFA211E0A88DB8D3D1C49D50249DE024_553275789 = (isHttps());
                    {
                        String blank;
                        blank = Streams.readAsciiLine(in);
                        {
                            boolean varE57DC7EEFAD90FA932B591041168097D_1715892776 = (!blank.isEmpty());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.203 -0400", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "9EB914897CC32F531E0FBA786A422C4F")
        public  Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());
            {
                boolean varFCAD955B043A900B307875922675107D_1739806072 = (isHttps());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.208 -0400", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "1C5721AFED1E2457DB5730B96D38A5ED")
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
                boolean var91F436A92F4865E1C76BC6FEB9045E64_1021873768 = (i < varyHeaders.length());
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
                boolean varCD2269726C173194777BF60852BC28C6_1603484089 = (i < responseHeaders.length());
                {
                    writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFCAD955B043A900B307875922675107D_1502339990 = (isHttps());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.209 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "721842763613324093B8B31F8CFD992B")
        private boolean isHttps() {
            boolean varFF3DAACE38DA6F1DB496E4B7E3303BBB_1887953536 = (uri.startsWith("https://"));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977522848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_977522848;
            // ---------- Original Method ----------
            //return uri.startsWith("https://");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.209 -0400", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "632EA870BA02B15CAF946E70E5E91E5A")
        private int readInt(InputStream in) throws IOException {
            String intString;
            intString = Streams.readAsciiLine(in);
            try 
            {
                int varABA47AA6CC39041115500328692BECDF_1751053220 = (Integer.parseInt(intString));
            } //End block
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("expected an int but was \"" + intString + "\"");
            } //End block
            addTaint(in.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012047543 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012047543;
            // ---------- Original Method ----------
            //String intString = Streams.readAsciiLine(in);
            //try {
                //return Integer.parseInt(intString);
            //} catch (NumberFormatException e) {
                //throw new IOException("expected an int but was \"" + intString + "\"");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.210 -0400", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "08923D18D2029D5E6205E210E6CA039D")
        private Certificate[] readCertArray(InputStream in) throws IOException {
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_982935942 = null; //Variable for return #1
            Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1063440608 = null; //Variable for return #2
            int length;
            length = readInt(in);
            {
                varB4EAC82CA7396A68D541C85D26508E83_982935942 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_1063440608 = result;
            } //End block
            catch (CertificateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e);
            } //End block
            addTaint(in.getTaint());
            Certificate[] varA7E53CE21691AB073D9660D615818899_216491205; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_216491205 = varB4EAC82CA7396A68D541C85D26508E83_982935942;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_216491205 = varB4EAC82CA7396A68D541C85D26508E83_1063440608;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_216491205.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_216491205;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.292 -0400", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "64DD978A74C693FC3C536C2666AB89FF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.292 -0400", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "BB735C574A7450B458756F97EA971A75")
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            boolean varE71B126F6436F11D7B0403FF7EAFCF2C_624055243 = (this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders));
            addTaint(uri.getTaint());
            addTaint(requestMethod.getTaint());
            addTaint(requestHeaders.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371324006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_371324006;
            // ---------- Original Method ----------
            //return this.uri.equals(uri.toString())
                    //&& this.requestMethod.equals(requestMethod)
                    //&& new ResponseHeaders(uri, responseHeaders)
                            //.varyMatches(varyHeaders.toMultimap(), requestHeaders);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.293 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "9FCB93EA5C567830041164CF5C09C6C2")
        public CacheResponse newCacheResponse(final InputStream in) {
            CacheResponse varB4EAC82CA7396A68D541C85D26508E83_133001873 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_133001873 = new CacheResponse() {
                @Override public Map<String, List<String>> getHeaders() {
                    return responseHeaders.toMultimap();
                }
                @Override public InputStream getBody() {
                    return in;
                }
            };
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_133001873.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_133001873;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.308 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "7F2E65B6A239AD880378377DA9DE7156")
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            SecureCacheResponse varB4EAC82CA7396A68D541C85D26508E83_1722751025 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1722751025 = new SecureCacheResponse() {
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
            varB4EAC82CA7396A68D541C85D26508E83_1722751025.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1722751025;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.308 -0400", hash_original_field = "FBC64DE7E28C29FA7A0D298DC4B80EE9", hash_generated_field = "486EB5B3E3205E6879EA7661BA0683BC")

    private static int VERSION = 201105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.308 -0400", hash_original_field = "4A75CD08A654B4D8DD3837B3EC053D66", hash_generated_field = "A274E44E5D2CB130ABF5BC3A099EC289")

    private static int ENTRY_METADATA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.308 -0400", hash_original_field = "FAC54FABB55F801B93D21B8EE66068DC", hash_generated_field = "B2A93A499CFEE4B42D55D59BFF5C05AA")

    private static int ENTRY_BODY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.308 -0400", hash_original_field = "F9DF2C58097C8A433569D632FFA49D34", hash_generated_field = "FEE6FEA6BA8B19F17305CAA6B276B3D8")

    private static int ENTRY_COUNT = 2;
}

