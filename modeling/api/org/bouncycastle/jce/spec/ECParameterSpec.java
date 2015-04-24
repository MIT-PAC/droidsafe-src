/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.547 -0500", hash_original_field = "704A3581F062D90BBFC67E94998B89B2", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve     curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.551 -0500", hash_original_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[]      seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.553 -0500", hash_original_field = "366E3F687F847EAA0B95F373906832D0", hash_generated_field = "316439DA3E4C6914572EC3C942E00A79")

    private ECPoint     G;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.555 -0500", hash_original_field = "C5269AA669EF1E6636D1450EA530C9C5", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger  n;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.558 -0500", hash_original_field = "FF6F1CE798488519FE43D7992CD2DB11", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger  h;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.560 -0500", hash_original_method = "E581F0D1251777D8F8C2673628C02E33", hash_generated_method = "6693C7808DAEDA441E31E7EB0DB2886F")
    
public ECParameterSpec(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n)
    {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = BigInteger.valueOf(1);
        this.seed = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.563 -0500", hash_original_method = "3844E6DD38495376CE54503FB9102730", hash_generated_method = "DBB6F954008C4893FEE3B244166C656C")
    
public ECParameterSpec(
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.565 -0500", hash_original_method = "B4859A7864ACD85B3E9FEBE41FAB289F", hash_generated_method = "9A41323F115F73D05FF53C109CDAAC03")
    
public ECParameterSpec(
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

    /**
     * return the curve along which the base point lies.
     * @return the curve
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.567 -0500", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "B9031E139E03D127788DF39899FDE161")
    
public ECCurve getCurve()
    {
        return curve;
    }

    /**
     * return the base point we are using for these domain parameters.
     * @return the base point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.570 -0500", hash_original_method = "ED03A647C1E8B017F749575ECBD102C0", hash_generated_method = "8F72A0CA261ED329671D4D92B63A30EC")
    
public ECPoint getG()
    {
        return G;
    }

    /**
     * return the order N of G
     * @return the order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.572 -0500", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "02928BD4257B76FF9B6C6F96BB0BD425")
    
public BigInteger getN()
    {
        return n;
    }

    /**
     * return the cofactor H to the order of G.
     * @return the cofactor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.574 -0500", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "B8364F7A0487534C88342679DF56B12F")
    
public BigInteger getH()
    {
        return h;
    }

    /**
     * return the seed used to generate this curve (if available).
     * @return the random seed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.576 -0500", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B9121A38AE643366EC4B8CEEAF78AD62")
    
public byte[] getSeed()
    {
        return seed;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.579 -0500", hash_original_method = "4D0C476A07E0F700EE67C6B7126A56CA", hash_generated_method = "394C1523507E9B998F8E0755C7E889C9")
    
public boolean equals(Object o)
    {
        if (!(o instanceof ECParameterSpec))
        {
            return false;
        }

        ECParameterSpec other = (ECParameterSpec)o;

        return this.getCurve().equals(other.getCurve()) && this.getG().equals(other.getG());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.582 -0500", hash_original_method = "222EBFC3DE5F327343BF00A614895E1C", hash_generated_method = "21D68A097E2BCC68EBC27774F7E8B2FA")
    
public int hashCode()
    {
        return this.getCurve().hashCode() ^ this.getG().hashCode();
    }
    
}

