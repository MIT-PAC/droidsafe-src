package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERGeneralString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.001 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.002 -0400", hash_original_method = "E16C9AF2574A91241A7B16E43930D742", hash_generated_method = "ED1593852A56E1D165E86378729810B4")
    public  DERGeneralString(byte[] string) {
        char[] cs = new char[string.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.002 -0400", hash_original_method = "3F7BE61BE73D3159504C79D758BB363A", hash_generated_method = "F86DDB26CE3D7779080C2999FF08166A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.003 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "10FEA651623B9A80BFEE5F39A8563C51")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_196912068 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_196912068.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_196912068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.003 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "64CF1647452E27B5B062CEDEA5E0E3CC")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1782255316 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1782255316.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1782255316;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.004 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "429B9EAAF4898E9E604FAC417D2B8E21")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte) cs[i];
        } 
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1471200081 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_806829885 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_806829885;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.005 -0400", hash_original_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E", hash_generated_method = "ECF02FD182BD0BEAB28F83CFB8A76630")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(GENERAL_STRING, this.getOctets());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.005 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "54490068F39D2EB271EA53868AAF138A")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_534268543 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30212732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30212732;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.006 -0400", hash_original_method = "790E2075BB1CC35320196C74CBC9C39A", hash_generated_method = "4ECE92259FFDD0A21453258FD14A4C77")
     boolean asn1Equals(DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERGeneralString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_667706023 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846711133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846711133;
        } 
        DERGeneralString s = (DERGeneralString) o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_527641705 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663808031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663808031;
        
        
        
            
        
        
        
    }

    
}

