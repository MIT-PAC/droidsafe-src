package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.643 -0400", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "249781E5FCB4B7182831503E258AE636")
    private  CertificateChainValidator() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.646 -0400", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "72F51D8A9F748E64E19290E4E9DD71C1")
    public SslError doHandshakeAndValidateServerCertificates(
            HttpsConnection connection, SSLSocket sslSocket, String domain) throws IOException {
        SslError varB4EAC82CA7396A68D541C85D26508E83_693308183 = null; 
        SSLSession sslSession = sslSocket.getSession();
        {
            boolean var93330143B7CECBEE557BABA2F99073AF_249523245 = (!sslSession.isValid());
            {
                closeSocketThrowException(sslSocket, "failed to perform SSL handshake");
            } 
        } 
        Certificate[] peerCertificates = sslSocket.getSession().getPeerCertificates();
        {
            closeSocketThrowException(
                sslSocket, "failed to retrieve peer certificates");
        } 
        {
            {
                {
                    connection.setCertificate(
                        new SslCertificate((X509Certificate)peerCertificates[0]));
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_693308183 = verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA");
        addTaint(connection.getTaint());
        addTaint(sslSocket.getTaint());
        addTaint(domain.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_693308183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_693308183;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.648 -0400", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "6DEC096A30D6F80CF1BE104116298E50")
    private void closeSocketThrowException(
            SSLSocket socket, String errorMessage, String defaultErrorMessage) throws IOException {
        closeSocketThrowException(
            socket, errorMessage != null ? errorMessage : defaultErrorMessage);
        addTaint(socket.getTaint());
        addTaint(errorMessage.getTaint());
        addTaint(defaultErrorMessage.getTaint());
        
        
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.648 -0400", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "96330B8C9B87CC0820607EBA834D30C4")
    private void closeSocketThrowException(SSLSocket socket,
            String errorMessage) throws IOException {
        {
            HttpLog.v("validation error: " + errorMessage);
        } 
        {
            SSLSession session = socket.getSession();
            {
                session.invalidate();
            } 
            socket.close();
        } 
        if (DroidSafeAndroidRuntime.control) throw new SSLHandshakeException(errorMessage);
        addTaint(socket.getTaint());
        addTaint(errorMessage.getTaint());
        
        
            
        
        
            
            
                
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.648 -0400", hash_original_field = "75E9E3354073877B40EBA5B806297F19", hash_generated_field = "7025A8FFA19D23C3239F45040E6EE9F0")

    private static final CertificateChainValidator sInstance = new CertificateChainValidator();
}

