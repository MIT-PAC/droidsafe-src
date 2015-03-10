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


package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public class ECAlgorithms {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.780 -0500", hash_original_method = "F48E0D5EA6C0E86FA4BAC23458A6895D", hash_generated_method = "A1CFEDCDA2D25AC533DB4D31967D0324")
    
public static ECPoint sumOfTwoMultiplies(ECPoint P, BigInteger a,
        ECPoint Q, BigInteger b)
    {
        ECCurve c = P.getCurve();
        if (!c.equals(Q.getCurve()))
        {
            throw new IllegalArgumentException("P and Q must be on same curve");
        }

        // Point multiplication for Koblitz curves (using WTNAF) beats Shamir's trick
        if (c instanceof ECCurve.F2m)
        {
            ECCurve.F2m f2mCurve = (ECCurve.F2m)c;
            if (f2mCurve.isKoblitz())
            {
                return P.multiply(a).add(Q.multiply(b));
            }
        }

        return implShamirsTrick(P, a, Q, b);
    }

    /*
     * "Shamir's Trick", originally due to E. G. Straus
     * (Addition chains of vectors. American Mathematical Monthly,
     * 71(7):806-808, Aug./Sept. 1964)
     * <pre>
     * Input: The points P, Q, scalar k = (km?, ... , k1, k0)
     * and scalar l = (lm?, ... , l1, l0).
     * Output: R = k * P + l * Q.
     * 1: Z <- P + Q
     * 2: R <- O
     * 3: for i from m-1 down to 0 do
     * 4:        R <- R + R        {point doubling}
     * 5:        if (ki = 1) and (li = 0) then R <- R + P end if
     * 6:        if (ki = 0) and (li = 1) then R <- R + Q end if
     * 7:        if (ki = 1) and (li = 1) then R <- R + Z end if
     * 8: end for
     * 9: return R
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.783 -0500", hash_original_method = "9FF3335214D46EC0C51CC23F1021FA73", hash_generated_method = "E7F2FDA4AA1BA81ECA9694627A5B7572")
    
public static ECPoint shamirsTrick(ECPoint P, BigInteger k,
        ECPoint Q, BigInteger l)
    {
        if (!P.getCurve().equals(Q.getCurve()))
        {
            throw new IllegalArgumentException("P and Q must be on same curve");
        }

        return implShamirsTrick(P, k, Q, l);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.786 -0500", hash_original_method = "CD0CA0D93D25834154450637B9C6752C", hash_generated_method = "53301DB5FBC8B137560781DF04CC9B00")
    
private static ECPoint implShamirsTrick(ECPoint P, BigInteger k,
        ECPoint Q, BigInteger l)
    {
        int m = Math.max(k.bitLength(), l.bitLength());
        ECPoint Z = P.add(Q);
        ECPoint R = P.getCurve().getInfinity();

        for (int i = m - 1; i >= 0; --i)
        {
            R = R.twice();

            if (k.testBit(i))
            {
                if (l.testBit(i))
                {
                    R = R.add(Z);
                }
                else
                {
                    R = R.add(P);
                }
            }
            else
            {
                if (l.testBit(i))
                {
                    R = R.add(Q);
                }
            }
        }

        return R;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.369 -0400", hash_original_method = "70F9F0F5BEFD5512C9E75259E8F999A7", hash_generated_method = "70F9F0F5BEFD5512C9E75259E8F999A7")
    public ECAlgorithms ()
    {
        //Synthesized constructor
    }
    
}

