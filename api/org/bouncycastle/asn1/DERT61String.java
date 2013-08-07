package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public class DERT61String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.570 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.571 -0400", hash_original_method = "729283B8151D354FE604ECA706D47EFD", hash_generated_method = "A524D61739EF17EEF60714876AB0509E")
    public  DERT61String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.571 -0400", hash_original_method = "0CF9010F1BDF3E8A972E72A6B339B40C", hash_generated_method = "628A9A81CB2AD8FF120F12611ACD495A")
    public  DERT61String(
        String   string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    public static DERT61String getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERT61String)
        {
            return (DERT61String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.572 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "7DBCB8D27BDCFCC9FA4F153CEEAD3444")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_42843318 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_42843318.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_42843318;
        // ---------- Original Method ----------
        //return string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.573 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "81953C68066264C47D10A822A9D2B91F")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_712152843 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_712152843.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_712152843;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.573 -0400", hash_original_method = "324AB1C41995E9982EA64A8881837CC9", hash_generated_method = "C19A158E9BA0B1496F29C7FCA0297D4C")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(T61_STRING, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(T61_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.573 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "8D06A494DB7DCCB426162679BB9626CE")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1401553083 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2143738266 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2143738266;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.574 -0400", hash_original_method = "E436607154A8EB2DA476BE28768351EE", hash_generated_method = "7B9EA3D80F3A9FA2D911838392D7F8FB")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERT61String))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1904930794 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577763774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577763774;
        } //End block
        boolean varF41DB2B225EB98F19BC025680F6574E9_925156911 = (this.getString().equals(((DERT61String)o).getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1621706710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1621706710;
        // ---------- Original Method ----------
        //if (!(o instanceof DERT61String))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERT61String)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.574 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "3D3B0BED886BF0E8821DC6DB65F8902D")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_2011395528 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883732077 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883732077;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
}

