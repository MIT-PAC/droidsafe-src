package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERBoolean extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.341 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private byte value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.341 -0400", hash_original_method = "DE46F6E30E17087250BC7B7B32B3A323", hash_generated_method = "32679D1A7F651A39D96A5F1BE8D9BE83")
    protected  DERBoolean(
        boolean     value) {
        this.value = (value) ? (byte)0xff : (byte)0;
        // ---------- Original Method ----------
        //this.value = (value) ? (byte)0xff : (byte)0;
    }

    
    public static DERBoolean getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERBoolean)
        {
            return (DERBoolean)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static DERBoolean getInstance(
        boolean  value) {
        return (value ? TRUE : FALSE);
    }

    
    public static DERBoolean getInstance(
        byte[] octets) {
        return (octets[0] != 0) ? TRUE : FALSE;
    }

    
    public static DERBoolean getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERBoolean)
        {
            return getInstance(o);
        }
        else
        {
            return getInstance(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.342 -0400", hash_original_method = "CAF36277BE2299D4A97B34E514847231", hash_generated_method = "5D4DA2F1AE5AD0D5B4876BA6B367C3E4")
    public boolean isTrue() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963294323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963294323;
        // ---------- Original Method ----------
        //return (value != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.342 -0400", hash_original_method = "17536CB7674727E81A6C11BC3F7B5C5B", hash_generated_method = "4B95FC14B1CAC95749DEF0A7357C5C36")
     void encode(
        DEROutputStream out) throws IOException {
        byte[] bytes = new byte[1];
        bytes[0] = value;
        out.writeEncoded(BOOLEAN, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //byte[]  bytes = new byte[1];
        //bytes[0] = value;
        //out.writeEncoded(BOOLEAN, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.342 -0400", hash_original_method = "7025372BC5443A52FED5B1B11C72A34D", hash_generated_method = "95EB0FFFA3237C82DEAFB90E85EC5038")
    protected boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848513084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848513084;
        // ---------- Original Method ----------
        //if ((o == null) || !(o instanceof DERBoolean))
        //{
            //return false;
        //}
        //return (value == ((DERBoolean)o).value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.343 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "9E3A2B52BDADE6B76A0B436FA18169E7")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047967709 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047967709;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.343 -0400", hash_original_method = "9F6A9420185E5E125B8A61B3882EDFBB", hash_generated_method = "81E91818732602637DF6953B8B7747FB")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_425272704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_425272704 = (value != 0) ? "TRUE" : "FALSE";
        varB4EAC82CA7396A68D541C85D26508E83_425272704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_425272704;
        // ---------- Original Method ----------
        //return (value != 0) ? "TRUE" : "FALSE";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.343 -0400", hash_original_field = "954CDE13DC4345C4B66DC594DD7EB8A1", hash_generated_field = "AD41B06028B6D238FF4AF850CAEFE733")

    public static final DERBoolean FALSE = new DERBoolean(false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.343 -0400", hash_original_field = "75C038426B85F270822D4441A8A13DF1", hash_generated_field = "74021F0F40550CDAE080A69CBD04BF42")

    public static final DERBoolean TRUE  = new DERBoolean(true);
}

