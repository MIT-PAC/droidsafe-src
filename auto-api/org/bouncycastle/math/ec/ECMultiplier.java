package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

interface ECMultiplier
{
    
    ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo);
}
