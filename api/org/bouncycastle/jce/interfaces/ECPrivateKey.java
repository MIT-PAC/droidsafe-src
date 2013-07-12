package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.PrivateKey;

public interface ECPrivateKey
    extends ECKey, PrivateKey
{
    
    public BigInteger getD();
}
