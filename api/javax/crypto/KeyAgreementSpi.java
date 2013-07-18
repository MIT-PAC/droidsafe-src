package javax.crypto;

// Droidsafe Imports
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class KeyAgreementSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.218 -0400", hash_original_method = "63241E16415E7B15EEAD7BA66A194D2D", hash_generated_method = "888DE129141231ECBF5F507BB6FEC590")
    public  KeyAgreementSpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract Key engineDoPhase(Key key, boolean lastPhase)
            throws InvalidKeyException, IllegalStateException;

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineGenerateSecret()
            throws IllegalStateException;

    
    @DSModeled(DSC.SAFE)
    protected abstract int engineGenerateSecret(byte[] sharedSecret, int offset)
            throws IllegalStateException, ShortBufferException;

    
    @DSModeled(DSC.SAFE)
    protected abstract SecretKey engineGenerateSecret(String algorithm)
            throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(Key key, SecureRandom random)
            throws InvalidKeyException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException;

    
}

