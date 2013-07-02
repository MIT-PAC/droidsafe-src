package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERUniversalString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.797 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "F26C5AE8BA7ACEC7B1EA4DA4444275F5")

    private byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.797 -0400", hash_original_method = "2B92FC0148DCC3B768EB41AB12E19E0C", hash_generated_method = "EB9C704CCBDB706AC49133E4C66FA4A0")
    public  DERUniversalString(
        byte[]   string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERUniversalString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERUniversalString)
        {
            return (DERUniversalString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERUniversalString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERUniversalString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUniversalString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.798 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "A106C3589831FC74CA01D4A8BAD5BBC6")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1600095733 = null; 
        StringBuffer buf = new StringBuffer("#");
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(this);
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("internal error encoding BitString");
        } 
        byte[] string = bOut.toByteArray();
        {
            int i = 0;
            {
                buf.append(table[(string[i] >>> 4) & 0xf]);
                buf.append(table[string[i] & 0xf]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1600095733 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1600095733.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1600095733;
        
        
        
        
        
        
            
        
        
        
           
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.798 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "89CCBBD04C8680A8F41F63131A77A49E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2122941583 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2122941583 = getString();
        varB4EAC82CA7396A68D541C85D26508E83_2122941583.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2122941583;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.799 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "5AA44B645FF0D575DC7780BBCD0466AD")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_416927746 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_416927746;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.799 -0400", hash_original_method = "7109223BA8B3755943761B0801F71200", hash_generated_method = "275C274B1C235B15774E86034D644668")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.799 -0400", hash_original_method = "2C48DF670B2A84721AF2DD998EBDD99A", hash_generated_method = "52D58C3EF1006AE6EE80DD51BBEA6AA2")
     boolean asn1Equals(
        DERObject  o) {
        boolean var00D546E80C3C9A43E63DED65DEC633EB_866613176 = (this.getString().equals(((DERUniversalString)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115852887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115852887;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.799 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "EC8E1E8C1F2D032520863B7A882F152F")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1718269334 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231749446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231749446;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.799 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}

