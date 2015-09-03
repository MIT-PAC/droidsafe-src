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

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;






public class ECNamedCurveParameterSpec extends ECParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.781 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String  name;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.783 -0500", hash_original_method = "26C644EB7C653DDD4CB6B37A75A99655", hash_generated_method = "203FF8697A5562557423017A7FC1C141")
    
public ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n)
    {
        super(curve, G, n);

        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.786 -0500", hash_original_method = "6202179398236C8F6061917C30684FB7", hash_generated_method = "F5A7956101ED1E68F1969EE24A3211BF")
    
public ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h)
    {
        super(curve, G, n, h);

        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.789 -0500", hash_original_method = "8EFB3A2E9C5B967CAF71EC98D8241ACE", hash_generated_method = "1035EB5F2E0113C27A99CDA7CA116AAA")
    
public ECNamedCurveParameterSpec(
        String      name,
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed)
    {
        super(curve, G, n, h, seed);

        this.name = name;
    }

    /**
     * return the name of the curve the EC domain parameters belong to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.791 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName()
    {
        return name;
    }

    
}

