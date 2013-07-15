package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyGeneratorSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.282 -0400", hash_original_method = "A75599FEFECBB1DE286B9919E5114FFE", hash_generated_method = "BB8AE1BD551B5F61A4E9C70D5974A167")
    public  KeyGeneratorSpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract SecretKey engineGenerateKey();

    
    protected abstract void engineInit(AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidAlgorithmParameterException;

    
    protected abstract void engineInit(int keysize, SecureRandom random);

    
    protected abstract void engineInit(SecureRandom random);

    
}

