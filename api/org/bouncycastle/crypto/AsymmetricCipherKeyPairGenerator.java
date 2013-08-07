package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface AsymmetricCipherKeyPairGenerator
{
    
    public void init(KeyGenerationParameters param);

    
    public AsymmetricCipherKeyPair generateKeyPair();
}
