package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

class FpNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.665 -0400", hash_original_method = "BABE471E2E455F4576B9B6A994FEF2CC", hash_generated_method = "BABE471E2E455F4576B9B6A994FEF2CC")
    public FpNafMultiplier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.665 -0400", hash_original_method = "DE008A6A0942FE352BE58D2F6B7E9069", hash_generated_method = "88FA32AAE698F044B17AA04CE7D5744F")
    public ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo) {
        addTaint(preCompInfo.getTaint());
        addTaint(k.getTaint());
        addTaint(p.getTaint());
        BigInteger e = k;
        BigInteger h = e.multiply(BigInteger.valueOf(3));
        ECPoint neg = p.negate();
        ECPoint R = p;
for(int i = h.bitLength() - 2;i > 0;--i)
        {
            R = R.twice();
            boolean hBit = h.testBit(i);
            boolean eBit = e.testBit(i);
            if(hBit != eBit)            
            {
                R = R.add(hBit ? p : neg);
            } //End block
        } //End block
ECPoint varB1A707F4AE63CA846D8DEED4B4536429_1531291136 =         R;
        varB1A707F4AE63CA846D8DEED4B4536429_1531291136.addTaint(taint);
        return varB1A707F4AE63CA846D8DEED4B4536429_1531291136;
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

