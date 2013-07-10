package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

public class X9IntegerConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.479 -0400", hash_original_method = "3E06FD5486BA6E5207C62F9D16D09EAF", hash_generated_method = "3E06FD5486BA6E5207C62F9D16D09EAF")
    public X9IntegerConverter ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.479 -0400", hash_original_method = "4EEA327D2CC1CF90BCBE86A301A2F541", hash_generated_method = "CCAB097260FE313A744BC7113FE63CF8")
    public int getByteLength(
        ECCurve c) {
        int var5636470C9F6E8A6C5B5880C5EEB5A3C8_1834655460 = ((c.getFieldSize() + 7) / 8);
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313799923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313799923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.479 -0400", hash_original_method = "906B1BA812A6A3F3853F695C4CB554DD", hash_generated_method = "885E117BB4353FF424BA32A22397F812")
    public int getByteLength(
        ECFieldElement fe) {
        int var678ACA3929ABD2D9AD5AC4C70537353A_1823262979 = ((fe.getFieldSize() + 7) / 8);
        addTaint(fe.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192374023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192374023;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.480 -0400", hash_original_method = "DFBCE33E331D16CEE660F164961DBF46", hash_generated_method = "3A2B92D35357EB4CE62E0A836F162125")
    public byte[] integerToBytes(
        BigInteger s,
        int        qLength) {
        byte[] bytes = s.toByteArray();
        {
            byte[] tmp = new byte[qLength];
            System.arraycopy(bytes, bytes.length - tmp.length, tmp, 0, tmp.length);
        } 
        {
            byte[] tmp = new byte[qLength];
            System.arraycopy(bytes, 0, tmp, tmp.length - bytes.length, bytes.length);
        } 
        addTaint(s.getTaint());
        addTaint(qLength);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1464931232 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1464931232;
        
        
        
        
            
            
            
        
        
        
            
            
            
        
        
    }

    
}

