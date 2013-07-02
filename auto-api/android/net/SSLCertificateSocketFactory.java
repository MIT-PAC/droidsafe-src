package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "F948430F59414DE0848E0387E3BDAA08", hash_generated_field = "89FC72129020E12BF57CD2392B01CE22")

    private SSLSocketFactory mInsecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "527FEA5AF537705080E80C3101FD6C4A", hash_generated_field = "8ACD47C45EED28B4842394CFAECEF862")

    private SSLSocketFactory mSecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "2A01FD6F9607400342C036D8E93CFD05", hash_generated_field = "610110525F7C805A8423D21E98665401")

    private TrustManager[] mTrustManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "968AEF7133E9F26346FF20CB917906EA", hash_generated_field = "2E9349D52F3A252E287249876735084D")

    private KeyManager[] mKeyManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "A8C798C3DBEEEB28583BB013C4DD4EE9", hash_generated_field = "FA38FA5743C19C615C595C89E63E7AB7")

    private int mHandshakeTimeoutMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "5565824935A99ACC77EEDE6513153296")

    private SSLClientSessionCache mSessionCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.007 -0400", hash_original_field = "8117DE95DBD772BCC84A9F5461DF0D0A", hash_generated_field = "796D4B7F9261400D7B1FBDCCF388E7E8")

    private boolean mSecure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.008 -0400", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "1800B163035D900AD23AC2D6DBEA6F13")
    @Deprecated
    public  SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
        addTaint(handshakeTimeoutMillis);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.008 -0400", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "6830AC530177609ED297B497DEB3CC58")
    private  SSLCertificateSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache, boolean secure) {
        mHandshakeTimeoutMillis = handshakeTimeoutMillis;
        mSessionCache = cache == null ? null : cache.mSessionCache;
        mSecure = secure;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SocketFactory getDefault(int handshakeTimeoutMillis) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, null, true);
    }

    
    @DSModeled(DSC.SAFE)
    public static SSLSocketFactory getDefault(int handshakeTimeoutMillis, SSLSessionCache cache) {
        return new SSLCertificateSocketFactory(handshakeTimeoutMillis, cache, true);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.010 -0400", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "6696DB29CD855C021D4C0E4AEE5797F7")
    private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1721485027 = null; 
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_2045411136 = null; 
        try 
        {
            OpenSSLContextImpl sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            varB4EAC82CA7396A68D541C85D26508E83_1721485027 = sslContext.engineGetSocketFactory();
        } 
        catch (KeyManagementException e)
        {
            Log.wtf(TAG, e);
            varB4EAC82CA7396A68D541C85D26508E83_2045411136 = (SSLSocketFactory) SSLSocketFactory.getDefault();
        } 
        addTaint(keyManagers[0].getTaint());
        addTaint(trustManagers[0].getTaint());
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1968473036; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1968473036 = varB4EAC82CA7396A68D541C85D26508E83_1721485027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1968473036 = varB4EAC82CA7396A68D541C85D26508E83_2045411136;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1968473036.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1968473036;
        
        
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isSslCheckRelaxed() {
        return "1".equals(SystemProperties.get("ro.debuggable")) &&
            "yes".equals(SystemProperties.get("socket.relaxsslcheck"));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.012 -0400", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "B4792B3DDD906679F8415ED7341FEBC9")
    private synchronized SSLSocketFactory getDelegate() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1111392552 = null; 
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_2016771121 = null; 
        {
            boolean var275D6A805F1C7FE5A1E02E6A1ECC80AC_1476929224 = (!mSecure || isSslCheckRelaxed());
            {
                {
                    mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1111392552 = mInsecureFactory;
            } 
            {
                {
                    mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_2016771121 = mSecureFactory;
            } 
        } 
        SSLSocketFactory varA7E53CE21691AB073D9660D615818899_1750085137; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1750085137 = varB4EAC82CA7396A68D541C85D26508E83_1111392552;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1750085137 = varB4EAC82CA7396A68D541C85D26508E83_2016771121;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1750085137.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1750085137;
        
        
            
                
                    
                
                    
                
                
            
            
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.012 -0400", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "998FF20F6D3A9FFEA40D588C8CF2D350")
    public void setTrustManagers(TrustManager[] trustManager) {
        mTrustManagers = trustManager;
        mSecureFactory = null;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.012 -0400", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "B5237A04FD9BED9F29D5F0DEB5F5A971")
    public void setKeyManagers(KeyManager[] keyManagers) {
        mKeyManagers = keyManagers;
        mSecureFactory = null;
        mInsecureFactory = null;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.013 -0400", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "E707050FD6562CCE9D9CF40885EDC233")
    @Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1695611960 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1695611960 = s;
        addTaint(k.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(close);
        varB4EAC82CA7396A68D541C85D26508E83_1695611960.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1695611960;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.014 -0400", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "2D2907823180B060CC47408F351F0499")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1190345139 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_1190345139 = s;
        varB4EAC82CA7396A68D541C85D26508E83_1190345139.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1190345139;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.014 -0400", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "A3EAB3B54948E4A471BBD581C0285DA9")
    @Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1567088312 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_1567088312 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1567088312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1567088312;
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.015 -0400", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "CAC22F2BAB0A14D1E095CE7B27C20A2A")
    @Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1460264940 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        varB4EAC82CA7396A68D541C85D26508E83_1460264940 = s;
        addTaint(addr.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1460264940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1460264940;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.016 -0400", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "99BAD785792FD41CC41AEC5EB5DCD09C")
    @Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1681376362 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1681376362 = s;
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddr.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1681376362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1681376362;
        
        
                
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.016 -0400", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "0229BE65AFC5EF49F417B0AAFC7F857C")
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1676925642 = null; 
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1676925642 = s;
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1676925642.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1676925642;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.017 -0400", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "00385504C02B8C09BEF0D9381D00E319")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1070360241 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1070360241 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1070360241.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1070360241;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.017 -0400", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "FA0DE0AED486CA10F333E559A8276530")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_845333477 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_845333477 = getDelegate().getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_845333477.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_845333477;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.018 -0400", hash_original_field = "B12979E9F39C789877B9E363DC6A35D4", hash_generated_field = "4391B686CA087DB40CFAB4DD4EE286E8")

    private static final String TAG = "SSLCertificateSocketFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.018 -0400", hash_original_field = "03D07F0B42548D73D2D83351537509EC", hash_generated_field = "71B80C01E377B8916D7C2A93588A1F48")

    private static final TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.018 -0400", hash_original_field = "6343101D0F76EABC0D4977BB28AE6A22", hash_generated_field = "381FF51A80ACF1B95AF4D1EAD812AEC8")

    private static final HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    
    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    
    
    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
    
    
    public X509Certificate[] getAcceptedIssuers() { return null; }
    
}

