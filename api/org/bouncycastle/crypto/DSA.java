package org.bouncycastle.crypto;

// Droidsafe Imports
import java.math.BigInteger;

public interface DSA
{
    
    public void init(boolean forSigning, CipherParameters param);

    
    public BigInteger[] generateSignature(byte[] message);

    
    public boolean verifySignature(byte[] message, BigInteger  r, BigInteger s);
}
