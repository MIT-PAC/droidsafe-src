package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

import org.bouncycastle.util.Strings;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DERUTF8String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.642 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.643 -0400", hash_original_method = "B56B53BD15659EE05E587584D616ACE1", hash_generated_method = "F8D1F50D5A9EA50B8A3086D75A7A3AED")
    public  DERUTF8String(byte[] string) {
        try 
        {
            this.string = Strings.fromUTF8ByteArray(string);
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            IllegalArgumentException varE9F507CA8722061EF8795BD129AA72D9_1007342332 = new IllegalArgumentException("UTF8 encoding invalid");
            varE9F507CA8722061EF8795BD129AA72D9_1007342332.addTaint(taint);
            throw varE9F507CA8722061EF8795BD129AA72D9_1007342332;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.643 -0400", hash_original_method = "87C8A077EBDA5677CBB631FE5690C6A7", hash_generated_method = "D2E018E2E7CAA8F0E1405358E3911B97")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.644 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "F0997E2828AE69288BE150980B2F10D7")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1898936898 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1898936898.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1898936898;
        // ---------- Original Method ----------
        //return string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.645 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "4F855C7541457B2DBBDB962C9AD4B8F5")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1407444895 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_1407444895.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1407444895;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.645 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "BA19A7383D44F63F2D0DA75D2205EC0A")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_1760998750 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790481976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790481976;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.645 -0400", hash_original_method = "DF88B5FE85EAF9BB2061A4AEA787A839", hash_generated_method = "D97F15ABCA823A61A9FE640A2A294049")
     boolean asn1Equals(DERObject o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERUTF8String))        
        {
            boolean var68934A3E9455FA72420237EB05902327_257244370 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984266458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984266458;
        } //End block
        DERUTF8String s = (DERUTF8String)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_865428031 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960900647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960900647;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUTF8String))
        //{
            //return false;
        //}
        //DERUTF8String s = (DERUTF8String)o;
        //return this.getString().equals(s.getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.646 -0400", hash_original_method = "6841F545C98612C1AFE91CE39DFBA4FF", hash_generated_method = "F14E0DDADF5A90EB46C4C48F5B6DE00D")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
        // ---------- Original Method ----------
        //out.writeEncoded(UTF8_STRING, Strings.toUTF8ByteArray(string));
    }

    
}

