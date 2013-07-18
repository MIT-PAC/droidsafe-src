package org.bouncycastle.crypto;

// Droidsafe Imports

public interface AsymmetricCipherKeyPairGenerator
{
    
    public void init(KeyGenerationParameters param);

    
    public AsymmetricCipherKeyPair generateKeyPair();
}
