package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public interface X509TrustManager extends TrustManager {

    
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException;


    
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException;

    
    public X509Certificate[] getAcceptedIssuers();
}
