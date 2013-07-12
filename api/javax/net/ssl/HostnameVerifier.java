package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HostnameVerifier {
    
    boolean verify(String hostname, SSLSession session);
}
