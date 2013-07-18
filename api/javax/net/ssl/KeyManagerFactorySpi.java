package javax.net.ssl;

// Droidsafe Imports
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class KeyManagerFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.646 -0400", hash_original_method = "6A7E81CC9CE1799ACFD008A7DC048460", hash_generated_method = "93A65C456CF3A0D713ED787ED5389AFC")
    public  KeyManagerFactorySpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    
    @DSModeled(DSC.SAFE)
    protected abstract KeyManager[] engineGetKeyManagers();

    
}

