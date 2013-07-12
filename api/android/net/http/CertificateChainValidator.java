package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.929 -0400", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "249781E5FCB4B7182831503E258AE636")
    private  CertificateChainValidator() {
        // ---------- Original Method ----------
    }

    
        public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.930 -0400", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "678C6184B8F1F4881AD2DEEDE7373600")
    public SslError doHandshakeAndValidateServerCertificates(
            HttpsConnection connection, SSLSocket sslSocket, String domain) throws IOException {
        addTaint(domain.getTaint());
        addTaint(sslSocket.getTaint());
        addTaint(connection.getTaint());
        SSLSession sslSession = sslSocket.getSession();
    if(!sslSession.isValid())        
        {
            closeSocketThrowException(sslSocket, "failed to perform SSL handshake");
        } //End block
        Certificate[] peerCertificates = sslSocket.getSession().getPeerCertificates();
    if(peerCertificates == null || peerCertificates.length == 0)        
        {
            closeSocketThrowException(
                sslSocket, "failed to retrieve peer certificates");
        } //End block
        else
        {
    if(connection != null)            
            {
    if(peerCertificates[0] != null)                
                {
                    connection.setCertificate(
                        new SslCertificate((X509Certificate)peerCertificates[0]));
                } //End block
            } //End block
        } //End block
SslError var5995AA76FBBB5331C788BBF94383B022_2086607111 =         verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA");
        var5995AA76FBBB5331C788BBF94383B022_2086607111.addTaint(taint);
        return var5995AA76FBBB5331C788BBF94383B022_2086607111;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.931 -0400", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "05E0FE804B6759B78541079DC94C2EE6")
    private void closeSocketThrowException(
            SSLSocket socket, String errorMessage, String defaultErrorMessage) throws IOException {
        addTaint(defaultErrorMessage.getTaint());
        addTaint(errorMessage.getTaint());
        addTaint(socket.getTaint());
        closeSocketThrowException(
            socket, errorMessage != null ? errorMessage : defaultErrorMessage);
        // ---------- Original Method ----------
        //closeSocketThrowException(
            //socket, errorMessage != null ? errorMessage : defaultErrorMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.931 -0400", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "EEF79FB8E32C667459C0C833C5AEACAF")
    private void closeSocketThrowException(SSLSocket socket,
            String errorMessage) throws IOException {
        addTaint(errorMessage.getTaint());
        addTaint(socket.getTaint());
    if(HttpLog.LOGV)        
        {
            HttpLog.v("validation error: " + errorMessage);
        } //End block
    if(socket != null)        
        {
            SSLSession session = socket.getSession();
    if(session != null)            
            {
                session.invalidate();
            } //End block
            socket.close();
        } //End block
        SSLHandshakeException varED9E2837C945A63AD04740882155F953_34834657 = new SSLHandshakeException(errorMessage);
        varED9E2837C945A63AD04740882155F953_34834657.addTaint(taint);
        throw varED9E2837C945A63AD04740882155F953_34834657;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.932 -0400", hash_original_field = "75E9E3354073877B40EBA5B806297F19", hash_generated_field = "7025A8FFA19D23C3239F45040E6EE9F0")

    private static final CertificateChainValidator sInstance = new CertificateChainValidator();
}

