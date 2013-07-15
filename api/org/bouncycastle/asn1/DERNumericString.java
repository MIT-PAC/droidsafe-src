package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERNumericString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.101 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.101 -0400", hash_original_method = "68F5D78267A661375BFA3ED79E149992", hash_generated_method = "9B887FA3143697834C11702A7625F1AB")
    public  DERNumericString(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.102 -0400", hash_original_method = "4A4CC31A466FEB81F134844B7BA257FB", hash_generated_method = "F68CB3283C8D4442C3B0A799F975D5BD")
    public  DERNumericString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.102 -0400", hash_original_method = "E352C3D2266CB71465C2437206485D10", hash_generated_method = "10A8E8D7B1721F43AE8EB90533EB6F44")
    public  DERNumericString(
        String   string,
        boolean  validate) {
        addTaint(validate);
    if(validate && !isNumericString(string))        
        {
            IllegalArgumentException var004F07C3BE12B584F6B99C05A347E3ED_27315036 = new IllegalArgumentException("string contains illegal characters");
            var004F07C3BE12B584F6B99C05A347E3ED_27315036.addTaint(taint);
            throw var004F07C3BE12B584F6B99C05A347E3ED_27315036;
        } //End block
        this.string = string;
        // ---------- Original Method ----------
        //if (validate && !isNumericString(string))
        //{
            //throw new IllegalArgumentException("string contains illegal characters");
        //}
        //this.string = string;
    }

    
        public static DERNumericString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERNumericString)
        {
            return (DERNumericString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERNumericString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERNumericString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERNumericString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.103 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "4A016C27E69932EF044161E05FFB14CA")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_838483051 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_838483051.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_838483051;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.103 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "467B7F8397DF0C9B1A9FF3E30D71B2B7")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1436506563 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1436506563.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1436506563;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.104 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "6363B4C9762865C7FF63D0F45D6BF080")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_2019334081 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1851247202 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1851247202;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.104 -0400", hash_original_method = "9CAFE2F99C4AA1A810005CA2021DBA5F", hash_generated_method = "13227F84E3B3A01A86E62EE784B936D7")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(NUMERIC_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(NUMERIC_STRING, this.getOctets());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.104 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "2C092CC7F70EB712CAFE5A345B42B602")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_1077864307 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933910428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933910428;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.105 -0400", hash_original_method = "8BA017E030540263DAC8EBF952EA3B45", hash_generated_method = "CB4E482AADAA1B5AE14E88AD5A890553")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERNumericString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_155726379 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559587719 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559587719;
        } //End block
        DERNumericString s = (DERNumericString)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_1676795833 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703480606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703480606;
        // ---------- Original Method ----------
        //if (!(o instanceof DERNumericString))
        //{
            //return false;
        //}
        //DERNumericString  s = (DERNumericString)o;
        //return this.getString().equals(s.getString());
    }

    
        public static boolean isNumericString(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }
            return false;
        }
        return true;
    }

    
}

