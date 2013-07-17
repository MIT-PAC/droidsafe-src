package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.703 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.704 -0400", hash_original_method = "9E5952D16AC98B93920C8F7137608462", hash_generated_method = "11378CEC4ADAA9B3E8D6933C03FDC29F")
    public  DERVisibleString(
        byte[]   string) {
        char[] cs = new char[string.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        } //End block
        this.string = new String(cs);
        // ---------- Original Method ----------
        //char[]  cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.705 -0400", hash_original_method = "C35105E6557DD0D425C7A0BF0E564EC8", hash_generated_method = "98383A6DB956062CDFE27D3D6F7188CB")
    public  DERVisibleString(
        String   string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.706 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "AD74FA4CF1DCAE5F3D25052188530284")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1706792231 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1706792231.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1706792231;
        // ---------- Original Method ----------
        //return string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.706 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "ED7C1BDF977391EF5313973DF2D75C09")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_870597996 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_870597996.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_870597996;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.707 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "813FD4BD48C135209A2224A37E79C52D")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1168007464 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1370851196 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1370851196;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.708 -0400", hash_original_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6", hash_generated_method = "236CE97B769DF654A6E5B006129F4EEA")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(VISIBLE_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(VISIBLE_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.708 -0400", hash_original_method = "D3E4E4BB0C90F60625E75FAD6BCA1138", hash_generated_method = "05B51FA95F9AB1EAE80FE2F0394C88A8")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERVisibleString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_495182214 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267802414 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267802414;
        } //End block
        boolean varF4A508056CD157C0803245687398C4CD_902174700 = (this.getString().equals(((DERVisibleString)o).getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524768238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_524768238;
        // ---------- Original Method ----------
        //if (!(o instanceof DERVisibleString))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERVisibleString)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.708 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "7F0B28D4525304C36AF7439BAFB10980")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_130894780 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487686650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487686650;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
}

