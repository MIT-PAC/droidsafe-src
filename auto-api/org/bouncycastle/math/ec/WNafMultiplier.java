package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;

class WNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.893 -0400", hash_original_method = "C00227C22ED402D319A853243DDBC230", hash_generated_method = "C00227C22ED402D319A853243DDBC230")
    public WNafMultiplier ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.894 -0400", hash_original_method = "1459872133D83D08012D8F1A13CEC4DA", hash_generated_method = "B3D368199CFD518FC1CCB87BD4860BAB")
    public byte[] windowNaf(byte width, BigInteger k) {
        byte[] wnaf = new byte[k.bitLength() + 1];
        short pow2wB = (short)(1 << width);
        BigInteger pow2wBI = BigInteger.valueOf(pow2wB);
        int i = 0;
        int length = 0;
        {
            boolean var90BEB270CA27021819A075365AD08434_102403106 = (k.signum() > 0);
            {
                {
                    boolean var383F976E410154A745E3FC06B83A2214_797256411 = (k.testBit(0));
                    {
                        BigInteger remainder = k.mod(pow2wBI);
                        {
                            boolean var1DBB8A5A29EBE1DCC5BC003EFB8FD3E2_1073894253 = (remainder.testBit(width - 1));
                            {
                                wnaf[i] = (byte)(remainder.intValue() - pow2wB);
                            } 
                            {
                                wnaf[i] = (byte)remainder.intValue();
                            } 
                        } 
                        k = k.subtract(BigInteger.valueOf(wnaf[i]));
                        length = i;
                    } 
                    {
                        wnaf[i] = 0;
                    } 
                } 
                k = k.shiftRight(1);
            } 
        } 
        byte[] wnafShort = new byte[length];
        System.arraycopy(wnaf, 0, wnafShort, 0, length);
        addTaint(width);
        addTaint(k.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1145183222 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1145183222;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.897 -0400", hash_original_method = "6B924519E3A0D968D1CF685546CDD2FF", hash_generated_method = "A4B251DC9CDE5AB9FDD850B4272B4AC0")
    public ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo) {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_667666737 = null; 
        WNafPreCompInfo wnafPreCompInfo;
        {
            wnafPreCompInfo = (WNafPreCompInfo)preCompInfo;
        } 
        {
            wnafPreCompInfo = new WNafPreCompInfo();
        } 
        int m = k.bitLength();
        byte width;
        int reqPreCompLen;
        {
            width = 2;
            reqPreCompLen = 1;
        } 
        {
            {
                width = 3;
                reqPreCompLen = 2;
            } 
            {
                {
                    width = 4;
                    reqPreCompLen = 4;
                } 
                {
                    {
                        width = 5;
                        reqPreCompLen = 8;
                    } 
                    {
                        {
                            width = 6;
                            reqPreCompLen = 16;
                        } 
                        {
                            {
                                width = 7;
                                reqPreCompLen = 32;
                            } 
                            {
                                width = 8;
                                reqPreCompLen = 127;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        int preCompLen = 1;
        ECPoint[] preComp = wnafPreCompInfo.getPreComp();
        ECPoint twiceP = wnafPreCompInfo.getTwiceP();
        {
            preComp = new ECPoint[]{ p };
        } 
        {
            preCompLen = preComp.length;
        } 
        {
            twiceP = p.twice();
        } 
        {
            ECPoint[] oldPreComp = preComp;
            preComp = new ECPoint[reqPreCompLen];
            System.arraycopy(oldPreComp, 0, preComp, 0, preCompLen);
            {
                int i = preCompLen;
                {
                    preComp[i] = twiceP.add(preComp[i - 1]);
                } 
            } 
        } 
        byte[] wnaf = windowNaf(width, k);
        int l = wnaf.length;
        ECPoint q = p.getCurve().getInfinity();
        {
            int i = l - 1;
            {
                q = q.twice();
                {
                    {
                        q = q.add(preComp[(wnaf[i] - 1)/2]);
                    } 
                    {
                        q = q.subtract(preComp[(-wnaf[i] - 1)/2]);
                    } 
                } 
            } 
        } 
        wnafPreCompInfo.setPreComp(preComp);
        wnafPreCompInfo.setTwiceP(twiceP);
        p.setPreCompInfo(wnafPreCompInfo);
        varB4EAC82CA7396A68D541C85D26508E83_667666737 = q;
        addTaint(p.getTaint());
        addTaint(k.getTaint());
        addTaint(preCompInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_667666737.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_667666737;
        
        
    }

    
}

