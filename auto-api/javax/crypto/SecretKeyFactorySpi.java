package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class SecretKeyFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.208 -0400", hash_original_method = "37AA0CEAD968FA5AED19221177267C4C", hash_generated_method = "8301FE6EFDEBF0A35884933BA2E82161")
    public  SecretKeyFactorySpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract SecretKey engineGenerateSecret(KeySpec keySpec)
            throws InvalidKeySpecException;

    
    @SuppressWarnings("unchecked")
protected abstract KeySpec engineGetKeySpec(SecretKey key, Class keySpec)
            throws InvalidKeySpecException;

    
    protected abstract SecretKey engineTranslateKey(SecretKey key)
            throws InvalidKeyException;

    
}

