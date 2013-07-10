package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERBMPString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.264 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.264 -0400", hash_original_method = "78F8AAB34A37706FEFE708907754C8E8", hash_generated_method = "35DE8928CFFE9ED8DAF6CC3DAF638872")
    public  DERBMPString(
        byte[]   string) {
        char[] cs = new char[string.length / 2];
        {
            int i = 0;
            {
                cs[i] = (char)((string[2 * i] << 8) | (string[2 * i + 1] & 0xff));
            } 
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.265 -0400", hash_original_method = "6B5E4F39ED8278020082E899D53170B5", hash_generated_method = "BA47B4DA0E258D9BDA4360123DE13384")
    public  DERBMPString(
        String   string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERBMPString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERBMPString)
        {
            return (DERBMPString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERBMPString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERBMPString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERBMPString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.266 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "C6EF03ECCD38A0004D00370754358FC0")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_566341592 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_566341592 = string;
        varB4EAC82CA7396A68D541C85D26508E83_566341592.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_566341592;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.266 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "E9F92D67CC98B5295EABC559E41021AA")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_92677208 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_92677208 = string;
        varB4EAC82CA7396A68D541C85D26508E83_92677208.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_92677208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.266 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "C4B2F3774765462FCEABBC4624A7487C")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1807855245 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351639714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351639714;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.267 -0400", hash_original_method = "7D03FB23F5FAD453913811002EB3F146", hash_generated_method = "0DBBB37F6414B41D82040F4EE86CCC8A")
    protected boolean asn1Equals(
        DERObject  o) {
        DERBMPString s = (DERBMPString)o;
        boolean varEE57EA262042757EB3692934946962F3_505722821 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412544215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412544215;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.267 -0400", hash_original_method = "FF137816E9C451A6CEB1C43EC2D7AD7D", hash_generated_method = "BDF7B6DD953F89BE7E5FD23CEC860645")
     void encode(
        DEROutputStream  out) throws IOException {
        char[] c = string.toCharArray();
        byte[] b = new byte[c.length * 2];
        {
            int i = 0;
            {
                b[2 * i] = (byte)(c[i] >> 8);
                b[2 * i + 1] = (byte)c[i];
            } 
        } 
        out.writeEncoded(BMP_STRING, b);
        addTaint(out.getTaint());
        
        
        
        
        
            
            
        
        
    }

    
}

