package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class KeyFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.329 -0400", hash_original_method = "AF4BD510DBC14C57BFA28DAEDECC0ECB", hash_generated_method = "AF4BD510DBC14C57BFA28DAEDECC0ECB")
        public KeyFactorySpi ()
    {
    }


    protected abstract PublicKey engineGeneratePublic(KeySpec keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract PrivateKey engineGeneratePrivate(KeySpec keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> keySpec)
                                    throws InvalidKeySpecException;

    
    protected abstract Key engineTranslateKey(Key key) throws InvalidKeyException;

    
}

