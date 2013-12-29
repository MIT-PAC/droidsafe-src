package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public interface BasicAgreement
{
    
    public void init(CipherParameters param);

    
    public BigInteger calculateAgreement(CipherParameters pubKey);
}
