package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HostnameVerifier {
    
    boolean verify(String hostname, SSLSession session);
}
