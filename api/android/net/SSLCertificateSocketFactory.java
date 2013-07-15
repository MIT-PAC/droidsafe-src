package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.460 -0400", hash_original_field = "F948430F59414DE0848E0387E3BDAA08", hash_generated_field = "89FC72129020E12BF57CD2392B01CE22")

    private SSLSocketFactory mInsecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.460 -0400", hash_original_field = "527FEA5AF537705080E80C3101FD6C4A", hash_generated_field = "8ACD47C45EED28B4842394CFAECEF862")

    private SSLSocketFactory mSecureFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.460 -0400", hash_original_field = "2A01FD6F9607400342C036D8E93CFD05", hash_generated_field = "610110525F7C805A8423D21E98665401")

    private TrustManager[] mTrustManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.460 -0400", hash_original_field = "968AEF7133E9F26346FF20CB917906EA", hash_generated_field = "2E9349D52F3A252E287249876735084D")

    private KeyManager[] mKeyManagers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.460 -0400", hash_original_field = "A8C798C3DBEEEB28583BB013C4DD4EE9", hash_generated_field = "FA38FA5743C19C615C595C89E63E7AB7")

    private int mHandshakeTimeoutMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.461 -0400", hash_original_field = "8713673389F715AC61146DC2ACD6B364", hash_generated_field = "5565824935A99ACC77EEDE6513153296")

    private SSLClientSessionCache mSessionCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.461 -0400", hash_original_field = "8117DE95DBD772BCC84A9F5461DF0D0A", hash_generated_field = "796D4B7F9261400D7B1FBDCCF388E7E8")

    private boolean mSecure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.461 -0400", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "1800B163035D900AD23AC2D6DBEA6F13")
    @Deprecated
    public  SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
        addTaint(handshakeTimeoutMillis);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.462 -0400", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "6830AC530177609ED297B497DEB3CC58")
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

    
        @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.464 -0400", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "B3F714DC04A522E0DC1739CD9AA0C965")
    private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        addTaint(trustManagers[0].getTaint());
        addTaint(keyManagers[0].getTaint());
        try 
        {
            OpenSSLContextImpl sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
SSLSocketFactory var0688CE61924B58E8E42B01B587786B23_1271875604 =             sslContext.engineGetSocketFactory();
            var0688CE61924B58E8E42B01B587786B23_1271875604.addTaint(taint);
            return var0688CE61924B58E8E42B01B587786B23_1271875604;
        } //End block
        catch (KeyManagementException e)
        {
            Log.wtf(TAG, e);
SSLSocketFactory varF47896031DB2974730631E4534BA0DEC_2015819449 =             (SSLSocketFactory) SSLSocketFactory.getDefault();
            varF47896031DB2974730631E4534BA0DEC_2015819449.addTaint(taint);
            return varF47896031DB2974730631E4534BA0DEC_2015819449;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.465 -0400", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "A2731E85F9EB8E65C40EDFD77AEBE878")
    private synchronized SSLSocketFactory getDelegate() {
    if(!mSecure || isSslCheckRelaxed())        
        {
    if(mInsecureFactory == null)            
            {
    if(mSecure)                
                {
                } //End block
                else
                {
                } //End block
                mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
            } //End block
SSLSocketFactory varA8D7AE461D90628F3AE602563DE6800B_2104938507 =             mInsecureFactory;
            varA8D7AE461D90628F3AE602563DE6800B_2104938507.addTaint(taint);
            return varA8D7AE461D90628F3AE602563DE6800B_2104938507;
        } //End block
        else
        {
    if(mSecureFactory == null)            
            {
                mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
            } //End block
SSLSocketFactory varA745E263981E51AC4CE6DF203D86CCF9_847893148 =             mSecureFactory;
            varA745E263981E51AC4CE6DF203D86CCF9_847893148.addTaint(taint);
            return varA745E263981E51AC4CE6DF203D86CCF9_847893148;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.466 -0400", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "998FF20F6D3A9FFEA40D588C8CF2D350")
    public void setTrustManagers(TrustManager[] trustManager) {
        mTrustManagers = trustManager;
        mSecureFactory = null;
        // ---------- Original Method ----------
        //mTrustManagers = trustManager;
        //mSecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.467 -0400", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "B5237A04FD9BED9F29D5F0DEB5F5A971")
    public void setKeyManagers(KeyManager[] keyManagers) {
        mKeyManagers = keyManagers;
        mSecureFactory = null;
        mInsecureFactory = null;
        // ---------- Original Method ----------
        //mKeyManagers = keyManagers;
        //mSecureFactory = null;
        //mInsecureFactory = null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.468 -0400", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "BDF7B429D8F133E48F1585390A353F7D")
    @Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        addTaint(close);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(k.getTaint());
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
    if(mSecure)        
        {
            verifyHostname(s, host);
        } //End block
Socket var0478718F0636FB61899C13801CE9FE09_76850174 =         s;
        var0478718F0636FB61899C13801CE9FE09_76850174.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_76850174;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.468 -0400", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "2249BC24664B3E2FFD786E353D978FDE")
    @Override
    public Socket createSocket() throws IOException {
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
Socket var0478718F0636FB61899C13801CE9FE09_1656936905 =         s;
        var0478718F0636FB61899C13801CE9FE09_1656936905.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1656936905;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.469 -0400", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "5E5860CBC8337124A149F53FCDE797AB")
    @Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddr.getTaint());
        addTaint(port);
        addTaint(addr.getTaint());
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
Socket var0478718F0636FB61899C13801CE9FE09_2098787341 =         s;
        var0478718F0636FB61899C13801CE9FE09_2098787341.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_2098787341;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //addr, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.469 -0400", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "3EA6247175D2B28F17940CBACFAFD982")
    @Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        addTaint(port);
        addTaint(addr.getTaint());
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
Socket var0478718F0636FB61899C13801CE9FE09_901572839 =         s;
        var0478718F0636FB61899C13801CE9FE09_901572839.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_901572839;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.470 -0400", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "2EBFEE6E2DAFBA9ECB6BCF195F65C3A4")
    @Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddr.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
    if(mSecure)        
        {
            verifyHostname(s, host);
        } //End block
Socket var0478718F0636FB61899C13801CE9FE09_1809127886 =         s;
        var0478718F0636FB61899C13801CE9FE09_1809127886.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1809127886;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //host, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.470 -0400", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "E08C78B223577423509F48E81746CC33")
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
    if(mSecure)        
        {
            verifyHostname(s, host);
        } //End block
Socket var0478718F0636FB61899C13801CE9FE09_1240715137 =         s;
        var0478718F0636FB61899C13801CE9FE09_1240715137.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1240715137;
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.471 -0400", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "030057FE12FF94A4D1FF59F6ACCF51E3")
    @Override
    public String[] getDefaultCipherSuites() {
String[] varD975358FAC88FC1B03513CAC9775EB14_814564513 =         getDelegate().getSupportedCipherSuites();
        varD975358FAC88FC1B03513CAC9775EB14_814564513.addTaint(taint);
        return varD975358FAC88FC1B03513CAC9775EB14_814564513;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.471 -0400", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "DF1B4C8F9B854D22A2FACCB75572FF89")
    @Override
    public String[] getSupportedCipherSuites() {
String[] varD975358FAC88FC1B03513CAC9775EB14_992716036 =         getDelegate().getSupportedCipherSuites();
        varD975358FAC88FC1B03513CAC9775EB14_992716036.addTaint(taint);
        return varD975358FAC88FC1B03513CAC9775EB14_992716036;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.471 -0400", hash_original_field = "B12979E9F39C789877B9E363DC6A35D4", hash_generated_field = "4391B686CA087DB40CFAB4DD4EE286E8")

    private static final String TAG = "SSLCertificateSocketFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.472 -0400", hash_original_field = "03D07F0B42548D73D2D83351537509EC", hash_generated_field = "71B80C01E377B8916D7C2A93588A1F48")

    private static final TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.472 -0400", hash_original_field = "6343101D0F76EABC0D4977BB28AE6A22", hash_generated_field = "381FF51A80ACF1B95AF4D1EAD812AEC8")

    private static final HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    // orphaned legacy method
    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    
    // orphaned legacy method
    public X509Certificate[] getAcceptedIssuers() { return null; }
    
    // orphaned legacy method
    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
    
}

