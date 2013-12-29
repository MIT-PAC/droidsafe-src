package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

interface ECMultiplier
{
    
    ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo);
}
