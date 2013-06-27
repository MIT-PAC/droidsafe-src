package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

class WNafMultiplier implements ECMultiplier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.554 -0400", hash_original_method = "C00227C22ED402D319A853243DDBC230", hash_generated_method = "C00227C22ED402D319A853243DDBC230")
    public WNafMultiplier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.557 -0400", hash_original_method = "1459872133D83D08012D8F1A13CEC4DA", hash_generated_method = "7A810B5BDD7DA79C5AEC536E150EA4F4")
    public byte[] windowNaf(byte width, BigInteger k) {
        byte[] wnaf;
        wnaf = new byte[k.bitLength() + 1];
        short pow2wB;
        pow2wB = (short)(1 << width);
        BigInteger pow2wBI;
        pow2wBI = BigInteger.valueOf(pow2wB);
        int i;
        i = 0;
        int length;
        length = 0;
        {
            boolean var90BEB270CA27021819A075365AD08434_728137491 = (k.signum() > 0);
            {
                {
                    boolean var383F976E410154A745E3FC06B83A2214_972138355 = (k.testBit(0));
                    {
                        BigInteger remainder;
                        remainder = k.mod(pow2wBI);
                        {
                            boolean var1DBB8A5A29EBE1DCC5BC003EFB8FD3E2_324237739 = (remainder.testBit(width - 1));
                            {
                                wnaf[i] = (byte)(remainder.intValue() - pow2wB);
                            } //End block
                            {
                                wnaf[i] = (byte)remainder.intValue();
                            } //End block
                        } //End collapsed parenthetic
                        k = k.subtract(BigInteger.valueOf(wnaf[i]));
                        length = i;
                    } //End block
                    {
                        wnaf[i] = 0;
                    } //End block
                } //End collapsed parenthetic
                k = k.shiftRight(1);
            } //End block
        } //End collapsed parenthetic
        byte[] wnafShort;
        wnafShort = new byte[length];
        System.arraycopy(wnaf, 0, wnafShort, 0, length);
        addTaint(width);
        addTaint(k.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_110334485 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_110334485;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.562 -0400", hash_original_method = "6B924519E3A0D968D1CF685546CDD2FF", hash_generated_method = "4F042847224625AEBB3082E66F959FD3")
    public ECPoint multiply(ECPoint p, BigInteger k, PreCompInfo preCompInfo) {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_326395741 = null; //Variable for return #1
        WNafPreCompInfo wnafPreCompInfo;
        {
            wnafPreCompInfo = (WNafPreCompInfo)preCompInfo;
        } //End block
        {
            wnafPreCompInfo = new WNafPreCompInfo();
        } //End block
        int m;
        m = k.bitLength();
        byte width;
        int reqPreCompLen;
        {
            width = 2;
            reqPreCompLen = 1;
        } //End block
        {
            {
                width = 3;
                reqPreCompLen = 2;
            } //End block
            {
                {
                    width = 4;
                    reqPreCompLen = 4;
                } //End block
                {
                    {
                        width = 5;
                        reqPreCompLen = 8;
                    } //End block
                    {
                        {
                            width = 6;
                            reqPreCompLen = 16;
                        } //End block
                        {
                            {
                                width = 7;
                                reqPreCompLen = 32;
                            } //End block
                            {
                                width = 8;
                                reqPreCompLen = 127;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        int preCompLen;
        preCompLen = 1;
        ECPoint[] preComp;
        preComp = wnafPreCompInfo.getPreComp();
        ECPoint twiceP;
        twiceP = wnafPreCompInfo.getTwiceP();
        {
            preComp = new ECPoint[]{ p };
        } //End block
        {
            preCompLen = preComp.length;
        } //End block
        {
            twiceP = p.twice();
        } //End block
        {
            ECPoint[] oldPreComp;
            oldPreComp = preComp;
            preComp = new ECPoint[reqPreCompLen];
            System.arraycopy(oldPreComp, 0, preComp, 0, preCompLen);
            {
                int i;
                i = preCompLen;
                {
                    preComp[i] = twiceP.add(preComp[i - 1]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        byte[] wnaf;
        wnaf = windowNaf(width, k);
        int l;
        l = wnaf.length;
        ECPoint q;
        q = p.getCurve().getInfinity();
        {
            int i;
            i = l - 1;
            {
                q = q.twice();
                {
                    {
                        q = q.add(preComp[(wnaf[i] - 1)/2]);
                    } //End block
                    {
                        q = q.subtract(preComp[(-wnaf[i] - 1)/2]);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        wnafPreCompInfo.setPreComp(preComp);
        wnafPreCompInfo.setTwiceP(twiceP);
        p.setPreCompInfo(wnafPreCompInfo);
        varB4EAC82CA7396A68D541C85D26508E83_326395741 = q;
        addTaint(p.getTaint());
        addTaint(k.getTaint());
        addTaint(preCompInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_326395741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326395741;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

