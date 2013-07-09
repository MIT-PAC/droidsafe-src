package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.bouncycastle.util.Strings;

public class DERUTF8String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.784 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.785 -0400", hash_original_method = "B56B53BD15659EE05E587584D616ACE1", hash_generated_method = "6038452F3CCD059F42051AF2029AA2EC")
    public  DERUTF8String(byte[] string) {
        try 
        {
            this.string = Strings.fromUTF8ByteArray(string);
        } 
        catch (ArrayIndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("UTF8 encoding invalid");
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.785 -0400", hash_original_method = "87C8A077EBDA5677CBB631FE5690C6A7", hash_generated_method = "D2E018E2E7CAA8F0E1405358E3911B97")
    public  DERUTF8String(String string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERUTF8String getInstance(Object obj) {
        if (obj == null || obj instanceof DERUTF8String)
        {
            return (DERUTF8String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERUTF8String getInstance(
        ASN1TaggedObject obj,
        boolean explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERUTF8String)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUTF8String(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.786 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "9F4D6B87499ECBF0BF3487AC3DFE3BF1")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_575560562 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_575560562 = string;
        varB4EAC82CA7396A68D541C85D26508E83_575560562.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_575560562;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.786 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "9EB227F23A065B04A5AD379ED1F7EDB0")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_761925673 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_761925673 = string;
        varB4EAC82CA7396A68D541C85D26508E83_761925673.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_761925673;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.786 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "7D462BD042F1CB2AD94BCADF2D5AA024")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_731424654 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121717425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121717425;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.787 -0400", hash_original_method = "DF88B5FE85EAF9BB2061A4AEA787A839", hash_generated_method = "3CF77D48A605DE675E6E4429BFF19B4E")
     boolean asn1Equals(DERObject o) {
        DERUTF8String s = (DERUTF8String)o;
        boolean varEE57EA262042757EB3692934946962F3_1687060552 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609102976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609102976;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.787 -0400", hash_original_method = "6841F545C98612C1AFE91CE39DFBA4FF", hash_generated_method = "13F2885577826CA2166D12C83C07F916")
     void encode(DEROutputStream out) throws IOException {
        out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
        addTaint(out.getTaint());
        
        
    }

    
}

