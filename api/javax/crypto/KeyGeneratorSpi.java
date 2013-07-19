package javax.crypto;

// Droidsafe Imports
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class KeyGeneratorSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.235 -0400", hash_original_method = "A75599FEFECBB1DE286B9919E5114FFE", hash_generated_method = "BB8AE1BD551B5F61A4E9C70D5974A167")
    public  KeyGeneratorSpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract SecretKey engineGenerateKey();

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidAlgorithmParameterException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(int keysize, SecureRandom random);

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(SecureRandom random);

    
}

