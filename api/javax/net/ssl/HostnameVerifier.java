package javax.net.ssl;

// Droidsafe Imports

public interface HostnameVerifier {
    
    boolean verify(String hostname, SSLSession session);
}
