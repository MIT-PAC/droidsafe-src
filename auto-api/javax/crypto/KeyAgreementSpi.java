package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyAgreementSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.091 -0400", hash_original_method = "63241E16415E7B15EEAD7BA66A194D2D", hash_generated_method = "888DE129141231ECBF5F507BB6FEC590")
    public  KeyAgreementSpi() {
        
    }

    
    protected abstract Key engineDoPhase(Key key, boolean lastPhase)
            throws InvalidKeyException, IllegalStateException;

    
    protected abstract byte[] engineGenerateSecret()
            throws IllegalStateException;

    
    protected abstract int engineGenerateSecret(byte[] sharedSecret, int offset)
            throws IllegalStateException, ShortBufferException;

    
    protected abstract SecretKey engineGenerateSecret(String algorithm)
            throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException;

    
    protected abstract void engineInit(Key key, SecureRandom random)
            throws InvalidKeyException;

    
    protected abstract void engineInit(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException;

    
}

