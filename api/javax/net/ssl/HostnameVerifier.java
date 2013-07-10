package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface HostnameVerifier {
    
    boolean verify(String hostname, SSLSession session);
}
