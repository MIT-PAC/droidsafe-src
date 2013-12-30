package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;






public class ECDomainParameters implements ECConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.217 -0500", hash_original_field = "704A3581F062D90BBFC67E94998B89B2", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve     curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.220 -0500", hash_original_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17", hash_generated_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17")

    byte[]      seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.222 -0500", hash_original_field = "366E3F687F847EAA0B95F373906832D0", hash_generated_field = "366E3F687F847EAA0B95F373906832D0")

    ECPoint     G;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.224 -0500", hash_original_field = "C5269AA669EF1E6636D1450EA530C9C5", hash_generated_field = "C5269AA669EF1E6636D1450EA530C9C5")

    BigInteger  n;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.226 -0500", hash_original_field = "FF6F1CE798488519FE43D7992CD2DB11", hash_generated_field = "FF6F1CE798488519FE43D7992CD2DB11")

    BigInteger  h;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.229 -0500", hash_original_method = "B7AFA44677648B19BDC10EE7871A7F9A", hash_generated_method = "0EEF991736E1B4AD6449088F001DFBB3")
    
public ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n)
    {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = ONE;
        this.seed = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.232 -0500", hash_original_method = "BD2A03126FF30335329E3F095211D4D0", hash_generated_method = "F453801E7116031378A0EF816A77F8F3")
    
public ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h)
    {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.235 -0500", hash_original_method = "F7FA10DE23B67EFC919789142B22AEA5", hash_generated_method = "65E79E53471CC2B7182F630FC5758BDA")
    
public ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed)
    {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = seed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.237 -0500", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "B9031E139E03D127788DF39899FDE161")
    
public ECCurve getCurve()
    {
        return curve;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.239 -0500", hash_original_method = "ED03A647C1E8B017F749575ECBD102C0", hash_generated_method = "8F72A0CA261ED329671D4D92B63A30EC")
    
public ECPoint getG()
    {
        return G;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.241 -0500", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "02928BD4257B76FF9B6C6F96BB0BD425")
    
public BigInteger getN()
    {
        return n;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.243 -0500", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "B8364F7A0487534C88342679DF56B12F")
    
public BigInteger getH()
    {
        return h;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.246 -0500", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B9121A38AE643366EC4B8CEEAF78AD62")
    
public byte[] getSeed()
    {
        return seed;
    }

    
}

