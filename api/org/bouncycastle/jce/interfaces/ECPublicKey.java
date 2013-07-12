package org.bouncycastle.jce.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.PublicKey;
import org.bouncycastle.math.ec.ECPoint;

public interface ECPublicKey
    extends ECKey, PublicKey
{
    
    public ECPoint getQ();
}
