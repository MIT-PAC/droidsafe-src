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
    private SSLSocketFactory mInsecureFactory = null;
    private SSLSocketFactory mSecureFactory = null;
    private TrustManager[] mTrustManagers = null;
    private KeyManager[] mKeyManagers = null;
    private int mHandshakeTimeoutMillis;
    private SSLClientSessionCache mSessionCache;
    private boolean mSecure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.467 -0400", hash_original_method = "C520FACF2CB3A9E78CAAA32B44A1FB0B", hash_generated_method = "32968A365D814EB20DE615FAD9434072")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SSLCertificateSocketFactory(int handshakeTimeoutMillis) {
        this(handshakeTimeoutMillis, null, true);
        dsTaint.addTaint(handshakeTimeoutMillis);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.467 -0400", hash_original_method = "0B60EEBB0E30E9D2D2074F3C398E1DED", hash_generated_method = "508522FB66C0FB39264A4A0A236F2F80")
    @DSModeled(DSC.SAFE)
    private SSLCertificateSocketFactory(
            int handshakeTimeoutMillis, SSLSessionCache cache, boolean secure) {
        dsTaint.addTaint(cache.dsTaint);
        dsTaint.addTaint(secure);
        dsTaint.addTaint(handshakeTimeoutMillis);
        mSessionCache = cache == null ? null : cache.mSessionCache;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.469 -0400", hash_original_method = "EA6C3E571993A79CC59A9005D7F049FF", hash_generated_method = "4F14260BC4E267F85744355E99B56C6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SSLSocketFactory makeSocketFactory(
            KeyManager[] keyManagers, TrustManager[] trustManagers) {
        dsTaint.addTaint(trustManagers[0].dsTaint);
        dsTaint.addTaint(keyManagers[0].dsTaint);
        try 
        {
            OpenSSLContextImpl sslContext;
            sslContext = new OpenSSLContextImpl();
            sslContext.engineInit(keyManagers, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(mSessionCache);
            SSLSocketFactory var732F56ED158690A07BF4116B70C6346E_353082003 = (sslContext.engineGetSocketFactory());
        } //End block
        catch (KeyManagementException e)
        {
            Log.wtf(TAG, e);
            SSLSocketFactory varB315E707F1920F31C6814686B729CDF2_395038640 = ((SSLSocketFactory) SSLSocketFactory.getDefault());
        } //End block
        return (SSLSocketFactory)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.469 -0400", hash_original_method = "293C785CB66F2E86F228FEC441D5947A", hash_generated_method = "1AD262D468E1AA1F6F076DF16E9BDB10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized SSLSocketFactory getDelegate() {
        {
            boolean var275D6A805F1C7FE5A1E02E6A1ECC80AC_1039176868 = (!mSecure || isSslCheckRelaxed());
            {
                {
                    mInsecureFactory = makeSocketFactory(mKeyManagers, INSECURE_TRUST_MANAGER);
                } //End block
            } //End block
            {
                {
                    mSecureFactory = makeSocketFactory(mKeyManagers, mTrustManagers);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (SSLSocketFactory)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.470 -0400", hash_original_method = "530A7515F3DC833E4C613AF46D6ECFB7", hash_generated_method = "64E6A2CB5EFFAE3589AA70AB8965F9FA")
    @DSModeled(DSC.SAFE)
    public void setTrustManagers(TrustManager[] trustManager) {
        dsTaint.addTaint(trustManager[0].dsTaint);
        mSecureFactory = null;
        // ---------- Original Method ----------
        //mTrustManagers = trustManager;
        //mSecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.470 -0400", hash_original_method = "C01FA00736C8FD8CD5B4AF14DA0E6BC6", hash_generated_method = "2A1EE0430AC7427B5F9B41EDE4F87501")
    @DSModeled(DSC.SAFE)
    public void setKeyManagers(KeyManager[] keyManagers) {
        dsTaint.addTaint(keyManagers[0].dsTaint);
        mSecureFactory = null;
        mInsecureFactory = null;
        // ---------- Original Method ----------
        //mKeyManagers = keyManagers;
        //mSecureFactory = null;
        //mInsecureFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.470 -0400", hash_original_method = "4304AB31317AB234B33A24A3097FC48A", hash_generated_method = "DB9789A91C720B81977491039B338721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(Socket k, String host, int port, boolean close) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(k.dsTaint);
        dsTaint.addTaint(close);
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(k, host, port, close);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.471 -0400", hash_original_method = "A93A66D768B2246423C7BE25AD8A2DA8", hash_generated_method = "3CB8BAB1B88FD216727066B398245683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket() throws IOException {
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket();
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket();
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.471 -0400", hash_original_method = "B1DE7D9F10AA772C2BD2AA45E50C7AB6", hash_generated_method = "C8F94998F2089CEF0445A251C815C518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress addr, int port, InetAddress localAddr, int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(localAddr.dsTaint);
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                addr, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //addr, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.471 -0400", hash_original_method = "FFBF9F2950A9BB08EFE61A5F32F42B11", hash_generated_method = "DF040FF2B6547D2FEECC4B7C1C7171F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress addr, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(addr.dsTaint);
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(addr, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.471 -0400", hash_original_method = "1DBE2FFA1790A1D0791947337B43D86B", hash_generated_method = "47A517964F0ED3AEBC5386FC5F6EF0D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localAddr.dsTaint);
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(
                host, port, localAddr, localPort);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(
                //host, port, localAddr, localPort);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.472 -0400", hash_original_method = "29FB194599A9B20E43B819582316EFA2", hash_generated_method = "37CF5E6D6D4087A20D83BE9C8A2AE848")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        OpenSSLSocketImpl s;
        s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        {
            verifyHostname(s, host);
        } //End block
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //OpenSSLSocketImpl s = (OpenSSLSocketImpl) getDelegate().createSocket(host, port);
        //s.setHandshakeTimeout(mHandshakeTimeoutMillis);
        //if (mSecure) {
            //verifyHostname(s, host);
        //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.472 -0400", hash_original_method = "6359CF219DCC414C7F8837CF1055EDC0", hash_generated_method = "D91699DC976DE217BCB471C17F3C9CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getDefaultCipherSuites() {
        String[] var794C9B1322A472F5C3B3299F25AB7BA8_1046518517 = (getDelegate().getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.472 -0400", hash_original_method = "51E2A3335139F25255D5BC1DBCD2892E", hash_generated_method = "5228080280620D6A8083C05D55D94D38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var794C9B1322A472F5C3B3299F25AB7BA8_1739399549 = (getDelegate().getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return getDelegate().getSupportedCipherSuites();
    }

    
    private static final String TAG = "SSLCertificateSocketFactory";
    private static final TrustManager[] INSECURE_TRUST_MANAGER = new TrustManager[] {
        new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };
    private static final HostnameVerifier HOSTNAME_VERIFIER =
        HttpsURLConnection.getDefaultHostnameVerifier();
}

