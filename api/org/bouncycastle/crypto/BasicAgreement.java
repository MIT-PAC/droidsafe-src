package org.bouncycastle.crypto;

// Droidsafe Imports
import java.math.BigInteger;

public interface BasicAgreement
{
    
    public void init(CipherParameters param);

    
    public BigInteger calculateAgreement(CipherParameters pubKey);
}
