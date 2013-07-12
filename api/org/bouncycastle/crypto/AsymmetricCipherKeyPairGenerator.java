package org.bouncycastle.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface AsymmetricCipherKeyPairGenerator
{
    
    public void init(KeyGenerationParameters param);

    
    public AsymmetricCipherKeyPair generateKeyPair();
}
