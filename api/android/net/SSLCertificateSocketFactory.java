package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.harmony.xnet.provider.jsse.OpenSSLContextImpl;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;

import android.os.SystemProperties;
import android.util.Log;

public class SSLCertificateSocketFactory extends SSLSocketFactory {

    /**
     * Returns a new socket factory instance with an optional handshake timeout.
     *
     * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
     *         for none.  The socket timeout is reset to 0 after the handshake.
     * @return a new SSLSocketFactory with the specified parameters
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.577 -0500", hash_original_method = "9B83296BE05C48282E9011D28DDCB54A", hash_generated_method = "CB977BF0A1060F0AE5EA7CA6E29C8F81")
    
public static SocketFactory getDefault(int handshakeTimeoutMillis) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, null, true);
    }

    /**
     * Returns a new socket factory instance with an optional handshake timeout
     * and SSL session cache.
     *
     * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
     *         for none.  The socket timeout is reset to 0 after the handshake.
     * @param cache The {@link SSLSessionCache} to use, or null for no cache.
     * @return a new SSLSocketFactory with the specified parameters
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.579 -0500", hash_original_method = "D309EC844DB2702B3C1C595ED44EB7A8", hash_generated_method = "A1A1C3D80A49D2EB99337C229B0EA022")
    
public static SSLSocketFactory getDefault(int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, true);
    }

    /**
     * Returns a new instance of a socket factory with all SSL security checks
     * disabled, using an optional handshake timeout and SSL session cache.
     *
     * <p class="caution"><b>Warning:</b> Sockets created using this factory
     * are vulnerable to man-in-the-middle attacks!</p>
     *
     * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
     *         for none.  The socket timeout is reset to 0 after the handshake.
     * @param cache The {@link SSLSessionCache} to use, or null for no cache.
     * @return an insecure SSLSocketFactory with the specified parameters
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.582 -0500", hash_original_method = "C4FBB842E4910E23FBBA605D8D51EE7B", hash_generated_method = "5FA2F21F66AC9F08D4E7CB28250381CD")
    
public static SSLSocketFactory getInsecure(int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, false);
    }

    /**
     * Returns a socket factory (also named SSLSocketFactory, but in a different
     * namespace) for use with the Apache HTTP stack.
     *
     * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
     *         for none.  The socket timeout is reset to 0 after the handshake.
     * @param cache The {@link SSLSessionCache} to use, or null for no cache.
     * @return a new SocketFactory with the specified parameters
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.584 -0500", hash_original_method = "B91AC610B6C1C479BA647D792CBD1DEC", hash_generated_method = "8E07145F90B05324EC9374A411254DB7")
    
public static org.apache.http.conn.ssl.SSLSocketFactory getHttpSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new org.apache.http.conn.ssl.SSLSocketFactory(
                new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, true));
    }

    /**
     * Verify the hostname of the certificate used by the other end of a
     * connected socket.  You MUST call this if you did not supply a hostname
     * to {@link #createSocket()}.  It is harmless to call this method
     * redundantly if the hostname has already been verified.
     *
     * <p>Wildcard certificates are allowed to verify any matching hostname,
     * so "foo.bar.example.com" is verified if the peer has a certificate
     * for "*.example.com".
     *
     * @param socket An SSL socket which has been connected to a server
     * @param hostname The expected hostname of the remote server
     * @throws IOException if something goes wrong handshaking with the server
     * @throws SSLPeerUnverifiedException if the server cannot prove its identity
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.586 -0500", hash_original_method = "2B95B4365655333AAA993B96EDB35EDC", hash_generated_method = "0D92F50434DBFAA742B4C2027BB0D734")
    
public static void verifyHostname(Socket socket, String hostname) throws IOException {
        if (!(socket instanceof SSLSocket)) {
            throw new IllegalArgumentException("Attempt to verify non-SSL socket");
        }

        if (!isSslCheckRelaxed()) {
            // The code at the start of OpenSSLSocketImpl.startHandshake()
            // ensures that the call is idempotent, so we can safely call it.
            SSLSocket ssl = (SSLSocket) socket;
            ssl.startHandshake();

            SSLSession session = ssl.getSession();
            if (session == null) {
                throw new SSLException("Cannot verify SSL socket without session");
            }
            if (!HOSTNAME_VERIFIER.verify(hostname, session)) {
                throw new SSLPeerUnverifiedException("Cannot verify hostname: " + hostname);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.591 -0500", hash_original_method = "7DBCA983BBA8193E3D9C095B35951C31", hash_generated_method = "956AC06637C67CC27C38D2D73E70C6A4")
    
private static boolean isSslCheckRelaxed() {
        return "1".equals(SystemProperties.get("ro.debuggable")) &&
            "yes".equals(SystemProperties.get("socket.relaxsslcheck"));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.541 -0500", hash_original_field = "EA88B3AF5018E29B68BA1AE112C87777", hash_generated_field = "4391B686CA087DB40CFAB4DD4EE286E8")

    private static final String TAG = "SSLCertificateSocketFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.316 -0400", hash_original_field = "03D07F0B42548D73D2D83351537509EC", hash_generated_field = "71B80C01E377B8916D7C2A93588A1F48")

    private static final TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.545 -0500", hash_original_method = "26F2D3EE02564BFED1F63E8224D261E2", hash_generated_method = "4B421804C4196085705F57A169F61AAF")
        
public X509Certificate[] getAcceptedIssuers() { return null; }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.547 -0500", hash_original_method = "8BEE625C472E5C247B0F67569E87EB34", hash_generated_method = "F756548F393463E0C8D93B459A266B14")
        
public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.549 -0500", hash_original_method = "B887E524006B0C946A6E6D3AF1B3859E", hash_generated_method = "9A95F409B60F21956FB15D9D594D5808")
        
public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.555 -0500", hash_original_field = "06A663E110C1C779F2069CD6EE6EF542", hash_generated_field = "381FF51A80ACF1B95AF4D1EAD812AEC8")

    private static final HostnameVerifier HOSTNAME_VERIFIER =
        HttpsURLConnection.getDefaultHostnameVerifier();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.557 -0500", hash_original_field = "729F5EC00BA21E5813C593A3D155B684", hash_generated_field = "89FC72129020E12BF57CD2392B01CE22")

    private SSLSocketFactory mInsecureFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.559 -0500", hash_original_field = "550FCA02723A9BF9D36E829C0F26FD75", hash_generated_field = "8ACD47C45EED28B4842394CFAECEF862")

    private SSLSocketFactory mSecureFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.561 -0500", hash_original_field = "25B558979E1BFCF49DC5A5E16300768C", hash_generated_field = "610110525F7C805A8423D21E98665401")

    private TrustManager[] mTrustManagers = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.563 -0500", hash_original_field = "AED0DC5D20688F0326D8D337AC821CE6", hash_generated_field = "2E9349D52F3A252E287249876735084D")

    private KeyManager[] mKeyManagers = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.565 -0500", hash_original_field = "92C066AD64790381831D2E60972F1CD6", hash_generated_field = "FA38FA5743C19C615C595C89E63E7AB7")

    private  int mHandshakeTimeoutMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.568 -0500", hash_original_field = "D03E46EDECBAA58DC5BFAFCFA4D7C707", hash_generated_field = "5565824935A99ACC77EEDE6513153296")

    private  SSLClientSessionCache mSessionCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.570 -0500", hash_original_field = "2F216006A24EE485707ECFEDACAEB4CA", hash_generated_field = "796D4B7F9261400D7B1FBDCCF388E7E8")

    private  boolean mSecure;

    /** @deprecated Use {@link #getDefault(int)} instead. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.572 -0500", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "F8F6913031A635492342A22CAEC9FE32")
    
@Deprecated
    public SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.575 -0500", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "B61B1262F4CB56E15292FD471F6874A6")
    
private SSLCertificateSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache, boolean secure) {
        mHandshakeTimeoutMillis = handshakeTimeoutMillis;
        mSessionCache = cache == null ? null : cache.mSessionCache;
        mSecure = secure;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.589 -0500", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "02BB81410CC2F31B22B88773310A42A9")
    
private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        try {
            OpenSSLContextImpl sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            return sslContext.engineGetSocketFactory();
        } catch (KeyManagementException e) {
            Log.wtf(TAG, e);
            return (SSLSocketFactory) SSLSocketFactory.getDefault();  // Fallback
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.593 -0500", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "0A26474FA54458BE9B8BD0D8B1817ACD")
    
private synchronized SSLSocketFactory getDelegate() {
        // Relax the SSL check if instructed (for this factory, or systemwide)
        if (!mSecure || isSslCheckRelaxed()) {
            if (mInsecureFactory == null) {
                if (mSecure) {
                    Log.w(TAG, "*** BYPASSING SSL SECURITY CHECKS (socket.relaxsslcheck=yes) ***");
                } else {
                    Log.w(TAG, "Bypassing SSL security checks at caller's request");
                }
                mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
            }
            return mInsecureFactory;
        } else {
            if (mSecureFactory == null) {
                mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
            }
            return mSecureFactory;
        }
    }

    /**
     * Sets the {@link TrustManager}s to be used for connections made by this factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.596 -0500", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "E1C8A9479965990722F9442ABD551845")
    
public void setTrustManagers(TrustManager[] trustManager) {
        mTrustManagers = trustManager;

        // Clear out all cached secure factories since configurations have changed.
        mSecureFactory = null;
        // Note - insecure factories only ever use the INSECURE_TRUST_MANAGER so they need not
        // be cleared out here.
    }

    /**
     * Sets the {@link KeyManager}s to be used for connections made by this factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.598 -0500", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "45EBA0324D9625CCE52A235C125DDF3F")
    
public void setKeyManagers(KeyManager[] keyManagers) {
        mKeyManagers = keyManagers;

        // Clear out any existing cached factories since configurations have changed.
        mSecureFactory = null;
        mInsecureFactory = null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method verifies the peer's certificate hostname after connecting
     * (unless created with {@link #getInsecure(int, SSLSessionCache)}).
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.601 -0500", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "F21147BC44780FC319DDC7126B73483E")
    
@Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if (mSecure) {
            verifyHostname(s, host);
        }
        return s;
    }

    /**
     * Creates a new socket which is not connected to any remote host.
     * You must use {@link Socket#connect} to connect the socket.
     *
     * <p class="caution"><b>Warning:</b> Hostname verification is not performed
     * with this method.  You MUST verify the server's identity after connecting
     * the socket to avoid man-in-the-middle attacks.</p>
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.603 -0500", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "00AB5FD6D97267BD86AADDDCDAA57662")
    
@Override
    public Socket createSocket() throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return s;
    }

    /**
     * {@inheritDoc}
     *
     * <p class="caution"><b>Warning:</b> Hostname verification is not performed
     * with this method.  You MUST verify the server's identity after connecting
     * the socket to avoid man-in-the-middle attacks.</p>
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.606 -0500", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "934210DA7F210392628B1AB507983364")
    
@Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort)
            throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return s;
    }

    /**
     * {@inheritDoc}
     *
     * <p class="caution"><b>Warning:</b> Hostname verification is not performed
     * with this method.  You MUST verify the server's identity after connecting
     * the socket to avoid man-in-the-middle attacks.</p>
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.608 -0500", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "29530CFBB387599E647A2E7AC79647FE")
    
@Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return s;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method verifies the peer's certificate hostname after connecting
     * (unless created with {@link #getInsecure(int, SSLSessionCache)}).
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.610 -0500", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "73B530554F06FB8B1E5F33347220B487")
    
@Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort)
            throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if (mSecure) {
            verifyHostname(s, host);
        }
        return s;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method verifies the peer's certificate hostname after connecting
     * (unless created with {@link #getInsecure(int, SSLSessionCache)}).
     */
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.613 -0500", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "040BF8C9DB457CA2AF485E86F6851AA9")
    
@Override
    public Socket createSocket(String host, int port) throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        if (mSecure) {
            verifyHostname(s, host);
        }
        return s;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.615 -0500", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "3BE7DC34A9F64CDA0387010A3791573C")
    
@Override
    public String[] getDefaultCipherSuites() {
        return getDelegate().getSupportedCipherSuites();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.617 -0500", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "5731D498CD82ADFFA650F550E298D16E")
    
@Override
    public String[] getSupportedCipherSuites() {
        return getDelegate().getSupportedCipherSuites();
    }
    // orphaned legacy method
    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    
    // orphaned legacy method
    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
    
    // orphaned legacy method
    public X509Certificate[] getAcceptedIssuers() { return null; }
    
}

