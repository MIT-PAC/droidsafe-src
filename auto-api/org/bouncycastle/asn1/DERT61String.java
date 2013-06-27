package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERT61String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.322 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.342 -0400", hash_original_method = "729283B8151D354FE604ECA706D47EFD", hash_generated_method = "080F072BC146B44646B8F14134176077")
    public  DERT61String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.343 -0400", hash_original_method = "0CF9010F1BDF3E8A972E72A6B339B40C", hash_generated_method = "628A9A81CB2AD8FF120F12611ACD495A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.344 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "1E0FC18E0FE98A7CEA55CF0428CFA4F1")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1502044848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1502044848 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1502044848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1502044848;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.345 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "3C17402A88050805A68B2CB59401B3CB")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_306465600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_306465600 = string;
        varB4EAC82CA7396A68D541C85D26508E83_306465600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306465600;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.345 -0400", hash_original_method = "324AB1C41995E9982EA64A8881837CC9", hash_generated_method = "4591B112CF94AB0FDE009C1F1255D4C1")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(T61_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(T61_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.360 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E00F7752AC4011165CE208923AC1B05B")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_846547474 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_846547474;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.367 -0400", hash_original_method = "E436607154A8EB2DA476BE28768351EE", hash_generated_method = "264BD28F15E2CD161E0AD8C5669E9A31")
     boolean asn1Equals(
        DERObject  o) {
        boolean varDB4F8840254FB61DC7001DF48A6A6EA9_344727768 = (this.getString().equals(((DERT61String)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648952533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648952533;
        // ---------- Original Method ----------
        //if (!(o instanceof DERT61String))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERT61String)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.368 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "7D19F080A91676B4FE79EA86F4E39BFB")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_164425304 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039328187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039328187;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
}

