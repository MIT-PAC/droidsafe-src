package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class SecretKeyFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.368 -0400", hash_original_method = "37AA0CEAD968FA5AED19221177267C4C", hash_generated_method = "8301FE6EFDEBF0A35884933BA2E82161")
    public  SecretKeyFactorySpi() {
        
    }

    
    protected abstract SecretKey engineGenerateSecret(KeySpec keySpec)
            throws InvalidKeySpecException;

    
        @SuppressWarnings("unchecked")
protected abstract KeySpec engineGetKeySpec(SecretKey key, Class keySpec)
            throws InvalidKeySpecException;

    
    protected abstract SecretKey engineTranslateKey(SecretKey key)
            throws InvalidKeyException;

    
}

