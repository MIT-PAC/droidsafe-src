package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public class DERGeneralString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.260 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.261 -0400", hash_original_method = "E16C9AF2574A91241A7B16E43930D742", hash_generated_method = "ED1593852A56E1D165E86378729810B4")
    public  DERGeneralString(byte[] string) {
        char[] cs = new char[string.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        } //End block
        this.string = new String(cs);
        // ---------- Original Method ----------
        //char[] cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.262 -0400", hash_original_method = "3F7BE61BE73D3159504C79D758BB363A", hash_generated_method = "F86DDB26CE3D7779080C2999FF08166A")
    public  DERGeneralString(String string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    @DSModeled(DSC.SAFE)
    public static DERGeneralString getInstance(
        Object obj) {
        if (obj == null || obj instanceof DERGeneralString) 
        {
            return (DERGeneralString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.263 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "57F51C180533DBCD8A569885F3B63804")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1212120441 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1212120441.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1212120441;
        // ---------- Original Method ----------
        //return string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.263 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "77516DF52591429981ED8A90ED54DA01")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_504090750 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_504090750.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_504090750;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.264 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "BF9FB878D38B1935CBCDC18C1528E650")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte) cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1976167208 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1042539472 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1042539472;
        // ---------- Original Method ----------
        //char[] cs = string.toCharArray();
        //byte[] bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++) 
        //{
            //bs[i] = (byte) cs[i];
        //}
        //return bs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.264 -0400", hash_original_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E", hash_generated_method = "ECF02FD182BD0BEAB28F83CFB8A76630")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(GENERAL_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(GENERAL_STRING, this.getOctets());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.265 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "867235263F035D6F3AD463D6B3810F7D")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_399592127 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709705717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709705717;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.265 -0400", hash_original_method = "790E2075BB1CC35320196C74CBC9C39A", hash_generated_method = "4CD544FE791B499CBF32032E929F4105")
     boolean asn1Equals(DERObject o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERGeneralString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1837340206 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69957688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69957688;
        } //End block
        DERGeneralString s = (DERGeneralString) o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_1502525916 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1278595482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1278595482;
        // ---------- Original Method ----------
        //if (!(o instanceof DERGeneralString)) 
        //{
            //return false;
        //}
        //DERGeneralString s = (DERGeneralString) o;
        //return this.getString().equals(s.getString());
    }

    
}

