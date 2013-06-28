package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public abstract class SecureCacheResponse extends CacheResponse {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.704 -0400", hash_original_method = "2B60842F322CE42A5832F1BBB0BB3BBC", hash_generated_method = "14E16CBBA191C94EBFE2CC1A18224220")
    public  SecureCacheResponse() {
        // ---------- Original Method ----------
    }

    
    public abstract String getCipherSuite();

    
    public abstract List<Certificate> getLocalCertificateChain();

    
    public abstract List<Certificate> getServerCertificateChain()
            throws SSLPeerUnverifiedException;

    
    public abstract Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException;

    
    public abstract Principal getLocalPrincipal();

    
}

