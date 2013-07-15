package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.bouncycastle.util.Strings;

public class DERUTF8String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.253 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.253 -0400", hash_original_method = "B56B53BD15659EE05E587584D616ACE1", hash_generated_method = "30057D2C8C26E1075A248246823DDBED")
    public  DERUTF8String(byte[] string) {
        try 
        {
            this.string = Strings.fromUTF8ByteArray(string);
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            IllegalArgumentException varE9F507CA8722061EF8795BD129AA72D9_120605379 = new IllegalArgumentException("UTF8 encoding invalid");
            varE9F507CA8722061EF8795BD129AA72D9_120605379.addTaint(taint);
            throw varE9F507CA8722061EF8795BD129AA72D9_120605379;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //this.string = Strings.fromUTF8ByteArray(string);
        //}
        //catch (ArrayIndexOutOfBoundsException e)
        //{
            //throw new IllegalArgumentException("UTF8 encoding invalid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.254 -0400", hash_original_method = "87C8A077EBDA5677CBB631FE5690C6A7", hash_generated_method = "D2E018E2E7CAA8F0E1405358E3911B97")
    public  DERUTF8String(String string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
        public static DERUTF8String getInstance(Object obj) {
        if (obj == null || obj instanceof DERUTF8String)
        {
            return (DERUTF8String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.254 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "4ADEFDD3892B3ED38DEBC8F847B600CF")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1430006916 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1430006916.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1430006916;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.255 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "49B59C9BB6A0A2E4FBDE6F265B81B1CF")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1126388354 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1126388354.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1126388354;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.255 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "AF54E930728E9116DB4E854F57F43169")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_1467689057 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299643813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299643813;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.255 -0400", hash_original_method = "DF88B5FE85EAF9BB2061A4AEA787A839", hash_generated_method = "92D561F7FE2E45BDEDAF37AC6564B056")
     boolean asn1Equals(DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERUTF8String))        
        {
            boolean var68934A3E9455FA72420237EB05902327_536101471 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813447999 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_813447999;
        } //End block
        DERUTF8String s = (DERUTF8String)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_389996422 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855670560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855670560;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUTF8String))
        //{
            //return false;
        //}
        //DERUTF8String s = (DERUTF8String)o;
        //return this.getString().equals(s.getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.256 -0400", hash_original_method = "6841F545C98612C1AFE91CE39DFBA4FF", hash_generated_method = "F14E0DDADF5A90EB46C4C48F5B6DE00D")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
        // ---------- Original Method ----------
        //out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
    }

    
}

