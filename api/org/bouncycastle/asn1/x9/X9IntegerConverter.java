package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

public class X9IntegerConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.536 -0400", hash_original_method = "3E06FD5486BA6E5207C62F9D16D09EAF", hash_generated_method = "3E06FD5486BA6E5207C62F9D16D09EAF")
    public X9IntegerConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.536 -0400", hash_original_method = "4EEA327D2CC1CF90BCBE86A301A2F541", hash_generated_method = "6CE5FF70C21B6103593BC1C9293E5BEE")
    public int getByteLength(
        ECCurve c) {
        addTaint(c.getTaint());
        int var0D89ABB1C42F93D2932E473B6520A4CF_2027310420 = ((c.getFieldSize() + 7) / 8);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314374088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314374088;
        // ---------- Original Method ----------
        //return (c.getFieldSize() + 7) / 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.537 -0400", hash_original_method = "906B1BA812A6A3F3853F695C4CB554DD", hash_generated_method = "41FA2CBA272653FA1AEB8D698C776409")
    public int getByteLength(
        ECFieldElement fe) {
        addTaint(fe.getTaint());
        int var663D7C1B201686694E09BA430720CD24_762458252 = ((fe.getFieldSize() + 7) / 8);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879202668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879202668;
        // ---------- Original Method ----------
        //return (fe.getFieldSize() + 7) / 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.537 -0400", hash_original_method = "DFBCE33E331D16CEE660F164961DBF46", hash_generated_method = "D49703476FF0E8C89093D2856B202A7E")
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
            byte[] varFA816EDB83E95BF0C8DA580BDFD491EF_1182886569 = (tmp);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1265212926 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1265212926;
        } //End block
        else
    if(qLength > bytes.length)        
        {
            byte[] tmp = new byte[qLength];
            System.arraycopy(bytes, 0, tmp, tmp.length - bytes.length, bytes.length);
            byte[] varFA816EDB83E95BF0C8DA580BDFD491EF_171191092 = (tmp);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1708376344 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1708376344;
        } //End block
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_756521608 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_973952402 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_973952402;
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

