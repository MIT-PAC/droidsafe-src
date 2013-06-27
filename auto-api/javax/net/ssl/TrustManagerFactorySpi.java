package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;

public abstract class TrustManagerFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.385 -0400", hash_original_method = "A9501ACA551B0C72B8BE137F9D419E50", hash_generated_method = "A8B11A5AB68CA4B531481F488581B329")
    public  TrustManagerFactorySpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract void engineInit(KeyStore ks) throws KeyStoreException;

    
    protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    
    protected abstract TrustManager[] engineGetTrustManagers();

    
}

