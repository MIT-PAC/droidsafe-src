package javax.net.ssl;

// Droidsafe Imports
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class TrustManagerFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.842 -0400", hash_original_method = "A9501ACA551B0C72B8BE137F9D419E50", hash_generated_method = "A8B11A5AB68CA4B531481F488581B329")
    public  TrustManagerFactorySpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(KeyStore ks) throws KeyStoreException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    
    @DSModeled(DSC.SAFE)
    protected abstract TrustManager[] engineGetTrustManagers();

    
}

