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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.377 -0400", hash_original_field = "F948430F59414DE0848E0387E3BDAA08", hash_generated_field = "89FC72129020E12BF57CD2392B01CE22")

    private SSLSocketFactory mInsecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.377 -0400", hash_original_field = "527FEA5AF537705080E80C3101FD6C4A", hash_generated_field = "8ACD47C45EED28B4842394CFAECEF862")

    private SSLSocketFactory mSecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.388 -0400", hash_original_field = "2A01FD6F9607400342C036D8E93CFD05", hash_generated_field = "610110525F7C805A8423D21E98665401")

    private TrustManager[] mTrustManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.388 -0400", hash_original_field = "968AEF7133E9F26346FF20CB917906EA", hash_generated_field = "2E9349D52F3A252E287249876735084D")

    private KeyManager[] mKeyManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.388 -0400", hash_original_field = "A8C798C3DBEEEB28583BB013C4DD4EE9", hash_generated_field = "FA38FA5743C19C615C595C89E63E7AB7")

    private int mHandshakeTimeoutMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.388 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "5565824935A99ACC77EEDE6513153296")

    private SSLClientSessionCache mSessionCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.388 -0400", hash_original_field = "8117DE95DBD772BCC84A9F5461DF0D0A", hash_generated_field = "796D4B7F9261400D7B1FBDCCF388E7E8")

    private boolean mSecure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.389 -0400", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "1800B163035D900AD23AC2D6DBEA6F13")
    @Deprecated
    public  SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
        addTaint(handshakeTimeoutMillis);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.390 -0400", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "6830AC530177609ED297B497DEB3CC58")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.413 -0400", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "B6496D1F8D96066FEAA0D608C768BC5E")
    private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1796451138 = null; //Variable for return #1
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_601487973 = null; //Variable for return #2
        try 
        {
            OpenSSLContextImpl sslContext;
            sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            varB4EAC82CA7396A68D541C85D26508E83_1796451138 = sslContext.engineGetSocketFactory();
        } //End block
        catch (KeyManagementException e)
        {
            Log.wtf(TAG, e);
            varB4EAC82CA7396A68D541C85D26508E83_601487973 = (SSLSocketFactory) SSLSocketFactory.getDefault();
        } //End block
        addTaint(keyManagers[0].getTaint());
        addTaint(trustManagers[0].getTaint());
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1526754367; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1526754367 = varB4EAC82CA7396A68D541C85D26508E83_1796451138;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1526754367 = varB4EAC82CA7396A68D541C85D26508E83_601487973;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1526754367.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1526754367;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.415 -0400", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "78C926781EB84DB6C22F0D7B45982EFF")
    private synchronized SSLSocketFactory getDelegate() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1565078552 = null; //Variable for return #1
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_688809133 = null; //Variable for return #2
        {
            boolean var275D6A805F1C7FE5A1E02E6A1ECC80AC_1566370343 = (!mSecure || isSslCheckRelaxed());
            {
                {
                    mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1565078552 = mInsecureFactory;
            } //End block
            {
                {
                    mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_688809133 = mSecureFactory;
            } //End block
        } //End collapsed parenthetic
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1942179321; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1942179321 = varB4EAC82CA7396A68D541C85D26508E83_1565078552;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1942179321 = varB4EAC82CA7396A68D541C85D26508E83_688809133;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1942179321.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1942179321;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.416 -0400", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "998FF20F6D3A9FFEA40D588C8CF2D350")
    public void setTrustManagers(TrustManager[] trustManager) {
        mTrustManagers = trustManager;
        mSecureFactory = null;
        // ---------- Original Method ----------
        //mTrustManagers = trustManager;
        //mSecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.432 -0400", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "B5237A04FD9BED9F29D5F0DEB5F5A971")
    public void setKeyManagers(KeyManager[] keyManagers) {
        mKeyManagers = keyManagers;
        mSecureFactory = null;
        mInsecureFactory = null;
        // ---------- Original Method ----------
        //mKeyManagers = keyManagers;
        //mSecureFactory = null;
        //mInsecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.433 -0400", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "7A8E0C115DE52CB4047D948B1BAA0BB8")
    @Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1285217686 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1285217686 = s;
        addTaint(k.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(close);
        varB4EAC82CA7396A68D541C85D26508E83_1285217686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285217686;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.446 -0400", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "9FB13F17DE7EDC14BF6E978092DEC81E")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1883347381 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_1883347381 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1883347381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883347381;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.465 -0400", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "037013AE04D850AA52310BF1C182EB31")
    @Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2140080680 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_2140080680 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_2140080680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2140080680;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //addr, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.466 -0400", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "9407D6446F962A05552CB5ADE6A24063")
    @Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_721247879 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_721247879 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_721247879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_721247879;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.481 -0400", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "7F039EE9246E0FB35EFAB53E569CBFDF")
    @Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_527021823 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_527021823 = s;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_527021823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_527021823;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //host, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.483 -0400", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "B1AE7E7CE49D814E1C51B4A863019BDB")
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1007022479 = null; //Variable for return #1
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1007022479 = s;
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1007022479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007022479;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.484 -0400", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "3564DE432CE61D06CE194DFCF493C22A")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1953461620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1953461620 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1953461620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1953461620;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.484 -0400", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "8A2C1251A6A5D746CEFE6F1E9657AA2B")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_829682134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_829682134 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_829682134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_829682134;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.485 -0400", hash_original_field = "B12979E9F39C789877B9E363DC6A35D4", hash_generated_field = "FC8E7695271CC66914D1C65333B02F61")

    private static String TAG = "SSLCertificateSocketFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.485 -0400", hash_original_field = "03D07F0B42548D73D2D83351537509EC", hash_generated_field = "D3769B6021F621E55BFBDCC08CB65733")

    private static TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.485 -0400", hash_original_field = "6343101D0F76EABC0D4977BB28AE6A22", hash_generated_field = "CCB419C3623B5FD23C04EEFDA18CFD14")

    private static HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
}

