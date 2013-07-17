package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERBMPString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.102 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.103 -0400", hash_original_method = "78F8AAB34A37706FEFE708907754C8E8", hash_generated_method = "2CEF79AB0E569859213614DB23F10A82")
    public  DERBMPString(
        byte[]   string) {
        char[] cs = new char[string.length / 2];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)((string[2 * i] << 8) | (string[2 * i + 1] & 0xff));
        } //End block
        this.string = new String(cs);
        // ---------- Original Method ----------
        //char[]  cs = new char[string.length / 2];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)((string[2 * i] << 8) | (string[2 * i + 1] & 0xff));
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.104 -0400", hash_original_method = "6B5E4F39ED8278020082E899D53170B5", hash_generated_method = "BA47B4DA0E258D9BDA4360123DE13384")
    public  DERBMPString(
        String   string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    public static DERBMPString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERBMPString)
        {
            return (DERBMPString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.105 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "2993959F2D3346B6569C92C4D3C7DCF2")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_223083313 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_223083313.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_223083313;
        // ---------- Original Method ----------
        //return string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.105 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "0E7EEFA56E5423F71F5A744E6CA4B202")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1199043327 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1199043327.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1199043327;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.105 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "268964B6CE22099830352692652745AC")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_467860620 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683935233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683935233;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.106 -0400", hash_original_method = "7D03FB23F5FAD453913811002EB3F146", hash_generated_method = "C5A47B8316F7EEFCECB072FE19F9FDB7")
    protected boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERBMPString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_61155296 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546282812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546282812;
        } //End block
        DERBMPString s = (DERBMPString)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_541165916 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748703296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748703296;
        // ---------- Original Method ----------
        //if (!(o instanceof DERBMPString))
        //{
            //return false;
        //}
        //DERBMPString  s = (DERBMPString)o;
        //return this.getString().equals(s.getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.107 -0400", hash_original_method = "FF137816E9C451A6CEB1C43EC2D7AD7D", hash_generated_method = "86BC185068295DF8220E50980B3D028E")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        char[] c = string.toCharArray();
        byte[] b = new byte[c.length * 2];
for(int i = 0;i != c.length;i++)
        {
            b[2 * i] = (byte)(c[i] >> 8);
            b[2 * i + 1] = (byte)c[i];
        } //End block
        out.writeEncoded(BMP_STRING, b);
        // ---------- Original Method ----------
        //char[]  c = string.toCharArray();
        //byte[]  b = new byte[c.length * 2];
        //for (int i = 0; i != c.length; i++)
        //{
            //b[2 * i] = (byte)(c[i] >> 8);
            //b[2 * i + 1] = (byte)c[i];
        //}
        //out.writeEncoded(BMP_STRING, b);
    }

    
}

