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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.013 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.014 -0400", hash_original_method = "5201B112432D21625783310AA9CEC395", hash_generated_method = "42720B8B1671B205A71B78FEF08907A6")
    public  DERInteger(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        // ---------- Original Method ----------
        //bytes = BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.014 -0400", hash_original_method = "52A85FB71F259AF94A4C569903FA35A3", hash_generated_method = "E20D10919EB5723E10B3A8A6847E53D2")
    public  DERInteger(
        BigInteger   value) {
        bytes = value.toByteArray();
        // ---------- Original Method ----------
        //bytes = value.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.014 -0400", hash_original_method = "742445D1CBEB8EC33F0452B05DE17699", hash_generated_method = "3B54D0B289C9422429FE1852B21923A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.022 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "ADDEB4BA4A5F84124B57F9A8E4AA4B84")
    public BigInteger getValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_644415379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_644415379 = new BigInteger(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_644415379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644415379;
        // ---------- Original Method ----------
        //return new BigInteger(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.022 -0400", hash_original_method = "71BDB36FFF593CAF4C9E79EFECF43EBD", hash_generated_method = "14FC1FB5FC0D89EB38D5E344A2D42F31")
    public BigInteger getPositiveValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_255586584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_255586584 = new BigInteger(1, bytes);
        varB4EAC82CA7396A68D541C85D26508E83_255586584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255586584;
        // ---------- Original Method ----------
        //return new BigInteger(1, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.028 -0400", hash_original_method = "01662A631E5ACE6C7726FCC0828E9E63", hash_generated_method = "487316090F805F90D278B906C5C496AA")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(INTEGER, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(INTEGER, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.029 -0400", hash_original_method = "473F358B008FFCD851D487BD1750243E", hash_generated_method = "F845580EF1F64AE327286ED70E1E6014")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336473343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336473343;
        // ---------- Original Method ----------
        //int     value = 0;
        //for (int i = 0; i != bytes.length; i++)
         //{
             //value ^= (bytes[i] & 0xff) << (i % 4);
         //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.030 -0400", hash_original_method = "A031FF36E08BD1C92CE6416060813BEC", hash_generated_method = "A7ADFFF1A02587C1375FEEE233E823EB")
     boolean asn1Equals(
        DERObject  o) {
        DERInteger other;
        other = (DERInteger)o;
        boolean varEED3A374262CB159629A62F0DFEB9CCB_2132656192 = (Arrays.areEqual(bytes, other.bytes));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351674073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351674073;
        // ---------- Original Method ----------
        //if (!(o instanceof DERInteger))
        //{
            //return false;
        //}
        //DERInteger other = (DERInteger)o;
        //return Arrays.areEqual(bytes, other.bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.031 -0400", hash_original_method = "EFB82D2D11830675F5DB319D1D1561C4", hash_generated_method = "121BBAD21BC20F536675E5E8D2008556")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1173148655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1173148655 = getValue().toString();
        varB4EAC82CA7396A68D541C85D26508E83_1173148655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173148655;
        // ---------- Original Method ----------
        //return getValue().toString();
    }

    
}

