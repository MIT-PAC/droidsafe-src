package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;



public class X9IntegerConverter {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.406 -0400", hash_original_method = "3E06FD5486BA6E5207C62F9D16D09EAF", hash_generated_method = "3E06FD5486BA6E5207C62F9D16D09EAF")
    public X9IntegerConverter ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.407 -0400", hash_original_method = "4EEA327D2CC1CF90BCBE86A301A2F541", hash_generated_method = "EC73F7B49E9F2538CF53EE2A5F96CC66")
    public int getByteLength(
        ECCurve c) {
        addTaint(c.getTaint());
        int var0D89ABB1C42F93D2932E473B6520A4CF_537994731 = ((c.getFieldSize() + 7) / 8);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008394166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008394166;
        // ---------- Original Method ----------
        //return (c.getFieldSize() + 7) / 8;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.407 -0400", hash_original_method = "906B1BA812A6A3F3853F695C4CB554DD", hash_generated_method = "F8A06044E537A3B6FBF64A4D80C4D7B0")
    public int getByteLength(
        ECFieldElement fe) {
        addTaint(fe.getTaint());
        int var663D7C1B201686694E09BA430720CD24_2083364153 = ((fe.getFieldSize() + 7) / 8);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558904131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558904131;
        // ---------- Original Method ----------
        //return (fe.getFieldSize() + 7) / 8;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.408 -0400", hash_original_method = "DFBCE33E331D16CEE660F164961DBF46", hash_generated_method = "5945B35415F5308C1FE577B31C414B00")
    public byte[] integerToBytes(
        BigInteger s,
        int        qLength) {
        addTaint(qLength);
        addTaint(s.getTaint());
        byte[] bytes = s.toByteArray();
        if(qLength < bytes.length)        
        {
            byte[] tmp = new byte[qLength];
            System.arraycopy(bytes, bytes.length - tmp.length, tmp, 0, tmp.length);
            byte[] varFA816EDB83E95BF0C8DA580BDFD491EF_445918729 = (tmp);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_385425765 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_385425765;
        } //End block
        else
        if(qLength > bytes.length)        
        {
            byte[] tmp = new byte[qLength];
            System.arraycopy(bytes, 0, tmp, tmp.length - bytes.length, bytes.length);
            byte[] varFA816EDB83E95BF0C8DA580BDFD491EF_1209688129 = (tmp);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_882769081 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_882769081;
        } //End block
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1741863255 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1973553424 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1973553424;
        // ---------- Original Method ----------
        //byte[] bytes = s.toByteArray();
        //if (qLength < bytes.length)
        //{
            //byte[] tmp = new byte[qLength];
            //System.arraycopy(bytes, bytes.length - tmp.length, tmp, 0, tmp.length);
            //return tmp;
        //}
        //else if (qLength > bytes.length)
        //{
            //byte[] tmp = new byte[qLength];
            //System.arraycopy(bytes, 0, tmp, tmp.length - bytes.length, bytes.length);
            //return tmp; 
        //}
        //return bytes;
    }

    
}

