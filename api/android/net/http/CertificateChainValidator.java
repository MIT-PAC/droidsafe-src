package android.net.http;

// Droidsafe Imports
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

import com.android.internal.net.DomainNameValidator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class CertificateChainValidator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.818 -0400", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "249781E5FCB4B7182831503E258AE636")
    private  CertificateChainValidator() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.819 -0400", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "9517332374590B36965353B44FC1C720")
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
SslError var5995AA76FBBB5331C788BBF94383B022_758865090 =         verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA");
        var5995AA76FBBB5331C788BBF94383B022_758865090.addTaint(taint);
        return var5995AA76FBBB5331C788BBF94383B022_758865090;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.820 -0400", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "05E0FE804B6759B78541079DC94C2EE6")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.821 -0400", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "FA44059FF83F8D6ACDDB4D15F416CA03")
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
        SSLHandshakeException varED9E2837C945A63AD04740882155F953_2071866238 = new SSLHandshakeException(errorMessage);
        varED9E2837C945A63AD04740882155F953_2071866238.addTaint(taint);
        throw varED9E2837C945A63AD04740882155F953_2071866238;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.821 -0400", hash_original_field = "75E9E3354073877B40EBA5B806297F19", hash_generated_field = "7025A8FFA19D23C3239F45040E6EE9F0")

    private static final CertificateChainValidator sInstance = new CertificateChainValidator();
}

