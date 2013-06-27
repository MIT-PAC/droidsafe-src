package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

class FpNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.277 -0400", hash_original_method = "BABE471E2E455F4576B9B6A994FEF2CC", hash_generated_method = "BABE471E2E455F4576B9B6A994FEF2CC")
    public FpNafMultiplier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.287 -0400", hash_original_method = "DE008A6A0942FE352BE58D2F6B7E9069", hash_generated_method = "769DFE74E79235F94703EE0EBEF1C9CA")
    public ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo) {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_447094753 = null; //Variable for return #1
        BigInteger e;
        e = k;
        BigInteger h;
        h = e.multiply(BigInteger.valueOf(3));
        ECPoint neg;
        neg = p.negate();
        ECPoint R;
        R = p;
        {
            int i;
            i = h.bitLength() - 2;
            {
                R = R.twice();
                boolean hBit;
                hBit = h.testBit(i);
                boolean eBit;
                eBit = e.testBit(i);
                {
                    R = R.add(hBit ? p : neg);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_447094753 = R;
        addTaint(p.getTaint());
        addTaint(k.getTaint());
        addTaint(preCompInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_447094753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_447094753;
        // ---------- Original Method ----------
        //BigInteger e = k;
        //BigInteger h = e.multiply(BigInteger.valueOf(3));
        //ECPoint neg = p.negate();
        //ECPoint R = p;
        //for (int i = h.bitLength() - 2; i > 0; --i)
        //{             
            //R = R.twice();
            //boolean hBit = h.testBit(i);
            //boolean eBit = e.testBit(i);
            //if (hBit != eBit)
            //{
                //R = R.add(hBit ? p : neg);
            //}
        //}
        //return R;
    }

    
}

