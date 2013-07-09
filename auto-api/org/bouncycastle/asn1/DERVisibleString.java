package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.846 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.847 -0400", hash_original_method = "9E5952D16AC98B93920C8F7137608462", hash_generated_method = "D655E36D2A38D3553CAA2216CCE4FAD8")
    public  DERVisibleString(
        byte[]   string) {
        char[] cs = new char[string.length];
        {
            int i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } 
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.847 -0400", hash_original_method = "C35105E6557DD0D425C7A0BF0E564EC8", hash_generated_method = "98383A6DB956062CDFE27D3D6F7188CB")
    public  DERVisibleString(
        String   string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERVisibleString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERVisibleString)
        {
            return (DERVisibleString)obj;
        }
        if (obj instanceof ASN1OctetString)
        {
            return new DERVisibleString(((ASN1OctetString)obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERVisibleString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.848 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "2F8BDB71E48F8577EDCD2B79AE30155E")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_766117493 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_766117493 = string;
        varB4EAC82CA7396A68D541C85D26508E83_766117493.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_766117493;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.848 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "266F2006FAC376B56DB0431707AAA200")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1832833860 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1832833860 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1832833860.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1832833860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.849 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "1A8FD832C1B4984B301ABF1AF9CE9928")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1007515498 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1007515498;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.849 -0400", hash_original_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6", hash_generated_method = "5B6DA5132EE74EDB2EE9F8776183609D")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(VISIBLE_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.849 -0400", hash_original_method = "D3E4E4BB0C90F60625E75FAD6BCA1138", hash_generated_method = "F53794276DE1B8761DF8438A9ACFF3F9")
     boolean asn1Equals(
        DERObject  o) {
        boolean var61367506D5D445678970BDDC79C23C61_1664136914 = (this.getString().equals(((DERVisibleString)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563878601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563878601;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.849 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "8D1147FFFB44FB02F12D4905A844B170")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1761049080 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916758132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916758132;
        
        
    }

    
}

