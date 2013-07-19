package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import java.math.BigInteger;
import java.security.PrivateKey;

public interface ECPrivateKey
    extends ECKey, PrivateKey
{
    
    public BigInteger getD();
}
