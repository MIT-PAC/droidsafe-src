package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

class WNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.641 -0400", hash_original_method = "C00227C22ED402D319A853243DDBC230", hash_generated_method = "C00227C22ED402D319A853243DDBC230")
    public WNafMultiplier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.642 -0400", hash_original_method = "1459872133D83D08012D8F1A13CEC4DA", hash_generated_method = "3A34A1491AB41151E0B043DD67A00496")
    public byte[] windowNaf(byte width, BigInteger k) {
        addTaint(k.getTaint());
        addTaint(width);
        byte[] wnaf = new byte[k.bitLength() + 1];
        short pow2wB = (short)(1 << width);
        BigInteger pow2wBI = BigInteger.valueOf(pow2wB);
        int i = 0;
        int length = 0;
        while
(k.signum() > 0)        
        {
    if(k.testBit(0))            
            {
                BigInteger remainder = k.mod(pow2wBI);
    if(remainder.testBit(width - 1))                
                {
                    wnaf[i] = (byte)(remainder.intValue() - pow2wB);
                } //End block
                else
                {
                    wnaf[i] = (byte)remainder.intValue();
                } //End block
                k = k.subtract(BigInteger.valueOf(wnaf[i]));
                length = i;
            } //End block
            else
            {
                wnaf[i] = 0;
            } //End block
            k = k.shiftRight(1);
            i++;
        } //End block
        length++;
        byte[] wnafShort = new byte[length];
        System.arraycopy(wnaf, 0, wnafShort, 0, length);
        byte[] var3D494D5E7FA819DFA7E1C077558ED5F0_569672865 = (wnafShort);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_925027370 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_925027370;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.649 -0400", hash_original_method = "6B924519E3A0D968D1CF685546CDD2FF", hash_generated_method = "979329B5DC2FAE2129A6024B52E5C3A3")
    public ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo) {
        addTaint(preCompInfo.getTaint());
        addTaint(k.getTaint());
        addTaint(p.getTaint());
        WNafPreCompInfo wnafPreCompInfo;
    if((preCompInfo != null) && (preCompInfo instanceof WNafPreCompInfo))        
        {
            wnafPreCompInfo = (WNafPreCompInfo)preCompInfo;
        } //End block
        else
        {
            wnafPreCompInfo = new WNafPreCompInfo();
        } //End block
        int m = k.bitLength();
        byte width;
        int reqPreCompLen;
    if(m < 13)        
        {
            width = 2;
            reqPreCompLen = 1;
        } //End block
        else
        {
    if(m < 41)            
            {
                width = 3;
                reqPreCompLen = 2;
            } //End block
            else
            {
    if(m < 121)                
                {
                    width = 4;
                    reqPreCompLen = 4;
                } //End block
                else
                {
    if(m < 337)                    
                    {
                        width = 5;
                        reqPreCompLen = 8;
                    } //End block
                    else
                    {
    if(m < 897)                        
                        {
                            width = 6;
                            reqPreCompLen = 16;
                        } //End block
                        else
                        {
    if(m < 2305)                            
                            {
                                width = 7;
                                reqPreCompLen = 32;
                            } //End block
                            else
                            {
                                width = 8;
                                reqPreCompLen = 127;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        int preCompLen = 1;
        ECPoint[] preComp = wnafPreCompInfo.getPreComp();
        ECPoint twiceP = wnafPreCompInfo.getTwiceP();
    if(preComp == null)        
        {
            preComp = new ECPoint[]{ p };
        } //End block
        else
        {
            preCompLen = preComp.length;
        } //End block
    if(twiceP == null)        
        {
            twiceP = p.twice();
        } //End block
    if(preCompLen < reqPreCompLen)        
        {
            ECPoint[] oldPreComp = preComp;
            preComp = new ECPoint[reqPreCompLen];
            System.arraycopy(oldPreComp, 0, preComp, 0, preCompLen);
for(int i = preCompLen;i < reqPreCompLen;i++)
            {
                preComp[i] = twiceP.add(preComp[i - 1]);
            } //End block
        } //End block
        byte[] wnaf = windowNaf(width, k);
        int l = wnaf.length;
        ECPoint q = p.getCurve().getInfinity();
for(int i = l - 1;i >= 0;i--)
        {
            q = q.twice();
    if(wnaf[i] != 0)            
            {
    if(wnaf[i] > 0)                
                {
                    q = q.add(preComp[(wnaf[i] - 1)/2]);
                } //End block
                else
                {
                    q = q.subtract(preComp[(-wnaf[i] - 1)/2]);
                } //End block
            } //End block
        } //End block
        wnafPreCompInfo.setPreComp(preComp);
        wnafPreCompInfo.setTwiceP(twiceP);
        p.setPreCompInfo(wnafPreCompInfo);
ECPoint varBEF1B7662E10AF6D5747729987514CB6_2050553681 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_2050553681.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_2050553681;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

