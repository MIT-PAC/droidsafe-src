package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.122 -0500", hash_original_field = "9F0359D8E3DE91D67F47C405F85D1EB0", hash_generated_field = "9B09D8AD9E5D9CB9C068F9CC40FB0395")

    private static final int VERSION = 201105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.123 -0500", hash_original_field = "4E6649A2D61ACC7F02FDD89093A80458", hash_generated_field = "0776A45C3DD1FFCE8D2D96E47CC39786")

    private static final int ENTRY_METADATA = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.124 -0500", hash_original_field = "A31A43445536400BAA58A762C8F9F023", hash_generated_field = "E5113D1AEC335048014C4BFA2995DB52")

    private static final int ENTRY_BODY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.124 -0500", hash_original_field = "DB77CF8E805D5A065837BA090D85B088", hash_generated_field = "3E63766656FB84DF97D5F150C04CFF24")

    private static final int ENTRY_COUNT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.125 -0500", hash_original_field = "49D67DE5BA2EAC224ECEF2E34936724A", hash_generated_field = "8D7B3AC911505868AEA4010DF26181F8")


    private  DiskLruCache cache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.126 -0500", hash_original_field = "C96DD4DFC6FCD5D3BE844C1B2EF8E179", hash_generated_field = "9451CF6EB93EE29D841188FD01582E44")

    private int writeSuccessCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.127 -0500", hash_original_field = "46FD32402B421AF955FD46B58F767FF0", hash_generated_field = "BF027D0731613DD6EDBF7FD99E17F8D6")

    private int writeAbortCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.127 -0500", hash_original_field = "3A714BD2A34591CAB27092122C84C6DD", hash_generated_field = "843970BEE5BFFD7AF4318A1DF280F033")

    private int networkCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.128 -0500", hash_original_field = "FCE59D97ECFE49E968FF90BAA339A9B5", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.129 -0500", hash_original_field = "BFF07A908239E29F2F6DA6DAF7C6AD93", hash_generated_field = "AE786DEC353802DA8366A92F7929343E")

    private int requestCount;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.130 -0500", hash_original_method = "78B20D695A86E0233974CD78CD9B40DF", hash_generated_method = "53915B2158784854E6998AE30FE4A774")
    public HttpResponseCache(File directory, long maxSize) throws IOException {
        cache = DiskLruCache.open(directory, VERSION, ENTRY_COUNT, maxSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.131 -0500", hash_original_method = "BDF5FA5DFC6F094E24DB34D390FA0AF5", hash_generated_method = "F8FEF1780A1A30BD5E9D4D030C51781E")
    private String uriToKey(URI uri) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes = messageDigest.digest(uri.toString().getBytes(Charsets.UTF_8));
            return IntegralToString.bytesToHexString(md5bytes, false);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.132 -0500", hash_original_method = "26BABC03D3AA785CC6E3BF7FEFF80D9A", hash_generated_method = "E88D9207566CBF75AB04A3BE03A72DA7")
    @Override
public CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) {
        String key = uriToKey(uri);
        DiskLruCache.Snapshot snapshot;
        Entry entry;
        try {
            snapshot = cache.get(key);
            if (snapshot == null) {
                return null;
            }
            entry = new Entry(new BufferedInputStream(snapshot.getInputStream(ENTRY_METADATA)));
        } catch (IOException e) {
            // Give up because the cache cannot be read.
            return null;
        }

        if (!entry.matches(uri, requestMethod, requestHeaders)) {
            snapshot.close();
            return null;
        }

        InputStream body = newBodyInputStream(snapshot);
        return entry.isHttps()
                ? entry.newSecureCacheResponse(body)
                : entry.newCacheResponse(body);
    }

    /**
     * Returns an input stream that reads the body of a snapshot, closing the
     * snapshot when the stream is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.134 -0500", hash_original_method = "414C2C76D37A8FDF2E21B69DEB8F21E6", hash_generated_method = "ABD8366C804D8001A789AF5FFF8CCEA0")
    private InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        return new FilterInputStream(snapshot.getInputStream(ENTRY_BODY)) {
            @Override public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.135 -0500", hash_original_method = "B60E0E98B4938597A03FCCE829FCA215", hash_generated_method = "474B591080D71567BD1C0B864AC4D34C")
    @Override
public CacheRequest put(URI uri, URLConnection urlConnection) throws IOException {
        if (!(urlConnection instanceof HttpURLConnection)) {
            return null;
        }

        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        String requestMethod = httpConnection.getRequestMethod();
        String key = uriToKey(uri);

        if (requestMethod.equals(HttpEngine.POST)
                || requestMethod.equals(HttpEngine.PUT)
                || requestMethod.equals(HttpEngine.DELETE)) {
            try {
                cache.remove(key);
            } catch (IOException ignored) {
                // The cache cannot be written.
            }
            return null;
        } else if (!requestMethod.equals(HttpEngine.GET)) {
            /*
             * Don't cache non-GET responses. We're technically allowed to cache
             * HEAD requests and some POST requests, but the complexity of doing
             * so is high and the benefit is low.
             */
            return null;
        }

        HttpEngine httpEngine = getHttpEngine(httpConnection);
        if (httpEngine == null) {
            // Don't cache unless the HTTP implementation is ours.
            return null;
        }

        ResponseHeaders response = httpEngine.getResponseHeaders();
        if (response.hasVaryAll()) {
            return null;
        }

        RawHeaders varyHeaders = httpEngine.getRequestHeaders().getHeaders().getAll(
                response.getVaryFields());
        Entry entry = new Entry(uri, varyHeaders, httpConnection);
        DiskLruCache.Editor editor = null;
        try {
            editor = cache.edit(key);
            if (editor == null) {
                return null;
            }
            entry.writeTo(editor);
            return new CacheRequestImpl(editor);
        } catch (IOException e) {
            // Give up because the cache cannot be written.
            try {
                if (editor != null) {
                    editor.abort();
                }
            } catch (IOException ignored) {
            }
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.137 -0500", hash_original_method = "E894667736427F176108888DBBB58A41", hash_generated_method = "EF73783845FFA882FA9F24063E71D0F5")
    private HttpEngine getHttpEngine(HttpURLConnection httpConnection) {
        if (httpConnection instanceof HttpURLConnectionImpl) {
            return ((HttpURLConnectionImpl) httpConnection).getHttpEngine();
        } else if (httpConnection instanceof HttpsURLConnectionImpl) {
            return ((HttpsURLConnectionImpl) httpConnection).getHttpEngine();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.137 -0500", hash_original_method = "B64C7BD7AB99F4603E597D8D8E01D294", hash_generated_method = "B71168C0D1FFFA2A0AB347FEF4EAAF8C")
    public DiskLruCache getCache() {
        return cache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.138 -0500", hash_original_method = "584B91EB5EE577F8A207E65218FB5240", hash_generated_method = "464AE523866156241CDE77CBA382AD77")
    public synchronized int getWriteAbortCount() {
        return writeAbortCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.139 -0500", hash_original_method = "2EA3BABAF279B90BEBA0727537DCC414", hash_generated_method = "4548DD5E9C5C682C61AEA3D6E5E9FA18")
    public synchronized int getWriteSuccessCount() {
        return writeSuccessCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.140 -0500", hash_original_method = "AFAC31322E1EE7F2799E824F8557136B", hash_generated_method = "B0DF93595E815F8FA6AB786C973F786A")
    synchronized void trackResponse(ResponseSource source) {
        requestCount++;

        switch (source) {
        case CACHE:
            hitCount++;
            break;
        case CONDITIONAL_CACHE:
        case NETWORK:
            networkCount++;
            break;
        }
    }

    
    private final class CacheRequestImpl extends CacheRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.144 -0500", hash_original_field = "217E4FF58E41077ED09A02E8DA387876", hash_generated_field = "473D8A10E05573BC7984E247163C640F")

        private  DiskLruCache.Editor editor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.145 -0500", hash_original_field = "2E3E93D03996B24E70AFD66CEA4EEACF", hash_generated_field = "008F5B15E9C0FBDACB4EED71187C2B4B")

        private OutputStream cacheOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.146 -0500", hash_original_field = "7DD4CED3516314F52669BF0DB39881AD", hash_generated_field = "0304A61A6DDC786F4BE08C5BF9CC08ED")

        private boolean done;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.147 -0500", hash_original_field = "9092B2A589A017E1C33F2C03FA917CA1", hash_generated_field = "B6D92F04843314CDB3A472363E834E04")

        private OutputStream body;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.149 -0500", hash_original_method = "E76640CD2FBCF56B6170776BBFFF9C65", hash_generated_method = "469D40A263A7780CAB0F173CAF6A1638")
        public CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(ENTRY_BODY);
            this.body = new FilterOutputStream(cacheOut) {
                @Override public void close() throws IOException {
                    synchronized (HttpResponseCache.this) {
                        if (done) {
                            return;
                        }
                        done = true;
                        writeSuccessCount++;
                    }
                    super.close();
                    editor.commit();
                }
            };
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.150 -0500", hash_original_method = "7827E040DB0396BA4CFDC9AA4B955B16", hash_generated_method = "4AAD3A253FA520A2060037E5D77035F7")
        @Override
public void abort() {
            synchronized (HttpResponseCache.this) {
                if (done) {
                    return;
                }
                done = true;
                writeAbortCount++;
            }
            IoUtils.closeQuietly(cacheOut);
            try {
                editor.abort();
            } catch (IOException ignored) {
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.150 -0500", hash_original_method = "CD115A1F543477A8E0342CED7BC41A18", hash_generated_method = "9F6AED861DB54D99AEC6C1569F545119")
        @Override
public OutputStream getBody() throws IOException {
            return body;
        }

        
    }


    
    private static final class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.152 -0500", hash_original_field = "EDEBE52DCF191A03299D02F6C51FE39B", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

        private  String uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.153 -0500", hash_original_field = "4256C0DA81CB3CD914F34222AE1FBD79", hash_generated_field = "9921329941711204154BA08BDD062296")

        private  RawHeaders varyHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.154 -0500", hash_original_field = "A775E0084465294DEDE05BD2DE5F86DA", hash_generated_field = "9625A54A79CF15AD33875352608C66CF")

        private  String requestMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.155 -0500", hash_original_field = "9C87E36C22B82EAAC8ABBDF951A3EE05", hash_generated_field = "D6576EAE015D49809D4E175A8DFA3DA7")

        private  RawHeaders responseHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.156 -0500", hash_original_field = "29E2AAA661609AB9806905F1C2C48A95", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

        private  String cipherSuite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.157 -0500", hash_original_field = "908A89473A21BF631FD9D04AAD1AACDB", hash_generated_field = "DC3CF2AC26AC99678179A5F131C32E62")

        private  Certificate[] peerCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.158 -0500", hash_original_field = "3A7B682AC8086BFBEA5D87E52DC843D4", hash_generated_field = "028084B73B654EF656F50BBE0F184A93")

        private  Certificate[] localCertificates;

        /*
         * Reads an entry from an input stream. A typical entry looks like this:
         *   http://google.com/foo
         *   GET
         *   2
         *   Accept-Language: fr-CA
         *   Accept-Charset: UTF-8
         *   HTTP/1.1 200 OK
         *   3
         *   Content-Type: image/png
         *   Content-Length: 100
         *   Cache-Control: max-age=600
         *
         * A typical HTTPS file looks like this:
         *   https://google.com/foo
         *   GET
         *   2
         *   Accept-Language: fr-CA
         *   Accept-Charset: UTF-8
         *   HTTP/1.1 200 OK
         *   3
         *   Content-Type: image/png
         *   Content-Length: 100
         *   Cache-Control: max-age=600
         *
         *   AES_256_WITH_MD5
         *   2
         *   base64-encoded peerCertificate[0]
         *   base64-encoded peerCertificate[1]
         *   -1
         *
         * The file is newline separated. The first two lines are the URL and
         * the request method. Next is the number of HTTP Vary request header
         * lines, followed by those lines.
         *
         * Next is the response status line, followed by the number of HTTP
         * response header lines, followed by those lines.
         *
         * HTTPS responses also contain SSL session information. This begins
         * with a blank line, and then a line containing the cipher suite. Next
         * is the length of the peer certificate chain. These certificates are
         * base64-encoded and appear each on their own line. The next line
         * contains the length of the local certificate chain. These
         * certificates are also base64-encoded and appear each on their own
         * line. A length of -1 is used to encode a null array.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.159 -0500", hash_original_method = "A32E30241E6AE79BFF18585A7D22913C", hash_generated_method = "BD4A3D3D27FAF303EC1EF6CD426AF1BF")
        public Entry(InputStream in) throws IOException {
            try {
                uri = Streams.readAsciiLine(in);
                requestMethod = Streams.readAsciiLine(in);
                varyHeaders = new RawHeaders();
                int varyRequestHeaderLineCount = readInt(in);
                for (int i = 0; i < varyRequestHeaderLineCount; i++) {
                    varyHeaders.addLine(Streams.readAsciiLine(in));
                }

                responseHeaders = new RawHeaders();
                responseHeaders.setStatusLine(Streams.readAsciiLine(in));
                int responseHeaderLineCount = readInt(in);
                for (int i = 0; i < responseHeaderLineCount; i++) {
                    responseHeaders.addLine(Streams.readAsciiLine(in));
                }

                if (isHttps()) {
                    String blank = Streams.readAsciiLine(in);
                    if (!blank.isEmpty()) {
                        throw new IOException("expected \"\" but was \"" + blank + "\"");
                    }
                    cipherSuite = Streams.readAsciiLine(in);
                    peerCertificates = readCertArray(in);
                    localCertificates = readCertArray(in);
                } else {
                    cipherSuite = null;
                    peerCertificates = null;
                    localCertificates = null;
                }
            } finally {
                in.close();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.160 -0500", hash_original_method = "2730B752BE7E47C2A79E3158A4A5E3C1", hash_generated_method = "E04DAAB752F506DDEC538902A6FBECFE")
        public Entry(URI uri, RawHeaders varyHeaders, HttpURLConnection httpConnection) {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpConnection.getHeaderFields());

            if (isHttps()) {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) httpConnection;
                cipherSuite = httpsConnection.getCipherSuite();
                Certificate[] peerCertificatesNonFinal = null;
                try {
                    peerCertificatesNonFinal = httpsConnection.getServerCertificates();
                } catch (SSLPeerUnverifiedException ignored) {
                }
                peerCertificates = peerCertificatesNonFinal;
                localCertificates = httpsConnection.getLocalCertificates();
            } else {
                cipherSuite = null;
                peerCertificates = null;
                localCertificates = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.162 -0500", hash_original_method = "88789BC2C1CD5F8123BF851F02A01A0B", hash_generated_method = "1389148B9B236F5FB05D0534320F51AC")
        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            OutputStream out = editor.newOutputStream(0);
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.UTF_8));

            writer.write(uri + '\n');
            writer.write(requestMethod + '\n');
            writer.write(Integer.toString(varyHeaders.length()) + '\n');
            for (int i = 0; i < varyHeaders.length(); i++) {
                writer.write(varyHeaders.getFieldName(i) + ": "
                        + varyHeaders.getValue(i) + '\n');
            }

            writer.write(responseHeaders.getStatusLine() + '\n');
            writer.write(Integer.toString(responseHeaders.length()) + '\n');
            for (int i = 0; i < responseHeaders.length(); i++) {
                writer.write(responseHeaders.getFieldName(i) + ": "
                        + responseHeaders.getValue(i) + '\n');
            }

            if (isHttps()) {
                writer.write('\n');
                writer.write(cipherSuite + '\n');
                writeCertArray(writer, peerCertificates);
                writeCertArray(writer, localCertificates);
            }
            writer.close();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.410 -0400", hash_original_method = "03191EC96D9A5CD24E720BDBCBE04A2D", hash_generated_method = "783E1F184BA0D6307BCB01A56B82F777")
        private boolean isHttps() {
            boolean var84590F99892941EEBA41F98A1FDD816B_1813402239 = (uri.startsWith("https://"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422600803 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_422600803;
            // ---------- Original Method ----------
            //return uri.startsWith("https://");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.163 -0500", hash_original_method = "6902188738A592ACC936EB175BFF523B", hash_generated_method = "901B22E9287AD4DEA2B2BF3315E3BDF3")
        private int readInt(InputStream in) throws IOException {
            String intString = Streams.readAsciiLine(in);
            try {
                return Integer.parseInt(intString);
            } catch (NumberFormatException e) {
                throw new IOException("expected an int but was \"" + intString + "\"");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.164 -0500", hash_original_method = "DA1C299BAC85411132B971A655DE52AC", hash_generated_method = "AEF488670CC8F9B35CB962389B87C98A")
        private Certificate[] readCertArray(InputStream in) throws IOException {
            int length = readInt(in);
            if (length == -1) {
                return null;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                Certificate[] result = new Certificate[length];
                for (int i = 0; i < result.length; i++) {
                    String line = Streams.readAsciiLine(in);
                    byte[] bytes = Base64.decode(line.getBytes(Charsets.US_ASCII));
                    result[i] = certificateFactory.generateCertificate(
                            new ByteArrayInputStream(bytes));
                }
                return result;
            } catch (CertificateException e) {
                throw new IOException(e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.165 -0500", hash_original_method = "31A77F7FE4035FAC2C12BBD4DA149ECB", hash_generated_method = "36DDE423BF7D87B2238AB9690C3BCAD7")
        private void writeCertArray(Writer writer, Certificate[] certificates) throws IOException {
            if (certificates == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificates.length) + '\n');
                for (Certificate certificate : certificates) {
                    byte[] bytes = certificate.getEncoded();
                    String line = Base64.encode(bytes);
                    writer.write(line + '\n');
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.166 -0500", hash_original_method = "2AD3F915E507834605A6A4131E76D62C", hash_generated_method = "70C6D0AFC1365F27BA2E31C2607D6BF3")
        public boolean matches(URI uri, String requestMethod,
                Map<String, List<String>> requestHeaders) {
            return this.uri.equals(uri.toString())
                    && this.requestMethod.equals(requestMethod)
                    && new ResponseHeaders(uri, responseHeaders)
                            .varyMatches(varyHeaders.toMultimap(), requestHeaders);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.414 -0400", hash_original_method = "89EB7BC0F9D5CDAB04210B055A77E99D", hash_generated_method = "8247E092C8F51A634726D31341AA8AE2")
        public CacheResponse newCacheResponse(final InputStream in) {
            addTaint(in.getTaint());
CacheResponse var290A606B2E179EF78FC04FCFE9A15A2D_753268352 =             new CacheResponse() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.171 -0500", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "8EE9ADE3AD26CD9859B7DFAB3D8AC29D")
                @Override
public Map<String, List<String>> getHeaders() {
                    return responseHeaders.toMultimap();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.172 -0500", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "782D0F7A2F5D37CC0FA034F1F99CB5A7")
                @Override
public InputStream getBody() {
                    return in;
                }
};
            var290A606B2E179EF78FC04FCFE9A15A2D_753268352.addTaint(taint);
            return var290A606B2E179EF78FC04FCFE9A15A2D_753268352;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.417 -0400", hash_original_method = "C9B15DB0F46F05D49B15F04525C28EC8", hash_generated_method = "FBCA15F19E431977CCDD32E59F049B8F")
        public SecureCacheResponse newSecureCacheResponse(final InputStream in) {
            addTaint(in.getTaint());
SecureCacheResponse varD331870BD359303242F080E81225CD8A_1476178398 =             new SecureCacheResponse() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.415 -0400", hash_original_method = "F3D6D63EF6EDB1F47E90FFCB800C4AA9", hash_generated_method = "EA2519FBD5AE25689A1D37A4916962BB")
            @Override
            public Map<String, List<String>> getHeaders() {
Map<String, List<String>> var0919DB83F382E960ABF31AD5831D30F0_1346796912 =                 responseHeaders.toMultimap();
                var0919DB83F382E960ABF31AD5831D30F0_1346796912.addTaint(taint);
                return var0919DB83F382E960ABF31AD5831D30F0_1346796912;
                // ---------- Original Method ----------
                //return responseHeaders.toMultimap();
            }
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.416 -0400", hash_original_method = "6B131586E425295B4C3DC3AE43124EB2", hash_generated_method = "E0EC3166B0280ABC71C86E6E3C87F45B")
            @Override
            public InputStream getBody() {
InputStream var091D3B9C0C9CE73F019D8ED2F738F1B8_1152990868 =                 in;
                var091D3B9C0C9CE73F019D8ED2F738F1B8_1152990868.addTaint(taint);
                return var091D3B9C0C9CE73F019D8ED2F738F1B8_1152990868;
                // ---------- Original Method ----------
                //return in;
            }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.173 -0500", hash_original_method = "D670C2680AE46E78B21CAD2B9515E8E7", hash_generated_method = "0696E00D24C597F9F0FC1307CFCF2D14")
                @Override
public String getCipherSuite() {
                    return cipherSuite;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.174 -0500", hash_original_method = "31D74A5EDE84A239E816669DB515C06E", hash_generated_method = "6FCF883C7CC3DF42ECFE86CEA445A33B")
                @Override
public List<Certificate> getServerCertificateChain()
                        throws SSLPeerUnverifiedException {
                    if (peerCertificates == null || peerCertificates.length == 0) {
                        throw new SSLPeerUnverifiedException(null);
                    }
                    return Arrays.asList(peerCertificates.clone());
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.175 -0500", hash_original_method = "B0F4ED14395510FBFE1098A8134CF356", hash_generated_method = "0948844402EFD3967A2133480D5A5C98")
                @Override
public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                    if (peerCertificates == null || peerCertificates.length == 0) {
                        throw new SSLPeerUnverifiedException(null);
                    }
                    return ((X509Certificate) peerCertificates[0]).getSubjectX500Principal();
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.176 -0500", hash_original_method = "88CD48CB7FE6E4F8F5378B409F5088BC", hash_generated_method = "672EFB659B963C26A1B0FEF7B653AF97")
                @Override
public List<Certificate> getLocalCertificateChain() {
                    if (localCertificates == null || localCertificates.length == 0) {
                        return null;
                    }
                    return Arrays.asList(localCertificates.clone());
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.177 -0500", hash_original_method = "0108FA4D241BF83AF9A8889A5D800085", hash_generated_method = "86A5E3370408239BE4E128BFF4BAB17E")
                @Override
public Principal getLocalPrincipal() {
                    if (localCertificates == null || localCertificates.length == 0) {
                        return null;
                    }
                    return ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
                }
};
            varD331870BD359303242F080E81225CD8A_1476178398.addTaint(taint);
            return varD331870BD359303242F080E81225CD8A_1476178398;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.141 -0500", hash_original_method = "456F1C16A4D586B3084074761F46B903", hash_generated_method = "5B7AF2711F3524860C7F52A4D5B2C284")
    synchronized void trackConditionalCacheHit() {
        hitCount++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.142 -0500", hash_original_method = "43B20B4C5A2152AB1A746223212EFB79", hash_generated_method = "8555AD1B3A837873B87588848BAAA34C")
    public synchronized int getNetworkCount() {
        return networkCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.143 -0500", hash_original_method = "F60E9424D0F277AC3F88D95186713E51", hash_generated_method = "850EFA35F88F6E7D89035D8A2E21ECF7")
    public synchronized int getHitCount() {
        return hitCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.143 -0500", hash_original_method = "B572A7BCEFA26365FDB2542BDB35291E", hash_generated_method = "768BCD7B9C7F97077EFAFA80CD55A9CE")
    public synchronized int getRequestCount() {
        return requestCount;
    }
}

