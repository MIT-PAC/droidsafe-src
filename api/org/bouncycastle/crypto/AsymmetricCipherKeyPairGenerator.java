package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface AsymmetricCipherKeyPairGenerator
{
    
    public void init(KeyGenerationParameters param);

    
    public AsymmetricCipherKeyPair generateKeyPair();
}
