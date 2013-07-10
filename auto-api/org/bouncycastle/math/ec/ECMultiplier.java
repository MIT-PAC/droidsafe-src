package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;

interface ECMultiplier
{
    
    ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo);
}
