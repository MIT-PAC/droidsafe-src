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
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public abstract class KeyManagerFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.537 -0400", hash_original_method = "6A7E81CC9CE1799ACFD008A7DC048460", hash_generated_method = "93A65C456CF3A0D713ED787ED5389AFC")
    public  KeyManagerFactorySpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract void engineInit(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException;

    
    protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    
    protected abstract KeyManager[] engineGetKeyManagers();

    
}

