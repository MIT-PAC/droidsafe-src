package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERT61String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.713 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.714 -0400", hash_original_method = "729283B8151D354FE604ECA706D47EFD", hash_generated_method = "BF54A151BD8D9C1FA62372DA4DB99912")
    public  DERT61String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.715 -0400", hash_original_method = "0CF9010F1BDF3E8A972E72A6B339B40C", hash_generated_method = "628A9A81CB2AD8FF120F12611ACD495A")
    public  DERT61String(
        String   string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERT61String getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERT61String)
        {
            return (DERT61String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERT61String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit)
        {
            return getInstance(o);
        }
        else
        {
            return new DERT61String(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.717 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "EF4DC9D78631958C53939B489176D6E7")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_679745873 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_679745873 = string;
        varB4EAC82CA7396A68D541C85D26508E83_679745873.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_679745873;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.718 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "A84D9171730B611E63AD75DBF93984AE")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_361919076 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_361919076 = string;
        varB4EAC82CA7396A68D541C85D26508E83_361919076.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_361919076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.719 -0400", hash_original_method = "324AB1C41995E9982EA64A8881837CC9", hash_generated_method = "4591B112CF94AB0FDE009C1F1255D4C1")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(T61_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.720 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E07FBA249BE95A4CD5A0E9455EBBAEB5")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2074419830 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2074419830;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.720 -0400", hash_original_method = "E436607154A8EB2DA476BE28768351EE", hash_generated_method = "4B4072B396292155DF4FD8B38491F43D")
     boolean asn1Equals(
        DERObject  o) {
        boolean varDB4F8840254FB61DC7001DF48A6A6EA9_1289846070 = (this.getString().equals(((DERT61String)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327028723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327028723;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.721 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "70AC55071B66923EFC5D43FA6826200B")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_601410360 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629710232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629710232;
        
        
    }

    
}

