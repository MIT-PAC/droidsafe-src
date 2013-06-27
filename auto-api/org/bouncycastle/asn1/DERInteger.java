package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class DERInteger extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.156 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.156 -0400", hash_original_method = "5201B112432D21625783310AA9CEC395", hash_generated_method = "42720B8B1671B205A71B78FEF08907A6")
    public  DERInteger(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        // ---------- Original Method ----------
        //bytes = BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.167 -0400", hash_original_method = "52A85FB71F259AF94A4C569903FA35A3", hash_generated_method = "E20D10919EB5723E10B3A8A6847E53D2")
    public  DERInteger(
        BigInteger   value) {
        bytes = value.toByteArray();
        // ---------- Original Method ----------
        //bytes = value.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.168 -0400", hash_original_method = "742445D1CBEB8EC33F0452B05DE17699", hash_generated_method = "3B54D0B289C9422429FE1852B21923A5")
    public  DERInteger(
        byte[]   bytes) {
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
        public static DERInteger getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERInteger)
        {
            return (DERInteger)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERInteger getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERInteger)
        {
            return getInstance(o);
        }
        else
        {
            return new ASN1Integer(ASN1OctetString.getInstance(obj.getObject()).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.168 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "C3E265AB4F2BA56DCF1664D763C45D94")
    public BigInteger getValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1159570469 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1159570469 = new BigInteger(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1159570469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1159570469;
        // ---------- Original Method ----------
        //return new BigInteger(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.177 -0400", hash_original_method = "71BDB36FFF593CAF4C9E79EFECF43EBD", hash_generated_method = "06E97B6B4F8FC36C769D36D15D4D490C")
    public BigInteger getPositiveValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_776849761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_776849761 = new BigInteger(1, bytes);
        varB4EAC82CA7396A68D541C85D26508E83_776849761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_776849761;
        // ---------- Original Method ----------
        //return new BigInteger(1, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.177 -0400", hash_original_method = "01662A631E5ACE6C7726FCC0828E9E63", hash_generated_method = "487316090F805F90D278B906C5C496AA")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(INTEGER, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(INTEGER, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.178 -0400", hash_original_method = "473F358B008FFCD851D487BD1750243E", hash_generated_method = "F318785C6C1FD1A0D436194B8AC69DB6")
    public int hashCode() {
        int value;
        value = 0;
        {
            int i;
            i = 0;
            {
                value ^= (bytes[i] & 0xff) << (i % 4);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665578695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665578695;
        // ---------- Original Method ----------
        //int     value = 0;
        //for (int i = 0; i != bytes.length; i++)
         //{
             //value ^= (bytes[i] & 0xff) << (i % 4);
         //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.178 -0400", hash_original_method = "A031FF36E08BD1C92CE6416060813BEC", hash_generated_method = "1D44E33012D51109D9D06D850E3FFB46")
     boolean asn1Equals(
        DERObject  o) {
        DERInteger other;
        other = (DERInteger)o;
        boolean varEED3A374262CB159629A62F0DFEB9CCB_1177913628 = (Arrays.areEqual(bytes, other.bytes));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89269669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89269669;
        // ---------- Original Method ----------
        //if (!(o instanceof DERInteger))
        //{
            //return false;
        //}
        //DERInteger other = (DERInteger)o;
        //return Arrays.areEqual(bytes, other.bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.191 -0400", hash_original_method = "EFB82D2D11830675F5DB319D1D1561C4", hash_generated_method = "703A12D46F0F8ABBF82F621738A29926")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1328570040 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1328570040 = getValue().toString();
        varB4EAC82CA7396A68D541C85D26508E83_1328570040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328570040;
        // ---------- Original Method ----------
        //return getValue().toString();
    }

    
}

