package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

interface ECMultiplier
{
    
    ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo);
}
