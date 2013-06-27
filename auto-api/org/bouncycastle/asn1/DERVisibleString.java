package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.402 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.416 -0400", hash_original_method = "9E5952D16AC98B93920C8F7137608462", hash_generated_method = "8E2F094D974B8E0FCE260A6D2E3E2061")
    public  DERVisibleString(
        byte[]   string) {
        char[] cs;
        cs = new char[string.length];
        {
            int i;
            i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } //End block
        } //End collapsed parenthetic
        this.string = new String(cs);
        // ---------- Original Method ----------
        //char[]  cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.416 -0400", hash_original_method = "C35105E6557DD0D425C7A0BF0E564EC8", hash_generated_method = "98383A6DB956062CDFE27D3D6F7188CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.417 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "6EB3B821E286DEBD6CA946B1E294B912")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_192109863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_192109863 = string;
        varB4EAC82CA7396A68D541C85D26508E83_192109863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_192109863;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.417 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "976577F5468FBE051D375786EF77DBF1")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_70530670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_70530670 = string;
        varB4EAC82CA7396A68D541C85D26508E83_70530670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_70530670;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.418 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "31577CE54A6AD639F96C0D4BF3CABEED")
    public byte[] getOctets() {
        char[] cs;
        cs = string.toCharArray();
        byte[] bs;
        bs = new byte[cs.length];
        {
            int i;
            i = 0;
            {
                bs[i] = (byte)cs[i];
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1210600929 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1210600929;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.418 -0400", hash_original_method = "EDEDEE2045D008C87CEA62CE5CC5E8C6", hash_generated_method = "5B6DA5132EE74EDB2EE9F8776183609D")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(VISIBLE_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(VISIBLE_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.419 -0400", hash_original_method = "D3E4E4BB0C90F60625E75FAD6BCA1138", hash_generated_method = "1EABFDA53924CF19CA6BDABB156DECFE")
     boolean asn1Equals(
        DERObject  o) {
        boolean var61367506D5D445678970BDDC79C23C61_883812682 = (this.getString().equals(((DERVisibleString)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65159870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65159870;
        // ---------- Original Method ----------
        //if (!(o instanceof DERVisibleString))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERVisibleString)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.419 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "C0A1619907EF81DAA38C0C2DC7E830D9")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1891870194 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706688597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706688597;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
}

