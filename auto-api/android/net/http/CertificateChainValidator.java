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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.816 -0400", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "249781E5FCB4B7182831503E258AE636")
    private  CertificateChainValidator() {
        // ---------- Original Method ----------
    }

    
        public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.838 -0400", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "4B01A721AB43D2437C87A7E8D09104BD")
    public SslError doHandshakeAndValidateServerCertificates(
            HttpsConnection connection, SSLSocket sslSocket, String domain) throws IOException {
        SslError varB4EAC82CA7396A68D541C85D26508E83_487650217 = null; //Variable for return #1
        SSLSession sslSession;
        sslSession = sslSocket.getSession();
        {
            boolean var93330143B7CECBEE557BABA2F99073AF_11637667 = (!sslSession.isValid());
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
        varB4EAC82CA7396A68D541C85D26508E83_487650217 = verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA");
        addTaint(connection.getTaint());
        addTaint(sslSocket.getTaint());
        addTaint(domain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_487650217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_487650217;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.839 -0400", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "6DEC096A30D6F80CF1BE104116298E50")
    private void closeSocketThrowException(
            SSLSocket socket, String errorMessage, String defaultErrorMessage) throws IOException {
        closeSocketThrowException(
            socket, errorMessage != null ? errorMessage : defaultErrorMessage);
        addTaint(socket.getTaint());
        addTaint(errorMessage.getTaint());
        addTaint(defaultErrorMessage.getTaint());
        // ---------- Original Method ----------
        //closeSocketThrowException(
            //socket, errorMessage != null ? errorMessage : defaultErrorMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.840 -0400", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "05AE6781C64EA0D84CD08CC9849BF78C")
    private void closeSocketThrowException(SSLSocket socket,
            String errorMessage) throws IOException {
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
        addTaint(socket.getTaint());
        addTaint(errorMessage.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.841 -0400", hash_original_field = "75E9E3354073877B40EBA5B806297F19", hash_generated_field = "4B8BDD7DAB8BC39946C710FF23835B77")

    private static CertificateChainValidator sInstance = new CertificateChainValidator();
}

