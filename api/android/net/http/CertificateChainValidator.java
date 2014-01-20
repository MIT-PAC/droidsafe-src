package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

class CertificateChainValidator {

    /**
     * @return The singleton instance of the certificates chain validator
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.195 -0500", hash_original_method = "0F243599E8016F5D4F15CBBF70F43AE6", hash_generated_method = "02D8009B6E1299C3B3A212C7B30F1CD2")
    
public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    /**
     * Similar to doHandshakeAndValidateServerCertificates but exposed to JNI for use
     * by Chromium HTTPS stack to validate the cert chain.
     * @param certChain The bytes for certificates in ASN.1 DER encoded certificates format.
     * @param domain The full website hostname and domain
     * @param authType The authentication type for the cert chain
     * @return An SSL error object if there is an error and null otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.202 -0500", hash_original_method = "18267EA0A2027BF86F0A85466039921C", hash_generated_method = "C96CA958F20C3743481DCCEA10551E2D")
    
public static SslError verifyServerCertificates(
        byte[][] certChain, String domain, String authType)
        throws IOException {

        if (certChain == null || certChain.length == 0) {
            throw new IllegalArgumentException("bad certificate chain");
        }

        X509Certificate[] serverCertificates = new X509Certificate[certChain.length];

        for (int i = 0; i < certChain.length; ++i) {
            serverCertificates[i] = new X509CertImpl(certChain[i]);
        }

        return verifyServerDomainAndCertificates(serverCertificates, domain, authType);
    }

    /**
     * Common code of doHandshakeAndValidateServerCertificates and verifyServerCertificates.
     * Calls DomainNamevalidator to verify the domain, and TrustManager to verify the certs.
     * @param chain the cert chain in X509 cert format.
     * @param domain The full website hostname and domain
     * @param authType The authentication type for the cert chain
     * @return An SSL error object if there is an error and null otherwise
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.205 -0500", hash_original_method = "2785BD3BA93222E8AB5B460FDCCCF9E9", hash_generated_method = "3A258E0C2116CB2D762D495F6C5139B6")
    
private static SslError verifyServerDomainAndCertificates(
            X509Certificate[] chain, String domain, String authType)
            throws IOException {
        // check if the first certificate in the chain is for this site
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
            return null;  // No errors.
        } catch (CertificateException e) {
            if (HttpLog.LOGV) {
                HttpLog.v("failed to validate the certificate chain, error: " +
                    e.getMessage());
            }
            return new SslError(SslError.SSL_UNTRUSTED, currCertificate);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.192 -0500", hash_original_field = "C561100F7CA9F2EEB7E58CFBB92AFD83", hash_generated_field = "7025A8FFA19D23C3239F45040E6EE9F0")

    private static final CertificateChainValidator sInstance
            = new CertificateChainValidator();

    /**
     * Creates a new certificate chain validator. This is a private constructor.
     * If you need a Certificate chain validator, call getInstance().
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.197 -0500", hash_original_method = "2F959D748394792DE55923600092C8E9", hash_generated_method = "D74C4DFAD21CEF4FCC29B841FA38D1DA")
    
private CertificateChainValidator() {}

    /**
     * Performs the handshake and server certificates validation
     * Notice a new chain will be rebuilt by tracing the issuer and subject
     * before calling checkServerTrusted().
     * And if the last traced certificate is self issued and it is expired, it
     * will be dropped.
     * @param sslSocket The secure connection socket
     * @param domain The website domain
     * @return An SSL error object if there is an error and null otherwise
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.200 -0500", hash_original_method = "5B87AA85F76367E84F6A87186CEADEE5", hash_generated_method = "216E1F74EE288CB17CA845827E206614")
    
public SslError doHandshakeAndValidateServerCertificates(
            HttpsConnection connection, SSLSocket sslSocket, String domain)
            throws IOException {
        // get a valid SSLSession, close the socket if we fail
        SSLSession sslSession = sslSocket.getSession();
        if (!sslSession.isValid()) {
            closeSocketThrowException(sslSocket, "failed to perform SSL handshake");
        }

        // retrieve the chain of the server peer certificates
        Certificate[] peerCertificates =
            sslSocket.getSession().getPeerCertificates();

        if (peerCertificates == null || peerCertificates.length == 0) {
            closeSocketThrowException(
                sslSocket, "failed to retrieve peer certificates");
        } else {
            // update the SSL certificate associated with the connection
            if (connection != null) {
                if (peerCertificates[0] != null) {
                    connection.setCertificate(
                        new SslCertificate((X509Certificate)peerCertificates[0]));
                }
            }
        }

        return verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, domain, "RSA");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.207 -0500", hash_original_method = "768C411890F29309D1F137AF28998331", hash_generated_method = "10AEA3ED4E1BC4F19C79B4C82569D499")
    
private void closeSocketThrowException(
            SSLSocket socket, String errorMessage, String defaultErrorMessage)
            throws IOException {
        closeSocketThrowException(
            socket, errorMessage != null ? errorMessage : defaultErrorMessage);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.210 -0500", hash_original_method = "8DFE74A9ABEF1F34DE8E6B965DB51B9B", hash_generated_method = "6E9E025EFFEDA554EA38003B6695FACD")
    
private void closeSocketThrowException(SSLSocket socket,
            String errorMessage) throws IOException {
        if (HttpLog.LOGV) {
            HttpLog.v("validation error: " + errorMessage);
        }

        if (socket != null) {
            SSLSession session = socket.getSession();
            if (session != null) {
                session.invalidate();
            }

            socket.close();
        }

        throw new SSLHandshakeException(errorMessage);
    }
}

