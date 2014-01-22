package org.bouncycastle.jce.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.PublicKey;

import org.bouncycastle.math.ec.ECPoint;

public interface ECPublicKey
    extends ECKey, PublicKey
{
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ECPoint getQ();
}
