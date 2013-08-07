package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.SSLPeerUnverifiedException;





public abstract class SecureCacheResponse extends CacheResponse {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.359 -0400", hash_original_method = "2B60842F322CE42A5832F1BBB0BB3BBC", hash_generated_method = "14E16CBBA191C94EBFE2CC1A18224220")
    public  SecureCacheResponse() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String getCipherSuite();

    
    @DSModeled(DSC.SAFE)
    public abstract List<Certificate> getLocalCertificateChain();

    
    @DSModeled(DSC.SAFE)
    public abstract List<Certificate> getServerCertificateChain()
            throws SSLPeerUnverifiedException;

    
    @DSModeled(DSC.SAFE)
    public abstract Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException;

    
    @DSModeled(DSC.SAFE)
    public abstract Principal getLocalPrincipal();

    
}

