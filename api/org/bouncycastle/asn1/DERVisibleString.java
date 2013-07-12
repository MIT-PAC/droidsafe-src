package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.284 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.285 -0400", hash_original_method = "9E5952D16AC98B93920C8F7137608462", hash_generated_method = "11378CEC4ADAA9B3E8D6933C03FDC29F")
    public  DERVisibleString(
        byte[]   string) {
        char[] cs = new char[string.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.285 -0400", hash_original_method = "C35105E6557DD0D425C7A0BF0E564EC8", hash_generated_method = "98383A6DB956062CDFE27D3D6F7188CB")
    public  DERVisibleString(
        String   string) {
        this.string = string;
        
        
    }

    
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

    
        public static DERVisibleString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.286 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "73AC54456597620C0A3CF821164A4334")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_567688589 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_567688589.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_567688589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.286 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "D19FB34C39102598B8AC713F123DF81E")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_535581017 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_535581017.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_535581017;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.287 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "5A990B759DFA7EDD1B73B63442E9415C")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } 
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1981580163 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_684273532 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_684273532;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.287 -0400", hash_original_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6", hash_generated_method = "236CE97B769DF654A6E5B006129F4EEA")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(VISIBLE_STRING, this.getOctets());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.287 -0400", hash_original_method = "D3E4E4BB0C90F60625E75FAD6BCA1138", hash_generated_method = "B52791BC7956AD6F2FEB0F3499E47498")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERVisibleString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1178881509 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117244977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117244977;
        } 
        boolean varF4A508056CD157C0803245687398C4CD_1234897735 = (this.getString().equals(((DERVisibleString)o).getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457587634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457587634;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.288 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "86499EED564E5440F043B7F50FB74987")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_566696942 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558321592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558321592;
        
        
    }

    
}

