package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERIA5String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.072 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.073 -0400", hash_original_method = "6D45D0BD0357770FD3E912C483EA28A2", hash_generated_method = "9355E3DC845A6BC72B1A15A15EF98D6C")
    public  DERIA5String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.073 -0400", hash_original_method = "E43446DCFA1E12AD62CEF41AA43F405C", hash_generated_method = "1148FF261F792216188D48ADE936F9C9")
    public  DERIA5String(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.074 -0400", hash_original_method = "116E9F3E400BAA7DE0ED2CEAD98AD4A9", hash_generated_method = "5973D5D3DB4FA0F553E09BE1C1F1CB1D")
    public  DERIA5String(
        String   string,
        boolean  validate) {
        addTaint(validate);
    if(string == null)        
        {
            NullPointerException var583B156DFC6C0D3E5E7C194136874CD3_2064865810 = new NullPointerException("string cannot be null");
            var583B156DFC6C0D3E5E7C194136874CD3_2064865810.addTaint(taint);
            throw var583B156DFC6C0D3E5E7C194136874CD3_2064865810;
        } //End block
    if(validate && !isIA5String(string))        
        {
            IllegalArgumentException var004F07C3BE12B584F6B99C05A347E3ED_1903528895 = new IllegalArgumentException("string contains illegal characters");
            var004F07C3BE12B584F6B99C05A347E3ED_1903528895.addTaint(taint);
            throw var004F07C3BE12B584F6B99C05A347E3ED_1903528895;
        } //End block
        this.string = string;
        // ---------- Original Method ----------
        //if (string == null)
        //{
            //throw new NullPointerException("string cannot be null");
        //}
        //if (validate && !isIA5String(string))
        //{
            //throw new IllegalArgumentException("string contains illegal characters");
        //}
        //this.string = string;
    }

    
        public static DERIA5String getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERIA5String)
        {
            return (DERIA5String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERIA5String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERIA5String)
        {
            return getInstance(o);
        }
        else
        {
            return new DERIA5String(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.075 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "42FB37FD1EFA4B8520CE029E99B484D9")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_897201784 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_897201784.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_897201784;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.075 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "DC8D45D9BB00FB20E8D099A0136CC2E1")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1309653163 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1309653163.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1309653163;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.075 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "5D223E9E4236EE20D8E7D91D90CC38A6")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_265900849 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_425470241 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_425470241;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.076 -0400", hash_original_method = "81A044D942E61187B7BC9BD1DB599BBA", hash_generated_method = "8C44FA4DF8C43471B7888B43FBF9CF46")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(IA5_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(IA5_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.076 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "43F98F5D925DE7D3C7DF6B606484C252")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_424222641 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1980651551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1980651551;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.076 -0400", hash_original_method = "9B52498F79C21F529133E97FFA41DA30", hash_generated_method = "8F5C3D7F6EF577EE556C95AA3C044458")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERIA5String))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1930317668 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_893722272 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_893722272;
        } //End block
        DERIA5String s = (DERIA5String)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_489939820 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752627022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752627022;
        // ---------- Original Method ----------
        //if (!(o instanceof DERIA5String))
        //{
            //return false;
        //}
        //DERIA5String  s = (DERIA5String)o;
        //return this.getString().equals(s.getString());
    }

    
        public static boolean isIA5String(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
        }
        return true;
    }

    
}

