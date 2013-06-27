package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

public class X9IntegerConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.479 -0400", hash_original_method = "3E06FD5486BA6E5207C62F9D16D09EAF", hash_generated_method = "3E06FD5486BA6E5207C62F9D16D09EAF")
    public X9IntegerConverter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.480 -0400", hash_original_method = "4EEA327D2CC1CF90BCBE86A301A2F541", hash_generated_method = "969DD7AA9A5AE36463228EDE40A014BF")
    public int getByteLength(
        ECCurve c) {
        int var5636470C9F6E8A6C5B5880C5EEB5A3C8_1781238925 = ((c.getFieldSize() + 7) / 8);
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173977859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173977859;
        // ---------- Original Method ----------
        //return (c.getFieldSize() + 7) / 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.480 -0400", hash_original_method = "906B1BA812A6A3F3853F695C4CB554DD", hash_generated_method = "9816CAAA1A84C95F62BE4D5A91A497BD")
    public int getByteLength(
        ECFieldElement fe) {
        int var678ACA3929ABD2D9AD5AC4C70537353A_909440366 = ((fe.getFieldSize() + 7) / 8);
        addTaint(fe.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607612912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607612912;
        // ---------- Original Method ----------
        //return (fe.getFieldSize() + 7) / 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.483 -0400", hash_original_method = "DFBCE33E331D16CEE660F164961DBF46", hash_generated_method = "240D1D09057D2E92ABC6E834793F7085")
    public byte[] integerToBytes(
        BigInteger s,
        int        qLength) {
        byte[] bytes;
        bytes = s.toByteArray();
        {
            byte[] tmp;
            tmp = new byte[qLength];
            System.arraycopy(bytes, bytes.length - tmp.length, tmp, 0, tmp.length);
        } //End block
        {
            byte[] tmp;
            tmp = new byte[qLength];
            System.arraycopy(bytes, 0, tmp, tmp.length - bytes.length, bytes.length);
        } //End block
        addTaint(s.getTaint());
        addTaint(qLength);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1531463106 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1531463106;
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

