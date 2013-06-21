package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.net.DomainNameValidator;
import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Date;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class CertificateChainValidator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.713 -0400", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "249781E5FCB4B7182831503E258AE636")
    @DSModeled(DSC.SAFE)
    private CertificateChainValidator() {
        // ---------- Original Method ----------
    }

    
        public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.714 -0400", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "26ED0369C0294CFE6F0D01074B4E24F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslError doHandshakeAndValidateServerCertificates(
            HttpsConnection connection, SSLSocket sslSocket, String domain) throws IOException {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(sslSocket.dsTaint);
        SSLSession sslSession;
        sslSession = sslSocket.getSession();
        {
            boolean var93330143B7CECBEE557BABA2F99073AF_422492033 = (!sslSession.isValid());
            {
                closeSocketThrowException(sslSocket, "failed to perform SSL handshake");
            } //End block
        } //End collapsed parenthetic
        Certificate[] peerCertificates;
        peerCertificates = sslSocket.getSession().getPeerCertificates();
        {
            closeSocketThrowException(
                sslSocket, "failed to retrieve peer certificates");
        } //End block
        {
            {
                {
                    connection.setCertificate(
                        new SslCertificate((X509Certificate)peerCertificates[0]));
                } //End block
            } //End block
        } //End block
        SslError var15C93933903158A68B2AE388763BEA10_1010416061 = (verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA"));
        return (SslError)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static SslError verifyServerCertificates(
        byte[][] certChain, String domain, String authType) throws IOException {
        if (certChain == null || certChain.length == 0) {
            throw new IllegalArgumentException("bad certificate chain");
        }
        X509Certificate[] serverCertificates = new X509Certificate[certChain.length];
        for (int i = 0; i < certChain.length; ++i) {
            serverCertificates[i] = new X509CertImpl(certChain[i]);
        }
        return verifyServerDomainAndCertificates(serverCertificates, domain, authType);
    }

    
        private static SslError verifyServerDomainAndCertificates(
            X509Certificate[] chain, String domain, String authType) throws IOException {
        X509Certificate currCertificate = chain[0];
        if (currCertificate == null) {
            throw new IllegalArgumentException("certificate for this site is null");
        }
        if (!DomainNameValidator.match(currCertificate, domain)) {
            if (HttpLog.LOGV) {
                HttpLog.v("certificate not for this host: " + domain);
            }
            return new SslError(SslError.SSL_IDMISMATCH, currCertificate);
        }
        try {
            SSLParametersImpl.getDefaultTrustManager().checkServerTrusted(chain, authType);
            return null;  
        } catch (CertificateException e) {
            if (HttpLog.LOGV) {
                HttpLog.v("failed to validate the certificate chain, error: " +
                    e.getMessage());
            }
            return new SslError(SslError.SSL_UNTRUSTED, currCertificate);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.714 -0400", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "CB3F114E3B373A365E0BC59D7BA45FF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeSocketThrowException(
            SSLSocket socket, String errorMessage, String defaultErrorMessage) throws IOException {
        dsTaint.addTaint(errorMessage);
        dsTaint.addTaint(socket.dsTaint);
        dsTaint.addTaint(defaultErrorMessage);
        closeSocketThrowException(
            socket, errorMessage != null ? errorMessage : defaultErrorMessage);
        // ---------- Original Method ----------
        //closeSocketThrowException(
            //socket, errorMessage != null ? errorMessage : defaultErrorMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.715 -0400", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "B13516296C13D6EE31EF76EC4E897278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeSocketThrowException(SSLSocket socket,
            String errorMessage) throws IOException {
        dsTaint.addTaint(errorMessage);
        dsTaint.addTaint(socket.dsTaint);
        {
            HttpLog.v("validation error: " + errorMessage);
        } //End block
        {
            SSLSession session;
            session = socket.getSession();
            {
                session.invalidate();
            } //End block
            socket.close();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new SSLHandshakeException(errorMessage);
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("validation error: " + errorMessage);
        //}
        //if (socket != null) {
            //SSLSession session = socket.getSession();
            //if (session != null) {
                //session.invalidate();
            //}
            //socket.close();
        //}
        //throw new SSLHandshakeException(errorMessage);
    }

    
    private static final CertificateChainValidator sInstance
            = new CertificateChainValidator();
}

