package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class KeyFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.907 -0400", hash_original_method = "54B4D82F193E9DD361521453DB006D9F", hash_generated_method = "54B4D82F193E9DD361521453DB006D9F")
    public KeyFactorySpi ()
    {
        //Synthesized constructor
    }


    protected abstract PublicKey engineGeneratePublic(KeySpec keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract PrivateKey engineGeneratePrivate(KeySpec keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract Key engineTranslateKey(Key key) throws InvalidKeyException;

    
}

