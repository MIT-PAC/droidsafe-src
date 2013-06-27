package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.SystemProperties;
import android.util.Log;
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

public class SSLCertificateSocketFactory extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "F948430F59414DE0848E0387E3BDAA08", hash_generated_field = "89FC72129020E12BF57CD2392B01CE22")

    private SSLSocketFactory mInsecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "527FEA5AF537705080E80C3101FD6C4A", hash_generated_field = "8ACD47C45EED28B4842394CFAECEF862")

    private SSLSocketFactory mSecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "2A01FD6F9607400342C036D8E93CFD05", hash_generated_field = "610110525F7C805A8423D21E98665401")

    private TrustManager[] mTrustManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "968AEF7133E9F26346FF20CB917906EA", hash_generated_field = "2E9349D52F3A252E287249876735084D")

    private KeyManager[] mKeyManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "A8C798C3DBEEEB28583BB013C4DD4EE9", hash_generated_field = "FA38FA5743C19C615C595C89E63E7AB7")

    private int mHandshakeTimeoutMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "5565824935A99ACC77EEDE6513153296")

    private SSLClientSessionCache mSessionCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.096 -0400", hash_original_field = "8117DE95DBD772BCC84A9F5461DF0D0A", hash_generated_field = "796D4B7F9261400D7B1FBDCCF388E7E8")

    private boolean mSecure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.103 -0400", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "1800B163035D900AD23AC2D6DBEA6F13")
    @Deprecated
    public  SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
        addTaint(handshakeTimeoutMillis);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.105 -0400", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "6830AC530177609ED297B497DEB3CC58")
    private  SSLCertificateSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache, boolean secure) {
        mHandshakeTimeoutMillis = handshakeTimeoutMillis;
        mSessionCache = cache == null ? null : cache.mSessionCache;
        mSecure = secure;
        // ---------- Original Method ----------
        //mHandshakeTimeoutMillis = handshakeTimeoutMillis;
        //mSessionCache = cache == null ? null : cache.mSessionCache;
        //mSecure = secure;
    }

    
        public static SocketFactory getDefault(int handshakeTimeoutMillis) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, null, true);
    }

    
        public static SSLSocketFactory getDefault(int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, true);
    }

    
        public static SSLSocketFactory getInsecure(int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, false);
    }

    
        public static org.apache.http.conn.ssl.SSLSocketFactory getHttpSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new org.apache.http.conn.ssl.SSLSocketFactory(
                new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, true));
    }

    
        public static void verifyHostname(Socket socket, String hostname) throws IOException {
        if (!(socket instanceof SSLSocket)) {
            throw new IllegalArgumentException("Attempt to verify non-SSL socket");
        }
        if (!isSslCheckRelaxed()) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.129 -0400", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "FC7CB526B51BB91B85D6DFADA6AB47B0")
    private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1362064383 = null; //Variable for return #1
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1582557257 = null; //Variable for return #2
        try 
        {
            OpenSSLContextImpl sslContext;
            sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            varB4EAC82CA7396A68D541C85D26508E83_1362064383 = sslContext.engineGetSocketFactory();
        } //End block
        catch (KeyManagementException e)
        {
            Log.wtf(TAG, e);
            varB4EAC82CA7396A68D541C85D26508E83_1582557257 = (SSLSocketFactory) SSLSocketFactory.getDefault();
        } //End block
        addTaint(keyManagers[0].getTaint());
        addTaint(trustManagers[0].getTaint());
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1972464288; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1972464288 = varB4EAC82CA7396A68D541C85D26508E83_1362064383;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1972464288 = varB4EAC82CA7396A68D541C85D26508E83_1582557257;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1972464288.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1972464288;
        // ---------- Original Method ----------
        //try {
            //OpenSSLContextImpl sslContext = new OpenSSLContextImpl();
            //sslContext.engineInit(keyManagers, trustManagers, null);
            //sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            //return sslContext.engineGetSocketFactory();
        //} catch (KeyManagementException e) {
            //Log.wtf(TAG, e);
            //return (SSLSocketFactory) SSLSocketFactory.getDefault();  
        //}
    }

    
        private static boolean isSslCheckRelaxed() {
        return "1".equals(SystemProperties.get("ro.debuggable")) &&
            "yes".equals(SystemProperties.get("socket.relaxsslcheck"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.131 -0400", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "AAC58BFAA170824FD05D1A8931DE14E4")
    private synchronized SSLSocketFactory getDelegate() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1870501481 = null; //Variable for return #1
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1886866619 = null; //Variable for return #2
        {
            boolean var275D6A805F1C7FE5A1E02E6A1ECC80AC_835832079 = (!mSecure || isSslCheckRelaxed());
            {
                {
                    mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1870501481 = mInsecureFactory;
            } //End block
            {
                {
                    mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1886866619 = mSecureFactory;
            } //End block
        } //End collapsed parenthetic
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1342908533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1342908533 = varB4EAC82CA7396A68D541C85D26508E83_1870501481;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1342908533 = varB4EAC82CA7396A68D541C85D26508E83_1886866619;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1342908533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1342908533;
        // ---------- Original Method ----------
        //if (!mSecure || isSslCheckRelaxed()) {
            //if (mInsecureFactory == null) {
                //if (mSecure) {
                    //Log.w(TAG, "*** BYPASSING SSL SECURITY CHECKS (socket.relaxsslcheck=yes) ***");
                //} else {
                    //Log.w(TAG, "Bypassing SSL security checks at caller's request");
                //}
                //mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
            //}
            //return mInsecureFactory;
        //} else {
            //if (mSecureFactory == null) {
                //mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
            //}
            //return mSecureFactory;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.132 -0400", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "998FF20F6D3A9FFEA40D588C8CF2D350")
    public void setTrustManagers(TrustManager[] trustManager) {
        mTrustManagers = trustManager;
        mSecureFactory = null;
        // ---------- Original Method ----------
        //mTrustManagers = trustManager;
        //mSecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.147 -0400", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "B5237A04FD9BED9F29D5F0DEB5F5A971")
    public void setKeyManagers(KeyManager[] keyManagers) {
        mKeyManagers = keyManagers;
        mSecureFactory = null;
        mInsecureFactory = null;
        // ---------- Original Method ----------
        //mKeyManagers = keyManagers;
        //mSecureFactory = null;
        //mInsecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.153 -0400", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "BFE91FB3B26BAF643D0CC8EDD5FF9A63")
    @Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1009560721 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1009560721 = s;
        addTaint(k.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(close);
        varB4EAC82CA7396A68D541C85D26508E83_1009560721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1009560721;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.165 -0400", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "933E2E1BAF8E231BABBC20BCD75C0C57")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_156984862 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_156984862 = s;
        varB4EAC82CA7396A68D541C85D26508E83_156984862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156984862;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.170 -0400", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "385026D7ACBE3E5DD5E57D14F53BD02D")
    @Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_994264245 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_994264245 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_994264245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994264245;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //addr, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.171 -0400", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "709047B0D8105FB223206FDEBC63A266")
    @Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1246470121 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_1246470121 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1246470121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246470121;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.172 -0400", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "6D5E963E395E77553CDCC414AD64457A")
    @Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_201170952 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_201170952 = s;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_201170952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_201170952;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //host, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.173 -0400", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "FCA0C0CDDCC2B4C5A4CA5F47E442D983")
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1695271670 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1695271670 = s;
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1695271670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695271670;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.189 -0400", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "AAE9BC0DB5684DC6FA6C41DB063AD174")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2144074223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2144074223 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_2144074223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2144074223;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.189 -0400", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "3B51C5E408E984315CA02168E8389D95")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1444663513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1444663513 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1444663513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1444663513;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.190 -0400", hash_original_field = "B12979E9F39C789877B9E363DC6A35D4", hash_generated_field = "FC8E7695271CC66914D1C65333B02F61")

    private static String TAG = "SSLCertificateSocketFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.190 -0400", hash_original_field = "03D07F0B42548D73D2D83351537509EC", hash_generated_field = "D3769B6021F621E55BFBDCC08CB65733")

    private static TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.190 -0400", hash_original_field = "6343101D0F76EABC0D4977BB28AE6A22", hash_generated_field = "CCB419C3623B5FD23C04EEFDA18CFD14")

    private static HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
}

