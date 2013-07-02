package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERGeneralString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.420 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.421 -0400", hash_original_method = "E16C9AF2574A91241A7B16E43930D742", hash_generated_method = "C7AC6141CA5E8B961E41297E595F52ED")
    public  DERGeneralString(byte[] string) {
        char[] cs = new char[string.length];
        {
            int i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } 
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.421 -0400", hash_original_method = "3F7BE61BE73D3159504C79D758BB363A", hash_generated_method = "F86DDB26CE3D7779080C2999FF08166A")
    public  DERGeneralString(String string) {
        this.string = string;
        
        
    }

    
    public static DERGeneralString getInstance(
        Object obj) {
        if (obj == null || obj instanceof DERGeneralString) 
        {
            return (DERGeneralString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    
    public static DERGeneralString getInstance(
        ASN1TaggedObject obj, 
        boolean explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERGeneralString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERGeneralString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.422 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "F0FE7BE8BD3A0FE38AB74087E00A6B2C")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1988421204 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1988421204 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1988421204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1988421204;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.422 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "D028C31C49A99CEA77DBF52683BE0442")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1989182209 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1989182209 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1989182209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1989182209;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.423 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "41FCB1C62367DFD3079E749C21AC36E5")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte) cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_122919672 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_122919672;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.423 -0400", hash_original_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E", hash_generated_method = "8ADC1B0855D0D1D9DE630F2973C793EA")
     void encode(DEROutputStream out) throws IOException {
        out.writeEncoded(GENERAL_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.423 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "E2EF1BA7903E2D4942A21AFCF1EC798B")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_590301094 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20722147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_20722147;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.424 -0400", hash_original_method = "790E2075BB1CC35320196C74CBC9C39A", hash_generated_method = "4932E5DFF0B63C289399734867F68EAB")
     boolean asn1Equals(DERObject o) {
        DERGeneralString s = (DERGeneralString) o;
        boolean varEE57EA262042757EB3692934946962F3_1787803577 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057402425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057402425;
        
        
        
            
        
        
        
    }

    
}

